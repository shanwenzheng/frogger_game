package frogger.model.actor.movableActor;

import java.util.ArrayList;
import java.util.HashMap;
import frogger.Main;
import frogger.controller.GameController;
import frogger.model.actor.staticActor.End;
import javafx.scene.image.Image;

public class Frog extends MovableActor{
	
	private HashMap<String, Image> frogImages;
	private ArrayList<Image> carDeathImages;
	private ArrayList<Image> waterDeathImages;			
	private boolean second;			
	private boolean noMove;	
	public String deathType;
	private int carD;
	private double w;
	private double movement = 13.3333333*2;			
	private double movementX = 10.666666*2;	
    
	public Frog(int size) {
		super();
		frogImages = new HashMap<String, Image>(){{
			put("w1",new Image(Main.class.getResourceAsStream("images/froggerUp.png"), size, size, true, true));
			put("a1",new Image(Main.class.getResourceAsStream("images/froggerLeft.png"), size, size, true, true));
			put("s1",new Image(Main.class.getResourceAsStream("images/froggerDown.png"), size, size, true, true));
			put("d1",new Image(Main.class.getResourceAsStream("images/froggerRight.png"), size, size, true, true));
			put("w2",new Image(Main.class.getResourceAsStream("images/froggerUpJump.png"), size, size, true, true));
			put("a2",new Image(Main.class.getResourceAsStream("images/froggerLeftJump.png"), size, size, true, true));
			put("s2",new Image(Main.class.getResourceAsStream("images/froggerDownJump.png"), size, size, true, true));
			put("d2",new Image(Main.class.getResourceAsStream("images/froggerRightJump.png"), size, size, true, true));
		}};
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
		setOrigin(1);
	}
	
	public void handleMove(String str) {
		if(str.equals("w")) {move(0, -movement);}
		else if(str.equals("a")) {move(-movementX, 0);}
		else if(str.equals("s")) {move(0, movement);}
		else if(str.equals("d")) {move(movementX, 0);}
	}
	
	public void moveKeyPressed(String keyCode) {
		if (noMove) {}
		else {
			setImage(frogImages.get(keyCode + (second ? "1" : "2")));
			second = !second;
			handleMove(keyCode);
		}
	}
	
	public void moveKeyReleased(String keyCode) {
		if (noMove) {}
		else {
			if(keyCode.equals("w") && getY() < w) {
				w = getY();
				GameController.INSTANCE.handleScoreChanged(10);
			}
			handleMove(keyCode);
			setImage(frogImages.get(keyCode+"1"));
			second = false;
		}
	}
	
	@Override
	public void act(long now) {
		checkAnimalWall();
		checkTouch();
		if(deathType != null) {handleDeath(now);}
	}
	
	@Override
	public void checkTouch() {
		if (getIntersectingObjects(End.class).size() >= 1) {
			GameController.INSTANCE.handleEndTouched(this);
		} else if(getY() < 438 && getIntersectingObjects(MovableActor.class).size() == 1) {
			GameController.INSTANCE.handlePoolTouched(this);		
		}
	}

	public void checkAnimalWall() {
		if (getY() > 734) {
			move(0,-movement*2);
		} else if (getX()<0) {
			move(movementX*2, 0);
		} else if (getX()>600) {
			move(-movementX*2, 0);
		}
	}
	
	public void handleDeath(long now){
		noMove = true;
		if((now)%11 == 0) {
			carD++;
		}
		
		if(deathType.equals("carDeath")) {
			handleCarDeath();
		}else if (deathType.equals("waterDeath")){
			handleWaterDeath();
		}
	}
	
	public void handleWaterDeath() {
		if(carD == 5) {
			setOrigin(0);
			GameController.INSTANCE.handleScoreChanged(-50);
		}else if (carD > 0) {
			setImage(waterDeathImages.get(carD - 1));
		}
	}
	
	public void handleCarDeath() {
		if(carD == 4) {
			setOrigin(0);
			GameController.INSTANCE.handleScoreChanged(-50);
		}else if(carD > 0) {
			setImage(carDeathImages.get(carD - 1));
		}
	}

	/* initialization frog position and status */
	public void setOrigin(int status) {
		w = status == 0 ? getY() : 800;
		carD = 0;
		noMove = false;
		second = false;
		deathType = null;
		setX(300);
		setY(679.8 + movement);
		setImage(frogImages.get("w1"));
	}

	public void setDeathType(String str) {
		deathType = str;
	}
}
