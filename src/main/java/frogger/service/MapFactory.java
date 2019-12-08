package frogger.service;

import frogger.model.Map;

/**
 * <h2> MapFactory </h2>
 * 
 * <p>The {@link MapFactory} class is used to generate a {@link Map} depend on the given gameLevel by calling {@link MapReader}
 * 
 * <p><strong>Note:</strong> this class is implemented as an factory pattern.
 * 
 * <p><strong>Main Functionality:</strong>
 * 
 * <pre>
 *		MapFactory.createMap(MapType);
 * </pre>
 * 
 * <p><strong>Use:</strong>
 * 
 * <pre>
 * 		MapFactory.{method}(); (Static Method Only)
 * </pre>
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @See Map
 * @See MapReader
 */
public class MapFactory {
	
	/**
	 *  Create a {@link Map} depend on the given gameLevel by calling {@link MapReader}
	 *  
	 * @param MapType	The MapType(gameLevel) of current game (generated from frogger.controller.SelectController)
	 * @return	A {@link Map} corresponding to the map type 
	 * @throws Exception An exception from {@link MapReader#MapReader()} which refers to the {@link ClassNotFoundException}
	 */
	public static Map createMap(String MapType) throws Exception {
		
		MapReader mapReader = null;
		
		if(MapType == null) {
			return null;
		}
		if(MapType.equals("SimpleMode")) {
			mapReader = new MapReader("SimpleMode");
		}else if(MapType.equals("NormalMode")) {
			mapReader = new MapReader("NormalMode");
		}else if(MapType.equals("HardMode")){
			mapReader = new MapReader("HardMode");
		}
		
		mapReader.createMap();
		return mapReader.getMap();
	}
}