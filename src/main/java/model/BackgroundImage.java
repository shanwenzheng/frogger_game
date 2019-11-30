package model;

import javafx.scene.image.Image;
import frogger.Main;

public class BackgroundImage extends StaticActor{	

	public BackgroundImage(String imageLink) {
		super();
		setImage(new Image(Main.class.getResourceAsStream(imageLink), 600, 800, true, true));	
	}
}
