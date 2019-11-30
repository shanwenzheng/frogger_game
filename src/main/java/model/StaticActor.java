package model;

public abstract class StaticActor extends Actor{
	
	public StaticActor(String imageLink, int size, double  x, double  y) {
		super(imageLink, size, x, y);
	}
	
	public StaticActor() {};
}
