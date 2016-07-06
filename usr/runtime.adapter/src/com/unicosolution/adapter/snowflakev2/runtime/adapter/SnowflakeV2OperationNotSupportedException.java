/**
 * 
 */
package com.unicosolution.adapter.snowflakev2.runtime.adapter;

import com.informatica.sdk.exceptions.SDKException;

/**
 * Thrown when Bulk Write cannot be performed in a given scenario.
 * 
 * @author UnicoSolution
 *
 */
public class SnowflakeV2OperationNotSupportedException extends SDKException {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -5860752548627516811L;
	private String message;
	
	public SnowflakeV2OperationNotSupportedException() {
		super();
	}
	
	public SnowflakeV2OperationNotSupportedException(String msg) {
		super();
		message = msg;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
