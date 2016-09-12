package com.unicosolution.adapter.snowflakev2.connection.model;

import com.informatica.metadata.infasdk.connectinfo.common.sdkmodelextension.model.SDKConnectInfoModelExtension;
import com.informatica.imf.annotations.Class;
import com.informatica.imf.annotations.Property;
import com.informatica.imf.annotations.constraints.model.Length;
import com.informatica.imf.annotations.constraints.model.Persistence;
import com.informatica.imf.annotations.constraints.model.Range;
import com.informatica.metadata.common.annotation.model.Parameterizable;
import com.informatica.imf.annotations.ClassKind;
import com.informatica.metadata.common.annotation.model.CppSerializeAsGeneric;

@CppSerializeAsGeneric( extensionPoint = "com.informatica.metadata.infasdk.connectinfo.sdkadapter.SDKConnectInfo" ,  serializedExtensionClass = "com.informatica.metadata.infasdk.connectinfo.common.sdkmodelextension.GenericSDKConnectInfoModelExtension" ,  containerProperty = "genericContainer" )
@com.informatica.imf.annotations.Class( classKind = com.informatica.imf.annotations.ClassKind.SECOND_CLASS_INTERNAL )
public class SnowflakeV2ConnectInfoExtension extends SDKConnectInfoModelExtension  {

    @Property( minOccurs = 1 ,  maxOccurs = 1 )
    @Length( min = 0 ,  max = 50 )
    @Persistence( size = 50 )
    String user;

    @Property( isSensitive = true ,  minOccurs = 1 ,  maxOccurs = 1 )
    @Length( min = 0 ,  max = 50 )
    @Persistence( size = 50 )
    String password;

    @Property( minOccurs = 0 ,  maxOccurs = 1 )
    @Length( min = 0 ,  max = 100 )
    @Persistence( size = 100 )
    String db;

    @Property( minOccurs = 0 ,  maxOccurs = 1 )
    @Length( min = 0 ,  max = 100 )
    @Persistence( size = 100 )
    String warehouse;

    @Property( minOccurs = 1 ,  maxOccurs = 1 )
    @Length( min = 0 ,  max = 50 )
    @Persistence( size = 50 )
    String account;

    @Property( minOccurs = 0 ,  maxOccurs = 1 )
    @Length( min = 0 ,  max = 50 )
    @Persistence( size = 50 )
    String role;

    @Property( minOccurs = 1 ,  maxOccurs = 1 )
    @Length( min = 0 ,  max = 25 )
    @Persistence( size = 25 )
    String schema;

    @Property( minOccurs = 1 ,  maxOccurs = 1 )
    boolean useCustomURL = false;

    @Property( minOccurs = 0 ,  maxOccurs = 1 )
    @Length( min = 0 ,  max = 255 )
    @Persistence( size = 255 )
    String customURL;

    @Property( minOccurs = 1 ,  maxOccurs = 1 )
    boolean clientSessionKeepAlive = true;

}