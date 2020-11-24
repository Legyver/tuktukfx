package com.legyver.tuktukfx.task;

import com.legyver.tuktukfx.adapter.TaskStatusAdapter;
import com.legyver.core.exception.CoreException;

/**
 * Interface to decouple this task library from JavaFx
 * @param <R> The return type (if any) of the task
 */
public interface ITask<R extends Object> {

	/**
	 * Hook to execute the task code.
	 *
	 * @param statusAdapter: the status adapter used to relay messages to the outer task
	 * @return the result of the task (if-any)
	 * @throws CoreException
	 * If the Task throws an exception, it can wrap it as a CoreException.
	 */
	R execute(TaskStatusAdapter statusAdapter) throws CoreException;
}
