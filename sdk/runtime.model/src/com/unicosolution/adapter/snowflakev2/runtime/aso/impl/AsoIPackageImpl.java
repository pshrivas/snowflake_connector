/*
 * Copyright (c)  Informatica Corporation. All rights reserved.
 */

/*
 * This file is generated. Do not modify.
 * IMF Version: 
 * Generation time: 
 */
package com.unicosolution.adapter.snowflakev2.runtime.aso.impl;

import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * The package implementation for IPackage.
 * 'com.unicosolution.adapter.snowflakev2.runtime.aso'
 */
public final class AsoIPackageImpl
extends com.informatica.imf.icore.impl.IPackageImpl
implements com.unicosolution.adapter.snowflakev2.runtime.aso.AsoIPackage {

    /**
     * The generated Serial Version UID.
     */
      private static final long serialVersionUID = -6266920932270985242L;

    /**
     * The IMF version that this package was generated with.
     */
    private static final String GENERATED_WITH_IMF_VERSION = "9.5.0";

    /**
     * @handcoded
     */
    private static final Logger LOGGER = Logger.getLogger(com.informatica.imf.icore.impl.IPackageImpl.class.getName());


    /**
     * Constant for class 'ComplexASO'.
     */
    public static final int COMPLEX_A_S_O = 0;


    /**
     * Constant for feature constant in class 'ComplexASO'.
     */
    private static final int COMPLEX_A_S_O_FEATURE_COUNT = com.informatica.adapter.sdkadapter.aso.impl.AsoIPackageImpl.getD__COMPLEX_A_S_OFeatureCount()+0;



    private com.informatica.imf.icore.IClass complexASOIClass = null;
    private static com.informatica.metadata.common.parameter.impl.ParameterIPackageImpl theComInformaticaMetadataCommonParameterIPackage = (com.informatica.metadata.common.parameter.impl.ParameterIPackageImpl)com.informatica.metadata.common.parameter.ParameterIPackage.I_INSTANCE;
    private static com.informatica.metadata.common.datasourceoperation.impl.DatasourceoperationIPackageImpl theComInformaticaMetadataCommonDatasourceoperationIPackage = (com.informatica.metadata.common.datasourceoperation.impl.DatasourceoperationIPackageImpl)com.informatica.metadata.common.datasourceoperation.DatasourceoperationIPackage.I_INSTANCE;
    private static com.informatica.metadata.common.partitionpoint.impl.PartitionpointIPackageImpl theComInformaticaMetadataCommonPartitionpointIPackage = (com.informatica.metadata.common.partitionpoint.impl.PartitionpointIPackageImpl)com.informatica.metadata.common.partitionpoint.PartitionpointIPackage.I_INSTANCE;
    private static com.informatica.metadata.common.modelextension.impl.ModelextensionIPackageImpl theComInformaticaMetadataCommonModelextensionIPackage = (com.informatica.metadata.common.modelextension.impl.ModelextensionIPackageImpl)com.informatica.metadata.common.modelextension.ModelextensionIPackage.I_INSTANCE;
    private static com.informatica.metadata.common.adapter.impl.AdapterIPackageImpl theComInformaticaMetadataCommonAdapterIPackage = (com.informatica.metadata.common.adapter.impl.AdapterIPackageImpl)com.informatica.metadata.common.adapter.AdapterIPackage.I_INSTANCE;
    private static com.informatica.adapter.sdkadapter.asoextension.impl.AsoextensionIPackageImpl theComInformaticaAdapterSdkadapterAsoextensionIPackage = (com.informatica.adapter.sdkadapter.asoextension.impl.AsoextensionIPackageImpl)com.informatica.adapter.sdkadapter.asoextension.AsoextensionIPackage.I_INSTANCE;
    private static com.informatica.adapter.sdkadapter.projection.impl.ProjectionIPackageImpl theComInformaticaAdapterSdkadapterProjectionIPackage = (com.informatica.adapter.sdkadapter.projection.impl.ProjectionIPackageImpl)com.informatica.adapter.sdkadapter.projection.ProjectionIPackage.I_INSTANCE;
    private static com.informatica.metadata.common.component.impl.ComponentIPackageImpl theComInformaticaMetadataCommonComponentIPackage = (com.informatica.metadata.common.component.impl.ComponentIPackageImpl)com.informatica.metadata.common.component.ComponentIPackage.I_INSTANCE;
    private static com.informatica.adapter.sdkadapter.asoconfig.impl.AsoconfigIPackageImpl theComInformaticaAdapterSdkadapterAsoconfigIPackage = (com.informatica.adapter.sdkadapter.asoconfig.impl.AsoconfigIPackageImpl)com.informatica.adapter.sdkadapter.asoconfig.AsoconfigIPackage.I_INSTANCE;
    private static com.informatica.adapter.sdkadapter.aso.impl.AsoIPackageImpl theComInformaticaAdapterSdkadapterAsoIPackage = (com.informatica.adapter.sdkadapter.aso.impl.AsoIPackageImpl)com.informatica.adapter.sdkadapter.aso.AsoIPackage.I_INSTANCE;
    private static com.informatica.metadata.common.dsoconfig.impl.DsoconfigIPackageImpl theComInformaticaMetadataCommonDsoconfigIPackage = (com.informatica.metadata.common.dsoconfig.impl.DsoconfigIPackageImpl)com.informatica.metadata.common.dsoconfig.DsoconfigIPackage.I_INSTANCE;
    private static com.informatica.adapter.sdkadapter.capabilityattribute.impl.CapabilityattributeIPackageImpl theComInformaticaAdapterSdkadapterCapabilityattributeIPackage = (com.informatica.adapter.sdkadapter.capabilityattribute.impl.CapabilityattributeIPackageImpl)com.informatica.adapter.sdkadapter.capabilityattribute.CapabilityattributeIPackage.I_INSTANCE;
    private static com.informatica.metadata.common.connectinfo.impl.ConnectinfoIPackageImpl theComInformaticaMetadataCommonConnectinfoIPackage = (com.informatica.metadata.common.connectinfo.impl.ConnectinfoIPackageImpl)com.informatica.metadata.common.connectinfo.ConnectinfoIPackage.I_INSTANCE;
    private static com.informatica.metadata.common.types.impl.TypesIPackageImpl theComInformaticaMetadataCommonTypesIPackage = (com.informatica.metadata.common.types.impl.TypesIPackageImpl)com.informatica.metadata.common.types.TypesIPackage.I_INSTANCE;
    private static com.informatica.imf.icore.impl.IcoreIPackageImpl theComInformaticaImfIcoreIPackage = (com.informatica.imf.icore.impl.IcoreIPackageImpl)com.informatica.imf.icore.IcoreIPackage.I_INSTANCE;
    private static com.informatica.metadata.common.typesystem.impl.TypesystemIPackageImpl theComInformaticaMetadataCommonTypesystemIPackage = (com.informatica.metadata.common.typesystem.impl.TypesystemIPackageImpl)com.informatica.metadata.common.typesystem.TypesystemIPackage.I_INSTANCE;
    private static com.informatica.metadata.common.datasource.impl.DatasourceIPackageImpl theComInformaticaMetadataCommonDatasourceIPackage = (com.informatica.metadata.common.datasource.impl.DatasourceIPackageImpl)com.informatica.metadata.common.datasource.DatasourceIPackage.I_INSTANCE;
    private static com.informatica.metadata.common.typesystem.typelibrary.impl.TypelibraryIPackageImpl theComInformaticaMetadataCommonTypesystemTypelibraryIPackage = (com.informatica.metadata.common.typesystem.typelibrary.impl.TypelibraryIPackageImpl)com.informatica.metadata.common.typesystem.typelibrary.TypelibraryIPackage.I_INSTANCE;
    private static com.informatica.metadata.common.constraint.impl.ConstraintIPackageImpl theComInformaticaMetadataCommonConstraintIPackage = (com.informatica.metadata.common.constraint.impl.ConstraintIPackageImpl)com.informatica.metadata.common.constraint.ConstraintIPackage.I_INSTANCE;
    private static com.informatica.adapter.sdkadapter.logical.impl.LogicalIPackageImpl theComInformaticaAdapterSdkadapterLogicalIPackage = (com.informatica.adapter.sdkadapter.logical.impl.LogicalIPackageImpl)com.informatica.adapter.sdkadapter.logical.LogicalIPackage.I_INSTANCE;
    private static com.informatica.metadata.common.core.impl.CoreIPackageImpl theComInformaticaMetadataCommonCoreIPackage = (com.informatica.metadata.common.core.impl.CoreIPackageImpl)com.informatica.metadata.common.core.CoreIPackage.I_INSTANCE;
    private AsoIPackageImpl() {
        super(com.unicosolution.adapter.snowflakev2.runtime.aso.AsoIFactory.I_INSTANCE);
        // set all the package-info
        setVersion("1.0.0");

    }

    /**
     * Creates, registers, and initializes the <b>Package</b> for this
     * model, and for any others upon which it depends.  Simple
     * dependencies are satisfied by calling this method on all
     * dependent packages before doing anything else. This method drives
     * initialization for interdependent packages directly, in parallel
     * with this package, itself.
     * <p>Of this package and its interdependencies, all packages which
     * have not yet been registered by their fully qualified name  values are first created
     * and registered.  The packages are then initialized in two steps:
     * meta-model objects for all of the packages are created before any
     * are initialized, since one package's meta-model objects may refer to
     * those of another.
     * <p>Invocation of this method will not affect any packages that have
     * already been initialized.
     * @return the initialized package for this model.</br>
     *         null if the package was not found.
     */
     public static com.unicosolution.adapter.snowflakev2.runtime.aso.AsoIPackage init() {
       synchronized(com.informatica.imf.icore.IMFRuntime.getInstance().getIMFRegistryLockObject()) {
          LOGGER.log(Level.FINE, "Initialization of com.unicosolution.adapter.snowflakev2.runtime.aso.AsoIPackage: enter 'init()'");
            com.informatica.imf.icore.IMFRuntime imfRuntime = com.informatica.imf.icore.IMFRuntime.getInstance();
          if (imfRuntime.isPackageRegistered(com.unicosolution.adapter.snowflakev2.runtime.aso.AsoIPackage.I_QUALIFIED_NAME)) {
            LOGGER.log(Level.FINE, "Initialization of com.unicosolution.adapter.snowflakev2.runtime.aso.AsoIPackage: already initialized");
            return (com.unicosolution.adapter.snowflakev2.runtime.aso.AsoIPackage)
              imfRuntime.getIPackageForName(com.unicosolution.adapter.snowflakev2.runtime.aso.AsoIPackage.I_QUALIFIED_NAME);
          }

          // Create and register package
          AsoIPackageImpl theComUnicosolutionAdapterSnowflakev2RuntimeAsoIPackage = (AsoIPackageImpl)
              new com.unicosolution.adapter.snowflakev2.runtime.aso.impl.AsoIPackageImpl();

          theComUnicosolutionAdapterSnowflakev2RuntimeAsoIPackage.createPackageContents();



          theComUnicosolutionAdapterSnowflakev2RuntimeAsoIPackage.initializePackageContents();



          imfRuntime.registerPackage(theComUnicosolutionAdapterSnowflakev2RuntimeAsoIPackage);

          LOGGER.log(Level.FINE, "Initialization of com.unicosolution.adapter.snowflakev2.runtime.aso.AsoIPackage: exit 'init()'");
          return theComUnicosolutionAdapterSnowflakev2RuntimeAsoIPackage;
      }
    }



    /**
     * Returns the IMF version that this package was generated with.
     * @return The used IMF version that was used for the generation of this package.
     */
    @Override
    public String getGeneratedWithIMFVersion() {
        return GENERATED_WITH_IMF_VERSION;
    }
    /**
     * Retrieves the 'ComplexASO' IClass defined
     * in this IPackage.
     * @return the 'ComplexASO' IClass defined
     * in this IPackage
     * 
     */
    public com.informatica.imf.icore.IClass getComplexASOIClass() {
        return this.complexASOIClass;
    }


    /**
     * @return the feature count of COMPLEX_A_S_O class
    */
    public static int getCOMPLEX_A_S_OFeatureCount(){
    return COMPLEX_A_S_O_FEATURE_COUNT;
    }



    /**
     * Retrieves the factory class defined in this package.
     * @return the factory class defined in this package.
     */
    @Override
    public com.informatica.imf.icore.IFactory getFactory() {
       return com.unicosolution.adapter.snowflakev2.runtime.aso.AsoIFactory.I_INSTANCE;
    }

    /**
     * @generated
     * @see com.informatica.imf.icore.INamedElement#getNamespace()
     */
    @Override
    public String getQualifiedName() {
      return I_QUALIFIED_NAME;
    }

   private boolean isCreated = false;

    /**
      * Creates the meta-model objects for the package.  This method is
      * guarded to have no affect on any invocation but its first.
      *
      *
      */
     @Override
     public void createPackageContents() {
         LOGGER.log(Level.FINE, "Initialization of com.unicosolution.adapter.snowflakev2.runtime.aso.AsoIPackage: enter 'createPackageContents()'");
         if (this.isCreated) {
           LOGGER.log(Level.FINE, "Initialization of com.unicosolution.adapter.snowflakev2.runtime.aso.AsoIPackage: already created");
           return;
         }
         this.isCreated = true;

         // Create classes and their features
         this.complexASOIClass = createIClass(COMPLEX_A_S_O);


         LOGGER.log(Level.FINE, "Initialization of com.unicosolution.adapter.snowflakev2.runtime.aso.AsoIPackage: exit 'createPackageContents()'");
    }
  private boolean isInitialized = false;
    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     *
     */
    @Override
    public void initializePackageContents() {
        LOGGER.log(Level.FINE, "Initialization of com.unicosolution.adapter.snowflakev2.runtime.aso.AsoIPackage: enter 'initializePackageContents()'");
      if (this.isInitialized) {
          LOGGER.log(Level.FINE, "Initialization of com.unicosolution.adapter.snowflakev2.runtime.aso.AsoIPackage: already initialized");
          return;
        }

        this.isInitialized = true;
        // Initialize package
        setName(I_NAME);
        setNsPrefix(I_NS_PREFIX);
        setComment(I_COMMENT);
      iSetIdentity(getQualifiedName());

        // Initialize types defined in this package
        addSuperTypesToClasses();
        initClasses();
        setFactory(com.unicosolution.adapter.snowflakev2.runtime.aso.AsoIFactory.I_INSTANCE);

        //initialize the targets for the Annotations present in this package
        initAnnotationTargets();
        //initialize annotations for all classes and properties, if any
        initAnnotationsForAllElements();

        LOGGER.log(Level.FINE, "Initialization of com.unicosolution.adapter.snowflakev2.runtime.aso.AsoIPackage: exit 'initializePackageContents()'");
    }
    private void addSuperTypesToClasses() {
        assert (this.complexASOIClass instanceof com.informatica.imf.icore.internal.IClassInternal);
        ((com.informatica.imf.icore.internal.IClassInternal) (this.complexASOIClass)).setSuperClass(com.informatica.adapter.sdkadapter.aso.AsoIPackage.I_INSTANCE.getD_ComplexASOIClass());
    }
    private void initClasses() {
        // Initialize classes and features; add operations and parameters
        initIClass(this.complexASOIClass, "ComplexASO",
        	!IS_ABSTRACT, IS_FIRST_CLASS, IS_EXTERNAL, !IS_FINAL, !IS_SEEDED, "", !IS_CONSTRAINT_ANNOTATION, !IS_NAMESPACE, !IS_NAMESPACED);

    }
    private void initEnums() {
        com.informatica.imf.icore.IEnumerationLiteral defaultLiteral = null;
        // Initialize enums and add enum literals
    }

    private void initAnnotationTargets() {
        //Set Annotation Targets for all the Annotation IClasses in this Package.
    }


    private void initAnnotationsForAllElements() {
      //This method initialize annotations present on various elements
      //(package, types and properties) in a package.



      		//initialization of annotations for class ComplexASO
      		com.informatica.metadata.common.annotation.impl.SerializeAsGenericClassImpl ComplexASOSerializeAsGenericClass = 
      					new com.informatica.metadata.common.annotation.impl.SerializeAsGenericClassImpl();
      		ComplexASOSerializeAsGenericClass.iSetIClass(com.informatica.metadata.common.annotation.AnnotationIPackage.I_INSTANCE.getSerializeAsGenericClassIClass());
      		ComplexASOSerializeAsGenericClass.setGenericClass("com.informatica.adapter.sdkadapter.aso.D_GenericComplexASO");
      		this.addAnnotationToElement(this.complexASOIClass, ComplexASOSerializeAsGenericClass);


    }
}