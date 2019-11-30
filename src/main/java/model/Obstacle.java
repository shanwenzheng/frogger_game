package model;

public class Obstacle extends MovableActor {
	
	public Obstacle(String imageLink, int size, double  xpos, double  ypos, double  s) {
		super(imageLink, size, xpos, ypos, s);
	}
	
	@Override
	public void act(long now) {
		move(getSpeed(), 0);
		checkWall(getSpeed(),-50,-200,600);
	}
}
