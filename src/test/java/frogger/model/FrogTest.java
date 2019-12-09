package frogger.model;

import static org.junit.Assert.*;

import org.junit.Test;

import frogger.model.actor.movableActor.Frog;

public class FrogTest {

	Frog frog = new Frog(60);
	
	@Test
	public void frogPositionTest() {
		assertTrue(frog.getX() == 300);
		assertTrue(frog.getY() == 679.8 + 13.3333333*2);
	}
	
	@Test
	public void setImageTest() {
		assertTrue(frog.getImage().getWidth() == 60);
	}
	
	@Test
	public void keyPressedMoveTest() {
		frog.moveKeyPressed("w");
		assertTrue(frog.getX() == 300);
		assertTrue(frog.getY() == 679.8);
	}
	
	@Test
	public void keyReleasedMoveTest() {
		frog.moveKeyReleased("a");
		assertTrue(frog.getX() == 300 - 10.666666*2);
		assertTrue(frog.getY() == 679.8 + 13.3333333*2);
	}
	
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
	
	@Test
	public void setDeathTypeTest() {
		frog.setDeathType("carDeath");
		assertEquals(frog.getDeathType(), "carDeath");
	}
	
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
