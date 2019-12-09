package frogger.model;

import static org.junit.Assert.*;

import org.junit.Test;

import frogger.model.actor.staticActor.End;

public class EndTest {

	End end = new End(60,100,200);
	
	@Test
	public void endPositionTest() {
		assertTrue(end.getX() == 100);
		assertTrue(end.getY() == 200);
	}
	
	@Test
	public void imageSetTest() {
		assertTrue(end.getImage().getHeight() == 60);
	}
	
	@Test
	public void setEndTest() {
		end.setEnd();
		assertTrue(end.isActivated());
		assertTrue(end.getImage().getHeight() == 70);
	}

}
