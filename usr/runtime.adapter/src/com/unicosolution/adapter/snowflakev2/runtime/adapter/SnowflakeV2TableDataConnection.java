package com.unicosolution.adapter.snowflakev2.runtime.adapter;

import com.informatica.sdk.adapter.javasdk.dataadapter.Connection;

import java.util.Map;
import java.util.HashMap;
import java.util.logging.Level;

import com.informatica.sdk.adapter.javasdk.common.ELogLevel;
import com.informatica.sdk.adapter.javasdk.common.EMessageLevel;
import com.informatica.sdk.adapter.javasdk.common.EReturnStatus;
import com.informatica.sdk.adapter.javasdk.common.Logger;
import com.informatica.sdk.adapter.javasdk.metadata.MetadataContext;
import com.informatica.sdk.adapter.metadata.common.Status;
import com.informatica.sdk.adapter.metadata.common.StatusEnum;
import com.informatica.sdk.exceptions.SDKException;
import com.unicosolution.adapter.snowflakev2.metadata.adapter.NativeConnectionHolder;
import com.unicosolution.adapter.snowflakev2.metadata.adapter.SnowflakeV2Connection;

public class SnowflakeV2TableDataConnection extends Connection {
	private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(
			SnowflakeV2TableDataConnection.class.getName());

	private Logger logger = null;

	private SnowflakeV2Connection metadataConn = new SnowflakeV2Connection();

	public SnowflakeV2TableDataConnection(Logger infaLogger) {
		this.logger = infaLogger;
	}

	/**
	 * Connects to the external data source. This method reuses the metadata
	 * connection to connect to the data source. Optionally, override this
	 * method if you want use a connection that is different from the metadata
	 * connection.
	 * 
	 * @param connHandle
	 *            The connection handle.
	 * @return An integer value defined in the EReturnStatus class that
	 *         indicates the status of the connect operation.
	 * @throws SDKException
	 */

	public int connect(MetadataContext connHandle) {
		LOGGER.finer(String.format("MetadataContext: %s", connHandle));
		Map<String, Object> attrMap = new HashMap<String, Object>();

		try {
			attrMap.put("user", connHandle.getStringAttribute("user"));
			attrMap.put("password", connHandle.getStringAttribute("password"));
			attrMap.put("db", connHandle.getStringAttribute("db"));
			attrMap.put("warehouse", connHandle.getStringAttribute("warehouse"));
			attrMap.put("account", connHandle.getStringAttribute("account"));
			attrMap.put("role", connHandle.getStringAttribute("role"));
			attrMap.put("schema", connHandle.getStringAttribute("schema"));
			attrMap.put("clientSessionKeepAlive", connHandle.getBooleanAttribute("clientSessionKeepAlive"));
			attrMap.put("useCustomURL", connHandle.getBooleanAttribute("useCustomURL"));
			attrMap.put("customURL", connHandle.getStringAttribute("customURL"));

			Status status = metadataConn.openConnection(attrMap);
			if (status.getStatus() == StatusEnum.SUCCESS) {
				return EReturnStatus.SUCCESS;
			} else {
				String msg = status.getMessage();
				if (msg != null) {
					logger.logMessage(EMessageLevel.MSG_ERROR, ELogLevel.TRACE_NONE, msg);
				}
				LOGGER.log(Level.SEVERE,
						String.format("Failed to open connection to Snowflake DB: %s", msg));
				return EReturnStatus.FAILURE;
			}

		} catch (SDKException e) {
			LOGGER.log(Level.SEVERE, "Failed to open connection to Snowflake DB", e);
			logger.logMessage(EMessageLevel.MSG_ERROR, ELogLevel.TRACE_NONE, e.getMessage());
		}

		return EReturnStatus.FAILURE;
	}

	/**
	 * Closes the connection with the external data source. This method reuses
	 * the metadata connection to disconnect from the data source. Optionally,
	 * override this method if you want use a connection that is different from
	 * the metadata connection.
	 * 
	 * @param connHandle
	 *            The connection handle.
	 * @return An integer value defined in the EReturnStatus class that
	 *         indicates the status of the disconnect operation.
	 */

	public int disConnect(MetadataContext connHandle) {
		LOGGER.finer(String.format("MetadataContext: %s", connHandle));
		Status status = metadataConn.closeConnection();
		if (status.getStatus() == StatusEnum.SUCCESS) {
			return EReturnStatus.SUCCESS;
		} else {

			String msg = status.getMessage();
			if (msg != null) {
				logger.logMessage(EMessageLevel.MSG_ERROR, ELogLevel.TRACE_NONE, msg);
			}
			LOGGER.log(Level.SEVERE,
					String.format("Failed to close connection to Snowflake DB: %s", msg));
			return EReturnStatus.FAILURE;
		}
	}

	/**
	 * Gets the connection with the external data source. This method reuses the
	 * metadata connection to connect to the data source. Optionally, override
	 * this method if you want use a connection that is different from the
	 * metadata connection.
	 * 
	 * @return An integer value defined in the EReturnStatus class that
	 *         indicates the status of the get operation.
	 */

	//Call this method for Table Data Read
	public Object getNativeConnection() {
		return metadataConn.getSnowflakeConnection();
    }

	//Call this method for Table Data Write
	public NativeConnectionHolder getNativeConnectionHolder() {
		return metadataConn.getSnowflakeNativeConnectionHolder();
    }
	
	public String getSchema() {
		return metadataConn.getSchema();
	}
	
	public String getCatalog() {
		return metadataConn.getCatalog();
	}
	
	public final SnowflakeV2Connection getMetadataConnection() {
		return metadataConn;
	}

}
