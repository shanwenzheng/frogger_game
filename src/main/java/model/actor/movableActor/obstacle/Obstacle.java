package model.actor.movableActor.obstacle;

import model.actor.movableActor.MovableActor;

public abstract class Obstacle extends MovableActor {
	
	public Obstacle(double  xpos, double  ypos, double  s) {
		super(xpos, ypos, s);
	}
	
	@Override
	public void act(long now) {
		move(getSpeed(), 0);
		checkWall(getSpeed(),-50,-200,600);
	}
}
