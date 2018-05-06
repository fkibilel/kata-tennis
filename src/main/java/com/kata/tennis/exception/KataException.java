package com.kata.tennis.exception;

/**
 * The Class KataException.
 */
public class KataException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5305389853235177282L;

	/** The Constant KATA_0001. */
	public static final String KATA_0001 = "KATA-0001";

	/** The Constant KATA_0002. */
	public static final String KATA_0002 = "KATA-0002";

	/** The code. */
	private String code;

	/** The message. */
	private String message;

	/**
	 * Instantiates a new kata exception.
	 *
	 * @param code
	 *            the code
	 * @param message
	 *            the message
	 */
	public KataException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		return code + " : " + message;
	}
}
