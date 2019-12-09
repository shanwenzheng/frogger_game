package frogger.model;

import static org.junit.Assert.*;

import org.junit.Test;

import frogger.constant.FileName;
import frogger.model.actor.movableActor.Obstacle;

public class ObstacleTest {

	Obstacle obstacle = new Obstacle(FileName.IMAGE_LONG_TRUCK_RIGHT,60,100,200,1);
	
	
	@Test
	public void wetTurtlePositionTest() {
		assertTrue(obstacle.getX() == 100);
		assertTrue(obstacle.getY() == 200);
	}
	
	@Test
	public void setImageTest() {
		assertTrue(obstacle.getImage().getWidth() == 60);
	}
	
	@Test
	public void speedTest() {
		assertTrue(obstacle.getSpeed() == 1);
	}
	
	@Test
	public void moveTest() {
		obstacle.move(20, 0);
		assertTrue(obstacle.getX() == 120);
	}
	
	@Test
	public void wallTouchTest() {
		obstacle.setX(700);
		obstacle.checkWall(obstacle.getSpeed(),-75,-200,600);
		assertTrue(obstacle.getX() == -200);
	}

}
