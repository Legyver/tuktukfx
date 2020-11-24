package com.legyver.tuktukfx.event;

/**
 * Events that can be communicated to task observers.
 */
public class TaskEvent {
	/**
	 * The subject of the event
	 */
	private final String subject;
	/**
	 * The type of the event
	 */
	private final String type;//just a String for extensibility

	/**
	 *
	 * @param subject: the subject of the event
	 * @param type: the type of the event
	 */
	public TaskEvent(String subject, String type) {
		this.subject = subject;
		this.type = type;
	}

	/**
	 * Subject of the event
	 * @return event subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Type of the event.  Can be either one of {@link TaskEventType} or some custom string.
	 * @return even type
	 */
	public String getType() {
		return type;
	}

}
