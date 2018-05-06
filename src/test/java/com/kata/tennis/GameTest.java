package com.kata.tennis;

import com.kata.tennis.enumeration.ScoreEnum;
import com.kata.tennis.exception.KataException;
import com.kata.tennis.impl.Player;
import com.kata.tennis.impl.Game;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * The Class GameTest.
 */
public class GameTest extends TestCase {

	/**
	 * Suite.
	 *
	 * @return the test
	 */
	public static Test suite() {
		return new TestSuite(GameTest.class);
	}

	/**
	 * Test player win point.
	 */
	public void testPlayerWinPoint() {
		Player player1 = new Player("test1");
		Player player2 = new Player("test2");
		Game game = new Game();
		try {
			assertFalse(game.playerWinPoint(player1, player2));
			assertTrue(player1.getCurrentGameScore() == ScoreEnum._15);
			assertTrue(player2.getCurrentGameScore() == ScoreEnum._0);
			assertFalse(game.playerWinPoint(player2, player1));
			assertTrue(player1.getCurrentGameScore() == ScoreEnum._15);
			assertTrue(player2.getCurrentGameScore() == ScoreEnum._15);
			assertFalse(game.playerWinPoint(player2, player1));
			assertTrue(player1.getCurrentGameScore() == ScoreEnum._15);
			assertTrue(player2.getCurrentGameScore() == ScoreEnum._30);
			assertFalse(game.playerWinPoint(player2, player1));
			assertTrue(player1.getCurrentGameScore() == ScoreEnum._15);
			assertTrue(player2.getCurrentGameScore() == ScoreEnum._40);
			assertFalse(game.playerWinPoint(player1, player2));
			assertTrue(player1.getCurrentGameScore() == ScoreEnum._30);
			assertTrue(player2.getCurrentGameScore() == ScoreEnum._40);
			assertTrue(game.playerWinPoint(player2, player1));
		} catch (KataException e) {
			fail(e.toString());
		}
	}

	/**
	 * Test player win point deuce.
	 */
	public void testPlayerWinPointDeuce() {
		Player player1 = new Player("test1");
		Player player2 = new Player("test2");
		Game game = new Game();
		try {
			assertFalse(game.playerWinPoint(player1, player2));
			assertTrue(player1.getCurrentGameScore() == ScoreEnum._15);
			assertTrue(player2.getCurrentGameScore() == ScoreEnum._0);
			assertFalse(game.playerWinPoint(player2, player1));
			assertTrue(player1.getCurrentGameScore() == ScoreEnum._15);
			assertTrue(player2.getCurrentGameScore() == ScoreEnum._15);
			assertFalse(game.playerWinPoint(player2, player1));
			assertTrue(player1.getCurrentGameScore() == ScoreEnum._15);
			assertTrue(player2.getCurrentGameScore() == ScoreEnum._30);
			assertFalse(game.playerWinPoint(player2, player1));
			assertTrue(player1.getCurrentGameScore() == ScoreEnum._15);
			assertTrue(player2.getCurrentGameScore() == ScoreEnum._40);
			assertFalse(game.playerWinPoint(player1, player2));
			assertTrue(player1.getCurrentGameScore() == ScoreEnum._30);
			assertTrue(player2.getCurrentGameScore() == ScoreEnum._40);
			assertFalse(game.playerWinPoint(player1, player2));
			assertTrue(player1.getCurrentGameScore() == ScoreEnum._DEUCE);
			assertTrue(player2.getCurrentGameScore() == ScoreEnum._DEUCE);
			assertFalse(game.playerWinPoint(player2, player1));
			assertTrue(player1.getCurrentGameScore() == ScoreEnum._40);
			assertTrue(player2.getCurrentGameScore() == ScoreEnum._AVG);
			assertFalse(game.playerWinPoint(player1, player2));
			assertTrue(player1.getCurrentGameScore() == ScoreEnum._DEUCE);
			assertTrue(player2.getCurrentGameScore() == ScoreEnum._DEUCE);
			assertFalse(game.playerWinPoint(player1, player2));
			assertTrue(player1.getCurrentGameScore() == ScoreEnum._AVG);
			assertTrue(player2.getCurrentGameScore() == ScoreEnum._40);
			assertTrue(game.playerWinPoint(player1, player2));
		} catch (KataException e) {
			fail(e.toString());
		}
	}

	/**
	 * Test player win point error.
	 */
	public void testPlayerWinPointError() {
		Player player1 = new Player("test1");
		Player player2 = new Player("test2");
		Game game = new Game();
		try {
			assertFalse(game.playerWinPoint(player1, player2));
			assertTrue(player1.getCurrentGameScore() == ScoreEnum._15);
			assertTrue(player2.getCurrentGameScore() == ScoreEnum._0);
			assertFalse(game.playerWinPoint(player2, player1));
			assertTrue(player1.getCurrentGameScore() == ScoreEnum._15);
			assertTrue(player2.getCurrentGameScore() == ScoreEnum._15);
			assertFalse(game.playerWinPoint(player2, player1));
			assertTrue(player1.getCurrentGameScore() == ScoreEnum._15);
			assertTrue(player2.getCurrentGameScore() == ScoreEnum._30);
			assertFalse(game.playerWinPoint(player2, player1));
			assertTrue(player1.getCurrentGameScore() == ScoreEnum._15);
			assertTrue(player2.getCurrentGameScore() == ScoreEnum._40);
			assertFalse(game.playerWinPoint(player1, player2));
			assertTrue(player1.getCurrentGameScore() == ScoreEnum._30);
			assertTrue(player2.getCurrentGameScore() == ScoreEnum._40);
			assertTrue(game.playerWinPoint(player2, player1));
		} catch (KataException e) {
			fail(e.toString());
		}

		try {
			game.playerWinPoint(player2, player1);
		} catch (KataException e) {
			assertTrue(KataException.KATA_0001.equals(e.getCode()));
			return;
		}

		fail();
	}
}
