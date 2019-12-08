package frogger.model.actor.movableActor;

import java.util.ArrayList;

import frogger.model.actor.Actor;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * <h2> MovableActor </h2>
 * 
 * <p> The {@link MovableActor} class is an <strong><i> abstract </i></strong> class contains the shared constructor and method
 * 
 * <p> The {@link MovableActor} class contains the constructor to set the initial position of instance, the {@link MovableActor#move(double, double)} controls the move of instance,
 * the {@link MovableActor#checkWall(double, int, int, int)} method to check the boundary of move. The {@link MovableActor#getIntersectingObjects(Class)} method which return the arrayList contains the {@link MovableActor} instances touched.
 * Also two abstract method {@link MovableActor#act(long)} and {@link MovableActor#checkTouch()} needed to be extended.
 * 
 * <p><strong> Note: </strong>: {@link MovableActor} classes are not allowed to be instantiated thus it's need to be extended
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @See Actor
 * @See Frog
 * @See Log
 * @See Obstacle
 * @See Turtle
 * @See WetTurtle
 */
public abstract class MovableActor extends Actor{
	
	/** <p>The speed of objects auto-move */
	private double speed;
	
	/** The constructor of {@link MovableActor} class do nothing and only used to be extended */
	public MovableActor() {};
	
	/**
	 * <p> The constructor of {@link MovableActor} class to set the position of instance and the speed of instance.
	 * <p> Using this constructor need to call the  function of super().
	 * 
	 * @param xpos		the X position of object
	 * @param ypos		the Y position of object
	 * @param s			the speed of object
	 */
	public MovableActor(double xpos, double ypos, double s) {
		super(xpos, ypos);
		speed = s;
	}
	
	/**
	 * <p> Controls the automatic movement of object.
	 * <p> This method will be called in {@link MovableActor#act(long)} in every frame
	 * 
	 * @param dx	The distance of X position of each move
	 * @param dy	The distance of Y position of each move
	 */
	public void move(double dx, double dy) {
	    setX(getX() + dx);
	    setY(getY() + dy);
	}
    
	/**
	 * <p> Check the wall touch condition and reset the position of object.
	 * <p> This method will be called in {@link MovableActor#act(long)} in every frame.
	 * <p> This function will do the following task: If the object move right and touch the right wall, set its X position to {@code newLeftPos},
	 * If the object move left and touch the left wall, set its X position to {@code newRightPos}.
	 * 
	 * @param speed			The speed of object. This parameter used to check the direction of object moving
	 * @param leftPos		The left boundary of object moving
	 * @param newLeftPos	The	new X position of object when touching the right wall
	 * @param newRightPos	The new Y position of object when touching the left wall
	 */
	public void checkWall(double speed, int leftPos, int newLeftPos, int newRightPos){
		if(getX() > 600 && speed > 0)
			setX(newLeftPos);
		if(getX() < leftPos && speed < 0)
			setX(newRightPos);
	}
    
	/**
	 * <p> returns all the instances that collide with instance who call this method and the class of those instances is {@code cls}.
	 * 
	 * @param <A>	The class extend from {@link Actor}
	 * @param cls	All the instance that collide with the instance who call this method
	 * @return		A {@link List} contains all the instances that collide with instance who call this method and the class of those instances is {@code cls}
	 */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for(Node n : ((Pane)getParent()).getChildren()) {
        	if(cls.isInstance(n) && n.intersects(this.getBoundsInLocal())) {
        		someArray.add((A)n);
        	}
        }
        return someArray;
    }
    
	/** 
	 * Returns the {@link #speed} in this {@link MovableActor}. 
	 * 
	 * @return the {@link #speed} in this {@link MovableActor}. 
	 */
    public double getSpeed() {
    	return speed;
    }
    
    /**
     * <p>An abstract method that will be called by {@link ActAnimation} in every frame to perfrom some operation.
     * <p><strong> Note: </strong>This is an abstract method and is designed to be overridden in the subclass of {@link MovableActor}</strong>
     * 
     * @param now	The current time of calling method.
     */
    public abstract void act(long now);
    
    /**
     * <p> An abstract method that will check the touch of other object (e.g., {@link Log} will call this method to check whether touch with {@link Frog}).
     * <p><strong> Note: </strong>This is an abstract method and is designed to be overridden in the subclass of {@link MovableActor}</strong>
     */
    public abstract void checkTouch();
}
