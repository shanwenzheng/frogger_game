package frogger.model.actor.movableActor;

import java.util.ArrayList;
import java.util.HashMap;
import frogger.Main;
import frogger.controller.GameController;
import frogger.model.Score;
import frogger.model.actor.staticActor.End;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

public class Frog extends MovableActor{
	
	private HashMap<String, Image> frogImages;
	private ArrayList<Image> carDeathImages;
	private ArrayList<Image> waterDeathImages;
	private Score points = new Score();	
	private boolean second = false;			
	private boolean noMove = false;					
	private double movement = 13.3333333*2;			
	private double movementX = 10.666666*2;	
	private double initX;
	private double initY;						
	private int carD = 0;
	private double w = 800;
	public String deathType = null;
    
	public Frog(int size, double xpos, double ypos) {
		super(xpos, ypos, 0);
		this.initX = xpos;
		this.initY = ypos;
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
		setImage(frogImages.get("w1"));
	}
	
	public void handleMove(String str) {
		if(str.equals("w")) {move(0, -movement);}
		else if(str.equals("a")) {move(-movementX, 0);}
		else if(str.equals("s")) {move(0, movement);}
		else if(str.equals("d")) {move(movementX, 0);}
	}
	
	public void handleKeyPressed(KeyEvent event) {
		if (noMove) {}
		else {
			String keyCode = event.getText();
			setImage(frogImages.get(keyCode + (second ? "1" : "2")));
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
				points.addScore(10);
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
			w=800;
			setOrigin();
		} else if(getY() < 438 && getIntersectingObjects(MovableActor.class).size() == 1) {
			GameController.INSTANCE.handlePoolTouched(this);		
		}
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
		
		if(carD == 5 || (carD == 4 && deathType.equals("carDeath"))) {
			setOrigin();
			deathType = null;
			carD = 0;
			setImage(frogImages.get("w1"));
			noMove = false;
			points.subScore(50);
		}else if (carD > 0){
			ArrayList<Image> temp =  deathType.equals("carDeath") ? carDeathImages : waterDeathImages;
			setImage(temp.get(carD-1));
		}
	}
	
	public Score getPoints() {
		return points;	
	}	
	
	public void setOrigin() {
		setX(initX);
		setY(initY);
	}

	public void setDeathType(String str) {
		deathType = str;
	}
}
