/*
 * Copyright (c) 2016 Informatica Corporation. All rights reserved.
 */

/*
 * This file is generated. Do not modify.
 * IMF Version: 9.5.0
 * Generation time: 2016-07-05 19:32:59
 */

package com.unicosolution.adapter.snowflakev2.table.metadata;


/**
 * The interface for IClass
 *     'TableRecordExtensions'.
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
 *     <li>{@link com.unicosolution.adapter.snowflakev2.table.metadata.TableRecordExtensions#getTableType() <em>tableType</em>} </li>
 * </ul>
 * </p>
 * @Class (isSeeded=false, classKind=com.informatica.imf.annotations.ClassKind.SECOND_CLASS_INTERNAL, isAbstract=false)
 */
 public interface TableRecordExtensions extends com.informatica.adapter.sdkadapter.logical.L_ModelExtensionNode {

    /** A constant that references the IClass for this generated Java Class. */
    com.informatica.imf.icore.IClass ICLASS = MetadataIPackage.I_INSTANCE.getTableRecordExtensionsIClass();
    /**
     * Retrieves the 'tableType' property value for this IObject.
     * @return the 'tableType' property value for this IObject.
     * @Property (redefines="", minOccurs=0, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    java.lang.String getTableType();


    /**
     * Sets the 'tableType' property value for this IObject.
     * @param tableType is the new property value for this IObject
     * @see #getTableType
     */
    void setTableType(java.lang.String tableType);

    /**
     * Exposes the IProperties of the IClass associated with this Object
     */
    static class Properties {

        public static com.informatica.imf.icore.IProperty TABLE_TYPE = null;
        static  {
			com.unicosolution.adapter.snowflakev2.table.metadata.impl.TableRecordExtensionsImpl.initIProperties();
		}
    }
 }