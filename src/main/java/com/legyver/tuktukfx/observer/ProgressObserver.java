package com.legyver.tuktukfx.observer;

import com.legyver.tuktukfx.adapter.TaskStatusAdapter;
import com.legyver.tuktukfx.event.TaskProgressTickerEvent;
import com.legyver.tuktukfx.status.TaskTimingData;

public class ProgressObserver implements TaskObserver<TaskProgressTickerEvent> {

	private final TaskStatusAdapter task;
	private final TaskTimingData timingData;

	public ProgressObserver(TaskStatusAdapter task, TaskTimingData timingData) {
		this.task = task;
		this.timingData = timingData;
	}

	@Override
	public void handle(TaskProgressTickerEvent event) {
		if (event.getCount() < timingData.getDomainSize()) {
			task.updateProgress(event.getCount(), timingData.getDomainSize());
		} else {
			task.updateProgress(timingData.getDomainSize(), timingData.getDomainSize());
		}
	}

}
