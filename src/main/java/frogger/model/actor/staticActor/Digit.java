package frogger.model.actor.staticActor;

import frogger.Main;
import frogger.constant.FileName;
import javafx.scene.image.Image;

public class Digit extends StaticActor{
	
	private int size;
	
	public Digit(int n, int size, double  x, double  y) {
		super(x, y);
		this.size = size;
		setImage(new Image(Main.class.getResourceAsStream(FileName.IMAGE_DIGIT.get(n)), size, size, true, true));
	}
	
	public void changeScore(int n) {
		setImage(new Image(Main.class.getResourceAsStream(FileName.IMAGE_DIGIT.get(n)), size, size, true, true));
	}
}

