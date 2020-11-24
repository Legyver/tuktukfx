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
import com.legyver.tuktukfx.status.TaskTimingData;

/**
 *
 * @param <R> The return type (if any) of the task.
 * @param <U> The type of task context
 */
public abstract class AbstractObservableTask<R, U extends TaskTimingData> implements ITask<R>, ProtoTaskFlow {

	/**
	 * Tasks can have observers which are registered to a {@link TaskEventType}
	 */
	private final Map<String, List<TaskObserver>> observers = new HashMap<>();
	/**
	 * The task
	 */
	protected final U context;

	/**
	 * Constructor to create an Observable task.
	 * @param context: The task context which includes timing data.  If you don't specify the context,
	 *               You will need to override {@link #execute(TaskStatusAdapter)}
	 */
	public AbstractObservableTask(U context) {
		this.context = context;
	}

	/**
	 * Register observers to a task
	 * @param statusAdapter: The mechanism to relay status messages to the outer task.
	 */
	@Override
	public void addObservers(TaskStatusAdapter statusAdapter) {
		addObserver(TaskEventType.CURSOR, new ProgressObserver(statusAdapter, context));
	}

	/**
	 * Register an observer to a task for a particular {@link TaskEventType}
	 * @param type: The type to register observer for
	 * @param observer: the observer
	 */
	protected void addObserver(String type, TaskObserver observer) {
		List<TaskObserver> processedEventObservers = observers.get(type);
		if (processedEventObservers == null) {
			processedEventObservers = new ArrayList<>();
			observers.put(type, processedEventObservers);
		}
		processedEventObservers.add(observer);
	}

	/**
	 * Notify method of the Observer pattern
	 * @param event: The event to notify the observers of
	 * @throws CoreException
	 * 		If your observer throws an exception, this exception will be relayed
	 */
	@Override
	public void notifyObservers(TaskEvent event) throws CoreException {
		List<TaskObserver> eventObservers = observers.get(event.getType());
		if (eventObservers != null) {
			for (TaskObserver observer : eventObservers) {
				observer.handle(event);
			}
		}
	}

	/**
	 * Convenience default implementation.  Override if you need to return a value when the task completes
	 * @param taskStatusAdapter the {@link TaskStatusAdapter}
	 * @return null by default.
	 * @throws CoreException
	 * 	In the event of an exception, wrap it in a CoreException and rethrow it.
	 */
	@Override
	public R execute(TaskStatusAdapter taskStatusAdapter) throws CoreException {
		process(taskStatusAdapter, context.getDomainSize());
		return null;
	}
}
