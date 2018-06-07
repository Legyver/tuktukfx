package com.legyver.tuktukfx.event;

public class TaskEvent {
	private final String subject;
	private final String type;//just a String for extensibility

	public TaskEvent(String subject, String type) {
		this.subject = subject;
		this.type = type;
	}

	public String getSubject() {
		return subject;
	}

	public String getType() {
		return type;
	}

}
