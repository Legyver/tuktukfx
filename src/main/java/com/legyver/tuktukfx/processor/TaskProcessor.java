package com.legyver.tuktukfx.processor;

import com.legyver.tuktukfx.adapter.TaskStatusAdapter;
import com.legyver.core.exception.CoreException;

public interface TaskProcessor<T extends TaskProcessorArgs> {

	void process(TaskStatusAdapter task, T args) throws CoreException;
}
