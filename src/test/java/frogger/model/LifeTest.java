package frogger.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * <h2> LifeTest </h2>
 * 
 * <p> The {@link LifeTest} function is used to test the correctness of parts of the method in {@link Life} 
 * which are testable without launching application.
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see Life
 */
public class LifeTest {

	/** A {@link Life} which is used to accomplish test */
	Life life = new Life(3);
	
	/**
	 * <p>This is the test method that tests the initial life counts of {@link #life}.
	 * <p>This test will pass if the remaining and total life counts are correct.
	 */
	@Test
	public void lifeInitTest() {
		assertEquals(3, life.getRemainingLife());
		assertEquals(3, life.getTotalLife());
	}
	
	/**
	 * <p>This is the test method that tests the correctness of {@link Life#loseLife()}
	 * <p>This test will pass if the remaining life counts are correct after calling {@link Life#loseLife()} until the remaining Life is zero
	 */
	@Test
	public void lifeLoseTest() {
		for(int i = life.getTotalLife(); i > 0; i--) {
			life.loseLife();
			assertEquals(i-1, life.getRemainingLife());
		}
	}

}
