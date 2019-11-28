package model.log;

import model.MovableActor;

public class Log extends MovableActor {
	
	public Log(double  xpos, double  ypos, double s) {
		super(xpos, ypos, s);
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
