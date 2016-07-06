/*
 * Copyright (c)  Informatica Corporation. All rights reserved.
 */

/*
 * This file is generated. Do not modify.
 * IMF Version: 
 * Generation time: 
 */
package com.unicosolution.adapter.snowflakev2.table.metadata.impl;

import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * The package implementation for IPackage.
 * 'com.unicosolution.adapter.snowflakev2.table.metadata'
 */
public final class MetadataIPackageImpl
extends com.informatica.imf.icore.impl.IPackageImpl
implements com.unicosolution.adapter.snowflakev2.table.metadata.MetadataIPackage {

    /**
     * The generated Serial Version UID.
     */
      private static final long serialVersionUID = 1964065194086264100L;

    /**
     * The IMF version that this package was generated with.
     */
    private static final String GENERATED_WITH_IMF_VERSION = "9.5.0";

    /**
     * @handcoded
     */
    private static final Logger LOGGER = Logger.getLogger(com.informatica.imf.icore.impl.IPackageImpl.class.getName());


    /**
     * Constant for class 'TableFieldExtensions'.
     */
    public static final int TABLE_FIELD_EXTENSIONS = 0;

    /**
     * Constant for property 'TableFieldExtensions.defaultColValue'.
     */
    public static final  int TABLE_FIELD_EXTENSIONS__DEFAULT_COL_VALUE =com.informatica.adapter.sdkadapter.logical.impl.LogicalIPackageImpl.getL__MODEL_EXTENSION_FIELD_BASEFeatureCount()+0;

    /**
     * Constant for property 'TableFieldExtensions.isNullable'.
     */
    public static final  int TABLE_FIELD_EXTENSIONS__IS_NULLABLE =com.informatica.adapter.sdkadapter.logical.impl.LogicalIPackageImpl.getL__MODEL_EXTENSION_FIELD_BASEFeatureCount()+1;

    /**
     * Constant for feature constant in class 'TableFieldExtensions'.
     */
    private static final int TABLE_FIELD_EXTENSIONS_FEATURE_COUNT = com.informatica.adapter.sdkadapter.logical.impl.LogicalIPackageImpl.getL__MODEL_EXTENSION_FIELD_BASEFeatureCount()+2;


    /**
     * Constant for class 'TableRecordExtensions'.
     */
    public static final int TABLE_RECORD_EXTENSIONS = 1;

    /**
     * Constant for property 'TableRecordExtensions.tableType'.
     */
    public static final  int TABLE_RECORD_EXTENSIONS__TABLE_TYPE =com.informatica.adapter.sdkadapter.logical.impl.LogicalIPackageImpl.getL__MODEL_EXTENSION_NODEFeatureCount()+0;

    /**
     * Constant for feature constant in class 'TableRecordExtensions'.
     */
    private static final int TABLE_RECORD_EXTENSIONS_FEATURE_COUNT = com.informatica.adapter.sdkadapter.logical.impl.LogicalIPackageImpl.getL__MODEL_EXTENSION_NODEFeatureCount()+1;



    private com.informatica.imf.icore.IClass tableFieldExtensionsIClass = null;
    private com.informatica.imf.icore.IClass tableRecordExtensionsIClass = null;
    private static com.informatica.metadata.common.modelextension.impl.ModelextensionIPackageImpl theComInformaticaMetadataCommonModelextensionIPackage = (com.informatica.metadata.common.modelextension.impl.ModelextensionIPackageImpl)com.informatica.metadata.common.modelextension.ModelextensionIPackage.I_INSTANCE;
    private static com.informatica.imf.icore.impl.IcoreIPackageImpl theComInformaticaImfIcoreIPackage = (com.informatica.imf.icore.impl.IcoreIPackageImpl)com.informatica.imf.icore.IcoreIPackage.I_INSTANCE;
    private static com.informatica.adapter.sdkadapter.logical.impl.LogicalIPackageImpl theComInformaticaAdapterSdkadapterLogicalIPackage = (com.informatica.adapter.sdkadapter.logical.impl.LogicalIPackageImpl)com.informatica.adapter.sdkadapter.logical.LogicalIPackage.I_INSTANCE;
    private MetadataIPackageImpl() {
        super(com.unicosolution.adapter.snowflakev2.table.metadata.MetadataIFactory.I_INSTANCE);
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
     public static com.unicosolution.adapter.snowflakev2.table.metadata.MetadataIPackage init() {
       synchronized(com.informatica.imf.icore.IMFRuntime.getInstance().getIMFRegistryLockObject()) {
          LOGGER.log(Level.FINE, "Initialization of com.unicosolution.adapter.snowflakev2.table.metadata.MetadataIPackage: enter 'init()'");
            com.informatica.imf.icore.IMFRuntime imfRuntime = com.informatica.imf.icore.IMFRuntime.getInstance();
          if (imfRuntime.isPackageRegistered(com.unicosolution.adapter.snowflakev2.table.metadata.MetadataIPackage.I_QUALIFIED_NAME)) {
            LOGGER.log(Level.FINE, "Initialization of com.unicosolution.adapter.snowflakev2.table.metadata.MetadataIPackage: already initialized");
            return (com.unicosolution.adapter.snowflakev2.table.metadata.MetadataIPackage)
              imfRuntime.getIPackageForName(com.unicosolution.adapter.snowflakev2.table.metadata.MetadataIPackage.I_QUALIFIED_NAME);
          }

          // Create and register package
          MetadataIPackageImpl theComUnicosolutionAdapterSnowflakev2TableMetadataIPackage = (MetadataIPackageImpl)
              new com.unicosolution.adapter.snowflakev2.table.metadata.impl.MetadataIPackageImpl();

          theComUnicosolutionAdapterSnowflakev2TableMetadataIPackage.createPackageContents();



          theComUnicosolutionAdapterSnowflakev2TableMetadataIPackage.initializePackageContents();



          imfRuntime.registerPackage(theComUnicosolutionAdapterSnowflakev2TableMetadataIPackage);

          LOGGER.log(Level.FINE, "Initialization of com.unicosolution.adapter.snowflakev2.table.metadata.MetadataIPackage: exit 'init()'");
          return theComUnicosolutionAdapterSnowflakev2TableMetadataIPackage;
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
     * Retrieves the 'TableFieldExtensions' IClass defined
     * in this IPackage.
     * @return the 'TableFieldExtensions' IClass defined
     * in this IPackage
     * 
     */
    public com.informatica.imf.icore.IClass getTableFieldExtensionsIClass() {
        return this.tableFieldExtensionsIClass;
    }


    /**
     * @return the feature count of TABLE_FIELD_EXTENSIONS class
    */
    public static int getTABLE_FIELD_EXTENSIONSFeatureCount(){
    return TABLE_FIELD_EXTENSIONS_FEATURE_COUNT;
    }

    /**
     * Retrieves the 'TableRecordExtensions' IClass defined
     * in this IPackage.
     * @return the 'TableRecordExtensions' IClass defined
     * in this IPackage
     * 
     */
    public com.informatica.imf.icore.IClass getTableRecordExtensionsIClass() {
        return this.tableRecordExtensionsIClass;
    }


    /**
     * @return the feature count of TABLE_RECORD_EXTENSIONS class
    */
    public static int getTABLE_RECORD_EXTENSIONSFeatureCount(){
    return TABLE_RECORD_EXTENSIONS_FEATURE_COUNT;
    }



    /**
     * Retrieves the factory class defined in this package.
     * @return the factory class defined in this package.
     */
    @Override
    public com.informatica.imf.icore.IFactory getFactory() {
       return com.unicosolution.adapter.snowflakev2.table.metadata.MetadataIFactory.I_INSTANCE;
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
         LOGGER.log(Level.FINE, "Initialization of com.unicosolution.adapter.snowflakev2.table.metadata.MetadataIPackage: enter 'createPackageContents()'");
         if (this.isCreated) {
           LOGGER.log(Level.FINE, "Initialization of com.unicosolution.adapter.snowflakev2.table.metadata.MetadataIPackage: already created");
           return;
         }
         this.isCreated = true;

         // Create classes and their features
         this.tableFieldExtensionsIClass = createIClass(TABLE_FIELD_EXTENSIONS);
         createIProperty(this.tableFieldExtensionsIClass,TABLE_FIELD_EXTENSIONS__DEFAULT_COL_VALUE);
         createIProperty(this.tableFieldExtensionsIClass,TABLE_FIELD_EXTENSIONS__IS_NULLABLE);

         this.tableRecordExtensionsIClass = createIClass(TABLE_RECORD_EXTENSIONS);
         createIProperty(this.tableRecordExtensionsIClass,TABLE_RECORD_EXTENSIONS__TABLE_TYPE);


         LOGGER.log(Level.FINE, "Initialization of com.unicosolution.adapter.snowflakev2.table.metadata.MetadataIPackage: exit 'createPackageContents()'");
    }
  private boolean isInitialized = false;
    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     *
     */
    @Override
    public void initializePackageContents() {
        LOGGER.log(Level.FINE, "Initialization of com.unicosolution.adapter.snowflakev2.table.metadata.MetadataIPackage: enter 'initializePackageContents()'");
      if (this.isInitialized) {
          LOGGER.log(Level.FINE, "Initialization of com.unicosolution.adapter.snowflakev2.table.metadata.MetadataIPackage: already initialized");
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
        setFactory(com.unicosolution.adapter.snowflakev2.table.metadata.MetadataIFactory.I_INSTANCE);

        //initialize the targets for the Annotations present in this package
        initAnnotationTargets();
        //initialize annotations for all classes and properties, if any
        initAnnotationsForAllElements();

        LOGGER.log(Level.FINE, "Initialization of com.unicosolution.adapter.snowflakev2.table.metadata.MetadataIPackage: exit 'initializePackageContents()'");
    }
    private void addSuperTypesToClasses() {
        assert (this.tableFieldExtensionsIClass instanceof com.informatica.imf.icore.internal.IClassInternal);
        ((com.informatica.imf.icore.internal.IClassInternal) (this.tableFieldExtensionsIClass)).setSuperClass(com.informatica.adapter.sdkadapter.logical.LogicalIPackage.I_INSTANCE.getL_ModelExtensionFieldBaseIClass());
        assert (this.tableRecordExtensionsIClass instanceof com.informatica.imf.icore.internal.IClassInternal);
        ((com.informatica.imf.icore.internal.IClassInternal) (this.tableRecordExtensionsIClass)).setSuperClass(com.informatica.adapter.sdkadapter.logical.LogicalIPackage.I_INSTANCE.getL_ModelExtensionNodeIClass());
    }
    private void initClasses() {
        // Initialize classes and features; add operations and parameters
        initIClass(this.tableFieldExtensionsIClass, "TableFieldExtensions",
        	!IS_ABSTRACT, IS_SECOND_CLASS, IS_INTERNAL, !IS_FINAL, !IS_SEEDED, "", !IS_CONSTRAINT_ANNOTATION, !IS_NAMESPACE, !IS_NAMESPACED);
        initIProperty(this.tableFieldExtensionsIClass.getAllProperties(true).get(TABLE_FIELD_EXTENSIONS__DEFAULT_COL_VALUE), com.informatica.imf.icore.ICoreDatatypes.I_STRING, "defaultColValue",
        	"", BOUNDS_VALUE_ZERO, BOUNDS_VALUE_ONE, null,
        	!IS_CONTAINMENT, IS_NO, IS_NOT_REFERABLE, !IS_UNIQUE, !IS_ORDERED, "", IS_FINALREDEFINE, "",
        	!IS_AGGREGATION, !IS_AGGREGATOR, !IS_FINAL_PROPERTY, !IS_NAME_PROPERTY, !IS_SENSITIVE,!IS_DEPRECATED, null);
        initIProperty(this.tableFieldExtensionsIClass.getAllProperties(true).get(TABLE_FIELD_EXTENSIONS__IS_NULLABLE), com.informatica.imf.icore.ICoreDatatypes.I_BOOLEAN, "isNullable",
        	true, BOUNDS_VALUE_ONE, BOUNDS_VALUE_ONE, null,
        	!IS_CONTAINMENT, IS_NO, IS_NOT_REFERABLE, !IS_UNIQUE, !IS_ORDERED, "", IS_FINALREDEFINE, "",
        	!IS_AGGREGATION, !IS_AGGREGATOR, !IS_FINAL_PROPERTY, !IS_NAME_PROPERTY, !IS_SENSITIVE,!IS_DEPRECATED, null);
        initIClass(this.tableRecordExtensionsIClass, "TableRecordExtensions",
        	!IS_ABSTRACT, IS_SECOND_CLASS, IS_INTERNAL, !IS_FINAL, !IS_SEEDED, "", !IS_CONSTRAINT_ANNOTATION, !IS_NAMESPACE, !IS_NAMESPACED);
        initIProperty(this.tableRecordExtensionsIClass.getAllProperties(true).get(TABLE_RECORD_EXTENSIONS__TABLE_TYPE), com.informatica.imf.icore.ICoreDatatypes.I_STRING, "tableType",
        	"", BOUNDS_VALUE_ZERO, BOUNDS_VALUE_ONE, null,
        	!IS_CONTAINMENT, IS_NO, IS_NOT_REFERABLE, !IS_UNIQUE, !IS_ORDERED, "", IS_FINALREDEFINE, "",
        	!IS_AGGREGATION, !IS_AGGREGATOR, !IS_FINAL_PROPERTY, !IS_NAME_PROPERTY, !IS_SENSITIVE,!IS_DEPRECATED, null);
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



      		//initialization of annotations for class TableFieldExtensions
      		com.informatica.metadata.common.annotation.impl.CppSerializeAsGenericImpl TableFieldExtensionsCppSerializeAsGeneric = 
      					new com.informatica.metadata.common.annotation.impl.CppSerializeAsGenericImpl();
      		TableFieldExtensionsCppSerializeAsGeneric.iSetIClass(com.informatica.metadata.common.annotation.AnnotationIPackage.I_INSTANCE.getCppSerializeAsGenericIClass());
      		TableFieldExtensionsCppSerializeAsGeneric.setContainerProperty("genericContainer");
      		TableFieldExtensionsCppSerializeAsGeneric.setExtensionPoint("com.informatica.adapter.sdkadapter.patternblocks.field.P_Field");
      		TableFieldExtensionsCppSerializeAsGeneric.setSerializedExtensionClass("com.informatica.adapter.sdkadapter.logical.L_GenericModelExtensionFieldBase");
      		this.addAnnotationToElement(this.tableFieldExtensionsIClass, TableFieldExtensionsCppSerializeAsGeneric);


      		//initialization of annotations for property defaultColValue
      		com.informatica.imf.annotations.constraints.impl.LengthImpl tablefieldextensionsDefaultcolvalueLength = 
      					new com.informatica.imf.annotations.constraints.impl.LengthImpl();
      		tablefieldextensionsDefaultcolvalueLength.iSetIClass(com.informatica.imf.annotations.constraints.ConstraintsIPackage.I_INSTANCE.getLengthIClass());
      		tablefieldextensionsDefaultcolvalueLength.setLengthType(com.informatica.imf.annotations.constraints.LengthType.OTHER);
      		tablefieldextensionsDefaultcolvalueLength.setMax(255);
      		tablefieldextensionsDefaultcolvalueLength.setMin(0);
      		this.addAnnotationToElement(this.tableFieldExtensionsIClass.getAllProperties(true).get(TABLE_FIELD_EXTENSIONS__DEFAULT_COL_VALUE), tablefieldextensionsDefaultcolvalueLength);
      		com.informatica.imf.annotations.constraints.impl.PersistenceImpl tablefieldextensionsDefaultcolvaluePersistence = 
      					new com.informatica.imf.annotations.constraints.impl.PersistenceImpl();
      		tablefieldextensionsDefaultcolvaluePersistence.iSetIClass(com.informatica.imf.annotations.constraints.ConstraintsIPackage.I_INSTANCE.getPersistenceIClass());
      		tablefieldextensionsDefaultcolvaluePersistence.setSize(255);
      		this.addAnnotationToElement(this.tableFieldExtensionsIClass.getAllProperties(true).get(TABLE_FIELD_EXTENSIONS__DEFAULT_COL_VALUE), tablefieldextensionsDefaultcolvaluePersistence);
      		//initialization of annotations for class TableRecordExtensions
      		com.informatica.metadata.common.annotation.impl.CppSerializeAsGenericImpl TableRecordExtensionsCppSerializeAsGeneric = 
      					new com.informatica.metadata.common.annotation.impl.CppSerializeAsGenericImpl();
      		TableRecordExtensionsCppSerializeAsGeneric.iSetIClass(com.informatica.metadata.common.annotation.AnnotationIPackage.I_INSTANCE.getCppSerializeAsGenericIClass());
      		TableRecordExtensionsCppSerializeAsGeneric.setContainerProperty("genericContainer");
      		TableRecordExtensionsCppSerializeAsGeneric.setExtensionPoint("com.informatica.adapter.sdkadapter.patternblocks.flatrecord.P_FlatRecord");
      		TableRecordExtensionsCppSerializeAsGeneric.setSerializedExtensionClass("com.informatica.adapter.sdkadapter.logical.L_GenericModelExtensionNode");
      		this.addAnnotationToElement(this.tableRecordExtensionsIClass, TableRecordExtensionsCppSerializeAsGeneric);


      		//initialization of annotations for property tableType
      		com.informatica.imf.annotations.constraints.impl.LengthImpl tablerecordextensionsTabletypeLength = 
      					new com.informatica.imf.annotations.constraints.impl.LengthImpl();
      		tablerecordextensionsTabletypeLength.iSetIClass(com.informatica.imf.annotations.constraints.ConstraintsIPackage.I_INSTANCE.getLengthIClass());
      		tablerecordextensionsTabletypeLength.setLengthType(com.informatica.imf.annotations.constraints.LengthType.OTHER);
      		tablerecordextensionsTabletypeLength.setMax(255);
      		tablerecordextensionsTabletypeLength.setMin(0);
      		this.addAnnotationToElement(this.tableRecordExtensionsIClass.getAllProperties(true).get(TABLE_RECORD_EXTENSIONS__TABLE_TYPE), tablerecordextensionsTabletypeLength);
      		com.informatica.imf.annotations.constraints.impl.PersistenceImpl tablerecordextensionsTabletypePersistence = 
      					new com.informatica.imf.annotations.constraints.impl.PersistenceImpl();
      		tablerecordextensionsTabletypePersistence.iSetIClass(com.informatica.imf.annotations.constraints.ConstraintsIPackage.I_INSTANCE.getPersistenceIClass());
      		tablerecordextensionsTabletypePersistence.setSize(255);
      		this.addAnnotationToElement(this.tableRecordExtensionsIClass.getAllProperties(true).get(TABLE_RECORD_EXTENSIONS__TABLE_TYPE), tablerecordextensionsTabletypePersistence);
    }
}