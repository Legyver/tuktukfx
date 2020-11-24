package com.legyver.tuktukfx.observer;

import com.legyver.tuktukfx.event.TaskEvent;
import com.legyver.core.exception.CoreException;

/**
 * Observers to listen for task processing events
 * @param <T>: The type of the task event
 */
public interface TaskObserver<T extends TaskEvent> {

	/**
	 * The action to take on an event.
	 *
	 * @param event: the actual event
	 * @throws CoreException
	 * If the Task Observer needs to throw an exception, it can wrap it in a CoreException.
	 */
	void handle(T event) throws CoreException;

}
