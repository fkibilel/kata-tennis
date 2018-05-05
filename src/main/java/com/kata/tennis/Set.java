package com.kata.tennis;

/**
 * The Class Set.
 */
public class Set {

	/** The player 1. */
	private Player player1;

	/** The player 2. */
	private Player player2;

	/**
	 * @param player1
	 * @param player2
	 */
	public Set(Player player1, Player player2) {
		super();
		this.player1 = player1;
		this.player2 = player2;
		this.player1.resetCurrentSetScore();
		this.player2.resetCurrentSetScore();
	}

	/**
	 * Player win point.
	 *
	 * @param player
	 *            the player
	 * @return true, if player wins the set
	 */
	public boolean playerWinPoint(Player player) {
		if (player.winOnePoint()) {
			System.out.printf("## !!!!!!!!! %-23s !!!!!!!!! ##\n", player.getName() + " WINS THE SET");
			return true;
		}
		this.displayScore();
		return false;
	}

	/**
	 * Display score.
	 */
	public void displayScore() {
		System.out.println("############### CURRENT SET SCORE ###############");
		System.out.printf("## %-43s ##\n",
				this.player1.getName() + " : " + this.player1.getCurrentSetScore().getValue());
		System.out.printf("## %-43s ##\n",
				this.player2.getName() + " : " + this.player2.getCurrentSetScore().getValue());
		System.out.println("#################################################");
	}
}
