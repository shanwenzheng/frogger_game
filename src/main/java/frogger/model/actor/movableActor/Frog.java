package frogger.model.actor.movableActor;

import java.util.HashMap;
import frogger.Main;
import frogger.constant.FileName;
import frogger.controller.GameController;
import frogger.model.actor.staticActor.End;
import javafx.scene.image.Image;

/**
 * <h2> Frog </h2>
 * 
 * <p> The {@link Frog} class is used to create the Frog object.
 * 
 * <p> A {@link Frog} object is set in {@link frogger.model.Map}. It is the main character of the game and move with the key pressed and released.
 * In each frame, this object also check the wall touch and check whether the frog touched the pool or enter into the end position.
 * When it touches {@link End} or sunk into pool, it will ask {@link GameController} to handle some consequences.
 *
 * <p> <Strong> Note: </strong> This class extends {@link MovableActor} abstract class and implements {@link MovableActor#act(long)} and {@link MovableActor#checkTouch()}.
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see MovableActor
 * @see GameController
 * @see End
 * @see frogger.model.Map
 */
public class Frog extends MovableActor{
	
	/**<p>An {@link HashMap} which contains all the images that {@link Frog} will change with the KeyEvent.
	 * 
	 * <p> The structure of the {@link HashMap}: 
	 * <br>W - Up, A - Left, S - Down, D - Right, 1 - Normal State, 2 - Jump State.
	 * <br> W + 1 means {@link Frog} toward up direction, W + 2 means {@link Frog} jump towards up direction and so on for A, S, D
	 */
	private HashMap<String, Image> frogImages;	
	
	/** The size of image */
	private int imageSize;
	
	/** The flag recording whether {@link Frog} will change the state to Jump state.*/
	private boolean second;			
	
	/** The flag recording whether {@link Frog} can continue moving. (When death this will be set to false) */
	private boolean noMove;	
	
	/** The deathType of frog death. This can be set to carDeath when touching {@link Obstacle} or waterDeath when sunk into water */
	public String deathType;
	
	/** An integer recording which images should display when death happen */
	private int carD;
	
	/** The last Y position the {@link Frog} arrived before death. Set to 800 when enter into end position or first attempt */
	private double w;
	
	/** The distance of each movement on the X axis */
	private double movement = 13.3333333*2;			
	
	/** The distance of each movement on the Y axis */
	private double movementX = 10.666666*2;	
    
	
	/**
	 * <p> The constructor of {@link Frog} class to generate instance
	 * 
	 * <p> This constructor call {@link #setOrigin(int)} function to sets the {@link Frog} in the given position of the given {@link frogger.model.Map}
	 * and initialize related variables. And this constructor also initializes the {@link HashMap} move image and set the initial image of {@link Frog}
	 * 
	 * @param size		The size of the image
	 */
	public Frog(int size) {
		super();
		this.imageSize = size;
		frogImages = new HashMap<String, Image>(){{
			put("w1",new Image(Main.class.getResourceAsStream(FileName.IMAGE_FROG_UP), size, size, true, true));
			put("a1",new Image(Main.class.getResourceAsStream(FileName.IMAGE_FROG_LEFT), size, size, true, true));
			put("s1",new Image(Main.class.getResourceAsStream(FileName.IMAGE_FROG_DOWN), size, size, true, true));
			put("d1",new Image(Main.class.getResourceAsStream(FileName.IMAGE_FROG_RIGHT), size, size, true, true));
			put("w2",new Image(Main.class.getResourceAsStream(FileName.IMAGE_FROG_UP_JUMP), size, size, true, true));
			put("a2",new Image(Main.class.getResourceAsStream(FileName.IMAGE_FROG_LEFT_JUMP), size, size, true, true));
			put("s2",new Image(Main.class.getResourceAsStream(FileName.IMAGE_FROG_DOWN_JUMP), size, size, true, true));
			put("d2",new Image(Main.class.getResourceAsStream(FileName.IMAGE_FROG_RIGHT_JUMP), size, size, true, true));
		}};
		setOrigin(1);
	}
	
	/**
	 * <p>This method is called when the key pressed and released to let {@link Frog} move
	 * 
	 * <p>When player pressed {@code W}, frog move upwards. When player pressed {@code A}, frog move Left.
	 * When player pressed {@code S}, frog move right. When player pressed {@code D}, frog move right.
	 * 
	 * @param str	The current direction of moving (W,A,S,D)
	 */
	public void handleMove(String str) {
		if(str.equals("w")) {move(0, -movement);}
		else if(str.equals("a")) {move(-movementX, 0);}
		else if(str.equals("s")) {move(0, movement);}
		else if(str.equals("d")) {move(movementX, 0);}
	}
	
	/**
	 * <p> This method is called by {@link GameController#handleKeyPressedEvent(javafx.scene.input.KeyEvent)} when player presses key.
	 * 
	 * <p> If {@code noMove} is true, {@link Frog} will not move. Otherwise, it will change the image and call the function {@link #handleMove(String)}.
	 * 
	 * @param keyCode	The Key Text of player entered
	 */
	public void moveKeyPressed(String keyCode) {
		if (noMove) {}
		else {
			setImage(frogImages.get(keyCode + (second ? "1" : "2")));
			second = !second;
			handleMove(keyCode);
		}
	}
	
