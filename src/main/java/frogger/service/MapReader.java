package frogger.service;

import java.util.HashMap;
import frogger.Main;
import frogger.constant.FileName;
import frogger.model.Map;
import frogger.model.actor.movableActor.Frog;
import frogger.model.actor.movableActor.Log;
import frogger.model.actor.movableActor.Obstacle;
import frogger.model.actor.movableActor.Turtle;
import frogger.model.actor.movableActor.WetTurtle;
import frogger.model.actor.staticActor.Digit;
import frogger.model.actor.staticActor.End;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MapReader {
	
	private Map map;
	private Class levelConst;
	
	public MapReader(String str) throws ClassNotFoundException {
		map = new Map();
		levelConst = Class.forName("frogger.constant." + str);
	}
	
	public Map getMap(){
		createMap();
		return map;
	}
	
	public void createMap(){
		createEnd();
		createScoreBoard();
		createHighScoreBoard();
		createAnimal();
		createObstalce();
		createLog();
		createTurtles();
		createWetTurtles();
		createLifeImage();
	}
	
	public void createEnd() {
		map.getEnds().add(new End(60,11,85));
		map.getEnds().add(new End(60,139,85));
		map.getEnds().add(new End(60,139 + 139-11,85));
		map.getEnds().add(new End(60,139 + 139-11+139-11+1,85));
		map.getEnds().add(new End(60,139 + 139-11+139-11+139-11+3,85));
	}
	
	public void createScoreBoard() {
		map.getScoreBoard().add(new Digit(0, 30, 565, 770));
		map.getScoreBoard().add(new Digit(0, 30, 535, 770));
		map.getScoreBoard().add(new Digit(0, 30, 505, 770));
	}
	
	public void createHighScoreBoard() {
		map.getHighScoreBoard().add(new Digit(0, 30, 365, 770));
		map.getHighScoreBoard().add(new Digit(0, 30, 335, 770));
		map.getHighScoreBoard().add(new Digit(0, 30, 305, 770));
	}
	
	public void createAnimal() {
		map.setAnimal(new Frog(40));
	}
	
	public void createObstalce(){
		readConstantClass("LONG_TRUCK");
		readConstantClass("SHORT_TRUCK");
		readConstantClass("QUICK_CAR");
		readConstantClass("SLOW_CAR");
	}
	
	public void createLog(){
		readConstantClass("LONG_LOG");
		readConstantClass("MEDIUM_LOG");
		readConstantClass("SHORT_LOG");
	}
	
	public void createTurtles(){
		readConstantClass("TURTLE");
	}
	

	public void createWetTurtles(){
		readConstantClass("WETTURTLE");
	}

	public void createLifeImage(){
		readConstantClass("LIFE_IMAGE");
	}
	
	@SuppressWarnings("unchecked")
	public void readConstantClass(String actorStr){
		HashMap<Integer, Integer> position = null;
		double speed = 0;

		try {
			position = (HashMap<Integer, Integer>) levelConst.getField("POS_OF_" + actorStr).get(null);
			if(!actorStr.equals("LIFE_IMAGE")) 	{speed = (double) levelConst.getField("SPEED_OF_" + actorStr).get(null);}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
