package frogger.model;

import static org.junit.Assert.*;

import org.junit.Test;

import frogger.constant.FileName;
import frogger.model.actor.movableActor.Log;

public class LogTest {

	Log log = new Log(FileName.IMAGE_LONG_LOG,60,100,200,1);
	
	@Test
	public void logPositionTest() {
		assertTrue(log.getX() == 100);
		assertTrue(log.getY() == 200);
	}
	
	@Test
	public void setImageTest() {
		assertTrue(log.getImage().getWidth() == 60);
	}
	
	@Test
	public void speedTest() {
		assertTrue(log.getSpeed() == 1);
	}
	
	@Test
	public void moveTest() {
		log.move(20, 0);
		assertTrue(log.getX() == 120);
	}
	
	@Test
	public void wallTouchTest() {
		log.setX(700);
		log.checkWall(log.getSpeed(),-75,-200,600);
		assertTrue(log.getX() == -200);
	}

}
