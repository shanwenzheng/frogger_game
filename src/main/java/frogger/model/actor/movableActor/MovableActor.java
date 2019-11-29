package frogger.model.actor.movableActor;

import java.util.ArrayList;

import frogger.model.actor.Actor;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public abstract class MovableActor extends Actor{
	
	private double speed;
	
	public MovableActor(double xpos, double ypos, double s) {
		super(xpos, ypos);
		speed = s;
	}
	
	public void move(double dx, double dy) {
	    setX(getX() + dx);
	    setY(getY() + dy);
	}
    
	public void checkWall(double speed, int leftPos, int newLeftPos, int newRightPos){
		if(getX() > 600 && speed > 0)
			setX(newLeftPos);
		if(getX() < leftPos && speed < 0)
			setX(newRightPos);
	}
    
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for(Node n : ((Pane)getParent()).getChildren()) {
        	if(cls.isInstance(n) && n.intersects(this.getBoundsInLocal())) {
        		someArray.add((A)n);
        	}
        }
        return someArray;
    }
    
    public double getSpeed() {
    	return speed;
    }
    
    public abstract void act(long now);
    public abstract void checkTouch();
}
