package com.legyver.tuktukfx.adapter;

/**
 * Allow inside-out communication of processing messages and statuses
 */
public interface TaskStatusAdapter {

	/**
	 *
	 * @param message: The message to send to the outside task
	 */
	void updateMessage(String message);

	/**
	 *
	 * @param numerator: The count of items encountered
	 * @param denominator: The domain size
	 */
	void updateProgress(double numerator, double denominator);

	/**
	 *
	 * @param title: The title to display
	 */
	void updateTitle(String title);

}
