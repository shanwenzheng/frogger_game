package model;

import javafx.scene.image.Image;

public class Log extends MovableActor {
	
	public Log(String imageLink, int size, double  xpos, double  ypos, double s) {
		super(imageLink, size, xpos, ypos, s);
	}
	
	@Override
	public void act(long now) {
		move(getSpeed(), 0);
		checkWall(getSpeed(),-300,-180,700);
	}
	
	public boolean getLeft() {
		return this.getSpeed() < 0;
	}
}
