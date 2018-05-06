package com.kata.tennis.match.impl;

import com.kata.tennis.enumeration.ScoreEnum;
import com.kata.tennis.exception.KataException;
import com.kata.tennis.match.IGame;

/**
 * The Class Game.
 */
public class Game implements IGame {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kata.tennis.match.IGame#playerWinPoint(com.kata.tennis.match.impl.
	 * Player, com.kata.tennis.match.impl.Player)
	 */
	public boolean playerWinPoint(Player player, Player opponent) throws KataException {

		// Throws exception if one player has already won the game
		if (player.getCurrentGameScore() == ScoreEnum._WIN || opponent.getCurrentGameScore() == ScoreEnum._WIN) {
			throw new KataException(KataException.KATA_0001, "One player has already won the game!");
		}

		// Set score state machine
		switch (player.getCurrentGameScore()) {
		case _0:
			player.setCurrentGameScore(ScoreEnum._15);
			break;
		case _15:
			player.setCurrentGameScore(ScoreEnum._30);
			break;
		case _30:
			// If the 2 players reach the score 40, the DEUCE rule is activated
			if (opponent.getCurrentGameScore() == ScoreEnum._40) {
				player.setCurrentGameScore(ScoreEnum._DEUCE);
				opponent.setCurrentGameScore(ScoreEnum._DEUCE);
			} else {
				player.setCurrentGameScore(ScoreEnum._40);
			}
			break;
		case _40:
			// If the player who has the ADVANTAGE looses the point, the score
			// is DEUCE
			if (opponent.getCurrentGameScore() == ScoreEnum._AVG) {
				player.setCurrentGameScore(ScoreEnum._DEUCE);
				opponent.setCurrentGameScore(ScoreEnum._DEUCE);
				break;
			}
			player.setCurrentGameScore(ScoreEnum._WIN);
			System.out.printf("## !!!!!!!!! %-21s !!!!!!!!! ##\n", player.getName() + " WINS THE GAME");
			return true;
		case _DEUCE:
			// If the score is DEUCE , the player who win the point take the
			// ADVANTAGE
			player.setCurrentGameScore(ScoreEnum._AVG);
			opponent.setCurrentGameScore(ScoreEnum._40);
			break;
		case _AVG:
			// If the player who has the ADVANTAGE win the point, he win the
			// game
			player.setCurrentGameScore(ScoreEnum._WIN);
			System.out.printf("## !!!!!!!!! %-21s !!!!!!!!! ##\n", player.getName() + " WINS THE GAME");
			return true;

		default:
			break;
		}
		// The game is still in progress
		return false;
	}
}
