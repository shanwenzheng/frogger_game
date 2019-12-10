package frogger.constant;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * <h2> GameLevelTest </h2>
 * 
 * <p> The {@link GameLevelTest} function is used to test whether the constant in {@link GameLevel} can be read successfully.
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see GameLevel
 */
public class GameLevelTest {

	/**
	 * <p>This is the test method that tests whether the constants in {@link GameLevel} can be read successfully.
	 * <p>This test will pass if the number of constant store in {@link GameLevel} is correct 
	 * and each string is also correct.
	 */
	@Test
	public void readGameLevelTest() {
		assertTrue(GameLevel.gameLevelList.size() == 3);
		assertEquals(GameLevel.gameLevelList.get(0), "NormalMode");
		assertEquals(GameLevel.gameLevelList.get(1), "SimpleMode");
		assertEquals(GameLevel.gameLevelList.get(2), "HardMode");
	}

}
