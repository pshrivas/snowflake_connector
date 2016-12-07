// Copyright (c) 2010 Informatica Corporation. All rights reserved.

// *** This file is generated. Do not modify. ***

package com.unicosolution.adapter.snowflakev2.table.runtime.capability.objectmanager.auto;

import java.io.PrintStream;
import com.informatica.sdk.adapter.metadata.common.semantic.iface.MetadataObject;
import java.util.Iterator;
import java.util.Date;
import com.informatica.messages.InfaMessage;
import java.util.Collection;
import java.util.Set;
import java.util.HashMap;
import com.informatica.sdk.adapter.metadata.common.semantic.iface.Action;
import com.informatica.sdk.adapter.metadata.common.semantic.iface.ObjectManagerContext;
import java.util.ArrayList;
import java.util.List;
import com.informatica.sdk.adapter.metadata.asoextension.objectmanager.manual.MD_ModelExtensionWriteCapAttributes;
import com.informatica.imf.icore.IProperty;
import com.informatica.adapter.sdkadapter.logical.semantic.manual.*;
import com.informatica.adapter.sdkadapter.logical.objectmanager.manual.ObjectManagerContextImpl;
import com.unicosolution.adapter.snowflakev2.table.runtime.capability.semantic.auto.SATableWriteCapabilityAttributesExtension;
import com.informatica.adapter.sdkadapter.logical.objectmanager.manual.OM_Obj;
import com.informatica.adapter.sdkadapter.logical.semantic.messages.Sdk_app_comMsg;
import java.util.Collections;
import com.informatica.adapter.sdkadapter.logical.validation.manual.SL_ValidationException;
import java.util.LinkedHashSet;

/** 
  * Object Manager for 
  */
@SuppressWarnings("unused") //$NON-NLS-1$
public class MATableWriteCapabilityAttributesExtension extends MD_ModelExtensionWriteCapAttributes implements OM_Obj
{

    /** Validate all fields. Override this in semantic layer to add custom validation */
    public boolean validateAll(boolean recurse, ObjectManagerContext ctx, MetadataObject currentObj, MetadataObject containerObj) throws SL_ValidationException
    {
        boolean rc = true;
        if(!super.validateAll(recurse, ctx, currentObj, containerObj))
            rc = false;
        SATableWriteCapabilityAttributesExtension semObj = (SATableWriteCapabilityAttributesExtension)currentObj;
        SL_ContainerObj rootObj = semObj.getRootObj();
        if(!validate_UpdateMode(new ObjectManagerContextImpl(Action.NOCHANGE), semObj.getUpdateMode(), semObj)) rc = false;
        if(!validate_truncateTargetTable(new ObjectManagerContextImpl(Action.NOCHANGE), semObj.isTruncateTargetTable(), semObj)) rc = false;
        if(!validate_bulkLoad(new ObjectManagerContextImpl(Action.NOCHANGE), semObj.isBulkLoad(), semObj)) rc = false;
        if(!validate_preSql(new ObjectManagerContextImpl(Action.NOCHANGE), semObj.getPreSql(), semObj)) rc = false;
        if(!validate_postSql(new ObjectManagerContextImpl(Action.NOCHANGE), semObj.getPostSql(), semObj)) rc = false;
        if(!validate_abortOnErrors(new ObjectManagerContextImpl(Action.NOCHANGE), semObj.isAbortOnErrors(), semObj)) rc = false;
        if(!validate_propagateData(new ObjectManagerContextImpl(Action.NOCHANGE), semObj.isPropagateData(), semObj)) rc = false;
        if(!validate_oneBatch(new ObjectManagerContextImpl(Action.NOCHANGE), semObj.isOneBatch(), semObj)) rc = false;
        if(!validate_startTransactionForJobs(new ObjectManagerContextImpl(Action.NOCHANGE), semObj.isStartTransactionForJobs(), semObj)) rc = false;
        if(!validate_updateKeyColumns(new ObjectManagerContextImpl(Action.NOCHANGE), semObj.getUpdateKeyColumns(), semObj)) rc = false;
        return rc;

    }

    /** Validate the 'UpdateMode' property  */
    public boolean validate_UpdateMode(ObjectManagerContext ctx, String newVal, MetadataObject semanticObject) throws SL_ValidationException
    {
        boolean rc = true;
        if(newVal.length()<0 || newVal.length()>4000)
            rc = Utils.processLengthViolation((SL_Obj)semanticObject, newVal.length(), 0, 4000, newVal, com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.UPDATE_MODE);
        return rc;

    }

    /** Validate the 'truncateTargetTable' property  */
    public boolean validate_truncateTargetTable(ObjectManagerContext ctx, boolean newVal, MetadataObject semanticObject) throws SL_ValidationException
    {
        boolean rc = true;
        return rc;

    }

    /** Validate the 'bulkLoad' property  */
    public boolean validate_bulkLoad(ObjectManagerContext ctx, boolean newVal, MetadataObject semanticObject) throws SL_ValidationException
    {
        boolean rc = true;
        return rc;

    }

    /** Validate the 'preSql' property  */
    public boolean validate_preSql(ObjectManagerContext ctx, String newVal, MetadataObject semanticObject) throws SL_ValidationException
    {
        boolean rc = true;
        if(newVal.length()<0 || newVal.length()>4000)
            rc = Utils.processLengthViolation((SL_Obj)semanticObject, newVal.length(), 0, 4000, newVal, com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.PRE_SQL);
        return rc;

    }

    /** Validate the 'postSql' property  */
    public boolean validate_postSql(ObjectManagerContext ctx, String newVal, MetadataObject semanticObject) throws SL_ValidationException
    {
        boolean rc = true;
        if(newVal.length()<0 || newVal.length()>4000)
            rc = Utils.processLengthViolation((SL_Obj)semanticObject, newVal.length(), 0, 4000, newVal, com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.POST_SQL);
        return rc;

    }

    /** Validate the 'abortOnErrors' property  */
    public boolean validate_abortOnErrors(ObjectManagerContext ctx, boolean newVal, MetadataObject semanticObject) throws SL_ValidationException
    {
        boolean rc = true;
        return rc;

    }

    /** Validate the 'propagateData' property  */
    public boolean validate_propagateData(ObjectManagerContext ctx, boolean newVal, MetadataObject semanticObject) throws SL_ValidationException
    {
        boolean rc = true;
        return rc;

    }

    /** Validate the 'oneBatch' property  */
    public boolean validate_oneBatch(ObjectManagerContext ctx, boolean newVal, MetadataObject semanticObject) throws SL_ValidationException
    {
        boolean rc = true;
        return rc;

    }

    /** Validate the 'startTransactionForJobs' property  */
    public boolean validate_startTransactionForJobs(ObjectManagerContext ctx, boolean newVal, MetadataObject semanticObject) throws SL_ValidationException
    {
        boolean rc = true;
        return rc;

    }

    /** Validate the 'updateKeyColumns' property  */
    public boolean validate_updateKeyColumns(ObjectManagerContext ctx, String newVal, MetadataObject semanticObject) throws SL_ValidationException
    {
        boolean rc = true;
        if(newVal.length()<0 || newVal.length()>4000)
            rc = Utils.processLengthViolation((SL_Obj)semanticObject, newVal.length(), 0, 4000, newVal, com.unicosolution.adapter.snowflakev2.table.runtime.capability.TableWriteCapabilityAttributesExtension.Properties.UPDATE_KEY_COLUMNS);
        return rc;

    }

}
