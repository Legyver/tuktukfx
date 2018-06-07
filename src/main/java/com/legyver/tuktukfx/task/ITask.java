package com.legyver.tuktukfx.task;

import com.legyver.tuktukfx.adapter.TaskStatusAdapter;
import com.legyver.core.exception.CoreException;

public interface ITask<T extends Object> {

	T execute(TaskStatusAdapter task) throws CoreException;
}
