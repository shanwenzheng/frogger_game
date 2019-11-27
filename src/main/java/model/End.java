package model;


import frogger.Main;
import javafx.scene.image.Image;

public class End extends StaticActor{
	boolean activated = false;
	
	public End(String imageLink, int size, int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image(Main.class.getResourceAsStream(imageLink), size, size, true, true));
	}
	
	public void setEnd() {
		setImage(new Image(Main.class.getResourceAsStream("images/FrogEnd.png"), 70, 70, true, true));
		activated = true;
	}
	
	public boolean isActivated() {
		return activated;
	}
	

}
