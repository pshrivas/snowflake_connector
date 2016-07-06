// Copyright (c) 2010 Informatica Corporation. All rights reserved.

// *** This file is generated. Do not modify. ***

package com.unicosolution.adapter.snowflakev2.table.runtime.capability.semantic.auto;

import java.util.Date;
import com.unicosolution.adapter.snowflakev2.table.runtime.capability.objectmanager.auto.MATableReadCapabilityAttributesExtension;
import com.informatica.tools.core.change.ObjectChangeSink;
import java.util.HashMap;
import com.informatica.imf.utils.ObjectUtils;
import com.informatica.sdk.adapter.metadata.common.semantic.iface.Action;
import java.util.ArrayList;
import com.informatica.imf.icore.IProperty;
import com.informatica.metadata.common.modelextension.semantic.auto.SAModelExtension;
import com.informatica.adapter.sdkadapter.logical.semantic.manual.*;
import java.util.Map;
import com.informatica.adapter.sdkadapter.logical.objectmanager.manual.ObjectManagerContextImpl;
import com.informatica.tools.core.change.impl.PropertyBasedObjectChangeImpl;
import com.informatica.adapter.sdkadapter.logical.validation.manual.SL_ValidationException;
import com.informatica.adapter.sdkadapter.logical.semantic.manual.SL_ObjImpl;
import java.util.LinkedHashSet;
import java.io.PrintStream;
import java.util.Iterator;
import com.informatica.messages.InfaMessage;
import com.informatica.adapter.sdkadapter.asoextension.semantic.auto.SAD_ModelExtensionReadCapAttributes;
import java.util.Collection;
import java.util.Set;
import com.unicosolution.adapter.snowflakev2.table.runtime.capability.semantic.iface.SEMTableReadCapabilityAttributesExtension;
import java.util.List;
import com.informatica.semantic.change.ObjectChange;
import com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension;
import com.unicosolution.adapter.snowflakev2.table.runtime.capability.CapabilityIFactory;
import com.informatica.adapter.sdkadapter.logical.semantic.messages.Sdk_app_comMsg;
import java.util.Collections;

/** 
  * Code generated semantic layer wrapper for TableReadCapabilityAttributesExtension
  */
@SuppressWarnings("unused") //$NON-NLS-1$
public class SATableReadCapabilityAttributesExtension extends SAD_ModelExtensionReadCapAttributes implements SL_Obj, SEMTableReadCapabilityAttributesExtension
{

    // Unique property IDs for use with generic versions of get/set/add/remove/(etc):
    public static final int PRESQL_ID = 195095397;
    public static final int POSTSQL_ID = 22973336;
    public static final int ROWOFFSET_ID = 1787464580;
    public static final int ROWLIMIT_ID = 1766751663;

