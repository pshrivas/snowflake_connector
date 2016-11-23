package com.unicosolution.adapter.snowflakev2.runtime.adapter.utils;

import net.snowflake.client.loader.LoadResultListener;
import net.snowflake.client.loader.LoadingError;
import net.snowflake.client.loader.Operation;
import com.unicosolution.adapter.snowflakev2.runtime.adapter.SnowflakeV2TableDataAdapter;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 */
public class BulkLoadResultListener implements LoadResultListener {
	private final Logger LOGGER = Logger.getLogger(BulkLoadResultListener.class.getName());
	
	private final List<ResultStats> cumulativeSessionStats = new ArrayList<ResultStats>();

	private final ResultStats insertStats = new ResultStats(ResultStats.Operation.INSERT);
	private final ResultStats deleteStats = new ResultStats(ResultStats.Operation.DELETE);
	private final ResultStats updateStats = new ResultStats(ResultStats.Operation.UPDATE);
	private final ResultStats upsertStats = new ResultStats(ResultStats.Operation.UPSERT);
	private final AtomicInteger errorCount = new AtomicInteger(0);
	private final AtomicInteger submittedRowCount = new AtomicInteger(0);

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
		LOGGER.log(Level.FINER,String.format(""));
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
	public void addProcessedRecordCount(Operation op, int count) {
		LOGGER.log(Level.FINER,String.format(
				"Operation: %s: Count: %s", op, count));
		switch (op) {
		case INSERT:
			insertStats.incrementProcessedRowsCount(count);
			break;
		case DELETE:
			deleteStats.incrementProcessedRowsCount(count);
			break;
		case UPSERT:
			upsertStats.incrementProcessedRowsCount(count);
			break;
		case MODIFY:
			updateStats.incrementProcessedRowsCount(count);
			break;
		}
	}

	@Override
	public void addOperationRecordCount(Operation op, int count) {
		LOGGER.log(Level.FINER, String.format(
				"Operation: %s: Count: %s", op, count));
		switch (op) {
		case INSERT:
			insertStats.incrementSuccessRowsCount(count);
			break;
		case DELETE:
			deleteStats.incrementSuccessRowsCount(count);
			break;
		case UPSERT:
			upsertStats.incrementSuccessRowsCount(count);
			break;
		case MODIFY:
			updateStats.incrementSuccessRowsCount(count);
			break;
		}
	}

	public void addRejectedRecordCount(Operation op, int count) {
		LOGGER.log(Level.FINER, String.format(
				"Operation: %s: Count: %s", op, count));
		switch (op) {
		case INSERT:
			insertStats.incrementRejectedRowsCount(count);
			break;
		case DELETE:
			deleteStats.incrementRejectedRowsCount(count);
			break;
		case UPSERT:
			upsertStats.incrementRejectedRowsCount(count);
			break;
		case MODIFY:
			updateStats.incrementRejectedRowsCount(count);
			break;
		}
	}

	public long getOperationRecordCount(Operation op) {
		LOGGER.log(Level.FINER,String.format("Operation: %s", op));
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
		LOGGER.log(Level.FINER,String.format("Operation: %s", op));
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
		LOGGER.log(Level.FINER,String.format("Operation: %s", op));
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
		// TODO: add errors here!!
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

	public void addErrorRecordCount(int i) {
		addRejectedRecordCount(_operation, i);
	}

	public int getErrorRecordCount() {
		return (int) getRejectedRecordCount(_operation);
	}

	public void resetErrorRecordCount() {
		// not used?
	}

	public void addErrorCount(int i) {
		errorCount.addAndGet(i);
	}

	public int getErrorCount() {
		return errorCount.get();
	}

	public void resetErrorCount() {
		errorCount.set(0);
	}

	public void addSubmittedRowCount(int cnt) {
		submittedRowCount.addAndGet(cnt);
	}

	public int getSubmittedRowCount() {
		return submittedRowCount.get();
	}

	public void resetSubmittedRowCount() {
		submittedRowCount.set(0);
	}
}
