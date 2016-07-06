package com.unicosolution.adapter.snowflakev2.typesystem;

import com.informatica.imf.icore.IMFRuntime;
import com.informatica.imf.icore.exception.SeedException;
import com.informatica.metadata.common.typesystem.DataType;
import com.informatica.metadata.common.typesystem.TypeSystem;
import com.informatica.metadata.common.typesystem.directmaps.DirectTypeSystemMap;
import com.informatica.metadata.common.typesystem.directmaps.util.DirectMapUtils;
import com.informatica.metadata.common.typesystem.storagesemantics.LengthUnitKind;
import com.informatica.metadata.common.typesystem.storagesemantics.RadixKind;
import com.informatica.metadata.common.typesystem.storagesemantics.util.StorageSemanticsUtils;
import com.informatica.metadata.common.typesystem.util.TypeSystemUtils;
import com.informatica.metadata.seed.platform.Platform;

@SuppressWarnings("unused")
@com.informatica.imf.annotations.seed.SeedProvider
public class SnowflakeV2TypeSystem  {

    @com.informatica.imf.annotations.seed.Seed
    public static final TypeSystem typesystem = TypeSystemUtils.INSTANCE.createTypeSystem("com.unicosolution.adapter.snowflakev2.typesystem.SnowflakeV2TypeSystem", 
                                                                                          "SNOWFLAKEV2", "SnowflakeV2 Adapter Type System");

    public static final DataType stringDT = StorageSemanticsUtils.INSTANCE.createLengthSemanticsDataType(typesystem, "String", 
                                                                                                         "", 65536, 255, 
                                                                                                         LengthUnitKind.characters, 
                                                                                                         true, true);

    public static final DataType integerDT = StorageSemanticsUtils.INSTANCE.createIntegralSemanticsDataType(typesystem, 
                                                                                                            "INTEGER", "", 
                                                                                                            10, 10, false);

    public static final DataType timestampDT = StorageSemanticsUtils.INSTANCE.createGDateSemanticsDataType(typesystem, "TIMESTAMP", 
                                                                                                           "", true, true, 
                                                                                                           true, true, true, 
                                                                                                           true, false, 
                                                                                                           6, 6, true);

    public static final DataType doubleDT = StorageSemanticsUtils.INSTANCE.createFloatSemanticsDataType(typesystem, "DOUBLE", 
                                                                                                        "", 15, 15, true, 
                                                                                                        RadixKind.binary, 
                                                                                                        252, 252, RadixKind.decimal);

    public static final DataType timestampntzDT = StorageSemanticsUtils.INSTANCE.createLengthSemanticsDataType(typesystem, 
                                                                                                               "TIMESTAMPNTZ", 
                                                                                                               "", 65536, 
                                                                                                               255, LengthUnitKind.characters, 
                                                                                                               true, true);

    public static final DataType numberDT = StorageSemanticsUtils.INSTANCE.createIntegralSemanticsDataType(typesystem, "NUMBER", 
                                                                                                           "", 38, 38, true);

    public static final DataType varcharDT = StorageSemanticsUtils.INSTANCE.createLengthSemanticsDataType(typesystem, "VARCHAR", 
                                                                                                          "", 65536, 255, 
                                                                                                          LengthUnitKind.characters, 
                                                                                                          true, true);

    public static final DataType dateDT = StorageSemanticsUtils.INSTANCE.createGDateSemanticsDataType(typesystem, "DATE", 
                                                                                                      "", true, true, true, 
                                                                                                      false, false, false, 
                                                                                                      false, 10, 10, false);

    public static final DataType floatDT = StorageSemanticsUtils.INSTANCE.createFloatSemanticsDataType(typesystem, "FLOAT", 
                                                                                                       "", 15, 15, false, 
                                                                                                       RadixKind.decimal, 
                                                                                                       11, 0, RadixKind.binary);

    public static final DataType variantDT = StorageSemanticsUtils.INSTANCE.createLengthSemanticsDataType(typesystem, "VARIANT", 
                                                                                                          "", 65536, 255, 
                                                                                                          LengthUnitKind.characters, 
                                                                                                          true, true);

    public static final DataType objectDT = StorageSemanticsUtils.INSTANCE.createLengthSemanticsDataType(typesystem, "OBJECT", 
                                                                                                         "", 65536, 255, 
                                                                                                         LengthUnitKind.characters, 
                                                                                                         true, true);

    public static final DataType arrayDT = StorageSemanticsUtils.INSTANCE.createLengthSemanticsDataType(typesystem, "ARRAY", 
                                                                                                        "", 65536, 255, 
                                                                                                        LengthUnitKind.characters, 
                                                                                                        true, true);

    public static final DataType booleanDT = StorageSemanticsUtils.INSTANCE.createLengthSemanticsDataType(typesystem, "BOOLEAN", 
                                                                                                          "", 5, 5, LengthUnitKind.characters, 
                                                                                                          true, true);

    public static final DataType timeDT = StorageSemanticsUtils.INSTANCE.createGDateSemanticsDataType(typesystem, "TIME", 
                                                                                                      "", false, false, 
                                                                                                      false, true, true, 
                                                                                                      true, false, 6, 6, 
                                                                                                      false);

