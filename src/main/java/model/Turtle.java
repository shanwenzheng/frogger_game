package model;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class Turtle extends MovableActor{
	private ArrayList<Image> turtleImages;	
	
	public Turtle(int size, double  xpos, double  ypos, double  s) {
		super(xpos, ypos, s);
		turtleImages = new ArrayList<Image>() {{
			add(new Image("file:resources/images/TurtleAnimation2.png", size, size, true, true));
			add(new Image("file:resources/images/TurtleAnimation1.png", size, size, true, true));
			add(new Image("file:resources/images/TurtleAnimation3.png", size, size, true, true));
		}};
		setImage(turtleImages.get(0));
	}
	
	@Override
	public void act(long now) {
		changeTurtleImage((int) (now/900000000  % 3));
		move(getSpeed(), 0);
		checkWall(getSpeed(),-75,-200,600);
	}
	
	public void changeTurtleImage(int index) {
		setImage(turtleImages.get(index));
	}
}
