package com.unicosolution.adapter.snowflakev2.connection.model;

import com.informatica.metadata.infasdk.connectinfo.sdkadapter.model.SDKConnectInfo;
import com.informatica.imf.annotations.Class;
import com.informatica.imf.annotations.Property;
import com.informatica.imf.annotations.constraints.model.Length;
import com.informatica.imf.annotations.constraints.model.Persistence;
import com.informatica.imf.annotations.constraints.model.Range;
import com.informatica.metadata.common.annotation.model.Parameterizable;
import com.informatica.imf.annotations.ClassKind;
import com.informatica.metadata.common.annotation.model.SerializeAsGenericClass;

@com.informatica.metadata.common.annotation.model.SerializeAsGenericClass( genericClass = "com.informatica.metadata.infasdk.connectinfo.sdkadapter.GenericSDKConnectInfo" )
@com.informatica.imf.annotations.Class( classKind = com.informatica.imf.annotations.ClassKind.FIRST_CLASS )
public class SnowflakeV2ConnectInfo extends SDKConnectInfo  {
}