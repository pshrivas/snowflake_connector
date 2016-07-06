package com.unicosolution.adapter.snowflakev2.table.runtime.capability.model;

import com.informatica.adapter.sdkadapter.asoextension.model.D_ModelExtensionCallCapAttributes;
import com.informatica.imf.annotations.Class;
import com.informatica.imf.annotations.Property;
import com.informatica.imf.annotations.constraints.model.Length;
import com.informatica.imf.annotations.constraints.model.Persistence;
import com.informatica.imf.annotations.constraints.model.Range;
import com.informatica.metadata.common.annotation.model.Parameterizable;
import com.informatica.metadata.common.annotation.model.CppSerializeAsGeneric;
import com.informatica.adapter.sdkadapter.logical.model.L_ModelExtensionNode;

@CppSerializeAsGeneric( extensionPoint = "com.informatica.adapter.sdkadapter.capabilityattribute.D_CallCapabilityAttributes" ,  serializedExtensionClass = "com.informatica.adapter.sdkadapter.asoextension.D_GenericModelExtensionCallCapAttributes" ,  containerProperty = "genericContainer" )
@com.informatica.imf.annotations.Class()
public class TableCallCapabilityAttributesExtension extends D_ModelExtensionCallCapAttributes  {
}