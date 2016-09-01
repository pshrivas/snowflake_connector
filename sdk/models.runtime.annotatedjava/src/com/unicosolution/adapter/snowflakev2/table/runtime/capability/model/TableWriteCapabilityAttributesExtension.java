package com.unicosolution.adapter.snowflakev2.table.runtime.capability.model;

import com.informatica.adapter.sdkadapter.asoextension.model.D_ModelExtensionWriteCapAttributes;
import com.informatica.imf.annotations.Class;
import com.informatica.imf.annotations.Property;
import com.informatica.imf.annotations.constraints.model.Length;
import com.informatica.imf.annotations.constraints.model.Persistence;
import com.informatica.imf.annotations.constraints.model.Range;
import com.informatica.metadata.common.annotation.model.Parameterizable;
import com.informatica.metadata.common.annotation.model.CppSerializeAsGeneric;
import com.informatica.adapter.sdkadapter.logical.model.L_ModelExtensionNode;

@CppSerializeAsGeneric( extensionPoint = "com.informatica.adapter.sdkadapter.capabilityattribute.D_WriteCapabilityAttributes" ,  serializedExtensionClass = "com.informatica.adapter.sdkadapter.asoextension.D_GenericModelExtensionWriteCapAttributes" ,  containerProperty = "genericContainer" )
@com.informatica.imf.annotations.Class()
public class TableWriteCapabilityAttributesExtension extends D_ModelExtensionWriteCapAttributes  {

    @Property( minOccurs = 1 ,  maxOccurs = 1 )
    boolean truncateTargetTable = false;

    @Property( minOccurs = 1 ,  maxOccurs = 1 )
    boolean bulkLoad = false;

    @Property( minOccurs = 0 ,  maxOccurs = 1 ,  isSubstitutable = true ,  substituteType = com.informatica.metadata.common.parameter.model.Parameter.class )
    @Length( min = 0 ,  max = 255 )
    @Persistence( size = 255 )
    String partitionID;

    @Property( minOccurs = 0 ,  maxOccurs = 1 ,  isSubstitutable = true ,  substituteType = com.informatica.metadata.common.parameter.model.Parameter.class )
    @Length( min = 0 ,  max = 255 )
    @Persistence( size = 255 )
    String preSql;

    @Property( minOccurs = 0 ,  maxOccurs = 1 ,  isSubstitutable = true ,  substituteType = com.informatica.metadata.common.parameter.model.Parameter.class )
    @Length( min = 0 ,  max = 255 )
    @Persistence( size = 255 )
    String postSql;

    @Property( minOccurs = 1 ,  maxOccurs = 1 )
    boolean abortOnErrors = false;

    @Property( minOccurs = 1 ,  maxOccurs = 1 )
    boolean propagateData = false;

    @Property( minOccurs = 1 ,  maxOccurs = 1 )
    boolean oneBatch = false;

    @Property( minOccurs = 1 ,  maxOccurs = 1 )
    boolean startTransactionForJobs = false;

}