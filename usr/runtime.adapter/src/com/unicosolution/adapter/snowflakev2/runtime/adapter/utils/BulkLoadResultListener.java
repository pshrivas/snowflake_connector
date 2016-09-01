package com.unicosolution.adapter.snowflakev2.runtime.adapter.utils;

import com.snowflake.client.loader.LoadResultListener;
import com.snowflake.client.loader.LoadingError;
import com.snowflake.client.loader.Operation;
import com.unicosolution.adapter.snowflakev2.runtime.adapter.SnowflakeV2TableDataAdapter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 */
public class BulkLoadResultListener implements LoadResultListener {

    private final List<ResultStats> cumulativeSessionStats = new ArrayList<ResultStats>();
    
    private static final String listenerLogFile = "BulkLoadResultListener.log";
    private static final String tmpdir = System.getProperty("java.io.tmpdir");
	public static final String LISTENER_BASE = tmpdir
			+ (((!(tmpdir.endsWith("/"))) && (!(tmpdir.endsWith("\\")))) ? Character
					.valueOf(File.separatorChar) : "") + "snowflake";

	private static final String logLocation = LISTENER_BASE + File.separatorChar + listenerLogFile;

    private final ResultStats insertStats = new ResultStats(ResultStats.Operation.INSERT);
    private final ResultStats deleteStats = new ResultStats(ResultStats.Operation.DELETE);
    private final ResultStats updateStats = new ResultStats(ResultStats.Operation.UPDATE);
    private final ResultStats upsertStats = new ResultStats(ResultStats.Operation.UPSERT);

    private boolean _abort_on = false;
    private boolean _propagate = false;
    
    private Operation _operation;
        
    public Operation getOperation() {
		return _operation;
	}

	public void setOperation(Operation _operation) {
		this._operation = _operation;
	}

	@SuppressWarnings("unused")
	private final SnowflakeV2TableDataAdapter _writer; 
        
    public BulkLoadResultListener(SnowflakeV2TableDataAdapter writer) {

        cumulativeSessionStats.add(insertStats);
        cumulativeSessionStats.add(deleteStats);
        cumulativeSessionStats.add(updateStats);
        cumulativeSessionStats.add(upsertStats);
        
        
        _writer = writer;
    }

    @Override
    public boolean needErrors() {
        return true;
    }

    @Override
    public boolean needSuccessRecords() {
        return _propagate;
    }

    @Override
    public void addProcessedRecordCount(Operation op, int i) {
        switch (op) {
            case INSERT:
                insertStats.incrementProcessedRowsCount(i);
                /*writeLog("BulkLoadResultListener::addProcessedRecordCount: " +
											"incrementProcessedRowsCount(" + i + ") called on insertStats");*/
                break;
            case DELETE:
                deleteStats.incrementProcessedRowsCount(i);
                /*writeLog("BulkLoadResultListener::addProcessedRecordCount: " +
											"incrementProcessedRowsCount(" + i + ") called on deleteStats");*/
                break;
            case UPSERT:
                upsertStats.incrementProcessedRowsCount(i);
                /*writeLog("BulkLoadResultListener::addProcessedRecordCount: " +
											"incrementProcessedRowsCount(" + i + ") called on upsertStats");*/
                break;
            case MODIFY:
                updateStats.incrementProcessedRowsCount(i);
                /*writeLog("BulkLoadResultListener::addProcessedRecordCount: " +
											"incrementProcessedRowsCount(" + i + ") called on updateStats");*/
                break;
        }
    }

    @Override
    public void addOperationRecordCount(Operation op, int i) {
        switch (op) {
            case INSERT:
                insertStats.incrementSuccessRowsCount(i);
                /*writeLog("BulkLoadResultListener::addOperationRecordCount: " +
											"incrementSuccessRowsCount(" + i + ") called on insertStats");*/
                break;
            case DELETE:
                deleteStats.incrementSuccessRowsCount(i);
                /*writeLog("BulkLoadResultListener::addOperationRecordCount: " +
											"incrementSuccessRowsCount(" + i + ") called on deleteStats");*/
                break;
            case UPSERT:
                upsertStats.incrementSuccessRowsCount(i);
                /*writeLog("BulkLoadResultListener::addOperationRecordCount: " +
											"incrementSuccessRowsCount(" + i + ") called on upsertStats");*/
                break;
            case MODIFY:
                updateStats.incrementSuccessRowsCount(i);
                /*writeLog("BulkLoadResultListener::addOperationRecordCount: " +
											"incrementSuccessRowsCount(" + i + ") called on updateStats");*/
                break;
        }
    }
    
