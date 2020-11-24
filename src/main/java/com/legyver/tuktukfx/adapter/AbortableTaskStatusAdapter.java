package com.legyver.tuktukfx.adapter;

/**
 * Allow inside-out communication of abortion.
 */
public interface AbortableTaskStatusAdapter extends TaskStatusAdapter, Runnable {
	/**
	 * Abort the current task.
	 */
	void abort();

	/**
	 * Monitor and break on this inside loops to speed-up task cancellation.
	 *
	 * @return returns true if the task is aborted
	 */
	boolean isAborted();
}
