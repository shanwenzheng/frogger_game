package frogger.model.actor.movableActor;

import java.util.ArrayList;

import frogger.Main;
import frogger.controller.GameController;
import javafx.scene.image.Image;

public class Turtle extends MovableActor{
	
	private ArrayList<Image> turtleImages;
	
	public Turtle(int size, double  xpos, double  ypos, double  s) {
		super(xpos, ypos, s);
		turtleImages = new ArrayList<Image>() {{
			add(new Image(Main.class.getResourceAsStream("images/TurtleAnimation2.png"), size, size, true, true));
			add(new Image(Main.class.getResourceAsStream("images/TurtleAnimation1.png"), size, size, true, true));
			add(new Image(Main.class.getResourceAsStream("images/TurtleAnimation3.png"), size, size, true, true));
		}};
		setImage(turtleImages.get(0));
	}

	@Override
	public void act(long now) {
		setImage(turtleImages.get((int) (now/900000000  % turtleImages.size())));
		move(getSpeed(), 0);
		checkWall(getSpeed(),-75,-200,600);
		checkTouch();
	}
	
	@Override
	public void checkTouch() {
		if(getIntersectingObjects(Frog.class).size() >= 1) {
			GameController.INSTANCE.handleLogTurtleTouched(this);
		}
	}
}
