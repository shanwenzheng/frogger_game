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
	private Frog animal;
	
	public Map() {
		logs = new ArrayList<Log>();
		obstacles = new ArrayList<Obstacle>();
		turtles = new ArrayList<Turtle>();
		wetTurtles = new ArrayList<WetTurtle>();
		ends = new ArrayList<End>();
		scoreBoard = new ArrayList<Digit>();
		highScoreBoard = new ArrayList<Digit>();
		lifeImage = new ArrayList<ImageView>();
	}
	
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

	public void setAnimal(Frog animal) {
		this.animal = animal;
	}
}

