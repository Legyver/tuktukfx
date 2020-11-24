package com.legyver.tuktukfx.event;

/**
 * Out-of-the-box task event types your TaskProcessors can emit and have your Observers consume.
 * These are string values for extensibility.  You can also register you observers to custom stings
 * as long as your emitted events have that same string as the event type.
 */
public interface TaskEventType {
	/**
	 * Out-of-the-box event type to track progress
	 */
	String CURSOR = "cursorEvent";
	/**
	 * Out-of-the-box event type to track an item was processed
	 */
	String PROCESSED = "processedEvent";
}
