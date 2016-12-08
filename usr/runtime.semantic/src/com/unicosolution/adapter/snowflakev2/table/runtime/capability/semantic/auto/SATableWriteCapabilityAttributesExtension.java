// Copyright (c) 2010 Informatica Corporation. All rights reserved.

// *** This file is generated. Do not modify. ***

package com.unicosolution.adapter.snowflakev2.table.runtime.capability.semantic.auto;

import java.util.Date;
import com.informatica.tools.core.change.ObjectChangeSink;
import java.util.HashMap;
import com.informatica.imf.utils.ObjectUtils;
import com.informatica.sdk.adapter.metadata.common.semantic.iface.Action;
import java.util.ArrayList;
import com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension;
import com.informatica.imf.icore.IProperty;
import com.informatica.metadata.common.modelextension.semantic.auto.SAModelExtension;
import com.informatica.adapter.sdkadapter.logical.semantic.manual.*;
import java.util.Map;
import com.informatica.adapter.sdkadapter.logical.objectmanager.manual.ObjectManagerContextImpl;
import com.informatica.tools.core.change.impl.PropertyBasedObjectChangeImpl;
import com.unicosolution.adapter.snowflakev2.table.runtime.capability.objectmanager.auto.MATableWriteCapabilityAttributesExtension;
import com.informatica.adapter.sdkadapter.logical.validation.manual.SL_ValidationException;
import com.informatica.adapter.sdkadapter.logical.semantic.manual.SL_ObjImpl;
import java.util.LinkedHashSet;
import java.io.PrintStream;
import com.informatica.adapter.sdkadapter.asoextension.semantic.auto.SAD_ModelExtensionWriteCapAttributes;
import java.util.Iterator;
import com.informatica.messages.InfaMessage;
import java.util.Collection;
import java.util.Set;
import com.unicosolution.adapter.snowflakev2.table.runtime.capability.semantic.iface.SEMTableWriteCapabilityAttributesExtension;
import java.util.List;
import com.informatica.semantic.change.ObjectChange;
import com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIFactory;
import com.informatica.adapter.sdkadapter.logical.semantic.messages.Sdk_app_comMsg;
import java.util.Collections;

/** 
  * Code generated semantic layer wrapper for TableWriteCapabilityAttributesExtension
  */
@SuppressWarnings("unused") //$NON-NLS-1$
public class SATableWriteCapabilityAttributesExtension extends SAD_ModelExtensionWriteCapAttributes implements SL_Obj, SEMTableWriteCapabilityAttributesExtension
{

    // Unique property IDs for use with generic versions of get/set/add/remove/(etc):
    public static final int UPDATEMODE_ID = -850965417;
    public static final int TRUNCATETARGETTABLE_ID = 2036646736;
    public static final int PRESQL_ID = -937490449;
    public static final int POSTSQL_ID = 265500770;
    public static final int ABORTONERRORS_ID = 1873395073;
    public static final int PROPAGATEDATA_ID = 1401041416;
    public static final int ONEBATCH_ID = 296468278;
    public static final int STARTTRANSACTIONFORJOBS_ID = 716940003;
    public static final int UPDATEKEYCOLUMNS_ID = -304174726;

