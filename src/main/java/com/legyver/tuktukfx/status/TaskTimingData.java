package com.legyver.tuktukfx.status;

/**
 * The domain-data used for progress indicators
 */
public class TaskTimingData {

	/**
	 * Domain size guess for progress indicators
	 */
	private final double domainSize;

	/**
	 * Used to refine progress indicator on repeated runs
	 */
	private double actualSize = 0;

	/**
	 * Instantiate the task context with timing data
	 * @param sizeGuess: best-guess for domain size used in progress indicators
	 */
	public TaskTimingData(double sizeGuess) {
		this.domainSize = sizeGuess;
	}

	/**
	 *
	 * @return; the size guess of the domain
	 */
	public double getDomainSize() {
		return domainSize;
	}

	/**
	 * Utility method for refining size guesses.
	 * @return  the actual size of the domain on the run.
	 */
	public double getActualSize() {
		return actualSize;
	}

	/**
	 * Item counter used to determine {@link #actualSize}
	 */
	public void count() {
		actualSize++;
	}
}
