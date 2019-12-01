package frogger.util;

import frogger.model.Map;

public class MapFactory {
	
	public static Map createMap(String MapType) throws Exception {
		
		MapReader mapReader;
		
		if(MapType == null) {
			return null;
		}
		if(MapType.equals("SimpleMode")) {
			mapReader = new MapReader("SimpleMode");
			return mapReader.getMap();
		}else if(MapType.equals("NormalMode")) {
			mapReader = new MapReader("NormalMode");
			return mapReader.getMap();
		}else if(MapType.equals("HardMode")){
			mapReader = new MapReader("HardMode");
			return mapReader.getMap();
		}
		return null;
	}
}