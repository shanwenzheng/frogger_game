package frogger.util;

import java.util.ArrayList;
import java.util.HashMap;

import frogger.Main;
import frogger.model.Map;
import frogger.model.actor.Actor;
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
	
	public Map getMap() throws Exception {
		createMap();
		return map;
	}
	
	public void createMap() throws Exception {
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
		ArrayList<End> temp = new ArrayList<End>();
		temp.add(new End(60,11,85));
		temp.add(new End(60,139,85));
		temp.add(new End(60,139 + 139-11,85));
		temp.add(new End(60,139 + 139-11+139-11+1,85));
		temp.add(new End(60,139 + 139-11+139-11+139-11+3,85));
		map.setEnds(temp);
	}
	
	public void createScoreBoard() {
		ArrayList<Digit> temp = new ArrayList<Digit>();
		temp.add(new Digit(0, 30, 565, 770));
		temp.add(new Digit(0, 30, 535, 770));
		temp.add(new Digit(0, 30, 505, 770));
		map.setScoreBoard(temp);
	}
	
	public void createHighScoreBoard() {
		ArrayList<Digit> temp = new ArrayList<Digit>();
		temp.add(new Digit(0, 30, 365, 770));
		temp.add(new Digit(0, 30, 335, 770));
		temp.add(new Digit(0, 30, 305, 770));
		map.setHighScoreBoard(temp);
	}
	
	public void createAnimal() {
		map.setAnimal(new Frog(40));
	}
	
	@SuppressWarnings("unchecked")
	public void createObstalce() throws Exception{
		ArrayList<Obstacle> temp = new ArrayList<Obstacle>();
		HashMap<Integer, Integer> position;
		double speed;
		
		position = (HashMap<Integer, Integer>) levelConst.getField("POS_OF_LONG_TRUCK").get(null);
		speed = (double) levelConst.getField("SPEED_OF_LONG_TRUCK").get(null);
		for(Integer xPos : position.keySet()) {
			String imageLink = "images/truck1" + (speed < 0 ? "Left" : "Right") + ".png";
			temp.add(new Obstacle(imageLink, 120, xPos, position.get(xPos), speed));
		}
		
		position = (HashMap<Integer, Integer>) levelConst.getField("POS_OF_SHORT_TRUCK").get(null);
		speed = (double) levelConst.getField("SPEED_OF_SHORT_TRUCK").get(null);
		for(Integer xPos : position.keySet()) {
			String imageLink = "images/truck2" + (speed < 0 ? "Left" : "Right") + ".png";
			temp.add(new Obstacle(imageLink, 200, xPos, position.get(xPos), speed));
		}
		
		position = (HashMap<Integer, Integer>) levelConst.getField("POS_OF_QUICK_CAR").get(null);
		speed = (double) levelConst.getField("SPEED_OF_QUICK_CAR").get(null);
		for(Integer xPos : position.keySet()) {
			String imageLink = "images/car1" + (speed < 0 ? "Left" : "Right") + ".png";
			temp.add(new Obstacle(imageLink, 50, xPos, position.get(xPos), speed));
		}
		
		position = (HashMap<Integer, Integer>) levelConst.getField("POS_OF_SLOW_CAR").get(null);
		speed = (double) levelConst.getField("SPEED_OF_SLOW_CAR").get(null);
		for(Integer xPos : position.keySet()) {
			String imageLink = "images/car1" + (speed < 0 ? "Left" : "Right") + ".png";
			temp.add(new Obstacle(imageLink, 50, xPos, position.get(xPos), speed));
		}
		
		map.setObstacles(temp);
	}
	
	@SuppressWarnings("unchecked")
	public void createLog() throws Exception{
		ArrayList<Log> temp = new ArrayList<Log>();
		HashMap<Integer, Integer> position;
		double speed;
		
		position = (HashMap<Integer, Integer>) levelConst.getField("POS_OF_LONG_LOG").get(null);
		speed = (double) levelConst.getField("SPEED_OF_LONG_LOG").get(null);
		for(Integer xPos : position.keySet()) {
			temp.add(new Log(("images/logs.png"), 300, xPos, position.get(xPos), speed));
		}
		
		position = (HashMap<Integer, Integer>) levelConst.getField("POS_OF_MEDIUM_LOG").get(null);
		speed = (double) levelConst.getField("SPEED_OF_MEDIUM_LOG").get(null);
		for(Integer xPos : position.keySet()) {
			temp.add(new Log(("images/log2.png"), 225, xPos, position.get(xPos), speed));
		}
		
		position = (HashMap<Integer, Integer>) levelConst.getField("POS_OF_SHORT_LOG").get(null);
		speed = (double) levelConst.getField("SPEED_OF_SHORT_LOG").get(null);
		for(Integer xPos : position.keySet()) {
			temp.add(new Log(("images/log3.png"), 150, xPos, position.get(xPos), speed));
		}
		
		map.setLogs(temp);
	}
	
	@SuppressWarnings("unchecked")
	public void createTurtles() throws Exception{
		ArrayList<Turtle> temp = new ArrayList<Turtle>();
		
		HashMap<Integer, Integer> position = (HashMap<Integer, Integer>) levelConst.getField("POS_OF_TURTLE").get(null);
		double speed = (double) levelConst.getField("SPEED_OF_TURTLE").get(null);
		for(Integer xPos : position.keySet()) {
			temp.add(new Turtle(130, xPos, position.get(xPos), speed));
		}
		
		map.setTurtles(temp);
	}
	
	@SuppressWarnings("unchecked")
	public void createWetTurtles() throws Exception{
		ArrayList<WetTurtle> temp = new ArrayList<WetTurtle>();
		
		HashMap<Integer, Integer> position = (HashMap<Integer, Integer>) levelConst.getField("POS_OF_WETTURTLE").get(null);
		double speed = (double) levelConst.getField("SPEED_OF_WETTURTLE").get(null);
		for(Integer xPos : position.keySet()) {
			temp.add(new WetTurtle(130, xPos, position.get(xPos), speed));
		}
		
		map.setWetTurtles(temp);
	}

	public void createLifeImage() throws Exception{
		ArrayList<ImageView> temp = new ArrayList<ImageView>();
		int shift = 0;
		for(int i = 0; i < (int)levelConst.getField("NUM_OF_LIFE").get(null); i++) {
			ImageView life = new ImageView(new Image(Main.class.getResourceAsStream("images/froggerUp.png"), 50, 50, true, true));
			life.setX(10 + shift);
			life.setY(750);
			temp.add(i, life);
			shift += 50;
		}
		map.setLifeImage(temp);
	}
}