    protected HashMap<IProperty, Integer> propMap = new HashMap<IProperty, Integer>();
    // get IProperty->propId map
    public Map<IProperty, Integer> getPropMap(){
        // populate the property map if empty
        if (propMap.isEmpty()) {
            java.util.List<IProperty> props = ObjectUtils.getMetaClass(_get_imfObject()).getAllProperties();
            for (IProperty prop : props) {
                // create prop id string
                String propIDStr = prop.getName().toUpperCase() + "_ID";
                if (propIDStr.equalsIgnoreCase("UPDATEMODE_ID"))
                    propMap.put(prop,UPDATEMODE_ID);
                else if (propIDStr.equalsIgnoreCase("TRUNCATETARGETTABLE_ID"))
                    propMap.put(prop,TRUNCATETARGETTABLE_ID);
                else if (propIDStr.equalsIgnoreCase("PRESQL_ID"))
                    propMap.put(prop,PRESQL_ID);
                else if (propIDStr.equalsIgnoreCase("POSTSQL_ID"))
                    propMap.put(prop,POSTSQL_ID);
                else if (propIDStr.equalsIgnoreCase("ABORTONERRORS_ID"))
                    propMap.put(prop,ABORTONERRORS_ID);
                else if (propIDStr.equalsIgnoreCase("PROPAGATEDATA_ID"))
                    propMap.put(prop,PROPAGATEDATA_ID);
                else if (propIDStr.equalsIgnoreCase("ONEBATCH_ID"))
                    propMap.put(prop,ONEBATCH_ID);
                else if (propIDStr.equalsIgnoreCase("STARTTRANSACTIONFORJOBS_ID"))
                    propMap.put(prop,STARTTRANSACTIONFORJOBS_ID);
                else if (propIDStr.equalsIgnoreCase("UPDATEKEYCOLUMNS_ID"))
                    propMap.put(prop,UPDATEKEYCOLUMNS_ID);

            }
        }
        Map<IProperty, Integer> baseMap = super.getPropMap();
        for (IProperty prop : baseMap.keySet()) {
            if (!propMap.containsKey(prop))
                propMap.put(prop, baseMap.get(prop));
        }
        return propMap;
    }

    /**  *** DO NOT USE THIS! *** Objects are constructed via the static newObj method */
    public SATableWriteCapabilityAttributesExtension()
    {
        super();
    }

    /** Get underlying IMF object. Reserved for semantic layer use only */
    public TableWriteCapabilityAttributesExtension _get_imfObject()
    {
        return (TableWriteCapabilityAttributesExtension)_imfObject;
    }

    /** Create new instance of Semantic layer object (inc. associated IMF object) */
    public static SATableWriteCapabilityAttributesExtension newObj(SL_ContainerObj root) throws SL_Exception
    {
        TableWriteCapabilityAttributesExtension imfObj = CapabilityIFactory.I_INSTANCE.createTableWriteCapabilityAttributesExtension();
        Utils.objectUtilsNewObject(imfObj);
        return newObjFrom(imfObj, root);
    }


    /** Create new instance of Semantic layer object (for given IMF object) */
    protected static SATableWriteCapabilityAttributesExtension newObjFrom(TableWriteCapabilityAttributesExtension imfObj, SL_ContainerObj root) throws SL_Exception
    {
        SATableWriteCapabilityAttributesExtension newObj = (SATableWriteCapabilityAttributesExtension)root.get_factory().newSemanticClass(TableWriteCapabilityAttributesExtension.class, root.get_factory().getClass().getClassLoader());
        newObj.rootObj = root;
        newObj._validator = (MATableWriteCapabilityAttributesExtension)root.get_factory().newObjectmanagerClass(TableWriteCapabilityAttributesExtension.class, root.get_factory().getClass().getClassLoader());
        newObj._imfObject = imfObj;
        Utils.addObjectExtension(newObj);
        return newObj;
    }


    /** Get associated Semantic layer object from iObjectInfo extensions */
    public static  SATableWriteCapabilityAttributesExtension getSemanticObject(TableWriteCapabilityAttributesExtension imfObj)
    {
        SATableWriteCapabilityAttributesExtension rc = (SATableWriteCapabilityAttributesExtension)Utils.getObjectExtension(imfObj);
        if(rc==null) {
            SL_ContainerObj container = Utils.getSemanticContainer(imfObj);
            rc = (SATableWriteCapabilityAttributesExtension)Utils.invoke_buildSemanticLayer(imfObj, container, container.get_factory(), container.getClass().getClassLoader());
        }

        return rc;
    }

    public MATableWriteCapabilityAttributesExtension _get_objectmanager()
    {
        return (MATableWriteCapabilityAttributesExtension)_validator;
    }

    public TableWriteCapabilityAttributesExtension getAdaptee()
    {
        return _get_imfObject();

    }

