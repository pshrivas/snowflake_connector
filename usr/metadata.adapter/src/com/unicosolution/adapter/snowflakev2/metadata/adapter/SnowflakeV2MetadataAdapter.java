package com.unicosolution.adapter.snowflakev2.metadata.adapter;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

import com.informatica.sdk.adapter.metadata.common.CDetailImportOpts;
import com.informatica.sdk.adapter.metadata.common.Option;
import com.informatica.sdk.adapter.metadata.common.Status;
import com.informatica.sdk.adapter.metadata.common.StatusEnum;
import com.informatica.sdk.adapter.metadata.patternblocks.catalog.semantic.iface.Catalog;
import com.informatica.sdk.adapter.metadata.patternblocks.constraint.semantic.iface.PrimaryKey;
import com.informatica.sdk.adapter.metadata.patternblocks.constraint.semantic.iface.UniqueKey;
import com.informatica.sdk.adapter.metadata.patternblocks.container.semantic.iface.Package;
import com.informatica.sdk.adapter.metadata.patternblocks.field.semantic.iface.Field;
import com.informatica.sdk.adapter.metadata.patternblocks.flatrecord.semantic.iface.FlatRecord;
import com.informatica.sdk.adapter.metadata.patternblocks.index.semantic.iface.Index;
import com.informatica.sdk.adapter.metadata.patternblocks.index.semantic.iface.IndexField;
import com.informatica.sdk.adapter.metadata.patternblocks.recordrelationship.semantic.iface.RecordRelationship;
import com.informatica.sdk.adapter.metadata.patternblocks.semantic.iface.Factory;
import com.informatica.sdk.adapter.metadata.patternblocks.shared.semantic.iface.ImportableObject;
import com.informatica.sdk.adapter.metadata.patternblocks.shared.semantic.iface.RecordTypeEnum;
import com.informatica.sdk.adapter.metadata.provider.AbstractMetadataAdapter;
import com.informatica.sdk.adapter.metadata.provider.Connection;
import com.informatica.sdk.adapter.metadata.writeback.MetadataWriteOptions;
import com.informatica.sdk.adapter.metadata.writeback.MetadataWriteSession;
import com.informatica.sdk.exceptions.ExceptionManager;
import com.unicosolution.adapter.snowflakev2.table.metadata.semantic.iface.SEMTableFieldExtensions;
import com.unicosolution.adapter.snowflakev2.table.metadata.semantic.iface.SEMTableRecordExtensions;

@SuppressWarnings("unused")
public class SnowflakeV2MetadataAdapter extends AbstractMetadataAdapter {
	private final static Logger LOGGER = Logger.getLogger(SnowflakeV2MetadataAdapter.class.getName());

	private Package tabSchema = null;
	private Factory sdkFactory = null;

	/**
	 * Gets the adapter metadata connection instance.
	 * 
	 * @param options
	 *            The various Options of the metadata connection instance. Ex:
	 *            NMO-type
	 * @param connAttrs
	 *            The connection attributes of the adapter.
	 * @return INFASDKConnection object that is the adapter specific connection
	 *         instance.
	 */
	@Override
	public Connection getMetadataConnection(List<Option> options, Map<String, Object> connAttrs) {
		if (LOGGER.isLoggable(Level.FINER)) {
			Map<String, Object> tmpConnAttrs = new HashMap<>(connAttrs);
			if (tmpConnAttrs.containsKey("password")) {
				tmpConnAttrs.remove("password");
			}
			LOGGER.finer(String.format("Options: %s, ConnAttrs: %s", options, tmpConnAttrs));
		}
		return new SnowflakeV2Connection();
	}

	/**
	 * Used to filter Records during metadata import. Implement the filtering
	 * logic to push the filter request to source. Not Used.
	 */
	private Boolean isRespectFilter(String objectName, String nameFilter) {
		LOGGER.finer(String.format("%s, %s", objectName, nameFilter));
		if (null == nameFilter)
			return true;
		return objectName.matches(nameFilter);
	}

