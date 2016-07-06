package com.unicosolution.adapter.snowflakev2.table.metadata.model;

import com.informatica.adapter.sdkadapter.logical.model.L_ModelExtensionFieldBase;
import com.informatica.imf.annotations.Class;
import com.informatica.imf.annotations.Property;
import com.informatica.imf.annotations.constraints.model.Length;
import com.informatica.imf.annotations.constraints.model.Persistence;
import com.informatica.imf.annotations.constraints.model.Range;
import com.informatica.metadata.common.annotation.model.Parameterizable;
import com.informatica.imf.annotations.ClassKind;
import com.informatica.metadata.common.annotation.model.CppSerializeAsGeneric;

@CppSerializeAsGeneric( extensionPoint = "com.informatica.adapter.sdkadapter.patternblocks.field.P_Field" ,  serializedExtensionClass = "com.informatica.adapter.sdkadapter.logical.L_GenericModelExtensionFieldBase" ,  containerProperty = "genericContainer" )
@com.informatica.imf.annotations.Class( classKind = com.informatica.imf.annotations.ClassKind.SECOND_CLASS_INTERNAL )
public class TableFieldExtensions extends L_ModelExtensionFieldBase  {

    @Property( minOccurs = 1 ,  maxOccurs = 1 )
    boolean isNullable = true;

    @Property( minOccurs = 0 ,  maxOccurs = 1 )
    @Length( min = 0 ,  max = 255 )
    @Persistence( size = 255 )
    String defaultColValue;

}