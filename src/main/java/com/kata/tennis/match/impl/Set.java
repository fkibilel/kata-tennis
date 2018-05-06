package com.kata.tennis.match.impl;

import com.kata.tennis.exception.KataException;
import com.kata.tennis.match.IGame;

/**
 * The Class Set.
 */
public class Set {

	/** The current game. */
	private IGame currentGame;

	/** The is set over. */
	private boolean isSetOver = false;

	/**
	 * Instantiates a new sets the.
	 */
	public Set() {
		super();
		this.currentGame = new Game();
	}

	/**
	 * Inits the game.
	 *
	 * @param player1
	 *            the player 1
	 * @param player2
	 *            the player 2
	 */
	private void initGame(Player player1, Player player2) {
		this.currentGame = new Game();
		player1.resetCurrentGameScore();
		player2.resetCurrentGameScore();
	}

	/**
	 * Inits the tie break game.
	 *
	 * @param player1
	 *            the player 1
	 * @param player2
	 *            the player 2
	 */
	private void initTieBreakGame(Player player1, Player player2) {
		this.currentGame = new TieBreakGame();
		player1.resetTieBreakGameScore();
		player2.resetTieBreakGameScore();
	}

	/**
	 * Player win point.
	 *
	 * @param player
	 *            the player
	 * @param opponent
	 *            the opponent
	 * @return true, if the player wins the set
	 * @throws KataException
	 *             the kata exception
	 */
	public boolean playerWinPoint(Player player, Player opponent) throws KataException {
		// Throws exception if the set is already over
		if (this.isSetOver) {
			throw new KataException(KataException.KATA_0002, "The set is already over!");
		}

		// if the player wins the game, increment his set score and check if he
		// wins the set
		if (this.currentGame.playerWinPoint(player, opponent)) {
			player.winOneGame();
			// If a player reach the Set score of 6 and the other player has a
			// Set score of 4 or lower, the player win the Set
			// If a player wins a Game and reach the Set score of 6 and the
			// other player has a Set score of 5, a new Game must be played and
			// the first player who reach the score of 7 wins the match
			if ((player.getCurrentSetScore() > 6)
					|| (player.getCurrentSetScore() == 6 && opponent.getCurrentSetScore() < 5)) {
				System.out.printf("## !!!!!!!!! %-21s !!!!!!!!! ##\n", player.getName() + " WINS THE SET");
				this.isSetOver = true;
				return true;
			}

			// start a new game
			// If the 2 players reach the score of 6 Games , the Tie-Break rule
			// is activated
			if ((player.getCurrentSetScore() == 6) && (opponent.getCurrentSetScore() == 6)) {
				this.initTieBreakGame(player, opponent);
			} else {
				this.initGame(player, opponent);
			}
		}
		return false;
	}

}
