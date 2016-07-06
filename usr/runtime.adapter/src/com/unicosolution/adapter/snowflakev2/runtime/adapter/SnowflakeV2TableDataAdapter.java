package com.unicosolution.adapter.snowflakev2.runtime.adapter;

import com.informatica.sdk.adapter.javasdk.dataadapter.DataAdapter;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TimeZone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;

import com.informatica.sdk.adapter.javasdk.common.EIUDIndicator;
import com.informatica.sdk.adapter.javasdk.common.ErrorRowInfo;
import com.informatica.sdk.adapter.javasdk.common.Logger;
import com.informatica.sdk.adapter.javasdk.common.PartitionInfo;
import com.informatica.sdk.adapter.javasdk.common.ELogLevel;
import com.informatica.sdk.adapter.javasdk.common.EMessageLevel;
import com.informatica.sdk.adapter.javasdk.common.EReturnStatus;
import com.informatica.sdk.adapter.javasdk.common.RowsStatInfo;
import com.informatica.sdk.adapter.javasdk.dataaccess.DataSession;
import com.informatica.sdk.adapter.javasdk.common.EIndicator;
import com.informatica.sdk.adapter.javasdk.metadata.EmetadataHandleTypes;
import com.informatica.sdk.adapter.javasdk.metadata.RuntimeConfigMetadata;
import com.informatica.sdk.adapter.javasdk.metadata.UserContext;
import com.informatica.sdk.adapter.metadata.capabilityattribute.semantic.iface.CapabilityAttributes;
import com.informatica.sdk.adapter.metadata.capabilityattribute.semantic.iface.WriteCapabilityAttributes;
import com.informatica.sdk.adapter.metadata.patternblocks.constraint.semantic.iface.PrimaryKey;
import com.informatica.sdk.adapter.metadata.patternblocks.field.semantic.iface.Field;
import com.informatica.sdk.adapter.metadata.patternblocks.flatrecord.semantic.iface.FlatRecord;
import com.informatica.sdk.adapter.metadata.patternblocks.shared.semantic.iface.ImportableObject;
import com.informatica.sdk.adapter.metadata.patternblocks.shared.semantic.iface.Record;
import com.informatica.sdk.adapter.metadata.projection.expression.semantic.iface.BinaryOperatorEnum;
import com.informatica.sdk.adapter.metadata.projection.expression.semantic.iface.Constant;
import com.informatica.sdk.adapter.metadata.projection.expression.semantic.iface.DateConstant;
import com.informatica.sdk.adapter.metadata.projection.expression.semantic.iface.DecimalConstant;
import com.informatica.sdk.adapter.metadata.projection.expression.semantic.iface.FieldIdentifier;
import com.informatica.sdk.adapter.metadata.projection.expression.semantic.iface.IntegerConstant;
import com.informatica.sdk.adapter.metadata.projection.expression.semantic.iface.LeafExpression;
import com.informatica.sdk.adapter.metadata.projection.expression.semantic.iface.SDKExpression;
import com.informatica.sdk.adapter.metadata.projection.expression.semantic.iface.StringConstant;
import com.informatica.sdk.adapter.metadata.projection.helper.semantic.iface.BasicProjectionField;
import com.informatica.sdk.adapter.metadata.projection.helper.semantic.iface.BasicProjectionView;
import com.informatica.sdk.exceptions.SDKException;
import com.informatica.sdk.adapter.javasdk.dataadapter.ReadAttributes;
import com.informatica.sdk.adapter.javasdk.dataadapter.WriteAttributes;
import com.informatica.sdk.adapter.javasdk.dataaccess.DataAttributes;
import com.snowflake.client.jdbc.internal.fasterxml.jackson.databind.Module.SetupContext;
import com.unicosolution.adapter.snowflakev2.runtimemessages.*;
import com.unicosolution.adapter.snowflakev2.table.runtime.capability.semantic.iface.SEMTableWriteCapabilityAttributesExtension;
import com.informatica.sdk.adapter.metadata.projection.projectionoperation.semantic.iface.ProjectionOperation;
import com.informatica.sdk.adapter.metadata.projection.filteroperation.semantic.iface.FilterOperation;
import com.informatica.sdk.adapter.metadata.projection.joinoperation.semantic.iface.JoinOperation;
import com.informatica.sdk.adapter.metadata.projection.sortoperation.semantic.iface.SortOperation;
import com.informatica.sdk.adapter.metadata.aso.semantic.iface.ASOOperation;
import com.informatica.sdk.adapter.metadata.capabilityattribute.semantic.iface.ASOComplexType;
import com.informatica.sdk.adapter.metadata.projection.semantic.iface.Projection;
import com.informatica.sdk.adapter.metadata.projection.simpleexpression.semantic.iface.SimpleBinaryExpression;
import com.informatica.sdk.adapter.metadata.projection.simpleexpression.semantic.iface.SimpleSDKExpression;
import com.informatica.sdk.adapter.metadata.common.datasourceoperation.semantic.iface.Capability;
import com.informatica.sdk.adapter.metadata.projection.semantic.iface.OperationBase;
import com.informatica.sdk.adapter.metadata.common.datasourceoperation.semantic.iface.ReadCapability;
import com.informatica.sdk.adapter.metadata.projection.semantic.iface.FieldBase;
import com.informatica.sdk.adapter.metadata.projection.semantic.iface.NativeField;
import com.informatica.sdk.adapter.metadata.projection.projectionoperation.semantic.iface.SelectTypeEnum;
import com.informatica.sdk.adapter.metadata.projection.sortoperation.semantic.iface.SortOrderEnum;
import com.informatica.sdk.adapter.metadata.projection.sourceoperation.semantic.iface.NativeSource;

@SuppressWarnings("unused")
public class SnowflakeV2TableDataAdapter extends DataAdapter {

	private Logger logger = null;
	
	private int BATCH_SIZE = 1000;

	private List<BasicProjectionField> projectionFields = null;

	private List<FieldInfo> connectedFields = null;

	private CapabilityAttributes capAttrs = null;

	private BasicProjectionView projectionView = null;

	private List<ImportableObject> nativeRecords = null;
	private ResultSet rs = null;
	private String filterQuery;
	private FilterOperation m_FilterOperation;
	private String lookupExpr = "";
	private String simpleLogicalOp;
	private FlatRecord fr = null;

	private String sortquery;
	private String selectdestinct = "";
	private String selectexpression;
	private int currPartIndex;

	private SortOperation m_SortOperation;
	private ArrayList<String> joinTypes;
	private ArrayList<String> joinExprs;

	private List<FieldBase> sortFieldBase;
	private SelectTypeEnum selType;
	private List<SortOrderEnum> sortOrderEnum;

	private String nativeFilterQuery;
	private String nativeJoinQuery;

	/**
	 * Initializes the data session. This method is called once for the current
	 * plugin -> Data Source Object -> Thread and is called sequentially for
	 * each thread.
	 * 
	 * @param dataSession
	 *            The dataSession instance, which is the container for SDK
	 *            handles.
	 * @return EReturnStatus The status of the initialization call.
	 */

	@Override
	public int initDataSession(DataSession dataSession) throws SDKException {
		// Use the logger for logging messages to the session log
		// as logMessage(ELogLevel.TRACE_NONE, Messages.CONN_SUCC_200,
		// "user",6005,5.2);
		this.logger = dataSession.getInfaUtilsHandle().getLogger();

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL,
				"SnowflakeV2TableDataAdapter:initDataSession:: begin");

		filterQuery = "";

		// The runtime metadata handle allows access to runtime metadata
		// information
		RuntimeConfigMetadata runtimeMetadataHandle = (RuntimeConfigMetadata) dataSession
				.getMetadataHandle(EmetadataHandleTypes.runtimeConfigMetadata);
		
		// Use the basic projection view to get basic details like the projected
		// fields/ filter / join metadata
		projectionView = runtimeMetadataHandle.getBasicProjection();
		
		// projectionFields has all fields of the native object to the platform
		// source/target
		projectionFields = projectionView.getProjectionFields();
		
		// connected fields is the subset of fields which are actually used in
		// the mapping.
		// use to fetch/write data to/from the native source
		connectedFields = getConnectedFields(runtimeMetadataHandle);

		// native flatrecord list used in the data session
		nativeRecords = projectionView.getNativeRecords();

		// handle to the list of capability attributes. Get the read/write
		// capability details using this list
		capAttrs = runtimeMetadataHandle.getCapabilityAttributes();
		
		// Get the current selected record
		fr = (FlatRecord) nativeRecords.get(0); // start mentioning the first
												// table name in a query

		SnowflakeV2UserContext suc = new SnowflakeV2UserContext();
		suc.setResetRowIndex(true);
		suc.setTotalRows(0);

		// Save the user context handle
		setSnowflakeUserContext(dataSession, suc);

		filterQuery = "";
		joinTypes = new ArrayList<String>();
		joinExprs = new ArrayList<String>();

