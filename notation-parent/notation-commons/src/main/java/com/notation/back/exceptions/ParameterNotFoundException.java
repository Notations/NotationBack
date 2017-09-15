package com.notation.back.exceptions;


/**
 * The Class ParameterNotFoundException.
 */
public class ParameterNotFoundException extends AbstractException{

	/**
	 *
	 */
	private static final long serialVersionUID = 5483364957773321143L;

	/**
	 * Instantiates a new parameter not found exception.
	 *
	 * @param errorCode the error code
	 * @param message the message
	 */
	public ParameterNotFoundException(final ErrorCode errorCode, final String message) {
		super(errorCode, message);
	}


}
