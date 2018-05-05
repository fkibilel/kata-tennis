package com.kata.tennis;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * The Class SetTest.
 */
public class SetTest extends TestCase {

	/**
	 * Suite.
	 *
	 * @return the test
	 */
	public static Test suite() {
		return new TestSuite(SetTest.class);
	}

	/**
	 * Test player win point.
	 */
	public void testPlayerWinPoint() {
		Player player1 = new Player("test1");
		Player player2 = new Player("test2");
		Set set = new Set(player1, player2);
		assertFalse(set.playerWinPoint(player1));
		assertTrue(player1.getCurrentSetScore() == ScoreEnum._15);
		assertTrue(player2.getCurrentSetScore() == ScoreEnum._0);
		assertFalse(set.playerWinPoint(player2));
		assertTrue(player1.getCurrentSetScore() == ScoreEnum._15);
		assertTrue(player2.getCurrentSetScore() == ScoreEnum._15);
		assertFalse(set.playerWinPoint(player2));
		assertTrue(player1.getCurrentSetScore() == ScoreEnum._15);
		assertTrue(player2.getCurrentSetScore() == ScoreEnum._30);
		assertFalse(set.playerWinPoint(player2));
		assertTrue(player1.getCurrentSetScore() == ScoreEnum._15);
		assertTrue(player2.getCurrentSetScore() == ScoreEnum._40);
		assertFalse(set.playerWinPoint(player1));
		assertTrue(player1.getCurrentSetScore() == ScoreEnum._30);
		assertTrue(player2.getCurrentSetScore() == ScoreEnum._40);
		assertTrue(set.playerWinPoint(player2));
	}

	/**
	 * Test display score.
	 */
	public void testDisplayScore() {
		Player player1 = new Player("test1");
		Player player2 = new Player("test2");
		Set set = new Set(player1, player2);
		assertFalse(set.playerWinPoint(player1));
		assertTrue(player1.getCurrentSetScore() == ScoreEnum._15);
		assertTrue(player2.getCurrentSetScore() == ScoreEnum._0);
		set.displayScore();
		assertTrue(true);
	}
}
