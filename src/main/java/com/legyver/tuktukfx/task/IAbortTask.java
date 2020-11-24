package com.legyver.tuktukfx.task;

import com.legyver.tuktukfx.adapter.AbortableTaskStatusAdapter;

/**
 * A task that can be aborted.
 * The main purpose of this interface is to allow cancellation of tasks while running in loops.
 * The burden is on the developer to monitor {@link AbortableTaskStatusAdapter#isAborted()} in the {@link com.legyver.tuktukfx.observer.TaskObserver}
 * @param <R> the return type (if any) of the task
 */
public interface IAbortTask<R> extends ITask<R> {
	/**
	 * Returns true if the task has been ordered to abort.
	 * @return the tasks current abort status
	 */
	boolean isAborted();

	/**
	 * Command to abort a task.
	 */
	void abort();
}