    /** Override if you need something more than the plain PropertyBasedObjectChangeImpl */
    protected ObjectChange createPropertyChange(Object object, IProperty property)
    {
        return Utils.createPropertyChange(object, property);

    }

    /** 
      * Get the 'UpdateMode' property.
      */
    public String getUpdateMode()
    {
        return _get_imfObject().getUpdateMode();
    }

    /** 
      * Set the 'UpdateMode' property.
      */
    public final void setUpdateMode(String newObj)throws SL_Exception
    {
        setUpdateMode(newObj, null);
    }


    /** 
      * Set the 'UpdateMode' property.
      */
    public void setUpdateMode(String newVal, ObjectChangeSink sink)
    {
        if(newVal!=null && newVal.equals(getUpdateMode())) return;

        if(rootObj.isAutoValidate())
            _get_objectmanager().validate_UpdateMode(new ObjectManagerContextImpl(Action.SET), newVal, this);

        ((TableWriteCapabilityAttributesExtension)_imfObject).setUpdateMode(newVal);
        Utils.setBitCascade(sink, getAdaptee());
        if (sink != null) {
            ObjectChange change = createPropertyChange(getAdaptee(), TableWriteCapabilityAttributesExtension.Properties.UPDATE_MODE);
            sink.addObjectChange(getAdaptee(), change);
        }


    }

    /** 
      * Get the 'truncateTargetTable' property.
      */
    public boolean isTruncateTargetTable()
    {
        return _get_imfObject().isTruncateTargetTable();
    }

    /** 
      * Set the 'truncateTargetTable' property.
      */
    public final void setTruncateTargetTable(boolean newObj)throws SL_Exception
    {
        setTruncateTargetTable(newObj, null);
    }


    /** 
      * Set the 'truncateTargetTable' property.
      */
    public void setTruncateTargetTable(boolean newVal, ObjectChangeSink sink)
    {
        if(newVal==isTruncateTargetTable()) return;

        if(rootObj.isAutoValidate())
            _get_objectmanager().validate_truncateTargetTable(new ObjectManagerContextImpl(Action.SET), newVal, this);

        ((TableWriteCapabilityAttributesExtension)_imfObject).setTruncateTargetTable(newVal);
        Utils.setBitCascade(sink, getAdaptee());
        if (sink != null) {
            ObjectChange change = createPropertyChange(getAdaptee(), TableWriteCapabilityAttributesExtension.Properties.TRUNCATE_TARGET_TABLE);
            sink.addObjectChange(getAdaptee(), change);
        }


    }

    /** 
      * Get the 'preSql' property.
      */
    public String getPreSql()
    {
        return _get_imfObject().getPreSql();
    }

    /** 
      * Set the 'preSql' property.
      */
    public final void setPreSql(String newObj)throws SL_Exception
    {
        setPreSql(newObj, null);
    }


    /** 
      * Set the 'preSql' property.
      */
    public void setPreSql(String newVal, ObjectChangeSink sink)
    {
        if(newVal!=null && newVal.equals(getPreSql())) return;

        if(rootObj.isAutoValidate())
            _get_objectmanager().validate_preSql(new ObjectManagerContextImpl(Action.SET), newVal, this);

        ((TableWriteCapabilityAttributesExtension)_imfObject).setPreSql(newVal);
        Utils.setBitCascade(sink, getAdaptee());
        if (sink != null) {
            ObjectChange change = createPropertyChange(getAdaptee(), TableWriteCapabilityAttributesExtension.Properties.PRE_SQL);
            sink.addObjectChange(getAdaptee(), change);
        }


    }

    /** 
      * Get the 'postSql' property.
      */
    public String getPostSql()
    {
        return _get_imfObject().getPostSql();
    }

    /** 
      * Set the 'postSql' property.
      */
    public final void setPostSql(String newObj)throws SL_Exception
    {
        setPostSql(newObj, null);
    }