	/**
	 * Caters to the user requests pertaining to the native metadata catalog.
	 * This may be performed in a single bulk catalog retrieval call or by a
	 * series of separate incremental requests. The adapter is expected to fetch
	 * the objects such as catalogs, hierarchy, packages, or records using
	 * Options parameter. During incremental processing, the first call will be
	 * expected to set the root objects on the SDKCatalog object and the
	 * subsequent calls should add child metadata objects to the retrieved
	 * object specified by the START_AT SDKOption.
	 * 
	 * @param options
	 *            List of option values that includes a START_AT option. The
	 *            START_AT option references a previously retrieved object from
	 *            which to start or resume metadata import. The START_AT option
	 *            also specifies the depth to indicate the levels of child
	 *            metadata objects to retrieve. If the START_AT option is not
	 *            provided then retrieval starts at the root level.
	 * @param connection
	 *            Adapter connection object to be used for connecting to the
	 *            third party
	 * @param catalog
	 *            The object to store the retrieved metadata catalog which is of
	 *            interest to the user. The results of incremental calls are
	 *            maintained in this object.
	 * @return true if the adapter applies the filter options, false if the SDK
	 *         applies the filers on the adapter's behalf.
	 */
	@Override
	public Boolean populateObjectCatalog(Connection connection, List<Option> options, Catalog catalog) {
		if (LOGGER.isLoggable(Level.FINER)) {
			final List<String> optionStrings = new ArrayList<>();
			for (Option option : options) {
				optionStrings.add(String.format("%s", option.getValue()));
			}
			LOGGER.finer(String.format("Connection: %s, Options: %s, Catalog: %s", connection != null, optionStrings,
					catalog));
		}
		Factory sdkFactory = catalog.getFactory();
		this.sdkFactory = sdkFactory;
		// Use the startFolder for incremental browsing of metadata
		Package startFolder = MetadataUtils.getStartFolder(options);
		LOGGER.finer(String.format("Start Folder: %s", startFolder));

		String nameFilter = MetadataUtils.getNameFilter(options);
		String catName = ((SnowflakeV2Connection) connection).getCatalog();
		String schemaName = ((SnowflakeV2Connection) connection).getSchema();
		try {
			DatabaseMetaData metadata = ((SnowflakeV2Connection) connection).getSnowflakeConnection().getMetaData();

			if (startFolder == null) {
				// handle DB list
				List<Package> foundCatalogList = new ArrayList<>();
				ResultSet resultIter = metadata.getCatalogs();
				while (resultIter.next()) {
					String foundCatalogName = resultIter.getString(1);
					Package pack = sdkFactory.newPackage(catalog);
					pack.setName(foundCatalogName);
					foundCatalogList.add(pack);
					if (foundCatalogName.equals(catName)) { // case sensitive
						catalog.addRootPackage(pack);
					}
				}
				resultIter.close();

				if (catalog.getRootPackages().size() == 0) {
					// If none of them matches, add all DB names to the list
					for (Package pack : foundCatalogList) {
						catalog.addRootPackage(pack);
					}
				}
				LOGGER.finer(String.format("Total number of Catalogs: %s, Detected Root Packages: %s",
						foundCatalogList.size(), catalog.getRootPackages().size()));
			} else {
				/*
				 * Get tables of schema. Use name filter if applicable. If name
				 * filter is not applicable, it should be null
				 */
				tabSchema = startFolder;

				boolean foundSchema = false;
				ResultSet schemaResultSet = metadata.getSchemas(tabSchema.getName(), "%");
				while (schemaResultSet.next()) {
					String targetSchema = schemaResultSet.getString(1);
					String taretCatalog = schemaResultSet.getString(2);
					if (targetSchema.equals(schemaName)) {
						foundSchema = true;
					}
					LOGGER.finer(String.format("Catalog: %s, Schema: %s", taretCatalog, targetSchema));
				}
				schemaResultSet.close();

				ResultSet tablesIter = metadata.getTables(tabSchema.getName(), foundSchema ? schemaName : "%", // use
																												// schema
																												// if
																												// found
																												// otherwise
																												// all
																												// schemas
						nameFilter == null ? "%" : "%" + nameFilter + "%", null);

				while (tablesIter.next()) {
					FlatRecord flatRecord = sdkFactory.newFlatRecord(catalog);
					String targetSchema = tablesIter.getString(2);
					String tableName = tablesIter.getString(3);
					String tableType = tablesIter.getString(4);

					flatRecord.setName(tableName);
					flatRecord.setNmoType("table");
					flatRecord.setNativeName(SnowflakeV2MetadataAdapter
							.encodeFullyQualifiedTableName(startFolder.getName(), targetSchema, tableName));

					LOGGER.finer(String.format("Table Type: %s", tableType));
					if ("TABLE".equals(tableType)) {
						flatRecord.setRecordTypeEnum(RecordTypeEnum.INOUT_TYPE);
					} else {
						flatRecord.setRecordTypeEnum(RecordTypeEnum.IN_TYPE);
					}

					SEMTableRecordExtensions mRecExts = (SEMTableRecordExtensions) flatRecord.getExtensions();
					mRecExts.setTableType(tableType);

					startFolder.addChildRecord(flatRecord);
				}

				tablesIter.close();
			}

		} catch (SQLException e) {
			LOGGER.severe(String.format("Failed to get metadata: %s", e.getMessage()));
			return false;
		}

		return true;
	}

