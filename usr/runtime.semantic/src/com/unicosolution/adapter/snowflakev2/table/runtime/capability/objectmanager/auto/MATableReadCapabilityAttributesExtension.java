// Copyright (c) 2010 Informatica Corporation. All rights reserved.

// *** This file is generated. Do not modify. ***

package com.unicosolution.adapter.snowflakev2.table.runtime.capability.objectmanager.auto;

import java.io.PrintStream;
import com.informatica.sdk.adapter.metadata.common.semantic.iface.MetadataObject;
import java.util.Iterator;
import java.util.Date;
import com.informatica.messages.InfaMessage;
import java.util.Collection;
import com.unicosolution.adapter.snowflakev2.table.runtime.capability.semantic.auto.SATableReadCapabilityAttributesExtension;
import java.util.Set;
import java.util.HashMap;
import com.informatica.sdk.adapter.metadata.common.semantic.iface.Action;
import com.informatica.sdk.adapter.metadata.common.semantic.iface.ObjectManagerContext;
import java.util.ArrayList;
import java.util.List;
import com.informatica.sdk.adapter.metadata.asoextension.objectmanager.manual.MD_ModelExtensionReadCapAttributes;
import com.informatica.imf.icore.IProperty;
import com.informatica.adapter.sdkadapter.logical.semantic.manual.*;
import com.informatica.adapter.sdkadapter.logical.objectmanager.manual.ObjectManagerContextImpl;
import com.informatica.adapter.sdkadapter.logical.objectmanager.manual.OM_Obj;
import com.informatica.adapter.sdkadapter.logical.semantic.messages.Sdk_app_comMsg;
import java.util.Collections;
import com.informatica.adapter.sdkadapter.logical.validation.manual.SL_ValidationException;
import java.util.LinkedHashSet;

/** 
  * Object Manager for 
  */
@SuppressWarnings("unused") //$NON-NLS-1$
public class MATableReadCapabilityAttributesExtension extends MD_ModelExtensionReadCapAttributes implements OM_Obj
{

    /** Validate all fields. Override this in semantic layer to add custom validation */
    public boolean validateAll(boolean recurse, ObjectManagerContext ctx, MetadataObject currentObj, MetadataObject containerObj) throws SL_ValidationException
    {
        boolean rc = true;
        if(!super.validateAll(recurse, ctx, currentObj, containerObj))
            rc = false;
        SATableReadCapabilityAttributesExtension semObj = (SATableReadCapabilityAttributesExtension)currentObj;
        SL_ContainerObj rootObj = semObj.getRootObj();
        if(!validate_preSQL(new ObjectManagerContextImpl(Action.NOCHANGE), semObj.getPreSQL(), semObj)) rc = false;
        if(!validate_postSQL(new ObjectManagerContextImpl(Action.NOCHANGE), semObj.getPostSQL(), semObj)) rc = false;
        if(!validate_rowOffSet(new ObjectManagerContextImpl(Action.NOCHANGE), semObj.getRowOffSet(), semObj)) rc = false;
        if(!validate_rowLimit(new ObjectManagerContextImpl(Action.NOCHANGE), semObj.getRowLimit(), semObj)) rc = false;
        return rc;

    }

    /** Validate the 'preSQL' property  */
    public boolean validate_preSQL(ObjectManagerContext ctx, String newVal, MetadataObject semanticObject) throws SL_ValidationException
    {
        boolean rc = true;
        if(newVal.length()<0 || newVal.length()>255)
            rc = Utils.processLengthViolation((SL_Obj)semanticObject, newVal.length(), 0, 255, newVal, com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.Properties.PRE_S_Q_L);
        return rc;

    }

    /** Validate the 'postSQL' property  */
    public boolean validate_postSQL(ObjectManagerContext ctx, String newVal, MetadataObject semanticObject) throws SL_ValidationException
    {
        boolean rc = true;
        if(newVal.length()<0 || newVal.length()>255)
            rc = Utils.processLengthViolation((SL_Obj)semanticObject, newVal.length(), 0, 255, newVal, com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableReadCapabilityAttributesExtension.Properties.POST_S_Q_L);
        return rc;

    }

    /** Validate the 'rowOffSet' property  */
    public boolean validate_rowOffSet(ObjectManagerContext ctx, int newVal, MetadataObject semanticObject) throws SL_ValidationException
    {
        boolean rc = true;
        return rc;

    }

    /** Validate the 'rowLimit' property  */
    public boolean validate_rowLimit(ObjectManagerContext ctx, int newVal, MetadataObject semanticObject) throws SL_ValidationException
    {
        boolean rc = true;
        return rc;

    }

}
