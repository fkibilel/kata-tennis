package com.kata.tennis;

import com.kata.tennis.exception.KataException;
import com.kata.tennis.match.impl.Player;
import com.kata.tennis.match.impl.Set;

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
		Set set = new Set();
		try {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					assertFalse(set.playerWinPoint(player1, player2));
				}
				assertTrue(player1.getCurrentSetScore() == i + 1);
			}
			for (int j = 0; j < 3; j++) {
				assertFalse(set.playerWinPoint(player1, player2));
			}
			assertTrue(set.playerWinPoint(player1, player2));
			assertTrue(player1.getCurrentSetScore() == 6);
		} catch (KataException e) {
			fail(e.toString());
		}
	}

	/**
	 * Test player win point 2.
	 */
	public void testPlayerWinPoint2() {
		Player player1 = new Player("test1");
		Player player2 = new Player("test2");
		Set set = new Set();
		try {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					assertFalse(set.playerWinPoint(player1, player2));
				}
				assertTrue(player1.getCurrentSetScore() == i + 1);
			}
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 4; j++) {
					assertFalse(set.playerWinPoint(player2, player1));
				}
				assertTrue(player2.getCurrentSetScore() == i + 1);
			}
			for (int j = 0; j < 4; j++) {
				assertFalse(set.playerWinPoint(player1, player2));
			}
			assertTrue(player1.getCurrentSetScore() == 6);
			for (int j = 0; j < 6; j++) {
				assertFalse(set.playerWinPoint(player1, player2));
			}
			assertTrue(set.playerWinPoint(player1, player2));
			assertTrue(player1.getCurrentSetScore() == 7);
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
		Set set = new Set();
		try {
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 4; j++) {
					set.playerWinPoint(player1, player2);
				}
				assertTrue(player1.getCurrentSetScore() == i + 1);
			}
		} catch (KataException e) {
			fail(e.toString());
		}
		try {
			set.playerWinPoint(player1, player2);
		} catch (KataException e) {
			assertTrue(KataException.KATA_0002.equals(e.getCode()));
			return;
		}

		fail();
	}
}
