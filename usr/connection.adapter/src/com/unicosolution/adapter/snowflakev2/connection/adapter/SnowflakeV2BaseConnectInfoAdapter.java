package com.unicosolution.adapter.snowflakev2.connection.adapter;

import com.informatica.sdk.adapter.connectionimpl.AbstractINFASDKAdapter;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import com.informatica.sdk.adapter.connection.SDKAdapterInfo;
import com.informatica.sdk.adapter.connection.SDKAdapterTypeEnum;
import com.informatica.sdk.adapter.connection.SDKConnectAttributeType;
import com.informatica.sdk.adapter.connection.SDKConnectionConsumerAttribute;
import com.informatica.sdk.adapter.connection.SDKConnectionConsumerGroup;
import com.informatica.sdk.adapter.connection.SDKConnectionConsumerInfo;
import com.informatica.sdk.adapter.connection.SDKConnectionConsumerPage;
import com.informatica.sdk.adapter.connection.SDKConnectionPoolEnum;
import com.informatica.sdk.adapter.connection.SDKConsumerTypeEnum;

@SuppressWarnings("unused")
public class SnowflakeV2BaseConnectInfoAdapter extends AbstractINFASDKAdapter  {

    SDKAdapterInfo adpInfo;

    // Attribute map
    protected Map<String, SDKConnectAttributeType> attributeMap = new HashMap<String, SDKConnectAttributeType>();

    public SnowflakeV2BaseConnectInfoAdapter(){
        adpInfo = new SDKAdapterInfo();
        adpInfo.setAdapterType(SDKAdapterTypeEnum.ENTERPRISE_APP);
        adpInfo.setResourceBundleName("i18n/SNOWFLAKEV2Bundle");
        adpInfo.setConnectionTypeDesc("SnowflakeV2");
        adpInfo.setConnectionDisplayName("SnowflakeV2");
        adpInfo.setConnectionPoolType(SDKConnectionPoolEnum.NONE);
    }



    /**
     * Implement this method to set the attribute types for the
     * adapter or to modify existing connection attribute types.
     *
     *************************************
     * AUTOGENERATED CODE : DO NOT CHANGE
     *
     * @param  connAttrTypes A list of connection attribute types.
     */

    @Override
    public void updateConnectInfoAttributeTypes(SDKConnectAttributeType attrib){
        String attribName = attrib.getAttributeName();
        List<Object> valuesList;
        if (attribName.equalsIgnoreCase("user")) {
            attrib.setAttributeCLIDisplayName("user");
        }
        else
        if (attribName.equalsIgnoreCase("password")) {
            attrib.setAttributeCLIDisplayName("password");
        }
        else
        if (attribName.equalsIgnoreCase("db")) {
            attrib.setAttributeCLIDisplayName("db");
        }
        else
        if (attribName.equalsIgnoreCase("warehouse")) {
            attrib.setAttributeCLIDisplayName("warehouse");
        }
        else
        if (attribName.equalsIgnoreCase("account")) {
            attrib.setAttributeCLIDisplayName("account");
        }
        else
        if (attribName.equalsIgnoreCase("role")) {
            attrib.setAttributeCLIDisplayName("role");
        }
        else
        if (attribName.equalsIgnoreCase("schema")) {
            attrib.setAttributeCLIDisplayName("schema");
        }
        else
        if (attribName.equalsIgnoreCase("useCustomURL")) {
            attrib.setAttributeCLIDisplayName("useCustomURL");
        }
        else
        if (attribName.equalsIgnoreCase("customURL")) {
            attrib.setAttributeCLIDisplayName("customURL");
        }
        else
        if (attribName.equalsIgnoreCase("clientSessionKeepAlive")) {
            attrib.setAttributeCLIDisplayName("clientSessionKeepAlive");
        }

        attributeMap.put(attribName, attrib);

    }



    /**
     * This method to provides the presentation details like pages for a particular 
     * consumer type. The pages, groups, and attributes displayed for the adapter on 
     * the consumer page depends on the type of consumer application that will use 
     * the adapter. The default presentation page is auto generated. This method can 
     * be changed only if the adapter needs a different type of presentation than the 
     * default generated code
     *
     *************************************
     * AUTOGENERATED CODE : DO NOT CHANGE
     *
     * @param  consumerType  The client application that will use this adapter.
     *
     * @return SDKConnectionConsumerInfo
     *          consumer pages for the adapter
     */

    @Override
    public SDKConnectionConsumerInfo getConnectionConsumerInfo(SDKConsumerTypeEnum type){
    		SDKConnectionConsumerInfo presentationInfo = null;

    		switch (type) {
    		case DEFAULT:
    		    presentationInfo = createPresentationInfoDFLT();
    		    break;
    		default:
    		    presentationInfo = createPresentationInfoDFLT();
    		    break;
    		}
    		return presentationInfo;
    }



    /* 
     * Creates presentation details 
     *************************************
     * AUTOGENERATED CODE : DO NOT CHANGE
     */

