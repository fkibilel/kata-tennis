package com.kata.tennis;

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
		Set set = new Set(player1, player2);

		System.out.println("############### STARTING THE GAME ###############");
		do {
			if (Math.random() < 0.5) {
				player = player1;
			} else {
				player = player2;
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (!set.playerWinPoint(player));
		System.out.println("################### GAME OVER ###################");
	}

}
