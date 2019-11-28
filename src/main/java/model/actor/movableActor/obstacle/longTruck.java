package model.actor.movableActor.obstacle;

import frogger.Main;
import javafx.scene.image.Image;

public class longTruck extends Obstacle{
	
	public longTruck(int size, double xpos, double ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image(Main.class.getResourceAsStream("images/truck2" + (s < 0 ? "Left" : "Right") + ".png"), size, size, true, true));
	}
}
