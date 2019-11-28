package model;

public abstract class MovableActor extends Actor{
	
	private double speed;
	
	public MovableActor() {};
	
	public MovableActor(double xpos, double ypos, double s) {
		super(xpos, ypos);
		speed = s;
	}
	
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
    
	public void checkWall(double speed, int leftPos, int newLeftPos, int newRightPos){
		if(getX() > 600 && speed > 0)
			setX(newLeftPos);
		if(getX() < leftPos && speed < 0)
			setX(newRightPos);
	}
    
    public double getSpeed() {
    	return speed;
    }
    
    public abstract void act(long now);
}
