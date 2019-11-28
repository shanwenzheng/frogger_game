package model.turtle;

import frogger.Main;
import javafx.scene.image.Image;

public class WetTurtle extends Turtle{
	
	private boolean sunk = false;
	
	public WetTurtle(int size, double  xpos, double  ypos, double  s) {
		super(xpos, ypos, s);
		this.getTurtleImages().add(new Image(Main.class.getResourceAsStream("images/TurtleAnimation2Wet.png"), size, size, true, true));
		this.getTurtleImages().add(new Image(Main.class.getResourceAsStream("images/TurtleAnimation1.png"), size, size, true, true));
		this.getTurtleImages().add(new Image(Main.class.getResourceAsStream("images/TurtleAnimation3Wet.png"), size, size, true, true));
		this.getTurtleImages().add(new Image(Main.class.getResourceAsStream("images/TurtleAnimation4Wet.png"), size, size, true, true));
		setImage(getTurtleImages().get(0));
	}
	
	public void changeWetturtleImage(int index) {
		setImage(getTurtleImages().get(index));
		sunk = index == 3 ? true : false;
	}
	
	public boolean isSunk() {
		return sunk;
	}
}
