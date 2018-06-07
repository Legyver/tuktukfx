package com.legyver.tuktukfx.observer;

import com.legyver.tuktukfx.event.TaskEvent;
import com.legyver.core.exception.CoreException;

public interface TaskObserver<T extends TaskEvent> {

	void handle(T event) throws CoreException;

}
