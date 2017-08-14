package com.notation.back.exceptions;

public class ConfigurationFileNotFoundException extends AbstractException {

	/**
	 *
	 */
	private static final long serialVersionUID = 2211845942936527489L;

	/**
	 *
	 * @param errorCode
	 */
	public ConfigurationFileNotFoundException(final ErrorCode errorCode) {
		super(errorCode);
	}

	/**
	 * Instantiates a new configuration file not found exception.
	 *
	 * @param errorCode the error code
	 * @param message the message
	 */
	public ConfigurationFileNotFoundException(final ErrorCode errorCode,
			final String message) {
		super(errorCode, message);
	}


}
