package model.log;

import frogger.Main;
import javafx.scene.image.Image;

public class LongLog extends Log{
	
	public LongLog(int size, double xpos, double ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image(Main.class.getResourceAsStream("images/logs.png"), size, size, true, true));
	}
}