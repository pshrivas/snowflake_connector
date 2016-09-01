/* 
 * Copyright (c) 2016 Informatica Corporation. All rights reserved. 
 */
 
/*
 * This file is generated. Do not modify.
 * IMF Version: 9.5.0 
 * Generation time: 2016-08-29 17:39:27
 */ 
package com.unicosolution.adapter.snowflakev2.table.metadata;

/**
 * The factory interface for IPackage.
 * 'com.unicosolution.adapter.snowflakev2.table.metadata'
 *
 * <p><br>
 * <b>Thread-Safety</b>
 * <br>This interface is thread-safe. An instance of the class implementing
 * this interface can be accessed by multiple threads concurrently.</br>
 * </br></p>
 */

public interface MetadataIFactory
extends com.informatica.imf.icore.IFactory {

    /**
     * The Factory instance for package
     * 'com.unicosolution.adapter.snowflakev2.table.metadata'.
     */
    com.unicosolution.adapter.snowflakev2.table.metadata.MetadataIFactory I_INSTANCE = new
        com.unicosolution.adapter.snowflakev2.table.metadata.impl.MetadataIFactoryImpl();
    /**
     * Creates an instance of TableFieldExtensions IClass.
     * @return an object of type TableFieldExtensions.
     */

    com.unicosolution.adapter.snowflakev2.table.metadata.TableFieldExtensions createTableFieldExtensions();
    /**
     * Creates an instance of TableRecordExtensions IClass.
     * @return an object of type TableRecordExtensions.
     */

    com.unicosolution.adapter.snowflakev2.table.metadata.TableRecordExtensions createTableRecordExtensions();
}