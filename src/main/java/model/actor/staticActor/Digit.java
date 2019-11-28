package model.actor.staticActor;

import frogger.Main;
import javafx.scene.image.Image;

public class Digit extends StaticActor{

	public Digit(int n, int size, double  x, double  y) {
		super(x, y);
		setImage(new Image(Main.class.getResourceAsStream("images/" + n + ".png"), size, size, true, true));
	}
}