    /** 
      * Set the 'postSql' property.
      */
    public void setPostSql(String newVal, ObjectChangeSink sink)
    {
        if(newVal!=null && newVal.equals(getPostSql())) return;

        if(rootObj.isAutoValidate())
            _get_objectmanager().validate_postSql(new ObjectManagerContextImpl(Action.SET), newVal, this);

        ((TableWriteCapabilityAttributesExtension)_imfObject).setPostSql(newVal);
        Utils.setBitCascade(sink, getAdaptee());
        if (sink != null) {
            ObjectChange change = createPropertyChange(getAdaptee(), TableWriteCapabilityAttributesExtension.Properties.POST_SQL);
            sink.addObjectChange(getAdaptee(), change);
        }


    }

    /** 
      * Get the 'abortOnErrors' property.
      */
    public boolean isAbortOnErrors()
    {
        return _get_imfObject().isAbortOnErrors();
    }

    /** 
      * Set the 'abortOnErrors' property.
      */
    public final void setAbortOnErrors(boolean newObj)throws SL_Exception
    {
        setAbortOnErrors(newObj, null);
    }


    /** 
      * Set the 'abortOnErrors' property.
      */
    public void setAbortOnErrors(boolean newVal, ObjectChangeSink sink)
    {
        if(newVal==isAbortOnErrors()) return;

        if(rootObj.isAutoValidate())
            _get_objectmanager().validate_abortOnErrors(new ObjectManagerContextImpl(Action.SET), newVal, this);

        ((TableWriteCapabilityAttributesExtension)_imfObject).setAbortOnErrors(newVal);
        Utils.setBitCascade(sink, getAdaptee());
        if (sink != null) {
            ObjectChange change = createPropertyChange(getAdaptee(), TableWriteCapabilityAttributesExtension.Properties.ABORT_ON_ERRORS);
            sink.addObjectChange(getAdaptee(), change);
        }


    }

    /** 
      * Get the 'propagateData' property.
      */
    public boolean isPropagateData()
    {
        return _get_imfObject().isPropagateData();
    }

    /** 
      * Set the 'propagateData' property.
      */
    public final void setPropagateData(boolean newObj)throws SL_Exception
    {
        setPropagateData(newObj, null);
    }


    /** 
      * Set the 'propagateData' property.
      */
    public void setPropagateData(boolean newVal, ObjectChangeSink sink)
    {
        if(newVal==isPropagateData()) return;

        if(rootObj.isAutoValidate())
            _get_objectmanager().validate_propagateData(new ObjectManagerContextImpl(Action.SET), newVal, this);

        ((TableWriteCapabilityAttributesExtension)_imfObject).setPropagateData(newVal);
        Utils.setBitCascade(sink, getAdaptee());
        if (sink != null) {
            ObjectChange change = createPropertyChange(getAdaptee(), TableWriteCapabilityAttributesExtension.Properties.PROPAGATE_DATA);
            sink.addObjectChange(getAdaptee(), change);
        }


    }

    /** 
      * Get the 'oneBatch' property.
      */
    public boolean isOneBatch()
    {
        return _get_imfObject().isOneBatch();
    }

    /** 
      * Set the 'oneBatch' property.
      */
    public final void setOneBatch(boolean newObj)throws SL_Exception
    {
        setOneBatch(newObj, null);
    }


    /** 
      * Set the 'oneBatch' property.
      */
    public void setOneBatch(boolean newVal, ObjectChangeSink sink)
    {
        if(newVal==isOneBatch()) return;

        if(rootObj.isAutoValidate())
            _get_objectmanager().validate_oneBatch(new ObjectManagerContextImpl(Action.SET), newVal, this);

        ((TableWriteCapabilityAttributesExtension)_imfObject).setOneBatch(newVal);
        Utils.setBitCascade(sink, getAdaptee());
        if (sink != null) {
            ObjectChange change = createPropertyChange(getAdaptee(), TableWriteCapabilityAttributesExtension.Properties.ONE_BATCH);
            sink.addObjectChange(getAdaptee(), change);
        }


    }

