package frogger.model;

import static org.junit.Assert.*;

import org.junit.Test;

import frogger.model.actor.movableActor.Turtle;

public class TurtleTest {

	Turtle turtle = new Turtle(60,100,200,1);
	
	@Test
	public void wetTurtlePositionTest() {
		assertTrue(turtle.getX() == 100);
		assertTrue(turtle.getY() == 200);
	}
	
	@Test
	public void setImageTest() {
		assertTrue(turtle.getImage().getWidth() == 60);
	}
	
	@Test
	public void speedTest() {
		assertTrue(turtle.getSpeed() == 1);
	}
	
	@Test
	public void moveTest() {
		turtle.move(20, 0);
		assertTrue(turtle.getX() == 120);
	}
	
	@Test
	public void wallTouchTest() {
		turtle.setX(700);
		turtle.checkWall(turtle.getSpeed(),-75,-200,600);
		assertTrue(turtle.getX() == -200);
	}


}