    public static final DataType timestampltzDT = StorageSemanticsUtils.INSTANCE.createGDateSemanticsDataType(typesystem, 
                                                                                                              "TIMESTAMPLTZ", 
                                                                                                              "", true, 
                                                                                                              true, true, 
                                                                                                              true, true, 
                                                                                                              true, true, 
                                                                                                              9, 9, true);

    public static final DataType timestamptzDT = StorageSemanticsUtils.INSTANCE.createGDateSemanticsDataType(typesystem, 
                                                                                                             "TIMESTAMPTZ", 
                                                                                                             "", true, true, 
                                                                                                             true, true, 
                                                                                                             true, true, 
                                                                                                             true, 9, 9, 
                                                                                                             true);

    private static final DirectTypeSystemMap snowflakev2PlatformMap = DirectMapUtils.INSTANCE.createDirectTypeSystemMap(
                                                                                                                        typesystem, 
                                                                                                                        Platform.typesystem);
    static {
            DirectMapUtils.INSTANCE.createDataTypeMap(snowflakev2PlatformMap, arrayDT, Platform.stringDT, false, false, 
                                                      true, false);
            DirectMapUtils.INSTANCE.createDataTypeMap(snowflakev2PlatformMap, objectDT, Platform.stringDT, false, false, 
                                                      true, false);
            DirectMapUtils.INSTANCE.createDataTypeMap(snowflakev2PlatformMap, integerDT, Platform.integerDT, false, false, 
                                                      true, true);
            DirectMapUtils.INSTANCE.createDataTypeMap(snowflakev2PlatformMap, doubleDT, Platform.doubleDT, false, false, 
                                                      true, false);
            DirectMapUtils.INSTANCE.createDataTypeMap(snowflakev2PlatformMap, varcharDT, Platform.stringDT, false, false, 
                                                      true, true);
            DirectMapUtils.INSTANCE.createDataTypeMap(snowflakev2PlatformMap, arrayDT, Platform.textDT, false, false, false, 
                                                      false);
            DirectMapUtils.INSTANCE.createDataTypeMap(snowflakev2PlatformMap, dateDT, Platform.dateDT, false, false, true, 
                                                      true);
            DirectMapUtils.INSTANCE.createDataTypeMap(snowflakev2PlatformMap, timestampntzDT, Platform.stringDT, false, 
                                                      false, true, false);
            DirectMapUtils.INSTANCE.createDataTypeMap(snowflakev2PlatformMap, timestamptzDT, Platform.dateDT, false, false, 
                                                      true, false);
            DirectMapUtils.INSTANCE.createDataTypeMap(snowflakev2PlatformMap, timestampntzDT, Platform.textDT, false, false, 
                                                      false, false);
            DirectMapUtils.INSTANCE.createDataTypeMap(snowflakev2PlatformMap, variantDT, Platform.stringDT, false, false, 
                                                      true, false);
            DirectMapUtils.INSTANCE.createDataTypeMap(snowflakev2PlatformMap, variantDT, Platform.textDT, false, false, 
                                                      false, true);
            DirectMapUtils.INSTANCE.createDataTypeMap(snowflakev2PlatformMap, timestampDT, Platform.dateDT, false, false, 
                                                      true, false);
            DirectMapUtils.INSTANCE.createDataTypeMap(snowflakev2PlatformMap, stringDT, Platform.textDT, false, false, true, 
                                                      false);
            DirectMapUtils.INSTANCE.createDataTypeMap(snowflakev2PlatformMap, timestampntzDT, Platform.dateDT, false, false, 
                                                      false, false);
            DirectMapUtils.INSTANCE.createDataTypeMap(snowflakev2PlatformMap, booleanDT, Platform.integerDT, false, false, 
                                                      false, false);
            DirectMapUtils.INSTANCE.createDataTypeMap(snowflakev2PlatformMap, objectDT, Platform.textDT, false, false, false, 
                                                      false);
            DirectMapUtils.INSTANCE.createDataTypeMap(snowflakev2PlatformMap, booleanDT, Platform.stringDT, false, false, 
                                                      true, false);
            DirectMapUtils.INSTANCE.createDataTypeMap(snowflakev2PlatformMap, floatDT, Platform.doubleDT, false, false, 
                                                      true, true);
            DirectMapUtils.INSTANCE.createDataTypeMap(snowflakev2PlatformMap, timeDT, Platform.dateDT, false, false, true, 
                                                      false);
            DirectMapUtils.INSTANCE.createDataTypeMap(snowflakev2PlatformMap, timestampltzDT, Platform.dateDT, false, false, 
                                                      true, false);
            DirectMapUtils.INSTANCE.createDataTypeMap(snowflakev2PlatformMap, numberDT, Platform.integerDT, false, false, 
                                                      true, false);
            DirectMapUtils.INSTANCE.createDataTypeMap(snowflakev2PlatformMap, booleanDT, Platform.textDT, false, false, 
                                                      false, false);
    }

    static {
            try {
             	 IMFRuntime.getInstance().getSeedRegistry().register(SnowflakeV2TypeSystem.class);
            } catch (SeedException e) {
            	e.printStackTrace();
            }
    }


    private SnowflakeV2TypeSystem(){}


}