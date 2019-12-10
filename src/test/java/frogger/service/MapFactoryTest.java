package frogger.service;

import static org.junit.Assert.*;

import org.junit.Test;

import frogger.model.Map;

/**
 * <h2> MapFactoryTest </h2>
 * 
 * <p> The {@link MapFactoryTest} test class is used to test the correctness of {@link MapFactory} 
 * which call the {@link MapReader} class to generate corresponding {@link Map} with the given input gameLevel
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see MapFactory
 *
 */
public class MapFactoryTest {

	/**
	 * <p> This is the test function that tests the correctness of {@link MapFactory#createMap(String)} which create the corresponding {@link Map} and return it
	 * 
	 * <p> This test will pass if the input is null, then not generate a Map. If the input is "NormalMode", it will generate a map.
	 * 
	 * @throws Exception	Throws the {@link ClassNotFoundException} if the constant class is not existed
	 */
	@Test
	public void MapFactoryReturnTypeTest() throws Exception {
		assertFalse(MapFactory.createMap(null) instanceof Map);
		assertTrue(MapFactory.createMap("NormalMode") instanceof Map);
	}

}
