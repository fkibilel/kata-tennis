package com.kata.tennis;

import com.kata.tennis.enumeration.ScoreEnum;
import com.kata.tennis.exception.KataException;
import com.kata.tennis.match.impl.Player;

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
		player.setCurrentGameScore(ScoreEnum._15);
		assertTrue(player.getCurrentGameScore() == ScoreEnum._15);
		player.resetCurrentGameScore();
		assertTrue(player.getCurrentGameScore() == ScoreEnum._0);
	}

	/**
	 * Test get game score.
	 */
	public void testGetGameScore() {
		Player player = new Player("test1");
		player.setCurrentGameScore(ScoreEnum._15);
		assertTrue("15".equals(player.getGameScore()));
	}

	/**
	 * Test get tie break game score.
	 */
	public void testGetTieBreakGameScore() {
		Player player = new Player("test1");
		player.resetTieBreakGameScore();
		try {
			player.winTieBreakPoint();
		} catch (KataException e) {
			fail(e.toString());
		}
		assertTrue("1".equals(player.getGameScore()));
	}

	/**
	 * Test win tie break point error.
	 */
	public void testWinTieBreakPointError() {
		Player player = new Player("test1");
		try {
			player.winTieBreakPoint();
		} catch (KataException e) {
			assertTrue(KataException.KATA_0003.equals(e.getCode()));
			return;
		}

		fail();

	}

}
