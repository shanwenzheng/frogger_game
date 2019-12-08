package frogger.model.actor.staticActor;

import frogger.Main;
import frogger.constant.FileName;
import javafx.scene.image.Image;

/**
 * <h2> End </h2>
 * 
 * <p> The {@link End} class is used to create the end object and change the image when Frog enter into this end terminal point.
 * 
 * <p> A {@link End} object is set in {@link frogger.model.Map}. It represents the end position where Frog move forward 
 * and change the end image when Frog touched the end terminal point.
 *
 * <p> <Strong> Note: </strong> This class extends {@link StaticActor} abstract class.
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see frogger.model.Map
 * @see StaticActor
 */
public class End extends StaticActor{
	
	/** A flag to determine whether the Frog has already entered into terminal point. */
	private boolean activated = false;
	/** The image of end when Frog entered into terminal point. */
	private Image frogEnd;
	
	/**
	 * <p> The constructor of {@link End} class to generate instance
	 * 
	 * <p> This constructor sets the {@link End} in the given position {@code x} and {@code y} in the {@link frogger.model.Map}.
	 * And set the initial image and {@link #frogEnd} image with the given {@code size}. 
	 * 
	 * @param size	The size of the image
	 * @param x		The position of x in the {@link frogger.model.Map} where digit stays
	 * @param y		The position of y in the {@link frogger.model.Map} where digit stays
	 */
	public End(int size, double  x, double  y) {
		super(x, y);
		setImage(new Image(Main.class.getResourceAsStream(FileName.IMAGE_END), size, size, true, true));
		frogEnd = new Image(Main.class.getResourceAsStream(FileName.IMAGE_END_FROG), size + 10, size + 10, true, true);
	}
	
	/** <p> Change the image of {@link End} and {@link #activated} to true when frog entered into terminal point. */
	public void setEnd() {
		setImage(frogEnd);
		activated = true;
	}
	
	/**
	 * <p> Return true if frog enter into end position, otherwise false 
	 * 
	 * @return	The flag whether the end is activated
	 */
	public boolean isActivated() {
		return activated;
	}
}
