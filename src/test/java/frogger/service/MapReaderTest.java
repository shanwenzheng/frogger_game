package frogger.service;

import static org.junit.Assert.*;
import java.util.HashMap;
import org.junit.Test;

public class MapReaderTest {
	
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