	/**
	 * Fetches metadata of the objects based on the options. Use this method to
	 * gather catalog information to support run-time data access when you
	 * create a platform data object corresponding to the fetched metadata
	 * object.
	 * 
	 * @param options
	 *            List of option values.
	 * 
	 * @param importableObjects
	 *            List of native objects that contains object names for which
	 *            the metadata details are required.
	 * 
	 * @param connection
	 *            Adapter connection object to be used for connecting to the
	 *            third party
	 *
	 * @param catalog
	 *            SDKCatalog that contains the retrieved metadata.
	 */
	@Override
	public void populateObjectDetails(Connection connection, List<Option> options,
			List<ImportableObject> importableObjects, Catalog catalog) {
		if (LOGGER.isLoggable(Level.FINER)) {
			final List<String> optionStrings = new ArrayList<>();
			for (Option option : options) {
				optionStrings.add(String.format("%s", option.getValue()));
			}
			LOGGER.finer(String.format("Connection: %s, Options: %s, ImportableObjects: %s, Catalog: %s",
					connection != null, optionStrings, importableObjects, catalog));
		}

		try {
			int optionID;
			boolean isgetRelated = false;
			for (Option opt : options) {
				// TODO: what is this?
				optionID = opt.getDescription().getEffectiveDefinition().getOptionID();
				if (optionID == CDetailImportOpts.GET_NON_CONTAINED_SHARED_DATA_RELS) {
					isgetRelated = true;
				}
			}

			SnowflakeV2Connection sfConnection = (SnowflakeV2Connection) connection;

			DatabaseMetaData metaData = sfConnection.getSnowflakeConnection().getMetaData();
			for (ImportableObject obj : importableObjects) {
				FlatRecord record = (FlatRecord) obj;

				// Add related objects
				if (isgetRelated) {
					ResultSet tablesIter = metaData.getImportedKeys(null, tabSchema.getName(), record.getName());
					while (tablesIter.next()) {
						String PKImportTableName = tablesIter.getString(3);

						FlatRecord relRecord = null;
						for (FlatRecord rec : catalog.getFlatRecords()) {
							if (PKImportTableName.equals(rec.getName())) {
								relRecord = rec;
								break;
							}
						}

						if (relRecord == null) {
							relRecord = sdkFactory.newFlatRecord(catalog);
							relRecord.setName(PKImportTableName);
							relRecord.setNativeName(tabSchema.getName() + "." + PKImportTableName);

							// Set the record access type
							/*
							 * if
							 * (!PKImportTableName.toLowerCase().contains("tgt")
							 * ) relRecord.setRecordTypeEnum(RecordTypeEnum.
							 * OUT_TYPE);
							 */

							catalog.getRootPackage(0).addChildRecord(relRecord);
						}

						RecordRelationship recordRel = sdkFactory.newRecordRelationship(catalog);
						recordRel.setParentRecord(record);
						recordRel.setChildRecord(relRecord);

						recordRel.setName(record.getNativeName() + "." + relRecord.getNativeName());
						catalog.addRecordRelationship(recordRel);
					}
					tablesIter.close();

				} else {
					// add columns
					addColumns(metaData, catalog, record);
				}
			}
		} catch (SQLException e) {
			ExceptionManager.createNonNlsAdapterSDKException(
					"An error occured while fetching metadata:[" + e.getMessage() + "]");
		} catch (Exception e) {
			ExceptionManager.createNonNlsAdapterSDKException(
					"An unexpected exception occured while fetching metadata:[" + e.getMessage() + "]");
		}

	}

