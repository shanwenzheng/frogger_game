package model;


import frogger.Main;
import javafx.scene.image.Image;

public class Digit extends StaticActor{
	int dim;
	Image im1;

	
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image(Main.class.getResourceAsStream("images/"+n+".png"), dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
}
