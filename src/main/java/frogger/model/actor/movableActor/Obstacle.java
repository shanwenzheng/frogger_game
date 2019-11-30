package frogger.model.actor.movableActor;

import frogger.Main;
import frogger.controller.GameController;
import javafx.scene.image.Image;

public class Obstacle extends MovableActor {
	
	public Obstacle(String imageLink, int size, double  xpos, double  ypos, double  s) {
		super(xpos, ypos, s);
		setImage(new Image(Main.class.getResourceAsStream(imageLink), size, size, true, true));
	}
	
	@Override
	public void act(long now) {
		move(getSpeed(), 0);
		checkWall(getSpeed(),-50,-200,600);
		checkTouch();
	}
	
	@Override
	public void checkTouch() {
		if(getIntersectingObjects(Frog.class).size() >= 1) {
			GameController.INSTANCE.handleObstacleTouched(this);
		}
	}
}
