package frogger.model.actor.movableActor.obstacle;

import frogger.Main;
import javafx.scene.image.Image;

public class car extends Obstacle {

	public car(int size, double xpos, double ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image(Main.class.getResourceAsStream("images/car1" + (s < 0 ? "Left" : "Right") + ".png"), size, size, true, true));
	}

}

