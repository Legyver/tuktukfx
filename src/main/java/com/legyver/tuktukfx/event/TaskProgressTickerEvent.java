package com.legyver.tuktukfx.event;

public class TaskProgressTickerEvent extends TaskEvent {

	private final int count;

	public TaskProgressTickerEvent(String subject, String type, int count) {
		super(subject, type);
		this.count = count;
	}

	public int getCount() {
		return count;
	}

}
