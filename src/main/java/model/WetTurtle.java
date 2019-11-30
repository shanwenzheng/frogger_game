package model;

import java.util.ArrayList;

import frogger.Main;
import javafx.scene.image.Image;

public class WetTurtle extends MovableActor{
	
	private ArrayList<Image> wetturtleImages;	
	private boolean sunk = false;
	
	public WetTurtle(int size, double  xpos, double  ypos, double  s) {
		super(xpos, ypos, s);
		wetturtleImages = new ArrayList<Image>() {{
			add(new Image(Main.class.getResourceAsStream("images/TurtleAnimation2Wet.png"), size, size, true, true));
			add(new Image(Main.class.getResourceAsStream("images/TurtleAnimation1.png"), size, size, true, true));
			add(new Image(Main.class.getResourceAsStream("images/TurtleAnimation3Wet.png"), size, size, true, true));
			add(new Image(Main.class.getResourceAsStream("images/TurtleAnimation4Wet.png"), size, size, true, true));
		}};
		setImage(wetturtleImages.get(0));
	}
	
	@Override
	public void act(long now) {
		changeWetturtleImage((int) (now/900000000  % 4));
		move(getSpeed(), 0);
		checkWall(getSpeed(),-75,-200,600);
	}
	
	public void changeWetturtleImage(int index) {
		setImage(wetturtleImages.get(index));
		sunk = index == 3 ? true : false;
	}
	
	public boolean isSunk() {
		return sunk;
	}
}
