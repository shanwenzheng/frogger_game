package frogger.constant;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * <h2> NormalMode </h2>
 * 
 * <p> The {@link NormalMode} class is used to store the normal level constant 
 * and read by {@link frogger.service.MapReader} to generate {@link frogger.model.Map}.
 * 
 * <p> <strong>Stored Constants:</strong>
 * <pre>
 * 		NUM_OF_LIFE;
 * 		SPEED_OF_LONG_TRUCK
 * 		SPEED_OF_SHORT_TRUCK
 * 		SPEED_OF_SLOW_CAR
 * 		SPEED_OF_QUICK_CAR
 * 		SPEED_OF_LONG_LOG
 * 		SPEED_OF_MEDIUM_LOG
 * 		SPEED_OF_SHORT_LOG
 * 		SPEED_OF_TURTLE
 * 		SPEED_OF_WETTURTLE
 * 		POS_OF_LONG_TRUCK
 *		POS_OF_SHORT_TRUCK
 * 		POS_OF_QUICK_CAR
 * 		POS_OF_SLOW_CAR
 * 		POS_OF_LONG_LOG
 * 		POS_OF_MEDIUM_LOG
 * 		POS_OF_SHORT_LOG
 * 		POS_OF_TURTLE
 * 		POS_OF_WETTURTLE
 * 		POS_OF_LIFE_IMAGE	
 * </pre>
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 *
 */
@SuppressWarnings("serial")
public class NormalMode {
	
	public static final int NUM_OF_LIFE = 3;
	
	public static final double SPEED_OF_LONG_TRUCK = 1;
	public static final double SPEED_OF_SHORT_TRUCK = 1;
	public static final double SPEED_OF_SLOW_CAR = -1;
	public static final double SPEED_OF_QUICK_CAR = -5;
	
	public static final double SPEED_OF_LONG_LOG = -2;
	public static final double SPEED_OF_MEDIUM_LOG = 0;
	public static final double SPEED_OF_SHORT_LOG = 0.75;
	
	public static final double SPEED_OF_TURTLE = -1;
	public static final double SPEED_OF_WETTURTLE = -1;

	public static final double SPEED_OF_SNAKE = 3;
	
	public static final HashMap<Integer, Integer> POS_OF_LONG_TRUCK = new HashMap<Integer, Integer>(){{
		put(0,540);
		put(500,540);
	}};
	
	public static final HashMap<Integer, Integer> POS_OF_SHORT_TRUCK = new HashMap<Integer, Integer>(){{
		put(0,649);
		put(300,649);
		put(600,649);
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
	
	public static final HashMap<Integer, Integer> POS_OF_MEDIUM_LOG = new HashMap<Integer, Integer>(){};
	
	public static final HashMap<Integer, Integer> POS_OF_SHORT_LOG = new HashMap<Integer, Integer>(){{
		put(0,166);
		put(220,166);
		put(440,166);
		put(50,329);
		put(270,329);
		put(490,329);
	}};
	
	public static final HashMap<Integer, Integer> POS_OF_TURTLE = new HashMap<Integer, Integer>(){{
		put(500,376);
		put(300,376);
	}};
	
	public static final HashMap<Integer, Integer> POS_OF_WETTURTLE = new HashMap<Integer, Integer>(){{
		put(700,376);
		put(600,217);
		put(400,217);
		put(200,217);
	}};

	public static final HashMap<Integer, Integer> POS_OF_SNAKE = new HashMap<Integer, Integer>(){{
		put(200,435);
	}};

	public static final HashMap<Integer, Integer> POS_OF_CHOMPER = new HashMap<Integer, Integer>(){{
		put(20,85);
//		put(150,85);
//		put(275,85);
//		put(405,85);
		put(535,85);
	}};
	
	public static final LinkedHashMap<Integer, Integer> POS_OF_LIFE_IMAGE = new LinkedHashMap<Integer, Integer>(){{
		put(10,750);
		put(60,750);
		put(110,750);
		//The position of x is added by 50
	}};
}
