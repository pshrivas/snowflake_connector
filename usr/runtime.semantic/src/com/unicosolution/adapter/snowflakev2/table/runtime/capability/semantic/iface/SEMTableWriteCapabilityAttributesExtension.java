// Copyright (c) 2010 Informatica Corporation. All rights reserved.

// *** This file is generated. Do not modify. ***

package com.unicosolution.adapter.snowflakev2.table.runtime.capability.semantic.iface;



public interface SEMTableWriteCapabilityAttributesExtension extends com.informatica.sdk.adapter.metadata.extension.semantic.iface.Extension
{

    /** 
      * Get the 'UpdateMode' property.
      */
    public String getUpdateMode();
    /** 
      * Set the 'UpdateMode' property.
      */
    public void setUpdateMode(String _newVal);
    /** 
      * Get the 'truncateTargetTable' property.
      */
    public boolean isTruncateTargetTable();
    /** 
      * Set the 'truncateTargetTable' property.
      */
    public void setTruncateTargetTable(boolean _newVal);
    /** 
      * Get the 'preSql' property.
      */
    public String getPreSql();
    /** 
      * Set the 'preSql' property.
      */
    public void setPreSql(String _newVal);
    /** 
      * Get the 'postSql' property.
      */
    public String getPostSql();
    /** 
      * Set the 'postSql' property.
      */
    public void setPostSql(String _newVal);
    /** 
      * Get the 'abortOnErrors' property.
      */
    public boolean isAbortOnErrors();
    /** 
      * Set the 'abortOnErrors' property.
      */
    public void setAbortOnErrors(boolean _newVal);
    /** 
      * Get the 'propagateData' property.
      */
    public boolean isPropagateData();
    /** 
      * Set the 'propagateData' property.
      */
    public void setPropagateData(boolean _newVal);
    /** 
      * Get the 'oneBatch' property.
      */
    public boolean isOneBatch();
    /** 
      * Set the 'oneBatch' property.
      */
    public void setOneBatch(boolean _newVal);
    /** 
      * Get the 'startTransactionForJobs' property.
      */
    public boolean isStartTransactionForJobs();
    /** 
      * Set the 'startTransactionForJobs' property.
      */
    public void setStartTransactionForJobs(boolean _newVal);
    /** 
      * Get the 'updateKeyColumns' property.
      */
    public String getUpdateKeyColumns();
    /** 
      * Set the 'updateKeyColumns' property.
      */
    public void setUpdateKeyColumns(String _newVal);
}
