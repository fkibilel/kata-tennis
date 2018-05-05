package com.kata.tennis.impl;

import com.kata.tennis.enumeration.ScoreEnum;
import com.kata.tennis.exception.KataException;

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
	 * @param opponent
	 *            the opponent
	 * @return true, if player wins the set
	 * @throws KataException
	 *             the kata exception
	 */
	public boolean winOnePoint(Player opponent) throws KataException {
		// Throws exception if one player has already won the set
		if (this.currentSetScore == ScoreEnum._WIN || opponent.currentSetScore == ScoreEnum._WIN) {
			throw new KataException(KataException.KATA_0001, "One player has already won the set!");
		}

		// Set score state machine
		switch (this.currentSetScore) {
		case _0:
			this.currentSetScore = ScoreEnum._15;
			break;
		case _15:
			this.currentSetScore = ScoreEnum._30;
			break;
		case _30:
			// If the 2 players reach the score 40, the DEUCE rule is activated
			if (opponent.getCurrentSetScore() == ScoreEnum._40) {
				this.currentSetScore = ScoreEnum._DEUCE;
				opponent.currentSetScore = ScoreEnum._DEUCE;
			} else {
				this.currentSetScore = ScoreEnum._40;
			}
			break;
		case _40:
			// If the player who has the ADVANTAGE looses the point, the score
			// is DEUCE
			if (opponent.getCurrentSetScore() == ScoreEnum._AVG) {
				this.currentSetScore = ScoreEnum._DEUCE;
				opponent.currentSetScore = ScoreEnum._DEUCE;
				break;
			}
			this.currentSetScore = ScoreEnum._WIN;
			return true;
		case _DEUCE:
			// If the score is DEUCE , the player who win the point take the
			// ADVANTAGE
			this.currentSetScore = ScoreEnum._AVG;
			opponent.currentSetScore = ScoreEnum._40;
			break;
		case _AVG:
			// If the player who has the ADVANTAGE win the point, he win the
			// game
			this.currentSetScore = ScoreEnum._WIN;
			return true;

		default:
			break;
		}
		// The set is still in progress
		return false;
	}
}
