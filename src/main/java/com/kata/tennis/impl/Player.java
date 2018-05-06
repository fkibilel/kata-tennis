package com.kata.tennis.impl;

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
	 * Reset current game score.
	 */
	public void resetCurrentGameScore() {
		this.currentGameScore = ScoreEnum._0;
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
	 * Win one point.
	 *
	 * @param opponent
	 *            the opponent
	 * @return true, if player wins the game
	 * @throws KataException
	 *             the kata exception
	 */
	public boolean winOnePoint(Player opponent) throws KataException {
		// Throws exception if one player has already won the game
		if (this.currentGameScore == ScoreEnum._WIN || opponent.currentGameScore == ScoreEnum._WIN) {
			throw new KataException(KataException.KATA_0001, "One player has already won the game!");
		}

		// Set score state machine
		switch (this.currentGameScore) {
		case _0:
			this.currentGameScore = ScoreEnum._15;
			break;
		case _15:
			this.currentGameScore = ScoreEnum._30;
			break;
		case _30:
			// If the 2 players reach the score 40, the DEUCE rule is activated
			if (opponent.getCurrentGameScore() == ScoreEnum._40) {
				this.currentGameScore = ScoreEnum._DEUCE;
				opponent.currentGameScore = ScoreEnum._DEUCE;
			} else {
				this.currentGameScore = ScoreEnum._40;
			}
			break;
		case _40:
			// If the player who has the ADVANTAGE looses the point, the score
			// is DEUCE
			if (opponent.getCurrentGameScore() == ScoreEnum._AVG) {
				this.currentGameScore = ScoreEnum._DEUCE;
				opponent.currentGameScore = ScoreEnum._DEUCE;
				break;
			}
			this.currentGameScore = ScoreEnum._WIN;
			return true;
		case _DEUCE:
			// If the score is DEUCE , the player who win the point take the
			// ADVANTAGE
			this.currentGameScore = ScoreEnum._AVG;
			opponent.currentGameScore = ScoreEnum._40;
			break;
		case _AVG:
			// If the player who has the ADVANTAGE win the point, he win the
			// game
			this.currentGameScore = ScoreEnum._WIN;
			return true;

		default:
			break;
		}
		// The game is still in progress
		return false;
	}
}
