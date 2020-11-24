package com.legyver.tuktukfx.processor;

import com.legyver.tuktukfx.adapter.TaskStatusAdapter;
import com.legyver.core.exception.CoreException;

/**
 * Task processor that performs the actual work of the task
 * @param <A>: The type of the {@link TaskStatusAdapter}
 */
public interface TaskProcessor<A extends TaskStatusAdapter> {

	/**
	 * Hook to execute the body of work.
	 *
	 * @param adapter: The actual adapter.
	 * @throws CoreException
	 * If the adapter processor throw an exception wrapped with a CoreException.
	 */
	void process(A adapter) throws CoreException;
}
