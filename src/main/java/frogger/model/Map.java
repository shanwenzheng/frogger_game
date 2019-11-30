package frogger.model;

import java.util.ArrayList;

import frogger.model.actor.movableActor.animal.Animal;
import frogger.model.actor.movableActor.log.Log;
import frogger.model.actor.movableActor.obstacle.Obstacle;
import frogger.model.actor.movableActor.turtle.Turtle;
import frogger.model.actor.staticActor.Digit;
import frogger.model.actor.staticActor.End;

public abstract class Map {
	private ArrayList<Log> logs;
	private ArrayList<Obstacle> obstacles;
	private ArrayList<Turtle> turtles;
	private ArrayList<End> ends;
	private ArrayList<Digit> digits;
	private Animal animal;
	
	public Map() {
		logs = new ArrayList<>();
		obstacles = new ArrayList<>();
		turtles = new ArrayList<>();
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
	}
	
	public void createAnimal() {
		animal = new Animal(40);
	}
	
	public void createEnd() {
		ends.add(new End(60,13,96));
		ends.add(new End(60,141,96));
		ends.add(new End(60,141 + 141-13,96));
		ends.add(new End(60,141 + 141-13+141-13+1,96));
		ends.add(new End(60,141 + 141-13+141-13+141-13+3,96));
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

	public ArrayList<End> getEnd() {
		return ends;
	}
	
	public ArrayList<Digit> getDigit(){
		return digits;
	}

	public Animal getAnimal() {
		return animal;
	}
	
	public abstract void createObstacles();
	public abstract void createLogs();
	public abstract void createTurtles();
}
