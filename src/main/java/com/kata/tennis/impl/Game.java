package com.kata.tennis.impl;

import com.kata.tennis.exception.KataException;

/**
 * The Class Game.
 */
public class Game {

	/**
	 * Player win point.
	 *
	 * @param player
	 *            the player
	 * @param opponent
	 *            the opponent
	 * @return true, if player wins the game
	 * @throws KataException
	 *             the kata exception
	 */
	public boolean playerWinPoint(Player player, Player opponent) throws KataException {
		// return true, if the player wins the game
		if (player.winOnePoint(opponent)) {
			System.out.printf("## !!!!!!!!! %-21s !!!!!!!!! ##\n", player.getName() + " WINS THE GAME");
			return true;
		}
		return false;
	}
}
