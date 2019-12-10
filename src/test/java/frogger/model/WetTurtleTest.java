package frogger.model;

import static org.junit.Assert.*;
import org.junit.Test;
import frogger.model.actor.movableActor.WetTurtle;

/**
 * <h2> WetTurtleTest </h2>
 * 
 * <p> The {@link WetTurtleTest} function is used to test the correctness of parts of the method in {@link WetTurtle} 
 * which are testable without launching application.
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see WetTurtle
 */
public class WetTurtleTest {

	/** A {@link WetTurtle} which is used to accomplish test */
	WetTurtle wetTurtle = new WetTurtle(60,100,200,1);
	
	/**
	 * <p>This is the test method that tests the initial position of {@link #wetTurtle}.
	 * <p>This test will pass if the X position and Y position are both correct.
	 */
	@Test
	public void wetTurtlePositionTest() {
		assertTrue(wetTurtle.getX() == 100);
		assertTrue(wetTurtle.getY() == 200);
	}
	
	/**
	 * <p>This is the test method that tests the initial image of {@link #wetTurtle}.
	 * <p>This test will pass if the size of initial image is correct.
	 */
	@Test
	public void setImageTest() {
		assertTrue(wetTurtle.getImage().getWidth() == 60);
	}
	
	/**
	 * <p>This is the test method that tests the initial speed of {@link #wetTurtle}.
	 * <p>This test will pass if the value of speed is correct.
	 */
	@Test
	public void speedTest() {
		assertTrue(wetTurtle.getSpeed() == 1);
	}
	
	/**
	 * <p>This is the test method that tests the correctness of {@link WetTurtle#move(double, double)}.
	 * <p>This test will pass if the X position is correct after calling {@link WetTurtle#move(double, double)}.
	 */
	@Test
	public void moveTest() {
		wetTurtle.move(20, 0);
		assertTrue(wetTurtle.getX() == 120);
	}
	
	/**
	 * <p>This is the test method that tests the correctness of {@link WetTurtle#checkWall(double, int, int, int)}.
	 * <p>This test will pass if the X position is correct after calling {@link WetTurtle#checkWall(double, int, int, int)}.
	 */
	@Test
	public void wallTouchTest() {
		wetTurtle.setX(700);
		wetTurtle.checkWall(wetTurtle.getSpeed(),-75,-200,600);
		assertTrue(wetTurtle.getX() == -200);
	}

}
