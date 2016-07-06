// Copyright (c) 2010 Informatica Corporation. All rights reserved.

// *** This file is generated. Do not modify. ***

package com.unicosolution.adapter.snowflakev2.table.runtime.capability.semantic.iface;



public interface SEMTableWriteCapabilityAttributesExtension extends com.informatica.sdk.adapter.metadata.extension.semantic.iface.Extension
{

    /** 
      * Get the 'truncateTargetTable' property.
      */
    public boolean isTruncateTargetTable();
    /** 
      * Set the 'truncateTargetTable' property.
      */
    public void setTruncateTargetTable(boolean _newVal);
    /** 
      * Get the 'bulkLoad' property.
      */
    public boolean isBulkLoad();
    /** 
      * Set the 'bulkLoad' property.
      */
    public void setBulkLoad(boolean _newVal);
    /** 
      * Get the 'partitionID' property.
      */
    public String getPartitionID();
    /** 
      * Set the 'partitionID' property.
      */
    public void setPartitionID(String _newVal);
}
