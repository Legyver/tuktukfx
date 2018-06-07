package com.legyver.tuktukfx.adapter;

public interface TaskStatusAdapter {

	void updateMessage(String message);

	void updateProgress(double numerator, double denominator);

	void updateTitle(String message);

	public boolean isCancelled();
}
