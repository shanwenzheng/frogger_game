package frogger.model;

import static org.junit.Assert.*;
import frogger.model.actor.movableActor.Turtle;
import org.junit.Test;

/**
 * <h2> TurtleTest </h2>
 * 
 * <p> The {@link TurtleTest} function is used to test the correctness of parts of the method in {@link Turtle} 
 * which are testable without launching application.
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see Turtle
 */
public class TurtleTest {

	/** A {@link Turtle} which will be used to accomplish test */
	Turtle turtle = new Turtle(60,100,200,1);
	
	/**
	 * <p>This is the test method that tests the initial position of {@link #turtle}.
	 * <p>This test will pass if the X position and Y position are both correct.
	 */
	@Test
	public void wetTurtlePositionTest() {
		assertTrue(turtle.getX() == 100);
		assertTrue(turtle.getY() == 200);
	}
	
	/**
	 * <p>This is the test method that tests the initial image of {@link #turtle}.
	 * <p>This test will be pass if the size of initial image is correct.
	 */
	@Test
	public void setImageTest() {
		assertTrue(turtle.getImage().getWidth() == 60);
	}
	
	/**
	 * <p>This is the test method that tests the initial speed of {@link #turtle}.
	 * <p>This test will pass if the value of speed is correct.
	 */
	@Test
	public void speedTest() {
		assertTrue(turtle.getSpeed() == 1);
	}
	
	/**
	 * <p>This is the test method that tests the correctness of {@link Turtle#move(double, double)}.
	 * <p>This test will pass if the X position is correct after calling {@link Turtle#move(double, double)}.
	 */
	@Test
	public void moveTest() {
		turtle.move(20, 0);
		assertTrue(turtle.getX() == 120);
	}
	
	/**
	 * <p>This is the test method that tests the correctness of {@link Turtle#checkWall(double, int, int, int)}.
	 * <p>This test will pass if the X position is correct after calling {@link Turtle#checkWall(double, int, int, int)}.
	 */
	@Test
	public void wallTouchTest() {
		turtle.setX(700);
		turtle.checkWall(turtle.getSpeed(),-75,-200,600);
		assertTrue(turtle.getX() == -200);
	}
}
