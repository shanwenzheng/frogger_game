package frogger.service;

import static org.junit.Assert.*;

import org.junit.Test;

import frogger.model.Map;

public class MapFactoryTest {

	@Test
	public void MapFactoryReturnTypeTest() throws Exception {
		assertFalse(MapFactory.createMap(null) instanceof Map);
		assertTrue(MapFactory.createMap("NormalMode") instanceof Map);
	}

}
