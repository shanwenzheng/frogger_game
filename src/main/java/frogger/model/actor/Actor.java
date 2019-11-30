package frogger.model.actor;

import javafx.scene.image.ImageView;

public abstract class Actor extends ImageView{
	
	public Actor() {};
	
	public Actor(double  x, double  y) {
		setX(x);
		setY(y);
	}
}
