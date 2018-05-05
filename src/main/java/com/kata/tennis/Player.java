package com.kata.tennis;

/**
 * The Class Player.
 */
public class Player {

	/** The name. */
	private String name;

	/** The current set score. */
	private ScoreEnum currentSetScore = ScoreEnum._0;

	/**
	 * @param name
	 */
	public Player(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the currentSetScore
	 */
	public ScoreEnum getCurrentSetScore() {
		return currentSetScore;
	}

	/**
	 * Reset current set score.
	 */
	public void resetCurrentSetScore() {
		this.currentSetScore = ScoreEnum._0;
	}

	/**
	 * Win one point.
	 *
	 * @return true, if player wins the set
	 */
	public boolean winOnePoint() {
		switch (this.currentSetScore) {
		case _0:
			this.currentSetScore = ScoreEnum._15;
			break;
		case _15:
			this.currentSetScore = ScoreEnum._30;
			break;
		case _30:
			this.currentSetScore = ScoreEnum._40;
			break;
		case _40:
			return true;

		default:
			break;
		}
		return false;
	}
}
