package frogger.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class LifeTest {

	Life life = new Life(3);
	
	@Test
	public void lifeInitTest() {
		assertEquals(3, life.getRemainingLife());
		assertEquals(3, life.getTotalLife());
	}
	
	@Test
	public void lifeLoseTest() {
		for(int i = life.getTotalLife(); i > 0; i--) {
			life.loseLife();
			assertEquals(i-1, life.getRemainingLife());
		}
	}

}
