package model.actor.staticActor;

import javafx.scene.image.Image;

public class Digit extends StaticActor{

	public Digit(int n, int dim, double  x, double  y) {
		super("images/"+n+".png", dim, x, y);
	}
}
