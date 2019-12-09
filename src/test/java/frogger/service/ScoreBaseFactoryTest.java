package frogger.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreBaseFactoryTest {

	@Test
	public void createScoreBaseTest() {
		assertEquals(50, ScoreBaseFactory.createScoreBase("NormalMode"));
		assertEquals(100, ScoreBaseFactory.createScoreBase("HardMode"));
		assertEquals(0, ScoreBaseFactory.createScoreBase("SimpleMode"));
	}

}
