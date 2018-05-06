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
		assertTrue(player.getCurrentGameScore() == ScoreEnum._15);
		player.resetCurrentGameScore();
		assertTrue(player.getCurrentGameScore() == ScoreEnum._0);
	}

	/**
	 * Test win one point.
	 */
	public void testWinOnePoint() {
		Player player = new Player("test1");
		Player opponent = new Player("test2");
		try {
			assertFalse(player.winOnePoint(opponent));
			assertTrue(player.getCurrentGameScore() == ScoreEnum._15);
			assertFalse(player.winOnePoint(opponent));
			assertTrue(player.getCurrentGameScore() == ScoreEnum._30);
			assertFalse(player.winOnePoint(opponent));
			assertTrue(player.getCurrentGameScore() == ScoreEnum._40);
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
			assertTrue(player.getCurrentGameScore() == ScoreEnum._15);
			assertFalse(player.winOnePoint(opponent));
			assertTrue(player.getCurrentGameScore() == ScoreEnum._30);
			assertFalse(player.winOnePoint(opponent));
			assertTrue(player.getCurrentGameScore() == ScoreEnum._40);
			assertFalse(opponent.winOnePoint(player));
			assertTrue(opponent.getCurrentGameScore() == ScoreEnum._15);
			assertFalse(opponent.winOnePoint(player));
			assertTrue(opponent.getCurrentGameScore() == ScoreEnum._30);
			assertFalse(opponent.winOnePoint(player));
			assertTrue(opponent.getCurrentGameScore() == ScoreEnum._DEUCE);
			assertTrue(player.getCurrentGameScore() == ScoreEnum._DEUCE);
			assertFalse(opponent.winOnePoint(player));
			assertTrue(opponent.getCurrentGameScore() == ScoreEnum._AVG);
			assertTrue(player.getCurrentGameScore() == ScoreEnum._40);
			assertFalse(player.winOnePoint(opponent));
			assertTrue(opponent.getCurrentGameScore() == ScoreEnum._DEUCE);
			assertTrue(player.getCurrentGameScore() == ScoreEnum._DEUCE);
			assertFalse(player.winOnePoint(opponent));
			assertTrue(opponent.getCurrentGameScore() == ScoreEnum._40);
			assertTrue(player.getCurrentGameScore() == ScoreEnum._AVG);
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
			assertTrue(player.getCurrentGameScore() == ScoreEnum._15);
			assertFalse(player.winOnePoint(opponent));
			assertTrue(player.getCurrentGameScore() == ScoreEnum._30);
			assertFalse(player.winOnePoint(opponent));
			assertTrue(player.getCurrentGameScore() == ScoreEnum._40);
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
