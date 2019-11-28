package model.actor.movableActor.log;

import frogger.Main;
import javafx.scene.image.Image;

public class ShortLog extends Log{

	public ShortLog(int size, double xpos, double ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image(Main.class.getResourceAsStream("images/log3.png"), size, size, true, true));
	}
	
}
