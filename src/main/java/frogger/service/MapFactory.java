package frogger.service;

import frogger.model.Map;

public class MapFactory {
	
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
		
		return mapReader.getMap();
	}
}