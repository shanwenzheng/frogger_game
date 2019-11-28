package model;

import java.util.ArrayList;
import java.util.HashMap;

import frogger.Main;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.log.Log;
import model.obstacle.Obstacle;
import model.turtle.NormalTurtle;
import model.turtle.WetTurtle;


public class Animal extends MovableActor {
	private HashMap<String, Image> frogImages;
	int points = 0;							
	int end = 0;
	private boolean second = false;			
	boolean noMove = false;					
	double movement = 13.3333333*2;			
	double movementX = 10.666666*2;			
	int imgSize;						
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean changeScore = false;
	int carD = 0;
	double w = 800;
	ArrayList<End> inter = new ArrayList<End>();
	
	public Animal(int size) {
		super(300, 706.5, 10.666666*2);
		this.imgSize = size;
		setImage(new Image(Main.class.getResourceAsStream("images/froggerUp.png"), imgSize, imgSize, true, true));
		frogImages= new HashMap<String, Image>() {{
			put("w1",new Image(Main.class.getResourceAsStream("images/froggerUp.png"), imgSize, imgSize, true, true));
			put("a1",new Image(Main.class.getResourceAsStream("images/froggerLeft.png"), imgSize, imgSize, true, true));
			put("s1",new Image(Main.class.getResourceAsStream("images/froggerDown.png"), imgSize, imgSize, true, true));
			put("d1",new Image(Main.class.getResourceAsStream("images/froggerRight.png"), imgSize, imgSize, true, true));
			put("w2",new Image(Main.class.getResourceAsStream("images/froggerUpJump.png"), imgSize, imgSize, true, true));
			put("a2",new Image(Main.class.getResourceAsStream("images/froggerLeftJump.png"), imgSize, imgSize, true, true));
			put("s2",new Image(Main.class.getResourceAsStream("images/froggerDownJump.png"), imgSize, imgSize, true, true));
			put("d2",new Image(Main.class.getResourceAsStream("images/froggerRightJump.png"), imgSize, imgSize, true, true));
		}};
	}
	
	public void handleMove(String str) {
		if(str.equals("w")) {
			move(0, -movement);
		}else if(str.equals("a")) {
			move(-movementX, 0);
		}else if(str.equals("s")) {
			move(0, movement);
		}else if(str.equals("d")) {
			move(movementX, 0);
		}
	}
	
	public void handleKeyPressed(KeyEvent event) {
		if (noMove) {}
		else {
			String keyCode = event.getText();
			if (second) {
				setImage(frogImages.get(keyCode+"1"));
				second = false;
			}else {
				setImage(frogImages.get(keyCode+"2"));
				second = true;
			}
			handleMove(keyCode);
		}
	}
	
	public void handleKeyReleased(KeyEvent event) {
		if (noMove) {}
		else {
			String keyCode = event.getText();
			if(keyCode.equals("w") && getY() < w) {
				changeScore = true;
				w = getY();
				points += 10;
			}
			handleMove(keyCode);
			setImage(frogImages.get(keyCode+"1"));
			second = false;
		}
	}
	
	@Override
	public void act(long now) {
		checkAnimalWall();
		
		if(waterDeath || carDeath) {
			handleDeath(now);
		}
		
		handleRoadCondition();
		handleWaterCondition();
	}
	
	
	public boolean getStop() {
		return end==5;
	}
	
	public int getPoints() {
		return points;
	}
	
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
	}
	
	public void checkAnimalWall() {
		if (getY()<0 || getY()>734) {
			setX(300);
			setY(679.8+movement);
		} else if (getX()<0) {
			move(movement*2, 0);
		} if (getX()>600) {
			move(-movement*2, 0);
		}
	}
	
	public void handleDeath(long now) {
		noMove = true;
		if((now)%11 == 0) {
			carD++;
		}
		
		String deathType = carDeath ? "cardeath" : "waterdeath";
		if(carD == 1) {
			setImage(new Image(Main.class.getResourceAsStream("images/" + deathType + carD + ".png"), imgSize,imgSize , true, true));
		}
		if(carD == 2) {
			setImage(new Image(Main.class.getResourceAsStream("images/" + deathType + carD + ".png"), imgSize,imgSize , true, true));
		}
		if(carD == 3) {
			setImage(new Image(Main.class.getResourceAsStream("images/" + deathType + carD + ".png"), imgSize,imgSize , true, true));
		}
		if(waterDeath && carD == 4) {
			setImage(new Image(Main.class.getResourceAsStream("images/waterdeath4.png"), imgSize,imgSize , true, true));
		}
		if(carD == 5 || (carD == 4 && carDeath)) {
			setX(300);
			setY(679.8+movement);
			waterDeath = false;
			carDeath = false;
			carD = 0;
			setImage(new Image(Main.class.getResourceAsStream("images/froggerUp.png"), imgSize, imgSize, true, true));
			noMove = false;
			if (points>50) {
				points-=50;
				changeScore = true;
			}
		}
	}

	public void handleRoadCondition() {
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {		
			carDeath = true;
		}
	}
	
	public void handleWaterCondition() {
		if(getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			moveWithSpeed(getIntersectingObjects(Log.class).get(0).getSpeed());
		}
		else if (getIntersectingObjects(NormalTurtle.class).size() >= 1 && !noMove) {			
			moveWithSpeed(getIntersectingObjects(NormalTurtle.class).get(0).getSpeed());
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			handleEndCondition();
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {				
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} 
			else {
				moveWithSpeed(getIntersectingObjects(WetTurtle.class).get(0).getSpeed());
			}
		}
		else if (getY()<413){
			waterDeath = true;
		}
	}
	
	public void moveWithSpeed(double speed) {
		move(speed,0);
	}

	public void handleEndCondition() {
		inter = (ArrayList<End>) getIntersectingObjects(End.class);
		if (getIntersectingObjects(End.class).get(0).isActivated()) {
			end--;
			points-=50;
		}
		points+=50;
		changeScore = true;
		w=800;
		getIntersectingObjects(End.class).get(0).setEnd();
		end++;
		setX(300);
		setY(679.8+movement);
	}
}
