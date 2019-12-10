package frogger.service;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * <h2> ScoreBaseFactoryTest </h2>
 * 
 * <p> The {@link ScoreBaseFactoryTest} test class is used to test the correctness of {@link ScoreBaseFactory} 
 * which generates the additional points to be added with the given gameLevel
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see ScoreBaseFactory
 *
 */
public class ScoreBaseFactoryTest {

	/**
	 * <p>This is the test function that check the correctness of {@link ScoreBaseFactory#createScoreBase(String)} 
	 * which generates the expected integer with the given gameLevel
	 * 
	 * <p>This test will be passed if each gameLevel's corresponding value is correct.
	 */
	@Test
	public void createScoreBaseTest() {
		assertEquals(50, ScoreBaseFactory.createScoreBase("NormalMode"));
		assertEquals(100, ScoreBaseFactory.createScoreBase("HardMode"));
		assertEquals(0, ScoreBaseFactory.createScoreBase("SimpleMode"));
	}

}
