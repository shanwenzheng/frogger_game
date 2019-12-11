package frogger.service;

import java.util.HashMap;
import frogger.Main;
import frogger.constant.FileName;
import frogger.model.Map;
import frogger.model.actor.movableActor.*;
import frogger.model.actor.staticActor.Chomper;
import frogger.model.actor.staticActor.Digit;
import frogger.model.actor.staticActor.End;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * <h2> MapReader </h2>
 * 
 * <p> The {@link MapReader} class of utility to create a {@link Map} by reading from different constant class based on the given input gameLevel
 * 
 * <p> An simple example constant class:
 * 
 * <pre>
 * 	public static final int NUM_OF_LIFE = 2;
 *	
 *	public static final double SPEED_OF_LONG_TRUCK = -1;
 *	
 *	public static final double SPEED_OF_LONG_LOG = -2;
 *
 *	public static final double SPEED_OF_TURTLE = -1;
 *	
 *	public static final HashMap&lt;Integer, Integer&gt; POS_OF_LONG_TRUCK = new HashMap&lt;Integer, Integer&gt;(){{
 *		put(0,540);
 *		put(500,540);
 *	}};
 *	
 *	public static final HashMap&lt;Integer, Integer&gt; POS_OF_LONG_LOG = new HashMap&lt;Integer, Integer&gt;(){{
 *		put(0,276);
 *		put(400,276);
 *	}};
 *	
 *	public static final LinkedHashMap&lt;Integer, Integer&gt; POS_OF_LIFE_IMAGE = new LinkedHashMap&lt;Integer, Integer&gt;(){{
 *		put(10,750);
 *		put(60,750);
 *	}};
 *	
 *	public static final HashMap&lt;Integer, Integer&gt; POS_OF_TURTLE = new HashMap&lt;Integer, Integer&gt;(){{
 *		put(500,376);
 *		put(300,376);
 *	}};
 * </pre>
 * 
 * <p><strong>Approach of reading from constant class</strong>
 * 
 * <pre>
 * 		Class levelConst = Class.forName("frogger.constant." + gameLevel);
 * 		double speed = levelConst.getField("SPEED_OF_" + actorStr).get(null);
 * 		HashMap&lt;Integer, Integer&gt; position = levelConst.getField("POS_OF_" + actorStr).get(null);
 * 
 * 		for(Integer xPos : position.keySet()) {
 *			map.getActors().add(new Actor(ImageLink, ImageSize, xPos, position.get(xPos), speed));
 *		}
 * </pre>
 * 
 * <p><strong>Use:</strong>
 * 
 * <pre>
 * 		MapReader mapReader = null;
 * 
 * 		//using the factory pattern
 * 		if(gameLevel.equals("certainMode") { mapReader = new MapReader(gameLevel); } 
 * 		
 * 		MapReader.createMap();
 * 		MapReader.getMap();
 * </pre>
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see MapFactory
 * @see Map
 *
 */
public class MapReader {
	
	/** <p> The map read from gameLevel constant class */
	private Map map;
	/** <p> The gameLevel constant class object */
	private Class levelConst;
	
	/**
	 * 	<p>Initialize new {@link Map} and constant {@link Class}.
	 * 
	 * @param gameLevel		The level of current game
	 * @throws ClassNotFoundException	Throws classNotFoundException if not find the corresponding gameLevel constant class
	 */
	public MapReader(String gameLevel) throws ClassNotFoundException {
		map = new Map();
		levelConst = Class.forName("frogger.constant." + gameLevel);
	}
	
	/**
	 * <p> return the {@link Map} read from gameLevel constant class
	 * 
	 * @return the {@link Map} read from gameLevel constant class
	 */
	public Map getMap(){
		return map;
	}
	
	/**
	 * <p> Call all single create {@link frogger.model.actor.Actor} class to generate the {@link Map}.
	 */
	public void createMap(){
		createEnd();
		createScoreBoard();
		createAnimal();
		createObstalce();
		createLog();
		createTurtles();
		createWetTurtles();
		createSnake();
		createChompers();
		createLifeImage();
	}
	
	/**
	 * <p> Create {@link End} objects.
	 */
	public void createEnd() {
		map.getEnds().add(new End(60,11,85));
		map.getEnds().add(new End(60,139,85));
		map.getEnds().add(new End(60,139 + 139-11,85));
		map.getEnds().add(new End(60,139 + 139-11+139-11+1,85));
		map.getEnds().add(new End(60,139 + 139-11+139-11+139-11+3,85));
	}
	
	/**
	 * <p> Create scoreBoard which contains three {@link Digit} objects
	 */
	public void createScoreBoard() {
		map.getScoreBoard().add(new Digit(0, 30, 565, 770));
		map.getScoreBoard().add(new Digit(0, 30, 535, 770));
		map.getScoreBoard().add(new Digit(0, 30, 505, 770));
	}
	
	/**
	 * <p> Create {@link Frog} object.
	 */
	public void createAnimal() {
		map.setAnimal(new Frog(40));
	}
	
	/**
	 * <p> Create {@link Obstacle} objects.
	 */
	public void createObstalce(){
		readConstantClass("LONG_TRUCK");
		readConstantClass("SHORT_TRUCK");
		readConstantClass("QUICK_CAR");
		readConstantClass("SLOW_CAR");
	}
	
	/**
	 * <p> Create {@link Log} objects.
	 */
	public void createLog(){
		readConstantClass("LONG_LOG");
		readConstantClass("MEDIUM_LOG");
		readConstantClass("SHORT_LOG");
	}

	/**
	 * <p> Create {@link Snake} objects.
	 */
	public void createSnake(){
		readConstantClass("SNAKE");
	}
	
	/**
	 * <p> Create {@link Turtle} objects.
	 */
	public void createTurtles(){
		readConstantClass("TURTLE");
	}
	
	/**
	 * <p> Create {@link WetTurtle} objects.
	 */
	public void createWetTurtles(){
		readConstantClass("WETTURTLE");
	}

	/**
	 * <p> Create LifeImage {@link ImageView} objects.
	 */
	public void createLifeImage(){
		readConstantClass("LIFE_IMAGE");
	}

	/**
	 * <p> Create {@link Chomper} objects.
	 */
	public void createChompers() {readConstantClass("CHOMPER"); }
	
	/**
	 * <p>Read the constant class and create corresponding {@link frogger.model.actor.Actor} objects based on the actor String input 
	 * 
	 * <p> This method first read the position and speed of corresponding actor from constant class. 
	 * And then using switch statement to select which object should be generated.
	 * 
	 * <p> <strong>Parameter Parsing: </strong>
	 * 
	 * <pre>
	 * 	"LONG_TRUCK" - Obstacle + size: 200;
	 * 	"SHROT_TRUCK" - Obstacle + size: 120;
	 * 	"QUICK_CAR" - Obstacle + size:50;
	 * 	"SLOW_CAR" - Obstacle + size:50;
	 * 	"LONG_LOG" - log + size:300;
	 * 	"MEDIUM_LOG" - Log + size:225;
	 * 	"SHORT_LOG" - Log + size:150;
	 * 	"TURTLE" - Turtle + size:130;
	 * 	"WETTURTLE" - WetTurtle + size:130;
	 * 	"SNAKE" - Snake + size: 100;
	 * 	"CHOMPER" - Chomper + size:60;
	 * 	"LIFE_IMAGE" - ImageView + size: 50;
	 * </pre>
	 * 
	 * @param actorStr	The name of which actor should be generated (More information depend on above Parameter Parsing)
	 */
	@SuppressWarnings("unchecked")
	public void readConstantClass(String actorStr){
		HashMap<Integer, Integer> position = null;
		double speed = 0;

		//Read the constants from class
		try {
			position = (HashMap<Integer, Integer>) levelConst.getField("POS_OF_" + actorStr).get(null);
			if(!actorStr.equals("LIFE_IMAGE") && !actorStr.equals("CHOMPER")) 	{speed = (double) levelConst.getField("SPEED_OF_" + actorStr).get(null);}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Generate corresponding actors
		switch(actorStr) {
			case "LONG_TRUCK":
				for(Integer xPos : position.keySet()) {
					map.getObstacles().add(new Obstacle((speed < 0 ? FileName.IMAGE_LONG_TRUCK_LEFT : FileName.IMAGE_LONG_TRUCK_RIGHT), 200, xPos, position.get(xPos), speed));
				}
				break;
			case "SHORT_TRUCK":
				for(Integer xPos : position.keySet()) {
					map.getObstacles().add(new Obstacle((speed < 0 ? FileName.IMAGE_SHORT_TRUCK_LEFT : FileName.IMAGE_SHORT_TRUCK_RIGHT), 120, xPos, position.get(xPos), speed));
				}
				break;
			case "QUICK_CAR":
				for(Integer xPos : position.keySet()) {
					map.getObstacles().add(new Obstacle((speed < 0 ? FileName.IMAGE_CAR_LEFT : FileName.IMAGE_CAR_RIGHT), 50, xPos, position.get(xPos), speed));
				}
				break;
			case "SLOW_CAR":
				for(Integer xPos : position.keySet()) {
					map.getObstacles().add(new Obstacle((speed < 0 ? FileName.IMAGE_CAR_LEFT : FileName.IMAGE_CAR_RIGHT), 50, xPos, position.get(xPos), speed));
				}
				break;
			case "LONG_LOG":
				for(Integer xPos : position.keySet()) {
					map.getLogs().add(new Log(FileName.IMAGE_LONG_LOG, 300, xPos, position.get(xPos), speed));
				}
				break;
			case "MEDIUM_LOG":
				for(Integer xPos : position.keySet()) {
					map.getLogs().add(new Log(FileName.IMAGE_MEDIUM_LOG, 225, xPos, position.get(xPos), speed));
				}
				break;
			case "SHORT_LOG":
				for(Integer xPos : position.keySet()) {
					map.getLogs().add(new Log(FileName.IMAGE_SHORT_LOG, 150, xPos, position.get(xPos), speed));
				}
				break;
			case "SNAKE":
				for(Integer xPos : position.keySet()){
					map.getSnakes().add(new Snake(FileName.IMAGE_SNAKE, 50, xPos, position.get(xPos), speed));
				}
				break;
			case "TURTLE":
				for(Integer xPos : position.keySet()) {
					map.getTurtles().add(new Turtle(130, xPos, position.get(xPos), speed));
				}
				break;
			case "WETTURTLE":
				for(Integer xPos : position.keySet()) {
					map.getWetTurtles().add(new WetTurtle(130, xPos, position.get(xPos), speed));
				}
				break;
			case "CHOMPER":
				for(Integer xPos : position.keySet()){
					map.getChompers().add(new Chomper(60, xPos, position.get(xPos)));
				}
				break;
			case "LIFE_IMAGE":
				for(Integer xPos : position.keySet()) {
					ImageView temp = new ImageView(new Image(Main.class.getResourceAsStream(FileName.IMAGE_LIFE), 50, 50, true, true));
					temp.setX(xPos);
					temp.setY(position.get(xPos));
					map.getLifeImage().add(temp);
				}
				break;
			default:
				break;
		}
	}
}
