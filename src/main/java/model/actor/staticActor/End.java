package model.actor.staticActor;

import frogger.Main;
import javafx.scene.image.Image;

public class End extends StaticActor{
	private boolean activated = false;
	
	public End(String imageLink, int size, double  x, double  y) {
		super(imageLink, size, x, y);
	}
	
	public void setEnd() {
		setImage(new Image(Main.class.getResourceAsStream("images/FrogEnd.png"), 70, 70, true, true));
		activated = true;
	}
	
	public boolean isActivated() {
		return activated;
	}
}
