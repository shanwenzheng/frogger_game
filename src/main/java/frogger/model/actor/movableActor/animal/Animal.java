package frogger.model.actor.movableActor.animal;

import java.util.ArrayList;
import java.util.HashMap;

import frogger.Main;
import frogger.model.actor.movableActor.MovableActor;
import frogger.model.actor.movableActor.log.Log;
import frogger.model.actor.movableActor.obstacle.Obstacle;
import frogger.model.actor.movableActor.turtle.NormalTurtle;
import frogger.model.actor.movableActor.turtle.WetTurtle;
import frogger.model.actor.staticActor.End;
import frogger.util.GameManager;
import frogger.util.ScoreBoardUpdater;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

public abstract class Animal extends MovableActor{
	
	private HashMap<String, Image> animalImages;
	private ArrayList<Image> carDeathImages;
	private ArrayList<Image> waterDeathImages;
	private int points = 0;							
	private int end = 0;
	private boolean second = false;			
	private boolean noMove = false;					
	private double movement = 13.3333333*2;			
	private double movementX = 10.666666*2;	
	private double initX;
	private double initY;						
	private boolean carDeath = false;
	private boolean waterDeath = false;
	private int carD = 0;
	private double w = 800;

	public Animal(int size, double xpos, double ypos, double s) {
		super(xpos, ypos, s);
		this.initX = xpos;
		this.initY = ypos;
		animalImages = new HashMap<String, Image>();
		carDeathImages = new ArrayList<Image>() {{
			add(new Image(Main.class.getResourceAsStream("images/cardeath1.png"), size,size , true, true));
			add(new Image(Main.class.getResourceAsStream("images/cardeath2.png"), size,size , true, true));
			add(new Image(Main.class.getResourceAsStream("images/cardeath3.png"), size,size , true, true));
		}};
		waterDeathImages = new ArrayList<Image>() {{
			add(new Image(Main.class.getResourceAsStream("images/waterdeath1.png"), size,size , true, true));
			add(new Image(Main.class.getResourceAsStream("images/waterdeath2.png"), size,size , true, true));
			add(new Image(Main.class.getResourceAsStream("images/waterdeath3.png"), size,size , true, true));
			add(new Image(Main.class.getResourceAsStream("images/waterdeath4.png"), size,size , true, true));
		}};
	}
	
	public void handleMove(String str) {
		if (noMove) {}
		else
		{
			if(str.equals("w")) {move(0, -movement);}
			else if(str.equals("a")) {move(-movementX, 0);}
			else if(str.equals("s")) {move(0, movement);}
			else if(str.equals("d")) {move(movementX, 0);}
		}
	}
	
	public void handleKeyPressed(KeyEvent event) {
		if (noMove) {}
		else {
			String keyCode = event.getText();
			setImage(animalImages.get(keyCode + (second ? "1" : "2")));
			second = !second;
			handleMove(keyCode);
		}
	}
	
	public void handleKeyReleased(KeyEvent event) {
		if (noMove) {}
		else {
			String keyCode = event.getText();
			if(keyCode.equals("w") && getY() < w) {
				w = getY();
				points += 10;
				ScoreBoardUpdater.INSTANCE.updateScore(getPoints());
			}
			handleMove(keyCode);
			setImage(animalImages.get(keyCode+"1"));
			second = false;
		}
	}
	
	@Override
	public void act(long now) {
		checkAnimalWall();
		if(waterDeath || carDeath) {
			handleDeath(now);
		}
		handleTouch();
	}

	public void checkAnimalWall() {
		if (getY()<0 || getY()>734) {
			setOrigin();
		} else if (getX()<0) {
			move(movement*2, 0);
		} else if (getX()>600) {
			move(-movement*2, 0);
		}
	}
	
	public void handleDeath(long now){
		noMove = true;
		if((now)%11 == 0) {
			carD++;
		}
		
		if(carD == 5 || (carD == 4 && carDeath)) {
			setOrigin();
			waterDeath = false;
			carDeath = false;
			carD = 0;
			setImage(animalImages.get("w1"));
			noMove = false;
			if (points>50) {
				points-=50;
				ScoreBoardUpdater.INSTANCE.updateScore(getPoints());
			}
		}else if (carD > 0){
			ArrayList<Image> temp =  carDeath ? carDeathImages : waterDeathImages;
			setImage(temp.get(carD-1));
		}
	}

	public void handleTouch() {		
		if(getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			handleLogTouch();
		}
		else if (getIntersectingObjects(NormalTurtle.class).size() >= 1 && !noMove) {			
			handleNormalTurtleTouch();
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			handleEndTouch();
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {				
			handleWetturtleTouch();
		}
		else {
			handleObstacleTouch();
			handlePoolTouch();
		}
	}
	
	public void handleObstacleTouch() {
		carDeath = getIntersectingObjects(Obstacle.class).size() >= 1;
	}
	
	public void handlePoolTouch() {
		waterDeath = getY()<413;
	}
	
	public void handleWetturtleTouch() {
		if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
			waterDeath = true;
		} 
		else {
			moveWithSpeed(getIntersectingObjects(WetTurtle.class).get(0).getSpeed());
		}
	}

	public void handleEndTouch() {
		if (getIntersectingObjects(End.class).get(0).isActivated()) {
			end--;
			points-=50;
		}
		points+=50;
		ScoreBoardUpdater.INSTANCE.updateScore(getPoints());
		w=800;
		getIntersectingObjects(End.class).get(0).setEnd();
		end++;
		setOrigin();
		
		if(end == 5) {
			GameManager.INSTANCE.endGame();
		}
	}
	
	public void handleLogTouch() {
		moveWithSpeed(getIntersectingObjects(Log.class).get(0).getSpeed());
	}
	
	public void handleNormalTurtleTouch() {
		moveWithSpeed(getIntersectingObjects(NormalTurtle.class).get(0).getSpeed());
	}
	
	public void moveWithSpeed(double speed) {
		move(speed,0);
	}
	
	public HashMap<String, Image> getAnimalImages(){
		return animalImages;
	}
	
	public int getPoints() {
		return points;
	}

	public void setOrigin() {
		setX(initX);
		setY(initY);
	}
}