	/**
	 * Adds fields to the flat record
	 * 
	 * @param metaData
	 *            The database metadata object of open MySQL connection
	 * @param catalog
	 *            SDKCatalog that contains the retrieved metadata.
	 * @param record
	 *            The flat record that gets filled with fields obtained from
	 *            {@link populateField} method
	 * @throws SQLException
	 */
	protected void addColumns(DatabaseMetaData metaData, Catalog catalog, FlatRecord record) throws SQLException {
		LOGGER.finer(String.format("Metadata: %s, Catalog: %s, Record: %s", metaData, catalog, record));
		Factory sdkFactory = catalog.getFactory();
		List<String> fullQualifiedNameList = SnowflakeV2MetadataAdapter
				.decodeFullyQualifiedTableName(record.getNativeName());
		String catalogName = fullQualifiedNameList.get(0);
		String schemaName = fullQualifiedNameList.get(1);
		String tableName = fullQualifiedNameList.get(2);

		ResultSet columnsIter = metaData.getColumns(catalogName, schemaName, tableName, null);

		// Adding index, package, uniquekeys
		Index ind = sdkFactory.newIndex(catalog);
		PrimaryKey pk = sdkFactory.newPrimaryKey(catalog);
		UniqueKey uk = sdkFactory.newUniqueKey(catalog);
		List<String> pkNames = new ArrayList<>();

		// First parameter to be set to catalog.getName() if restricting search
		// to catalog
		ResultSet primaryKeys = metaData.getPrimaryKeys(catalogName, schemaName, tableName);

		while (primaryKeys.next()) {
			LOGGER.finer(String.format("Primary Key: %s", primaryKeys.getString(4)));
			pkNames.add(primaryKeys.getString(4));
		}
		LOGGER.finer(String.format("Number of PkNames: %s", pkNames.size()));

		while (columnsIter.next()) {
			Field field = sdkFactory.newField(catalog);
			populateField(field, columnsIter, catalogName, schemaName, tableName);

			// Checking if primary and then adding the keys
			if (pkNames.contains(field.getName())) {
				IndexField idxFld = sdkFactory.newIndexField(catalog);
				idxFld.setIndexBaseField(field);
				idxFld.setName(field.getName());
				ind.addIndexField(idxFld);
				ind.setName(field.getName());
				ind.setNativeName(field.getNativeName());
				pk.addField(field);
				pk.setName(field.getName());
				pk.setNativeName(field.getName());
				uk.addField(field);
				uk.setName(field.getName());
				uk.setNativeName(field.getName());

				record.addIndex(ind);
				record.addPrimaryKey(pk);
				record.addUniqueKey(uk);
			}

			record.addField(field);
		}
		columnsIter.close();
	}

	/**
	 * Populates the field level metadata
	 * 
	 * @param field
	 *            Field object used for setting information to a native field
	 *            object
	 * @param columnsIter
	 *            A ResultSet object containing the result of a query obtained
	 *            from metadata.getColumns() for Snowflake DB
	 * @throws SQLException
	 *             if any ResultSet exception occurs
	 */

