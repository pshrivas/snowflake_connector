/*
 * Copyright (c) 2016 Informatica Corporation. All rights reserved.
 */

/*
 * This file is generated. Do not modify.
 * IMF Version: 9.5.0
 * Generation time: 2016-07-05 19:33:17
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
    private static final long serialVersionUID = -8727365761583341033L;

    private static int PROPERTY_ID;

    protected boolean bulkLoad = true;

    protected java.lang.String partitionID = "";

    protected com.informatica.metadata.common.parameter.Parameter partitionID$;

    protected boolean truncateTargetTable = true;


    /**
     * Default constructor for TableWriteCapabilityAttributesExtensionImpl.
     */
    public TableWriteCapabilityAttributesExtensionImpl() {
        assert iObjInfo != null;
        iSetIClass(com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage.I_INSTANCE
                .getTableWriteCapabilityAttributesExtensionIClass());
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
     * Retrieves the 'partitionID' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#getPartitionID()
     * @return the 'partitionID' property value for this Object
     */
     public java.lang.String getPartitionID() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.partitionID;
     }

    /**
     * Sets the 'partitionID' property value for this IObject.
     * If a <code>null</code> is specified as the value for this property,
     * the default value of the String, i.e., empty string('""') will be set.
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#setPartitionID(java.lang.String partitionID)
     * @param partitionID is the new value for property 'partitionID'
     */public void setPartitionID(java.lang.String partitionID) {
    		if(this.partitionID.equals(partitionID)) {
    			return;
    		}

    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            java.lang.String oldVal = this.partitionID;
            if(partitionID == null) {
                partitionID = "";
            }
            this.partitionID = partitionID;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.PARTITION_I_D, oldVal, partitionID);
            }
        }
     


     /**
     * Retrieves the 'partitionID$' property value for this Object.
     *
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#getPartitionID$()
     * @return the 'partitionID$' property value for this Object
     */
     public com.informatica.metadata.common.parameter.Parameter getPartitionID$() {
         if (this.iIsProxy()) {
             if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
                 throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
                     com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
             }
         }
         return this.partitionID$;
     }

    /**
     * Sets the 'partitionID$' property value for this IObject.
     * @see com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#setPartitionID$(com.informatica.metadata.common.parameter.Parameter partitionID$)
     * @param partitionID$ is the new value for property 'partitionID$'
     */public void setPartitionID$(com.informatica.metadata.common.parameter.Parameter partitionID$) {

    		if (this.iIsProxy()) {
    			if(!isResolvingProxy() && !resolveProxyUsingCallback()) {
    				throw new com.informatica.imf.icore.exception.UnresolvedProxyException(
    					com.informatica.imf.ImfMsg.GETTERS_AND_SETTERS_NOT_PERMITTED_ON_PROXY_OBJECT);
    			}
    		}
            com.informatica.metadata.common.parameter.Parameter actualObject = partitionID$;
            if(partitionID$ != null) {
              if(partitionID$ instanceof com.informatica.imf.icore.IDelegatedObject ) {
               actualObject = ((com.informatica.imf.icore.IDelegatedObject)partitionID$).getDelegatee();
                }
            }
    		if(this.partitionID$ == actualObject) {
    			return;
    		}
            if (actualObject == null) {
               if (iGetSubstituteProperties()
                           .containsKey(com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.PARTITION_I_D$))
                     iRemoveSubstituteProperty(com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.PARTITION_I_D$);
            } else {
               iPutSubstituteProperty(
                            com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.PARTITION_I_D$,
                            actualObject);
            }
            com.informatica.metadata.common.parameter.Parameter oldVal = (com.informatica.metadata.common.parameter.Parameter) this.partitionID$;
            this.partitionID$ = actualObject;
            if (com.informatica.imf.icore.IMFRuntime.getInstance().isListenerActive()) {
                com.informatica.imf.icore.IMFRuntime.getInstance().getObjectChangeListener().onPropertyChange(
                    this, com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.PARTITION_I_D$, oldVal, actualObject);
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
        case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.bulkLoad":
            return this.isBulkLoad();
        case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.partitionID":
            return this.getPartitionID();
        case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.partitionID$":
            return this.getPartitionID$();
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
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.bulkLoad":
                return this.isBulkLoad();
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.partitionID":
                return this.getPartitionID();
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.partitionID$":
                return this.getPartitionID$();
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
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.bulkLoad":

                if (newValue == null) {
                        throw new com.informatica.core.exception.IllegalArgumentException(
                               com.informatica.imf.ImfMsg.MANDATORY_PROPERTY_property_OF_class_CANNOT_BE_SET_TO_NULL,
                               iProperty.getName(),
                               this.iGetIClass());
                 }
                this.setBulkLoad((java.lang.Boolean) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.partitionID":
                this.setPartitionID((java.lang.String) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.partitionID$":
                this.setPartitionID$((com.informatica.metadata.common.parameter.Parameter) newValue);
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
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.bulkLoad":

                if (newValue == null) {
                        throw new com.informatica.core.exception.IllegalArgumentException(
                               com.informatica.imf.ImfMsg.MANDATORY_PROPERTY_property_OF_class_CANNOT_BE_SET_TO_NULL,
                               iProperty.getName(),
                               this.iGetIClass());
                 }
                this.setBulkLoad((java.lang.Boolean) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.partitionID":
                this.setPartitionID((java.lang.String) newValue);
                break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.partitionID$":
                this.setPartitionID$((com.informatica.metadata.common.parameter.Parameter) newValue);
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
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.bulkLoad":
               this.bulkLoad = (java.lang.Boolean) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.partitionID":
               this.partitionID = (java.lang.String) newValue;
               break;
            case "com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.partitionID$":
               this.partitionID$ = (com.informatica.metadata.common.parameter.Parameter) newValue;
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
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.TABLE_WRITE_CAPABILITY_ATTRIBUTES_EXTENSION__BULK_LOAD;
        		com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.BULK_LOAD =
        			com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage.I_INSTANCE.getTableWriteCapabilityAttributesExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.TABLE_WRITE_CAPABILITY_ATTRIBUTES_EXTENSION__PARTITION_I_D;
        		com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.PARTITION_I_D =
        			com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage.I_INSTANCE.getTableWriteCapabilityAttributesExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.TABLE_WRITE_CAPABILITY_ATTRIBUTES_EXTENSION__PARTITION_I_D$;
        		com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.PARTITION_I_D$ =
        			com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage.I_INSTANCE.getTableWriteCapabilityAttributesExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
        PROPERTY_ID = com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.TABLE_WRITE_CAPABILITY_ATTRIBUTES_EXTENSION__TRUNCATE_TARGET_TABLE;
        		com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.TRUNCATE_TARGET_TABLE =
        			com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage.I_INSTANCE.getTableWriteCapabilityAttributesExtensionIClass().getAllProperties(true).get(PROPERTY_ID);
    }
}