package com.legyver.tuktukfx.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.legyver.tuktukfx.adapter.TaskStatusAdapter;
import com.legyver.tuktukfx.event.TaskEvent;
import com.legyver.tuktukfx.event.TaskEventType;
import com.legyver.core.exception.CoreException;
import com.legyver.tuktukfx.observer.ProgressObserver;
import com.legyver.tuktukfx.observer.TaskObserver;
import com.legyver.tuktukfx.processor.TaskProcessorArgs;
import com.legyver.tuktukfx.status.TaskTimingData;

public abstract class AbstractObservableTask<T, U extends TaskProcessorArgs> implements ITask<T>, ProtoTaskFlow<U> {

	private final Map<String, List<TaskObserver>> observers = new HashMap<>();
	private final TaskTimingData timingData;

	public AbstractObservableTask(TaskTimingData timingData) {
		this.timingData = timingData;
	}

	@Override
	public void addObservers(TaskStatusAdapter task) {
		addObserver(TaskEventType.CURSOR, new ProgressObserver(task, timingData));
	}

	protected void addObserver(String type, TaskObserver observer) {
		List<TaskObserver> processedEventObservers = observers.get(type);
		if (processedEventObservers == null) {
			processedEventObservers = new ArrayList<>();
			observers.put(type, processedEventObservers);
		}
		processedEventObservers.add(observer);
	}

	@Override
	public void notifyObservers(TaskEvent event) throws CoreException {
		List<TaskObserver> eventObservers = observers.get(event.getType());
		if (eventObservers != null) {
			for (TaskObserver observer : eventObservers) {
				observer.handle(event);
			}
		}
	}
}
