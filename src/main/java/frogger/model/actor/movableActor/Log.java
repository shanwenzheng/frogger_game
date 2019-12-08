package frogger.model.actor.movableActor;

import frogger.Main;
import frogger.controller.GameController;
import javafx.scene.image.Image;

/**
 * <h2> Log </h2>
 * 
 * <p> The {@link Log} class is used to create the Log object.
 * 
 * <p> A {@link Log} object is set in {@link frogger.model.Map}. It can move with the constant speed as time goes on.
 * In each frame, this object also check the wall touch and check whether there are animal intersect with it.
 * When it touches the {@link Frog}, it will ask {@link GameController} to handle some consequences.
 *
 * <p> <Strong> Note: </strong> This class extends {@link MovableActor} abstract class and implements {@link MovableActor#act(long)} and {@link MovableActor#checkTouch()}.
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see frogger.model.Map
 * @see MovableActor
 * @see GameController
 * @see Frog
 */
public class Log extends MovableActor {
	
	/**
	 * <p> The constructor of {@link Log} class to generate instance
	 * 
	 * <p> This constructor sets the {@link Log} in the given position {@code x} and {@code y} in the {@link frogger.model.Map}.
	 * Set the constant speed in the given {@code speed}.
	 * Set the initial image with the given {@code size}. 
	 * 
	 * @param imageLink	The path of image needed to be set to {@link Log}
	 * @param size		The size of the image
	 * @param xpos		The position of x in the {@link frogger.model.Map} where digit stays
	 * @param ypos		The position of y in the {@link frogger.model.Map} where digit stays
	 * @param s			The speed of {@link Log} movement
	 */
	public Log(String imageLink, int size, double  xpos, double  ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image(Main.class.getResourceAsStream(imageLink), size, size, true, true));
	}
	
	/**
	 * <p>This method will do the following tasks:
	 *  1. move the {@link Log}
	 *  2. check whether {@link Log} has touched the right or left wall
	 *  3. check whether {@link Log} has touched the {@link Frog}
	 *  
	 * <p> This method that will be called by {@link frogger.service.ActAnimation} in every frame to execute all above tasks.
	 */
	@Override
	public void act(long now) {
		move(getSpeed(), 0);
		checkWall(getSpeed(),-300,-180,700);
		checkTouch();
	}
	
	/**
	 * <p> This method checks whether {@link Log} has touched the {@link Frog} and call {@link GameController} to handle consequences.
	 * 
	 * <p> When the {@link Log} is intersected with {@link Frog}, it will call {@link GameController#handleLogTurtleTouched(MovableActor)}
	 */
	@Override
	public void checkTouch() {
		if(getIntersectingObjects(Frog.class).size() >= 1) {
			GameController.INSTANCE.handleLogTurtleTouched(this);
		}
	}
}
