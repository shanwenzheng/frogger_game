package frogger.model.actor.movableActor;

import java.util.ArrayList;

import frogger.Main;
import frogger.constant.FileName;
import frogger.controller.GameController;
import javafx.scene.image.Image;

/**
 * <h2> WetTurtle </h2>
 * 
 * <p> The {@link WetTurtle} class is used to create the WetTurtle object.
 * 
 * <p> A {@link WetTurtle} object is set in {@link Map}. It can move with the constant speed and change the image as time goes on.
 * In each frame, this object also check the wall touch and check whether there are animal intersect with it.
 * When it touches the {@link Frog}, it will ask {@link GameController} to handle some consequences.
 *
 * <p> <Strong> Note: </strong> This class extends {@link MovableActor} abstract class and implements {@link MovableActor#act(long)} and {@link MovableActor#checkTouch()}.
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @See Map
 * @See MovableActor
 * @See GameController
 * @See Frog
 */
public class WetTurtle extends MovableActor{
	
	/** An {@link ArrayList} which contains all the images that {@link WetTurtle} will change with time goes on */
	private ArrayList<Image> wetTurtleImages;
	/** The flag recording whether the {@link WetTurtle} has undered into water */
	private boolean sunk = false;
	
	/**
	 * <p> The constructor of {@link WetTurtle} class to generate instance
	 * 
	 * <p> This constructor sets the {@link WetTurtle} in the given position {@code x} and {@code y} in the {@link Map}.
	 * Set the constant speed in the given {@code speed}.
	 * Set the initial image with the given {@code size}. 
	 * And initialize the {@link ArrayList} image which contains all the different shapes of {@link WetTurtle}
	 * 
	 * @param size		The size of the image
	 * @param xpos		The position of x in the {@link Map} where digit stays
	 * @param ypos		The position of y in the {@link Map} where digit stays
	 * @param s			The speed of {@link WetTurtle} movement
	 */
	public WetTurtle(int size, double  xpos, double  ypos, double  s) {
		super(xpos, ypos, s);
		wetTurtleImages = new ArrayList<Image>() {{
			add(new Image(Main.class.getResourceAsStream(FileName.IMAGE_WETTURTLE.get(1)), size, size, true, true));
			add(new Image(Main.class.getResourceAsStream(FileName.IMAGE_WETTURTLE.get(0)), size, size, true, true));
			add(new Image(Main.class.getResourceAsStream(FileName.IMAGE_WETTURTLE.get(2)), size, size, true, true));
			add(new Image(Main.class.getResourceAsStream(FileName.IMAGE_WETTURTLE.get(3)), size, size, true, true));
		}};
		setImage(wetTurtleImages.get(0));
	}

	/**
	 * <p>This method will do the following tasks:
	 *  1. change the image of {@link WetTurtle} as time goes on.
	 *  2. set sunk to true if {@link WetTurtle} has sunk into water
	 *  3. move the {@link WetTurtle}
	 *  4. check whether {@link WetTurtle} has touched the right or left wall
	 *  5. check whether {@link WetTurtle} has touched the {@link Frog}
	 *  
	 * <p> This method that will be called by {@link ActAnimation} in every frame to execute all above tasks.
	 */
	@Override
	public void act(long now) {
		int index = (int) (now/900000000  % wetTurtleImages.size());
		setImage(wetTurtleImages.get(index));
		sunk = (index == 3);
		
		move(getSpeed(), 0);
		checkWall(getSpeed(),-75,-200,600);
		checkTouch();
	}
	
	/**
	 * <p> This method checks whether {@link WetTurtle} has touched the {@link Frog} and call {@link GameController} to handle consequences.
	 * 
	 * <p> When the {@link WetTurtle} is sunk, it will call {@link GameController#handlePoolTouched(MovableActor)}
	 * <br> When the {@link WetTurtle} is not sunk, it will call {@link GameController#handleLogTurtleTouched(MovableActor)}.
	 */
	@Override
	public void checkTouch() {
		if(getIntersectingObjects(Frog.class).size() >= 1) {
			if(sunk) {
				GameController.INSTANCE.handlePoolTouched(this);
			}else {
				GameController.INSTANCE.handleLogTurtleTouched(this);
			}
		}
	}
}
