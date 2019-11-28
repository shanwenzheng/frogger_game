package model;

import java.util.HashSet;
import java.util.Set;

import model.turtle.NormalTurtle;
import model.turtle.Turtle;
import model.turtle.WetTurtle;

public abstract class Map {
	private Set<Log> logs;
	private Set<Obstacle> obstacles;
	private Set<Turtle> turtles;
	private Set<End> ends;
	private Animal animal;
	private BackgroundImage backgroundImage;
	
	public Map() {
		logs = new HashSet<>();
		obstacles = new HashSet<>();
		turtles = new HashSet<>();
		ends = new HashSet<>();
		initMap();
	}
	
	public void initMap() {
		createBackgroundImage();
		createAnimal();
		createEnd();
		createObstacles();
		createLogs();
		createTurtles();
	}
	
	public void createBackgroundImage() {
		backgroundImage = new BackgroundImage("images/iKogsKW.png");	
	}
	
	public void createAnimal() {
		animal = new Animal("images/froggerUp.png",40);
	}
	
	public void createEnd() {
		ends.add(new End("images/end.png",60,13,96));
		ends.add(new End("images/end.png",60,141,96));
		ends.add(new End("images/end.png",60,141 + 141-13,96));
		ends.add(new End("images/end.png",60,141 + 141-13+141-13+1,96));
		ends.add(new End("images/end.png",60,141 + 141-13+141-13+141-13+3,96));
	}

	public Set<Log> getLogs() {
		return logs;
	}

	public Set<Obstacle> getObstacles() {
		return obstacles;
	}
	
	public Set<Turtle> getTurtles(){
		return turtles;
	}

	public Set<End> getEnd() {
		return ends;
	}

	public Animal getAnimal() {
		return animal;
	}

	public BackgroundImage getBackgroundImage() {
		return backgroundImage;
	}
	
	public abstract void createObstacles();
	public abstract void createLogs();
	public abstract void createTurtles();
}
