/*
 * Copyright (c) 2016 Informatica Corporation. All rights reserved.
 */

/*
 * This file is generated. Do not modify.
 * IMF Version: 9.5.0
 * Generation time: 2016-08-29 17:39:52
 */

package com.unicosolution.adapter.snowflakev2.table.runtime.capability;
/**
 * The package interface for IPackage.
 * 'com.unicosolution.adapter.snowflakev2.table.runtime.capability'
 *
 * <p><br>
 * <b>Thread-Safety</b>
 * <br>This interface is thread-safe. An instance of the class implementing
 * this interface can be accessed by multiple threads concurrently. Note that
 * the package initialization of this package and all its dependent package
 * is also thread-safe.</br>
 * </br></p>
 */
public interface CapabilityIPackage
extends com.informatica.imf.icore.IPackage {
    // Package attributes derived from package namespace and name
    /**
     * Constant for the name of the package.
     */
    java.lang.String I_NAME = "capability";

    /**
     * Constant for the comment associated with the package.
     */
    java.lang.String I_COMMENT = "";

    /**
     * Constant for the namespace prefix.
     */
    java.lang.String I_NS_PREFIX = "com.unicosolution.adapter.snowflakev2.table.runtime";

    /**
     * Constant for the fully qualified name.
     */
    java.lang.String I_QUALIFIED_NAME = I_NS_PREFIX + "." + I_NAME;


    // Create and initialize metamodel for this package (reflective API)
    /**
     * Constant for the package instance.
     */
    com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIPackage I_INSTANCE = com.unicosolution.adapter.snowflakev2.table.runtime.capability.impl.CapabilityIPackageImpl.init();


    /**
     * Retrieves the 'TableCallCapabilityAttributesExtension' IClass
     * defined in this IPackage.
     * @return the 'TableCallCapabilityAttributesExtension' IClass
     * defined in this IPackage
     */
    com.informatica.imf.icore.IClass getTableCallCapabilityAttributesExtensionIClass();


    /**
     * Retrieves the 'TableLookupCapabilityAttributesExtension' IClass
     * defined in this IPackage.
     * @return the 'TableLookupCapabilityAttributesExtension' IClass
     * defined in this IPackage
     */
    com.informatica.imf.icore.IClass getTableLookupCapabilityAttributesExtensionIClass();


    /**
     * Retrieves the 'TableReadCapabilityAttributesExtension' IClass
     * defined in this IPackage.
     * @return the 'TableReadCapabilityAttributesExtension' IClass
     * defined in this IPackage
     */
    com.informatica.imf.icore.IClass getTableReadCapabilityAttributesExtensionIClass();


    /**
     * Retrieves the 'TableWriteCapabilityAttributesExtension' IClass
     * defined in this IPackage.
     * @return the 'TableWriteCapabilityAttributesExtension' IClass
     * defined in this IPackage
     */
    com.informatica.imf.icore.IClass getTableWriteCapabilityAttributesExtensionIClass();
}