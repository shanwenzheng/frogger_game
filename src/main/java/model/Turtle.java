package model;


import frogger.Main;
import javafx.scene.image.Image;

public class Turtle extends MovableActor{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	private int speed;
	int i = 1;
	boolean bool = true;
	@Override
	public void act(long now) {

				if (now/900000000  % 3 ==0) {
					setImage(turtle2);
					
				}
				else if (now/900000000 % 3 == 1) {
					setImage(turtle1);
					
				}
				else if (now/900000000 %3 == 2) {
					setImage(turtle3);
					
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	public Turtle(int size, int xpos, int ypos, int s) {
		turtle1 = new Image(Main.class.getResourceAsStream("images/TurtleAnimation1.png"), size, size, true, true);
		turtle2 = new Image(Main.class.getResourceAsStream("images/TurtleAnimation2.png"), size, size, true, true);
		turtle3 = new Image(Main.class.getResourceAsStream("images/TurtleAnimation3.png"), size, size, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
}
