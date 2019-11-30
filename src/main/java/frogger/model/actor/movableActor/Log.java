package frogger.model.actor.movableActor;

import frogger.Main;
import frogger.controller.GameController;
import javafx.scene.image.Image;

public class Log extends MovableActor {
	
	public Log(String imageLink, int size, double  xpos, double  ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image(Main.class.getResourceAsStream(imageLink), size, size, true, true));
	}
	
	@Override
	public void act(long now) {
		move(getSpeed(), 0);
		checkWall(getSpeed(),-300,-180,700);
		checkTouch();
	}
	
	@Override
	public void checkTouch() {
		if(getIntersectingObjects(Frog.class).size() >= 1) {
			GameController.INSTANCE.handleLogTurtleTouched(this);
		}
	}
}