		// Get the partition specific information if Partitioning is enabled
		PartitionInfo pInfo = runtimeMetadataHandle.getPartitionInfo();
		currPartIndex = pInfo.getCurrentPartitionIndex();
		int totParts = pInfo.getTotalAdapterPartitions();

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL,
				"SnowflakeV2TableDataAdapter:initDataSession:: filterQuery : " + filterQuery);

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL,
				"SnowflakeV2TableDataAdapter:initDataSession:: joinTypes : " + joinTypes);

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL,
				"SnowflakeV2TableDataAdapter:initDataSession:: joinExprs : " + joinExprs);

		int status = processFilterAndJoin(runtimeMetadataHandle);

		if (status != EReturnStatus.SUCCESS) {
			return status;
		}

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL,
				"SnowflakeV2TableDataAdapter:initDataSession:: end");

		return EReturnStatus.SUCCESS;
	}

	/**
	 * Builds the Join expression by resolving the table name and the column
	 * name
	 * 
	 * @param simplBinExpr
	 *            An object of SimpleBinaryExpression class, from which the
	 *            left/right operand and the operator are extracted.
	 * @return The expression in the form of tableName.columnName
	 */

	private String getResolvedJoinExpression(SimpleBinaryExpression simplBinExpr) {
		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL, "getResolvedJoinExpression:: begin");

		FieldIdentifier pLeftFieldIden = (FieldIdentifier) simplBinExpr.getLeftOperand();

		Field lfield = (Field) pLeftFieldIden.getNativeFieldRef();
		String lParentName = buildTabName(lfield.getParentRecord().getName()); // changed
																				// from
																				// nativeName
																				// to
																				// name
		String lOperandName = lParentName + ".\"" + pLeftFieldIden.getBaseField().getName() + "\"";

		FieldIdentifier pRightFieldIden = (FieldIdentifier) simplBinExpr.getRightOperand();

		Field rfield = (Field) pRightFieldIden.getNativeFieldRef();
		String rParentName = buildTabName(rfield.getParentRecord().getName()); // changed
																				// from
																				// nativeName
																				// to
																				// name
		String rOperandName = rParentName + ".\"" + pRightFieldIden.getBaseField().getName() + "\"";

		String finalExpr = lOperandName + " " + getOperator(simplBinExpr.getBinaryOperator()) + " " + rOperandName;

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL,
				"getResolvedJoinExpression:: finalExpr: " + finalExpr);

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL, "getResolvedJoinExpression:: end");

		return finalExpr;
	}

	/**
	 * Gets the list of connected fields in the read or write operation. If the
	 * method is referenced with any unconnected fields, the method may
	 * encounter errors.
	 * 
	 * @param runtimeMetadataHandle
	 *            The run-time metadata handle of the DataSession.
	 * @return A list of Fields that are connected in the read or write
	 *         operation.
	 */

	private ArrayList<FieldInfo> getConnectedFields(RuntimeConfigMetadata runtimeMetadataHandle) {

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL, "getConnectedFields:: begin");

		int i = 0;
		ArrayList<FieldInfo> fields = new ArrayList<FieldInfo>();
		for (BasicProjectionField pfield : projectionFields) {
			if (runtimeMetadataHandle.isFieldConnected(i)) {
				FieldInfo f = new FieldInfo(pfield, i);
				fields.add(f);
			}
			i++;
		}

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL, "getConnectedFields:: end");
		return fields;
	}

	/**
	 * parse the mapping graph to obtain filter and join expressions
	 * 
	 * @return status of processing of filter and join expressions
	 ************************************* 
	 *         AUTOGENERATED CODE : DO NOT CHANGE
	 ************************************* 
	 */

	private int processFilterAndJoin(RuntimeConfigMetadata runtimeMetadataHandle) {
		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL, "processFilterAndJoin:: begin");

		ASOOperation m_asoOperation = runtimeMetadataHandle.getAdapterDataSourceOperation();

		ASOComplexType asoComplexType = m_asoOperation.getComplexTypes().get(0);

		List<Projection> projlist = asoComplexType.getProjections();

		List<Capability> caps = m_asoOperation.getCapabilities();

		Capability cap = caps.get(0);

		for (int j = 0; j < projlist.size(); j++) {

			Projection proj = projlist.get(j);
			if (proj == null) {
				logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE, "Error : Projections is NULL");
				return EReturnStatus.FAILURE;
			}

			List<OperationBase> baseOperList = proj.getBaseOperations();
			if (baseOperList == null) {
				logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE,
						"Error : Base Projection is NULL");
				return EReturnStatus.FAILURE;
			}

			int status = EReturnStatus.SUCCESS;
			for (int itrProj = 0; itrProj < baseOperList.size(); itrProj++) {
				OperationBase ob = baseOperList.get(itrProj);
				if (ob == null) {
					logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE,
							"Error : Operation Base is NULL");
					return EReturnStatus.FAILURE;
				}

				if (cap instanceof ReadCapability) {
					if (ob instanceof FilterOperation) {
						FilterOperation filterOperation = (FilterOperation) ob;
						if (filterOperation.isNativeFilter()) {
							status = processNativeFilter((FilterOperation) ob);
						} else {
							status = processPlatformFilter((FilterOperation) ob);
						}
					} else if (ob instanceof JoinOperation) {
						if (((JoinOperation) ob).isNativeJoin()) {
							status = processNativeJoin((JoinOperation) ob);
						} else {
							status = processPlatformJoin((JoinOperation) ob);
						}
					} else if (ob instanceof SortOperation) {
						status = processSortOperation((SortOperation) ob);

					} else if (ob instanceof ProjectionOperation) {
						status = processProjectionOperation((ProjectionOperation) ob);
					}

				}
				if (status != EReturnStatus.SUCCESS) {
					return status;
				}
			}
		}
		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL, "processFilterAndJoin:: end");

		return EReturnStatus.SUCCESS;
	}

	/**
	 * Process the native filter expression. This function will be called once
	 * for each native filter operation.
	 * 
	 * @param nativeFilter
	 *            The filter operation instance, which contains the native
	 *            filter expression
	 * @return status of the processing for filter operation
	 */
	private int processNativeFilter(FilterOperation nativeFilter) {
		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL, "processNativeFilter:: begin");

		m_FilterOperation = nativeFilter;
		nativeFilterQuery = m_FilterOperation.getFilterExpression();

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL,
				"Native Filter expression " + m_FilterOperation.getFilterExpression());

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL, "processNativeFilter:: end");

		return EReturnStatus.SUCCESS;
	}

	/**
	 * Process the platform filter expression. This function will be called once
	 * for each platform filter operation.
	 * 
	 * @param platformFilter
	 *            The filter operation instance, which contains the platform
	 *            filter expression
	 * @return status of the processing for filter operation
	 */
	private int processPlatformFilter(FilterOperation platformFilter) {
		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL, "processPlatformFilter:: begin");

		m_FilterOperation = platformFilter;
		SDKExpression expression = m_FilterOperation.getInfaSDKExpression();

		if (expression instanceof SimpleSDKExpression) {
			SimpleSDKExpression simpleExpr = (SimpleSDKExpression) expression;
			simpleLogicalOp = simpleExpr.getLogicalOperator().toString();

			filterQuery = generateFilterClauseFromExpression(expression);
			logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL, filterQuery);
		} else {
			logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL, "Unsupported expression type");
			return EReturnStatus.FAILURE;
		}

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL, "processPlatformFilter:: end");

		return EReturnStatus.SUCCESS;
	}

	/**
	 * Process the native join expression. This function will be called once for
	 * each native join operation.
	 * 
	 * @param nativeJoin
	 *            The join operation instance, which contains the native join
	 *            expression
	 * @return status for the processing of join operation
	 */
	private int processNativeJoin(JoinOperation nativeJoin) {
		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL, "processNativeJoin:: begin");

		nativeJoinQuery = nativeJoin.getJoinCondition();
		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL,
				"Native Join expression " + nativeJoin.getJoinCondition());

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL, "processNativeJoin:: end");

		return EReturnStatus.SUCCESS;
	}

	/**
	 * Process the platform join expression. This function will be called once
	 * for each platform join operation.
	 * 
	 * @param platformJoin
	 *            The join operation instance, which contains the platform join
	 *            expression
	 * @return status for the processing of join operation
	 */
	private int processPlatformJoin(JoinOperation platformJoin) {
		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL, "processPlatformJoin:: begin");

		SDKExpression expression = platformJoin.getInfaSDKExpression();
		String jexpr = "";
		switch (platformJoin.getJoinPolicyEnum()) {
		case INNERJOIN:
			joinTypes.add("JOIN");
			break;
		case LEFTOUTERJOIN:
			joinTypes.add("LEFT JOIN");
			break;
		case RIGHTOUTERJOIN:
			joinTypes.add("RIGHT JOIN");
			break;
		case FULLOUTERJOIN:
			joinTypes.add("FULL OUTER JOIN");
			break;
		}

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL,
				"Join expression " + expression.getExpressionString());

		if (expression instanceof SimpleSDKExpression) {
			SimpleSDKExpression simpleExpr = (SimpleSDKExpression) expression;
			simpleLogicalOp = simpleExpr.getLogicalOperator().toString();

			List<SimpleBinaryExpression> simplBinExprs = simpleExpr.getSimpleBinaryExpressions();

			for (SimpleBinaryExpression simplBinExpr : simplBinExprs) {
				jexpr += " " + simpleLogicalOp + " " + getResolvedJoinExpression(simplBinExpr);
			}

			jexpr = jexpr.replaceFirst(simpleLogicalOp, "");
			joinExprs.add(" ON " + jexpr);
		} else {
			logger.logMessage(EMessageLevel.MSG_ERROR, ELogLevel.TRACE_NONE, "Unsupported expression type");
			return EReturnStatus.FAILURE;
		}

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL, "processPlatformJoin:: end");

		return EReturnStatus.SUCCESS;
	}

	private int processProjectionOperation(ProjectionOperation ob) {

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL, "processProjectionOperation:: ");

		ProjectionOperation po = (ProjectionOperation) ob;
		// Get the type of return set for the lookup query
		SelectTypeEnum selType = po.getSelectTypeEnum();

		/*
		 * String selectdestinct; String selectexpression; if
		 * (selType.toString().equalsIgnoreCase("DISTINCT")) electdestinct =
		 * "DISTINCT "; else if
		 * (selType.toString().equalsIgnoreCase("FIRST_ROW") ||
		 * selType.toString().equalsIgnoreCase( "LAST_ROW") ||
		 * selType.toString() .equalsIgnoreCase("ANY")) selectexpression =
		 * " LIMIT 1";
		 */

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL, "processProjectionOperation:: end");
		return EReturnStatus.SUCCESS;

	}

	private int processSortOperation(SortOperation ob) {
		List<FieldBase> sortFieldBase = ob.getSortFieldsList();

		List<SortOrderEnum> sortOrderEnum = ob.getSortOrdersEnumList();
		/*
		 * String sortquery = ""; if (sortFieldBase.size() > 0) if
		 * (sortquery.length() == 0) sortquery = " ORDER BY "; else sortquery +=
		 * ", "; // if more than one sort operation specified in a ASO with
		 * multiple NMOs
		 * 
		 * for (int i = 0; i < sortFieldBase.size(); i++) { if (i > 0) sortquery
		 * += ", ";
		 * 
		 * NativeField nf = (NativeField) sortFieldBase.get(i)
		 * .getSourceFieldRef(); NativeSource ns = (NativeSource) nf
		 * .getContainingOperation();
		 * 
		 * String recName = ns.getNativeRecord().getNativeName();
		 * 
		 * sortquery += recName + "." + nf.getName();
		 * 
		 * if (sortOrderEnum.get(i).toString() .equalsIgnoreCase("DESCENDING"))
		 * sortquery += " desc";
		 */
		return EReturnStatus.SUCCESS;
	}

	/**
	 * Begins the data session once for the current plugin -> DSO -> thread
	 * which could be called in parallel for each thread. If connection pooling
	 * is enabled, then the same connection can initialize multiple data
	 * sessions.
	 * 
	 * @param dataSession
	 *            The Data session instance, which is the container for SDK
	 *            handles.
	 * @return EReturnStatus The status of the begin session call.
	 */

	@Override
	public int beginDataSession(DataSession dataSession) {

		return EReturnStatus.SUCCESS;
	}

	/**
	 * Ends the data session once for the current plugin -> DSO -> thread which
	 * could be called in parallel for each thread. If connection pooling is
	 * enabled, then the same connection can initialize multiple data sessions.
	 * 
	 * @param dataSession
	 *            The Data session instance, which is the container for SDK
	 *            handles.
	 * @return EReturnStatus The status of the end session call.
	 */

	@Override
	public int endDataSession(DataSession dataSession) {
		return EReturnStatus.SUCCESS;
	}

	/**
	 * Deinitializes the data session. This method is called once for the
	 * current plugin -> Data Source Object -> Thread and is called sequentially
	 * for each thread.
	 * 
	 * @param dataSession
	 *            The dataSession instance, which is the container for SDK
	 *            handles.
	 * @return EReturnStatus The status of the deinitialization call.
	 */

	@Override
	public int deinitDataSession(DataSession dataSession) {
		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL, "deinitDataSession:: begin");
		try {
			// Close result set
			if (rs != null) {
				rs.close();
			}
			// Close statements
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL, "deinitDataSession:: end");
		return EReturnStatus.SUCCESS;
	}

	/**
	 * Reads data from the external data source. Returning NO_MORE_DATA after
	 * completion of reading data, stops calling the read method again.
	 * Returning a success informs SDK to continue calling the method.
	 * 
	 * @param dataSession
	 *            The dataSession instance, which is the container for SDK
	 *            handles.
	 * @param readAttr
	 *            The ReadAttributes that provides access to the read specific
	 *            attributes for the data adapter passed during the read phase.
	 * @return EReturnStatus The status of the read call.
	 */

	@Override
	public int read(DataSession dataSession, ReadAttributes readAttr) throws SDKException {

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL, "SnowflakeV2TableDataAdapter:Read:: begin");

		int rowsToRead = readAttr.getNumRowsToRead();

		Statement ps;

		SnowflakeV2TableDataConnection conn = (SnowflakeV2TableDataConnection) dataSession.getConnection();
		SnowflakeV2UserContext suc = getSnowflakeUserContext(dataSession);

		if (!suc.isResetRowIndex()) {
			List<List<Object>> dataTable = new ArrayList<List<Object>>();
			int returnStatus = readDatafromSource(dataSession, dataTable, rowsToRead);
			setDataToPlatform(dataSession, dataTable);
			readAttr.setNumRowsRead(dataTable.size());
			return returnStatus;
		}

		String query = getQuery(connectedFields);
		try {
			Connection nativeConn = (Connection) conn.getNativeConnection();
			ps = nativeConn.createStatement();
			// ps =
			// nativeConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
			// ResultSet.CONCUR_READ_ONLY);

			// Embed the filter query onto the select statement so that
			// filtering happens at the source

			// Supporting native and Simple SDK expression both
			if ((filterQuery != null && filterQuery.length() > 0)
					&& (nativeFilterQuery != null && nativeFilterQuery.length() > 0)) {
				if (nativeJoinQuery != null && nativeJoinQuery.length() > 0)
					query = getNativeJoinQuery(connectedFields) + " WHERE " + filterQuery + " " + simpleLogicalOp
							+ " ( " + nativeFilterQuery + " )";
				else if (joinTypes.size() > 0 || joinExprs.size() > 0)
					query = getJoinQuery(connectedFields) + " WHERE " + filterQuery + " " + simpleLogicalOp + " ( "
							+ nativeFilterQuery + " )";
				else
					query = query + " WHERE " + filterQuery + " " + simpleLogicalOp + " ( " + nativeFilterQuery + " )";
			} else {
				// Combination of filter and join expressions
				if (joinTypes.size() > 0 || joinExprs.size() > 0) {
					if (filterQuery != null && filterQuery.length() > 0)
						query = getJoinQuery(connectedFields) + " WHERE " + filterQuery;
					else if (nativeFilterQuery != null && nativeFilterQuery.length() > 0)
						query = getJoinQuery(connectedFields) + " WHERE " + nativeFilterQuery;
					else
						query = getJoinQuery(connectedFields);
				} else if (nativeJoinQuery != null && nativeJoinQuery.length() > 0) {
					if (filterQuery != null && filterQuery.length() > 0)
						query = getNativeJoinQuery(connectedFields) + " WHERE " + filterQuery;
					else if (nativeFilterQuery != null && nativeFilterQuery.length() > 0)
						query = getNativeJoinQuery(connectedFields) + " WHERE " + nativeFilterQuery;
					else
						query = getNativeJoinQuery(connectedFields);
				}

				// Single filter/join expressions
				else if (filterQuery != null && filterQuery.length() > 0) {
					//filterQuery = filterQuery;
					query = query + " WHERE " + filterQuery;
				} else if (nativeFilterQuery != null && nativeFilterQuery.length() > 0)
					query = query + " WHERE " + nativeFilterQuery;
				else if (lookupExpr != null && lookupExpr.length() > 0)
					query = query + " WHERE " + lookupExpr;

			}

			try {
				logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL,
						"SnowflakeV2TableDataAdapter:Read:: query: " + query);

				rs = ps.executeQuery(query);
			} catch (SQLException e1) {
				ps.close();
				logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE, e1.getMessage());
				return EReturnStatus.FAILURE;
			}

		} catch (SQLException se) {
			logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE, se.getMessage());
			return EReturnStatus.FAILURE;
		}

		List<List<Object>> dataTable = new ArrayList<List<Object>>();

		int returnStatus = readDatafromSource(dataSession, dataTable, rowsToRead);
		setDataToPlatform(dataSession, dataTable);
		readAttr.setNumRowsRead(dataTable.size());

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL, "SnowflakeV2TableDataAdapter:Read:: end");
		return returnStatus;
	}

	/**
	 * Builds the native JOIN query from the constructed generic query excluding
	 * the native JOIN expression.
	 * 
	 * @param connectedFields
	 *            List of connected fields
	 * @return JOIN query including the native JOIN expression
	 */

	private String getNativeJoinQuery(List<FieldInfo> connectedFields) {
		String query = getQuery(connectedFields);

		return query + " ON " + nativeJoinQuery;
	}

	/**
	 * Builds the JOIN query from the constructed generic query along with the
	 * SDK JOIN expression
	 * 
	 * @param connectedFields
	 *            List of connected fields
	 * @return JOIN query along with the SDK JOIN expression
	 */

	private String getJoinQuery(List<FieldInfo> connectedFields) {

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL,
				"SnowflakeV2TableDataAdapter:getJoinQuery:: begin");
		String query = getGenericQuery(connectedFields);
		FlatRecord fr1, fr2;
		String tabName1, tabName2;
		fr1 = (FlatRecord) nativeRecords.get(0);
		fr2 = (FlatRecord) nativeRecords.get(1);
		tabName1 = buildTabName(fr1.getName()); // -unico- changed from
												// nativeName to name
		tabName2 = buildTabName(fr2.getName()); // -unico- changed from
												// nativeName to name

		if (joinExprs.size() > 0)
			query += tabName1 + " " + joinTypes.get(0) + " " + tabName2 + joinExprs.get(0);
		else
			query += tabName1 + " " + joinTypes.get(0) + " " + tabName2;

		for (int i = 2; i < nativeRecords.size(); i++) {
			fr2 = (FlatRecord) nativeRecords.get(i);
			tabName2 = buildTabName(fr2.getName()); // -unico- changed from
													// nativeName to name
			if (joinExprs.size() > 0)
				query += " " + joinTypes.get(i - 1) + " " + tabName2 + joinExprs.get(i - 1);
			else
				query += " " + joinTypes.get(i - 1) + " " + tabName2;
		}
		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL,
				"SnowflakeV2TableDataAdapter:getJoinQuery:: end");
		return query;
	}

	/**
	 * Prepares a generic query from a list of connected fields.
	 * 
	 * @param connectedFields
	 *            List of connected fields
	 * @return The prepared generic query
	 */

	private String getGenericQuery(List<FieldInfo> connectedFields) {

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL,
				"SnowflakeV2TableDataAdapter:getGenericQuery:: begin");

		String query = "SELECT " + selectdestinct;
		boolean addComma = false;
		for (FieldInfo field : connectedFields) {
			if (addComma) {
				query += " , ";
			}
			
			query += buildTabName(field.field.getNativeFieldRef().getParentRecord().getName()) + "."; // -unico-
																										// changed
																										// from
																										// nativeName
																										// to
																										// name
			query += "\"" + field.field.getNativeFieldRef().getName() + "\"";
			addComma = true;
		}
		query += " FROM ";

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL,
				"SnowflakeV2TableDataAdapter:getGenericQuery:: query: " + query);

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL,
				"SnowflakeV2TableDataAdapter:getGenericQuery:: end");
		return query;
	}

	/*
	 * Builds the read query from the connected fields
	 */

	private String getQuery(List<FieldInfo> connectedFields) {

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL,
				"SnowflakeV2TableDataAdapter:getQuery:: begin");

		String query = "SELECT ";
		boolean addComma = false;
		for (FieldInfo field : connectedFields) {
			if (addComma)
				query += " , ";
			query += field.field.getNativeFieldRef().getName();
			addComma = true;
		}
		// Assuming of a single source
		query += " FROM " + ((Record) nativeRecords.get(0)).getName();

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL,
				"SnowflakeV2TableDataAdapter:getQuery:: query: " + query);

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL,
				"SnowflakeV2TableDataAdapter:getQuery:: end");
		return query;
	}

	/**
	 * Reads the data from the native source and populates the data table list
	 * by setting the data only for projected fields that are in the same
	 * sequence. The dataTable is a List of List<Object>. Each List
	 * <Object> represents a single row.
	 * 
	 * @param dataTable
	 *            List of List of Objects. Each List of Objects represents a
	 *            single row.
	 * @param rowsToRead
	 *            Max number of rows to be read
	 * @return EReturnStatus The status of the populate call.
	 * 
	 */

	private int readDatafromSource(DataSession dataSession, List<List<Object>> dataTable, int rowsToRead) {

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL,
				"SnowflakeV2TableDataAdapter:readDatafromSource:: begin");

		int rowsRead = 0;
		int status = EReturnStatus.SUCCESS;

		SnowflakeV2UserContext muc = getSnowflakeUserContext(dataSession);

		try {
			if (muc.isResetRowIndex()) {
				muc.setResetRowIndex(false); // Subsequent read calls should
												// read from the ResultSet
												// instead of making a DB query
			}

			while (rowsRead < rowsToRead) {
				if (!rs.next()) {
					status = EReturnStatus.NO_MORE_DATA;
					break;
				}

				List<Object> datarow = new ArrayList<Object>();
				for (int i = 0; i < connectedFields.size(); i++) {
					String dataType = connectedFields.get(i).field.getNativeFieldRef().getDataType();
					if ("BOOLEAN".equalsIgnoreCase(dataType)) {
						datarow.add(rs.getString(i + 1));
					} else {
						datarow.add(rs.getObject(i + 1));
					}
				}

				dataTable.add(datarow);
				rowsRead++;
			}

			muc.setTotalRows(muc.getTotalRows() + rowsRead);

		} catch (SQLException e) {
			logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE, e.getMessage());
			return EReturnStatus.FAILURE;
		}

		setSnowflakeUserContext(dataSession, muc);

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL,
				"SnowflakeV2TableDataAdapter:readDatafromSource:: end");
		return status;
	}

	/**
	 * Sets the multiple row data in the data table to the data session buffer
	 * 
	 * <pre>
	 * ##################################
	 * AUTOGENERATED CODE
	 * Unico - Modified to handle Snowflake -> Platform mapped datatypes
	 * ##################################
	 * </pre>
	 * 
	 * @param dataSession
	 *            The dataSession instance, which is the container for SDK
	 *            handles.
	 * @param dataTable
	 *            List of List of Objects. Each List of Objects represents a
	 *            single row.
	 */

	private void setDataToPlatform(DataSession dataSession, List<List<Object>> dataTable) throws SDKException {

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL,
				"SnowflakeV2TableDataAdapter:setDataToPlatform:: begin");

		for (int row = 0; row < dataTable.size(); row++) {
			List<Object> rowData = dataTable.get(row);
			for (int col = 0; col < connectedFields.size(); col++) {
				DataAttributes pDataAttributes = new DataAttributes();
				pDataAttributes.setDataSetId(0);
				pDataAttributes.setColumnIndex(connectedFields.get(col).index);
				pDataAttributes.setRowIndex(row);
				Object data = rowData.get(col);

				String dataType = connectedFields.get(col).field.getDataType();
				String columnName = connectedFields.get(col).field.getName();

				BasicProjectionField field = connectedFields.get(col).field;
				String nativeType = field.getNativeFieldRef().getDataType();

				if (dataType.equalsIgnoreCase("string") || dataType.equalsIgnoreCase("text")) {
					if (data == null) {
						pDataAttributes.setLength(0);
						pDataAttributes.setIndicator(EIndicator.NULL);
					} else if ("BOOLEAN".equalsIgnoreCase(nativeType)) {
						String boolValue = data.toString();
						if ("true".equalsIgnoreCase(boolValue) || "t".equalsIgnoreCase(boolValue)
								|| "on".equalsIgnoreCase(boolValue) || "1".equalsIgnoreCase(boolValue)
								|| "y".equalsIgnoreCase(boolValue) || "yes".equalsIgnoreCase(boolValue)) {
							data = "true";
						} else {
							data = "false";
						}
					} else {
						String text = data.toString();

						int fieldLength = connectedFields.get(col).field.getPrec();
						if (text.length() > fieldLength) {
							pDataAttributes.setLength(fieldLength);
							pDataAttributes.setIndicator(EIndicator.TRUNCATED);
							data = text.substring(0, fieldLength);
						} else {
							pDataAttributes.setLength(text.length());
							pDataAttributes.setIndicator(EIndicator.VALID);
						}
					}
                    if ("TIMESTAMPNTZ".equalsIgnoreCase(nativeType)) { //TIMESTAMPNTZ does not accept TimeZone.
                        												//So we have mapped it to Informatica "string" type. But the data from
                         												//the datasource would still be TIMESTAMPNTZ (Timestamp)
                    	//dataSession.setDateTimeData((Timestamp) data, pDataAttributes);
                    	//dataSession.setStringData((String) data.toString(), pDataAttributes);
                    	if (null != data) {
                    		dataSession.setStringData((String) data.toString(), pDataAttributes);
                    	} else {
                    		dataSession.setStringData((String) null, pDataAttributes);
                    	}
					} else {
						dataSession.setStringData((String) data, pDataAttributes);
					}
				} else if (dataType.compareToIgnoreCase("double") == 0) {
					if (data instanceof Double) {
						pDataAttributes.setIndicator(EIndicator.VALID);
					} else if (data instanceof Number) {
						pDataAttributes.setIndicator(EIndicator.VALID);
						data = ((Number) data).doubleValue();
					} else if (data == null) {
						pDataAttributes.setIndicator(EIndicator.NULL);
					} else {
						logger.logMessage(EMessageLevel.MSG_ERROR, ELogLevel.TRACE_NONE,
								"Data for column [" + columnName + "] of type [" + dataType + "] "
										+ "should be a of type [" + Number.class.getName() + "] or its sub-types.");
						data = null;
					}
					dataSession.setDoubleData((Double) data, pDataAttributes);
				} else if (dataType.compareToIgnoreCase("float") == 0) {
					if (data instanceof Float) {
						pDataAttributes.setIndicator(EIndicator.VALID);
					} else if (data instanceof Number) {
						pDataAttributes.setIndicator(EIndicator.VALID);
						data = ((Number) data).floatValue();
					} else if (data == null) {
						pDataAttributes.setIndicator(EIndicator.NULL);
					} else {
						logger.logMessage(EMessageLevel.MSG_ERROR, ELogLevel.TRACE_NONE,
								"Data for column [" + columnName + "] of type [" + dataType + "] "
										+ "should be a of type [" + Number.class.getName() + "] or its sub-types.");
						data = null;
					}
					dataSession.setFloatData((Float) data, pDataAttributes);
				} else if (dataType.compareToIgnoreCase("long") == 0) {
					if (data instanceof Long) {
						pDataAttributes.setIndicator(EIndicator.VALID);
					} else if (data instanceof Number) {
						pDataAttributes.setIndicator(EIndicator.VALID);
						data = ((Number) data).longValue();
					} else if (data == null) {
						pDataAttributes.setIndicator(EIndicator.NULL);
					} else {
						logger.logMessage(EMessageLevel.MSG_ERROR, ELogLevel.TRACE_NONE,
								"Data for column [" + columnName + "] of type [" + dataType + "] "
										+ "should be a of type [" + Number.class.getName() + "] or its sub-types.");
						data = null;
					}
					dataSession.setLongData((Long) data, pDataAttributes);
				} else if (dataType.compareToIgnoreCase("short") == 0) {
					if (data instanceof Short)
						pDataAttributes.setIndicator(EIndicator.VALID);
					else if (data instanceof Number) {
						pDataAttributes.setIndicator(EIndicator.VALID);
						data = ((Number) data).shortValue();
					} else if (data == null) {
						pDataAttributes.setIndicator(EIndicator.NULL);
					} else {
						logger.logMessage(EMessageLevel.MSG_ERROR, ELogLevel.TRACE_NONE,
								"Data for column [" + columnName + "] of type [" + dataType + "] "
										+ "should be a of type [" + Number.class.getName() + "] or its sub-types.");
						data = null;
					}
					dataSession.setShortData((Short) data, pDataAttributes);
				} else if (dataType.compareToIgnoreCase("integer") == 0) {
					if (data instanceof Integer) {
						pDataAttributes.setIndicator(EIndicator.VALID);
					} else if (data instanceof Number) {
						pDataAttributes.setIndicator(EIndicator.VALID);
						data = ((Number) data).intValue();
					} else if (data == null) {
						pDataAttributes.setIndicator(EIndicator.NULL);
					} else {
						logger.logMessage(EMessageLevel.MSG_ERROR, ELogLevel.TRACE_NONE,
								"Data for column [" + columnName + "] of type [" + dataType + "] "
										+ "should be a of type [" + Number.class.getName() + "] or its sub-types.");
						data = null;
					}
					dataSession.setIntData((Integer) data, pDataAttributes);
				} else if (dataType.compareToIgnoreCase("bigint") == 0) {
					if (data instanceof Long) {
						pDataAttributes.setIndicator(EIndicator.VALID);
					} else if (data instanceof Number) {
						pDataAttributes.setIndicator(EIndicator.VALID);
						data = ((Number) data).longValue();
					} else if (data == null) {
						pDataAttributes.setIndicator(EIndicator.NULL);
					} else {
						logger.logMessage(EMessageLevel.MSG_ERROR, ELogLevel.TRACE_NONE,
								"Data for column [" + columnName + "] of type [" + dataType + "] "
										+ "should be a of type [" + Number.class.getName() + "] or its sub-types.");
						data = null;
					}
					dataSession.setLongData((Long) data, pDataAttributes);
				} else if (dataType.compareToIgnoreCase("date/time") == 0) {
					if (data instanceof Date) {
						Timestamp timeStampDate = new Timestamp(((Date) data).getTime());
						data = timeStampDate;
					} else if (data instanceof Timestamp) {
						pDataAttributes.setIndicator(EIndicator.VALID);
					} else if (data == null) {
						pDataAttributes.setIndicator(EIndicator.NULL);
					} else {
						logger.logMessage(EMessageLevel.MSG_ERROR, ELogLevel.TRACE_NONE,
								"Data for column [" + columnName + "] of type [" + dataType + "]"
										+ " should be a of type [" + Timestamp.class.getName() + "].");
						data = null;
					}
					dataSession.setDateTimeData((Timestamp) data, pDataAttributes);
				} else if (dataType.compareToIgnoreCase("binary") == 0) {

					if (data == null) {
						pDataAttributes.setLength(0);
						pDataAttributes.setIndicator(EIndicator.NULL);
					} else if (data instanceof byte[]) {
						byte[] binData = (byte[]) data;
						int fieldLength = connectedFields.get(col).field.getPrec();

						if (binData.length > fieldLength) {
							pDataAttributes.setLength(fieldLength);
							pDataAttributes.setIndicator(EIndicator.TRUNCATED);
							data = Arrays.copyOf(binData, fieldLength);
						} else {
							pDataAttributes.setLength(binData.length);
							pDataAttributes.setIndicator(EIndicator.VALID);

						}
					} else {
						logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_VERBOSE_DATA, "Data for type ["
								+ dataType + "] should be a of type [" + byte[].class.getName() + "].");
						data = null;
						pDataAttributes.setLength(0);
						pDataAttributes.setIndicator(EIndicator.NULL);
					}
					dataSession.setBinaryData((byte[]) data, pDataAttributes);
				} else if (dataType.compareToIgnoreCase("decimal") == 0) {
					if (data instanceof BigDecimal) {
						pDataAttributes.setIndicator(EIndicator.VALID);
					} else if (data == null) {
						pDataAttributes.setIndicator(EIndicator.NULL);
					} else {
						logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_VERBOSE_DATA, "Data for type ["
								+ dataType + "] should be a of type [" + BigDecimal.class.getName() + "].");
						data = null;
					}
					dataSession.setBigDecimalData((BigDecimal) data, pDataAttributes);
				}
			}
		}

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL,
				"SnowflakeV2TableDataAdapter:setDataToPlatform:: end");

	}

	/**
	 * Writes data to the external data source. The SDK continues to call this
	 * method until it completes writing data to the data source.
	 * 
	 * @param dataSession
	 *            The dataSession instance, which is the container for SDK
	 *            handles.
	 * @param writeAttr
	 *            The WriteAttributes that provides access to the write specific
	 *            attributes for the data adapter passed during the read phase.
	 * @return EReturnStatus The status of the write call.
	 */

	@Override
	public int write(DataSession dataSession, WriteAttributes writeAttr) throws SDKException {

		// Get runtime config metadata handle
		RuntimeConfigMetadata runtimeMd = (RuntimeConfigMetadata) dataSession
				.getMetadataHandle(EmetadataHandleTypes.runtimeConfigMetadata);

		//Checking the first row is good enough
		int operationType = runtimeMd.getRowIUDIndicator(0);
		
		//operationType = EIUDIndicator.INSERT; //Only for testing
		
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_VERBOSE_DATA, "Operation Type: " + operationType);

		int returnStatus = EReturnStatus.FAILURE;

		switch (operationType) {
		case EIUDIndicator.INSERT:
			returnStatus = writeInsert(dataSession, writeAttr);
			break;
		case EIUDIndicator.DELETE:
			returnStatus = writeDelete(dataSession, writeAttr);
			break;
		case EIUDIndicator.UPDATE:
			returnStatus = writeUpdate(dataSession, writeAttr);
			break;

		default: // Default is INSERT
			returnStatus = writeInsert(dataSession, writeAttr);
			
			//returnStatus = writeUpsert(dataSession, writeAttr);
			//Will enable UPSERT when Infa starts supporting the operation
			
			break;

		}

		return returnStatus;
	}

	/**
	 * <pre>
	 * Steps:
	 * 1. Get the runtime handle from platform
	 * 2. Get the number of rows to insert
	 * 3. Get the additional properties (that were defined in the Write Capability section) and their values
	 * 4. Get the target table name and build base queries for single insert, batch insert and bulk insert
	 * 5. Begin Transaction on the native connection 
	 * 		5.a. Truncate the target table if opted	
	 * 		5.b. For each row to be written, build and / or execute queries
	 * 				5.b.1.  If single-insert, 
	 * 						5.b.1.i. 	If the value is too large for the target, reject the row and move to the next
	 * 						5.b.1.ii.	Else Execute the insert query
	 * 				5.b.2. If bulk-insert,
	 * 						5.b.2.i.	Append the value list and / or column list and move to the next row
	 * 				5.b.3. If using batch,
	 * 						5.b.3.i.	Add the constructed query to the batch
	 * 						5.b.3.ii.	If the size of the batch has reached the defined limit, execute the current batch and clear it
	 * 		5.c. If bulk-insert,
	 * 				5.c.1. Execute the bulk query
	 * 				5.c.2. If unsuccessful, ROLLBACK the transaction
	 * 		5.d. If using batch,
	 * 				5.d.1. If the batch contains more rows to be executed, execute the batch and clear it
	 * 		5.e. Free up the DB resources as needed
	 * 		5.f. If there were no ROLLBACK in previous steps, COMMIT the transaction
	 * 6. End Transaction on the native connection
	 * </pre>
	 * 
	 * @param dataSession
	 * @param writeAttr
	 * @return
	 * @throws SDKException
	 */
	private int writeInsert(DataSession dataSession, WriteAttributes writeAttr) throws SDKException {

		Statement stmt = null;
		PreparedStatement ps = null;

		int batchCount = 0;
		List<ErrorRowInfo> errorRowInfo = new ArrayList<ErrorRowInfo>();
		String valueList;
		String writerPartID = null;
		boolean bulkLoad = false;
		ExecutionType queryExecType = ExecutionType.BATCH;
		boolean truncateTable = false;
		boolean txnRolledBack = false;
		ASOOperation m_asoOperation;

		/** 1. Get the runtime handle from platform */
		RuntimeConfigMetadata runtimeMetadataHandle = (RuntimeConfigMetadata) dataSession
				.getMetadataHandle(EmetadataHandleTypes.runtimeConfigMetadata);
		if (runtimeMetadataHandle == null) {
			logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE,
					"writeInsert Error : Runtime Handle is NULL");
			return EReturnStatus.FAILURE;
		}
		
		SnowflakeV2UserContext uc = getSnowflakeUserContext(dataSession);
		FlatRecord fr = (FlatRecord) projectionView.getNativeRecords().get(0);
		String tabName = buildTabName(fr.getName());

		/** 2. Get the number of rows to insert */
		int rowsToWrite = writeAttr.getNumRowsToWrite();

		/**
		 * 3. Get the additional properties (that were defined in the Write
		 * Capability section) and their values
		 */
		m_asoOperation = runtimeMetadataHandle.getAdapterDataSourceOperation();
		WriteCapabilityAttributes writeCapAttr = m_asoOperation.getWriteCapabilityAttributes();
		if (writeCapAttr != null) {
			SEMTableWriteCapabilityAttributesExtension partAttris = (SEMTableWriteCapabilityAttributesExtension) (writeCapAttr)
					.getExtensions();

			writerPartID = partAttris.getPartitionID();
			bulkLoad = partAttris.isBulkLoad();
			truncateTable = partAttris.isTruncateTargetTable();
		}
		queryExecType = getQueryExecType(bulkLoad);

		/**
		 * 4. Get the target table name and build base queries for single
		 * insert, batch insert and bulk insert
		 */

		String truncateQuery = "TRUNCATE TABLE " + tabName;

		String insertQueryBase = "INSERT INTO " + tabName + " ( " + getTargetColumnList() + " ) ";
		
		String insertQueryBulk = "";
		String insertQueryBatch = insertQueryBase;
		String insertQuerySingle = insertQueryBase;
		
		//Construct the appropriate query based on the ExecutionType
		switch (queryExecType) {
		case SINGLE:
			insertQuerySingle += getSingleInsertQuery(tabName);
			break;
		case BATCH:
			insertQueryBatch += "values ( ";
			for (int i = 0; i < connectedFields.size(); i++) {
				insertQueryBatch += "?, ";
			}
			insertQueryBatch = insertQueryBatch.substring(0, insertQueryBatch.lastIndexOf(",")) + ") ";
			break;
		case BULK:
			break;
		default:
			break;
		}

		// Get rows statistics info to update row statistics etc.
		RowsStatInfo rowsStatInfo = runtimeMetadataHandle.getRowsStatInfo(EIUDIndicator.INSERT);

		/** 5. Begin Transaction on the native connection */
		SnowflakeV2TableDataConnection conn = (SnowflakeV2TableDataConnection) dataSession.getConnection();
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_VERBOSE_DATA,
				"WRITE-Insert: Got the connection handle");
		Connection nativeConn = (Connection) conn.getNativeConnection();
		try {
			nativeConn.setAutoCommit(false); // BEGIN TRANSACTION

			stmt = nativeConn.createStatement(); //For Bulk and Truncate Queries
			
			if (queryExecType == ExecutionType.BATCH){
				ps = nativeConn.prepareStatement(insertQueryBatch);
			} else if (queryExecType == ExecutionType.SINGLE){
				ps = nativeConn.prepareStatement(insertQuerySingle);
			}

		} catch (SQLException e2) {
			logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_VERBOSE_DATA, e2.getMessage());
			return EReturnStatus.FAILURE;
		}

		/** 5.a. Truncate the target table if opted */
		if (truncateTable && !uc.isTuncateRequestCompleted()) {
			// This operation cannot be rolled back
			try {
				stmt.executeQuery(truncateQuery);
				uc.setTruncateRequestCompleted(true);
				setSnowflakeUserContext(dataSession, uc);
			} catch (SQLException e) {
				logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_VERBOSE_DATA,
						"Could not truncate table " + tabName + " " + e.getMessage());
			}
		}

		/** 5.b. For each row to be written, build and / or execute queries */
		insertQueryBulk = insertQueryBase;
		boolean firstBulkRun = true;
		for (int row = 0; row < rowsToWrite; row++) {

			boolean reject = false;

			valueList = "(";

			for (int fieldIndex = 0; fieldIndex < connectedFields.size(); fieldIndex++) {

				BasicProjectionField field = connectedFields.get(fieldIndex).field;

				DataAttributes pDataAttributes = new DataAttributes();
				pDataAttributes.setRowIndex(row);
				pDataAttributes.setColumnIndex(connectedFields.get(fieldIndex).index);
				pDataAttributes.setDataSetId(0); // currently 0

				if (queryExecType == ExecutionType.BULK) {
					valueList += getDataValueFromPlatform(dataSession, pDataAttributes, field) + ","; 
				}

				switch (pDataAttributes.getIndicator()) {
				case EIndicator.TOO_LARGE:
				case EIndicator.TRUNCATED:
					reject = true;
				}

				if (reject) {
					break;
				}

				if (queryExecType == ExecutionType.SINGLE || queryExecType == ExecutionType.BATCH) {
					try {
						setDataValueToNativeSink(dataSession, pDataAttributes, field, ps, fieldIndex + 1);
					} catch (SQLException e) {
						logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_VERBOSE_DATA,
								"WRITE-insert: Could not set values in PreparedStatement for row-" + row + " column-"
										+ (fieldIndex + 1) + " " + e.getMessage());
					}
				}
			}

			if (reject) { // Skip row query formation
				continue;
			}

			if (queryExecType == ExecutionType.SINGLE) {

				logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_VERBOSE_DATA, "WRITE: " + insertQuerySingle);

				/** 5.b.1.ii. Else Execute the insert query */
				try { 
					rowsStatInfo.incrementRequested(1);
					
				    ps.executeUpdate();

				    rowsStatInfo.incrementAffected(1);
				    rowsStatInfo.incrementApplied(1); 
				} catch (SQLException e) {
					rowsStatInfo.incrementRejected(1);
				  
					logger.logMessage(EMessageLevel.MSG_FATAL_ERROR,
							  				ELogLevel.TRACE_VERBOSE_DATA, "Rejected: " +
							  							rowsStatInfo.getRejectedRows());
				  
					errorRowInfo.add(new ErrorRowInfo(0, row,
							  		Integer.toString(e.getErrorCode()), e.getMessage()));
				  
					//Per design, no rollback done in this case.
				  
				  continue; 
				 }

			} else if(queryExecType == ExecutionType.BATCH) {
				try {
					ps.addBatch();
					batchCount++;

					if (batchCount % BATCH_SIZE == 0) {
						rowsStatInfo.incrementRequested(BATCH_SIZE);
						
						ps.executeBatch();
						
						rowsStatInfo.incrementAffected(BATCH_SIZE);
						rowsStatInfo.incrementApplied(BATCH_SIZE);

						ps.clearBatch();
						batchCount = 0;
					} // end batch count check

				} catch (SQLException e) {
					rowsStatInfo.incrementRejected(BATCH_SIZE);
					logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_VERBOSE_DATA,
							"Batch Execution failed: " + rowsStatInfo.getRejectedRows());

					errorRowInfo.add(new ErrorRowInfo(0, row, Integer.toString(e.getErrorCode()), e.getMessage()));

					// Batch update failed. So, rollback txn
					// ROLLBACK TRANSACTION
					try {
						nativeConn.rollback();
						txnRolledBack = true;
					} catch (SQLException e1) {
						logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE,
								"Transaction Rollback Failed: " + e1.getErrorCode() + ": " + e1.getMessage());
					}

					break; // Do not process the rest of the rows
				} // end catch

			} // end batch insert
			else if (queryExecType == ExecutionType.BULK) {// Preparing the bulk query
				valueList = valueList.substring(0, valueList.lastIndexOf(",")) + ") ";
				if (firstBulkRun) {
					insertQueryBulk += " values " + valueList; 
					firstBulkRun = false;
				} else {
					insertQueryBulk += ", " + valueList;
				}

				continue;

			} 
		} // end row

		/** 5.c.1. Execute the bulk query */
		if (queryExecType == ExecutionType.BULK) {
			try {
				rowsStatInfo.incrementRequested(rowsToWrite);

				stmt.executeUpdate(insertQueryBulk);

				rowsStatInfo.incrementAffected(rowsToWrite);
				rowsStatInfo.incrementApplied(rowsToWrite);
			} catch (SQLException e) {
				rowsStatInfo.incrementRejected(rowsToWrite);
				logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE,
						"Bulk load failed: " + e.getErrorCode() + ": " + e.getMessage());

				/** 5.c.2. If unsuccessful, ROLLBACK the transaction **/
				// ROLLBACK TRANSACTION
				try {
					nativeConn.rollback();
					txnRolledBack = true;
				} catch (SQLException e1) {
					logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE,
							"Transaction Rollback Failed: " + e.getErrorCode() + ": " + e.getMessage());
				}

				return EReturnStatus.FAILURE;
			}
		} // end bulk load
		else {
			// Finish up the remaining inserts in the batch and end the
			// transaction
			/**
			 * 5.d.1. If the batch contains more rows to be executed, execute
			 * the batch and clear it
			 */
			if (batchCount > 0) {
				try {
					rowsStatInfo.incrementRequested(batchCount);
					ps.executeBatch();
					rowsStatInfo.incrementAffected(batchCount);
					rowsStatInfo.incrementApplied(batchCount);

					ps.clearBatch();
					batchCount = 0;

				} catch (SQLException e) {
					rowsStatInfo.incrementRejected(batchCount);
					logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_VERBOSE_DATA,
							"Batch Execution failed: " + rowsStatInfo.getRejectedRows());

					errorRowInfo
							.add(new ErrorRowInfo(0, batchCount, Integer.toString(e.getErrorCode()), e.getMessage()));

					// Batch update failed. So, rollback txn
					// ROLLBACK TRANSACTION
					try {
						nativeConn.rollback();
						txnRolledBack = true;
					} catch (SQLException e1) {
						logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE,
								"Transaction Rollback Failed: " + e.getErrorCode() + ": " + e.getMessage());
					}
				} // end catch

			} // end batchCount > 0
		}

		// Finally, free up the DB resources and end the transaction
		try {
			/** 5.e. Free up the DB resources as needed */
			if (null != stmt) {
				stmt.close();
			}
			if (null != ps) {
				ps.close();
			}

			// COMMIT TRANSACTION
			/**
			 * 5.f. If there were no ROLLBACK in previous steps, COMMIT the
			 * transaction
			 */
			if (!txnRolledBack) {
				nativeConn.commit();
			}

			/** 6. End Transaction on the native connection */
			nativeConn.setAutoCommit(true); // END TRANSACTION

		} catch (SQLException e) {
			logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE,
					"Closing statement failed: " + e.getErrorCode() + ": " + e.getMessage());
		}

		if (errorRowInfo.size() > 0) {
			runtimeMetadataHandle.setErrorInputRowInfo(errorRowInfo);
		}

		return EReturnStatus.SUCCESS;
	}

	/**
	 * This method returns <code>null</code> if
	 * <code>this.connectedFields</code> is <code>null</code> or empty.
	 * 
	 * @return Returns comma separated list of columns from the target table.
	 */
	private String getTargetColumnList() {
		String colList = "";
		if (null == connectedFields || connectedFields.size() == 0) {
			return null;
		}

		for (int fieldIndex = 0; fieldIndex < connectedFields.size(); fieldIndex++) {
			BasicProjectionField field = connectedFields.get(fieldIndex).field;
			colList += field.getName() + ", ";
		}
		colList = colList.substring(0, colList.lastIndexOf(","));

		return colList;
	}
	
	/**
	 * Checks if the list of columns has any of the Semi-Structured Data Types
	 * viz., Object, Array, Variant
	 * Determines the appropriate <code>ExecutionType</code> based on the <code>isBulk</code> boolean
	 * 
	 * @param isBulk - indicates if Bulk Write option has been chosen by user
	 * @return ExecutionType
	 * @throws SnowflakeV2OperationNotSupportedException 
	 */
	private ExecutionType getQueryExecType(boolean isBulk) throws SnowflakeV2OperationNotSupportedException {
		String nativeType = "";
		boolean hasSemiStructure = false;
		boolean hasDateTime = false;
		ExecutionType typeToReturn = ExecutionType.BATCH;
		
		for (int fieldIndex = 0; fieldIndex < connectedFields.size(); fieldIndex++) {
			BasicProjectionField field = connectedFields.get(fieldIndex).field;
			nativeType = field.getNativeFieldRef().getDataType();
			
			if (!hasSemiStructure && ("OBJECT".equalsIgnoreCase(nativeType) ||
					"ARRAY".equalsIgnoreCase(nativeType) ||
						"VARIANT".equalsIgnoreCase(nativeType))) {
				
				hasSemiStructure = true;
				
			}
			if (!hasDateTime && (nativeType.startsWith("TIME") ||
					nativeType.startsWith("DATE"))) {
				hasDateTime = true;
			}
		}
		
		if (isBulk) {
			if (hasSemiStructure) {
				//User has opted Bulk Write, but the target table has field(s) of 
				//Semi-Structured data type. Cannot perform requested operation. 
				//So, throw SDKException 
				
				typeToReturn = ExecutionType.NOP;
				
				logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_VERBOSE_DATA,
						"Could not perform Bulk Write operation on target table " +
							" becuase one of the columns is of type Object, Array or Variant" );
				
				throw new SnowflakeV2OperationNotSupportedException("Could not perform " +
						"Bulk Write operation on target table "+
						" becuase one of the columns is of type Object, Array or Variant");
			} else if (hasDateTime) {
				typeToReturn = ExecutionType.BATCH; //Raw SQL is built in the case of Bulk, 
													//which messes up the Timezone info. 
													//so, use PreparedStatement only
			}
			else {
				//The target table does not have any field of Semi-Structured data type.
				//So, the requested Bulk write operation can be performed.
				typeToReturn = ExecutionType.BULK;
			}
		} else {
			if (hasSemiStructure) {
				//Can only execute each write query one-by-one.
				typeToReturn = ExecutionType.SINGLE;
			} else {
				//For better performance, execute the queries in batches
				typeToReturn = ExecutionType.BATCH;
			}
		}

		return typeToReturn;
	}
	
	/**
	 * Builds the Insert SQL incorporating the appropriate native functions 
	 * to handle the Semi-structured data types
	 * 
	 * @param tableName - name of the Table to insert into
	 * @return - Insert SQL string ready to be used in a <code>PreparedStatement</code>
	 */
	private String getSingleInsertQuery(String tableName) {
		String insertSQL = "SELECT ";
		
		String nativeType = "";
		for (int fieldIndex = 0; fieldIndex < connectedFields.size(); fieldIndex++) {
			BasicProjectionField field = connectedFields.get(fieldIndex).field;
			nativeType = field.getNativeFieldRef().getDataType();
			
			insertSQL += getQueryFieldPlaceHolder(field) + ", ";
			
			/*switch (nativeType) {
				case "OBJECT":
					insertSQL += "TO_OBJECT(PARSE_JSON(?)), ";
					break;
					
				case "ARRAY":
					insertSQL += "TO_ARRAY(?), ";
					break;
					
				case "VARIANT":
					insertSQL += "TO_VARIANT(?), ";
					break;

				default:
					insertSQL += "?, ";
			}*/
			
		}
		
		insertSQL = insertSQL.substring(0, insertSQL.lastIndexOf(","));

		return insertSQL;
	}

	
	private String getQueryFieldPlaceHolder(BasicProjectionField field) {
		String nativeType = field.getNativeFieldRef().getDataType();
		String placeHolder = "?";
		switch (nativeType) {
			case "OBJECT":
				placeHolder = "TO_OBJECT(PARSE_JSON(?))";
				break;
				
			case "ARRAY":
				placeHolder = "TO_ARRAY(?)";
				break;
				
			case "VARIANT":
				placeHolder = "TO_VARIANT(?)";
				break;

			default:
				placeHolder = "?";
		}
		
		return placeHolder;
		
	}
	/**
	 * 
	 * Method to delete records
	 * 
	 * @param dataSession
	 * @param writeAttr
	 * @return
	 * @throws SDKException
	 */
	private int writeDelete(DataSession dataSession, WriteAttributes writeAttr) throws SDKException {

		PreparedStatement pstmt = null;
		boolean txnRolledBack = false;

		int rowsToWrite = writeAttr.getNumRowsToWrite();
		List<ErrorRowInfo> errorRowInfo = new ArrayList<ErrorRowInfo>();
		List<Field> pkFields = new ArrayList<>();

		SnowflakeV2TableDataConnection conn = (SnowflakeV2TableDataConnection) dataSession.getConnection();
		Connection nativeConn = (Connection) conn.getNativeConnection();

		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_VERBOSE_DATA, "DELETE: Got the connection handle");

		FlatRecord frToDeleteFrom = (FlatRecord) projectionView.getNativeRecords().get(0);
		String tabName = buildTabName(frToDeleteFrom.getName());
		String query = "DELETE FROM " + tabName + " WHERE ";

		// Get runtime config metadata handle
		RuntimeConfigMetadata runtimeMetadataHandle = (RuntimeConfigMetadata) dataSession
				.getMetadataHandle(EmetadataHandleTypes.runtimeConfigMetadata);
		if (runtimeMetadataHandle == null) {
			logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE, "Error : Runtime Handle is NULL");
			return EReturnStatus.FAILURE;
		}
		// Get rows statistics info to update row statistics etc.
		RowsStatInfo rowsStatInfo = runtimeMetadataHandle.getRowsStatInfo(EIUDIndicator.DELETE);

		
		// Get the list of Primary Key Column Names 
		PrimaryKey primKey = frToDeleteFrom.getPrimaryKey();
		if (null != primKey) {
			pkFields = primKey.getFieldList();

		} else {
			logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE, 
					"Cannot DELETE from table " + tabName + ". No Primary Keys available");

			throw new SnowflakeV2OperationNotSupportedException("Cannot DELETE from table " + 
					tabName + ". No Primary Keys available");
		}

		List<String> pkColumnNames = new ArrayList<>();
		for (Field fd : pkFields) {
			pkColumnNames.add(fd.getName());
			query += fd.getName() + " = ? AND ";
		}
		query = query.substring(0, query.lastIndexOf(" AND"));
		
		try {
			nativeConn.setAutoCommit(false); //BEGIN TRANSACTION
			
			pstmt = nativeConn.prepareStatement(query);
			
		} catch (SQLException e2) {
			logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_VERBOSE_DATA, e2.getMessage());
			return EReturnStatus.FAILURE;
		}

		// Build and execute the DELETE query for each row
		for (int row = 0; row < rowsToWrite; row++) {

			boolean reject = false;
			int pkMapped = 0;

			for (int fieldIndex = 0; fieldIndex < connectedFields.size(); fieldIndex++) {

				BasicProjectionField field = connectedFields.get(fieldIndex).field;
				
				if (!pkColumnNames.contains(field.getName())) {
					continue;
				}

				DataAttributes pDataAttributes = new DataAttributes();
				pDataAttributes.setRowIndex(row);
				pDataAttributes.setColumnIndex(connectedFields.get(fieldIndex).index);
				pDataAttributes.setDataSetId(0); // currently 0

				try {
					pkMapped++;
					setDataValueToNativeSink(dataSession, pDataAttributes, field, pstmt, pkMapped);
				} catch (Exception e) {
					logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_VERBOSE_DATA, e.getMessage());
				}

				switch (pDataAttributes.getIndicator()) {
				case EIndicator.TOO_LARGE:
				case EIndicator.TRUNCATED:
					reject = true;
				}

				if (reject) {
					break;
				}

			} //end columns loop
			
			if (pkMapped == 0) {
				reject = true;
			}
			
			if (reject) { // Skip row query formation
				rowsStatInfo.incrementRejected(1);
				continue;
			}

			logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_VERBOSE_DATA, "DELETE: " + query);

			try {
				rowsStatInfo.incrementRequested(1);
				
				pstmt.executeUpdate();
				
				rowsStatInfo.incrementAffected(1);
				rowsStatInfo.incrementApplied(1);
			} catch (SQLException e) {
				rowsStatInfo.incrementRejected(1);
				logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_VERBOSE_DATA,
						"Rejected: " + rowsStatInfo.getRejectedRows());
				
				errorRowInfo.add(new ErrorRowInfo(0, row, Integer.toString(e.getErrorCode()), e.getMessage()));
				continue;
			}
		} //end rows loop
		
		
		try {
			if (null != pstmt) {
				pstmt.close();
			}
			
			if (!txnRolledBack) {
				nativeConn.commit(); // COMMIT
			}
			
			nativeConn.setAutoCommit(true); //END TRANSACTION
			
		} catch (Exception e) {
			logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_VERBOSE_DATA,
					"Transaction failed ");
		}

		if (errorRowInfo.size() > 0) {
			runtimeMetadataHandle.setErrorInputRowInfo(errorRowInfo);
		}

		return EReturnStatus.SUCCESS;
	}

	
	/**
	 * 
	 * Method to update records
	 * 
	 * @param dataSession
	 * @param writeAttr
	 * @return
	 * @throws SDKException
	 */
	private int writeUpdate(DataSession dataSession, WriteAttributes writeAttr) throws SDKException {

		PreparedStatement pstmt = null;
		boolean txnRolledBack = false;

		int rowsToWrite = writeAttr.getNumRowsToWrite();
		List<ErrorRowInfo> errorRowInfo = new ArrayList<ErrorRowInfo>();
		List<Field> pkFields = new ArrayList<>();

		SnowflakeV2TableDataConnection conn = (SnowflakeV2TableDataConnection) dataSession.getConnection();
		Connection nativeConn = (Connection) conn.getNativeConnection();

		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_VERBOSE_DATA, "DELETE: Got the connection handle");

		FlatRecord frToUpdate = (FlatRecord) projectionView.getNativeRecords().get(0);
		String tabName = buildTabName(frToUpdate.getName());

		// Get runtime config metadata handle
		RuntimeConfigMetadata runtimeMetadataHandle = (RuntimeConfigMetadata) dataSession
				.getMetadataHandle(EmetadataHandleTypes.runtimeConfigMetadata);
		if (runtimeMetadataHandle == null) {
			logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE, "Error : Runtime Handle is NULL");
			return EReturnStatus.FAILURE;
		}
		// Get rows statistics info to update row statistics etc.
		RowsStatInfo rowsStatInfo = runtimeMetadataHandle.getRowsStatInfo(EIUDIndicator.DELETE);

		
		// Get the list of Primary Key Column Names 
		PrimaryKey primKey = frToUpdate.getPrimaryKey();
		if (null != primKey) {
			pkFields = primKey.getFieldList();

		} else {
			logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE, 
					"Cannot UPDATE table " + tabName + ". No Primary Keys available" );
			
			throw new SnowflakeV2OperationNotSupportedException("Cannot UPDATE table " + 
					tabName + ". No Primary Keys available");
		}

		List<String> pkColumnNames = new ArrayList<>();
		String query = "UPDATE " + tabName ;
		String setClause = " SET ";
		String whereClause = " WHERE ";
		
		//Begin Query Construction  -- DO NOT CHANGE THE ORDER
		for (Field fd : pkFields) {
			pkColumnNames.add(fd.getName());
		}

		Map<String, Integer> fieldPositionMap = new HashMap<>(); 
		int pos = 1;
		for (int fieldIndex = 0; fieldIndex < connectedFields.size(); fieldIndex++) {
			BasicProjectionField field = connectedFields.get(fieldIndex).field;
						
			if (!pkColumnNames.contains(field.getName())) {
				setClause += field.getName() + " = " + getQueryFieldPlaceHolder(field) + ", ";
				fieldPositionMap.put(field.getName(), pos);
				pos++;
			}
		}
		setClause = setClause.substring(0, setClause.lastIndexOf(","));

		for (int fieldIndex = 0; fieldIndex < connectedFields.size(); fieldIndex++) {
			BasicProjectionField field = connectedFields.get(fieldIndex).field;
						
			if (pkColumnNames.contains(field.getName())) {
				whereClause += field.getName() + " = " + getQueryFieldPlaceHolder(field) + " AND ";
				fieldPositionMap.put(field.getName(), pos);
				pos++;
			}
		}
		whereClause = whereClause.substring(0, whereClause.lastIndexOf(" AND"));
		
		query = query + setClause + whereClause;
		//End Query Construction
		
		
		try {
			nativeConn.setAutoCommit(false); //BEGIN TRANSACTION
			
			pstmt = nativeConn.prepareStatement(query);
			
		} catch (SQLException e2) {
			logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_VERBOSE_DATA, e2.getMessage());
			return EReturnStatus.FAILURE;
		}
		 
		// Build and execute the DELETE query for each row
		for (int row = 0; row < rowsToWrite; row++) {

			boolean reject = false;
			int pkMapped = 0;

			for (int fieldIndex = 0; fieldIndex < connectedFields.size(); fieldIndex++) {

				BasicProjectionField field = connectedFields.get(fieldIndex).field;
				
				/*if (!pkColumnNames.contains(field.getName())) {
					continue;
				}*/

				DataAttributes pDataAttributes = new DataAttributes();
				pDataAttributes.setRowIndex(row);
				pDataAttributes.setColumnIndex(connectedFields.get(fieldIndex).index);
				pDataAttributes.setDataSetId(0); // currently 0

				try {
					pkMapped++;
					//setUpdateDataValueToNativeSink(dataSession, pDataAttributes, field, pstmt, fieldPositionMap.get(field.getName()).intValue());
					setDataValueToNativeSink(dataSession, pDataAttributes, field, pstmt, fieldPositionMap.get(field.getName()).intValue());
				} catch (Exception e) {
					logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_VERBOSE_DATA, e.getMessage());
				}

				switch (pDataAttributes.getIndicator()) {
				case EIndicator.TOO_LARGE:
				case EIndicator.TRUNCATED:
					reject = true;
				}

				if (reject) {
					break;
				}

			} //end columns loop
			
			if (pkMapped == 0) {
				reject = true;
			}
			
			if (reject) { // Skip row query formation
				rowsStatInfo.incrementRejected(1);
				continue;
			}

			logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_VERBOSE_DATA, "DELETE: " + query);

			try {
				rowsStatInfo.incrementRequested(1);
				
				pstmt.executeUpdate();
				
				rowsStatInfo.incrementAffected(1);
				rowsStatInfo.incrementApplied(1);
			} catch (SQLException e) {
				rowsStatInfo.incrementRejected(1);
				logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_VERBOSE_DATA,
						"Rejected: " + rowsStatInfo.getRejectedRows());
				
				errorRowInfo.add(new ErrorRowInfo(0, row, Integer.toString(e.getErrorCode()), e.getMessage()));
				continue;
			}
		} //end rows loop
		
		
		try {
			if (null != pstmt) {
				pstmt.close();
			}
			
			if (!txnRolledBack) {
				nativeConn.commit(); // COMMIT
			}
			
			nativeConn.setAutoCommit(true); //END TRANSACTION
			
		} catch (Exception e) {
			logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_VERBOSE_DATA,
					"Transaction failed");
		}

		if (errorRowInfo.size() > 0) {
			runtimeMetadataHandle.setErrorInputRowInfo(errorRowInfo);
		}

		return EReturnStatus.SUCCESS;
	}
	
	/**
	 * 
	 * @param dataSession
	 * @param writeAttr
	 * @return
	 * @throws SDKException
	 */

	// Currently not used. Will revisit method when INFA enables support for UPSERT operation
	private int writeUpsert(DataSession dataSession, WriteAttributes writeAttr) throws SDKException {

		Statement stmt = null;

		int rowsToWrite = writeAttr.getNumRowsToWrite();

		SnowflakeV2TableDataConnection conn = (SnowflakeV2TableDataConnection) dataSession.getConnection();
		Connection nativeConn = (Connection) conn.getNativeConnection();

		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_VERBOSE_DATA, "UPDATE: Got the connection handle");

		FlatRecord frToUpdate = (FlatRecord) projectionView.getNativeRecords().get(0);

		String tabName = buildTabName(frToUpdate.getName());

		List<ErrorRowInfo> errorRowInfo = new ArrayList<ErrorRowInfo>();

		try {
			stmt = nativeConn.createStatement();
		} catch (SQLException e2) {
			logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_VERBOSE_DATA, e2.getMessage());
		}

		// Get runtime config metadata handle
		RuntimeConfigMetadata runtimeMd = (RuntimeConfigMetadata) dataSession
				.getMetadataHandle(EmetadataHandleTypes.runtimeConfigMetadata);

		// Fetching partition specific attributes
		String writerPartID = null;
		RuntimeConfigMetadata runtimeMetadataHandle = (RuntimeConfigMetadata) dataSession
				.getMetadataHandle(EmetadataHandleTypes.runtimeConfigMetadata);

		if (runtimeMetadataHandle == null) {
			logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE, "Error : Runtime Handle is NULL");
			return EReturnStatus.FAILURE;
		}
		ASOOperation m_asoOperation;
		m_asoOperation = runtimeMetadataHandle.getAdapterDataSourceOperation();
		WriteCapabilityAttributes currPartInfo = m_asoOperation.getWriteCapabilityAttributes();

		// Get rows statistics info to update row statistics etc.
		RowsStatInfo rowsStatInfo = runtimeMd.getRowsStatInfo(EIUDIndicator.DELETE);

		// Get the list of Primary Key Column Names
		List<Field> pkFields = new ArrayList<>();
		PrimaryKey primKey = frToUpdate.getPrimaryKey();
		if (null != primKey) {
			pkFields = primKey.getFieldList();
		} else {
			logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE, 
					"Cannot UPSERT table " + tabName + ". No Primary Keys available" );
			
			throw new SnowflakeV2OperationNotSupportedException("Cannot UPSERT table " + 
					tabName + ". No Primary Keys available");
		}

		List<String> pkColumnNames = new ArrayList<>();
		for (Field fd : pkFields) {
			pkColumnNames.add(fd.getName());
		}

		// Build and execute the UPDATE(UPSERT) query for each row
		for (int row = 0; row < rowsToWrite; row++) {

			boolean reject = false;

			String query = "update " + tabName;
			String whereCondition = "";
			String dataValue = "";

			String colList = "(";
			String valueList = "(";
			String queryForInsert = "insert into " + tabName + "";

			List<String> conditionList = new ArrayList<>();

			// Build the conditions to be included in the "WHERE" clause for
			// this row based on
			// the primary keys

			boolean firstCondition = true;
			boolean buildSet = false;
			boolean firstSet = true;
			String setClause = " SET ";

			for (int fieldIndex = 0; fieldIndex < connectedFields.size(); fieldIndex++) {

				BasicProjectionField field = connectedFields.get(fieldIndex).field;

				buildSet = false;
				if (pkColumnNames.contains(field.getName())) {
					if (firstCondition) {
						whereCondition = whereCondition + " " + field.getName() + " = ";
						firstCondition = false;
					} else {
						whereCondition = whereCondition + " AND " + field.getName() + " = ";
					}
				} else {
					// If the field is not part of the Primary Key, include it
					// in the SET clause
					buildSet = true;
					if (firstSet) {
						setClause = setClause + field.getName() + " = ";
						firstSet = false;
					} else {
						setClause = setClause + ", " + field.getName() + " = ";
					}
				}

				DataAttributes pDataAttributes = new DataAttributes();
				pDataAttributes.setRowIndex(row);
				pDataAttributes.setColumnIndex(connectedFields.get(fieldIndex).index);
				pDataAttributes.setDataSetId(0); // currently 0

				dataValue = getDataValueFromPlatform(dataSession, pDataAttributes, field);
				valueList += dataValue + ",";

				switch (pDataAttributes.getIndicator()) {
				case EIndicator.TOO_LARGE:
				case EIndicator.TRUNCATED:
					reject = true;
				}

				if (buildSet) {
					setClause = setClause + dataValue;
				} else {
					if (null == dataValue || "".equalsIgnoreCase(dataValue.trim())) {
						reject = true; // Reject record if value for a PK column is NULL
					} else {
						whereCondition = whereCondition + dataValue;
					}
				}

				if (reject) {
					break;
				}
				colList += field.getName() + ",";

			}
			colList = colList.substring(0, colList.lastIndexOf(",")) + ") ";
			valueList = valueList.substring(0, valueList.lastIndexOf(",")) + ") ";

			queryForInsert += colList + " values " + valueList;

			logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_VERBOSE_DATA, "WRITE: " + queryForInsert);

			if (!"".equalsIgnoreCase(whereCondition)) {
				query = query + setClause + " where " + whereCondition;
			} else {
				// This case could happen when the Primary Key information
				// cannot be found (or not available)
				// for the target table
				// Executing an UPDATE statement without WHERE clause will
				// update all the records in the table
				// We need to avoid this.
				reject = true;
			}

			if (reject) { // Skip row query formation
				rowsStatInfo.incrementRejected(1);
				continue;
			}

			logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_VERBOSE_DATA, "UPDATE(UPSERT): " + query);

			// IMPORTANT NOTE: SNOWFLAKE DOES NOT SUPPORT addBatch() on Statement

			try {
				rowsStatInfo.incrementRequested(1);

				int updtCount = stmt.executeUpdate(query); // update

				if (updtCount == 0) {
					stmt.executeUpdate(queryForInsert); // insert
				}

				rowsStatInfo.incrementAffected(1);
				rowsStatInfo.incrementApplied(1);
			} catch (SQLException e) {

				rowsStatInfo.incrementRejected(1);
				logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_VERBOSE_DATA,
						"Rejected: " + rowsStatInfo.getRejectedRows());

				errorRowInfo.add(new ErrorRowInfo(0, row, Integer.toString(e.getErrorCode()), e.getMessage()));

				continue;
			}
		}

		if (errorRowInfo.size() > 0) {
			runtimeMetadataHandle.setErrorInputRowInfo(errorRowInfo);
		}

		return EReturnStatus.SUCCESS;
	}

	/**
	 * Retrieves the data value for a particular field for a particular row from
	 * the INFA Cloud
	 * 
	 * @param dataSession
	 * @param pDataAttributes
	 * @param field
	 * @return
	 * @throws SDKException
	 */
	private String getDataValueFromPlatform(DataSession dataSession, DataAttributes pDataAttributes,
			BasicProjectionField field) throws SDKException {

		String dataValue = "";

		switch (field.getDataType().toLowerCase()) {
		case "string":
		case "text":
			String nativeType = field.getNativeFieldRef().getDataType();
			
			switch (nativeType) {
			case "BIT":
				if (dataSession.getStringData(pDataAttributes).equalsIgnoreCase("true")) {
					dataValue += "1";
				} else {
					dataValue += "0";
				}				
				break;
			case "BOOLEAN":
				dataValue = dataSession.getStringData(pDataAttributes);
				if ("t".equalsIgnoreCase(dataValue) || "true".equalsIgnoreCase(dataValue)
						|| "yes".equalsIgnoreCase(dataValue) || "y".equalsIgnoreCase(dataValue)
						|| "on".equalsIgnoreCase(dataValue) || "1".equalsIgnoreCase(dataValue)) {
					dataValue = "true";
				} else {
					dataValue = "false";
				}
				break;
			case "OBJECT":
				dataValue += "TO_OBJECT(PARSE_JSON(\'" + dataSession.getStringData(pDataAttributes) + "\'))";
				break;
			case "ARRAY":
				dataValue += "TO_ARRAY(\'" + dataSession.getStringData(pDataAttributes) + "\')";
				break;
			case "VARIANT":
				dataValue += "TO_VARIANT(\'" + dataSession.getStringData(pDataAttributes) + "\')";
				break;
				
			default:
				dataValue += "\'" + dataSession.getStringData(pDataAttributes) + "\'";
				break;
			}
			break;
			
		case "integer":
			dataValue += dataSession.getIntData(pDataAttributes) + "";
			break;
		case "bigint":
			dataValue += dataSession.getLongData(pDataAttributes) + "";
			break;
		case "double":
			dataValue += dataSession.getDoubleData(pDataAttributes);
			break;
		case "date/time":
			dataValue += "\'" + dataSession.getDateTimeData(pDataAttributes) + "\'";
			break;
		case "decimal":
			dataValue += dataSession.getBigDecimalData(pDataAttributes);
			break;
		case "binary":
			dataValue += "\'" + dataSession.getBinaryData(pDataAttributes) + "\'";
			break;

		}

		return dataValue;

	}

	/**
	 * Sets value into the PreparedStatement for a specified column index
	 * 
	 * @param dataSession
	 * @param pDataAttributes
	 * @param field
	 * @param pstmt
	 * @param index
	 * @throws SDKException
	 * @throws SQLException
	 */
	private void setDataValueToNativeSink(DataSession dataSession, DataAttributes pDataAttributes,
			BasicProjectionField field, PreparedStatement pstmt, int index) throws SDKException, SQLException {

		String strDataValue = "";
		int intDataValue = 0;
		long longDataValue = 0L;
		double doubleDataValue = 0;
		
		String nativeType = field.getNativeFieldRef().getDataType();
		
		switch (field.getDataType().toLowerCase()) {

		case "string":
			strDataValue = dataSession.getStringData(pDataAttributes);

			switch (nativeType) {
			case "BOOLEAN":
				boolean boolValue = false;
				if (pDataAttributes.getIndicator() == EIndicator.NULL) {
					pstmt.setNull(index, Types.BOOLEAN);
				} else {
					if ("t".equalsIgnoreCase(strDataValue) || "true".equalsIgnoreCase(strDataValue)
							|| "yes".equalsIgnoreCase(strDataValue) || "y".equalsIgnoreCase(strDataValue)
							|| "on".equalsIgnoreCase(strDataValue) || "1".equalsIgnoreCase(strDataValue)) {
						boolValue = true;
					} else {
						boolValue = false;
					}
	
					pstmt.setBoolean(index, boolValue);
					pDataAttributes.setIndicator((short) 0);
				}
				break;
			
			/** Supply the data as String for OBJECT, ARRAY and VARIANT types. 
			 * The native functions in the query take String parameters*/
			case "OBJECT":
			case "ARRAY":
			case "VARIANT":
				if (pDataAttributes.getIndicator() == EIndicator.NULL) {
					pstmt.setString(index, null);
				} else {
					pstmt.setString(index, "\'" + strDataValue + "\'");
				}
				break;
			default:
				if (pDataAttributes.getIndicator() == EIndicator.NULL) {
					pstmt.setString(index, null);
				} else {
					pstmt.setString(index, strDataValue);
				}
				break;
			}
			break;
			
		case "integer":
			intDataValue = dataSession.getIntData(pDataAttributes);
			if (pDataAttributes.getIndicator() == EIndicator.NULL) {
				pstmt.setNull(index, Types.INTEGER);
			} else {
				pstmt.setInt(index, intDataValue);
			}
			break;
		
		case "bigint":
			longDataValue = dataSession.getLongData(pDataAttributes);
			if (pDataAttributes.getIndicator() == EIndicator.NULL) {
				pstmt.setNull(index, Types.BIGINT);
			} else {
				pstmt.setLong(index, longDataValue);
			}
			break;
		
		case "double":
			doubleDataValue = dataSession.getDoubleData(pDataAttributes);
			if (pDataAttributes.getIndicator() == EIndicator.NULL) {
				pstmt.setNull(index, Types.DOUBLE);
			} else {
				pstmt.setDouble(index, doubleDataValue);
			}
			break;
		
		case "date/time":
			Timestamp dateTime = dataSession.getDateTimeData(pDataAttributes);
			if (pDataAttributes.getIndicator() == EIndicator.NULL) {
				//pstmt.setTimestamp(index, null);
				pstmt.setNull(index, Types.TIMESTAMP);
			} else {
				if (nativeType.indexOf("NTZ") > 0) {
					Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
					cal.setTimeInMillis(dateTime.getTime());
					TimeZone tz = cal.getTimeZone();
					String zoneID = tz.getID();
	
					pstmt.setTimestamp(index, dataSession.getDateTimeData(pDataAttributes), cal);
				} else if (nativeType.indexOf("LTZ") > 0) {
					pstmt.setTimestamp(index, dataSession.getDateTimeData(pDataAttributes));
				} else {
					//Could be TZ or Date or Time
					pstmt.setTimestamp(index, dataSession.getDateTimeData(pDataAttributes));
					
					//Time t = new java.sql.Time(dataSession.getDateTimeData(pDataAttributes).getTime());
					//pstmt.setTime(..);
				}
			}
			break;

		case "decimal":
			BigDecimal bdValue = dataSession.getBigDecimalData(pDataAttributes);
			if (pDataAttributes.getIndicator() == EIndicator.NULL) {
				pstmt.setBigDecimal(index, null);
			} else {
				pstmt.setBigDecimal(index, bdValue);
			}
			break;
			
		default:
			strDataValue = dataSession.getStringData(pDataAttributes);
			if (pDataAttributes.getIndicator() == EIndicator.NULL) {
				pstmt.setString(index, null);
			} else {
				pstmt.setString(index, strDataValue);
			}

			break;
		}

	}

	/**
	 * Sets value into the PreparedStatement for a specified column index
	 * 
	 * @param dataSession
	 * @param pDataAttributes
	 * @param field
	 * @param pstmt
	 * @param index
	 * @throws SDKException
	 * @throws SQLException
	 */
	//Unused.
	private void setUpdateDataValueToNativeSink(DataSession dataSession, DataAttributes pDataAttributes,
			BasicProjectionField field, PreparedStatement pstmt, int index) throws SDKException, SQLException {

		String strDataValue = "";
		int intDataValue = 0;
		long longDataValue = 0L;
		double doubleDataValue = 0;
		String nativeType = field.getNativeFieldRef().getDataType();
		
		switch (field.getDataType().toLowerCase()) {

		case "string":
			strDataValue = dataSession.getStringData(pDataAttributes);
			switch (nativeType) {
			case "BOOLEAN":
				boolean boolValue = false;
				if (pDataAttributes.getIndicator() == EIndicator.NULL) {
					pstmt.setNull(index, Types.BOOLEAN);
				} else {
					if ("t".equalsIgnoreCase(strDataValue) || "true".equalsIgnoreCase(strDataValue)
							|| "yes".equalsIgnoreCase(strDataValue) || "y".equalsIgnoreCase(strDataValue)
							|| "on".equalsIgnoreCase(strDataValue) || "1".equalsIgnoreCase(strDataValue)) {
						boolValue = true;
					} else {
						boolValue = false;
					}
	
					pstmt.setBoolean(index, boolValue);
					pDataAttributes.setIndicator((short) 0);
				}
				break;
			
			/** Supply the data as String for OBJECT, ARRAY and VARIANT types. 
			 * The native functions in the query take String parameters*/
			case "OBJECT":
				String strValue = "";
				if (pDataAttributes.getIndicator() == EIndicator.NULL) {
					pstmt.setString(index, "TO_OBJECT(PARSE_JSON(\'\'))");
				} else {
					String strToObj = "TO_OBJECT(PARSE_JSON(\'" + dataSession.getStringData(pDataAttributes) + "\'))";
					pstmt.setString(index, strToObj);
				}
				break;
			case "ARRAY":
				if (pDataAttributes.getIndicator() == EIndicator.NULL) {
					pstmt.setString(index, "TO_ARRAY(\'\')");
				} else {
					pstmt.setString(index, "TO_ARRAY(\'" + dataSession.getStringData(pDataAttributes) + "\')");
				}
				break;
			case "VARIANT":
				if (pDataAttributes.getIndicator() == EIndicator.NULL) {
					pstmt.setString(index, "TO_VARIANT(\'\')");
				} else {
					pstmt.setString(index, "TO_VARIANT(\'" + dataSession.getStringData(pDataAttributes) + "\')");
				}
				break;
			default:
				if (pDataAttributes.getIndicator() == EIndicator.NULL) {
					pstmt.setString(index, null);
				} else {
					pstmt.setString(index, strDataValue);
				}
				break;
			}
			break;
			
		case "integer":
			intDataValue = dataSession.getIntData(pDataAttributes);
			if (pDataAttributes.getIndicator() == EIndicator.NULL) {
				pstmt.setNull(index, Types.INTEGER);
			} else {
				pstmt.setInt(index, intDataValue);
			}
			break;
		
		case "bigint":
			longDataValue = dataSession.getLongData(pDataAttributes);
			if (pDataAttributes.getIndicator() == EIndicator.NULL) {
				pstmt.setNull(index, Types.BIGINT);
			} else {
				pstmt.setLong(index, longDataValue);
			}
			break;
		
		case "double":
			doubleDataValue = dataSession.getDoubleData(pDataAttributes);
			if (pDataAttributes.getIndicator() == EIndicator.NULL) {
				pstmt.setNull(index, Types.DOUBLE);
			} else {
				pstmt.setDouble(index, doubleDataValue);
			}
			break;
		
		case "date/time":
			Timestamp dateTime = dataSession.getDateTimeData(pDataAttributes);
			if (pDataAttributes.getIndicator() == EIndicator.NULL) {
				//pstmt.setTimestamp(index, null);
				pstmt.setNull(index, Types.TIMESTAMP);
			} else {
				if (nativeType.indexOf("NTZ") > 0) {
					Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
					cal.setTimeInMillis(dateTime.getTime());
					TimeZone tz = cal.getTimeZone();
					String zoneID = tz.getID();
	
					pstmt.setTimestamp(index, dataSession.getDateTimeData(pDataAttributes), cal);
				} else if (nativeType.indexOf("LTZ") > 0) {
					pstmt.setTimestamp(index, dataSession.getDateTimeData(pDataAttributes));
				} else {
					//Could be TZ or Date or Time
					pstmt.setTimestamp(index, dataSession.getDateTimeData(pDataAttributes));
					
					//Time t = new java.sql.Time(dataSession.getDateTimeData(pDataAttributes).getTime());
					//pstmt.setTime(..);
				}
			}
			break;

		case "decimal":
			BigDecimal bdValue = dataSession.getBigDecimalData(pDataAttributes);
			if (pDataAttributes.getIndicator() == EIndicator.NULL) {
				pstmt.setBigDecimal(index, null);
			} else {
				pstmt.setBigDecimal(index, bdValue);
			}
			break;
			
		default:
			strDataValue = dataSession.getStringData(pDataAttributes);
			if (pDataAttributes.getIndicator() == EIndicator.NULL) {
				pstmt.setString(index, null);
			} else {
				pstmt.setString(index, strDataValue);
			}

			break;
		}
	}

	/**
	 * This API should be implemented by adapter developer in conjunction with
	 * read API to implement lookup. SDK will provide updated filter condition
	 * with reset API. Adapter developer are expected to reset the adapter
	 * context in reset API.
	 * 
	 * @param dataSession
	 *            DataSession instance
	 * @return EReturnStatus
	 */

	@Override
	public int reset(DataSession dataSession) throws SDKException {

		SDKExpression expression;
		// String logicalOperator;

		filterQuery = "";

		SnowflakeV2UserContext muc = getSnowflakeUserContext(dataSession);

		muc.setResetRowIndex(true);
		muc.setTotalRows(0);

		setSnowflakeUserContext(dataSession, muc);

		if (m_FilterOperation != null) {
			if (m_FilterOperation.isNativeFilter()) {
				lookupExpr = m_FilterOperation.getFilterExpression();
				logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NONE,
						"Lookup Native Filter expression " + lookupExpr);
			} else {
				expression = m_FilterOperation.getInfaSDKExpression();
				logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NONE,
						"Lookup Filter expression " + expression.getExpressionString());

				lookupExpr = generateFilterClauseFromExpression(expression);
			}
		}

		return EReturnStatus.SUCCESS;

	}

	private String generateFilterClauseFromExpression(SDKExpression expression) {
		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL,
				"SnowflakeV2TableDataAdapter:generateFilterClauseFromExpression:: begin");

		SimpleSDKExpression simpleExpr = (SimpleSDKExpression) expression;
		List<SimpleBinaryExpression> pBinExprsList = simpleExpr.getSimpleBinaryExpressions();

		String filterExpression = "";

		for (SimpleBinaryExpression expr : pBinExprsList) {

			filterExpression += "( ";

			// Fetching Left operand
			if (expr.getLeftOperand() instanceof FieldIdentifier) {
				FieldIdentifier pFieldIden = (FieldIdentifier) expr.getLeftOperand();
				filterExpression = getFieldOperand(filterExpression, pFieldIden);
			} else if (expr.getLeftOperand() instanceof Constant) {
				Constant lConstant;
				lConstant = (Constant) expr.getLeftOperand();
				filterExpression = getConstantOperand(filterExpression, lConstant);
			}

			filterExpression += " " + getOperator(expr.getBinaryOperator());

			// Fetching the right operand
			if (expr.getRightOperand() instanceof FieldIdentifier) {
				FieldIdentifier pFieldIden = (FieldIdentifier) expr.getRightOperand();
				filterExpression = getFieldOperand(filterExpression, pFieldIden);
			} else if (expr.getRightOperand() instanceof Constant) {
				Constant rConstant;
				rConstant = (Constant) expr.getRightOperand();
				filterExpression = getConstantOperand(filterExpression, rConstant);
			}

			filterExpression += ") " + simpleLogicalOp;
		}

		filterExpression = filterExpression.substring(0, filterExpression.lastIndexOf(simpleLogicalOp));

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL,
				"SnowflakeV2TableDataAdapter:generateFilterClauseFromExpression:: filterExpression: "
						+ filterExpression);

		logger.logMessage(EMessageLevel.MSG_DEBUG, ELogLevel.TRACE_NORMAL,
				"SnowflakeV2TableDataAdapter:generateFilterClauseFromExpression:: end");

		return filterExpression;
	}

	// Fetches the operand if its an instance of the Field
	private String getFieldOperand(String filterExpression, FieldIdentifier pFieldIden) {
		Field efield = (Field) pFieldIden.getNativeFieldRef();
		if (efield != null) {
			// String eParentName =
			// buildTabName(efield.getParentRecord().getNativeName());
			// String eOperandName = eParentName + ".\"" +
			// pFieldIden.getBaseField().getName() + "\"";

			String eOperandName = "\"" + pFieldIden.getBaseField().getName() + "\"";
			filterExpression += eOperandName;
		}
		return filterExpression;
	}

	/**
	 * Translates the table name from <b>catalog.table</b> or
	 * <b>schema.table</b> to <b>catalog."table"</b> or <b>schema."table"</b>
	 * respectively. <br/>
	 * <br/>
	 * If the table name has special characters, it will be enclosed within
	 * double quotes.
	 * 
	 * @param nativeName
	 *            Native name of the flat record.
	 * @return The translated table name whose syntax is suitable for third
	 *         party.
	 */

	private String buildTabName(String nativeName) {

		// 17-Jun-2016: Using native name in Snowflake queries is not supported.
		// Input is not in the native name format.
		// So, commenting out this splitting-logic and returning the input as it is.

		/*
		 * String[] list = nativeName.split("\\."); String finalStr = list[0] +
		 * "." + "\"" + list[1] + "\""; return finalStr;
		 */

		return nativeName;
	}

	/**
	 * Get the third party equivalent of the binary operator
	 * 
	 * @param binaryOperator
	 *            An object of BinaryOperatorEnum class
	 * @return String equivalent of the binary operator
	 */

	private String getOperator(BinaryOperatorEnum binaryOperator) {
		switch (binaryOperator) {
		case EQUALS:
			return "=";
		case NOT_EQUALS:
			return "!=";
		case LESS:
			return "<";
		case LESS_OR_EQUALS:
			return "<=";
		case GREATER:
			return ">";
		case GREATER_OR_EQUALS:
			return ">=";
		case PLUS:
		case MINUS:
		case DIVIDE:
		case MULTIPLY:
		case MOD:
		case AND:
		case OR:
			return null;
		}
		return null;
	}

	// Fetches the operand if its an instance of a Constant
	private String getConstantOperand(String filterExpression, Constant eConstant) {
		if (eConstant instanceof DecimalConstant) {
			BigDecimal eValue = ((DecimalConstant) eConstant).getDecimalDataValue();
			filterExpression += " " + eValue.doubleValue();
		} else if (eConstant instanceof IntegerConstant) {
			BigInteger eValue = ((IntegerConstant) eConstant).getIntegerDataValue();
			filterExpression += " " + eValue.longValue();
		} else if (eConstant instanceof StringConstant) {
			String eValue = eConstant.getStringDataValue();
			filterExpression += " '" + eValue + "' ";
		} else if (eConstant instanceof DateConstant) {
			java.util.Date eValue = ((DateConstant) eConstant).getDateValue();
			filterExpression += " '" + eValue + "' ";
		}

		return filterExpression;
	}

	/**
	 * Log a localized message to session log.
	 * 
	 * @param logLevel
	 *            ELogLevel Trace level at which the message should be logged.
	 * @param messageKey
	 *            Message Key of the Message.
	 * @param messageFormatArguments
	 *            Message Format arguments.
	 * @return EReturnStatus The status of the logger call.
	 */

	private int logMessage(int logLevel, String messageKey, Object... messageFormatArguments) {
		if (this.logger != null) {
			return logger.logMessage(MessageBundle.getInstance(), logLevel, messageKey, messageFormatArguments);
		}
		return EReturnStatus.FAILURE;
	}

	/*
	 * Class holding information about the projected field and the index
	 */
	private class FieldInfo {
		BasicProjectionField field;
		int index;

		public FieldInfo(BasicProjectionField field, int index) {
			super();
			this.field = field;
			this.index = index;
		}
	}

	private void setSnowflakeUserContext(DataSession dataSession, SnowflakeV2UserContext muc) {
		dataSession.getMetadataHandle(EmetadataHandleTypes.runtimeConfigMetadata).setUserHandle(muc);
	}

	private SnowflakeV2UserContext getSnowflakeUserContext(DataSession dataSession) {
		return (SnowflakeV2UserContext) dataSession.getMetadataHandle(EmetadataHandleTypes.runtimeConfigMetadata)
				.getUserHandle();
	}

	protected class SnowflakeV2UserContext extends UserContext {

		private boolean resetRowIndex = false;
		private int totalRows = 0;
		private boolean truncateRequestCompleted = false;

		public boolean isResetRowIndex() {
			return resetRowIndex;
		}

		public void setResetRowIndex(boolean resetRowIndex) {
			this.resetRowIndex = resetRowIndex;
		}

		public int getTotalRows() {
			return totalRows;
		}

		public void setTotalRows(int totalRows) {
			this.totalRows = totalRows;
		}
		
		public boolean isTuncateRequestCompleted() {
			return truncateRequestCompleted;
		}
		
		public void setTruncateRequestCompleted(boolean complete) {
			this.truncateRequestCompleted = complete;
		}

	}
	
	enum ExecutionType {
		SINGLE, 	//Execute queries one by one. No option to improve performance
		BATCH,		//Use PreparedStatement and batch up for improved performance
		BULK,		//Create a Single query appending all values, if user opts for Bulk write
		NOP			//Request cannot be processed. Applicable when user opts for Bulk Write
					//but uses a table that has Semi-Structured data types (Object, Array or Variant)
	}

}