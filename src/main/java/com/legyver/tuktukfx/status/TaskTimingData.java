package com.legyver.tuktukfx.status;

public class TaskTimingData {
	private final double domainSize;//used for determining progress
	private double actualSize = 0;//used to refine progress indicator on repeated runs

	public TaskTimingData(double sizeGuess) {
		this.domainSize = sizeGuess;
	}

	public double getDomainSize() {
		return domainSize;
	}

	public double getActualSize() {
		return actualSize;
	}

	public void count() {
		actualSize++;
	}
}
