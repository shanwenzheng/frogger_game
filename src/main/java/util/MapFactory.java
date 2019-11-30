package util;

import model.HardModeMap;
import model.Map;
import model.NormalModeMap;
import model.SimpleModeMap;

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