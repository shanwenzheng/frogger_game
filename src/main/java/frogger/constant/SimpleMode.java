package frogger.constant;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class SimpleMode {
	public static final int NUM_OF_LIFE = 4;
	
	public static final double SPEED_OF_LONG_TRUCK = -1;
	public static final double SPEED_OF_SHORT_TRUCK = -1;
	public static final double SPEED_OF_SLOW_CAR = 1;
	public static final double SPEED_OF_QUICK_CAR = 4;
	
	public static final double SPEED_OF_LONG_LOG = -2;
	public static final double SPEED_OF_MEDIUM_LOG = 1;
	public static final double SPEED_OF_SHORT_LOG = 0.75;
	
	public static final double SPEED_OF_TURTLE = -1;
	public static final double SPEED_OF_WETTURTLE = -1;
	
	public static final HashMap<Integer, Integer> POS_OF_LONG_TRUCK = new HashMap<Integer, Integer>(){{
		put(0,540);
		put(500,540);
	}};
	
	public static final HashMap<Integer, Integer> POS_OF_SHORT_TRUCK = new HashMap<Integer, Integer>(){{
		put(0,649);
		put(400,649);
	}};
	
	public static final HashMap<Integer, Integer> POS_OF_QUICK_CAR = new HashMap<Integer, Integer>(){{
		put(500,490);
	}};
	
	public static final HashMap<Integer, Integer> POS_OF_SLOW_CAR = new HashMap<Integer, Integer>(){{
		put(100,597);
		put(250,597);
		put(400,597);
		put(550,597);
	}};
	
	public static final HashMap<Integer, Integer> POS_OF_LONG_LOG = new HashMap<Integer, Integer>(){{
		put(0,276);
		put(400,276);
	}};
	
	public static final HashMap<Integer, Integer> POS_OF_MEDIUM_LOG = new HashMap<Integer, Integer>(){{
		put(50,329);
		put(370,329);
		put(590,329);
	}};
	
	public static final HashMap<Integer, Integer> POS_OF_SHORT_LOG = new HashMap<Integer, Integer>(){{
		put(0,166);
		put(220,166);
		put(440,166);
		put(590,166);
	}};
	
	public static final HashMap<Integer, Integer> POS_OF_TURTLE = new HashMap<Integer, Integer>(){{
		put(500,376);
		put(300,376);
		put(700,376);
		put(600,217);
		put(400,217);
		put(200,217);
	}};
	
	public static final HashMap<Integer, Integer> POS_OF_WETTURTLE = new HashMap<Integer, Integer>(){};
	
	public static final LinkedHashMap<Integer, Integer> POS_OF_LIFE_IMAGE = new LinkedHashMap<Integer, Integer>(){{
		put(10,750);
		put(60,750);
		put(110,750);
		put(160,750);
	}};
}
