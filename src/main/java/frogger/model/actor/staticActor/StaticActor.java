package frogger.model.actor.staticActor;

import frogger.model.actor.Actor;

/**
 * <h2> StaticActor </h2>
 * 
 * <p> The {@link StaticActor} class is an <strong><i> abstract </i></strong> class contains the shared constructor which set the position of StaticActor instance
 * 
 * <p><strong> Note: </strong>: {@link StaticActor} classes are not allowed to be instantiated thus it's need to be extended
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see Actor
 * @see End
 * @see Digit
 */
public abstract class StaticActor extends Actor{
	
	/** The constructor of {@link StaticActor} class do nothing and only used to be extended */
	public StaticActor() {};
	
	/**
	 * <p> The constructor of {@link StaticActor} class to set the position of instance and only worked when the class is extended.
	 * <p> Using this constructor need to call the  function of super().
	 * 
	 * @param x		the X position of object
	 * @param y		the Y position of object
	 */
	public StaticActor(double  x, double  y) {
		super(x, y);
	}
}
