package com.legyver.tuktukfx.adapter;

import com.legyver.tuktukfx.task.ITask;

import javafx.concurrent.Task;

public class JavaFxAdapter<T extends Object> extends Task<T> implements TaskStatusAdapter {
	private final ITask<T> wrappedTask;

	public JavaFxAdapter(ITask<T> wrappedTask) {
		this.wrappedTask = wrappedTask;
	}

	@Override
	protected T call() throws Exception {
		return wrappedTask.execute(this);
	}

	@Override
	public void updateTitle(String message) {
		super.updateTitle(message);//overriden to expose JavaFx messaging to common ProgressAwareTask abstraction
	}

	@Override
	public void updateMessage(String message) {
		super.updateMessage(message);//overriden to expose JavaFx messaging to common ProgressAwareTask abstraction
	}

	@Override
	public void updateProgress(double numerator, double denominator) {
		super.updateProgress(numerator, denominator);//overriden to expose JavaFx messaging to common ProgressAwareTask abstraction
	}

}