	protected void populateField(Field field, ResultSet columnsIter, String catalogName, String schemaName,
			String tableName) throws SQLException {
		String name = columnsIter.getString(4);
		String dType = columnsIter.getString(6);
		int length = columnsIter.getInt(16);
		int scale = columnsIter.getInt(9);
		int precision = columnsIter.getInt(7);

		if (LOGGER.isLoggable(Level.FINER)) {
			LOGGER.finer(String.format("Field: %s, Name: %s, Type: %s," + " Length: %s, Precision: %s, Scale: %s",
					field, name, dType, length, scale, precision));
		}
		field.setName(name);
		field.setNativeName(SnowflakeV2MetadataAdapter.encodeFullyQualifiedTableName(catalogName, schemaName, tableName)
				+ "." + SnowflakeV2MetadataAdapter.encodeFullyQualifiedName(name));
		field.setLength(length);

		String[] datatype = dType.split(" ");
		if (datatype.length > 1) {
			if ((datatype[1].equals("UNSIGNED"))) {
				dType = datatype[0];
			}
		}

		field.setDataType(dType);
		field.setScale(scale);

		// if (dType.equalsIgnoreCase("BIT"))
		if (dType.equalsIgnoreCase("DOUBLE")) {
			field.setPrecision(38);
			field.setScale(5);
		} else if (dType.startsWith("TIMESTAMP")) {
			field.setPrecision(38);
		} else if (dType.startsWith("DATE")) {
			field.setPrecision(38);
		} else if (dType.startsWith("TIME")) {
			field.setPrecision(38);
		} else if (dType.equalsIgnoreCase("BOOLEAN")) {
			field.setPrecision(7);
		} else if (dType.equalsIgnoreCase("OBJECT")) {
			field.setPrecision(65536);
		} else if (dType.equalsIgnoreCase("ARRAY")) {
			field.setPrecision(65536);
		} else if (dType.equalsIgnoreCase("VARIANT")) {
			field.setPrecision(65536);
		} else {
			field.setPrecision(precision);
		}

		/*
		 * //Set the field access type if(!name.toLowerCase().contains("tgt"))
		 * field.setFieldTypeEnum(FieldTypeEnum.OUT_TYPE);
		 */
		// TODO: do we need to set Field Type Enum? IN/OUT/INOUT

		// Populating the field extensions: Default value, isNullable
		String defValue = columnsIter.getString(13);
		boolean isNullable = !"0".equals(columnsIter.getString(11));

		// TODO: why field.setNullable or field.setDefaultColValue cannot be
		// used here
		SEMTableFieldExtensions mFieldExts = (SEMTableFieldExtensions) field.getExtensions();
		mFieldExts.setDefaultColValue(defValue);
		mFieldExts.setIsNullable(isNullable);
	}

	/**
	 * Caters to the user request to create/update/delete metadata in external
	 * system using the objects and options provided
	 * 
	 * @param sdkConnection
	 *            Adapter connection object to be used for connecting to the
	 *            third party.
	 * @param writeSession
	 *            Session Object used to get metadata object on which action is
	 *            required and corresponding overridden options. Also used to
	 *            update back metadata write related results for each object.
	 * @param defOptions
	 *            default writeOptions for metadata object
	 * @return Status object that contains method success status.
	 */

