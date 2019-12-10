package frogger.model;

import static org.junit.Assert.*;
import org.junit.Test;
import frogger.model.actor.staticActor.End;

/**
 * <h2> EndTest </h2>
 * 
 * <p> The {@link EndTest} function is used to test the correctness of parts of the method in {@link End} 
 * which are testable without launching application.
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see End
 */
public class EndTest {

	/** A {@link End} which is used to accomplish test */
	End end = new End(60,100,200);
	
	/**
	 * <p>This is the test method that tests the initial position of {@link #end}.
	 * <p>This test will pass if the X position and Y position are both correct.
	 */
	@Test
	public void endPositionTest() {
		assertTrue(end.getX() == 100);
		assertTrue(end.getY() == 200);
	}
	
	/**
	 * <p>This is the test method that tests the initial image of {@link #end}.
	 * <p>This test will pass if the size of initial image is correct.
	 */
	@Test
	public void imageSetTest() {
		assertTrue(end.getImage().getHeight() == 60);
	}
	
	/**
	 * <p>This is the test method that tests the correctness of {@link End#setEnd()}.
	 * <p>This test will pass if the size of frog end image is correct and the activiated field is true.
	 */
	@Test
	public void setEndTest() {
		end.setEnd();
		assertTrue(end.isActivated());
		assertTrue(end.getImage().getHeight() == 70);
	}

}
