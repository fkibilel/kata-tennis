package com.kata.tennis;

import com.kata.tennis.exception.KataException;
import com.kata.tennis.match.impl.Player;
import com.kata.tennis.match.impl.TieBreakGame;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * The Class TieBreakGameTest.
 */
public class TieBreakGameTest extends TestCase {

	/**
	 * Suite.
	 *
	 * @return the test
	 */
	public static Test suite() {
		return new TestSuite(TieBreakGameTest.class);
	}

	/**
	 * Test player win point.
	 */
	public void testPlayerWinPoint() {
		Player player1 = new Player("test1");
		Player player2 = new Player("test2");
		TieBreakGame game = new TieBreakGame();
		player1.resetTieBreakGameScore();
		player2.resetTieBreakGameScore();
		try {
			for (int i = 0; i < 6; i++) {
				assertFalse(game.playerWinPoint(player1, player2));
				assertTrue(player1.getTieBreakScore() == i + 1);
				assertTrue(player2.getTieBreakScore() == 0);
			}
			for (int i = 0; i < 5; i++) {
				assertFalse(game.playerWinPoint(player2, player1));
				assertTrue(player1.getTieBreakScore() == 6);
				assertTrue(player2.getTieBreakScore() == i + 1);
			}
			assertTrue(game.playerWinPoint(player1, player2));
			assertTrue(player1.getTieBreakScore() == 7);
			assertTrue(player2.getTieBreakScore() == 5);
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
		TieBreakGame game = new TieBreakGame();
		player1.resetTieBreakGameScore();
		player2.resetTieBreakGameScore();
		try {
			for (int i = 0; i < 9; i++) {
				assertFalse(game.playerWinPoint(player1, player2));
				assertTrue(player1.getTieBreakScore() == i + 1);
				assertTrue(player2.getTieBreakScore() == i);
				assertFalse(game.playerWinPoint(player2, player1));
				assertTrue(player1.getTieBreakScore() == i + 1);
				assertTrue(player2.getTieBreakScore() == i + 1);
			}
			assertFalse(game.playerWinPoint(player1, player2));
			assertTrue(player1.getTieBreakScore() == 10);
			assertTrue(player2.getTieBreakScore() == 9);
			assertTrue(game.playerWinPoint(player1, player2));
			assertTrue(player1.getTieBreakScore() == 11);
			assertTrue(player2.getTieBreakScore() == 9);
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
		TieBreakGame game = new TieBreakGame();
		player1.resetTieBreakGameScore();
		player2.resetTieBreakGameScore();
		try {
			for (int i = 0; i < 6; i++) {
				assertFalse(game.playerWinPoint(player1, player2));
				assertTrue(player1.getTieBreakScore() == i + 1);
				assertTrue(player2.getTieBreakScore() == 0);
			}
			assertTrue(game.playerWinPoint(player1, player2));
			assertTrue(player1.getTieBreakScore() == 7);
			assertTrue(player2.getTieBreakScore() == 0);
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
