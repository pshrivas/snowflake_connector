/* 
 * Copyright (c) 2016 Informatica Corporation. All rights reserved. 
 */
 
/*
 * This file is generated. Do not modify.
 * IMF Version: 9.5.0 
 * Generation time: 2016-11-22 20:37:13
 */ 
package com.unicosolution.adapter.snowflakev2.connection;

/**
 * The factory interface for IPackage.
 * 'com.unicosolution.adapter.snowflakev2.connection'
 *
 * <p><br>
 * <b>Thread-Safety</b>
 * <br>This interface is thread-safe. An instance of the class implementing
 * this interface can be accessed by multiple threads concurrently.</br>
 * </br></p>
 */

public interface ConnectionIFactory
extends com.informatica.imf.icore.IFactory {

    /**
     * The Factory instance for package
     * 'com.unicosolution.adapter.snowflakev2.connection'.
     */
    com.unicosolution.adapter.snowflakev2.connection.ConnectionIFactory I_INSTANCE = new
        com.unicosolution.adapter.snowflakev2.connection.impl.ConnectionIFactoryImpl();
    /**
     * Creates an instance of SnowflakeV2ConnectInfoExtension IClass.
     * @return an object of type SnowflakeV2ConnectInfoExtension.
     */

    com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfoExtension createSnowflakeV2ConnectInfoExtension();
    /**
     * Creates an instance of SnowflakeV2ConnectInfo IClass.
     * @return an object of type SnowflakeV2ConnectInfo.
     */

    com.unicosolution.adapter.snowflakev2.connection.SnowflakeV2ConnectInfo createSnowflakeV2ConnectInfo();
}