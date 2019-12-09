package frogger.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreTest {

	Score scoreAdd = new Score();
	Score scoreSub = new Score(60);
	
	@Test
	public void scoreInitTest() {
		assertEquals(0, scoreAdd.getScore());
		assertEquals(60, scoreSub.getScore());
	}
	
	@Test
	public void scoreAddTest() {
		scoreAdd.addScore(30);
		assertEquals(30,scoreAdd.getScore());
	}
	
	@Test
	public void scoreSubTest() {
		scoreSub.subScore(20);
		assertEquals(40,scoreSub.getScore());
	}

}
