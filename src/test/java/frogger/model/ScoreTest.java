package frogger.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * <h2> ScoreTest </h2>
 * 
 * <p> The {@link ScoreTest} function is used to test the correctness of parts of the method in {@link Score} 
 * which are testable without launching application.
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see Score
 */
public class ScoreTest {
	
	/** A {@link Score} which is used to test the function of {@link Score#addScore(int)} */
	Score scoreAdd = new Score();
	/** A {@link Score} which is used to test the function of {@link Score#subScore(int)} */
	Score scoreSub = new Score(60);
	
	/**
	 * <p>This is the test method that tests the initial points of {@link Score}.
	 * <p>This test will pass if the points are correct.
	 */
	@Test
	public void scoreInitTest() {
		assertEquals(0, scoreAdd.getScore());
		assertEquals(60, scoreSub.getScore());
	}
	
	/**
	 * <p>This is the test method that tests the correctness of {@link Score#addScore(int)}.
	 * <p>This test will pass if the points are correct after adding.
	 */
	@Test
	public void scoreAddTest() {
		scoreAdd.addScore(30);
		assertEquals(30,scoreAdd.getScore());
	}
	
	/**
	 * <p>This is the test method that tests the correctness of {@link Score#subScore(int)}.
	 * <p>This test will pass if the points are correct after subtracting.
	 */
	@Test
	public void scoreSubTest() {
		scoreSub.subScore(20);
		assertEquals(40,scoreSub.getScore());
	}

}
