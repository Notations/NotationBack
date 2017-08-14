package com.notation.back.exceptions;

import javax.validation.constraints.NotNull;

/**
 * The Class AbstractException. Abstract class, parent of all Exceptions.
 */
public abstract class AbstractException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8950900923568838426L;


	/**
	 *
	 */
	@NotNull
	protected final ErrorCode errorCode;

	/**
	 * Instantiates a new abstract exception.
	 * @param errorCode the error code
	 */
	public AbstractException(final ErrorCode errorCode) {
		this(errorCode, null, null);
	}

	/**
	 * Instantiates a new abstract exception.
	 * @param errorCode the error code
	 * @param message the message
	 */
	public AbstractException(final ErrorCode errorCode, final String message) {
		this(errorCode, message, null);
	}

	/**
	 * Instantiates a new abstract exception.
	 * @param errorCode the error code
	 * @param cause the cause
	 */
	public AbstractException(final ErrorCode errorCode, final Throwable cause) {
		this(errorCode, null, cause);
	}

	/**
	 * Instantiates a new abstract exception.
	 * @param errorCode the error code
	 * @param message the message
	 * @param cause the cause
	 */
	public AbstractException(final ErrorCode errorCode, final String message, final Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	/**
	 * Gets the error code.
	 * @return the errorCode
	 */
	public ErrorCode getErrorCode() {
		return this.errorCode;
	}

}
