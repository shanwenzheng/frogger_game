package model;

import java.util.HashSet;
import java.util.Set;

import model.actor.movableActor.animal.Animal;
import model.actor.movableActor.log.Log;
import model.actor.movableActor.obstacle.Obstacle;
import model.actor.movableActor.turtle.NormalTurtle;
import model.actor.movableActor.turtle.Turtle;
import model.actor.movableActor.turtle.WetTurtle;
import model.actor.staticActor.BackgroundImage;
import model.actor.staticActor.End;

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
		animal = new Animal(40);
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
