package com.kata.tennis;

/**
 * The Enum ScoreEnum.
 */
public enum ScoreEnum {

	/** The 0. */
	_0("0"),
	/** The 15. */
	_15("15"),
	/** The 30. */
	_30("30"),
	/** The 40. */
	_40("40");

	/** The value. */
	private String value;

	/**
	 * Instantiates a new score enum.
	 *
	 * @param value
	 *            the value
	 */
	ScoreEnum(String value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
}
