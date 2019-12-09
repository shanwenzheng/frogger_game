package frogger.model;

import static org.junit.Assert.*;

import org.junit.Test;

import frogger.model.actor.movableActor.WetTurtle;

public class WetTurtleTest {

	WetTurtle wetTurtle = new WetTurtle(60,100,200,1);
	
	@Test
	public void wetTurtlePositionTest() {
		assertTrue(wetTurtle.getX() == 100);
		assertTrue(wetTurtle.getY() == 200);
	}
	
	@Test
	public void setImageTest() {
		assertTrue(wetTurtle.getImage().getWidth() == 60);
	}
	
	@Test
	public void speedTest() {
		assertTrue(wetTurtle.getSpeed() == 1);
	}
	
	@Test
	public void moveTest() {
		wetTurtle.move(20, 0);
		assertTrue(wetTurtle.getX() == 120);
	}
	
	@Test
	public void wallTouchTest() {
		wetTurtle.setX(700);
		wetTurtle.checkWall(wetTurtle.getSpeed(),-75,-200,600);
		assertTrue(wetTurtle.getX() == -200);
	}

}
