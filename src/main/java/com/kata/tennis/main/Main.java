package com.kata.tennis.main;

import com.kata.tennis.exception.KataException;
import com.kata.tennis.impl.Player;
import com.kata.tennis.impl.Set;

/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		Player player1 = new Player("Nadal");
		Player player2 = new Player("Federer");
		Player player = null;
		Player opponent = null;
		Set set = new Set(player1, player2);

		System.out.println("############### STARTING THE GAME ###############");
		try {
			do {
				// Choose randomly the player that will get the point
				if (Math.random() < 0.5) {
					player = player1;
					opponent = player2;
				} else {
					player = player2;
					opponent = player1;
				}
				// Wait 2s before the next point
				Thread.sleep(2000);
			} while (!set.playerWinPoint(player, opponent));
		} catch (InterruptedException e) {
			System.out.println("%%%%%%%%%% UNKNOWN ERROR OCCURED");
		} catch (KataException e) {
			System.out.println("%%%%%%%%%% ERROR: " + e);
		}
		System.out.println("################### GAME OVER ###################");
	}

}
