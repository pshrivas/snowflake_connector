/*
 * Copyright (c) 2016 Informatica Corporation. All rights reserved.
 */

/*
 * This file is generated. Do not modify.
 * IMF Version: 9.5.0
 * Generation time: 2016-07-05 19:33:16
 */
package com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl;

/**
 * The implementation for an TableReadCapabilityAttributesExtension.
 *
 */
public class TableReadCapabilityAttributesExtensionImpl
extends com.informatica.adapter.sdkadapter.asoextension.impl.D_ModelExtensionReadCapAttributesImpl
implements com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension {
    /**
     * The generated Serial Version UID.
     */
    private static final long serialVersionUID = 393351344686902134L;

    private static int PROPERTY_ID;

    protected java.lang.String postSQL = "";

    protected com.informatica.metadata.common.parameter.Parameter postSQL$;

    protected java.lang.String preSQL = "";

    protected java.lang.Integer rowLimit = 0;

    protected com.informatica.metadata.common.parameter.Parameter rowLimit$;

    protected java.lang.Integer rowOffSet = 0;

    protected com.informatica.metadata.common.parameter.Parameter rowOffSet$;


    /**
     * Default constructor for TableReadCapabilityAttributesExtensionImpl.
     */
    public TableReadCapabilityAttributesExtensionImpl() {
        assert iObjInfo != null;
        iSetIClass(com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage.I_INSTANCE
                .getTableReadCapabilityAttributesExtensionIClass());
    }


     /**
     * Retrieves the 'postSQL' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension#getPostSQL()
     * @return the 'postSQL' property value for this Object
     */
     public java.lang.String getPostSQL() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.postSQL;
     }

    /**
     * Sets the 'postSQL' property value for this IObject.
     * If a <code>null</code> is specified as the value for this property,
     * the default value of the String, i.e., empty string('""') will be set.
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension#setPostSQL(java.lang.String postSQL)
     * @param postSQL is the new value for property 'postSQL'
     */public void setPostSQL(java.lang.String postSQL) {
    		if(this.postSQL.equals(postSQL)) {
    			return;
    		}

    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            java.lang.String oldVal = this.postSQL;
            if(postSQL == null) {
                postSQL = "";
            }
            this.postSQL = postSQL;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.Properties.POST_S_Q_L, oldVal, postSQL);
            }
        }
     


     /**
     * Retrieves the 'postSQL$' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension#getPostSQL$()
     * @return the 'postSQL$' property value for this Object
     */
     public com.informatica.metadata.common.parameter.Parameter getPostSQL$() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.postSQL$;
     }

    /**
     * Sets the 'postSQL$' property value for this IObject.
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension#setPostSQL$(com.informatica.metadata.common.parameter.Parameter postSQL$)
     * @param postSQL$ is the new value for property 'postSQL$'
     */public void setPostSQL$(com.informatica.metadata.common.parameter.Parameter postSQL$) {

    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            com.informatica.metadata.common.parameter.Parameter actualObject = postSQL$;
            if(postSQL$ != null) {
              if(postSQL$ instanceof com.informatica.imf.icore.IDelegatedObject ) {
               actualObject = ((com.informatica.imf.icore.IDelegatedObject)postSQL$).getDelegatee();
                }
            }
    		if(this.postSQL$ == actualObject) {
    			return;
    		}
            if (actualObject == null) {
               if (iGetSubstituteProperties()
                           .containsKey(com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.Properties.POST_S_Q_L$))
                     iRemoveSubstituteProperty(com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.Properties.POST_S_Q_L$);
            } else {
               iPutSubstituteProperty(
                            com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.Properties.POST_S_Q_L$,
                            actualObject);
            }
            com.informatica.metadata.common.parameter.Parameter oldVal = (com.informatica.metadata.common.parameter.Parameter) this.postSQL$;
            this.postSQL$ = actualObject;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.Properties.POST_S_Q_L$, oldVal, actualObject);
            }
        }
     


     /**
     * Retrieves the 'preSQL' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension#getPreSQL()
     * @return the 'preSQL' property value for this Object
     */
     public java.lang.String getPreSQL() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.preSQL;
     }

    /**
     * Sets the 'preSQL' property value for this IObject.
     * If a <code>null</code> is specified as the value for this property,
     * the default value of the String, i.e., empty string('""') will be set.
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension#setPreSQL(java.lang.String preSQL)
     * @param preSQL is the new value for property 'preSQL'
     */public void setPreSQL(java.lang.String preSQL) {
    		if(this.preSQL.equals(preSQL)) {
    			return;
    		}

    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            java.lang.String oldVal = this.preSQL;
            if(preSQL == null) {
                preSQL = "";
            }
            this.preSQL = preSQL;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.Properties.PRE_S_Q_L, oldVal, preSQL);
            }
        }
     


     /**
     * Retrieves the 'rowLimit' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension#getRowLimit()
     * @return the 'rowLimit' property value for this Object
     */
     public java.lang.Integer getRowLimit() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.rowLimit;
     }

    /**
     * Sets the 'rowLimit' property value for this IObject.
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension#setRowLimit(java.lang.Integer rowLimit)
     * @param rowLimit is the new value for property 'rowLimit'
     */public void setRowLimit(java.lang.Integer rowLimit) {
    		if(this.rowLimit == rowLimit) {
    			return;
    		}
    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            java.lang.Integer oldVal = this.rowLimit;
            this.rowLimit = rowLimit;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.Properties.ROW_LIMIT, oldVal, rowLimit);
            }
        }
     


     /**
     * Retrieves the 'rowLimit$' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension#getRowLimit$()
     * @return the 'rowLimit$' property value for this Object
     */
     public com.informatica.metadata.common.parameter.Parameter getRowLimit$() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.rowLimit$;
     }

    /**
     * Sets the 'rowLimit$' property value for this IObject.
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension#setRowLimit$(com.informatica.metadata.common.parameter.Parameter rowLimit$)
     * @param rowLimit$ is the new value for property 'rowLimit$'
     */public void setRowLimit$(com.informatica.metadata.common.parameter.Parameter rowLimit$) {

    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            com.informatica.metadata.common.parameter.Parameter actualObject = rowLimit$;
            if(rowLimit$ != null) {
              if(rowLimit$ instanceof com.informatica.imf.icore.IDelegatedObject ) {
               actualObject = ((com.informatica.imf.icore.IDelegatedObject)rowLimit$).getDelegatee();
                }
            }
    		if(this.rowLimit$ == actualObject) {
    			return;
    		}
            if (actualObject == null) {
               if (iGetSubstituteProperties()
                           .containsKey(com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.Properties.ROW_LIMIT$))
                     iRemoveSubstituteProperty(com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.Properties.ROW_LIMIT$);
            } else {
               iPutSubstituteProperty(
                            com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.Properties.ROW_LIMIT$,
                            actualObject);
            }
            com.informatica.metadata.common.parameter.Parameter oldVal = (com.informatica.metadata.common.parameter.Parameter) this.rowLimit$;
            this.rowLimit$ = actualObject;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.Properties.ROW_LIMIT$, oldVal, actualObject);
            }
        }
     


     /**
     * Retrieves the 'rowOffSet' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension#getRowOffSet()
     * @return the 'rowOffSet' property value for this Object
     */
     public java.lang.Integer getRowOffSet() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.rowOffSet;
     }

    /**
     * Sets the 'rowOffSet' property value for this IObject.
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension#setRowOffSet(java.lang.Integer rowOffSet)
     * @param rowOffSet is the new value for property 'rowOffSet'
     */public void setRowOffSet(java.lang.Integer rowOffSet) {
    		if(this.rowOffSet == rowOffSet) {
    			return;
    		}
    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            java.lang.Integer oldVal = this.rowOffSet;
            this.rowOffSet = rowOffSet;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.Properties.ROW_OFF_SET, oldVal, rowOffSet);
            }
        }
     


     /**
     * Retrieves the 'rowOffSet$' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension#getRowOffSet$()
     * @return the 'rowOffSet$' property value for this Object
     */
     public com.informatica.metadata.common.parameter.Parameter getRowOffSet$() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.rowOffSet$;
     }

    /**
     * Sets the 'rowOffSet$' property value for this IObject.
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension#setRowOffSet$(com.informatica.metadata.common.parameter.Parameter rowOffSet$)
     * @param rowOffSet$ is the new value for property 'rowOffSet$'
     */public void setRowOffSet$(com.informatica.metadata.common.parameter.Parameter rowOffSet$) {

    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            com.informatica.metadata.common.parameter.Parameter actualObject = rowOffSet$;
            if(rowOffSet$ != null) {
              if(rowOffSet$ instanceof com.informatica.imf.icore.IDelegatedObject ) {
               actualObject = ((com.informatica.imf.icore.IDelegatedObject)rowOffSet$).getDelegatee();
                }
            }
    		if(this.rowOffSet$ == actualObject) {
    			return;
    		}
            if (actualObject == null) {
               if (iGetSubstituteProperties()
                           .containsKey(com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.Properties.ROW_OFF_SET$))
                     iRemoveSubstituteProperty(com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.Properties.ROW_OFF_SET$);
            } else {
               iPutSubstituteProperty(
                            com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.Properties.ROW_OFF_SET$,
                            actualObject);
            }
            com.informatica.metadata.common.parameter.Parameter oldVal = (com.informatica.metadata.common.parameter.Parameter) this.rowOffSet$;
            this.rowOffSet$ = actualObject;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.Properties.ROW_OFF_SET$, oldVal, actualObject);
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
    	if( propertyId <com.informatica.adapter.sdkadapter.asoextension.impl.AsoextensionIPackageImpl.getD__MODEL_EXTENSION_READ_CAP_ATTRIBUTESFeatureCount())
    	return super.iGet(iProperty);
    	else
    	switch (((com.informatica.imf.icore.internal.IPropertyInternal) iProperty).getQualifiedName()){
        case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.postSQL":
            return this.getPostSQL();
        case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.postSQL$":
            return this.getPostSQL$();
        case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.preSQL":
            return this.getPreSQL();
        case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.rowLimit":
            return this.getRowLimit();
        case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.rowLimit$":
            return this.getRowLimit$();
        case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.rowOffSet":
            return this.getRowOffSet();
        case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.rowOffSet$":
            return this.getRowOffSet$();
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
    	if( propertyId <com.informatica.adapter.sdkadapter.asoextension.impl.AsoextensionIPackageImpl.getD__MODEL_EXTENSION_READ_CAP_ATTRIBUTESFeatureCount())
    	return super.iGet(iProperty,encrypted);
    	else
    	switch (((com.informatica.imf.icore.internal.IPropertyInternal) iProperty).getQualifiedName()){
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.postSQL":
                return this.getPostSQL();
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.postSQL$":
                return this.getPostSQL$();
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.preSQL":
                return this.getPreSQL();
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.rowLimit":
                return this.getRowLimit();
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.rowLimit$":
                return this.getRowLimit$();
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.rowOffSet":
                return this.getRowOffSet();
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.rowOffSet$":
                return this.getRowOffSet$();
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
    	if( propertyId <com.informatica.adapter.sdkadapter.asoextension.impl.AsoextensionIPackageImpl.getD__MODEL_EXTENSION_READ_CAP_ATTRIBUTESFeatureCount())
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
    	if( propertyId <com.informatica.adapter.sdkadapter.asoextension.impl.AsoextensionIPackageImpl.getD__MODEL_EXTENSION_READ_CAP_ATTRIBUTESFeatureCount())
    	super.iSet(iProperty,newValue);
    	else
        	switch (((com.informatica.imf.icore.internal.IPropertyInternal) iProperty).getQualifiedName()) {
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.postSQL":
                this.setPostSQL((java.lang.String) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.postSQL$":
                this.setPostSQL$((com.informatica.metadata.common.parameter.Parameter) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.preSQL":
                this.setPreSQL((java.lang.String) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.rowLimit":

                if (newValue == null) {
                        throw new com.informatica.core.exception.IllegalArgumentException(
                               com.informatica.imf.ImfMsg.MANDATORY_PROPERTY_property_OF_class_CANNOT_BE_SET_TO_NULL,
                               iProperty.getName(),
                               this.iGetIClass());
                 }
                this.setRowLimit((java.lang.Integer) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.rowLimit$":
                this.setRowLimit$((com.informatica.metadata.common.parameter.Parameter) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.rowOffSet":

                if (newValue == null) {
                        throw new com.informatica.core.exception.IllegalArgumentException(
                               com.informatica.imf.ImfMsg.MANDATORY_PROPERTY_property_OF_class_CANNOT_BE_SET_TO_NULL,
                               iProperty.getName(),
                               this.iGetIClass());
                 }
                this.setRowOffSet((java.lang.Integer) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.rowOffSet$":
                this.setRowOffSet$((com.informatica.metadata.common.parameter.Parameter) newValue);
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
    	if( propertyId <com.informatica.adapter.sdkadapter.asoextension.impl.AsoextensionIPackageImpl.getD__MODEL_EXTENSION_READ_CAP_ATTRIBUTESFeatureCount())
    	super.iSet(iProperty,newValue,encrypted);
    	else
        	switch (((com.informatica.imf.icore.internal.IPropertyInternal) iProperty).getQualifiedName()){
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.postSQL":
                this.setPostSQL((java.lang.String) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.postSQL$":
                this.setPostSQL$((com.informatica.metadata.common.parameter.Parameter) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.preSQL":
                this.setPreSQL((java.lang.String) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.rowLimit":

                if (newValue == null) {
                        throw new com.informatica.core.exception.IllegalArgumentException(
                               com.informatica.imf.ImfMsg.MANDATORY_PROPERTY_property_OF_class_CANNOT_BE_SET_TO_NULL,
                               iProperty.getName(),
                               this.iGetIClass());
                 }
                this.setRowLimit((java.lang.Integer) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.rowLimit$":
                this.setRowLimit$((com.informatica.metadata.common.parameter.Parameter) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.rowOffSet":

                if (newValue == null) {
                        throw new com.informatica.core.exception.IllegalArgumentException(
                               com.informatica.imf.ImfMsg.MANDATORY_PROPERTY_property_OF_class_CANNOT_BE_SET_TO_NULL,
                               iProperty.getName(),
                               this.iGetIClass());
                 }
                this.setRowOffSet((java.lang.Integer) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.rowOffSet$":
                this.setRowOffSet$((com.informatica.metadata.common.parameter.Parameter) newValue);
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
    	if( propertyId <com.informatica.adapter.sdkadapter.asoextension.impl.AsoextensionIPackageImpl.getD__MODEL_EXTENSION_READ_CAP_ATTRIBUTESFeatureCount())
    	super.iInverseSet(iProperty,newValue);
    	else
        	switch (((com.informatica.imf.icore.internal.IPropertyInternal) iProperty).getQualifiedName()) {
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.postSQL":
               this.postSQL = (java.lang.String) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.postSQL$":
               this.postSQL$ = (com.informatica.metadata.common.parameter.Parameter) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.preSQL":
               this.preSQL = (java.lang.String) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.rowLimit":
               this.rowLimit = (java.lang.Integer) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.rowLimit$":
               this.rowLimit$ = (com.informatica.metadata.common.parameter.Parameter) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.rowOffSet":
               this.rowOffSet = (java.lang.Integer) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.rowOffSet$":
               this.rowOffSet$ = (com.informatica.metadata.common.parameter.Parameter) newValue;
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
        sb.append("com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension").append('[');
        sb.append(this.hashCode());
        sb.append(']');
        return sb.toString();
    }

    public static void initIProperties() {
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.TABLE_READ_CAPABILITY_ATTRIBUTES_EXTENSION__POST_S_Q_L;
        		com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.Properties.POST_S_Q_L =
        			com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage.I_INSTANCE.getTableReadCapabilityAttributesExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.TABLE_READ_CAPABILITY_ATTRIBUTES_EXTENSION__POST_S_Q_L$;
        		com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.Properties.POST_S_Q_L$ =
        			com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage.I_INSTANCE.getTableReadCapabilityAttributesExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.TABLE_READ_CAPABILITY_ATTRIBUTES_EXTENSION__PRE_S_Q_L;
        		com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.Properties.PRE_S_Q_L =
        			com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage.I_INSTANCE.getTableReadCapabilityAttributesExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.TABLE_READ_CAPABILITY_ATTRIBUTES_EXTENSION__ROW_LIMIT;
        		com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.Properties.ROW_LIMIT =
        			com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage.I_INSTANCE.getTableReadCapabilityAttributesExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.TABLE_READ_CAPABILITY_ATTRIBUTES_EXTENSION__ROW_LIMIT$;
        		com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.Properties.ROW_LIMIT$ =
        			com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage.I_INSTANCE.getTableReadCapabilityAttributesExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.TABLE_READ_CAPABILITY_ATTRIBUTES_EXTENSION__ROW_OFF_SET;
        		com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.Properties.ROW_OFF_SET =
        			com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage.I_INSTANCE.getTableReadCapabilityAttributesExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.TABLE_READ_CAPABILITY_ATTRIBUTES_EXTENSION__ROW_OFF_SET$;
        		com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.Properties.ROW_OFF_SET$ =
        			com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage.I_INSTANCE.getTableReadCapabilityAttributesExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
    }
}