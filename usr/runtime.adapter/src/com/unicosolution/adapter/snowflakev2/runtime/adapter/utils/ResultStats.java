package com.unicosolution.adapter.snowflakev2.runtime.adapter.utils;

import java.util.concurrent.atomic.AtomicLong;

public final class ResultStats {
	private AtomicLong rowsProcessed;
	private AtomicLong successRows;
	private AtomicLong rejectedRows;
	private final Operation operation;
	
	public ResultStats(Operation paramOperation) {
		this.rowsProcessed = new AtomicLong(0);
		this.successRows = new AtomicLong(0);
		this.rejectedRows = new AtomicLong(0);
		this.operation = paramOperation;
	}

	public long getCumulativeProcessedRows() {
		return this.rowsProcessed.longValue();
	}

	public long getCumulativeSuccessRows() {
		return this.successRows.longValue();
	}

	public long getCumulativeRejectedRows() {
		return this.rejectedRows.longValue();
	}

	public void incrementSuccessRowsCount(int incrSuccessCount) {
		this.successRows.getAndAdd((long)incrSuccessCount);
	}

	public void incrementProcessedRowsCount(int incrProcessedCount) {
		this.rowsProcessed.getAndAdd((long)incrProcessedCount);
	}

	public void incrementRejectedRowsCount(int incrRejectedCount) {
		this.rejectedRows.getAndAdd((long)incrRejectedCount);
	}

	public Operation getOperation() {
		return this.operation;
	}

	public static enum Operation {
		INSERT, UPDATE, DELETE, UPSERT;
	}
}