    public void addRejectedRecordCount(Operation op, int i) {
        switch (op) {
            case INSERT:
                insertStats.incrementRejectedRowsCount(i);
                /*writeLog("BulkLoadResultListener::addRejectedRecordCount: " +
											"incrementRejectedRowsCount(" + i + ") called on insertStats");*/
                break;
            case DELETE:
                deleteStats.incrementRejectedRowsCount(i);
                /*writeLog("BulkLoadResultListener::addRejectedRecordCount: " +
											"incrementRejectedRowsCount(" + i + ") called on deleteStats");*/
                break;
            case UPSERT:
                upsertStats.incrementRejectedRowsCount(i);
                /*writeLog("BulkLoadResultListener::addRejectedRecordCount: " +
											"incrementRejectedRowsCount(" + i + ") called on upsertStats");*/
                break;
            case MODIFY:
                updateStats.incrementRejectedRowsCount(i);
                /*writeLog("BulkLoadResultListener::addRejectedRecordCount: " +
											"incrementRejectedRowsCount(" + i + ") called on updateStats");*/
                break;
        }
    }

    public long getOperationRecordCount(Operation op) {
       	switch (op) {
            case INSERT:
            	return insertStats.getCumulativeSuccessRows();
            case DELETE:
            	return deleteStats.getCumulativeSuccessRows();
            case UPSERT:
            	return upsertStats.getCumulativeSuccessRows();
            case MODIFY:
            	return updateStats.getCumulativeSuccessRows();
        }
       	return 0L;
    }

	public long getProcessedRecordCount(Operation op) {
       	switch (op) {
            case INSERT:
            	return insertStats.getCumulativeProcessedRows();
            case DELETE:
            	return deleteStats.getCumulativeProcessedRows();
            case UPSERT:
            	return upsertStats.getCumulativeProcessedRows();
            case MODIFY:
            	return updateStats.getCumulativeProcessedRows();
        }
    	return 0L;
    }

    public long getRejectedRecordCount(Operation op) {
    	switch (op) {
            case INSERT:
            	return insertStats.getCumulativeRejectedRows();
            case DELETE:
            	return deleteStats.getCumulativeRejectedRows();
            case UPSERT:
            	return upsertStats.getCumulativeRejectedRows();
            case MODIFY:
            	return updateStats.getCumulativeRejectedRows();
        }
    	return 0L; 
    }    	

    @Override
    public void recordProvided(Operation op, Object[] record) {
    }

    public void addError(LoadingError le) {
    }

    public boolean throwOnError() {
        return _abort_on;
    }

    public List<ResultStats> getCumulativeSessionStats() {
        return cumulativeSessionStats;
    }

    public void setAbortOnErrors(boolean needToAbortOnErrors) {
        this._abort_on = needToAbortOnErrors;
    }

    public void setPropagate(boolean isPropagate) {
        this._propagate = isPropagate;
    }
    
   public void addErrorCount(int i){
	       
	  }
   
   public void addErrorRecordCount(int i){
	   addRejectedRecordCount(_operation, i);
   }

   public int getErrorCount(){
	return 0;
	       
	  }
   
   public int getErrorRecordCount(){
	   return (int)getRejectedRecordCount(_operation);
   }
   
   public void resetErrorCount(){
       
	  }
   
   public void resetErrorRecordCount(){
       
	  }
   
   private void writeLog(String msg) {
	   synchronized(this) {
		   try {
			   PrintWriter pw = new PrintWriter(
					   new BufferedWriter(new FileWriter(logLocation, true)));
			   
			   DateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss z");
			   Date now = new Date();
			   
			   pw.println("[" + df.format(now)+ "] : " + msg);
			   
			   pw.close();
			   
		   } catch(IOException e) {
			   //Do nothing
		   }
	   }
   }

}
