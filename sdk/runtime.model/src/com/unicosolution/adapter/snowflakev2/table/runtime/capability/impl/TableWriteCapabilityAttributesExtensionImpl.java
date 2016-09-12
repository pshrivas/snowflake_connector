/*
 * Copyright (c) 2016 Informatica Corporation. All rights reserved.
 */

/*
 * This file is generated. Do not modify.
 * IMF Version: 9.5.0
 * Generation time: 2016-09-12 04:42:17
 */
package com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl;

/**
 * The implementation for an TableWriteCapabilityAttributesExtension.
 *
 */
public class TableWriteCapabilityAttributesExtensionImpl
extends com.informatica.adapter.sdkadapter.asoextension.impl.D_ModelExtensionWriteCapAttributesImpl
implements com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension {
    /**
     * The generated Serial Version UID.
     */
    private static final long serialVersionUID = -116467259375983265L;

    private static int PROPERTY_ID;

    protected boolean abortOnErrors = false;

    protected boolean bulkLoad = false;

    protected boolean oneBatch = false;

    protected java.lang.String postSql = "";

    protected com.informatica.metadata.common.parameter.Parameter postSql$;

    protected java.lang.String preSql = "";

    protected com.informatica.metadata.common.parameter.Parameter preSql$;

    protected boolean propagateData = false;

    protected boolean startTransactionForJobs = false;

    protected boolean truncateTargetTable = false;


    /**
     * Default constructor for TableWriteCapabilityAttributesExtensionImpl.
     */
    public TableWriteCapabilityAttributesExtensionImpl() {
        assert iObjInfo != null;
        iSetIClass(com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage.I_INSTANCE
                .getTableWriteCapabilityAttributesExtensionIClass());
    }


     /**
     * Retrieves the 'abortOnErrors' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#isAbortOnErrors()
     * @return the 'abortOnErrors' property value for this Object
     */
     public boolean isAbortOnErrors() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.abortOnErrors;
     }

    /**
     * Sets the 'abortOnErrors' property value for this IObject.
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#setAbortOnErrors(boolean abortOnErrors)
     * @param abortOnErrors is the new value for property 'abortOnErrors'
     */public void setAbortOnErrors(boolean abortOnErrors) {
    		if(this.abortOnErrors == abortOnErrors) {
    			return;
    		}
    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            boolean oldVal = this.abortOnErrors;
            this.abortOnErrors = abortOnErrors;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.ABORT_ON_ERRORS, oldVal, abortOnErrors);
            }
        }
     


     /**
     * Retrieves the 'bulkLoad' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#isBulkLoad()
     * @return the 'bulkLoad' property value for this Object
     */
     public boolean isBulkLoad() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.bulkLoad;
     }

    /**
     * Sets the 'bulkLoad' property value for this IObject.
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#setBulkLoad(boolean bulkLoad)
     * @param bulkLoad is the new value for property 'bulkLoad'
     */public void setBulkLoad(boolean bulkLoad) {
    		if(this.bulkLoad == bulkLoad) {
    			return;
    		}
    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            boolean oldVal = this.bulkLoad;
            this.bulkLoad = bulkLoad;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.BULK_LOAD, oldVal, bulkLoad);
            }
        }
     


     /**
     * Retrieves the 'oneBatch' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#isOneBatch()
     * @return the 'oneBatch' property value for this Object
     */
     public boolean isOneBatch() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.oneBatch;
     }

    /**
     * Sets the 'oneBatch' property value for this IObject.
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#setOneBatch(boolean oneBatch)
     * @param oneBatch is the new value for property 'oneBatch'
     */public void setOneBatch(boolean oneBatch) {
    		if(this.oneBatch == oneBatch) {
    			return;
    		}
    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            boolean oldVal = this.oneBatch;
            this.oneBatch = oneBatch;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.ONE_BATCH, oldVal, oneBatch);
            }
        }
     


     /**
     * Retrieves the 'postSql' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#getPostSql()
     * @return the 'postSql' property value for this Object
     */
     public java.lang.String getPostSql() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.postSql;
     }

    /**
     * Sets the 'postSql' property value for this IObject.
     * If a <code>null</code> is specified as the value for this property,
     * the default value of the String, i.e., empty string('""') will be set.
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#setPostSql(java.lang.String postSql)
     * @param postSql is the new value for property 'postSql'
     */public void setPostSql(java.lang.String postSql) {
    		if(this.postSql.equals(postSql)) {
    			return;
    		}

    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            java.lang.String oldVal = this.postSql;
            if(postSql == null) {
                postSql = "";
            }
            this.postSql = postSql;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.POST_SQL, oldVal, postSql);
            }
        }
     


     /**
     * Retrieves the 'postSql$' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#getPostSql$()
     * @return the 'postSql$' property value for this Object
     */
     public com.informatica.metadata.common.parameter.Parameter getPostSql$() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.postSql$;
     }

    /**
     * Sets the 'postSql$' property value for this IObject.
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#setPostSql$(com.informatica.metadata.common.parameter.Parameter postSql$)
     * @param postSql$ is the new value for property 'postSql$'
     */public void setPostSql$(com.informatica.metadata.common.parameter.Parameter postSql$) {

    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            com.informatica.metadata.common.parameter.Parameter actualObject = postSql$;
            if(postSql$ != null) {
              if(postSql$ instanceof com.informatica.imf.icore.IDelegatedObject ) {
               actualObject = ((com.informatica.imf.icore.IDelegatedObject)postSql$).getDelegatee();
                }
            }
    		if(this.postSql$ == actualObject) {
    			return;
    		}
            if (actualObject == null) {
               if (iGetSubstituteProperties()
                           .containsKey(com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.POST_SQL$))
                     iRemoveSubstituteProperty(com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.POST_SQL$);
            } else {
               iPutSubstituteProperty(
                            com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.POST_SQL$,
                            actualObject);
            }
            com.informatica.metadata.common.parameter.Parameter oldVal = (com.informatica.metadata.common.parameter.Parameter) this.postSql$;
            this.postSql$ = actualObject;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.POST_SQL$, oldVal, actualObject);
            }
        }
     


     /**
     * Retrieves the 'preSql' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#getPreSql()
     * @return the 'preSql' property value for this Object
     */
     public java.lang.String getPreSql() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.preSql;
     }

    /**
     * Sets the 'preSql' property value for this IObject.
     * If a <code>null</code> is specified as the value for this property,
     * the default value of the String, i.e., empty string('""') will be set.
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#setPreSql(java.lang.String preSql)
     * @param preSql is the new value for property 'preSql'
     */public void setPreSql(java.lang.String preSql) {
    		if(this.preSql.equals(preSql)) {
    			return;
    		}

    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            java.lang.String oldVal = this.preSql;
            if(preSql == null) {
                preSql = "";
            }
            this.preSql = preSql;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.PRE_SQL, oldVal, preSql);
            }
        }
     


     /**
     * Retrieves the 'preSql$' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#getPreSql$()
     * @return the 'preSql$' property value for this Object
     */
     public com.informatica.metadata.common.parameter.Parameter getPreSql$() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.preSql$;
     }

    /**
     * Sets the 'preSql$' property value for this IObject.
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#setPreSql$(com.informatica.metadata.common.parameter.Parameter preSql$)
     * @param preSql$ is the new value for property 'preSql$'
     */public void setPreSql$(com.informatica.metadata.common.parameter.Parameter preSql$) {

    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            com.informatica.metadata.common.parameter.Parameter actualObject = preSql$;
            if(preSql$ != null) {
              if(preSql$ instanceof com.informatica.imf.icore.IDelegatedObject ) {
               actualObject = ((com.informatica.imf.icore.IDelegatedObject)preSql$).getDelegatee();
                }
            }
    		if(this.preSql$ == actualObject) {
    			return;
    		}
            if (actualObject == null) {
               if (iGetSubstituteProperties()
                           .containsKey(com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.PRE_SQL$))
                     iRemoveSubstituteProperty(com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.PRE_SQL$);
            } else {
               iPutSubstituteProperty(
                            com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.PRE_SQL$,
                            actualObject);
            }
            com.informatica.metadata.common.parameter.Parameter oldVal = (com.informatica.metadata.common.parameter.Parameter) this.preSql$;
            this.preSql$ = actualObject;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.PRE_SQL$, oldVal, actualObject);
            }
        }
     


     /**
     * Retrieves the 'propagateData' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#isPropagateData()
     * @return the 'propagateData' property value for this Object
     */
     public boolean isPropagateData() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.propagateData;
     }

    /**
     * Sets the 'propagateData' property value for this IObject.
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#setPropagateData(boolean propagateData)
     * @param propagateData is the new value for property 'propagateData'
     */public void setPropagateData(boolean propagateData) {
    		if(this.propagateData == propagateData) {
    			return;
    		}
    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            boolean oldVal = this.propagateData;
            this.propagateData = propagateData;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.PROPAGATE_DATA, oldVal, propagateData);
            }
        }
     


     /**
     * Retrieves the 'startTransactionForJobs' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#isStartTransactionForJobs()
     * @return the 'startTransactionForJobs' property value for this Object
     */
     public boolean isStartTransactionForJobs() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.startTransactionForJobs;
     }

    /**
     * Sets the 'startTransactionForJobs' property value for this IObject.
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#setStartTransactionForJobs(boolean startTransactionForJobs)
     * @param startTransactionForJobs is the new value for property 'startTransactionForJobs'
     */public void setStartTransactionForJobs(boolean startTransactionForJobs) {
    		if(this.startTransactionForJobs == startTransactionForJobs) {
    			return;
    		}
    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            boolean oldVal = this.startTransactionForJobs;
            this.startTransactionForJobs = startTransactionForJobs;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.START_TRANSACTION_FOR_JOBS, oldVal, startTransactionForJobs);
            }
        }
     


     /**
     * Retrieves the 'truncateTargetTable' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#isTruncateTargetTable()
     * @return the 'truncateTargetTable' property value for this Object
     */
     public boolean isTruncateTargetTable() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.truncateTargetTable;
     }

    /**
     * Sets the 'truncateTargetTable' property value for this IObject.
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#setTruncateTargetTable(boolean truncateTargetTable)
     * @param truncateTargetTable is the new value for property 'truncateTargetTable'
     */public void setTruncateTargetTable(boolean truncateTargetTable) {
    		if(this.truncateTargetTable == truncateTargetTable) {
    			return;
    		}
    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            boolean oldVal = this.truncateTargetTable;
            this.truncateTargetTable = truncateTargetTable;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.TRUNCATE_TARGET_TABLE, oldVal, truncateTargetTable);
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
    	if( propertyId <com.informatica.adapter.sdkadapter.asoextension.impl.AsoextensionIPackageImpl.getD__MODEL_EXTENSION_WRITE_CAP_ATTRIBUTESFeatureCount())
    	return super.iGet(iProperty);
    	else
    	switch (((com.informatica.imf.icore.internal.IPropertyInternal) iProperty).getQualifiedName()){
        case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.abortOnErrors":
            return this.isAbortOnErrors();
        case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.bulkLoad":
            return this.isBulkLoad();
        case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.oneBatch":
            return this.isOneBatch();
        case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.postSql":
            return this.getPostSql();
        case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.postSql$":
            return this.getPostSql$();
        case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.preSql":
            return this.getPreSql();
        case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.preSql$":
            return this.getPreSql$();
        case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.propagateData":
            return this.isPropagateData();
        case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.startTransactionForJobs":
            return this.isStartTransactionForJobs();
        case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.truncateTargetTable":
            return this.isTruncateTargetTable();
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
    	if( propertyId <com.informatica.adapter.sdkadapter.asoextension.impl.AsoextensionIPackageImpl.getD__MODEL_EXTENSION_WRITE_CAP_ATTRIBUTESFeatureCount())
    	return super.iGet(iProperty,encrypted);
    	else
    	switch (((com.informatica.imf.icore.internal.IPropertyInternal) iProperty).getQualifiedName()){
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.abortOnErrors":
                return this.isAbortOnErrors();
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.bulkLoad":
                return this.isBulkLoad();
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.oneBatch":
                return this.isOneBatch();
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.postSql":
                return this.getPostSql();
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.postSql$":
                return this.getPostSql$();
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.preSql":
                return this.getPreSql();
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.preSql$":
                return this.getPreSql$();
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.propagateData":
                return this.isPropagateData();
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.startTransactionForJobs":
                return this.isStartTransactionForJobs();
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.truncateTargetTable":
                return this.isTruncateTargetTable();
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
    	if( propertyId <com.informatica.adapter.sdkadapter.asoextension.impl.AsoextensionIPackageImpl.getD__MODEL_EXTENSION_WRITE_CAP_ATTRIBUTESFeatureCount())
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
    	if( propertyId <com.informatica.adapter.sdkadapter.asoextension.impl.AsoextensionIPackageImpl.getD__MODEL_EXTENSION_WRITE_CAP_ATTRIBUTESFeatureCount())
    	super.iSet(iProperty,newValue);
    	else
        	switch (((com.informatica.imf.icore.internal.IPropertyInternal) iProperty).getQualifiedName()) {
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.abortOnErrors":

                if (newValue == null) {
                        throw new com.informatica.core.exception.IllegalArgumentException(
                               com.informatica.imf.ImfMsg.MANDATORY_PROPERTY_property_OF_class_CANNOT_BE_SET_TO_NULL,
                               iProperty.getName(),
                               this.iGetIClass());
                 }
                this.setAbortOnErrors((java.lang.Boolean) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.bulkLoad":

                if (newValue == null) {
                        throw new com.informatica.core.exception.IllegalArgumentException(
                               com.informatica.imf.ImfMsg.MANDATORY_PROPERTY_property_OF_class_CANNOT_BE_SET_TO_NULL,
                               iProperty.getName(),
                               this.iGetIClass());
                 }
                this.setBulkLoad((java.lang.Boolean) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.oneBatch":

                if (newValue == null) {
                        throw new com.informatica.core.exception.IllegalArgumentException(
                               com.informatica.imf.ImfMsg.MANDATORY_PROPERTY_property_OF_class_CANNOT_BE_SET_TO_NULL,
                               iProperty.getName(),
                               this.iGetIClass());
                 }
                this.setOneBatch((java.lang.Boolean) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.postSql":
                this.setPostSql((java.lang.String) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.postSql$":
                this.setPostSql$((com.informatica.metadata.common.parameter.Parameter) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.preSql":
                this.setPreSql((java.lang.String) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.preSql$":
                this.setPreSql$((com.informatica.metadata.common.parameter.Parameter) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.propagateData":

                if (newValue == null) {
                        throw new com.informatica.core.exception.IllegalArgumentException(
                               com.informatica.imf.ImfMsg.MANDATORY_PROPERTY_property_OF_class_CANNOT_BE_SET_TO_NULL,
                               iProperty.getName(),
                               this.iGetIClass());
                 }
                this.setPropagateData((java.lang.Boolean) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.startTransactionForJobs":

                if (newValue == null) {
                        throw new com.informatica.core.exception.IllegalArgumentException(
                               com.informatica.imf.ImfMsg.MANDATORY_PROPERTY_property_OF_class_CANNOT_BE_SET_TO_NULL,
                               iProperty.getName(),
                               this.iGetIClass());
                 }
                this.setStartTransactionForJobs((java.lang.Boolean) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.truncateTargetTable":

                if (newValue == null) {
                        throw new com.informatica.core.exception.IllegalArgumentException(
                               com.informatica.imf.ImfMsg.MANDATORY_PROPERTY_property_OF_class_CANNOT_BE_SET_TO_NULL,
                               iProperty.getName(),
                               this.iGetIClass());
                 }
                this.setTruncateTargetTable((java.lang.Boolean) newValue);
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
    	if( propertyId <com.informatica.adapter.sdkadapter.asoextension.impl.AsoextensionIPackageImpl.getD__MODEL_EXTENSION_WRITE_CAP_ATTRIBUTESFeatureCount())
    	super.iSet(iProperty,newValue,encrypted);
    	else
        	switch (((com.informatica.imf.icore.internal.IPropertyInternal) iProperty).getQualifiedName()){
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.abortOnErrors":

                if (newValue == null) {
                        throw new com.informatica.core.exception.IllegalArgumentException(
                               com.informatica.imf.ImfMsg.MANDATORY_PROPERTY_property_OF_class_CANNOT_BE_SET_TO_NULL,
                               iProperty.getName(),
                               this.iGetIClass());
                 }
                this.setAbortOnErrors((java.lang.Boolean) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.bulkLoad":

                if (newValue == null) {
                        throw new com.informatica.core.exception.IllegalArgumentException(
                               com.informatica.imf.ImfMsg.MANDATORY_PROPERTY_property_OF_class_CANNOT_BE_SET_TO_NULL,
                               iProperty.getName(),
                               this.iGetIClass());
                 }
                this.setBulkLoad((java.lang.Boolean) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.oneBatch":

                if (newValue == null) {
                        throw new com.informatica.core.exception.IllegalArgumentException(
                               com.informatica.imf.ImfMsg.MANDATORY_PROPERTY_property_OF_class_CANNOT_BE_SET_TO_NULL,
                               iProperty.getName(),
                               this.iGetIClass());
                 }
                this.setOneBatch((java.lang.Boolean) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.postSql":
                this.setPostSql((java.lang.String) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.postSql$":
                this.setPostSql$((com.informatica.metadata.common.parameter.Parameter) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.preSql":
                this.setPreSql((java.lang.String) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.preSql$":
                this.setPreSql$((com.informatica.metadata.common.parameter.Parameter) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.propagateData":

                if (newValue == null) {
                        throw new com.informatica.core.exception.IllegalArgumentException(
                               com.informatica.imf.ImfMsg.MANDATORY_PROPERTY_property_OF_class_CANNOT_BE_SET_TO_NULL,
                               iProperty.getName(),
                               this.iGetIClass());
                 }
                this.setPropagateData((java.lang.Boolean) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.startTransactionForJobs":

                if (newValue == null) {
                        throw new com.informatica.core.exception.IllegalArgumentException(
                               com.informatica.imf.ImfMsg.MANDATORY_PROPERTY_property_OF_class_CANNOT_BE_SET_TO_NULL,
                               iProperty.getName(),
                               this.iGetIClass());
                 }
                this.setStartTransactionForJobs((java.lang.Boolean) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.truncateTargetTable":

                if (newValue == null) {
                        throw new com.informatica.core.exception.IllegalArgumentException(
                               com.informatica.imf.ImfMsg.MANDATORY_PROPERTY_property_OF_class_CANNOT_BE_SET_TO_NULL,
                               iProperty.getName(),
                               this.iGetIClass());
                 }
                this.setTruncateTargetTable((java.lang.Boolean) newValue);
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
    	if( propertyId <com.informatica.adapter.sdkadapter.asoextension.impl.AsoextensionIPackageImpl.getD__MODEL_EXTENSION_WRITE_CAP_ATTRIBUTESFeatureCount())
    	super.iInverseSet(iProperty,newValue);
    	else
        	switch (((com.informatica.imf.icore.internal.IPropertyInternal) iProperty).getQualifiedName()) {
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.abortOnErrors":
               this.abortOnErrors = (java.lang.Boolean) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.bulkLoad":
               this.bulkLoad = (java.lang.Boolean) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.oneBatch":
               this.oneBatch = (java.lang.Boolean) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.postSql":
               this.postSql = (java.lang.String) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.postSql$":
               this.postSql$ = (com.informatica.metadata.common.parameter.Parameter) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.preSql":
               this.preSql = (java.lang.String) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.preSql$":
               this.preSql$ = (com.informatica.metadata.common.parameter.Parameter) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.propagateData":
               this.propagateData = (java.lang.Boolean) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.startTransactionForJobs":
               this.startTransactionForJobs = (java.lang.Boolean) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.truncateTargetTable":
               this.truncateTargetTable = (java.lang.Boolean) newValue;
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
        sb.append("com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension").append('[');
        sb.append(this.hashCode());
        sb.append(']');
        return sb.toString();
    }

    public static void initIProperties() {
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.TABLE_WRITE_CAPABILITY_ATTRIBUTES_EXTENSION__ABORT_ON_ERRORS;
        		com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.ABORT_ON_ERRORS =
        			com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage.I_INSTANCE.getTableWriteCapabilityAttributesExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.TABLE_WRITE_CAPABILITY_ATTRIBUTES_EXTENSION__BULK_LOAD;
        		com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.BULK_LOAD =
        			com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage.I_INSTANCE.getTableWriteCapabilityAttributesExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.TABLE_WRITE_CAPABILITY_ATTRIBUTES_EXTENSION__ONE_BATCH;
        		com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.ONE_BATCH =
        			com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage.I_INSTANCE.getTableWriteCapabilityAttributesExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.TABLE_WRITE_CAPABILITY_ATTRIBUTES_EXTENSION__POST_SQL;
        		com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.POST_SQL =
        			com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage.I_INSTANCE.getTableWriteCapabilityAttributesExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.TABLE_WRITE_CAPABILITY_ATTRIBUTES_EXTENSION__POST_SQL$;
        		com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.POST_SQL$ =
        			com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage.I_INSTANCE.getTableWriteCapabilityAttributesExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.TABLE_WRITE_CAPABILITY_ATTRIBUTES_EXTENSION__PRE_SQL;
        		com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.PRE_SQL =
        			com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage.I_INSTANCE.getTableWriteCapabilityAttributesExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.TABLE_WRITE_CAPABILITY_ATTRIBUTES_EXTENSION__PRE_SQL$;
        		com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.PRE_SQL$ =
        			com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage.I_INSTANCE.getTableWriteCapabilityAttributesExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.TABLE_WRITE_CAPABILITY_ATTRIBUTES_EXTENSION__PROPAGATE_DATA;
        		com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.PROPAGATE_DATA =
        			com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage.I_INSTANCE.getTableWriteCapabilityAttributesExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.TABLE_WRITE_CAPABILITY_ATTRIBUTES_EXTENSION__START_TRANSACTION_FOR_JOBS;
        		com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.START_TRANSACTION_FOR_JOBS =
        			com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage.I_INSTANCE.getTableWriteCapabilityAttributesExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.TABLE_WRITE_CAPABILITY_ATTRIBUTES_EXTENSION__TRUNCATE_TARGET_TABLE;
        		com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.TRUNCATE_TARGET_TABLE =
        			com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage.I_INSTANCE.getTableWriteCapabilityAttributesExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
    }
}