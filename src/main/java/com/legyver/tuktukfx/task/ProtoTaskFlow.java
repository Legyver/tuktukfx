package com.legyver.tuktukfx.task;

import com.legyver.tuktukfx.adapter.TaskStatusAdapter;
import com.legyver.tuktukfx.event.TaskEvent;
import com.legyver.core.exception.CoreException;
import com.legyver.tuktukfx.processor.TaskProcessor;
import com.legyver.tuktukfx.processor.TaskProcessorArgs;

public interface ProtoTaskFlow<T extends TaskProcessorArgs> {

	void addObservers(TaskStatusAdapter task);

	void notifyObservers(TaskEvent event) throws CoreException;

	TaskProcessor getTaskProcessor();

	T getTaskProcessorArgs();

	default void updateStatus(TaskStatusAdapter adapter, String message) {
		adapter.updateTitle(message);
	}

	default void updateInstafeed(TaskStatusAdapter adapter, String message) {
		adapter.updateMessage(message);
	}

	default void updateProgress(TaskStatusAdapter adapter, double numerator, double denominator) {
		adapter.updateProgress(numerator, denominator);
	}

	default void process(TaskStatusAdapter adapter, double domain) throws CoreException {
		addObservers(adapter);

		TaskProcessor taskProcessor = getTaskProcessor();
		taskProcessor.process(adapter, getTaskProcessorArgs());

		updateInstafeed(adapter, "");
		updateStatus(adapter, "Done");
		updateProgress(adapter, domain, domain);//complete
	}
}