	/**
	 * <p> This method is called by {@link GameController#handleKeyReleasedEvent(javafx.scene.input.KeyEvent)} when player releases key. 
	 * <p> If {@code noMove} is true, {@link Frog} will not move. Otherwise, it will change the image and call the function {@link #handleMove(String)}.
	 * <p> If {@link Frog} moves upwards and the Y position is less than {@code w}, it will call the function {@link GameController#handleScoreChanged(int)} to change the socre of game.
	 * 
	 * @param keyCode	The Key Text of player entered
	 */
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
	
	/**
	 * <p>This method will do the following tasks:
	 *  1. check whether {@link Frog} has touched the wall
	 *  2. check whether {@link Frog} has touched the {@link End} or pool
	 *  3. Call {@link #handleDeath(long)} when touched the {@link Obstacle} or pool
	 *  
	 * <p> This method that will be called by {@link frogger.service.ActAnimation} in every frame to execute all above tasks.
	 */
	@Override
	public void act(long now) {
		checkAnimalWall();
		checkTouch();
		if(deathType != null) {handleDeath(now);}
	}
	
	/**
	 * <p> This method checks whether {@link Frog} has touched the {@link End} or pool and call {@link GameController} to handle consequences.
	 * 
	 * <p> When the {@link Frog} is intersected with {@link End}, it will call {@link GameController#handleEndTouched(MovableActor)}
	 * <br> When the {@link Frog} is sunk into pool, it will call {@link GameController#handlePoolTouched(MovableActor)}.
	 */
	@Override
	public void checkTouch() {
		if (getIntersectingObjects(End.class).size() >= 1) {
			GameController.INSTANCE.handleEndTouched(this);
		} else if(getY() < 438 && getIntersectingObjects(MovableActor.class).size() == 1) {
			GameController.INSTANCE.handlePoolTouched(this);		
		}
	}

	/**
	 * <p> This method checks whether {@link Frog} has touched the boundary of game stage and reset its position when touching the wall
	 */
	public void checkAnimalWall() {
		if (getY() > 734) {
			move(0,-movement*2);
		} else if (getX()<0) {
			move(movementX*2, 0);
		} else if (getX()>600) {
			move(-movementX*2, 0);
		}
	}
	
	/**
	 * <p> This method is called when {@link Frog} touch {@link Obstacle} or sunk into pool to handle the death situation.
	 * 
	 * <p> This method sets the {@link #noMove} to true to prohibit {@link Frog} move and incremental {@link #carD} which is used as index to change death image,
	 * And it calls {@link #handleCarDeath()} or {@link #handleWaterDeath()} based on the {@link #deathType} which is changed by {@link GameController}.
	 *
	 * @param now	The long type variable which will be used to calculate {@link #carD}
	 */
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
	
	/**
	 * <p> This method is called by {@link #handleDeath(long)} when the {@link #deathType} is set to "waterDeath" to handle the water death situation.
	 * 
	 * <p> This methods sets the death image depend on the index {@link #carD} and {@link #imageSize}. And if {@link #carD} is equal to 5,
	 * it will call {@link #setOrigin(int)} function to reset {@link Frog} and call {@link frogger.controller.GameController} to handle the socreChanged and lifeLosed consequences.
	 */
	public void handleWaterDeath() {
		if(carD == 5) {
			setOrigin(0);
			GameController.INSTANCE.handleScoreChanged(-50);
			GameController.INSTANCE.handleLifeLosed();
		}else if (carD > 0) {
			setImage(new Image(Main.class.getResourceAsStream(FileName.IMAGE_WATER_DEATH.get(carD-1)), imageSize, imageSize, true, true));
		}
	}
	
	/**
	 * <p> This method is called by {@link #handleDeath(long)} when the {@link #deathType} is set to "carDeath" to handle the car death situation.
	 * 
	 * <p> This methods sets the death image depend on the index {@link #carD} and {@link #imageSize}. And if {@link #carD} is equal to 4,
	 * it will call {@link #setOrigin(int)} function to reset {@link Frog} and call {@link frogger.controller.GameController} to handle the socreChanged and lifeLosed consequences.
	 */
	public void handleCarDeath() {
		if(carD == 4) {
			setOrigin(0);
			GameController.INSTANCE.handleScoreChanged(-50);
			GameController.INSTANCE.handleLifeLosed();
		}else if(carD > 0) {
			setImage(new Image(Main.class.getResourceAsStream(FileName.IMAGE_CAR_DEATH.get(carD-1)), imageSize, imageSize, true, true));
		}
	}

	/**
	 * <p> This method initialization frog position and status.
	 * <p> This method is called when death happens or enter into end position
	 * 
	 * @param status	status == 1 means enter into end position or at the begining of playing; status == 0 means face death event
	 */
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

	/**
	 * <p> This method is called by {@link GameController#handlePoolTouched(MovableActor)} or {@link GameController#handleObstacleTouched(MovableActor)} when death happens.
	 * <p> deathType is set to carDeather when touch the {@link Obstacle} or set to waterDeath when touch the pool
	 * 
	 * @param str	An string of {@link deathType} is set to {@code str}
	 */
	public void setDeathType(String str) {
		deathType = str;
	}
}
