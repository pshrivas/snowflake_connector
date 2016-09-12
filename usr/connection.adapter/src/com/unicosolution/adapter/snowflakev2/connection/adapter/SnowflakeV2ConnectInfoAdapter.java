package com.unicosolution.adapter.snowflakev2.connection.adapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.informatica.sdk.adapter.connection.SDKConnectionConsumerAttribute;
import com.informatica.sdk.adapter.connection.SDKConsumerTypeEnum;
import com.informatica.sdk.adapter.connection.SDKErrorInfo;
import com.informatica.sdk.exceptions.ExceptionManager;
import com.unicosolution.adapter.snowflakev2.designmessages.MessageBundle;
import com.unicosolution.adapter.snowflakev2.designmessages.Messages;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SnowflakeV2ConnectInfoAdapter extends SnowflakeV2BaseConnectInfoAdapter  {
	public static final String CONNECTOR_NAMESPACE = "com.unicosolution";
	public static final String JDBC_NAMESPACE = "com.snowflake";
	public static final String SYSTEM_PROPERTY_NAMESPACE = "com.snowflake.connector.informatica.";
	public static final Level DEFAULT_LOG_LEVEL = Level.SEVERE;
	
	private Logger LOGGER = Logger.getLogger(SnowflakeV2ConnectInfoAdapter.class.getName());

	static {
		/**
         * Configures logger to output to a file.
         * Two System parameters:
         * - com.snowflake.connector.informatica.logging.level:    Log Level
         * - com.snowflake.connector.informatica.logging.filename: Log file name
         */
		String userLogLevel = System.getProperty(
				SYSTEM_PROPERTY_NAMESPACE + "logging.level");
		if (userLogLevel != null) {
			Level logLevel = null;
			try {
				logLevel = Level.parse(userLogLevel);
			} catch (IllegalArgumentException|NullPointerException e) {
				e.printStackTrace();
				// fallback to the default log level
				logLevel = DEFAULT_LOG_LEVEL;
			}
			final String[] nameSpaces = new String[] {
					JDBC_NAMESPACE,
					CONNECTOR_NAMESPACE};
			for (String nameSpace: nameSpaces) {
				Logger logger = Logger.getLogger(nameSpace);	
				logger.setLevel(logLevel);
	
				try {
					String logFileName = System.getProperty(
							SYSTEM_PROPERTY_NAMESPACE + "logging.filename",
							"%t/V2SnowflakeConnectorInformatica%u.%g.log");
		        	FileHandler fileHandler = new FileHandler(logFileName);
		        	fileHandler.setLevel(logLevel);
		        	fileHandler.setFormatter(new SimpleFormatter());
		        	logger.addHandler(fileHandler);
				} catch (SecurityException|IOException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
			// set the same log level to JDBC driver
			System.setProperty("snowflake.jdbc.log.level", userLogLevel);
		}
    }

	/**
	 * Validates the connection attributes of an adapter.
	 *
	 * Use this method to validate the values for the attributes of an adapter
	 * and to perform validation that is specific to an adapter.
	 *
	 * @param attrNameValmap
	 *            The attribute name and corresponding value map for all
	 *            attributes of an adapter.
	 *
	 * @return An error key and value for attribute the errors found during
	 *         attribute validation.
	 */
	@Override
	public SDKErrorInfo validateAttributes(Map<String, Object> attrNameValmap) {
		if (LOGGER.isLoggable(Level.FINER)) {
			Map<String, Object> tmpConnAttrs = new HashMap<>(attrNameValmap);
			if (tmpConnAttrs.containsKey("password")) {
				tmpConnAttrs.remove("password");
			}
			LOGGER.finer(String.format("AttrNameVal: %s", tmpConnAttrs));
		}
		String user = (String) attrNameValmap.get("user");
		if (null == user || "".equalsIgnoreCase(user.trim())) {
			ExceptionManager.createNlsAdapterSDKException(
					MessageBundle.getInstance(),
					Messages.SnowflakeV2_EMPTY_USER_900);
		}
		
		String password = (String) attrNameValmap.get("password");
		if (null == password || "".equalsIgnoreCase(password.trim())) {
			ExceptionManager.createNlsAdapterSDKException(
					MessageBundle.getInstance(),
					Messages.SnowflakeV2_EMPTY_PASSWORD_901);
		}
		
		String account = (String) attrNameValmap.get("account");
		if (null == account || "".equalsIgnoreCase(account.trim())) {
			ExceptionManager.createNlsAdapterSDKException(
					MessageBundle.getInstance(),
					Messages.SnowflakeV2_EMPTY_ACCOUNT_905);
		}
			
		return null;
	}

	/**
	 * Gets the list of objects for the wizard pages which appears in the client
	 * application that uses the adapter.
	 * 
	 * Use this method to provide the list of objects that appears in the client
	 * application. The pages, groups, and attributes appears based on the type
	 * of consumer application that uses the adapter. You must provide the
	 * corresponding properties file.
	 * 
	 * @param consumerType
	 *            The client application that use the adapter.
	 * @param map
	 *            A map containing the attribute name as keys and corresponding
	 *            values as objects.
	 * 
	 * @return A list of the objects to be included in the client application
	 *         that uses the adapter.
	 */
	@Override
	public List<Object> getConnectInfoUpdatedConsumerInfo(
			Map<String, Object> map, SDKConsumerTypeEnum consumerType) {
		LOGGER.finer(String.format("Map: %s, ConsumerType: %s", map, consumerType));
		ArrayList<Object> newAttributes = new ArrayList<>();
		
		String account = (String) map.get("account");
		String user = (String) map.get("user");
		String password = (String) map.get("password");
		String warehouse = (String) map.get("warehouse");
		String db = (String) map.get("db");
		String schema = (String) map.get("schema");
		String role = (String) map.get("role");

		SDKConnectionConsumerAttribute accountNew = createAttributePresentation(
				"account", "ACCOUNT", "ACCOUNT_TOOLTIP", true, false, true);
		SDKConnectionConsumerAttribute userNew = createAttributePresentation(
				"user", "USER", "USER_TOOLTIP", true, false, true);
		SDKConnectionConsumerAttribute passwordNew = createAttributePresentation(
				"password", "PASSWORD", "PASSWORD_TOOLTIP", true, false, true);
		SDKConnectionConsumerAttribute warehouseNew = createAttributePresentation(
				"warehouse", "WAREHOUSE", "WAREHOUSE_TOOLTIP", true, false, true);
		SDKConnectionConsumerAttribute dbNew = createAttributePresentation(
				"db", "DB", "DB_TOOLTIP", true, false, true);
		SDKConnectionConsumerAttribute schemaNew = createAttributePresentation(
				"schema", "SCHEMA", "SCHEMA_TOOLTIP", true, false, true);
		SDKConnectionConsumerAttribute roleNew = createAttributePresentation(
				"role", "ROLE", "ROLE_TOOLTIP", true, false, false);

		accountNew.getAttributeType().setAttributeValue(account);
		newAttributes.add(accountNew);

		userNew.getAttributeType().setAttributeValue(user);
		newAttributes.add(userNew);

		passwordNew.getAttributeType().setAttributeValue(password);
		newAttributes.add(passwordNew);

		warehouseNew.getAttributeType().setAttributeValue(warehouse);
		newAttributes.add(warehouseNew);

		dbNew.getAttributeType().setAttributeValue(db);
		newAttributes.add(dbNew);

		schemaNew.getAttributeType().setAttributeValue(schema);
		newAttributes.add(schemaNew);

		roleNew.getAttributeType().setAttributeValue(role);
		newAttributes.add(roleNew);

		return newAttributes;
	}

}