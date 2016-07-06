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
 *     'TableWriteCapabilityAttributesExtension'.
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
 *     <li>{@link com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#isBulkLoad() <em>bulkLoad</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#getPartitionID() <em>partitionID</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#getPartitionID$() <em>partitionID$</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#isTruncateTargetTable() <em>truncateTargetTable</em>} </li>
 * </ul>
 * </p>
 * @Class (isSeeded=false, classKind=com.informatica.imf.annotations.ClassKind.SECOND_CLASS_INTERNAL, isAbstract=false)
 */
 public interface TableWriteCapabilityAttributesExtension extends com.informatica.adapter.sdkadapter.asoextension.D_ModelExtensionWriteCapAttributes {

    /** A constant that references the IClass for this generated Java Class. */
    com.informatica.imf.icore.IClass ICLASS = CapabilityIPackage.I_INSTANCE.getTableWriteCapabilityAttributesExtensionIClass();
    /**
     * Retrieves the 'bulkLoad' property value for this IObject.
     * @return the 'bulkLoad' property value for this IObject.
     * @Property (redefines="", minOccurs=1, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    boolean isBulkLoad();


    /**
     * Sets the 'bulkLoad' property value for this IObject.
     * @param bulkLoad is the new property value for this IObject
     * @see #getBulkLoad
     */
    void setBulkLoad(boolean bulkLoad);


    /**
     * Retrieves the 'partitionID' property value for this IObject.
     * @return the 'partitionID' property value for this IObject.
     * @Property (redefines="", minOccurs=0, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    java.lang.String getPartitionID();


    /**
     * Sets the 'partitionID' property value for this IObject.
     * @param partitionID is the new property value for this IObject
     * @see #getPartitionID
     */
    void setPartitionID(java.lang.String partitionID);


    /**
     * Retrieves the 'partitionID$' property value for this IObject.
     * @return the 'partitionID$' property value for this IObject.
     * @Property (redefines="", containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.EXTERNAL, containmentType=com.informatica.imf.annotations.ContainmentType.UNSET, isUnique=false, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    com.informatica.metadata.common.parameter.Parameter getPartitionID$();


    /**
     * Sets the 'partitionID$' property value for this IObject.
     * @param partitionID$ is the new property value for this IObject
     * @see #getPartitionID$
     */
    void setPartitionID$(com.informatica.metadata.common.parameter.Parameter partitionID$);


    /**
     * Retrieves the 'truncateTargetTable' property value for this IObject.
     * @return the 'truncateTargetTable' property value for this IObject.
     * @Property (redefines="", minOccurs=1, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    boolean isTruncateTargetTable();


    /**
     * Sets the 'truncateTargetTable' property value for this IObject.
     * @param truncateTargetTable is the new property value for this IObject
     * @see #getTruncateTargetTable
     */
    void setTruncateTargetTable(boolean truncateTargetTable);

    /**
     * Exposes the IProperties of the IClass associated with this Object
     */
    static class Properties {

        public static com.informatica.imf.icore.IProperty BULK_LOAD = null;

        public static com.informatica.imf.icore.IProperty PARTITION_I_D = null;

        public static com.informatica.imf.icore.IProperty PARTITION_I_D$ = null;

        public static com.informatica.imf.icore.IProperty TRUNCATE_TARGET_TABLE = null;
        static  {
			com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.TableWriteCapabilityAttributesExtensionImpl.initIProperties();
		}
    }
 }