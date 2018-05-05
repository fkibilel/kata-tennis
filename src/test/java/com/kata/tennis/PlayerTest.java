package com.kata.tennis;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * The Class PlayerTest.
 */
public class PlayerTest extends TestCase {

	/**
	 * Suite.
	 *
	 * @return the test
	 */
	public static Test suite() {
		return new TestSuite(PlayerTest.class);
	}

	/**
	 * Test reset current set score.
	 */
	public void testResetCurrentSetScore() {
		Player player = new Player("test");
		assertFalse(player.winOnePoint());
		assertTrue(player.getCurrentSetScore() == ScoreEnum._15);
		player.resetCurrentSetScore();
		assertTrue(player.getCurrentSetScore() == ScoreEnum._0);
	}

	/**
	 * Test win one point.
	 */
	public void testWinOnePoint() {
		Player player = new Player("test");
		assertFalse(player.winOnePoint());
		assertTrue(player.getCurrentSetScore() == ScoreEnum._15);
		assertFalse(player.winOnePoint());
		assertTrue(player.getCurrentSetScore() == ScoreEnum._30);
		assertFalse(player.winOnePoint());
		assertTrue(player.getCurrentSetScore() == ScoreEnum._40);
		assertTrue(player.winOnePoint());
	}
}
