package frogger.model.actor.movableActor.turtle;

import java.util.ArrayList;

import frogger.model.actor.movableActor.MovableActor;
import javafx.scene.image.Image;

public abstract class Turtle extends MovableActor {
	private ArrayList<Image> turtleImages;
	
	public Turtle(double  xpos, double  ypos, double  s) {
		super(xpos, ypos, s);
		turtleImages = new ArrayList<Image>();
	}

	@Override
	public void act(long now) {
		changeTurtleImage((int) (now/900000000  % turtleImages.size()));
		move(getSpeed(), 0);
		checkWall(getSpeed(),-75,-200,600);
	}
	
	public ArrayList<Image> getTurtleImages(){
		return turtleImages;
	}
	
	public abstract void changeTurtleImage(int index);
}
