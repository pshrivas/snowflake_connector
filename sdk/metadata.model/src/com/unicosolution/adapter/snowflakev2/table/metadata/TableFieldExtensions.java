/*
 * Copyright (c) 2016 Informatica Corporation. All rights reserved.
 */

/*
 * This file is generated. Do not modify.
 * IMF Version: 9.5.0
 * Generation time: 2016-09-16 12:10:01
 */

package com.unicosolution.adapter.snowflakev2.table.metadata;


/**
 * The interface for IClass
 *     'TableFieldExtensions'.
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
 *     <li>{@link com.unicosolution.adapter.snowflakev2.table.metadata.TableFieldExtensions#getDefaultColValue() <em>defaultColValue</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.table.metadata.TableFieldExtensions#isIsNullable() <em>isNullable</em>} </li>
 * </ul>
 * </p>
 * @Class (isSeeded=false, classKind=com.informatica.imf.annotations.ClassKind.SECOND_CLASS_INTERNAL, isAbstract=false)
 */
 public interface TableFieldExtensions extends com.informatica.adapter.sdkadapter.logical.L_ModelExtensionFieldBase {

    /** A constant that references the IClass for this generated Java Class. */
    com.informatica.imf.icore.IClass ICLASS = MetadataIPackage.I_INSTANCE.getTableFieldExtensionsIClass();
    /**
     * Retrieves the 'defaultColValue' property value for this IObject.
     * @return the 'defaultColValue' property value for this IObject.
     * @Property (redefines="", minOccurs=0, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    java.lang.String getDefaultColValue();


    /**
     * Sets the 'defaultColValue' property value for this IObject.
     * @param defaultColValue is the new property value for this IObject
     * @see #getDefaultColValue
     */
    void setDefaultColValue(java.lang.String defaultColValue);


    /**
     * Retrieves the 'isNullable' property value for this IObject.
     * @return the 'isNullable' property value for this IObject.
     * @Property (redefines="", minOccurs=1, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    boolean isIsNullable();


    /**
     * Sets the 'isNullable' property value for this IObject.
     * @param isNullable is the new property value for this IObject
     * @see #getIsNullable
     */
    void setIsNullable(boolean isNullable);

    /**
     * Exposes the IProperties of the IClass associated with this Object
     */
    static class Properties {

        public static com.informatica.imf.icore.IProperty DEFAULT_COL_VALUE = null;

        public static com.informatica.imf.icore.IProperty IS_NULLABLE = null;
        static  {
			com.unicosolution.adapter.snowflakev2.table.metadata.impl.TableFieldExtensionsImpl.initIProperties();
		}
    }
 }