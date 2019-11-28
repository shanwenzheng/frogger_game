package frogger.util;

import frogger.model.HardModeMap;
import frogger.model.Map;
import frogger.model.NormalModeMap;
import frogger.model.SimpleModeMap;

public class MapFactory {
	
	public static Map createMap(String MapType) {
		if(MapType == null) {
			return null;
		}
		if(MapType.equals("SimpleMode")) {
			return new SimpleModeMap();
		}else if(MapType.equals("NormalMode")) {
			return new NormalModeMap();
		}else if(MapType.equals("HardMode")){
			return new HardModeMap();
		}
		return null;
	}
}