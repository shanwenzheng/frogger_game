package frogger.model.actor.movableActor.animal;

import frogger.Main;
import javafx.scene.image.Image;


public class Frog extends Animal {
	
	public Frog(int size, double xpos, double ypos) {
		super(size, xpos, ypos, 0);
		setImage(new Image(Main.class.getResourceAsStream("images/froggerUp.png"), size, size, true, true));
		getAnimalImages().put("w1",new Image(Main.class.getResourceAsStream("images/froggerUp.png"), size, size, true, true));
		getAnimalImages().put("a1",new Image(Main.class.getResourceAsStream("images/froggerLeft.png"), size, size, true, true));
		getAnimalImages().put("s1",new Image(Main.class.getResourceAsStream("images/froggerDown.png"), size, size, true, true));
		getAnimalImages().put("d1",new Image(Main.class.getResourceAsStream("images/froggerRight.png"), size, size, true, true));
		getAnimalImages().put("w2",new Image(Main.class.getResourceAsStream("images/froggerUpJump.png"), size, size, true, true));
		getAnimalImages().put("a2",new Image(Main.class.getResourceAsStream("images/froggerLeftJump.png"), size, size, true, true));
		getAnimalImages().put("s2",new Image(Main.class.getResourceAsStream("images/froggerDownJump.png"), size, size, true, true));
		getAnimalImages().put("d2",new Image(Main.class.getResourceAsStream("images/froggerRightJump.png"), size, size, true, true));
	}
}
