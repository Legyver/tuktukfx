package com.legyver.tuktukfx.task;

import com.legyver.tuktukfx.status.TaskTimingData;

/**
 * Base class wrapper for tasks you want to be able to abort.
 *
 * @param <R> Type of Return type of task
 * @param <U> Type of TaskContext that extends TaskTimingData
 */
public abstract class AbstractAbortableTask<R, U extends TaskTimingData> extends AbstractObservableTask<R, U> implements IAbortTask<R> {
	private boolean aborted;

	/**
	 * Pass in the main task context here.  This is exists mainly as a way to pass arguments to your task processor.
	 * However, it also serves to communicate the domain/range size to any observers for status reporting.
	 * @param timingData: context for the task
	 */
	public AbstractAbortableTask(U timingData) {
		super(timingData);
	}

	@Override
	public boolean isAborted() {
		return aborted;
	}

	@Override
	public void abort() {
		aborted = true;
	}
}
