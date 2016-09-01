/* 
 * Copyright (c) 2016 Informatica Corporation. All rights reserved. 
 */
 
/*
 * This file is generated. Do not modify.
 * IMF Version: 9.5.0 
 * Generation time: 2016-08-29 17:39:53
 */ 

package com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl;

/**
 * The factory implementation for IPackage.
 * 'com.unicosolution.adapter.snowflakev2.table.runtime.capability'
 */
public class CapabilityIFactoryImpl
extends com.informatica.imf.icore.impl.IFactoryImpl
implements com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIFactory {

    /**
     * The generated Serial Version UID.
     * This is the same as for the 'com.unicosolution.adapter.snowflakev2.table.runtime.capabilityIPackageImpl'.
     */
    private static final long serialVersionUID = 3107354896552342317L;

    /**
     * Default constructor.
     */
    public CapabilityIFactoryImpl() {
    }
    
    /**
     * Returns an instance of specified IClass.
     * @param iClass the ICore class to be created.
     * @return an instance of specified IClass.
     */
    @SuppressWarnings("unchecked")
    public <T> T create(com.informatica.imf.icore.IClass iClass) {
        if(!this.getPackage().getTypes().contains(iClass)) {
    		throw new com.informatica.core.exception.IllegalArgumentException(
                    com.informatica.imf.ImfMsg.THE_CLASS_type_DOESNOT_BELONG_TO_PACKAGE_package,
                    iClass.getName(),
                    this.getPackage().getName());
    	}
        switch (((com.informatica.imf.icore.internal.ITypeInternal)iClass).getTypeId()) {
     	    case com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.TABLE_CALL_CAPABILITY_ATTRIBUTES_EXTENSION:
     	        return (T) createTableCallCapabilityAttributesExtension(); 
     	    case com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.TABLE_LOOKUP_CAPABILITY_ATTRIBUTES_EXTENSION:
     	        return (T) createTableLookupCapabilityAttributesExtension(); 
     	    case com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.TABLE_READ_CAPABILITY_ATTRIBUTES_EXTENSION:
     	        return (T) createTableReadCapabilityAttributesExtension(); 
     	    case com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.TABLE_WRITE_CAPABILITY_ATTRIBUTES_EXTENSION:
     	        return (T) createTableWriteCapabilityAttributesExtension(); 
     	    default:
                throw new com.informatica.core.exception.IllegalArgumentException(
                    com.informatica.imf.ImfMsg.THE_CLASS_type_IS_NOT_A_VALID_CLASSIFIER,
                    iClass.getName());
     	}
    }
    /**
     * Returns a proxy instance of the specified IClass.
     * @param iClass
     *            The <code>IClass</code> whose instance needs to be created.
     * @param identity
     *            The identity of the proxy object.
     * @return the proxy instance with its identity set. All data members of the
     *         object are set to their default values
     * @throws com.informatica.imf.icore.exception.InstantiationException
     *              when <code>IClass</code> is abstract/non-identifiable/annotation
     * @throws com.informatica.imf.icore.exception.IllegalArgumentException
     *              when identity is null object
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T createProxy(com.informatica.imf.icore.IClass iClass,
        com.informatica.imf.icore.IIdentity identity) {
        if(!this.getPackage().getTypes().contains(iClass)) {
    		throw new com.informatica.core.exception.IllegalArgumentException(
                    com.informatica.imf.ImfMsg.THE_CLASS_type_DOESNOT_BELONG_TO_PACKAGE_package,
                    iClass.getName(),
                    this.getPackage().getName());
    	}
        if(!iClass.isIdentifiableClass()){
            throw new com.informatica.imf.icore.exception.InstantiationException(
                  com.informatica.imf.ImfMsg.PROXY_OBJECT_CANNOT_BE_CREATED_FOR_class_CLASS,
                  "non-externally referable"
                  );
        }
        if(iClass.isAbstract()){
            throw new com.informatica.imf.icore.exception.InstantiationException(
                  com.informatica.imf.ImfMsg.PROXY_OBJECT_CANNOT_BE_CREATED_FOR_class_CLASS,
                  "abstract"
                  );
        }
        if(iClass.isPrimitive()){
            throw new com.informatica.imf.icore.exception.InstantiationException(
                  com.informatica.imf.ImfMsg.PROXY_OBJECT_CANNOT_BE_CREATED_FOR_class_CLASS,
                  "primitive"
                  );
        }
        if(iClass.isAnnotationClass()){
            throw new com.informatica.imf.icore.exception.InstantiationException(
                  com.informatica.imf.ImfMsg.PROXY_OBJECT_CANNOT_BE_CREATED_FOR_class_CLASS,
                  "annotation"
                  );
        }
        if(identity == null){
            throw new com.informatica.core.exception.IllegalArgumentException(
                  com.informatica.imf.ImfMsg.NULL_IDENTITY_FOR_PROXY_OBJECT);
        }
        switch (((com.informatica.imf.icore.internal.ITypeInternal)iClass).getTypeId()) {
            default:
            throw new com.informatica.core.exception.IllegalArgumentException(
                  com.informatica.imf.ImfMsg.THE_CLASS_type_IS_NOT_A_VALID_CLASSIFIER,
                  iClass.getName());
        }
        
    }
     	
    /**
     * Returns the value of specified IDataType that corresponding with the specified string.
     * Note that this method is specific to enumerations in the package.
     * @param iDataType the ICoreDatatype
     * @param initialValue the initial value.
     * @return the value of specified IDataType that corresponding with the specified string.
     * @throws com.informatica.imf.icore.exception.IllegalArgumentException
     *              when iDataType is not an enumeration in the package.
     */
    public java.lang.Object datatypeFromString(com.informatica.imf.icore.IDatatype iDataType, java.lang.String initialValue) {
        switch (((com.informatica.imf.icore.internal.ITypeInternal)iDataType).getTypeId()) {
            default:
                throw new com.informatica.core.exception.IllegalArgumentException(
                    com.informatica.imf.ImfMsg.THE_DATATYPE_type_IS_NOT_A_VALID_CLASSIFIER,
                    iDataType.getName());
        }
    }
    
    /**
     * Returns the string representation of the specified datatype value.
     * Note that this method is specific to enumerations in the package.
     * @param iDataType the ICore data type.
     * @param value the instance value.
     * @return Returns the string representation of the specified datatype value.
     * @throws com.informatica.imf.icore.exception.IllegalArgumentException
     *              when iDataType is not an enumeration in the package.
     */
    public java.lang.String datatypeToString(com.informatica.imf.icore.IDatatype iDataType, java.lang.Object value) {
        switch (((com.informatica.imf.icore.internal.IDatatypeInternal)iDataType).getTypeId()) {
        
            default:
                throw new com.informatica.core.exception.IllegalArgumentException(
                    com.informatica.imf.ImfMsg.THE_DATATYPE_type_IS_NOT_A_VALID_CLASSIFIER,
                    iDataType.getName());
        }
    }
    
    /**
     * Creates an instance of TableCallCapabilityAttributesExtension IClass.
     * @return an object of type TableCallCapabilityAttributesExtension.
     */
     public com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableCallCapabilityAttributesExtension createTableCallCapabilityAttributesExtension() {
        com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableCallCapabilityAttributesExtension tableCallCapabilityAttributesExtension = new TableCallCapabilityAttributesExtensionImpl();
        return tableCallCapabilityAttributesExtension;
     }

    /**
     * Creates an instance of TableLookupCapabilityAttributesExtension IClass.
     * @return an object of type TableLookupCapabilityAttributesExtension.
     */
     public com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableLookupCapabilityAttributesExtension createTableLookupCapabilityAttributesExtension() {
        com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableLookupCapabilityAttributesExtension tableLookupCapabilityAttributesExtension = new TableLookupCapabilityAttributesExtensionImpl();
        return tableLookupCapabilityAttributesExtension;
     }

    /**
     * Creates an instance of TableReadCapabilityAttributesExtension IClass.
     * @return an object of type TableReadCapabilityAttributesExtension.
     */
     public com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension createTableReadCapabilityAttributesExtension() {
        com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension tableReadCapabilityAttributesExtension = new TableReadCapabilityAttributesExtensionImpl();
        return tableReadCapabilityAttributesExtension;
     }

    /**
     * Creates an instance of TableWriteCapabilityAttributesExtension IClass.
     * @return an object of type TableWriteCapabilityAttributesExtension.
     */
     public com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension createTableWriteCapabilityAttributesExtension() {
        com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension tableWriteCapabilityAttributesExtension = new TableWriteCapabilityAttributesExtensionImpl();
        return tableWriteCapabilityAttributesExtension;
     }
    
    /**
     * Retrieves the IPackage for this IFactory.
     * @return the IPackage for this IFactory.
     */
    @Override
    public com.informatica.imf.icore.IPackage getPackage() {
        return com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage.I_INSTANCE;
    }
}