package com.legyver.tuktukfx.observer;

import com.legyver.tuktukfx.adapter.TaskStatusAdapter;
import com.legyver.tuktukfx.event.TaskProgressTickerEvent;
import com.legyver.tuktukfx.status.TaskTimingData;

/**
 * A task observer that reports the progress of a task based on the {@link #timingData}
 */
public class ProgressObserver implements TaskObserver<TaskProgressTickerEvent> {

	/**
	 * The inner-to-outer task status adapter
	 */
	private final TaskStatusAdapter task;

	/**
	 * The task timing data
	 */
	private final TaskTimingData timingData;

	/**
	 * Constructor to create a ProgressObserver.
	 * @param statusAdapter: Task status adapter that allows sending inner events to the outer task
	 * @param timingData: Task timing data used to base progress calculations on
	 */
	public ProgressObserver(TaskStatusAdapter statusAdapter, TaskTimingData timingData) {
		this.task = statusAdapter;
		this.timingData = timingData;
	}

	/**
	 * Updates the outer task with the progress.
	 * If the actual count is greater than the expected number, will just send domain/domain so completion
	 * percentage never exceeds 100%.
	 *
	 * @param event: the actual event
	 */
	@Override
	public void handle(TaskProgressTickerEvent event) {
		if (event.getCount() < timingData.getDomainSize()) {
			task.updateProgress(event.getCount(), timingData.getDomainSize());
		} else {
			task.updateProgress(timingData.getDomainSize(), timingData.getDomainSize());
		}
	}

}
