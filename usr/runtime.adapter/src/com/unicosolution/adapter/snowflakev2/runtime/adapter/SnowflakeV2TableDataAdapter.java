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
import java.util.logging.Level;

import com.informatica.sdk.adapter.javasdk.common.EIUDIndicator;
import com.informatica.sdk.adapter.javasdk.common.ErrorRowInfo;
import com.informatica.sdk.adapter.javasdk.common.Logger;
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
import com.informatica.sdk.exceptions.ExceptionManager;
import com.informatica.sdk.exceptions.SDKException;
import com.informatica.sdk.adapter.javasdk.dataadapter.ReadAttributes;
import com.informatica.sdk.adapter.javasdk.dataadapter.WriteAttributes;
import com.informatica.sdk.adapter.javasdk.dataaccess.DataAttributes;
import net.snowflake.client.jdbc.internal.amazonaws.util.json.JSONObject;
import net.snowflake.client.jdbc.internal.fasterxml.jackson.databind.Module.SetupContext;
import net.snowflake.client.loader.Loader;
import net.snowflake.client.loader.LoaderProperty;
import net.snowflake.client.loader.Operation;
import net.snowflake.client.loader.StreamLoader;
import com.unicosolution.adapter.snowflakev2.metadata.adapter.RecordMeta;
import com.unicosolution.adapter.snowflakev2.metadata.adapter.SnowflakeV2Connection;
import com.unicosolution.adapter.snowflakev2.runtime.adapter.utils.BulkLoadResultListener;
import com.unicosolution.adapter.snowflakev2.runtime.adapter.utils.ResultStats;
import com.unicosolution.adapter.snowflakev2.runtimemessages.MessageBundle;
import com.unicosolution.adapter.snowflakev2.runtimemessages.Messages;
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
import com.informatica.sdk.adapter.metadata.common.datasourceoperation.semantic.iface.WriteCapability;
import com.informatica.sdk.adapter.metadata.projection.semantic.iface.OperationBase;
import com.informatica.sdk.adapter.metadata.common.datasourceoperation.semantic.iface.ReadCapability;
import com.informatica.sdk.adapter.metadata.projection.semantic.iface.FieldBase;
import com.informatica.sdk.adapter.metadata.projection.semantic.iface.NativeField;
import com.informatica.sdk.adapter.metadata.projection.projectionoperation.semantic.iface.SelectTypeEnum;
import com.informatica.sdk.adapter.metadata.projection.sortoperation.semantic.iface.SortOrderEnum;
import com.informatica.sdk.adapter.metadata.projection.sourceoperation.semantic.iface.NativeSource;

@SuppressWarnings("unused")
public class SnowflakeV2TableDataAdapter extends DataAdapter {
	private static final java.util.logging.Logger LOGGER = java.util.logging.Logger
			.getLogger(SnowflakeV2TableDataAdapter.class.getName());

	private Logger logger = null;

	private int BATCH_SIZE = 1000;

	private List<BasicProjectionField> projectionFields = null;

	private List<FieldInfo> connectedFields = null;

	private CapabilityAttributes capAttrs = null;

	private BasicProjectionView projectionView = null;

	private List<ImportableObject> nativeRecords = null;
	private ResultSet resultSet = null;

	private FilterOperation m_FilterOperation;
	private String filterQuery;

	private String lookupExpr = "";
	private String simpleLogicalOp;
	private FlatRecord currentFlatRecord = null;

	private String sortquery;
	private String selectdestinct = "";
	private String selectexpression;
	private int currPartIndex;

	private ArrayList<String> joinTypes;
	private ArrayList<String> joinExprs;

	// TODO: do we support sort?
	private SortOperation m_SortOperation;
	private List<FieldBase> sortFieldBase;

	private SelectTypeEnum selType;
	private List<SortOrderEnum> sortOrderEnum;

	private String nativeFilterQuery;
	private String nativeJoinQuery;

	private Loader loader;
	private BulkLoadResultListener listener;
	private Operation op;

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
		logger = dataSession.getInfaUtilsHandle().getLogger();

