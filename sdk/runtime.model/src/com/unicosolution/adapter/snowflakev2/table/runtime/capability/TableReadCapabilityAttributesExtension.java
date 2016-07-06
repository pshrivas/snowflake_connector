/*
 * Copyright (c) 2016 Informatica Corporation. All rights reserved.
 */

/*
 * This file is generated. Do not modify.
 * IMF Version: 9.5.0
 * Generation time: 2016-07-05 19:33:16
 */

package com.unicosolution.adapter.snowflakev2.table.runtime.capability;


/**
 * The interface for IClass
 *     'TableReadCapabilityAttributesExtension'.
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
 *     <li>{@link com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension#getPostSQL() <em>postSQL</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension#getPostSQL$() <em>postSQL$</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension#getPreSQL() <em>preSQL</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension#getRowLimit() <em>rowLimit</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension#getRowLimit$() <em>rowLimit$</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension#getRowOffSet() <em>rowOffSet</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension#getRowOffSet$() <em>rowOffSet$</em>} </li>
 * </ul>
 * </p>
 * @Class (isSeeded=false, classKind=com.informatica.imf.annotations.ClassKind.SECOND_CLASS_INTERNAL, isAbstract=false)
 */
 public interface TableReadCapabilityAttributesExtension extends com.informatica.adapter.sdkadapter.asoextension.D_ModelExtensionReadCapAttributes {

    /** A constant that references the IClass for this generated Java Class. */
    com.informatica.imf.icore.IClass ICLASS = CapabilityIPackage.I_INSTANCE.getTableReadCapabilityAttributesExtensionIClass();
    /**
     * Retrieves the 'postSQL' property value for this IObject.
     * @return the 'postSQL' property value for this IObject.
     * @Property (redefines="", minOccurs=0, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    java.lang.String getPostSQL();


    /**
     * Sets the 'postSQL' property value for this IObject.
     * @param postSQL is the new property value for this IObject
     * @see #getPostSQL
     */
    void setPostSQL(java.lang.String postSQL);


    /**
     * Retrieves the 'postSQL$' property value for this IObject.
     * @return the 'postSQL$' property value for this IObject.
     * @Property (redefines="", containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.EXTERNAL, containmentType=com.informatica.imf.annotations.ContainmentType.UNSET, isUnique=false, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    com.informatica.metadata.common.parameter.Parameter getPostSQL$();


    /**
     * Sets the 'postSQL$' property value for this IObject.
     * @param postSQL$ is the new property value for this IObject
     * @see #getPostSQL$
     */
    void setPostSQL$(com.informatica.metadata.common.parameter.Parameter postSQL$);


    /**
     * Retrieves the 'preSQL' property value for this IObject.
     * @return the 'preSQL' property value for this IObject.
     * @Property (redefines="", minOccurs=0, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    java.lang.String getPreSQL();


    /**
     * Sets the 'preSQL' property value for this IObject.
     * @param preSQL is the new property value for this IObject
     * @see #getPreSQL
     */
    void setPreSQL(java.lang.String preSQL);


    /**
     * Retrieves the 'rowLimit' property value for this IObject.
     * @return the 'rowLimit' property value for this IObject.
     * @Property (redefines="", minOccurs=0, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    java.lang.Integer getRowLimit();


    /**
     * Sets the 'rowLimit' property value for this IObject.
     * @param rowLimit is the new property value for this IObject
     * @see #getRowLimit
     */
    void setRowLimit(java.lang.Integer rowLimit);


    /**
     * Retrieves the 'rowLimit$' property value for this IObject.
     * @return the 'rowLimit$' property value for this IObject.
     * @Property (redefines="", containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.EXTERNAL, containmentType=com.informatica.imf.annotations.ContainmentType.UNSET, isUnique=false, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    com.informatica.metadata.common.parameter.Parameter getRowLimit$();


    /**
     * Sets the 'rowLimit$' property value for this IObject.
     * @param rowLimit$ is the new property value for this IObject
     * @see #getRowLimit$
     */
    void setRowLimit$(com.informatica.metadata.common.parameter.Parameter rowLimit$);


    /**
     * Retrieves the 'rowOffSet' property value for this IObject.
     * @return the 'rowOffSet' property value for this IObject.
     * @Property (redefines="", minOccurs=0, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    java.lang.Integer getRowOffSet();


    /**
     * Sets the 'rowOffSet' property value for this IObject.
     * @param rowOffSet is the new property value for this IObject
     * @see #getRowOffSet
     */
    void setRowOffSet(java.lang.Integer rowOffSet);


    /**
     * Retrieves the 'rowOffSet$' property value for this IObject.
     * @return the 'rowOffSet$' property value for this IObject.
     * @Property (redefines="", containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.EXTERNAL, containmentType=com.informatica.imf.annotations.ContainmentType.UNSET, isUnique=false, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    com.informatica.metadata.common.parameter.Parameter getRowOffSet$();


    /**
     * Sets the 'rowOffSet$' property value for this IObject.
     * @param rowOffSet$ is the new property value for this IObject
     * @see #getRowOffSet$
     */
    void setRowOffSet$(com.informatica.metadata.common.parameter.Parameter rowOffSet$);

    /**
     * Exposes the IProperties of the IClass associated with this Object
     */
    static class Properties {

        public static com.informatica.imf.icore.IProperty POST_S_Q_L = null;

        public static com.informatica.imf.icore.IProperty POST_S_Q_L$ = null;

        public static com.informatica.imf.icore.IProperty PRE_S_Q_L = null;

        public static com.informatica.imf.icore.IProperty ROW_LIMIT = null;

        public static com.informatica.imf.icore.IProperty ROW_LIMIT$ = null;

        public static com.informatica.imf.icore.IProperty ROW_OFF_SET = null;

        public static com.informatica.imf.icore.IProperty ROW_OFF_SET$ = null;
        static  {
			com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.TableReadCapabilityAttributesExtensionImpl.initIProperties();
		}
    }
 }