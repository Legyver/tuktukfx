package com.legyver.tuktukfx.task;

import com.legyver.tuktukfx.adapter.TaskStatusAdapter;
import com.legyver.tuktukfx.event.TaskEvent;
import com.legyver.core.exception.CoreException;
import com.legyver.tuktukfx.processor.TaskProcessor;

/**
 * Skeleton flow for tasks
 */
public interface ProtoTaskFlow {

	/**
	 * Register observers to a task
	 * @param statusAdapter: The mechanism to relay status messages to the outer task.
	 */
	void addObservers(TaskStatusAdapter statusAdapter);

	/**
	 * Notify method of the Observer pattern
	 * @param event: The event to notify the observers of
	 * @throws CoreException
	 * 		If your observer throws an exception, this exception will be relayed
	 */
	void notifyObservers(TaskEvent event) throws CoreException;

	/**
	 * Hook to specify the TaskProcessor containing your task logic
	 * @return the task processor
	 */
	TaskProcessor getTaskProcessor();

	/**
	 * Forward the message title to the {@link TaskStatusAdapter}
	 * @param adapter: the Task status adapter
	 * @param title: the status title to forward
	 */
	default void updateStatus(TaskStatusAdapter adapter, String title) {
		adapter.updateTitle(title);
	}

	/**
	 * Forward the message detail to the {@link TaskStatusAdapter}
	 * @param adapter: the Task status adapter
	 * @param message: the status detail to forward
	 */
	default void updateInstafeed(TaskStatusAdapter adapter, String message) {
		adapter.updateMessage(message);
	}

	/**
	 * Forward the progress to the {@link TaskStatusAdapter}
	 * @param adapter: The Task status adapter
	 * @param numerator: the progress count
	 * @param denominator: the domain size
	 */
	default void updateProgress(TaskStatusAdapter adapter, double numerator, double denominator) {
		adapter.updateProgress(numerator, denominator);
	}

	/**
	 * Default execution hooks that ties together the proto-flow.
	 * @param adapter: The Task status adapter
	 * @param domain: size guess
	 * @throws CoreException
	 * if the TaskProcessor throws an exception.
	 */
	default void process(TaskStatusAdapter adapter, double domain) throws CoreException {
		addObservers(adapter);

		TaskProcessor taskProcessor = getTaskProcessor();
		taskProcessor.process(adapter);

		updateInstafeed(adapter, "");
		updateStatus(adapter, "Done");
		updateProgress(adapter, domain, domain);//complete
	}
}
