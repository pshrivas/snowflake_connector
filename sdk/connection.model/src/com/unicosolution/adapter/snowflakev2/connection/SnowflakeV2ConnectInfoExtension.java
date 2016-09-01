/*
 * Copyright (c) 2016 Informatica Corporation. All rights reserved.
 */

/*
 * This file is generated. Do not modify.
 * IMF Version: 9.5.0
 * Generation time: 2016-08-29 17:39:10
 */

package com.unicosolution.adapter.snowflakev2.connection;


/**
 * The interface for IClass
 *     'SnowflakeV2ConnectInfoExtension'.
 * 
 * <p><br>
 * <b>Thread-Safety</b>
 * <p>
 * <strong>Note that this interface is not thread-safe.</strong> If multiple
 * threads access an instance of this interface concurrently, it must be
 * synchronized externally.</p>
 * </br></p>
 * <p>
 * The following features (Attributes/references) are supported:
 * <ul>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#getSSL() <em>SSL</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#getAccount() <em>account</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#getAuthenticator() <em>authenticator</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#getClientSessionKeepAlive() <em>clientSessionKeepAlive</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#getCustomURL() <em>customURL</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#getDb() <em>db</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#getPasscode() <em>passcode</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#isPasscodeInPassword() <em>passcodeInPassword</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#getPassword() <em>password</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#getPort() <em>port</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#getRole() <em>role</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#getSchema() <em>schema</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#getTracing() <em>tracing</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#isUseCustomURL() <em>useCustomURL</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#getUser() <em>user</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#getWarehouse() <em>warehouse</em>} </li>
 * </ul>
 * </p>
 * @Class (isSeeded=false, classKind=com.informatica.imf.annotations.ClassKind.SECOND_CLASS_INTERNAL, isAbstract=false)
 */
 public interface SnowflakeV2ConnectInfoExtension extends com.informatica.metadata.infasdk.connectinfo.common.sdkmodelextension.SDKConnectInfoModelExtension {

    /** A constant that references the IClass for this generated Java Class. */
    com.informatica.imf.icore.IClass ICLASS = ConnectionIPackage.I_INSTANCE.getSnowflakeV2ConnectInfoExtensionIClass();
    /**
     * Retrieves the 'SSL' property value for this IObject.
     * @return the 'SSL' property value for this IObject.
     * @Property (redefines="", minOccurs=0, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    java.lang.String getSSL();


    /**
     * Sets the 'SSL' property value for this IObject.
     * @param aSSL is the new property value for this IObject
     * @see #getSSL
     */
    void setSSL(java.lang.String aSSL);


    /**
     * Retrieves the 'account' property value for this IObject.
     * @return the 'account' property value for this IObject.
     * @Property (redefines="", minOccurs=1, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    java.lang.String getAccount();


    /**
     * Sets the 'account' property value for this IObject.
     * @param account is the new property value for this IObject
     * @see #getAccount
     */
    void setAccount(java.lang.String account);


    /**
     * Retrieves the 'authenticator' property value for this IObject.
     * @return the 'authenticator' property value for this IObject.
     * @Property (redefines="", minOccurs=0, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    java.lang.String getAuthenticator();


    /**
     * Sets the 'authenticator' property value for this IObject.
     * @param authenticator is the new property value for this IObject
     * @see #getAuthenticator
     */
    void setAuthenticator(java.lang.String authenticator);


    /**
     * Retrieves the 'clientSessionKeepAlive' property value for this IObject.
     * @return the 'clientSessionKeepAlive' property value for this IObject.
     * @Property (redefines="", minOccurs=0, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    java.lang.String getClientSessionKeepAlive();


    /**
     * Sets the 'clientSessionKeepAlive' property value for this IObject.
     * @param clientSessionKeepAlive is the new property value for this IObject
     * @see #getClientSessionKeepAlive
     */
    void setClientSessionKeepAlive(java.lang.String clientSessionKeepAlive);


    /**
     * Retrieves the 'customURL' property value for this IObject.
     * @return the 'customURL' property value for this IObject.
     * @Property (redefines="", minOccurs=0, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    java.lang.String getCustomURL();


    /**
     * Sets the 'customURL' property value for this IObject.
     * @param customURL is the new property value for this IObject
     * @see #getCustomURL
     */
    void setCustomURL(java.lang.String customURL);


    /**
     * Retrieves the 'db' property value for this IObject.
     * @return the 'db' property value for this IObject.
     * @Property (redefines="", minOccurs=1, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    java.lang.String getDb();


    /**
     * Sets the 'db' property value for this IObject.
     * @param db is the new property value for this IObject
     * @see #getDb
     */
    void setDb(java.lang.String db);


    /**
     * Retrieves the 'passcode' property value for this IObject.
     * @return the 'passcode' property value for this IObject.
     * @Property (redefines="", minOccurs=0, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    java.lang.String getPasscode();


    /**
     * Sets the 'passcode' property value for this IObject.
     * @param passcode is the new property value for this IObject
     * @see #getPasscode
     */
    void setPasscode(java.lang.String passcode);


    /**
     * Retrieves the 'passcodeInPassword' property value for this IObject.
     * @return the 'passcodeInPassword' property value for this IObject.
     * @Property (redefines="", minOccurs=1, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    boolean isPasscodeInPassword();


    /**
     * Sets the 'passcodeInPassword' property value for this IObject.
     * @param passcodeInPassword is the new property value for this IObject
     * @see #getPasscodeInPassword
     */
    void setPasscodeInPassword(boolean passcodeInPassword);


    /**
     * Retrieves the 'password' property value for this IObject.
     * @return the 'password' property value for this IObject.
     * @Property (redefines="", minOccurs=1, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    java.lang.String getPassword();

    /**
     * Retrieves the 'password' property value for this IObject.
     * @param encrypted
     *			boolean indicating if the return value must be encrypted or not
     * @return the 'password' property value for this IObject.
     * @Property (redefines="", minOccurs=1, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    java.lang.String getPassword(boolean encrypted);

    /**
     * Sets the 'password' property value for this IObject.
     * @param password is the new property value for this IObject
     * @see #getPassword
     */
    void setPassword(java.lang.String password);

    /**
     * Sets the 'password' property value for this IObject.
     * @param password is the new property value for this IObject
     * @param encrypted boolean indicating if the String argument is already encrypted or not
     * @see #getPassword
     */
    void setPassword(java.lang.String password, boolean encrypted);

    /**
     * Retrieves the 'port' property value for this IObject.
     * @return the 'port' property value for this IObject.
     * @Property (redefines="", minOccurs=0, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    java.lang.String getPort();


    /**
     * Sets the 'port' property value for this IObject.
     * @param port is the new property value for this IObject
     * @see #getPort
     */
    void setPort(java.lang.String port);


    /**
     * Retrieves the 'role' property value for this IObject.
     * @return the 'role' property value for this IObject.
     * @Property (redefines="", minOccurs=0, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    java.lang.String getRole();


    /**
     * Sets the 'role' property value for this IObject.
     * @param role is the new property value for this IObject
     * @see #getRole
     */
    void setRole(java.lang.String role);


    /**
     * Retrieves the 'schema' property value for this IObject.
     * @return the 'schema' property value for this IObject.
     * @Property (redefines="", minOccurs=0, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    java.lang.String getSchema();


    /**
     * Sets the 'schema' property value for this IObject.
     * @param schema is the new property value for this IObject
     * @see #getSchema
     */
    void setSchema(java.lang.String schema);


    /**
     * Retrieves the 'tracing' property value for this IObject.
     * @return the 'tracing' property value for this IObject.
     * @Property (redefines="", minOccurs=0, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    java.lang.String getTracing();


    /**
     * Sets the 'tracing' property value for this IObject.
     * @param tracing is the new property value for this IObject
     * @see #getTracing
     */
    void setTracing(java.lang.String tracing);


    /**
     * Retrieves the 'useCustomURL' property value for this IObject.
     * @return the 'useCustomURL' property value for this IObject.
     * @Property (redefines="", minOccurs=1, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    boolean isUseCustomURL();


    /**
     * Sets the 'useCustomURL' property value for this IObject.
     * @param useCustomURL is the new property value for this IObject
     * @see #getUseCustomURL
     */
    void setUseCustomURL(boolean useCustomURL);


    /**
     * Retrieves the 'user' property value for this IObject.
     * @return the 'user' property value for this IObject.
     * @Property (redefines="", minOccurs=1, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    java.lang.String getUser();


    /**
     * Sets the 'user' property value for this IObject.
     * @param user is the new property value for this IObject
     * @see #getUser
     */
    void setUser(java.lang.String user);


    /**
     * Retrieves the 'warehouse' property value for this IObject.
     * @return the 'warehouse' property value for this IObject.
     * @Property (redefines="", minOccurs=1, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    java.lang.String getWarehouse();


    /**
     * Sets the 'warehouse' property value for this IObject.
     * @param warehouse is the new property value for this IObject
     * @see #getWarehouse
     */
    void setWarehouse(java.lang.String warehouse);

    /**
     * Exposes the IProperties of the IClass associated with this Object
     */
    static class Properties {

        public static com.informatica.imf.icore.IProperty S_S_L = null;

        public static com.informatica.imf.icore.IProperty ACCOUNT = null;

        public static com.informatica.imf.icore.IProperty AUTHENTICATOR = null;

        public static com.informatica.imf.icore.IProperty CLIENT_SESSION_KEEP_ALIVE = null;

        public static com.informatica.imf.icore.IProperty CUSTOM_U_R_L = null;

        public static com.informatica.imf.icore.IProperty DB = null;

        public static com.informatica.imf.icore.IProperty PASSCODE = null;

        public static com.informatica.imf.icore.IProperty PASSCODE_IN_PASSWORD = null;

        public static com.informatica.imf.icore.IProperty PASSWORD = null;

        public static com.informatica.imf.icore.IProperty PORT = null;

        public static com.informatica.imf.icore.IProperty ROLE = null;

        public static com.informatica.imf.icore.IProperty SCHEMA = null;

        public static com.informatica.imf.icore.IProperty TRACING = null;

        public static com.informatica.imf.icore.IProperty USE_CUSTOM_U_R_L = null;

        public static com.informatica.imf.icore.IProperty USER = null;

        public static com.informatica.imf.icore.IProperty WAREHOUSE = null;
        static  {
			com.unicosolution.adapter.snowflakev2.connection.impl.SnowflakeV2ConnectInfoExtensionImpl.initIProperties();
		}
    }
 }