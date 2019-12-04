package frogger.model.actor.movableActor;

import java.util.ArrayList;

import frogger.Main;
import frogger.constant.FileName;
import frogger.controller.GameController;
import javafx.scene.image.Image;

public class WetTurtle extends MovableActor{
	
	private ArrayList<Image> wetTurtleImages;
	private boolean sunk = false;
	
	public WetTurtle(int size, double  xpos, double  ypos, double  s) {
		super(xpos, ypos, s);
		wetTurtleImages = new ArrayList<Image>() {{
			add(new Image(Main.class.getResourceAsStream(FileName.IMAGE_WETTURTLE.get(1)), size, size, true, true));
			add(new Image(Main.class.getResourceAsStream(FileName.IMAGE_WETTURTLE.get(0)), size, size, true, true));
			add(new Image(Main.class.getResourceAsStream(FileName.IMAGE_WETTURTLE.get(2)), size, size, true, true));
			add(new Image(Main.class.getResourceAsStream(FileName.IMAGE_WETTURTLE.get(3)), size, size, true, true));
		}};
		setImage(wetTurtleImages.get(0));
	}

	@Override
	public void act(long now) {
		int index = (int) (now/900000000  % wetTurtleImages.size());
		setImage(wetTurtleImages.get(index));
		sunk = (index == 3);
		
		move(getSpeed(), 0);
		checkWall(getSpeed(),-75,-200,600);
		checkTouch();
	}
	
	@Override
	public void checkTouch() {
		if(getIntersectingObjects(Frog.class).size() >= 1) {
			if(sunk) {
				GameController.INSTANCE.handlePoolTouched(this);
			}else {
				GameController.INSTANCE.handleLogTurtleTouched(this);
			}
		}
	}
}
