package com.unicosolution.adapter.snowflakev2.connection.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.informatica.sdk.adapter.connection.SDKConnectionConsumerAttribute;
import com.informatica.sdk.adapter.connection.SDKConsumerTypeEnum;
import com.informatica.sdk.adapter.connection.SDKErrorInfo;
import com.informatica.sdk.exceptions.ExceptionManager;
import com.unicosolution.adapter.snowflakev2.designmessages.MessageBundle;
import com.unicosolution.adapter.snowflakev2.designmessages.Messages;

public class SnowflakeV2ConnectInfoAdapter extends SnowflakeV2BaseConnectInfoAdapter  {

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

		String user = (String) attrNameValmap.get("user");
		if (null == user || "".equalsIgnoreCase(user.trim())) {
			ExceptionManager.createNlsAdapterSDKException(
					MessageBundle.getInstance(),
					Messages.EMPTY_USER_900);
		}
		
		String password = (String) attrNameValmap.get("password");
		if (null == password || "".equalsIgnoreCase(password.trim())) {
			ExceptionManager.createNlsAdapterSDKException(
					MessageBundle.getInstance(),
					Messages.EMPTY_PASSWORD_901);
		}
		
		String db = (String) attrNameValmap.get("db");
		if (null == db || "".equalsIgnoreCase(db.trim())) {
			ExceptionManager.createNlsAdapterSDKException(
					MessageBundle.getInstance(),
					Messages.EMPTY_DB_902);
		}
		
		String schema = (String) attrNameValmap.get("schema");
		if (null == schema || "".equalsIgnoreCase(schema.trim())) {
			ExceptionManager.createNlsAdapterSDKException(
					MessageBundle.getInstance(),
					Messages.EMPTY_SCHEMA_903);
		}
		
		String warehouse = (String) attrNameValmap.get("warehouse");
		if (null == warehouse || "".equalsIgnoreCase(warehouse.trim())) {
			ExceptionManager.createNlsAdapterSDKException(
					MessageBundle.getInstance(),
					Messages.EMPTY_WAREHOUSE_904);
		}
		
		String account = (String) attrNameValmap.get("account");
		if (null == account || "".equalsIgnoreCase(account.trim())) {
			ExceptionManager.createNlsAdapterSDKException(
					MessageBundle.getInstance(),
					Messages.EMPTY_ACCOUNT_905);
		}

		/*String pCode = (String) attrNameValmap.get("passcode");
		if (null != pCode && pCode.length() > 25) {
			ExceptionManager.createNlsAdapterSDKException(
					MessageBundle.getInstance(),
					Messages.INVALID_PASSCODE_905);
		}*/
			
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

		ArrayList<Object> newAttributes = new ArrayList<>();

		String account = (String) map.get("account");
		String user = (String) map.get("user");
		String password = (String) map.get("password");
		String warehouse = (String) map.get("warehouse");
		String db = (String) map.get("db");
		String schema = (String) map.get("schema");
		String authenticator = (String) map.get("authenticator");
		String role = (String) map.get("role");
		String tracing = (String) map.get("tracing");
		String passcode = (String) map.get("passcode");
		boolean passcodeInPassword = (boolean) map.get("passcodeInPassword");

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
		SDKConnectionConsumerAttribute authenticatorNew = createAttributePresentation(
				"authenticator", "AUTHENTICATOR", "AUTHENTICATOR_TOOLTIP", true, false, false);
		SDKConnectionConsumerAttribute roleNew = createAttributePresentation(
				"role", "ROLE", "ROLE_TOOLTIP", true, false, false);
		SDKConnectionConsumerAttribute tracingNew = createAttributePresentation(
				"tracing", "TRACING", "TRACING_TOOLTIP", true, false, false);
		SDKConnectionConsumerAttribute passcodeNew = createAttributePresentation(
				"passcode", "PASSCODE", "PASSCODE_TOOLTIP", true, false, false);
		SDKConnectionConsumerAttribute passcodeInPasswordNew = createAttributePresentation(
				"passcodeInPassword", "PASSCODE IN PASSWORD", "PASSCODEINPASSWORD_TOOLTIP", true, false, true);

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

		authenticatorNew.getAttributeType().setAttributeValue(authenticator);
		newAttributes.add(authenticatorNew);

		roleNew.getAttributeType().setAttributeValue(role);
		newAttributes.add(roleNew);

		tracingNew.getAttributeType().setAttributeValue(tracing);
		newAttributes.add(tracingNew);

		passcodeNew.getAttributeType().setAttributeValue(passcode);
		newAttributes.add(passcodeNew);

		passcodeInPasswordNew.getAttributeType().setAttributeValue(passcodeInPassword);
		newAttributes.add(passcodeInPasswordNew);

		return newAttributes;
	}

}