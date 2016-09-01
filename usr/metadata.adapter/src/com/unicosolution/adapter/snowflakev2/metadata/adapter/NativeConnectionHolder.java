package com.unicosolution.adapter.snowflakev2.metadata.adapter;

import java.sql.Connection;

/**
 * Wrapper for database connections meant to be used by the Bulk Write code
 * 
 * @author Karthikeyan, UNICO
 * @date 11-Aug-2016
 */
public class NativeConnectionHolder {
	
	private Connection putConnection;
	private Connection processConnection;
	
	public NativeConnectionHolder(Connection putConnection,
			Connection processConnection) {
		
		this.putConnection = putConnection;
		this.processConnection = processConnection;
	}
	
	public void setPutConnection(Connection putConnection) {
		this.putConnection = putConnection;
	}

	public void setProcessConnection(Connection processConnection) {
		this.processConnection = processConnection;
	}

	public Connection getPutConnection() {
		return putConnection;
	}
	
	public Connection getProcessConnection() {
		return processConnection;
	}
	
	

}
