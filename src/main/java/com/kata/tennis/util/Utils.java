package com.kata.tennis.util;

import com.kata.tennis.match.impl.Player;

/**
 * The Class Utils.
 */
public class Utils {

	/**
	 * Display score.
	 *
	 * @param player1
	 *            the player 1
	 * @param player2
	 *            the player 2
	 */
	public static void displayScore(Player player1, Player player2) {
		System.out.println("######### PLAYER ########  SET  ##  GAME  #####");
		System.out.printf("## %-19s ## %-4s  ## %-7s ####\n", player1.getName(), player1.getCurrentSetScore(),
				player1.getGameScore());
		System.out.printf("## %-19s ## %-4s  ## %-7s ####\n", player2.getName(), player2.getCurrentSetScore(),
				player2.getGameScore());
		System.out.println("###############################################");
	}

	/**
	 * Display final score.
	 *
	 * @param player1
	 *            the player 1
	 * @param player2
	 *            the player 2
	 */
	public static void displayFinalScore(Player player1, Player player2) {
		System.out.println("######### PLAYER ########      SET      #######");
		System.out.printf("## %-19s ##       %-4s    #######\n", player1.getName(), player1.getCurrentSetScore());
		System.out.printf("## %-19s ##       %-4s    #######\n", player2.getName(), player2.getCurrentSetScore());
		System.out.println("###############################################");
	}
}
