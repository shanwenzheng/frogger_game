package frogger.model.actor.staticActor;

import frogger.Main;
import frogger.constant.FileName;
import javafx.scene.image.Image;

/**
 * <h2> Digit </h2>
 * 
 * <p> The {@link Digit} class is used to create the single bit of scoreBoard and change the image when {@link frogger.model.Score} changed.
 * 
 * <p> A {@link Digit} object is set in {@link frogger.model.Map}. It represents the current {@link frogger.model.Score} of game and change the points when {@link frogger.model.Score} added or subtracted.
 *
 * <p> <Strong> Note: </strong> This class extends {@link StaticActor} abstract class.
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see frogger.model.Map
 * @see StaticActor
 */
public class Digit extends StaticActor{
	
	/** The image size of {@link Digit} */
	private int size;
	
	/**
	 * <p> The constructor of {@link Digit} class to generate instance
	 * 
	 * <p> This constructor sets the {@link Digit} in the given position {@code x} and {@code y} in the {@link frogger.model.Map}.
	 * And set the initial image with the given {@code size} and number {@code n}. 
	 * 
	 * @param n		The image index (If n == 0, then the image will be "0.png")
	 * @param size	The size of the image
	 * @param x		The position of x in the {@link frogger.model.Map} where digit stays
	 * @param y		The position of y in the {@link frogger.model.Map} where digit stays
	 */
	public Digit(int n, int size, double  x, double  y) {
		super(x, y);
		this.size = size;
		setImage(new Image(Main.class.getResourceAsStream(FileName.IMAGE_DIGIT.get(n)), size, size, true, true));
	}
	
	/**
	 * <p> Change the image of digit with the given image index {@code n}.
	 * 
	 * @param n		The image index (If n == 3, then the image will be "3.png")
	 */
	public void changeScore(int n) {
		setImage(new Image(Main.class.getResourceAsStream(FileName.IMAGE_DIGIT.get(n)), size, size, true, true));
	}
}

