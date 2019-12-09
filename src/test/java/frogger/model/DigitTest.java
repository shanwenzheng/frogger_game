package frogger.model;

import static org.junit.Assert.*;

import org.junit.Test;

import frogger.model.actor.staticActor.Digit;
import javafx.scene.image.Image;

public class DigitTest {

	Digit digit = new Digit(0,60,100,200);
	
	@Test
	public void digitPositionTest() {
		assertTrue(digit.getX() == 100);
		assertTrue(digit.getY() == 200);
	}
	
	@Test
	public void setImageTest() {
		assertTrue(digit.getImage().getHeight() == 60);
	}
	
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