		String msg = "begin";
		LOGGER.log(Level.FINER, msg);
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("initDataSession", msg));

		// The runtime metadata handle allows access to runtime metadata
		// information
		RuntimeConfigMetadata runtimeMetadataHandle = (RuntimeConfigMetadata) dataSession
				.getMetadataHandle(EmetadataHandleTypes.runtimeConfigMetadata);

		// Use the basic projection view to get basic details like the projected
		// fields/ filter / join metadata
		projectionView = runtimeMetadataHandle.getBasicProjection();

		// TODO: this is used only once in getConnectedFields. Doesn't need to
		// TODO: be instance variable
		// projectionFields has all fields of the native object to the platform
		// source/target
		projectionFields = projectionView.getProjectionFields();

		// connected fields is the subset of fields which are actually used in
		// the mapping.
		// use to fetch/write data to/from the native source
		connectedFields = getConnectedFields(runtimeMetadataHandle);

		// native flatrecord list used in the data session
		nativeRecords = projectionView.getNativeRecords();

		// TODO: what is this? This is not used even in MySQL example
		// handle to the list of capability attributes. Get the read/write
		// capability details using this list
		capAttrs = runtimeMetadataHandle.getCapabilityAttributes();

		// Get the current selected record
		currentFlatRecord = (FlatRecord) nativeRecords.get(0);

		SnowflakeV2UserContext suc = new SnowflakeV2UserContext();
		suc.setResetRowIndex(true);
		suc.setTotalRows(0);

		// Save the user context handle
		setSnowflakeUserContext(dataSession, suc);

		filterQuery = "";
		joinTypes = new ArrayList<String>();
		joinExprs = new ArrayList<String>();

		SnowflakeV2TableDataConnection conn = (SnowflakeV2TableDataConnection) dataSession.getConnection();

		int status = processFilterAndJoin(runtimeMetadataHandle);
		if (status != EReturnStatus.SUCCESS) {
			// not success
			return status;
		}
		msg = String.format(
				"Platform Join Types: %s," + " Platform Join Exprs: %s," + " Native Join: %s,"
						+ " Platform Filter Query: %s," + " Native Filter: %s",
				joinTypes, joinExprs, nativeJoinQuery, filterQuery, nativeFilterQuery);
		LOGGER.log(Level.FINER, msg);
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("initDataSession", msg));

		Capability capability = runtimeMetadataHandle.getAdapterDataSourceOperation().getCapabilities().get(0);

		if (capability instanceof WriteCapability) { // the operation is WRITE
			status = initBulkLoader(dataSession);
		}

		return status;
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
		String msg = String.format("SimpleBinaryExpression: %s, Left Op: %s, Opr: %s, Right Op: %s", simplBinExpr,
				simplBinExpr.getLeftOperand(), simplBinExpr.getBinaryOperator(), simplBinExpr.getRightOperand());
		LOGGER.log(Level.FINER, msg);
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("getResolvedJoinExpression", msg));

		// left operand
		FieldIdentifier pLeftFieldIden = (FieldIdentifier) simplBinExpr.getLeftOperand();
		Field lfield = (Field) pLeftFieldIden.getNativeFieldRef();
		String lOperandName = lfield.getNativeName();

		// right operand
		FieldIdentifier pRightFieldIden = (FieldIdentifier) simplBinExpr.getRightOperand();
		Field rfield = (Field) pRightFieldIden.getNativeFieldRef();
		String rOperandName = rfield.getNativeName();

		// combine with the operator
		String finalExpr = lOperandName + " " + getOperator(simplBinExpr.getBinaryOperator()) + " " + rOperandName;

		msg = String.format("Final Expr: %s", finalExpr);
		LOGGER.log(Level.FINER, msg);
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("getResolvedJoinExpression", msg));

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
	private List<FieldInfo> getConnectedFields(RuntimeConfigMetadata runtimeMetadataHandle) {
		String msg = "begin";
		LOGGER.log(Level.FINER, msg);
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("getConnectedFields", msg));

		int i = 0;
		List<FieldInfo> fields = new ArrayList<>();
		for (BasicProjectionField pfield : projectionFields) {
			if (runtimeMetadataHandle.isFieldConnected(i)) {
				FieldInfo f = new FieldInfo(pfield, i);
				fields.add(f);
			}
			i++;
		}
		msg = String.format("Connected fields: %s", fields);
		LOGGER.log(Level.FINER, msg);
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("getConnectedFields", msg));
		return fields;
	}

	/**
	 * parse the mapping graph to obtain filter and join expressions
	 * 
	 * @param dataSession
	 * 
	 * @return status of processing of filter and join expressions
	 ************************************* 
	 *         AUTOGENERATED CODE : DO NOT CHANGE
	 ************************************* 
	 */
	private int processFilterAndJoin(RuntimeConfigMetadata runtimeMetadataHandle) {
		String msg = String.format("RuntimeConfigMetadata: %s", runtimeMetadataHandle);
		LOGGER.log(Level.FINER, msg);
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("processFilterAndJoin", msg));

		ASOOperation m_asoOperation = runtimeMetadataHandle.getAdapterDataSourceOperation();
		ASOComplexType asoComplexType = m_asoOperation.getComplexTypes().get(0);
		List<Projection> projlist = asoComplexType.getProjections();
		List<Capability> caps = m_asoOperation.getCapabilities();
		Capability cap = caps.get(0);

		for (Projection proj : projlist) {
			msg = String.format("Projection: %s", proj);
			LOGGER.log(Level.FINER, msg);
			logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("processFilterAndJoin", msg));
			if (proj == null) {
				msg = "Projection is null";
				LOGGER.log(Level.SEVERE, msg);
				logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE,
						formatLog("processFilterAndJoin", msg));
				return EReturnStatus.FAILURE;
			}

			List<OperationBase> baseOperList = proj.getBaseOperations();
			msg = String.format("Base Projection: %s, size=%s", baseOperList, baseOperList.size());
			LOGGER.log(Level.FINER, msg);
			logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("processFilterAndJoin", msg));
			if (baseOperList == null) {
				msg = String.format("Base Projection is null. Projection: %s", proj);
				LOGGER.log(Level.SEVERE, msg);
				logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE, msg);
				return EReturnStatus.FAILURE;
			}

			int status = EReturnStatus.SUCCESS;
			for (OperationBase ob : baseOperList) {
				if (ob == null) {
					msg = String.format("Operation Base is null. Projection: %s, Base Projecion: %s", proj,
							baseOperList);
					LOGGER.log(Level.SEVERE, msg);
					logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE, msg);
					return EReturnStatus.FAILURE;
				}

				msg = String.format("Operation: %s, ReadCapacity?: %s", ob.getClass().getName(),
						cap instanceof ReadCapability);
				LOGGER.log(Level.FINER, msg);
				logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL,
						formatLog("processFilterAndJoin", msg));
				if (cap instanceof ReadCapability) {
					if (ob instanceof FilterOperation) {
						FilterOperation filterOperation = (FilterOperation) ob;
						if (filterOperation.isNativeFilter()) {
							status = processNativeFilter(filterOperation);
						} else {
							status = processPlatformFilter(filterOperation);
						}
					} else if (ob instanceof JoinOperation) {
						JoinOperation joinOperation = (JoinOperation) ob;
						LOGGER.log(Level.FINER,
								String.format("Join Opeartion. Is Native?: %s", joinOperation.isNativeJoin()));
						if (joinOperation.isNativeJoin()) {
							status = processNativeJoin(joinOperation);
						} else {
							status = processPlatformJoin(joinOperation);
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
		String msg = String.format("FilterOperation: %s, Filter Extension: %s", nativeFilter,
				nativeFilter.getFilterExpression());
		LOGGER.log(Level.FINER, msg);
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("processNativeFilter", msg));

		m_FilterOperation = nativeFilter;
		nativeFilterQuery = m_FilterOperation.getFilterExpression();

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
		String msg = String.format("FilterOperation: %s", platformFilter);
		LOGGER.log(Level.FINER, msg);
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("processPlatformFilter", msg));

		m_FilterOperation = platformFilter;
		SDKExpression expression = m_FilterOperation.getInfaSDKExpression();

		if (expression instanceof SimpleSDKExpression) {
			SimpleSDKExpression simpleExpr = (SimpleSDKExpression) expression;
			simpleLogicalOp = simpleExpr.getLogicalOperator().toString();

			filterQuery = generateFilterClauseFromExpression(expression);
			msg = String.format("filterQuery: %s", filterQuery);
			LOGGER.log(Level.FINER, msg);
			logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("processPlatformFilter", msg));
		} else {
			msg = String.format("Unsupported expression type: %s", expression.getClass().getName());
			LOGGER.log(Level.FINER, msg);
			logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("processPlatformFilter", msg));
			return EReturnStatus.FAILURE;
		}
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
		String msg = String.format("JoinOperation: %s, JoinCondition: %s", nativeJoin, nativeJoin.getJoinCondition());
		LOGGER.log(Level.FINER, msg);
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("processNativeJoin", msg));
		nativeJoinQuery = nativeJoin.getJoinCondition();
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
		String msg = String.format(
				"JoinOperation: Name: %s,InfaSDKExpression: %s, Join Policy Enum: %s,"
						+ " Foreign Key Relationship: %s, Join Condition: %s, Join Modifier: %s",
				platformJoin.getName(), platformJoin.getInfaSDKExpression().getExpressionString(),
				platformJoin.getJoinPolicyEnum(), platformJoin.getForeignKeyRelationship(),
				platformJoin.getJoinCondition(), platformJoin.getJoinModifier());
		LOGGER.log(Level.FINER, msg);
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("processPlatformJoin", msg));

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

		msg = String.format("Join Expression: %s", expression.getExpressionString());
		LOGGER.log(Level.FINER, msg);
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("processPlatformJoin", msg));

		if (expression instanceof SimpleSDKExpression) {
			SimpleSDKExpression simpleExpr = (SimpleSDKExpression) expression;
			simpleLogicalOp = simpleExpr.getLogicalOperator().toString();
			msg = String.format("Simple Logical Op: %s", simpleLogicalOp);
			LOGGER.log(Level.FINER, msg);
			logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_VERBOSE_DATA,
					formatLog("processPlatformJoin", msg));

			List<SimpleBinaryExpression> simplBinExprs = simpleExpr.getSimpleBinaryExpressions();

			for (SimpleBinaryExpression simplBinExpr : simplBinExprs) {
				msg = String.format("Simple Binary Expression: %s", simplBinExpr);
				LOGGER.log(Level.FINER, msg);
				logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_VERBOSE_DATA,
						formatLog("processPlatformJoin", msg));
				jexpr += " " + simpleLogicalOp + " " + getResolvedJoinExpression(simplBinExpr);
			}

			// remove the first Operator
			jexpr = jexpr.replaceFirst(simpleLogicalOp, "");
			joinExprs.add(" ON " + jexpr);
		} else {
			msg = String.format("Unsupported expression type: %s", expression.getClass().getName());
			LOGGER.log(Level.SEVERE, msg);
			logger.logMessage(EMessageLevel.MSG_ERROR, ELogLevel.TRACE_NONE, formatLog("processPlatformJoin", msg));
			return EReturnStatus.FAILURE;
		}

		msg = String.format("JoinExprs: %s", joinExprs);
		LOGGER.log(Level.FINER, msg);
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("processPlatformJoin", msg));
		return EReturnStatus.SUCCESS;
	}

	private int processProjectionOperation(ProjectionOperation ob) {
		String msg = String.format("ProjectionOperation: %s, Select Type: %s", ob, ob.getSelectTypeEnum());
		LOGGER.log(Level.FINER, msg);
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("processProjectionOperation", msg));

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
		return EReturnStatus.SUCCESS;
	}

	/**
	 * Process the platform sort expression.
	 * 
	 * Do we support sort expression?
	 * 
	 * @param ob
	 * @return
	 */
	private int processSortOperation(SortOperation ob) {
		String msg = String.format("SortOperation: %s, Field Base: %s, Sort Order: %S", ob, ob.getSortFieldsList(),
				ob.getSortOrdersEnumList());
		LOGGER.log(Level.FINER, msg);
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("processSortOperation", msg));

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
		LOGGER.log(Level.FINER, String.format("DataSession: %s", dataSession));
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
		LOGGER.log(Level.FINER, String.format("DataSession: %s", dataSession));
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
	public int deinitDataSession(DataSession dataSession) throws SDKException {
		String msg = "begin";
		LOGGER.log(Level.FINER, msg);
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("deinitDataSession", msg));

		RuntimeConfigMetadata runtimeMetadataHandle = (RuntimeConfigMetadata) dataSession
				.getMetadataHandle(EmetadataHandleTypes.runtimeConfigMetadata);

		Capability capability = runtimeMetadataHandle.getAdapterDataSourceOperation().getCapabilities().get(0);

		int returnStatus = EReturnStatus.FAILURE;
		// the operation is WRITE
		if (capability instanceof WriteCapability) {

			try {
				logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL,
						formatLog("deinitDataSession", "finishing loader"));
				loader.finish();

				int opInd = EIUDIndicator.INSERT; // default
				switch (op) {
				case INSERT:
					opInd = EIUDIndicator.INSERT;
					break;
				case MODIFY:
				case UPSERT:
					// MODIFY and UPSERT are the same in Informatica
					opInd = EIUDIndicator.UPDATE;
					break;
				case DELETE:
					opInd = EIUDIndicator.DELETE;
					break;
				default:
					logger.logMessage(EMessageLevel.MSG_WARNING, ELogLevel.TRACE_NORMAL, formatLog("deinitDataSession",
							"Unknown operation: " + op + ", Getting the stats as INSERT operation."));
					opInd = EIUDIndicator.INSERT;
				}

				RowsStatInfo rowsStatInfo = runtimeMetadataHandle.getRowsStatInfo(opInd);

				listener = (BulkLoadResultListener) loader.getListener();
				// Local -> No. of Rows Written
				rowsStatInfo.incrementApplied(listener.getProcessedRecordCount(op));
				rowsStatInfo.incrementAffected(listener.getOperationRecordCount(op));
				rowsStatInfo.incrementRejected(listener.getRejectedRecordCount(op));

				msg = String.format(
						"Processed Record Count: %s, Operation Record Count: %s, Rejected Recourd Count: %s",
						listener.getProcessedRecordCount(op), listener.getOperationRecordCount(op),
						listener.getRejectedRecordCount(op));
				LOGGER.log(Level.FINER, msg);

				logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_VERBOSE_DATA,
						formatLog("deinitDataSession", msg));
				returnStatus = EReturnStatus.SUCCESS;
			} catch (Exception e) {
				final String eMsg = e.getMessage();
				LOGGER.log(Level.SEVERE, eMsg, e);
				logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE,
						formatLog("deinitDataSession", eMsg));
				ExceptionManager.createNonNlsAdapterSDKException(formatLog("deinitDataSession", eMsg));

			} finally {
				try {
					loader.close();
				} catch (Exception e) {
					final String eMsg = formatLog("deinitDataSession", e.getMessage());
					LOGGER.log(Level.WARNING, eMsg, e);
					logger.logMessage(EMessageLevel.MSG_WARNING, ELogLevel.TRACE_NONE, eMsg);
				}
			}
		} else if (capability instanceof ReadCapability) {
			try {
				// Close result set
				if (resultSet != null) {
					resultSet.close();
				}
				returnStatus = EReturnStatus.SUCCESS;
			} catch (SQLException e) {
				final String eMsg = e.getMessage();
				LOGGER.log(Level.SEVERE, eMsg, e);
				logger.logMessage(EMessageLevel.MSG_WARNING, ELogLevel.TRACE_NONE,
						formatLog("deinitDataSession", eMsg));
				ExceptionManager.createNonNlsAdapterSDKException(formatLog("deinitDataSession", eMsg));
			}
		}
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NONE,
				formatLog("deinitDataSession", (returnStatus == EReturnStatus.SUCCESS ? "SUCCESS" : "FAILURE")));
		return returnStatus;
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
		String msg = String.format("DataSession: %s," + " ReadAttributes: %s," + " Number of Rows to Read: %s",
				dataSession, readAttr, readAttr.getNumRowsToRead());
		LOGGER.log(Level.FINER, msg);
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("read", msg));

		int rowsToRead = readAttr.getNumRowsToRead();
		SnowflakeV2TableDataConnection conn = (SnowflakeV2TableDataConnection) dataSession.getConnection();
		SnowflakeV2UserContext suc = getSnowflakeUserContext(dataSession);

		// Checking if the call to read is multiple times. Multiple calls to
		// read occurs when the data read is more than the platform buffer
		// allocated. rowsToRead > rows that is read from the third party

		if (!suc.isResetRowIndex()) {
			List<List<Object>> dataTable = new ArrayList<List<Object>>();
			int returnStatus = readDatafromSource(dataSession, dataTable, rowsToRead);
			setDataToPlatform(dataSession, dataTable);
			readAttr.setNumRowsRead(dataTable.size());
			return returnStatus;
		}

		try {
			Connection nativeConn = (Connection) conn.getNativeConnection();
			Statement ps = nativeConn.createStatement();
			// Embed the filter query onto the select statement so that
			// filtering happens at the source

			// Supporting native and Simple SDK expression both
			String query = getQuery(connectedFields);
			if (!isNullOrEmpty(filterQuery) && !isNullOrEmpty(nativeFilterQuery)) {
				// both Platform Filter or Native Filter is enabled
				if (!isNullOrEmpty(nativeJoinQuery)) {
					query = getNativeJoinQuery(connectedFields) + " WHERE " + filterQuery + " " + simpleLogicalOp
							+ " ( " + nativeFilterQuery + " )";
				} else if (joinTypes.size() > 0 || joinExprs.size() > 0) {
					query = getJoinQuery(connectedFields) + " WHERE " + filterQuery + " " + simpleLogicalOp + " ( "
							+ nativeFilterQuery + " )";
				} else {
					query = query + " WHERE " + filterQuery + " " + simpleLogicalOp + " ( " + nativeFilterQuery + " )";
				}
			} else {
				// Combination of filter and join expressions
				if (joinTypes.size() > 0 || joinExprs.size() > 0) {
					// Platform Join
					query = getJoinQuery(connectedFields);
					if (!isNullOrEmpty(filterQuery)) {
						query += " WHERE " + filterQuery;
					} else if (!isNullOrEmpty(nativeFilterQuery)) {
						query += " WHERE " + nativeFilterQuery;
					}
				} else if (!isNullOrEmpty(nativeJoinQuery)) {
					// Native Join
					query = getNativeJoinQuery(connectedFields);
					if (!isNullOrEmpty(filterQuery)) {
						query += " WHERE " + filterQuery;
					} else if (!isNullOrEmpty(nativeFilterQuery)) {
						query += " WHERE " + nativeFilterQuery;
					}
				} else if (!isNullOrEmpty(filterQuery)) {
					// Single filter expressions
					query = query + " WHERE " + filterQuery;
				} else if (!isNullOrEmpty(nativeFilterQuery)) {
					query = query + " WHERE " + nativeFilterQuery;
				} else if (!isNullOrEmpty(lookupExpr)) {
					query = query + " WHERE " + lookupExpr;
				}
			}

			try {
				msg = String.format("Query: %s", query);
				LOGGER.log(Level.FINER, msg);
				logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("read", msg));

				resultSet = ps.executeQuery(query);
			} finally {
				ps.close();
			}

		} catch (SQLException se) {
			String eMsg = se.getMessage();
			LOGGER.log(Level.SEVERE, eMsg, se);
			logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE, formatLog("read", eMsg));
			ExceptionManager.createNonNlsAdapterSDKException(formatLog("read", eMsg));
			return EReturnStatus.FAILURE;
		}

		List<List<Object>> dataTable = new ArrayList<List<Object>>();
		int returnStatus = readDatafromSource(dataSession, dataTable, rowsToRead);
		setDataToPlatform(dataSession, dataTable);
		readAttr.setNumRowsRead(dataTable.size());
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
		String msg = String.format("ConnectedFields: %s", connectedFields);
		LOGGER.log(Level.FINER, msg);
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_VERBOSE_DATA, formatLog("getNativeJoinQuery", msg));
		return getQuery(connectedFields) + " ON " + nativeJoinQuery;
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
		LOGGER.log(Level.FINER, String.format("ConnectedFields: %s", connectedFields));

		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("getJoinQuery", "begin"));
		String query = getGenericQuery(connectedFields);

		FlatRecord fr1 = (FlatRecord) nativeRecords.get(0);
		FlatRecord fr2 = (FlatRecord) nativeRecords.get(1);
		String tabName1 = fr1.getNativeName();
		String tabName2 = fr2.getNativeName();

		if (joinExprs.size() > 0)
			query += tabName1 + " " + joinTypes.get(0) + " " + tabName2 + joinExprs.get(0);
		else
			query += tabName1 + " " + joinTypes.get(0) + " " + tabName2;

		for (int i = 2; i < nativeRecords.size(); i++) {
			fr2 = (FlatRecord) nativeRecords.get(i);
			tabName2 = fr2.getNativeName();
			if (joinExprs.size() > 0)
				query += " " + joinTypes.get(i - 1) + " " + tabName2 + joinExprs.get(i - 1);
			else
				query += " " + joinTypes.get(i - 1) + " " + tabName2;
		}
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("getJoinQuery", query));
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
		LOGGER.log(Level.FINER, String.format("ConnectedFields: %s", connectedFields));
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("getGenericQuery", "begin"));

		// TODO: do we need this? selectdestinct. This is not used.
		String query = "SELECT " + selectdestinct;
		boolean addComma = false;
		for (FieldInfo field : connectedFields) {
			if (addComma) {
				query += " , ";
			}
			// NOTE: column native name is a fully qualified name
			query += field.field.getNativeFieldRef().getNativeName();
			addComma = true;
		}
		query += " FROM ";
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("getGenericQuery", query));
		return query;
	}

	/**
	 * Builds the read query from the connected fields
	 */
	private String getQuery(List<FieldInfo> connectedFields) {
		LOGGER.log(Level.FINER, String.format("ConnectedFields: %s", connectedFields));
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("getQuery", "begin"));

		String query = "SELECT ";
		boolean addComma = false;
		for (FieldInfo field : connectedFields) {
			if (addComma) {
				query += ", ";
			}
			query += field.field.getNativeFieldRef().getNativeName();
			addComma = true;
		}
		// Assuming of a single source
		query += " FROM " + ((Record) nativeRecords.get(0)).getNativeName();

		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("getQuery", query));
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
		LOGGER.log(Level.FINER, String.format("DataSession: %s," + " DataTable: %s," + " RowsToRead: %s", dataSession,
				dataTable, rowsToRead));

		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("readDatafromSource", "begin"));

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
				if (!resultSet.next()) {
					status = EReturnStatus.NO_MORE_DATA;
					break;
				}

				List<Object> datarow = new ArrayList<Object>();
				for (int i = 0; i < connectedFields.size(); i++) {
					String dataType = connectedFields.get(i).field.getNativeFieldRef().getDataType();
					if ("BOOLEAN".equalsIgnoreCase(dataType) || "OBJECT".equalsIgnoreCase(dataType)) {
						datarow.add(resultSet.getString(i + 1));
					} else {
						datarow.add(resultSet.getObject(i + 1));
					}
				}

				dataTable.add(datarow);
				rowsRead++;
			}

			muc.setTotalRows(muc.getTotalRows() + rowsRead);

		} catch (SQLException e) {
			String eMsg = e.getMessage();
			LOGGER.log(Level.SEVERE, eMsg, e);
			logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE,
					formatLog("readDatafromSource", eMsg));
			ExceptionManager.createNonNlsAdapterSDKException(formatLog("readDatafromSource", eMsg));
			return EReturnStatus.FAILURE;
		}

		setSnowflakeUserContext(dataSession, muc);
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("readDatafromSource", "end"));
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
		LOGGER.log(Level.FINER, String.format("DataSession: %s, DataTable: %s", dataSession, dataTable));
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("setDataToPlatform", "begin"));

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

						logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_VERBOSE_DATA,
								"setDataToPlatform: boolValue : " + boolValue + " pDataAttributes.getIndicator() : "
										+ pDataAttributes.getIndicator());

						if ("true".equalsIgnoreCase(boolValue) || "t".equalsIgnoreCase(boolValue)
								|| "on".equalsIgnoreCase(boolValue) || "1".equalsIgnoreCase(boolValue)
								|| "y".equalsIgnoreCase(boolValue) || "yes".equalsIgnoreCase(boolValue)
								|| "\"true\"".equalsIgnoreCase(boolValue)) {
							data = "true";
						} else {
							data = "false";
						}
						logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_VERBOSE_DATA,
								"setDataToPlatform: data : " + data);

					} else if ("OBJECT".equalsIgnoreCase(nativeType)) {

						String strData = (String) data;
						try {
							JSONObject jsonData = new JSONObject(strData);
							data = jsonData.toString();

						} catch (Exception e) {
							data = ((String) data).replaceAll("\n", "");

							// data = ((String) data).replaceAll("\n", "")
							// .replaceAll("\\\"", "\"");
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
					// TODO: is this still valid?
					// TIMESTAMPNTZ does not accept Timezone. So
					// we have mapped it to Informatica "string" type.
					// But the data from the datasource would still be
					// TIMESTAMPNTZ
					if ("TIMESTAMPNTZ".equalsIgnoreCase(nativeType)) {
						// dataSession.setDateTimeData((Timestamp) data,
						// pDataAttributes);
						// dataSession.setStringData((String) data.toString(),
						// pDataAttributes);
						if (null != data) {
							dataSession.setStringData((String) data.toString(), pDataAttributes);
						} else {
							dataSession.setStringData((String) null, pDataAttributes);
						}
					} else {
						dataSession.setStringData((String) data, pDataAttributes);
						logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_VERBOSE_DATA,
								" After setting data to session, pDataAttributes.getIndicator() : "
										+ pDataAttributes.getIndicator());
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
						logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_VERBOSE_DATA, "Data for type ["
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
						logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_VERBOSE_DATA, "Data for type ["
								+ dataType + "] should be a of type [" + BigDecimal.class.getName() + "].");
						data = null;
					}
					dataSession.setBigDecimalData((BigDecimal) data, pDataAttributes);
				}
			}
		}
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("setDataToPlatform", "end"));

	}

	private String getOperationTypeString(int operationType, boolean isUpsert) {
		if (operationType == EIUDIndicator.INSERT) {
			return "INSERT";
		} else if (operationType == EIUDIndicator.UPDATE) {
			if (isUpsert) {
				return "UPSERT";
			} else {
				return "UPDATE";
			}
		} else if (operationType == EIUDIndicator.DELETE) {
			return "DELETE";
		} else if (operationType == EIUDIndicator.STREAMING_INSERT) {
			return "STREAMING_INSERT";
		} else if (operationType == EIUDIndicator.REJECT) {
			return "REJECT";
		}
		return "UNKNOWN";
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
		RuntimeConfigMetadata runtimeMetadataHandle = (RuntimeConfigMetadata) dataSession
				.getMetadataHandle(EmetadataHandleTypes.runtimeConfigMetadata);

		// Checking the first row is good enough at bulk loading at all times.
		int operationType = runtimeMetadataHandle.getRowIUDIndicator(0);

		ASOOperation asoOperation = runtimeMetadataHandle.getAdapterDataSourceOperation();
		WriteCapabilityAttributes currPartInfo = asoOperation.getWriteCapabilityAttributes();

		String writerPartID = null;
		boolean isUpsert = false;
		boolean abortOnErrors = false;
		boolean propagateData = false;

		if (currPartInfo != null) {
			SEMTableWriteCapabilityAttributesExtension partAttris = (SEMTableWriteCapabilityAttributesExtension) (currPartInfo)
					.getExtensions();
			isUpsert = !partAttris.getUpdateMode().equalsIgnoreCase("Update As Update");

			// loader listener properties
			abortOnErrors = partAttris.isAbortOnErrors();
			propagateData = partAttris.isPropagateData();
		}

		int returnStatus = EReturnStatus.FAILURE;

		switch (operationType) {
		case EIUDIndicator.INSERT:
			op = Operation.INSERT;
			break;
		case EIUDIndicator.DELETE:
			op = Operation.DELETE;
			break;
		case EIUDIndicator.UPDATE:
			if (!isUpsert) {
				op = Operation.MODIFY;
			} else {
				op = Operation.UPSERT;
			}
			break;

		default: // Default is INSERT
			op = Operation.INSERT;
			break;
		}

		returnStatus = submitDataToLoader(dataSession, writeAttr.getNumRowsToWrite());

		// Capture the processing stats from the loader's listener
		RowsStatInfo rowsStatInfo = runtimeMetadataHandle.getRowsStatInfo(operationType);

		rowsStatInfo.incrementRequested(writeAttr.getNumRowsToWrite());
		listener = (BulkLoadResultListener) loader.getListener();
		// Local -> No. of Rows Written
		rowsStatInfo.incrementApplied(listener.getProcessedRecordCount(op));
		rowsStatInfo.incrementAffected(listener.getOperationRecordCount(op));
		rowsStatInfo.incrementRejected(listener.getRejectedRecordCount(op));

		String msg = String.format(
				"Operation Type: %s, Submitted: %s, Processed Record Count: %s, Operation Record Count: %s, Rejected Recourd Count: %s",
				getOperationTypeString(operationType, isUpsert), writeAttr.getNumRowsToWrite(),
				listener.getProcessedRecordCount(op), listener.getOperationRecordCount(op),
				listener.getRejectedRecordCount(op));
		LOGGER.log(Level.FINER, msg);
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_VERBOSE_DATA, formatLog("write", msg));

		// Resetting the listener. All metrics are reset
		listener = new BulkLoadResultListener(this);
		listener.setAbortOnErrors(abortOnErrors);
		listener.setPropagate(propagateData);
		((BulkLoadResultListener) listener).setOperation(op);
		loader.setListener(listener);
		return returnStatus;
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
		LOGGER.log(Level.FINER, String.format("DataSession: %s", dataSession));

		SDKExpression expression;

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

	/**
	 * Generates a WHERE clause from a filter expression.
	 * 
	 * (A1 binOp B1) op (A2 binOp B2) op (A3 binOp B2)...
	 * 
	 * @param expression
	 * @return a where clause
	 */
	private String generateFilterClauseFromExpression(SDKExpression expression) {
		LOGGER.log(Level.FINER, String.format("SDKExpression: %s", expression));
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL,
				formatLog("generateFilterClauseFromExpression", "begin"));

		SimpleSDKExpression simpleExpr = (SimpleSDKExpression) expression;
		List<SimpleBinaryExpression> pBinExprsList = simpleExpr.getSimpleBinaryExpressions();

		String filterExpression = "";

		for (SimpleBinaryExpression expr : pBinExprsList) {

			filterExpression += "( ";

			// Left operand
			if (expr.getLeftOperand() instanceof FieldIdentifier) {
				FieldIdentifier pFieldIden = (FieldIdentifier) expr.getLeftOperand();
				filterExpression = getFieldOperand(filterExpression, pFieldIden);
			} else if (expr.getLeftOperand() instanceof Constant) {
				Constant lConstant = (Constant) expr.getLeftOperand();
				filterExpression = getConstantOperand(filterExpression, lConstant);
			}

			filterExpression += " " + getOperator(expr.getBinaryOperator());

			// Right operand
			if (expr.getRightOperand() instanceof FieldIdentifier) {
				FieldIdentifier pFieldIden = (FieldIdentifier) expr.getRightOperand();
				filterExpression = getFieldOperand(filterExpression, pFieldIden);
			} else if (expr.getRightOperand() instanceof Constant) {
				Constant rConstant = (Constant) expr.getRightOperand();
				filterExpression = getConstantOperand(filterExpression, rConstant);
			}

			filterExpression += ") " + simpleLogicalOp;
		}

		filterExpression = filterExpression.substring(0, filterExpression.lastIndexOf(simpleLogicalOp));
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL,
				formatLog("generateFilterClauseFromExpression", filterExpression));
		return filterExpression;
	}

	// Fetches the operand if its an instance of the Field
	private String getFieldOperand(String filterExpression, FieldIdentifier pFieldIden) {
		LOGGER.log(Level.FINER,
				String.format("FilterExpression: %s, FieldIdentifier: %s", filterExpression, pFieldIden));
		Field efield = (Field) pFieldIden.getNativeFieldRef();
		if (efield != null) {
			filterExpression += efield.getNativeName();
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
		LOGGER.log(Level.FINER, String.format("NativeName: %s", nativeName));
		// 17-Jun-2016: Using native name in Snowflake queries is not supported.
		// Input is not in the native name format.
		// So, commenting out this splitting-logic and returning the input as it
		// is.

		// TODO: this should be remove as the native names are stored in
		// nativeName attributes in Field object
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
		LOGGER.log(Level.FINER, String.format("BinaryOperatorEnum: %s", binaryOperator));
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

	/**
	 * Gets a constant/static value
	 * 
	 * @param filterExpression
	 * @param eConstant
	 * @return a constant value
	 */
	private String getConstantOperand(String filterExpression, Constant eConstant) {
		LOGGER.log(Level.FINER, String.format("FieldExpression: %s, Constant: %s", filterExpression, eConstant));
		if (eConstant instanceof DecimalConstant) {
			BigDecimal eValue = ((DecimalConstant) eConstant).getDecimalDataValue();
			// TODO: format double with precision and scale
			filterExpression += " " + eValue.doubleValue();
		} else if (eConstant instanceof IntegerConstant) {
			BigInteger eValue = ((IntegerConstant) eConstant).getIntegerDataValue();
			filterExpression += " " + eValue.longValue();
		} else if (eConstant instanceof StringConstant) {
			String eValue = eConstant.getStringDataValue();
			filterExpression += " '" + eValue + "' ";
		} else if (eConstant instanceof DateConstant) {
			java.util.Date eValue = ((DateConstant) eConstant).getDateValue();
			// TODO: format date object so that the DB can recognize it
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
		if (logger != null) {
			return logger.logMessage(MessageBundle.getInstance(), logLevel, messageKey, messageFormatArguments);
		}
		return EReturnStatus.FAILURE;
	}

	/**
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

		public String toString() {
			return String.format("Field: %s, Index: %s", field, index);
		}
	}

	private void setSnowflakeUserContext(DataSession dataSession, SnowflakeV2UserContext muc) {
		LOGGER.log(Level.FINER, String.format("DataSession: %s, SnowflakeV2UserContext: %s", dataSession, muc));
		dataSession.getMetadataHandle(EmetadataHandleTypes.runtimeConfigMetadata).setUserHandle(muc);
	}

	private SnowflakeV2UserContext getSnowflakeUserContext(DataSession dataSession) {
		LOGGER.log(Level.FINER, String.format("DataSession: %s", dataSession));
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

	public void logDebugMessage(String caller, String method, String message) {
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_VERBOSE_DATA, caller + ":" + method + ": " + message);
	}

	/**
	 * Kicks off the bulk loader process (threads)
	 */
	private int initBulkLoader(DataSession dataSession) throws SDKException {
		LOGGER.log(Level.FINER, String.format("DataSession: %s", dataSession));
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("initBulkLoader", "begin"));

		SnowflakeV2TableDataConnection conn = (SnowflakeV2TableDataConnection) dataSession.getConnection();

		String database = conn.getCatalog();
		String schema = conn.getSchema();

		String tableName = currentFlatRecord.getName();
		LOGGER.log(Level.FINER,
				String.format("Table Name: %s, Table Native Name: %s", tableName, currentFlatRecord.getNativeName()));

		List<String> columnsList = new ArrayList<>();
		for (FieldInfo fieldInfo : connectedFields) {
			columnsList.add(fieldInfo.field.getName());
		}
		LOGGER.log(Level.FINER, String.format("Column List: %s", columnsList));

		List<Field> pkFields = new ArrayList<>();
		PrimaryKey pk = currentFlatRecord.getPrimaryKey();
		if (null != pk && null != pk.getFieldList() && !pk.getFieldList().isEmpty()) {
			pkFields.addAll(pk.getFieldList());
		}
		LOGGER.log(Level.FINER, String.format("Primary Key Fields: %s", pkFields));

		List<String> pkColumns = new ArrayList<>();
		for (Field pkField : pkFields) {
			pkColumns.add(pkField.getName());
		}
		LOGGER.log(Level.FINER, String.format("Primary Key Columns: %s", pkColumns));

		RecordMeta recordMeta = new RecordMeta();
		recordMeta.setCatalogName(database);
		recordMeta.setRecordName(tableName);
		recordMeta.setColumns(columnsList);
		recordMeta.setKeys(pkColumns);

		SnowflakeV2Connection metadataConnection = conn.getMetadataConnection();
		loader = metadataConnection.getStreamLoader(recordMeta);

		RuntimeConfigMetadata runtimeMetadataHandle = (RuntimeConfigMetadata) dataSession
				.getMetadataHandle(EmetadataHandleTypes.runtimeConfigMetadata);

		ASOOperation m_asoOperation = runtimeMetadataHandle.getAdapterDataSourceOperation();
		WriteCapabilityAttributes writeCapAttr = m_asoOperation.getWriteCapabilityAttributes();

		String preSql = null;
		String postSql = null;
		boolean oneBatch = false;
		boolean truncateTable = false;
		String updatedKeyColumns = null;
		boolean startTransaction = false;
		boolean abortOnErrors = false;
		boolean propagateData = false;

		if (writeCapAttr != null) {
			SEMTableWriteCapabilityAttributesExtension writeAttribs = (SEMTableWriteCapabilityAttributesExtension) (writeCapAttr)
					.getExtensions();

			// loader properties
			preSql = writeAttribs.getPreSql();
			postSql = writeAttribs.getPostSql();
			oneBatch = writeAttribs.isOneBatch();
			truncateTable = writeAttribs.isTruncateTargetTable();
			updatedKeyColumns = writeAttribs.getUpdateKeyColumns();
			startTransaction = writeAttribs.isStartTransactionForJobs();

			// loader listener properties
			abortOnErrors = writeAttribs.isAbortOnErrors();
			propagateData = writeAttribs.isPropagateData();
		}

		if (!isNullOrEmpty(preSql)) {
			loader.setProperty(LoaderProperty.executeBefore, preSql);
		}
		if (!isNullOrEmpty(database)) {
			loader.setProperty(LoaderProperty.databaseName, database);
		}
		if (!isNullOrEmpty(schema)) {
			loader.setProperty(LoaderProperty.schemaName, schema);
		}
		if (!isNullOrEmpty(postSql)) {
			loader.setProperty(LoaderProperty.executeAfter, postSql);
		}

		loader.setProperty(LoaderProperty.startTransaction, startTransaction);
		loader.setProperty(LoaderProperty.oneBatch, oneBatch);
		loader.setProperty(LoaderProperty.truncateTable, truncateTable);

		// safe to set, delayed OP change will be a no-ops
		loader.setProperty(LoaderProperty.operation, Operation.INSERT);
		op = Operation.INSERT;

		if (!isNullOrEmpty(updatedKeyColumns)) {
			// key columns
			List<String> keys = new ArrayList<>();
			for (String c : updatedKeyColumns.split("\\s*;\\s*")) {
				boolean found = false;

				for (FieldInfo fieldInfo : connectedFields) {
					LOGGER.log(Level.FINER,
							String.format(
									"FieldInfo: " + " Index: %s," + " Field Name: %s," + " Field Native Ref Name: %s,"
											+ " Field Native Ref Native Name: %s",
									fieldInfo.index, fieldInfo.field.getName(),
									fieldInfo.field.getNativeFieldRef().getName(),
									fieldInfo.field.getNativeFieldRef().getNativeName()));
					if (fieldInfo.field.getNativeFieldRef().getName().equalsIgnoreCase(c)) {
						keys.add(fieldInfo.field.getNativeFieldRef().getName());
						found = true;
						break;
					}
				}
				if (!found) {
					// no column didn't match
					String msg = String.format("Not found the Update Key Column: %s", c);
					LOGGER.log(Level.WARNING, msg);
					logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE,
							formatLog("initBulkLoader", msg));
					ExceptionManager.createNonNlsAdapterSDKException(formatLog("initBulkLoader", msg));
					return EReturnStatus.FAILURE;
				}
			}
			loader.setProperty(LoaderProperty.keys, keys);
		}

		String msg = String.format(
				"Loader Properties: DB: %s, Schema: %s, OneBatch: %s, TruncateTable: %s, StartTransaction: %s, UpdatedKeyColumns: %s",
				database, schema, oneBatch, truncateTable, startTransaction, updatedKeyColumns);
		LOGGER.log(Level.FINER, msg);
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("initBulkLoader", msg));
		msg = String.format("Loader Listener Properties: AbortOnErrors %s, Propagte: %s", abortOnErrors, propagateData);
		LOGGER.log(Level.FINER, msg);
		logger.logMessage(EMessageLevel.MSG_INFO, ELogLevel.TRACE_NORMAL, formatLog("initBulkLoader", msg));

		// A new listener. All metrics are reset
		listener = new BulkLoadResultListener(this);
		listener.setAbortOnErrors(abortOnErrors);
		listener.setPropagate(propagateData);
		loader.setListener(listener);
		try {
			LOGGER.log(Level.FINE, String.format("Starting Loader..."));
			loader.start();
		} catch (Exception e) {
			String eMsg = String.format("Failed to start Loader: %s", e.getMessage());
			LOGGER.log(Level.SEVERE, eMsg);
			logger.logMessage(EMessageLevel.MSG_FATAL_ERROR, ELogLevel.TRACE_NONE, formatLog("initBulkLoader", eMsg));
			try {
				loader.finish();
				loader.close();
			} catch (Exception e1) {
				LOGGER.log(Level.WARNING,
						String.format("Ignoring Loader finish/close failed in the event of loader start failure"));
			} finally {
				ExceptionManager.createNonNlsAdapterSDKException(formatLog("initBulkLoader", eMsg));
			}
			return EReturnStatus.FAILURE;
		}
		return EReturnStatus.SUCCESS;
	}

	private int submitDataToLoader(DataSession dataSession, int numberOfRows) throws SDKException {
		LOGGER.log(Level.FINER, String.format("DataSession: %s, NoOfRows: %s", dataSession, numberOfRows));

		loader.resetOperation(op);
		((BulkLoadResultListener) loader.getListener()).setOperation(op);

		int noOfCols = connectedFields.size();
		List<Object[]> rows = new ArrayList<>();
		Object fieldData = null;

		for (int row = 0; row < numberOfRows; row++) {

			try {
				Object[] rowData = new Object[noOfCols];

				for (int fieldIndex = 0; fieldIndex < noOfCols; fieldIndex++) {

					FieldInfo fieldInfo = connectedFields.get(fieldIndex);
					LOGGER.log(Level.FINER,
							String.format(
									"FieldInfo: Index: %s, Field Name: %s, Field Native Ref Name: %s,"
											+ " Field Native Ref Native Name: %s",
									fieldInfo.index, fieldInfo.field.getName(),
									fieldInfo.field.getNativeFieldRef().getName(),
									fieldInfo.field.getNativeFieldRef().getNativeName()));

					DataAttributes pDataAttributes = new DataAttributes();
					pDataAttributes.setRowIndex(row);
					pDataAttributes.setColumnIndex(fieldInfo.index);
					pDataAttributes.setDataSetId(0); // currently 0

					BasicProjectionField field = fieldInfo.field;
					fieldData = getDataObjectValueFromPlatform(dataSession, pDataAttributes, field);

					rowData[fieldIndex] = fieldData;
				}

				loader.submitRow(rowData);
			} catch (Exception e) {
				String eMsg = "";
				if (loader instanceof StreamLoader) {
					if (((StreamLoader) loader).getListener() instanceof BulkLoadResultListener) {
						// The Loader and LoadResultListener APIs do not provide
						// a way to track rejected count
						// So, need to do this hack
						StreamLoader streamLoader = (StreamLoader) loader;
						BulkLoadResultListener bulkLoadResultListener = (BulkLoadResultListener) streamLoader
								.getListener();
						bulkLoadResultListener.addRejectedRecordCount(op, 1);
						LOGGER.log(Level.WARNING, String.format("Write failed: %s", e.getMessage(),
								bulkLoadResultListener.getRejectedRecordCount(op)), e);
					} else {
						LOGGER.log(Level.SEVERE,
								String.format("Unsupported loader is used: %s", loader.getClass().getName()), e);
					}
				} else {
					// if not StreamLoader, implement here to set the rejected
					// record.
					eMsg = String.format("The loader class is not StreamLoader: %s. Ignored...",
							loader.getClass().getName());
					LOGGER.log(Level.WARNING, eMsg);
				}
				eMsg = formatLog("submitDataToLoader",
						String.format("Rejecting row-%s for %s operation on table %s, Cause: %s", row, op,
								currentFlatRecord.getName(), e.getMessage()));
				LOGGER.log(Level.INFO, eMsg, e);
				logger.logMessage(EMessageLevel.MSG_ERROR, ELogLevel.TRACE_NONE, eMsg);
				ExceptionManager.createNonNlsAdapterSDKException(formatLog("submitDataToLoader", eMsg));
				return EReturnStatus.FAILURE;
			}
		}
		return EReturnStatus.SUCCESS;
	}

	private Object getDataObjectValueFromPlatform(DataSession dataSession, DataAttributes pDataAttributes,
			BasicProjectionField field) throws SDKException {
		LOGGER.log(Level.FINER, String.format("DataSession: %s, DataAttributes: %s, BasicProjectionField: %s",
				dataSession, pDataAttributes, field));

		String dataValue = "";
		Object objValue = null;

		LOGGER.log(Level.FINER, String.format("Data Type: %s", field.getDataType()));
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
				objValue = new String(dataValue);
				break;
			case "BOOLEAN":
				dataValue = dataSession.getStringData(pDataAttributes);
				objValue = ("t".equalsIgnoreCase(dataValue) || "true".equalsIgnoreCase(dataValue)
						|| "yes".equalsIgnoreCase(dataValue) || "y".equalsIgnoreCase(dataValue)
						|| "on".equalsIgnoreCase(dataValue) || "1".equalsIgnoreCase(dataValue));
				break;

			case "OBJECT":
			case "ARRAY":
			case "VARIANT":
			default:
				dataValue += dataSession.getStringData(pDataAttributes);
				// dataValue += "\'" +
				// dataSession.getStringData(pDataAttributes) + "\'";
				objValue = new String(dataValue);
				break;
			}
			break;

		case "integer":
			objValue = new Integer(dataSession.getIntData(pDataAttributes));
			break;

		case "bigint":
			objValue = new Long(dataSession.getLongData(pDataAttributes));
			break;

		case "double":
			objValue = new Double(dataSession.getDoubleData(pDataAttributes));
			break;

		case "date/time":
			objValue = dataSession.getDateTimeData(pDataAttributes);
			break;

		case "decimal":
			objValue = dataSession.getBigDecimalData(pDataAttributes);
			break;

		case "binary":
			objValue = dataSession.getBinaryData(pDataAttributes) + "";
			break;
		}
		// Preventing primitives to be set as 0
		if (pDataAttributes.getIndicator() == EIndicator.NULL) {
			objValue = null;
		}

		return objValue;
	}

	/**
	 * Is null or empty string?
	 * 
	 * @param str
	 * @return true if null or empty
	 */
	private final boolean isNullOrEmpty(String str) {
		return str == null || str.trim().isEmpty();
	}

	private final String formatLog(String methodName, String msg) {
		return SnowflakeV2TableDataAdapter.class.getSimpleName() + "." + methodName + ": " + msg;
	}
}