package model.actor.movableActor.obstacle;

import frogger.Main;
import javafx.scene.image.Image;

public class shortTruck extends Obstacle{

	public shortTruck(int size, double xpos, double ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image(Main.class.getResourceAsStream("images/truck1" + (s < 0 ? "Left" : "Right") + ".png"), size, size, true, true));
	}
}
