package frogger.model;

import static org.junit.Assert.*;
import org.junit.Test;
import frogger.model.actor.movableActor.Frog;

/**
 * <h2> FrogTest </h2>
 * 
 * <p> The {@link FrogTest} function is used to test the correctness of parts of the method in {@link Frog} 
 * which are testable without launching application.
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see Frog
 */
public class FrogTest {

	/** A {@link Frog} which is used to accomplish test */
	Frog frog = new Frog(60);
	
	/**
	 * <p>This is the test method that tests the initial position of {@link #frog}.
	 * <p>This test will pass if the X position and Y position are both correct.
	 */
	@Test
	public void frogPositionTest() {
		assertTrue(frog.getX() == 300);
		assertTrue(frog.getY() == 679.8 + 13.3333333*2);
	}
	
	/**
	 * <p>This is the test method that tests the initial image of {@link #frog}.
	 * <p>This test will pass if the size of initial image is correct.
	 */
	@Test
	public void setImageTest() {
		assertTrue(frog.getImage().getWidth() == 60);
	}
	
	/**
	 * <p>This is the test method that tests the correctness of {@link Frog#moveKeyPressed(String)}.
	 * <p>This test will pass if the X and Y position is correct when pressing "W" (Calling {@link Frog#moveKeyPressed(String)} with the input "w").
	 */
	@Test
	public void keyPressedMoveTest() {
		frog.moveKeyPressed("w");
		assertTrue(frog.getX() == 300);
		assertTrue(frog.getY() == 679.8);
	}
	
	/**
	 * <p>This is the test method that tests the correctness of {@link Frog#moveKeyReleased(String)}.
	 * <p>This test will pass if the X and Y position is correct when releasing "A" (Calling {@link Frog#moveKeyReleased(String)} with the input "a").
	 */
	@Test
	public void keyReleasedMoveTest() {
		frog.moveKeyReleased("a");
		assertTrue(frog.getX() == 300 - 10.666666*2);
		assertTrue(frog.getY() == 679.8 + 13.3333333*2);
	}
	
	/**
	 * <p>This is the test method that tests the correctness of {@link Frog#checkAnimalWall()}.
	 * <p>This test will pass if the X and Y position is correct after calling {@link Frog#checkAnimalWall()}.
	 */
	@Test
	public void checkAnimalWallTest() {
		frog.setY(800);
		frog.checkAnimalWall();
		assertTrue(frog.getY() == 800 - 13.3333333*4);
		
		frog.setY(100);
		frog.setX(-100);
		frog.checkAnimalWall();
		assertTrue(frog.getX() == -100 + 10.666666*4);
	}
	
	/**
	 * <p>This is the test method that tests the correctness of {@link Frog#setDeathType(String)}.
	 * <p>This test will pass if the deathType in {@link #frog} is "carDeath" after calling {@link Frog#setDeathType(String)} with the input "carDeath".
	 */
	@Test
	public void setDeathTypeTest() {
		frog.setDeathType("carDeath");
		assertEquals(frog.getDeathType(), "carDeath");
	}
	
	/**
	 * <p>This is the test method that tests the correctness of {@link Frog#setOrigin(int)}.
	 * <p>This test will pass if the X and Y position as well as tyhe deathType are both correct after calling {@link Frog#setOrigin(int)}.
	 */
	@Test
	public void setOriginTest() {
		frog.setX(100);
		frog.setY(200);
		frog.setDeathType("waterDeath");
		frog.setOrigin(1);
		
		assertTrue(frog.getX() == 300);
		assertTrue(frog.getY() == 679.8 + 13.3333333*2);
		assertEquals(frog.getDeathType(), null);
	}
}
