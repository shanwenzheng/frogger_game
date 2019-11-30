package frogger.model.actor;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

import frogger.Main;


public abstract class Actor extends ImageView{
	
	public Actor(double  x, double  y) {
		setX(x);
		setY(y);
	}

    public Pane getWorld() {
        return (Pane) getParent();
    }

    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }

    public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
    	ArrayList<A> someArray = (ArrayList<A>) getIntersectingObjects(cls);
        return someArray.get(0);
    }
    
    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getWorld().getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }

}