	@Override
	public Status writeObjects(Connection connection, MetadataWriteSession writeSession,
			MetadataWriteOptions defOptions) {
		LOGGER.finer(String.format("Connection: %s, Session: %s, Options: %s", connection != null, writeSession,
				defOptions));
		// retrieve the options
		/*
		 * int optionID; List<Option> options = defOptions.getOptions(); Boolean
		 * defCreateIfMissing = true; for (Option option : options) { optionID =
		 * option.getDescription().getEffectiveDefinition() .getOptionID(); if
		 * (optionID == CWriteObjectsOpts.DROP_AND_CREATE) { defCreateIfMissing
		 * = (Boolean) option.getValue(); } else {
		 * //ExceptionManager.createNonNlsAdapterSDKException(
		 * "Not supported option found"); } } //get default parent and action
		 * type MetadataObject defParentObj = defOptions.getParentObject();
		 * ActionTypeEnum defActType = defOptions.getActionType();
		 * List<MetadataWriteAction> wrtActions =
		 * writeSession.getWriteActions(); Catalog catalog = null;
		 * 
		 * //perform individual actions for(MetadataWriteAction action:
		 * wrtActions) { MetadataObject objToWrite = action.getObjectToWrite();
		 * MetadataWriteOptions wrtOptions = action.getWriteOptions();
		 * ActionTypeEnum actType = defActType; MetadataObject parentObj =
		 * defParentObj; Boolean createIfMissing = defCreateIfMissing;
		 * 
		 * //if overridden options are provided, get the overridden values of
		 * parent action type, options. Else, take default global options
		 * if(wrtOptions != null){ //get current action type, parent, options
		 * actType = wrtOptions.getActionType(); parentObj =
		 * wrtOptions.getParentObject(); List<Option> currOptions =
		 * wrtOptions.getOptions(); for (Option option : currOptions) { optionID
		 * = option.getDescription().getEffectiveDefinition() .getOptionID(); if
		 * (optionID == CWriteObjectsOpts.DROP_AND_CREATE) { createIfMissing =
		 * (Boolean) option.getValue(); } else {
		 * //ExceptionManager.createNonNlsAdapterSDKException(
		 * "Not supported option found"); } } }
		 * 
		 * 
		 * if(objToWrite instanceof FlatRecord){ FlatRecord rec =
		 * (FlatRecord)objToWrite; String recName = rec.getNativeName();
		 * List<FieldBase> flds = rec.getFieldList(); //get parent package under
		 * which the record should be inserted List<Package> pkgs =
		 * rec.getParentPackages(); catalog = rec.getCatalog();
		 * 
		 * //create/update/delete record in external system using metadata
		 * connection and record/field details provided switch(actType){ case
		 * create: //create record under parent parentObj break; case delete:
		 * //delete record break; case update: //update record break; default:
		 * break;
		 * 
		 * 
		 * } MetadataWriteResults res = new MetadataWriteResults(new
		 * Status(StatusEnum.SUCCESS, "")); //if updated object is different,
		 * set the appropriate value FlatRecord updatedObject =
		 * catalog.getFactory().newFlatRecord(catalog);
		 * updatedObject.setName("someName"); //set other attributes
		 * res.setUpdatedObject(updatedObject); action.setWriteResults(res); } }
		 */

		// return success if writeback succeeded
		return new Status(StatusEnum.SUCCESS, "");
	}

	/**
	 * Encodes a string with double quotes. Note the object name cannot include
	 * double quotes, so it is safe to surround the name with double quotes
	 * without escaping characters.
	 * 
	 * @param objectName
	 * @return a object name surrounded by double quotes
	 */
	private static final String encodeFullyQualifiedName(String objectName) {
		return "\"" + objectName + "\"";
	}

	/**
	 * Encodes catalog, schema and table names into a fully qualified name
	 * 
	 * @param catalog
	 * @param schema
	 * @param table
	 * @return a fully qualified table name
	 */
	private static final String encodeFullyQualifiedTableName(String catalog, String schema, String table) {
		return SnowflakeV2MetadataAdapter.encodeFullyQualifiedName(catalog) + "."
				+ SnowflakeV2MetadataAdapter.encodeFullyQualifiedName(schema) + "."
				+ SnowflakeV2MetadataAdapter.encodeFullyQualifiedName(table);
	}

	/**
	 * Decodes a fully qualified name into catalog, schema and table.
	 * 
	 * @param fullyQualifiedTableName
	 * @return
	 */
	private static final List<String> decodeFullyQualifiedTableName(String fullyQualifiedTableName) {
		List<String> ret = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		for (int idx = 1; idx < fullyQualifiedTableName.length();) {
			char ch = fullyQualifiedTableName.charAt(idx);
			if (ch == '"') {
				ret.add(sb.toString());
				sb = new StringBuffer();
				idx += 3; // skip '.' and the next '"'
			} else {
				sb.append(ch);
				if (ch == '"') {
					++idx;
					sb.append(ch);
				}
				++idx;
			}
		}
		return ret;
	}
}