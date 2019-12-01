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
import javafx.scene.image.ImageView;

public abstract class Map {
	private ArrayList<Log> logs;
	private ArrayList<Obstacle> obstacles;
	private ArrayList<Turtle> turtles;
	private ArrayList<WetTurtle> wetTurtles;
	private ArrayList<End> ends;
	private ArrayList<Digit> scoreBoard;
	private ArrayList<Digit> highScoreBoard;
	private ArrayList<ImageView> lifeImage;
	private Life life;
	private Frog animal;
	
	public Map() {
		logs = new ArrayList<>();
		obstacles = new ArrayList<>();
		turtles = new ArrayList<>();
		wetTurtles = new ArrayList<>();
		ends = new ArrayList<>();
		scoreBoard = new ArrayList<>();
		highScoreBoard = new ArrayList<>();
		lifeImage = new ArrayList<>();
	}
	
	public void initMap() {
		createAnimal();
		createEnd();
		createScoreBoard();
		createHighScoreBoard();
		createObstacles();
		createLogs();
		createTurtles();
		createWetTurtles();
		createLifeImage();
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
	
	public void createScoreBoard() {
		scoreBoard.add(new Digit(0, 30, 565, 770));
		scoreBoard.add(new Digit(0, 30, 535, 770));
		scoreBoard.add(new Digit(0, 30, 505, 770));
	}
	
	public void createHighScoreBoard() {
		highScoreBoard.add(new Digit(0, 30, 365, 770));
		highScoreBoard.add(new Digit(0, 30, 335, 770));
		highScoreBoard.add(new Digit(0, 30, 305, 770));
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
	
	public ArrayList<Digit> getScoreBoard(){
		return scoreBoard;
	}
	
	public ArrayList<Digit> getHighScoreBoard(){
		return highScoreBoard;
	}
	
	public ArrayList<ImageView> getLifeImage(){
		return lifeImage;
	}
	
	public Life getLife() {
		return life;
	}
	
	public void setLife(Life life) {
		this.life = life;
	}

	public Frog getAnimal() {
		return animal;
	}
	
	public abstract void createObstacles();
	public abstract void createLogs();
	public abstract void createTurtles();
	public abstract void createWetTurtles();
	public abstract void createLifeImage();
}

