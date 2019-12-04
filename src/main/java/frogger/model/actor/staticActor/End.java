package frogger.model.actor.staticActor;

import frogger.Main;
import frogger.constant.FileName;
import javafx.scene.image.Image;

public class End extends StaticActor{
	private boolean activated = false;
	private Image frogEnd;
	
	public End(int size, double  x, double  y) {
		super(x, y);
		setImage(new Image(Main.class.getResourceAsStream(FileName.IMAGE_END), size, size, true, true));
		frogEnd = new Image(Main.class.getResourceAsStream(FileName.IMAGE_END_FROG), size + 10, size + 10, true, true);
	}
	
	public void setEnd() {
		setImage(frogEnd);
		activated = true;
	}
	
	public boolean isActivated() {
		return activated;
	}
}
