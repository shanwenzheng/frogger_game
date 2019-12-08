package frogger.model.actor;

import frogger.model.actor.staticActor.StaticActor;
import javafx.scene.image.ImageView;

/**
 * <h2> Actor </h2>
 * 
 * <p> The {@link Actor} class is an <strong><i> abstract </i></strong> class contains the shared constructor which set the position of actor instance
 * 
 * <p><strong> Note: </strong>: {@link Actor} classes are not allowed to be instantiated thus it's need to be extended
 * 
 * <p> <Strong> Note: </strong> This class extends {@link ImageView} abstract class.
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @See StaticActor
 * @See MovableActor
 * @See End
 * @See Digit
 * @See Frog
 * @See Obstacle
 * @See Log
 * @See Turtle
 * @See WetTurtle
 * @See ImageView
 */
public abstract class Actor extends ImageView{
	
	/** The constructor of {@link Actor} class do nothing and only used to be extended */
	public Actor() {};
	
	/**
	 * <p> The constructor of {@link Actor} class to set the position of instance and only worked when the class is extended.
	 * <p> Using this constructor need to call the  function of super().
	 * 
	 * @param x		the X position of object
	 * @param y		the Y position of object
	 */
	public Actor(double  x, double  y) {
		setX(x);
		setY(y);
	}
}
