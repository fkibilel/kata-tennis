package com.kata.tennis.match.impl;

import com.kata.tennis.exception.KataException;
import com.kata.tennis.match.IGame;

/**
 * The Class TieBreakGame.
 */
public class TieBreakGame implements IGame {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kata.tennis.match.IGame#playerWinPoint(com.kata.tennis.match.impl.
	 * Player, com.kata.tennis.match.impl.Player)
	 */
	public boolean playerWinPoint(Player player, Player opponent) throws KataException {

		// Throws exception if one player has already won the game
		if ((player.getTieBreakScore() >= 7 || opponent.getTieBreakScore() >= 7)
				&& (Math.abs(player.getTieBreakScore() - opponent.getTieBreakScore()) >= 2)) {
			throw new KataException(KataException.KATA_0001, "One player has already won the game!");
		}

		player.winTieBreakPoint();
		if ((player.getTieBreakScore() >= 7) && (player.getTieBreakScore() - opponent.getTieBreakScore() >= 2)) {
			System.out.printf("## !!!!!!!!! %-21s !!!!!!!!! ##\n", player.getName() + " WINS THE GAME");
			return true;
		}
		return false;
	}

}
