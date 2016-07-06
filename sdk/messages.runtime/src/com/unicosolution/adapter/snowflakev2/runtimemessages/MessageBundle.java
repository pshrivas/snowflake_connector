package com.unicosolution.adapter.snowflakev2.runtimemessages;

import com.informatica.sdk.i18n.exceptions.MessageException;

public class MessageBundle  {

    private static com.informatica.sdk.common.i18n.MessageBundle  msgBundle = null;

    private MessageBundle(){}


    public static synchronized com.informatica.sdk.common.i18n.MessageBundle getInstance(){
    		try {
    			if (msgBundle == null) {
    				msgBundle = new com.informatica.sdk.common.i18n.MessageBundle(Messages.BUNDLE_ID);
    			}
    		} catch (MessageException e) {
    		}
    		return msgBundle;
    }


}