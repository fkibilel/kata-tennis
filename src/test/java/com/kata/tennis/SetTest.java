package com.kata.tennis;

import com.kata.tennis.enumeration.ScoreEnum;
import com.kata.tennis.exception.KataException;
import com.kata.tennis.impl.Player;
import com.kata.tennis.impl.Set;

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
		try {
			assertFalse(set.playerWinPoint(player1, player2));
			assertTrue(player1.getCurrentSetScore() == ScoreEnum._15);
			assertTrue(player2.getCurrentSetScore() == ScoreEnum._0);
			assertFalse(set.playerWinPoint(player2, player1));
			assertTrue(player1.getCurrentSetScore() == ScoreEnum._15);
			assertTrue(player2.getCurrentSetScore() == ScoreEnum._15);
			assertFalse(set.playerWinPoint(player2, player1));
			assertTrue(player1.getCurrentSetScore() == ScoreEnum._15);
			assertTrue(player2.getCurrentSetScore() == ScoreEnum._30);
			assertFalse(set.playerWinPoint(player2, player1));
			assertTrue(player1.getCurrentSetScore() == ScoreEnum._15);
			assertTrue(player2.getCurrentSetScore() == ScoreEnum._40);
			assertFalse(set.playerWinPoint(player1, player2));
			assertTrue(player1.getCurrentSetScore() == ScoreEnum._30);
			assertTrue(player2.getCurrentSetScore() == ScoreEnum._40);
			assertTrue(set.playerWinPoint(player2, player1));
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
		Set set = new Set(player1, player2);
		try {
			assertFalse(set.playerWinPoint(player1, player2));
			assertTrue(player1.getCurrentSetScore() == ScoreEnum._15);
			assertTrue(player2.getCurrentSetScore() == ScoreEnum._0);
			assertFalse(set.playerWinPoint(player2, player1));
			assertTrue(player1.getCurrentSetScore() == ScoreEnum._15);
			assertTrue(player2.getCurrentSetScore() == ScoreEnum._15);
			assertFalse(set.playerWinPoint(player2, player1));
			assertTrue(player1.getCurrentSetScore() == ScoreEnum._15);
			assertTrue(player2.getCurrentSetScore() == ScoreEnum._30);
			assertFalse(set.playerWinPoint(player2, player1));
			assertTrue(player1.getCurrentSetScore() == ScoreEnum._15);
			assertTrue(player2.getCurrentSetScore() == ScoreEnum._40);
			assertFalse(set.playerWinPoint(player1, player2));
			assertTrue(player1.getCurrentSetScore() == ScoreEnum._30);
			assertTrue(player2.getCurrentSetScore() == ScoreEnum._40);
			assertFalse(set.playerWinPoint(player1, player2));
			assertTrue(player1.getCurrentSetScore() == ScoreEnum._DEUCE);
			assertTrue(player2.getCurrentSetScore() == ScoreEnum._DEUCE);
			assertFalse(set.playerWinPoint(player2, player1));
			assertTrue(player1.getCurrentSetScore() == ScoreEnum._40);
			assertTrue(player2.getCurrentSetScore() == ScoreEnum._AVG);
			assertFalse(set.playerWinPoint(player1, player2));
			assertTrue(player1.getCurrentSetScore() == ScoreEnum._DEUCE);
			assertTrue(player2.getCurrentSetScore() == ScoreEnum._DEUCE);
			assertFalse(set.playerWinPoint(player1, player2));
			assertTrue(player1.getCurrentSetScore() == ScoreEnum._AVG);
			assertTrue(player2.getCurrentSetScore() == ScoreEnum._40);
			assertTrue(set.playerWinPoint(player1, player2));
		} catch (KataException e) {
			fail(e.toString());
		}
	}

	/**
	 * Test display score.
	 */
	public void testDisplayScore() {
		Player player1 = new Player("test1");
		Player player2 = new Player("test2");
		Set set = new Set(player1, player2);
		try {
			assertFalse(set.playerWinPoint(player1, player2));
		} catch (KataException e) {
			fail(e.toString());
		}
		assertTrue(player1.getCurrentSetScore() == ScoreEnum._15);
		assertTrue(player2.getCurrentSetScore() == ScoreEnum._0);
		set.displayScore();
		assertTrue(true);
	}

	/**
	 * Test player win point error.
	 */
	public void testPlayerWinPointError() {
		Player player1 = new Player("test1");
		Player player2 = new Player("test2");
		Set set = new Set(player1, player2);
		try {
			assertFalse(set.playerWinPoint(player1, player2));
			assertTrue(player1.getCurrentSetScore() == ScoreEnum._15);
			assertTrue(player2.getCurrentSetScore() == ScoreEnum._0);
			assertFalse(set.playerWinPoint(player2, player1));
			assertTrue(player1.getCurrentSetScore() == ScoreEnum._15);
			assertTrue(player2.getCurrentSetScore() == ScoreEnum._15);
			assertFalse(set.playerWinPoint(player2, player1));
			assertTrue(player1.getCurrentSetScore() == ScoreEnum._15);
			assertTrue(player2.getCurrentSetScore() == ScoreEnum._30);
			assertFalse(set.playerWinPoint(player2, player1));
			assertTrue(player1.getCurrentSetScore() == ScoreEnum._15);
			assertTrue(player2.getCurrentSetScore() == ScoreEnum._40);
			assertFalse(set.playerWinPoint(player1, player2));
			assertTrue(player1.getCurrentSetScore() == ScoreEnum._30);
			assertTrue(player2.getCurrentSetScore() == ScoreEnum._40);
			assertTrue(set.playerWinPoint(player2, player1));
		} catch (KataException e) {
			fail(e.toString());
		}

		try {
			set.playerWinPoint(player2, player1);
		} catch (KataException e) {
			assertTrue(KataException.KATA_0001.equals(e.getCode()));
			return;
		}

		fail();
	}
}
