/* 
 * Copyright (c) 2016 Informatica Corporation. All rights reserved. 
 */
 
/*
 * This file is generated. Do not modify.
 * IMF Version: 9.5.0 
 * Generation time: 2016-09-21 20:40:27
 */ 
package com.unicosolution.adapter.snowflakev2.table.runtime.capability;

/**
 * The factory interface for IPackage.
 * 'com.unicosolution.adapter.snowflakev2.table.runtime.capability'
 *
 * <p><br>
 * <b>Thread-Safety</b>
 * <br>This interface is thread-safe. An instance of the class implementing
 * this interface can be accessed by multiple threads concurrently.</br>
 * </br></p>
 */

public interface CapabilityIFactory
extends com.informatica.imf.icore.IFactory {

    /**
     * The Factory instance for package
     * 'com.unicosolution.adapter.snowflakev2.table.runtime.capability'.
     */
    com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIFactory I_INSTANCE = new
        com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIFactoryImpl();
    /**
     * Creates an instance of TableCallCapabilityAttributesExtension IClass.
     * @return an object of type TableCallCapabilityAttributesExtension.
     */

    com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableCallCapabilityAttributesExtension createTableCallCapabilityAttributesExtension();
    /**
     * Creates an instance of TableLookupCapabilityAttributesExtension IClass.
     * @return an object of type TableLookupCapabilityAttributesExtension.
     */

    com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableLookupCapabilityAttributesExtension createTableLookupCapabilityAttributesExtension();
    /**
     * Creates an instance of TableReadCapabilityAttributesExtension IClass.
     * @return an object of type TableReadCapabilityAttributesExtension.
     */

    com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension createTableReadCapabilityAttributesExtension();
    /**
     * Creates an instance of TableWriteCapabilityAttributesExtension IClass.
     * @return an object of type TableWriteCapabilityAttributesExtension.
     */

    com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension createTableWriteCapabilityAttributesExtension();
}