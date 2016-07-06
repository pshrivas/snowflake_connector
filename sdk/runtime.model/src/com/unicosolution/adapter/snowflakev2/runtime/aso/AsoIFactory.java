/* 
 * Copyright (c) 2016 Informatica Corporation. All rights reserved. 
 */
 
/*
 * This file is generated. Do not modify.
 * IMF Version: 9.5.0 
 * Generation time: 2016-07-05 19:33:15
 */ 
package com.unicosolution.adapter.snowflakev2.runtime.aso;

/**
 * The factory interface for IPackage.
 * 'com.unicosolution.adapter.snowflakev2.runtime.aso'
 *
 * <p><br>
 * <b>Thread-Safety</b>
 * <br>This interface is thread-safe. An instance of the class implementing
 * this interface can be accessed by multiple threads concurrently.</br>
 * </br></p>
 */

public interface AsoIFactory
extends com.informatica.imf.icore.IFactory {

    /**
     * The Factory instance for package
     * 'com.unicosolution.adapter.snowflakev2.runtime.aso'.
     */
    com.unicosolution.adapter.snowflakev2.runtime.aso.AsoIFactory I_INSTANCE = new
        com.unicosolution.adapter.snowflakev2.runtime.aso.impl.AsoIFactoryImpl();
    /**
     * Creates an instance of ComplexASO IClass.
     * @return an object of type ComplexASO.
     */

    com.unicosolution.adapter.snowflakev2.runtime.aso.ComplexASO createComplexASO();
}