    /** 
      * Get the 'startTransactionForJobs' property.
      */
    public boolean isStartTransactionForJobs()
    {
        return _get_imfObject().isStartTransactionForJobs();
    }

    /** 
      * Set the 'startTransactionForJobs' property.
      */
    public final void setStartTransactionForJobs(boolean newObj)throws SL_Exception
    {
        setStartTransactionForJobs(newObj, null);
    }


    /** 
      * Set the 'startTransactionForJobs' property.
      */
    public void setStartTransactionForJobs(boolean newVal, ObjectChangeSink sink)
    {
        if(newVal==isStartTransactionForJobs()) return;

        if(rootObj.isAutoValidate())
            _get_objectmanager().validate_startTransactionForJobs(new ObjectManagerContextImpl(Action.SET), newVal, this);

        ((TableWriteCapabilityAttributesExtension)_imfObject).setStartTransactionForJobs(newVal);
        Utils.setBitCascade(sink, getAdaptee());
        if (sink != null) {
            ObjectChange change = createPropertyChange(getAdaptee(), TableWriteCapabilityAttributesExtension.Properties.START_TRANSACTION_FOR_JOBS);
            sink.addObjectChange(getAdaptee(), change);
        }


    }

    /** 
      * Get the 'updateKeyColumns' property.
      */
    public String getUpdateKeyColumns()
    {
        return _get_imfObject().getUpdateKeyColumns();
    }

    /** 
      * Set the 'updateKeyColumns' property.
      */
    public final void setUpdateKeyColumns(String newObj)throws SL_Exception
    {
        setUpdateKeyColumns(newObj, null);
    }


    /** 
      * Set the 'updateKeyColumns' property.
      */
    public void setUpdateKeyColumns(String newVal, ObjectChangeSink sink)
    {
        if(newVal!=null && newVal.equals(getUpdateKeyColumns())) return;

        if(rootObj.isAutoValidate())
            _get_objectmanager().validate_updateKeyColumns(new ObjectManagerContextImpl(Action.SET), newVal, this);

        ((TableWriteCapabilityAttributesExtension)_imfObject).setUpdateKeyColumns(newVal);
        Utils.setBitCascade(sink, getAdaptee());
        if (sink != null) {
            ObjectChange change = createPropertyChange(getAdaptee(), TableWriteCapabilityAttributesExtension.Properties.UPDATE_KEY_COLUMNS);
            sink.addObjectChange(getAdaptee(), change);
        }


    }

    /** Pretty-print this object: */
    public String toString()
    {
        String rc = "SATableWriteCapabilityAttributesExtension " +" (hashCode="+hashCode()+")";
        rc += " (UpdateMode="+getUpdateMode()+")";
        rc += " (truncateTargetTable="+isTruncateTargetTable()+")";
        rc += " (preSql="+getPreSql()+")";
        rc += " (postSql="+getPostSql()+")";
        rc += " (abortOnErrors="+isAbortOnErrors()+")";
        rc += " (propagateData="+isPropagateData()+")";
        rc += " (oneBatch="+isOneBatch()+")";
        rc += " (startTransactionForJobs="+isStartTransactionForJobs()+")";
        rc += " (updateKeyColumns="+getUpdateKeyColumns()+")";
        return rc;

    }

    /** Builds semantic layer objects for existing IMF model */
    public static SATableWriteCapabilityAttributesExtension buildSemanticLayer(TableWriteCapabilityAttributesExtension imfObj, SL_ContainerObj root) throws SL_Exception
    {
        SATableWriteCapabilityAttributesExtension me = newObjFrom(imfObj, (SL_ContainerObj)root);
        me._buildSemanticLayerRecurse(root);
        return me;

    }

    /** Recursive helper method for building semantic layer */
    public SATableWriteCapabilityAttributesExtension _buildSemanticLayerRecurse(SL_ContainerObj root) throws SL_Exception
    {

        super._buildSemanticLayerRecurse(root);

        return this;
    }

