package frogger.model.actor.staticActor;

import frogger.Main;
import frogger.constant.FileName;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

/**
 * <h2> End </h2>
 *
 * <p> The {@link Chomper} class is used to create the chomper object and eat the frog when Frog touched with this object.
 *
 * <p> A {@link Chomper} object is set in {@link frogger.model.Map}. It represents the chomper which used to eat the frog
 * when frog touch this object. The position of chomper is the same as one of the ends and if the remaining empty end is zero,
 * one of the chompers will be removed from {@link Pane};
 *
 * <p> <Strong> Note: </strong> This class extends {@link StaticActor} abstract class.
 *
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see frogger.model.Map
 * @see StaticActor
 */
public class Chomper extends StaticActor{

    /**
     * <p> The constructor of {@link Chomper} class to generate instance
     *
     * <p> This constructor sets the {@link Chomper} in the given position {@code x} and {@code y} in the {@link frogger.model.Map}.
     * And set the initial image with the given {@code size}.
     *
     * @param size	The size of the image
     * @param x		The position of x in the {@link frogger.model.Map} where Chomper stays
     * @param y		The position of y in the {@link frogger.model.Map} where Chomper stays
     */
    public Chomper(int size, double  x, double  y) {
        super(x, y);
        setImage(new Image(Main.class.getResourceAsStream(FileName.IMAGE_CHOMPER), size, size, true, true));
    }

}
