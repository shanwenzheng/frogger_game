package frogger.constant;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameLevelTest {

	@Test
	public void readGameLevelTest() {
		assertTrue(GameLevel.gameLevelList.size() == 3);
		assertEquals(GameLevel.gameLevelList.get(0), "NormalMode");
		assertEquals(GameLevel.gameLevelList.get(1), "SimpleMode");
		assertEquals(GameLevel.gameLevelList.get(2), "HardMode");
	}

}
