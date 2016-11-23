/*
 * Copyright (c) 2016 Informatica Corporation. All rights reserved.
 */

/*
 * This file is generated. Do not modify.
 * IMF Version: 9.5.0
 * Generation time: 2016-11-22 20:37:13
 */
package com.unicosolution.adapter.snowflakev2.connection.impl;

/**
 * The implementation for an SnowflakeV2ConnectInfoExtension.
 *
 */
public class SnowflakeV2ConnectInfoExtensionImpl
extends com.informatica.metadata.infasdk.connectinfo.common.sdkmodelextension.impl.SDKConnectInfoModelExtensionImpl
implements com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension {
    /**
     * The generated Serial Version UID.
     */
    private static final long serialVersionUID = 3167186841041590970L;

    private static int PROPERTY_ID;

    protected java.lang.String account = "";

    protected boolean clientSessionKeepAlive = true;

    private static final String DEFAULT_CUSTOMURL = "jdbc:snowflake://";

    protected java.lang.String customURL = DEFAULT_CUSTOMURL;

    protected java.lang.String db = "";

    protected java.lang.String password = "";

    protected java.lang.String role = "";

    protected java.lang.String schema = "";

    protected boolean useCustomURL = false;

    protected java.lang.String user = "";

    protected java.lang.String warehouse = "";


    /**
     * Default constructor for SnowflakeV2ConnectInfoExtensionImpl.
     */
    public SnowflakeV2ConnectInfoExtensionImpl() {
        assert iObjInfo != null;
        iSetIClass(com.unicosolution.adapter.snowflakev2.connection.ConnectionIPackage.I_INSTANCE
                .getSnowflakeV2ConnectInfoExtensionIClass());
    }


     /**
     * Retrieves the 'account' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#getAccount()
     * @return the 'account' property value for this Object
     */
     public java.lang.String getAccount() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.account;
     }

    /**
     * Sets the 'account' property value for this IObject.
     * If a <code>null</code> is specified as the value for this property,
     * the default value of the String, i.e., empty string('""') will be set.
     * @see com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#setAccount(java.lang.String account)
     * @param account is the new value for property 'account'
     */public void setAccount(java.lang.String account) {
    		if(this.account.equals(account)) {
    			return;
    		}

    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            java.lang.String oldVal = this.account;
            if(account == null) {
                account = "";
            }
            this.account = account;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.ACCOUNT, oldVal, account);
            }
        }
     


     /**
     * Retrieves the 'clientSessionKeepAlive' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#isClientSessionKeepAlive()
     * @return the 'clientSessionKeepAlive' property value for this Object
     */
     public boolean isClientSessionKeepAlive() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.clientSessionKeepAlive;
     }

    /**
     * Sets the 'clientSessionKeepAlive' property value for this IObject.
     * @see com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#setClientSessionKeepAlive(boolean clientSessionKeepAlive)
     * @param clientSessionKeepAlive is the new value for property 'clientSessionKeepAlive'
     */public void setClientSessionKeepAlive(boolean clientSessionKeepAlive) {
    		if(this.clientSessionKeepAlive == clientSessionKeepAlive) {
    			return;
    		}
    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            boolean oldVal = this.clientSessionKeepAlive;
            this.clientSessionKeepAlive = clientSessionKeepAlive;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.CLIENT_SESSION_KEEP_ALIVE, oldVal, clientSessionKeepAlive);
            }
        }
     


     /**
     * Retrieves the 'customURL' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#getCustomURL()
     * @return the 'customURL' property value for this Object
     */
     public java.lang.String getCustomURL() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.customURL;
     }

    /**
     * Sets the 'customURL' property value for this IObject.
     * If a <code>null</code> is specified as the value for this property,
     * the default value of the String, i.e., empty string('""') will be set.
     * @see com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#setCustomURL(java.lang.String customURL)
     * @param customURL is the new value for property 'customURL'
     */public void setCustomURL(java.lang.String customURL) {
    		if(this.customURL.equals(customURL)) {
    			return;
    		}

    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            java.lang.String oldVal = this.customURL;
            if(customURL == null) {
                customURL = "";
            }
            this.customURL = customURL;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.CUSTOM_U_R_L, oldVal, customURL);
            }
        }
     


     /**
     * Retrieves the 'db' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#getDb()
     * @return the 'db' property value for this Object
     */
     public java.lang.String getDb() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.db;
     }

    /**
     * Sets the 'db' property value for this IObject.
     * If a <code>null</code> is specified as the value for this property,
     * the default value of the String, i.e., empty string('""') will be set.
     * @see com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#setDb(java.lang.String db)
     * @param db is the new value for property 'db'
     */public void setDb(java.lang.String db) {
    		if(this.db.equals(db)) {
    			return;
    		}

    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            java.lang.String oldVal = this.db;
            if(db == null) {
                db = "";
            }
            this.db = db;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.DB, oldVal, db);
            }
        }
     


     /**
     * Retrieves the 'password' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#getPassword()
     * @return the 'password' property value for this Object
     */
     public java.lang.String getPassword() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return decrypt(this.password,com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.PASSWORD, this);
     }

    /**
     * Sets the 'password' property value for this IObject.
     * If a <code>null</code> is specified as the value for this property,
     * the default value of the String, i.e., empty string('""') will be set.
     * @see com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#setPassword(java.lang.String password)
     * @param password is the new value for property 'password'
     */public void setPassword(java.lang.String password) {

    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            java.lang.String oldVal = decrypt(this.password, com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.PASSWORD, this);
    		if(oldVal.equals(password)) {
    			return;
    		}
            if(password == null) {
                password = "";
            }
            this.password = encrypt(password, com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.PASSWORD, this);
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.PASSWORD, oldVal, password);
            }
        }
     

    /**
     * Retrieves the 'password'  property value for this IObject.
     * @param encrypted
     *			boolean indicating if the return value must be encrypted or not
     * @return the 'password'  property value for this IObject.
     * @Property (redefines="", minOccurs=1, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    	public java.lang.String getPassword(boolean encrypted) {

    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
    		if(encrypted) {
    			return this.password;
    		}
    		return decrypt(this.password, com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.PASSWORD, this);
    	}

    /**
     * Sets the 'password' property value for this IObject.
     * @param password' is the new property value for this IObject
     * @param encrypted boolean indicating if the String argument is already encrypted or not
     * @see #getPassword
     */
    	public void setPassword(java.lang.String password, boolean encrypted) {
    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
    		if(encrypted && (this.password.equals(password))) {
    			return;
    		}
    		java.lang.String oldVal = decrypt(this.password, com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.PASSWORD, this);
    		if(!encrypted && (oldVal.equals(password))) {
    			return;
    		}
    		if(password == null) {
    			password = "";
    		}
    		if(encrypted) {
    			this.password = password;
    		} else {
    			this.password = encrypt(password, com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.PASSWORD, this);
    		}
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.PASSWORD, oldVal, password);
            }
    	}


     /**
     * Retrieves the 'role' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#getRole()
     * @return the 'role' property value for this Object
     */
     public java.lang.String getRole() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.role;
     }

    /**
     * Sets the 'role' property value for this IObject.
     * If a <code>null</code> is specified as the value for this property,
     * the default value of the String, i.e., empty string('""') will be set.
     * @see com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#setRole(java.lang.String role)
     * @param role is the new value for property 'role'
     */public void setRole(java.lang.String role) {
    		if(this.role.equals(role)) {
    			return;
    		}

    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            java.lang.String oldVal = this.role;
            if(role == null) {
                role = "";
            }
            this.role = role;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.ROLE, oldVal, role);
            }
        }
     


     /**
     * Retrieves the 'schema' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#getSchema()
     * @return the 'schema' property value for this Object
     */
     public java.lang.String getSchema() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.schema;
     }

    /**
     * Sets the 'schema' property value for this IObject.
     * If a <code>null</code> is specified as the value for this property,
     * the default value of the String, i.e., empty string('""') will be set.
     * @see com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#setSchema(java.lang.String schema)
     * @param schema is the new value for property 'schema'
     */public void setSchema(java.lang.String schema) {
    		if(this.schema.equals(schema)) {
    			return;
    		}

    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            java.lang.String oldVal = this.schema;
            if(schema == null) {
                schema = "";
            }
            this.schema = schema;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.SCHEMA, oldVal, schema);
            }
        }
     


     /**
     * Retrieves the 'useCustomURL' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#isUseCustomURL()
     * @return the 'useCustomURL' property value for this Object
     */
     public boolean isUseCustomURL() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.useCustomURL;
     }

    /**
     * Sets the 'useCustomURL' property value for this IObject.
     * @see com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#setUseCustomURL(boolean useCustomURL)
     * @param useCustomURL is the new value for property 'useCustomURL'
     */public void setUseCustomURL(boolean useCustomURL) {
    		if(this.useCustomURL == useCustomURL) {
    			return;
    		}
    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            boolean oldVal = this.useCustomURL;
            this.useCustomURL = useCustomURL;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.USE_CUSTOM_U_R_L, oldVal, useCustomURL);
            }
        }
     


     /**
     * Retrieves the 'user' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#getUser()
     * @return the 'user' property value for this Object
     */
     public java.lang.String getUser() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.user;
     }

    /**
     * Sets the 'user' property value for this IObject.
     * If a <code>null</code> is specified as the value for this property,
     * the default value of the String, i.e., empty string('""') will be set.
     * @see com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#setUser(java.lang.String user)
     * @param user is the new value for property 'user'
     */public void setUser(java.lang.String user) {
    		if(this.user.equals(user)) {
    			return;
    		}

    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            java.lang.String oldVal = this.user;
            if(user == null) {
                user = "";
            }
            this.user = user;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.USER, oldVal, user);
            }
        }
     


     /**
     * Retrieves the 'warehouse' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#getWarehouse()
     * @return the 'warehouse' property value for this Object
     */
     public java.lang.String getWarehouse() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.warehouse;
     }

    /**
     * Sets the 'warehouse' property value for this IObject.
     * If a <code>null</code> is specified as the value for this property,
     * the default value of the String, i.e., empty string('""') will be set.
     * @see com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension#setWarehouse(java.lang.String warehouse)
     * @param warehouse is the new value for property 'warehouse'
     */public void setWarehouse(java.lang.String warehouse) {
    		if(this.warehouse.equals(warehouse)) {
    			return;
    		}

    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            java.lang.String oldVal = this.warehouse;
            if(warehouse == null) {
                warehouse = "";
            }
            this.warehouse = warehouse;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.WAREHOUSE, oldVal, warehouse);
            }
        }
     



    /**
     * Returns the value of the specified IProperty.
     * @param iProperty is any IProperty
     * @return the value of the specified property
     *
     */

    @SuppressWarnings("unchecked")
    @Override
    public java.lang.Object iGet(com.informatica.imf.icore.IProperty iProperty) {
    	if(!this.iGetIClass().containsIProperty(iProperty)) {
    		throw new com.informatica.core.exception.IllegalArgumentException(
                    com.informatica.imf.ImfMsg.COULD_NOT_RETRIEVE_PROPERTY_property_FOR_CLASS_class,
                    iProperty.getName(),
                    this.iGetIClass().getQualifiedName());
    	}
    	int propertyId= ((com.informatica.imf.icore.internal.IPropertyInternal) iProperty).getPropertyId();
    	if( propertyId <com.informatica.metadata.infasdk.connectinfo.common.sdkmodelextension.impl.SdkmodelextensionIPackageImpl.getS_D_K_CONNECT_INFO_MODEL_EXTENSIONFeatureCount())
    	return super.iGet(iProperty);
    	else
    	switch (((com.informatica.imf.icore.internal.IPropertyInternal) iProperty).getQualifiedName()){
        case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.account":
            return this.getAccount();
        case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.clientSessionKeepAlive":
            return this.isClientSessionKeepAlive();
        case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.customURL":
            return this.getCustomURL();
        case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.db":
            return this.getDb();
        case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.password":
            return this.getPassword();
        case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.role":
            return this.getRole();
        case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.schema":
            return this.getSchema();
        case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.useCustomURL":
            return this.isUseCustomURL();
        case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.user":
            return this.getUser();
        case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.warehouse":
            return this.getWarehouse();
        default:
                throw new com.informatica.core.exception.IllegalArgumentException(
                    com.informatica.imf.ImfMsg.COULD_NOT_RETRIEVE_PROPERTY_property_FOR_CLASS_class,
                    iProperty.getName(),
                    this.iGetIClass());
        }
    }

    /**
     * Returns the value of the specified IProperty.
     * @param iProperty is any IProperty
     * @param encrypted indicates if the returned string value needs to be
     * 			encrypted. Applicable only to string properties.
     * @return the value of the specified property
     */
    @SuppressWarnings("unchecked")
    @Override
    public java.lang.Object iGet(com.informatica.imf.icore.IProperty iProperty,
    							boolean encrypted) {
    	if(!this.iGetIClass().containsIProperty(iProperty)) {
    		throw new com.informatica.core.exception.IllegalArgumentException(
                    com.informatica.imf.ImfMsg.COULD_NOT_RETRIEVE_PROPERTY_property_FOR_CLASS_class,
                    iProperty.getName(),
                    this.iGetIClass().getQualifiedName());
    	}
    	int propertyId= ((com.informatica.imf.icore.internal.IPropertyInternal) iProperty).getPropertyId();
    	if( propertyId <com.informatica.metadata.infasdk.connectinfo.common.sdkmodelextension.impl.SdkmodelextensionIPackageImpl.getS_D_K_CONNECT_INFO_MODEL_EXTENSIONFeatureCount())
    	return super.iGet(iProperty,encrypted);
    	else
    	switch (((com.informatica.imf.icore.internal.IPropertyInternal) iProperty).getQualifiedName()){
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.account":
                return this.getAccount();
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.clientSessionKeepAlive":
                return this.isClientSessionKeepAlive();
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.customURL":
                return this.getCustomURL();
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.db":
                return this.getDb();
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.password":
                return this.getPassword(encrypted);
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.role":
                return this.getRole();
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.schema":
                return this.getSchema();
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.useCustomURL":
                return this.isUseCustomURL();
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.user":
                return this.getUser();
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.warehouse":
                return this.getWarehouse();
            default:
                   throw new com.informatica.core.exception.IllegalArgumentException(
                       com.informatica.imf.ImfMsg.COULD_NOT_RETRIEVE_PROPERTY_property_FOR_CLASS_class,
                       iProperty.getName(),
                       this.iGetIClass());
        }
    }

    /**
     * Returns true if the specified collection has items in it.
     * @param iProperty is any IProperty
     * @return true if the specified collection has items in it.
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean iHasItems(com.informatica.imf.icore.IProperty iProperty) {
        if(!this.iGetIClass().containsIProperty(iProperty)) {
            throw new com.informatica.core.exception.IllegalArgumentException(
                  com.informatica.imf.ImfMsg.COULD_NOT_RETRIEVE_PROPERTY_property_FOR_CLASS_class,
                  iProperty.getName(),
                  this.iGetIClass().getQualifiedName());
        }
        if (iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                    com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
              }
        }
    	int propertyId= ((com.informatica.imf.icore.internal.IPropertyInternal) iProperty).getPropertyId();
    	if( propertyId <com.informatica.metadata.infasdk.connectinfo.common.sdkmodelextension.impl.SdkmodelextensionIPackageImpl.getS_D_K_CONNECT_INFO_MODEL_EXTENSIONFeatureCount())
    	return super.iHasItems(iProperty);
    	else
        	switch (((com.informatica.imf.icore.internal.IPropertyInternal) iProperty).getQualifiedName()){
            default:
                    throw new com.informatica.core.exception.IllegalArgumentException(
                        com.informatica.imf.ImfMsg.ILLEGAL_INVOCATION_OF_HASITEMS_ON_NON_COLLECTION_PROPERTY_property_FOR_CLASS_class,
                        iProperty.getName(),
                        this.iGetIClass());
            }
        }

     /**
     * Sets the value of the specified IProperty.
     * @param iProperty is any IProperty
     * @param newValue is the new value for the specified IProperty
     *
     */
    @SuppressWarnings("unchecked")
    @Override
    public void iSet(com.informatica.imf.icore.IProperty iProperty, java.lang.Object newValue) {
    	if(!this.iGetIClass().containsIProperty(iProperty)) {
    		throw new com.informatica.core.exception.IllegalArgumentException(
                    com.informatica.imf.ImfMsg.COULD_NOT_RETRIEVE_PROPERTY_property_FOR_CLASS_class,
                    iProperty.getName(),
                    this.iGetIClass().getQualifiedName());
    	}
    	int propertyId= ((com.informatica.imf.icore.internal.IPropertyInternal) iProperty).getPropertyId();
    	if( propertyId <com.informatica.metadata.infasdk.connectinfo.common.sdkmodelextension.impl.SdkmodelextensionIPackageImpl.getS_D_K_CONNECT_INFO_MODEL_EXTENSIONFeatureCount())
    	super.iSet(iProperty,newValue);
    	else
        	switch (((com.informatica.imf.icore.internal.IPropertyInternal) iProperty).getQualifiedName()) {
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.account":
                this.setAccount((java.lang.String) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.clientSessionKeepAlive":

                if (newValue == null) {
                        throw new com.informatica.core.exception.IllegalArgumentException(
                               com.informatica.imf.ImfMsg.MANDATORY_PROPERTY_property_OF_class_CANNOT_BE_SET_TO_NULL,
                               iProperty.getName(),
                               this.iGetIClass());
                 }
                this.setClientSessionKeepAlive((java.lang.Boolean) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.customURL":
                this.setCustomURL((java.lang.String) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.db":
                this.setDb((java.lang.String) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.password":
                this.setPassword((java.lang.String) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.role":
                this.setRole((java.lang.String) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.schema":
                this.setSchema((java.lang.String) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.useCustomURL":

                if (newValue == null) {
                        throw new com.informatica.core.exception.IllegalArgumentException(
                               com.informatica.imf.ImfMsg.MANDATORY_PROPERTY_property_OF_class_CANNOT_BE_SET_TO_NULL,
                               iProperty.getName(),
                               this.iGetIClass());
                 }
                this.setUseCustomURL((java.lang.Boolean) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.user":
                this.setUser((java.lang.String) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.warehouse":
                this.setWarehouse((java.lang.String) newValue);
                break;
            default:
                  throw new com.informatica.core.exception.IllegalArgumentException(
                    com.informatica.imf.ImfMsg.COULD_NOT_SET_PROPERTY_property_FOR_CLASS_class,
                    iProperty.getName(),
                    this.iGetIClass());
            }
        }

    /**
     * Sets the value of the specified IProperty.
     * @param iProperty is any IProperty
     * @param newValue is the new value for the specified IProperty
     * @param encrypted boolean indicating if the value passed is already
     * 			encrypted or not.
     *
     */
    @SuppressWarnings("unchecked")
    @Override
    public void iSet(com.informatica.imf.icore.IProperty iProperty, java.lang.Object newValue
    	, boolean encrypted) {
    	if(!this.iGetIClass().containsIProperty(iProperty)) {
    		throw new com.informatica.core.exception.IllegalArgumentException(
                    com.informatica.imf.ImfMsg.COULD_NOT_RETRIEVE_PROPERTY_property_FOR_CLASS_class,
                    iProperty.getName(),
                    this.iGetIClass().getQualifiedName());
    	}
    	int propertyId= ((com.informatica.imf.icore.internal.IPropertyInternal) iProperty).getPropertyId();
    	if( propertyId <com.informatica.metadata.infasdk.connectinfo.common.sdkmodelextension.impl.SdkmodelextensionIPackageImpl.getS_D_K_CONNECT_INFO_MODEL_EXTENSIONFeatureCount())
    	super.iSet(iProperty,newValue,encrypted);
    	else
        	switch (((com.informatica.imf.icore.internal.IPropertyInternal) iProperty).getQualifiedName()){
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.account":
                this.setAccount((java.lang.String) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.clientSessionKeepAlive":

                if (newValue == null) {
                        throw new com.informatica.core.exception.IllegalArgumentException(
                               com.informatica.imf.ImfMsg.MANDATORY_PROPERTY_property_OF_class_CANNOT_BE_SET_TO_NULL,
                               iProperty.getName(),
                               this.iGetIClass());
                 }
                this.setClientSessionKeepAlive((java.lang.Boolean) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.customURL":
                this.setCustomURL((java.lang.String) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.db":
                this.setDb((java.lang.String) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.password":
                this.setPassword((java.lang.String) newValue, encrypted);
                break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.role":
                this.setRole((java.lang.String) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.schema":
                this.setSchema((java.lang.String) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.useCustomURL":

                if (newValue == null) {
                        throw new com.informatica.core.exception.IllegalArgumentException(
                               com.informatica.imf.ImfMsg.MANDATORY_PROPERTY_property_OF_class_CANNOT_BE_SET_TO_NULL,
                               iProperty.getName(),
                               this.iGetIClass());
                 }
                this.setUseCustomURL((java.lang.Boolean) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.user":
                this.setUser((java.lang.String) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.warehouse":
                this.setWarehouse((java.lang.String) newValue);
                break;
            default:
                  throw new com.informatica.core.exception.IllegalArgumentException(
                    com.informatica.imf.ImfMsg.COULD_NOT_SET_PROPERTY_property_FOR_CLASS_class,
                    iProperty.getName(),
                    this.iGetIClass());
        }
    }

    /**
     * Sets the value of the specified IProperty.
     * Note on setting collection property: Even though collection properties can be set using this method, it is to be
     * noted that the wrapped collections as such are not directly replaced instead, the core collection in the wrappers
     * are replaced using the passed wrappers core (i.e: lhs.setWrappedCollection(rhs.getWrappedCollection())
     * @param iProperty is any IProperty
     * @param newValue is the new value for the specified IProperty
     *
     */
    @SuppressWarnings("unchecked")
    @Override
    public void iInverseSet(com.informatica.imf.icore.IProperty iProperty, java.lang.Object newValue) {
    	if(!this.iGetIClass().containsIProperty(iProperty)) {
    		throw new com.informatica.core.exception.IllegalArgumentException(
                    com.informatica.imf.ImfMsg.COULD_NOT_RETRIEVE_PROPERTY_property_FOR_CLASS_class,
                    iProperty.getName(),
                    this.iGetIClass().getQualifiedName());
    	}
    	int propertyId= ((com.informatica.imf.icore.internal.IPropertyInternal) iProperty).getPropertyId();
    	if( propertyId <com.informatica.metadata.infasdk.connectinfo.common.sdkmodelextension.impl.SdkmodelextensionIPackageImpl.getS_D_K_CONNECT_INFO_MODEL_EXTENSIONFeatureCount())
    	super.iInverseSet(iProperty,newValue);
    	else
        	switch (((com.informatica.imf.icore.internal.IPropertyInternal) iProperty).getQualifiedName()) {
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.account":
               this.account = (java.lang.String) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.clientSessionKeepAlive":
               this.clientSessionKeepAlive = (java.lang.Boolean) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.customURL":
               this.customURL = (java.lang.String) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.db":
               this.db = (java.lang.String) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.password":
               this.password = (java.lang.String) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.role":
               this.role = (java.lang.String) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.schema":
               this.schema = (java.lang.String) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.useCustomURL":
               this.useCustomURL = (java.lang.Boolean) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.user":
               this.user = (java.lang.String) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.warehouse":
               this.warehouse = (java.lang.String) newValue;
               break;
            default:
                  throw new com.informatica.core.exception.IllegalArgumentException(
                      com.informatica.imf.ImfMsg.COULD_NOT_SET_PROPERTY_property_FOR_CLASS_class,
                      iProperty.getName(),
                      this.iGetIClass());
         }
    }


    /**
     * @see java.lang.Object#toString()
     * @generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension").append('[');
        sb.append(this.hashCode());
        sb.append(']');
        return sb.toString();
    }

    public static void initIProperties() {
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.connection.impl.ConnectionIPackageImpl.SNOWFLAKE_V2_CONNECT_INFO_EXTENSION__ACCOUNT;
        		com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.ACCOUNT =
        			com.unicosolution.adapter.snowflakev2.connection.ConnectionIPackage.I_INSTANCE.getSnowflakeV2ConnectInfoExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.connection.impl.ConnectionIPackageImpl.SNOWFLAKE_V2_CONNECT_INFO_EXTENSION__CLIENT_SESSION_KEEP_ALIVE;
        		com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.CLIENT_SESSION_KEEP_ALIVE =
        			com.unicosolution.adapter.snowflakev2.connection.ConnectionIPackage.I_INSTANCE.getSnowflakeV2ConnectInfoExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.connection.impl.ConnectionIPackageImpl.SNOWFLAKE_V2_CONNECT_INFO_EXTENSION__CUSTOM_U_R_L;
        		com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.CUSTOM_U_R_L =
        			com.unicosolution.adapter.snowflakev2.connection.ConnectionIPackage.I_INSTANCE.getSnowflakeV2ConnectInfoExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.connection.impl.ConnectionIPackageImpl.SNOWFLAKE_V2_CONNECT_INFO_EXTENSION__DB;
        		com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.DB =
        			com.unicosolution.adapter.snowflakev2.connection.ConnectionIPackage.I_INSTANCE.getSnowflakeV2ConnectInfoExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.connection.impl.ConnectionIPackageImpl.SNOWFLAKE_V2_CONNECT_INFO_EXTENSION__PASSWORD;
        		com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.PASSWORD =
        			com.unicosolution.adapter.snowflakev2.connection.ConnectionIPackage.I_INSTANCE.getSnowflakeV2ConnectInfoExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.connection.impl.ConnectionIPackageImpl.SNOWFLAKE_V2_CONNECT_INFO_EXTENSION__ROLE;
        		com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.ROLE =
        			com.unicosolution.adapter.snowflakev2.connection.ConnectionIPackage.I_INSTANCE.getSnowflakeV2ConnectInfoExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.connection.impl.ConnectionIPackageImpl.SNOWFLAKE_V2_CONNECT_INFO_EXTENSION__SCHEMA;
        		com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.SCHEMA =
        			com.unicosolution.adapter.snowflakev2.connection.ConnectionIPackage.I_INSTANCE.getSnowflakeV2ConnectInfoExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.connection.impl.ConnectionIPackageImpl.SNOWFLAKE_V2_CONNECT_INFO_EXTENSION__USE_CUSTOM_U_R_L;
        		com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.USE_CUSTOM_U_R_L =
        			com.unicosolution.adapter.snowflakev2.connection.ConnectionIPackage.I_INSTANCE.getSnowflakeV2ConnectInfoExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.connection.impl.ConnectionIPackageImpl.SNOWFLAKE_V2_CONNECT_INFO_EXTENSION__USER;
        		com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.USER =
        			com.unicosolution.adapter.snowflakev2.connection.ConnectionIPackage.I_INSTANCE.getSnowflakeV2ConnectInfoExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.connection.impl.ConnectionIPackageImpl.SNOWFLAKE_V2_CONNECT_INFO_EXTENSION__WAREHOUSE;
        		com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension.Properties.WAREHOUSE =
        			com.unicosolution.adapter.snowflakev2.connection.ConnectionIPackage.I_INSTANCE.getSnowflakeV2ConnectInfoExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
    }
}