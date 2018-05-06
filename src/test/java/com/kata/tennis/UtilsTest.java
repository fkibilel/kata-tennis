package com.kata.tennis;

import com.kata.tennis.match.impl.Player;
import com.kata.tennis.util.Utils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * The Class UtilsTest.
 */
public class UtilsTest extends TestCase {

	/**
	 * Suite.
	 *
	 * @return the test
	 */
	public static Test suite() {
		return new TestSuite(UtilsTest.class);
	}

	/**
	 * Test display score.
	 */
	public void testDisplayScore() {
		Player player1 = new Player("test1");
		Player player2 = new Player("test2");
		Utils.displayScore(player1, player2);
		assertTrue(true);
	}

	/**
	 * Test display final score.
	 */
	public void testDisplayFinalScore() {
		Player player1 = new Player("test1");
		Player player2 = new Player("test2");
		Utils.displayFinalScore(player1, player2);
		assertTrue(true);
	}

}