    protected HashMap<IProperty, Integer> propMap = new HashMap<IProperty, Integer>();
    // get IProperty->propId map
    public Map<IProperty, Integer> getPropMap(){
        // populate the property map if empty
        if (propMap.isEmpty()) {
            java.util.List<IProperty> props = ObjectUtils.getMetaClass(_get_imfObject()).getAllProperties();
            for (IProperty prop : props) {
                // create prop id string
                String propIDStr = prop.getName().toUpperCase() + "_ID";
                if (propIDStr.equalsIgnoreCase("PRESQL_ID"))
                    propMap.put(prop,PRESQL_ID);
                else if (propIDStr.equalsIgnoreCase("POSTSQL_ID"))
                    propMap.put(prop,POSTSQL_ID);
                else if (propIDStr.equalsIgnoreCase("ROWOFFSET_ID"))
                    propMap.put(prop,ROWOFFSET_ID);
                else if (propIDStr.equalsIgnoreCase("ROWLIMIT_ID"))
                    propMap.put(prop,ROWLIMIT_ID);

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
    public SATableReadCapabilityAttributesExtension()
    {
        super();
    }

    /** Get underlying IMF object. Reserved for semantic layer use only */
    public TableReadCapabilityAttributesExtension _get_imfObject()
    {
        return (TableReadCapabilityAttributesExtension)_imfObject;
    }

    /** Create new instance of Semantic layer object (inc. associated IMF object) */
    public static SATableReadCapabilityAttributesExtension newObj(SL_ContainerObj root) throws SL_Exception
    {
        TableReadCapabilityAttributesExtension imfObj = CapabilityIFactory.I_INSTANCE.createTableReadCapabilityAttributesExtension();
        Utils.objectUtilsNewObject(imfObj);
        return newObjFrom(imfObj, root);
    }


    /** Create new instance of Semantic layer object (for given IMF object) */
    protected static SATableReadCapabilityAttributesExtension newObjFrom(TableReadCapabilityAttributesExtension imfObj, SL_ContainerObj root) throws SL_Exception
    {
        SATableReadCapabilityAttributesExtension newObj = (SATableReadCapabilityAttributesExtension)root.get_factory().newSemanticClass(TableReadCapabilityAttributesExtension.class, root.get_factory().getClass().getClassLoader());
        newObj.rootObj = root;
        newObj._validator = (MATableReadCapabilityAttributesExtension)root.get_factory().newObjectmanagerClass(TableReadCapabilityAttributesExtension.class, root.get_factory().getClass().getClassLoader());
        newObj._imfObject = imfObj;
        Utils.addObjectExtension(newObj);
        return newObj;
    }


    /** Get associated Semantic layer object from iObjectInfo extensions */
    public static  SATableReadCapabilityAttributesExtension getSemanticObject(TableReadCapabilityAttributesExtension imfObj)
    {
        SATableReadCapabilityAttributesExtension rc = (SATableReadCapabilityAttributesExtension)Utils.getObjectExtension(imfObj);
        if(rc==null) {
            SL_ContainerObj container = Utils.getSemanticContainer(imfObj);
            rc = (SATableReadCapabilityAttributesExtension)Utils.invoke_buildSemanticLayer(imfObj, container, container.get_factory(), container.getClass().getClassLoader());
        }

        return rc;
    }

    public MATableReadCapabilityAttributesExtension _get_objectmanager()
    {
        return (MATableReadCapabilityAttributesExtension)_validator;
    }

    public TableReadCapabilityAttributesExtension getAdaptee()
    {
        return _get_imfObject();

    }

    /** Override if you need something more than the plain PropertyBasedObjectChangeImpl */
    protected ObjectChange createPropertyChange(Object object, IProperty property)
    {
        return Utils.createPropertyChange(object, property);

    }

    /** 
      * Get the 'preSQL' property.
      */
    public String getPreSQL()
    {
        return _get_imfObject().getPreSQL();
    }

    /** 
      * Set the 'preSQL' property.
      */
    public final void setPreSQL(String newObj)throws SL_Exception
    {
        setPreSQL(newObj, null);
    }


    /** 
      * Set the 'preSQL' property.
      */
    public void setPreSQL(String newVal, ObjectChangeSink sink)
    {
        if(newVal!=null && newVal.equals(getPreSQL())) return;

        if(rootObj.isAutoValidate())
            _get_objectmanager().validate_preSQL(new ObjectManagerContextImpl(Action.SET), newVal, this);

        ((TableReadCapabilityAttributesExtension)_imfObject).setPreSQL(newVal);
        Utils.setBitCascade(sink, getAdaptee());
        if (sink != null) {
            ObjectChange change = createPropertyChange(getAdaptee(), TableReadCapabilityAttributesExtension.Properties.PRE_S_Q_L);
            sink.addObjectChange(getAdaptee(), change);
        }


    }

    /** 
      * Get the 'postSQL' property.
      */
    public String getPostSQL()
    {
        return _get_imfObject().getPostSQL();
    }

    /** 
      * Set the 'postSQL' property.
      */
    public final void setPostSQL(String newObj)throws SL_Exception
    {
        setPostSQL(newObj, null);
    }


    /** 
      * Set the 'postSQL' property.
      */
    public void setPostSQL(String newVal, ObjectChangeSink sink)
    {
        if(newVal!=null && newVal.equals(getPostSQL())) return;

        if(rootObj.isAutoValidate())
            _get_objectmanager().validate_postSQL(new ObjectManagerContextImpl(Action.SET), newVal, this);

        ((TableReadCapabilityAttributesExtension)_imfObject).setPostSQL(newVal);
        Utils.setBitCascade(sink, getAdaptee());
        if (sink != null) {
            ObjectChange change = createPropertyChange(getAdaptee(), TableReadCapabilityAttributesExtension.Properties.POST_S_Q_L);
            sink.addObjectChange(getAdaptee(), change);
        }


    }

    /** 
      * Get the 'rowOffSet' property.
      */
    public int getRowOffSet()
    {
        return _get_imfObject().getRowOffSet();
    }

    /** 
      * Set the 'rowOffSet' property.
      */
    public final void setRowOffSet(int newObj)throws SL_Exception
    {
        setRowOffSet(newObj, null);
    }


    /** 
      * Set the 'rowOffSet' property.
      */
    public void setRowOffSet(int newVal, ObjectChangeSink sink)
    {
        if(newVal==getRowOffSet()) return;

        if(rootObj.isAutoValidate())
            _get_objectmanager().validate_rowOffSet(new ObjectManagerContextImpl(Action.SET), newVal, this);

        ((TableReadCapabilityAttributesExtension)_imfObject).setRowOffSet(newVal);
        Utils.setBitCascade(sink, getAdaptee());
        if (sink != null) {
            ObjectChange change = createPropertyChange(getAdaptee(), TableReadCapabilityAttributesExtension.Properties.ROW_OFF_SET);
            sink.addObjectChange(getAdaptee(), change);
        }


    }

    /** 
      * Get the 'rowLimit' property.
      */
    public int getRowLimit()
    {
        return _get_imfObject().getRowLimit();
    }

    /** 
      * Set the 'rowLimit' property.
      */
    public final void setRowLimit(int newObj)throws SL_Exception
    {
        setRowLimit(newObj, null);
    }


    /** 
      * Set the 'rowLimit' property.
      */
    public void setRowLimit(int newVal, ObjectChangeSink sink)
    {
        if(newVal==getRowLimit()) return;

        if(rootObj.isAutoValidate())
            _get_objectmanager().validate_rowLimit(new ObjectManagerContextImpl(Action.SET), newVal, this);

        ((TableReadCapabilityAttributesExtension)_imfObject).setRowLimit(newVal);
        Utils.setBitCascade(sink, getAdaptee());
        if (sink != null) {
            ObjectChange change = createPropertyChange(getAdaptee(), TableReadCapabilityAttributesExtension.Properties.ROW_LIMIT);
            sink.addObjectChange(getAdaptee(), change);
        }


    }

    /** Pretty-print this object: */
    public String toString()
    {
        String rc = "SATableReadCapabilityAttributesExtension " +" (hashCode="+hashCode()+")";
        rc += " (preSQL="+getPreSQL()+")";
        rc += " (postSQL="+getPostSQL()+")";
        rc += " (rowOffSet="+getRowOffSet()+")";
        rc += " (rowLimit="+getRowLimit()+")";
        return rc;

    }

    /** Builds semantic layer objects for existing IMF model */
    public static SATableReadCapabilityAttributesExtension buildSemanticLayer(TableReadCapabilityAttributesExtension imfObj, SL_ContainerObj root) throws SL_Exception
    {
        SATableReadCapabilityAttributesExtension me = newObjFrom(imfObj, (SL_ContainerObj)root);
        me._buildSemanticLayerRecurse(root);
        return me;

    }

    /** Recursive helper method for building semantic layer */
    public SATableReadCapabilityAttributesExtension _buildSemanticLayerRecurse(SL_ContainerObj root) throws SL_Exception
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
            case PRESQL_ID:
                return getPreSQL();
            case POSTSQL_ID:
                return getPostSQL();
            case ROWOFFSET_ID:
                return getRowOffSet();
            case ROWLIMIT_ID:
                return getRowLimit();
            default:
                return super.get(propID);
            }

    }

    /** Set the value of property identified by 'propID'. Primitives are set as boxed. */
    public void set(int propID, Object obj) throws SL_Exception
    {
            switch(propID)
            {
            case PRESQL_ID:
                setPreSQL((String)obj);
                return;
            case POSTSQL_ID:
                setPostSQL((String)obj);
                return;
            case ROWOFFSET_ID:
                setRowOffSet((java.lang.Integer)obj);
                return;
            case ROWLIMIT_ID:
                setRowLimit((java.lang.Integer)obj);
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
        SATableReadCapabilityAttributesExtension fromObj = (SATableReadCapabilityAttributesExtension)fromObjArg;
        super._shallowCopyInternal((SL_Obj)fromObj);

        setPreSQL(fromObj.getPreSQL());

        setPostSQL(fromObj.getPostSQL());

        setRowOffSet(fromObj.getRowOffSet());

        setRowLimit(fromObj.getRowLimit());
    }

    /** 
      * Make this object a deep copy of 'fromObj'. References are not updated.
      * Typically use deepCopy() instead of this.
      */
    public  void _deepCopyInternal(SL_Obj fromObjArg,SL_ContainerObj trgContainer) {
        _shallowCopyInternal(fromObjArg);
        SATableReadCapabilityAttributesExtension fromObj = (SATableReadCapabilityAttributesExtension)fromObjArg;
        super._deepCopyInternal((SAD_ModelExtensionReadCapAttributes)fromObj,trgContainer);


    }

    /** 
      * return shallow clone of this object. Primitives & references are copied as-is.
      * Contained sub objects and contained collections are changed. 
      */
    public SL_Obj _shallowCloneInternal(SL_ContainerObj trgContainer) {
        SATableReadCapabilityAttributesExtension newObj = (SATableReadCapabilityAttributesExtension) this._newObj_NonStatic((SL_ContainerObj)trgContainer);
        if(trgContainer.get_patchRefsMap()!=null) 
            trgContainer.get_patchRefsMap().put(this, newObj);
        newObj._shallowCopyInternal(this);
        return newObj;
    }

    /** 
      * Return deep clone of this object. References are not updated.
      * Typically use deepClone() instead of this.
      */
    public SATableReadCapabilityAttributesExtension _deepCloneInternal(SL_ContainerObj trgContainer) {
        SATableReadCapabilityAttributesExtension newObj = (SATableReadCapabilityAttributesExtension) this._newObj_NonStatic((SL_ContainerObj)trgContainer);
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
    public SATableReadCapabilityAttributesExtension deepClone(SL_ContainerObj trgContainer) {
        SATableReadCapabilityAttributesExtension newObj = (SATableReadCapabilityAttributesExtension) this._newObj_NonStatic((SL_ContainerObj)trgContainer);
        if(trgContainer.get_patchRefsMap()!=null) 
            trgContainer.get_patchRefsMap().put(this, newObj);
        newObj.deepCopy(this, trgContainer);
        return newObj;

    }

    /** 
      * Create new instance. Just calls static newObj method. Useful for
      * generated code where the exact class of an object is not known.
      */
    public SATableReadCapabilityAttributesExtension _newObj_NonStatic(SL_ContainerObj trgContainer) throws SL_Exception
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
        SATableReadCapabilityAttributesExtension fromObj = (SATableReadCapabilityAttributesExtension)fromObjArg;

        // Get the map of old->new references
        Map<SL_Obj, SL_Obj> map = rootObj.get_patchRefsMap();

        SL_Obj wkObj;
        super._patchReferencesInternal(fromObj);


    }

}
