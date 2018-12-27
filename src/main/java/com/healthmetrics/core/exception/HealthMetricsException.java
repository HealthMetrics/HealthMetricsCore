package com.healthmetrics.core.exception;

/**
 * Custom Exception.
 * 
 * @author Gonzalo
 */
public class HealthMetricsException extends Exception {

	/** Thingy. */
	private static final long serialVersionUID = 1263959747174258326L;

	/**
	 * Creates a new Exception with a simple message.
	 * 
	 * @param message
	 */
	public HealthMetricsException(String message) {
		super(message);
	}

	/**
	 * Creates an Exception with a message and a throwable.
	 * 
	 * @param message
	 * @param t
	 */
	public HealthMetricsException(String message, Throwable t) {
		super(message, t);
	}

}
