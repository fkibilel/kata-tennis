package com.kata.tennis;

import com.kata.tennis.enumeration.ScoreEnum;
import com.kata.tennis.exception.KataException;
import com.kata.tennis.impl.Player;

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
		Player player = new Player("test1");
		Player opponent = new Player("test2");
		try {
			assertFalse(player.winOnePoint(opponent));
		} catch (KataException e) {
			fail(e.toString());
		}
		assertTrue(player.getCurrentSetScore() == ScoreEnum._15);
		player.resetCurrentSetScore();
		assertTrue(player.getCurrentSetScore() == ScoreEnum._0);
	}

	/**
	 * Test win one point.
	 */
	public void testWinOnePoint() {
		Player player = new Player("test1");
		Player opponent = new Player("test2");
		try {
			assertFalse(player.winOnePoint(opponent));
			assertTrue(player.getCurrentSetScore() == ScoreEnum._15);
			assertFalse(player.winOnePoint(opponent));
			assertTrue(player.getCurrentSetScore() == ScoreEnum._30);
			assertFalse(player.winOnePoint(opponent));
			assertTrue(player.getCurrentSetScore() == ScoreEnum._40);
			assertTrue(player.winOnePoint(opponent));
		} catch (KataException e) {
			fail(e.toString());
		}
	}

	/**
	 * Test win one point deuce.
	 */
	public void testWinOnePointDeuce() {
		Player player = new Player("test1");
		Player opponent = new Player("test2");
		try {
			assertFalse(player.winOnePoint(opponent));
			assertTrue(player.getCurrentSetScore() == ScoreEnum._15);
			assertFalse(player.winOnePoint(opponent));
			assertTrue(player.getCurrentSetScore() == ScoreEnum._30);
			assertFalse(player.winOnePoint(opponent));
			assertTrue(player.getCurrentSetScore() == ScoreEnum._40);
			assertFalse(opponent.winOnePoint(player));
			assertTrue(opponent.getCurrentSetScore() == ScoreEnum._15);
			assertFalse(opponent.winOnePoint(player));
			assertTrue(opponent.getCurrentSetScore() == ScoreEnum._30);
			assertFalse(opponent.winOnePoint(player));
			assertTrue(opponent.getCurrentSetScore() == ScoreEnum._DEUCE);
			assertTrue(player.getCurrentSetScore() == ScoreEnum._DEUCE);
			assertFalse(opponent.winOnePoint(player));
			assertTrue(opponent.getCurrentSetScore() == ScoreEnum._AVG);
			assertTrue(player.getCurrentSetScore() == ScoreEnum._40);
			assertFalse(player.winOnePoint(opponent));
			assertTrue(opponent.getCurrentSetScore() == ScoreEnum._DEUCE);
			assertTrue(player.getCurrentSetScore() == ScoreEnum._DEUCE);
			assertFalse(player.winOnePoint(opponent));
			assertTrue(opponent.getCurrentSetScore() == ScoreEnum._40);
			assertTrue(player.getCurrentSetScore() == ScoreEnum._AVG);
			assertTrue(player.winOnePoint(opponent));
		} catch (KataException e) {
			fail(e.toString());
		}
	}

	/**
	 * Test win one point error.
	 */
	public void testWinOnePointError() {
		Player player = new Player("test1");
		Player opponent = new Player("test2");
		try {
			assertFalse(player.winOnePoint(opponent));
			assertTrue(player.getCurrentSetScore() == ScoreEnum._15);
			assertFalse(player.winOnePoint(opponent));
			assertTrue(player.getCurrentSetScore() == ScoreEnum._30);
			assertFalse(player.winOnePoint(opponent));
			assertTrue(player.getCurrentSetScore() == ScoreEnum._40);
			assertTrue(player.winOnePoint(opponent));
		} catch (KataException e) {
			fail(e.toString());
		}

		try {
			player.winOnePoint(opponent);
		} catch (KataException e) {
			assertTrue(KataException.KATA_0001.equals(e.getCode()));
			return;
		}

		fail();
	}
}
