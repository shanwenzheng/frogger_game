package model.log;

import frogger.Main;
import javafx.scene.image.Image;

public class MediumLog extends Log{
		
	public MediumLog(int size, double xpos, double ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image(Main.class.getResourceAsStream("images/log2.png"), size, size, true, true));
	}
}