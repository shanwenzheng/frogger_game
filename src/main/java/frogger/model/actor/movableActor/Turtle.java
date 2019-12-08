package frogger.model.actor.movableActor;

import java.util.ArrayList;

import frogger.Main;
import frogger.constant.FileName;
import frogger.controller.GameController;
import javafx.scene.image.Image;

/**
 * <h2> Turtle </h2>
 * 
 * <p> The {@link Turtle} class is used to create the Turtle object.
 * 
 * <p> A {@link Turtle} object is set in {@link frogger.model.Map}. It can move with the constant speed and change the image as time goes on.
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
public class Turtle extends MovableActor{
	
	/** An {@link ArrayList} which contains all the images that {@link Turtle} will change with time goes on */
	private ArrayList<Image> turtleImages;
	
	/**
	 * <p> The constructor of {@link Turtle} class to generate instance
	 * 
	 * <p> This constructor sets the {@link Turtle} in the given position {@code x} and {@code y} in the {@link frogger.model.Map}.
	 * Set the constant speed in the given {@code speed}.
	 * Set the initial image with the given {@code size}. 
	 * And initialize the {@link ArrayList} image which contains all the different shapes of {@link Turtle}
	 * 
	 * @param size		The size of the image
	 * @param xpos		The position of x in the {@link frogger.model.Map} where digit stays
	 * @param ypos		The position of y in the {@link frogger.model.Map} where digit stays
	 * @param s			The speed of {@link Turtle} movement
	 */
	public Turtle(int size, double  xpos, double  ypos, double  s) {
		super(xpos, ypos, s);
		turtleImages = new ArrayList<Image>() {{
			add(new Image(Main.class.getResourceAsStream(FileName.IMAGE_TURTLE.get(1)), size, size, true, true));
			add(new Image(Main.class.getResourceAsStream(FileName.IMAGE_TURTLE.get(0)), size, size, true, true));
			add(new Image(Main.class.getResourceAsStream(FileName.IMAGE_TURTLE.get(2)), size, size, true, true));
		}};
		setImage(turtleImages.get(0));
	}

	/**
	 * <p>This method will do the following tasks:
	 *  1. change the image of {@link Turtle} as time goes on.
	 *  2. move the {@link Turtle}
	 *  3. check whether {@link Turtle} has touched the right or left wall
	 *  4. check whether {@link Turtle} has touched the {@link Frog}
	 *  
	 * <p> This method that will be called by {@link frogger.service.ActAnimation} in every frame to execute all above tasks.
	 */
	@Override
	public void act(long now) {
		int index = (int) (now/900000000  % turtleImages.size());
		setImage(turtleImages.get(index));
		
		move(getSpeed(), 0);
		checkWall(getSpeed(),-75,-200,600);
		checkTouch();
	}
	
	/**
	 * <p> This method checks whether {@link Turtle} has touched the {@link Frog} and call {@link GameController} to handle consequences.
	 * 
	 * <p> When the {@link Turtle} is intersected with {@link Frog}, it will call {@link GameController#handleLogTurtleTouched(MovableActor)}
	 */
	@Override
	public void checkTouch() {
		if(getIntersectingObjects(Frog.class).size() >= 1) {
			GameController.INSTANCE.handleLogTurtleTouched(this);
		}
	}
}