    /** Resets model dependent state in semantic layer. Called only when semantic layer encapulation has been bypassed with direct IMF model updates. */
    public void resetSemanticState() throws SL_Exception
    {
        super.resetSemanticState();


    }

    /** Get the value of property identified by 'propID'. Primitives come back as boxed. */
    public Object get(int propID) throws SL_Exception
    {
            switch(propID)
            {
            case UPDATEMODE_ID:
                return getUpdateMode();
            case TRUNCATETARGETTABLE_ID:
                return isTruncateTargetTable();
            case PRESQL_ID:
                return getPreSql();
            case POSTSQL_ID:
                return getPostSql();
            case ABORTONERRORS_ID:
                return isAbortOnErrors();
            case PROPAGATEDATA_ID:
                return isPropagateData();
            case ONEBATCH_ID:
                return isOneBatch();
            case STARTTRANSACTIONFORJOBS_ID:
                return isStartTransactionForJobs();
            case UPDATEKEYCOLUMNS_ID:
                return getUpdateKeyColumns();
            default:
                return super.get(propID);
            }

    }

    /** Set the value of property identified by 'propID'. Primitives are set as boxed. */
    public void set(int propID, Object obj) throws SL_Exception
    {
            switch(propID)
            {
            case UPDATEMODE_ID:
                setUpdateMode((String)obj);
                return;
            case TRUNCATETARGETTABLE_ID:
                setTruncateTargetTable((java.lang.Boolean)obj);
                return;
            case PRESQL_ID:
                setPreSql((String)obj);
                return;
            case POSTSQL_ID:
                setPostSql((String)obj);
                return;
            case ABORTONERRORS_ID:
                setAbortOnErrors((java.lang.Boolean)obj);
                return;
            case PROPAGATEDATA_ID:
                setPropagateData((java.lang.Boolean)obj);
                return;
            case ONEBATCH_ID:
                setOneBatch((java.lang.Boolean)obj);
                return;
            case STARTTRANSACTIONFORJOBS_ID:
                setStartTransactionForJobs((java.lang.Boolean)obj);
                return;
            case UPDATEKEYCOLUMNS_ID:
                setUpdateKeyColumns((String)obj);
                return;
            default:
                super.set(propID, obj);
                return;
            }

    }


    /** Just so we can force the class to initialise via a call to a known static method */
    public static void init() {}

    /** Get single entry from list identified by 'propID': */
    public  Object get(int propID, int i) throws SL_Exception
    {
        switch(propID)
        {
        default:
            return super.get(propID, i);
        }
    }

    /** Add single entry to list identified by 'propID': */
    public  void add(int propID, int i, Object obj) throws SL_Exception
    {
        switch(propID)
        {
        default:
            super.add(propID, i, obj);
        }
    }

    /** Remove single entry to list identified by 'propID': */
    public  Object remove(int propID, int i) throws SL_Exception
    {
        switch(propID)
        {
        default:
            return super.remove(propID, i);
        }
    }

    /** Get size of list identified by 'propID': */
    public  int size(int propID) throws SL_Exception
    {
        switch(propID)
        {
        default:
            return super.size(propID);
        }
    }

    /** 
      * Make this object a shallow copy of 'fromObj': primitives & (non-aggregating) references 
      * are copied as-is. Contained sub objects / contained collections not copied
      */
    public  void _shallowCopyInternal(SL_Obj fromObjArg) {
        SATableWriteCapabilityAttributesExtension fromObj = (SATableWriteCapabilityAttributesExtension)fromObjArg;
        super._shallowCopyInternal((SL_Obj)fromObj);

        setUpdateMode(fromObj.getUpdateMode());

        setTruncateTargetTable(fromObj.isTruncateTargetTable());

        setPreSql(fromObj.getPreSql());

        setPostSql(fromObj.getPostSql());

        setAbortOnErrors(fromObj.isAbortOnErrors());

        setPropagateData(fromObj.isPropagateData());

        setOneBatch(fromObj.isOneBatch());

        setStartTransactionForJobs(fromObj.isStartTransactionForJobs());

        setUpdateKeyColumns(fromObj.getUpdateKeyColumns());
    }

