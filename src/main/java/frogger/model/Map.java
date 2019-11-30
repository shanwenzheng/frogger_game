package frogger.model;

import java.util.ArrayList;

import frogger.Main;
import frogger.model.actor.movableActor.Frog;
import frogger.model.actor.movableActor.Log;
import frogger.model.actor.movableActor.Obstacle;
import frogger.model.actor.movableActor.Turtle;
import frogger.model.actor.movableActor.WetTurtle;
import frogger.model.actor.staticActor.Digit;
import frogger.model.actor.staticActor.End;

public abstract class Map {
	private ArrayList<Log> logs;
	private ArrayList<Obstacle> obstacles;
	private ArrayList<Turtle> turtles;
	private ArrayList<WetTurtle> wetTurtles;
	private ArrayList<End> ends;
	private ArrayList<Digit> digits;
	private Frog animal;
	private String backgroundImage;
	
	public Map() {
		logs = new ArrayList<>();
		obstacles = new ArrayList<>();
		turtles = new ArrayList<>();
		wetTurtles = new ArrayList<>();
		ends = new ArrayList<>();
		digits = new ArrayList<>();
		initMap();
	}
	
	public void initMap() {
		createAnimal();
		createEnd();
		createDigit();
		createObstacles();
		createLogs();
		createTurtles();
		createWetTurtles();
		createBackgroundImage();
	}
	
	public void createBackgroundImage() {
		String str = Main.class.getResource("images/iKogsKW.png").toString();
		backgroundImage = "-fx-background-image: url('" + str + "'); -fx-background-size: 600 800;";
	}
	
	public void createAnimal() {
		animal = new Frog(40);
	}
	
	public void createEnd() {
		ends.add(new End(60,11,85));
		ends.add(new End(60,139,85));
		ends.add(new End(60,139 + 139-11,85));
		ends.add(new End(60,139 + 139-11+139-11+1,85));
		ends.add(new End(60,139 + 139-11+139-11+139-11+3,85));
	}
	
	public void createDigit() {
		digits.add(new Digit(0, 30, 565, 25));
		digits.add(new Digit(0, 30, 535, 25));
		digits.add(new Digit(0, 30, 505, 25));
	}

	public ArrayList<Log> getLogs() {
		return logs;
	}

	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}
	
	public ArrayList<Turtle> getTurtles(){
		return turtles;
	}
	
	public ArrayList<WetTurtle> getWetTurtles(){
		return wetTurtles;
	}

	public ArrayList<End> getEnd() {
		return ends;
	}
	
	public ArrayList<Digit> getDigit(){
		return digits;
	}

	public Frog getAnimal() {
		return animal;
	}
	
	public String getBackgroundImage() {
		return backgroundImage;
	}
	
	public abstract void createObstacles();
	public abstract void createLogs();
	public abstract void createTurtles();
	public abstract void createWetTurtles();
}
