package com.kata.tennis.match;

import com.kata.tennis.exception.KataException;
import com.kata.tennis.match.impl.Player;

/**
 * The Interface IGame.
 */
public interface IGame {

	/**
	 * Player win point.
	 *
	 * @param player
	 *            the player
	 * @param opponent
	 *            the opponent
	 * @return true, if successful
	 * @throws KataException
	 *             the kata exception
	 */
	boolean playerWinPoint(Player player, Player opponent) throws KataException;
}
