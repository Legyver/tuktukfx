package com.legyver.tuktukfx.ctx;

import com.legyver.tuktukfx.status.TaskTimingData;

public class TaskContext {

	private final TaskTimingData taskTimeData;

	public TaskContext(TaskTimingData taskTimeData) {
		this.taskTimeData = taskTimeData;
	}

	public TaskTimingData getTaskTimeData() {
		return taskTimeData;
	}

}