    private SDKConnectionConsumerInfo createPresentationInfoDFLT(){
        SDKConnectionConsumerInfo presentationInfo = new SDKConnectionConsumerInfo();

    	presentationInfo.getConnInfoConsumerPages().add(createPage1DFLT());

    	return presentationInfo;

    }



    /* 
     * Creates presentation page 
     *************************************
     * AUTOGENERATED CODE : DO NOT CHANGE
     */

    private SDKConnectionConsumerPage createPage1DFLT(){
    	SDKConnectionConsumerPage presentationPage = new SDKConnectionConsumerPage();

    	presentationPage.setPageName("PAGE_1_NAME");
    	presentationPage.setPageDescription("PAGE_1_DESC");

    	presentationPage.getConnInfoConsumerGroups().add(createPage1Group1DFLT());

    	return presentationPage;

    }



    /* 
     * Creates presentation group 
     *************************************
     * AUTOGENERATED CODE : DO NOT CHANGE
     */

    private SDKConnectionConsumerGroup createPage1Group1DFLT(){
    	SDKConnectionConsumerGroup group = new SDKConnectionConsumerGroup();

    	group.setGroupName("PAGE_1_GROUP_1_NAME");
    	group.setGroupTitle("PAGE_1_GROUP_1_TITLE");
    	group.setGroupTooltip("PAGE_1_GROUP_1_TOOLTIP");

        group.getConnInfoPresentationControls().add(
                	createAttributePresentation("user", "USER", "USER_TOOLTIP",
                	                            true, false, true));

        group.getConnInfoPresentationControls().add(
                	createAttributePresentation("password", "PASSWORD", "PASSWORD_TOOLTIP",
                	                            true, false, true));

        group.getConnInfoPresentationControls().add(
                	createAttributePresentation("db", "DB", "DB_TOOLTIP",
                	                            true, false, false));

        group.getConnInfoPresentationControls().add(
                	createAttributePresentation("warehouse", "WAREHOUSE", "WAREHOUSE_TOOLTIP",
                	                            true, false, false));

        group.getConnInfoPresentationControls().add(
                	createAttributePresentation("account", "ACCOUNT", "ACCOUNT_TOOLTIP",
                	                            true, false, true));

        group.getConnInfoPresentationControls().add(
                	createAttributePresentation("role", "ROLE", "ROLE_TOOLTIP",
                	                            true, false, false));

        group.getConnInfoPresentationControls().add(
                	createAttributePresentation("schema", "SCHEMA", "SCHEMA_TOOLTIP",
                	                            true, false, false));

        group.getConnInfoPresentationControls().add(
                	createAttributePresentation("useCustomURL", "USECUSTOMURL", "USECUSTOMURL_TOOLTIP",
                	                            true, false, true));

        group.getConnInfoPresentationControls().add(
                	createAttributePresentation("customURL", "CUSTOMURL", "CUSTOMURL_TOOLTIP",
                	                            true, false, false));

        group.getConnInfoPresentationControls().add(
                	createAttributePresentation("clientSessionKeepAlive", "CLIENTSESSIONKEEPALIVE", "CLIENTSESSIONKEEPALIVE_TOOLTIP",
                	                            true, false, true));


    	return group;

    }




    /*
    *************************************
    * AUTOGENERATED CODE : DO NOT CHANGE
    */
    @Override
    public SDKAdapterInfo getAdapterInfo() {
    	return adpInfo;
    }

    /** 
    * Creates a new SDKConnectionConsumerAttribute object and populates it with attribute and presentation information.
    * @param attributeName Name of the attribute.
    * @param presentationName Name of the presentation.
    * @param toolTip Tooltip text to display in the user interface.
    * @param enabled Determines whether the attribute is enabled or disabled on the user interface.
    * @param hasDependentAttr Determines whether the attribute has dependent attributes that should be updated for changes in this attribute.
    * @param isMandatory Determines whether the attribute is a mandatory attribute.
    * @return Returns a SDKConnectionConsumerAttribute object which is used on the user interface.
    */
    public SDKConnectionConsumerAttribute createAttributePresentation(
    		String attributeName, String presentationName, String toolTip,
    		boolean enabled, boolean hasDependentAttr, boolean isMandatory) {
    	SDKConnectionConsumerAttribute attributeTypePresentation = new SDKConnectionConsumerAttribute();

    	attributeTypePresentation.setIsHidden(false);
    	attributeTypePresentation.setAttributeName(presentationName);
    	attributeTypePresentation.setToolTip(toolTip);
    	attributeTypePresentation.setIsEnabled(enabled);
    	attributeTypePresentation.setHasDependentAttributes(hasDependentAttr);
    	attributeTypePresentation.setAttributeType(attributeMap
    			.get(attributeName));
    	attributeTypePresentation.getAttributeType()
    			.setIsMandatory(isMandatory);
    	return attributeTypePresentation;
    }


}