    /** 
      * Make this object a deep copy of 'fromObj'. References are not updated.
      * Typically use deepCopy() instead of this.
      */
    public  void _deepCopyInternal(SL_Obj fromObjArg,SL_ContainerObj trgContainer) {
        _shallowCopyInternal(fromObjArg);
        SATableWriteCapabilityAttributesExtension fromObj = (SATableWriteCapabilityAttributesExtension)fromObjArg;
        super._deepCopyInternal((SAD_ModelExtensionWriteCapAttributes)fromObj,trgContainer);


    }

    /** 
      * return shallow clone of this object. Primitives & references are copied as-is.
      * Contained sub objects and contained collections are changed. 
      */
    public SL_Obj _shallowCloneInternal(SL_ContainerObj trgContainer) {
        SATableWriteCapabilityAttributesExtension newObj = (SATableWriteCapabilityAttributesExtension) this._newObj_NonStatic((SL_ContainerObj)trgContainer);
        if(trgContainer.get_patchRefsMap()!=null) 
            trgContainer.get_patchRefsMap().put(this, newObj);
        newObj._shallowCopyInternal(this);
        return newObj;
    }

    /** 
      * Return deep clone of this object. References are not updated.
      * Typically use deepClone() instead of this.
      */
    public SATableWriteCapabilityAttributesExtension _deepCloneInternal(SL_ContainerObj trgContainer) {
        SATableWriteCapabilityAttributesExtension newObj = (SATableWriteCapabilityAttributesExtension) this._newObj_NonStatic((SL_ContainerObj)trgContainer);
        if(trgContainer.get_patchRefsMap()!=null) 
            trgContainer.get_patchRefsMap().put(this, newObj);
        newObj._deepCopyInternal(this, trgContainer);
        return newObj;

    }

    /** 
      * Make a deep clone of this semantic object. Whole containment graph 
      * is cloned. References are updated. Note this is not the same 
      * as cloning the IMF objects: this clone ensures any semantic logic 
      * is executed for the new objects
      */
    public SATableWriteCapabilityAttributesExtension deepClone(SL_ContainerObj trgContainer) {
        SATableWriteCapabilityAttributesExtension newObj = (SATableWriteCapabilityAttributesExtension) this._newObj_NonStatic((SL_ContainerObj)trgContainer);
        if(trgContainer.get_patchRefsMap()!=null) 
            trgContainer.get_patchRefsMap().put(this, newObj);
        newObj.deepCopy(this, trgContainer);
        return newObj;

    }

    /** 
      * Create new instance. Just calls static newObj method. Useful for
      * generated code where the exact class of an object is not known.
      */
    public SATableWriteCapabilityAttributesExtension _newObj_NonStatic(SL_ContainerObj trgContainer) throws SL_Exception
    {
        return newObj((SL_ContainerObj)trgContainer);
    }

    /** 
      * Make this semantic object a deep copy of 'fromObj'. Whole containment graph 
      * is cloned. References are updated. Note this is not the same 
      * as cloning the IMF objects: this copy ensures any semantic logic 
      * is executed for the new objects. Agreegates are not copied.
      */
    public void deepCopy(SL_Obj fromObj,SL_ContainerObj trgContainer) {
        rootObj.set_patchRefsMap(new HashMap<SL_Obj, SL_Obj>());
        _deepCopyInternal(fromObj, trgContainer);
        _patchReferencesInternal(fromObj);
        rootObj.set_patchRefsMap(null);

    }

    /** 
      * Helper function for deepCopy/deepClone. Fixes references.
      */
    public void _patchReferencesInternal(SL_Obj fromObjArg) {
        SATableWriteCapabilityAttributesExtension fromObj = (SATableWriteCapabilityAttributesExtension)fromObjArg;

        // Get the map of old->new references
        Map<SL_Obj, SL_Obj> map = rootObj.get_patchRefsMap();

        SL_Obj wkObj;
        super._patchReferencesInternal(fromObj);


    }

}
