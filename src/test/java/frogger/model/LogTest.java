package frogger.model;

import static org.junit.Assert.*;
import org.junit.Test;
import frogger.constant.FileName;
import frogger.model.actor.movableActor.Log;

/**
 * <h2> LogTest </h2>
 * 
 * <p> The {@link LogTest} function is used to test the correctness of parts of the method in {@link Log} 
 * which are testable without launching application.
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see Log
 */
public class LogTest {

	/** A {@link Log} which is used to accomplish test */
	Log log = new Log(FileName.IMAGE_LONG_LOG,60,100,200,1);
	
	/**
	 * <p>This is the test method that tests the initial position of {@link #log}.
	 * <p>This test will pass if the X position and Y position are both correct.
	 */
	@Test
	public void logPositionTest() {
		assertTrue(log.getX() == 100);
		assertTrue(log.getY() == 200);
	}
	
	/**
	 * <p>This is the test method that tests the initial image of {@link #log}.
	 * <p>This test will pass if the size of initial image is correct.
	 */
	@Test
	public void setImageTest() {
		assertTrue(log.getImage().getWidth() == 60);
	}
	
	/**
	 * <p>This is the test method that tests the initial speed of {@link #log}.
	 * <p>This test will pass if the value of speed is correct.
	 */
	@Test
	public void speedTest() {
		assertTrue(log.getSpeed() == 1);
	}
	
	/**
	 * <p>This is the test method that tests the correctness of {@link Log#move(double, double)}.
	 * <p>This test will pass if the X position is correct after calling {@link Log#move(double, double)}.
	 */
	@Test
	public void moveTest() {
		log.move(20, 0);
		assertTrue(log.getX() == 120);
	}
	
	/**
	 * <p>This is the test method that tests the correctness of {@link Log#checkWall(double, int, int, int)}.
	 * <p>This test will pass if the X position is correct after calling {@link Log#checkWall(double, int, int, int)}.
	 */
	@Test
	public void wallTouchTest() {
		log.setX(700);
		log.checkWall(log.getSpeed(),-75,-200,600);
		assertTrue(log.getX() == -200);
	}

}
