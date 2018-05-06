package com.kata.tennis.match.impl;

import com.kata.tennis.enumeration.ScoreEnum;
import com.kata.tennis.exception.KataException;

/**
 * The Class Player.
 */
public class Player {

	/** The name. */
	private String name;

	/** The current game score. */
	private ScoreEnum currentGameScore = ScoreEnum._0;

	/** The current set score. */
	private int currentSetScore = 0;

	/** The tie break score. */
	private int tieBreakScore = -1;

	/**
	 * Instantiates a new player.
	 *
	 * @param name
	 *            the name
	 */
	public Player(String name) {
		super();
		this.name = name;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the current game score.
	 *
	 * @return the currentGameScore
	 */
	public ScoreEnum getCurrentGameScore() {
		return currentGameScore;
	}

	/**
	 * Sets the current game score.
	 *
	 * @param currentGameScore
	 *            the currentGameScore to set
	 */
	public void setCurrentGameScore(ScoreEnum currentGameScore) {
		this.currentGameScore = currentGameScore;
	}

	/**
	 * Gets the game score.
	 *
	 * @return the game score
	 */
	public String getGameScore() {
		if (this.tieBreakScore != -1) {
			return String.valueOf(this.tieBreakScore);
		}
		return currentGameScore.getValue();
	}

	/**
	 * Reset current game score.
	 */
	public void resetCurrentGameScore() {
		this.currentGameScore = ScoreEnum._0;
	}

	/**
	 * Reset tie break game score.
	 */
	public void resetTieBreakGameScore() {
		this.tieBreakScore = 0;
	}

	/**
	 * Gets the current set score.
	 *
	 * @return the currentSetScore
	 */
	public int getCurrentSetScore() {
		return currentSetScore;
	}

	/**
	 * Win one game.
	 */
	public void winOneGame() {
		this.currentSetScore++;
	}

	/**
	 * Gets the tie break score.
	 *
	 * @return the tieBreakScore
	 */
	public int getTieBreakScore() {
		return tieBreakScore;
	}

	/**
	 * Win tie break point.
	 *
	 * @throws KataException
	 *             the kata exception
	 */
	public void winTieBreakPoint() throws KataException {
		// Throw exception if the tie break game is not started
		if (this.tieBreakScore == -1) {
			throw new KataException(KataException.KATA_0003,
					"Trying to increase the tie-break score and the tie-break game is not yet started!");
		}
		this.tieBreakScore++;
	}
}
