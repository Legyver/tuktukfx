package com.legyver.tuktukfx.event;

/**
 * Event for broadcasting progress (or more explicitly, the range)
 */
public class TaskProgressTickerEvent extends TaskEvent {

	/**
	 * The count
	 */
	private final int count;

	/**
	 * Constructor for an Event that tracks a count
	 * @param subject: The message subject
	 * @param type: The message type
	 * @param count: The current count
	 */
	public TaskProgressTickerEvent(String subject, String type, int count) {
		super(subject, type);
		this.count = count;
	}

	/**
	 * The count of items encountered
	 * @return the count at the time of the event
	 */
	public int getCount() {
		return count;
	}

}
