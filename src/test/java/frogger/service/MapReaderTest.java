package frogger.service;

import static org.junit.Assert.*;
import java.util.HashMap;
import org.junit.Test;

/**
 * <h2> MapReaderTest </h2>
 * 
 * <p> The {@link MapReaderTest} test class is used to test the correctness of {@link MapReader} 
 * which generates the map by reading constant class with the given gameLevel
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see MapReader
 */
public class MapReaderTest {
	
	/**
	 * <p> This is the test function that tests the correctness of {@link MapReader#readConstantClass(String)}
	 * which reads the speed and position of objects from constant class with the given gameLevel
	 * 
 * <p> This method takes {@link frogger.constant.NormalMode} as an example and read the speed and position of log. If the speed 
	 * and all of the position is correct, then the test passes.
	 * 
	 * @throws Exception	Throws the {@link ClassNotFoundException} if the constant class is not existed
	 */
	@Test
	public void readConstantClassTest() throws Exception {
		Class levelConst = Class.forName("frogger.constant.NormalMode");
		
		HashMap<Integer, Integer> position = (HashMap<Integer, Integer>) levelConst.getField("POS_OF_LONG_LOG").get(null);
		double speed = (double) levelConst.getField("SPEED_OF_LONG_LOG").get(null);

		int shift = 0;
		for(Integer xPos : position.keySet()) {
			assertEquals(Integer.valueOf(0+shift), xPos);
			assertEquals(Integer.valueOf(276), position.get(xPos));
			shift += 400;
		}
		assertTrue(speed == -2);
	}

}
