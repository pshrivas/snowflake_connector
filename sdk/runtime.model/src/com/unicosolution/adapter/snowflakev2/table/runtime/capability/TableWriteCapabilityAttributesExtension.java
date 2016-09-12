/*
 * Copyright (c) 2016 Informatica Corporation. All rights reserved.
 */

/*
 * This file is generated. Do not modify.
 * IMF Version: 9.5.0
 * Generation time: 2016-09-12 06:07:28
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
 *     <li>{@link com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#isAbortOnErrors() <em>abortOnErrors</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#isBulkLoad() <em>bulkLoad</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#isOneBatch() <em>oneBatch</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#getPostSql() <em>postSql</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#getPostSql$() <em>postSql$</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#getPreSql() <em>preSql</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#getPreSql$() <em>preSql$</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#isPropagateData() <em>propagateData</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#isStartTransactionForJobs() <em>startTransactionForJobs</em>} </li>
 *     <li>{@link com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension#isTruncateTargetTable() <em>truncateTargetTable</em>} </li>
 * </ul>
 * </p>
 * @Class (isSeeded=false, classKind=com.informatica.imf.annotations.ClassKind.SECOND_CLASS_INTERNAL, isAbstract=false)
 */
 public interface TableWriteCapabilityAttributesExtension extends com.informatica.adapter.sdkadapter.asoextension.D_ModelExtensionWriteCapAttributes {

    /** A constant that references the IClass for this generated Java Class. */
    com.informatica.imf.icore.IClass ICLASS = CapabilityIPackage.I_INSTANCE.getTableWriteCapabilityAttributesExtensionIClass();
    /**
     * Retrieves the 'abortOnErrors' property value for this IObject.
     * @return the 'abortOnErrors' property value for this IObject.
     * @Property (redefines="", minOccurs=1, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    boolean isAbortOnErrors();


    /**
     * Sets the 'abortOnErrors' property value for this IObject.
     * @param abortOnErrors is the new property value for this IObject
     * @see #getAbortOnErrors
     */
    void setAbortOnErrors(boolean abortOnErrors);


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
     * Retrieves the 'oneBatch' property value for this IObject.
     * @return the 'oneBatch' property value for this IObject.
     * @Property (redefines="", minOccurs=1, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    boolean isOneBatch();


    /**
     * Sets the 'oneBatch' property value for this IObject.
     * @param oneBatch is the new property value for this IObject
     * @see #getOneBatch
     */
    void setOneBatch(boolean oneBatch);


    /**
     * Retrieves the 'postSql' property value for this IObject.
     * @return the 'postSql' property value for this IObject.
     * @Property (redefines="", minOccurs=0, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    java.lang.String getPostSql();


    /**
     * Sets the 'postSql' property value for this IObject.
     * @param postSql is the new property value for this IObject
     * @see #getPostSql
     */
    void setPostSql(java.lang.String postSql);


    /**
     * Retrieves the 'postSql$' property value for this IObject.
     * @return the 'postSql$' property value for this IObject.
     * @Property (redefines="", containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.EXTERNAL, containmentType=com.informatica.imf.annotations.ContainmentType.UNSET, isUnique=false, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    com.informatica.metadata.common.parameter.Parameter getPostSql$();


    /**
     * Sets the 'postSql$' property value for this IObject.
     * @param postSql$ is the new property value for this IObject
     * @see #getPostSql$
     */
    void setPostSql$(com.informatica.metadata.common.parameter.Parameter postSql$);


    /**
     * Retrieves the 'preSql' property value for this IObject.
     * @return the 'preSql' property value for this IObject.
     * @Property (redefines="", minOccurs=0, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    java.lang.String getPreSql();


    /**
     * Sets the 'preSql' property value for this IObject.
     * @param preSql is the new property value for this IObject
     * @see #getPreSql
     */
    void setPreSql(java.lang.String preSql);


    /**
     * Retrieves the 'preSql$' property value for this IObject.
     * @return the 'preSql$' property value for this IObject.
     * @Property (redefines="", containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.EXTERNAL, containmentType=com.informatica.imf.annotations.ContainmentType.UNSET, isUnique=false, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    com.informatica.metadata.common.parameter.Parameter getPreSql$();


    /**
     * Sets the 'preSql$' property value for this IObject.
     * @param preSql$ is the new property value for this IObject
     * @see #getPreSql$
     */
    void setPreSql$(com.informatica.metadata.common.parameter.Parameter preSql$);


    /**
     * Retrieves the 'propagateData' property value for this IObject.
     * @return the 'propagateData' property value for this IObject.
     * @Property (redefines="", minOccurs=1, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    boolean isPropagateData();


    /**
     * Sets the 'propagateData' property value for this IObject.
     * @param propagateData is the new property value for this IObject
     * @see #getPropagateData
     */
    void setPropagateData(boolean propagateData);


    /**
     * Retrieves the 'startTransactionForJobs' property value for this IObject.
     * @return the 'startTransactionForJobs' property value for this IObject.
     * @Property (redefines="", minOccurs=1, containerType=com.informatica.imf.annotations.ContainerType.NOT_A_CONTAINER, referenceScope=com.informatica.imf.annotations.ReferenceScope.NONE, containmentType=com.informatica.imf.annotations.ContainmentType.NOT_CONTAINED, isUnique=false, maxOccurs=1, opposite="", redefinability=com.informatica.imf.annotations.Redefinability.FINAL_PROPERTY)
     */
    boolean isStartTransactionForJobs();


    /**
     * Sets the 'startTransactionForJobs' property value for this IObject.
     * @param startTransactionForJobs is the new property value for this IObject
     * @see #getStartTransactionForJobs
     */
    void setStartTransactionForJobs(boolean startTransactionForJobs);


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

        public static com.informatica.imf.icore.IProperty ABORT_ON_ERRORS = null;

        public static com.informatica.imf.icore.IProperty BULK_LOAD = null;

        public static com.informatica.imf.icore.IProperty ONE_BATCH = null;

        public static com.informatica.imf.icore.IProperty POST_SQL = null;

        public static com.informatica.imf.icore.IProperty POST_SQL$ = null;

        public static com.informatica.imf.icore.IProperty PRE_SQL = null;

        public static com.informatica.imf.icore.IProperty PRE_SQL$ = null;

        public static com.informatica.imf.icore.IProperty PROPAGATE_DATA = null;

        public static com.informatica.imf.icore.IProperty START_TRANSACTION_FOR_JOBS = null;

        public static com.informatica.imf.icore.IProperty TRUNCATE_TARGET_TABLE = null;
        static  {
			com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.TableWriteCapabilityAttributesExtensionImpl.initIProperties();
		}
    }
 }