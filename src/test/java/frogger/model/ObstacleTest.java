package frogger.model;

import static org.junit.Assert.*;
import org.junit.Test;
import frogger.constant.FileName;
import frogger.model.actor.movableActor.Obstacle;

/**
 * <h2> ObstacleTest </h2>
 * 
 * <p> The {@link ObstacleTest} function is used to test the correctness of parts of the method in {@link Obstacle} 
 * which are testable without launching application.
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see Obstacle
 */
public class ObstacleTest {

	/** A {@link Obstacle} which is used to accomplish test */
	Obstacle obstacle = new Obstacle(FileName.IMAGE_LONG_TRUCK_RIGHT,60,100,200,1);
	
	/**
	 * <p>This is the test method that tests the initial position of {@link #obstacle}.
	 * <p>This test will pass if the X position and Y position are both correct.
	 */
	@Test
	public void wetTurtlePositionTest() {
		assertTrue(obstacle.getX() == 100);
		assertTrue(obstacle.getY() == 200);
	}
	
	/**
	 * <p>This is the test method that tests the initial image of {@link #obstacle}.
	 * <p>This test will be pass if the size of initial image is correct.
	 */
	@Test
	public void setImageTest() {
		assertTrue(obstacle.getImage().getWidth() == 60);
	}
	
	/**
	 * <p>This is the test method that tests the initial speed of {@link #obstacle}.
	 * <p>This test will pass if the value of speed is correct.
	 */
	@Test
	public void speedTest() {
		assertTrue(obstacle.getSpeed() == 1);
	}
	
	/**
	 * <p>This is the test method that tests the correctness of {@link Obstacle#move(double, double)}.
	 * <p>This test will pass if the X position is correct after calling {@link Obstacle#move(double, double)}.
	 */
	@Test
	public void moveTest() {
		obstacle.move(20, 0);
		assertTrue(obstacle.getX() == 120);
	}
	
	/**
	 * <p>This is the test method that tests the correctness of {@link Obstacle#checkWall(double, int, int, int)}.
	 * <p>This test will pass if the X position is correct after calling {@link Obstacle#checkWall(double, int, int, int)}.
	 */
	@Test
	public void wallTouchTest() {
		obstacle.setX(700);
		obstacle.checkWall(obstacle.getSpeed(),-75,-200,600);
		assertTrue(obstacle.getX() == -200);
	}

}
