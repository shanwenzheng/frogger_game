package model;

import javafx.scene.image.Image;

public class Digit extends StaticActor{

	public Digit(int n, int dim, double  x, double  y) {
		super("file:resources/images/"+n+".png", dim, x, y);
	}
}
