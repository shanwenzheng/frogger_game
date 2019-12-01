package frogger.model;

import java.util.ArrayList;

import frogger.model.actor.movableActor.Frog;
import frogger.model.actor.movableActor.Log;
import frogger.model.actor.movableActor.Obstacle;
import frogger.model.actor.movableActor.Turtle;
import frogger.model.actor.movableActor.WetTurtle;
import frogger.model.actor.staticActor.Digit;
import frogger.model.actor.staticActor.End;
import javafx.scene.image.ImageView;

public class Map {
	private ArrayList<Log> logs;
	private ArrayList<Obstacle> obstacles;
	private ArrayList<Turtle> turtles;
	private ArrayList<WetTurtle> wetTurtles;
	private ArrayList<End> ends;
	private ArrayList<Digit> scoreBoard;
	private ArrayList<Digit> highScoreBoard;
	private ArrayList<ImageView> lifeImage;
	
	public ArrayList<Log> getLogs() {
		return logs;
	}

	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}

	public ArrayList<Turtle> getTurtles() {
		return turtles;
	}

	public ArrayList<WetTurtle> getWetTurtles() {
		return wetTurtles;
	}

	public ArrayList<End> getEnds() {
		return ends;
	}

	public ArrayList<Digit> getScoreBoard() {
		return scoreBoard;
	}

	public ArrayList<Digit> getHighScoreBoard() {
		return highScoreBoard;
	}

	public ArrayList<ImageView> getLifeImage() {
		return lifeImage;
	}

	public Frog getAnimal() {
		return animal;
	}

	public void setLogs(ArrayList<Log> logs) {
		this.logs = logs;
	}

	public void setObstacles(ArrayList<Obstacle> obstacles) {
		this.obstacles = obstacles;
	}

	public void setTurtles(ArrayList<Turtle> turtles) {
		this.turtles = turtles;
	}

	public void setWetTurtles(ArrayList<WetTurtle> wetTurtles) {
		this.wetTurtles = wetTurtles;
	}

	public void setEnds(ArrayList<End> ends) {
		this.ends = ends;
	}

	public void setScoreBoard(ArrayList<Digit> scoreBoard) {
		this.scoreBoard = scoreBoard;
	}

	public void setHighScoreBoard(ArrayList<Digit> highScoreBoard) {
		this.highScoreBoard = highScoreBoard;
	}

	public void setLifeImage(ArrayList<ImageView> lifeImage) {
		this.lifeImage = lifeImage;
	}

	public void setAnimal(Frog animal) {
		this.animal = animal;
	}

	private Frog animal;
	
	public Map() {}

}

