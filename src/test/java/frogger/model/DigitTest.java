package frogger.model;

import static org.junit.Assert.*;

import org.junit.Test;

import frogger.model.actor.staticActor.Digit;
import frogger.model.actor.staticActor.End;
import javafx.scene.image.Image;

/**
 * <h2> DigitTest </h2>
 * 
 * <p> The {@link DigitTest} function is used to test the correctness of parts of the method in {@link Digit} 
 * which are testable without launching application.
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see Digit
 */
public class DigitTest {

	/** A {@link Digit} which is used to accomplish test */
	Digit digit = new Digit(0,60,100,200);
	
	/**
	 * <p>This is the test method that tests the initial position of {@link #digit}.
	 * <p>This test will pass if the X position and Y position are both correct.
	 */
	@Test
	public void digitPositionTest() {
		assertTrue(digit.getX() == 100);
		assertTrue(digit.getY() == 200);
	}
	
	/**
	 * <p>This is the test method that tests the initial image of {@link #digit}.
	 * <p>This test will pass if the size of initial image is correct.
	 */
	@Test
	public void setImageTest() {
		assertTrue(digit.getImage().getHeight() == 60);
	}
	
	/**
	 * <p>This is the test method that tests the correctness of {@link Digit#changeScore(int)}.
	 * <p>This test will pass if all the images are changed after calling {@link Digit#changeScore(int)}.
	 */
	@Test
	public void changeImageTest() {	
		for(int i = 1; i < 10; i++) {
			Image oldImage = digit.getImage();
			digit.changeScore(i);
			Image newImage = digit.getImage();
			assertFalse(oldImage == newImage);
		}
	}

}
