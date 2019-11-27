package model;

import javafx.scene.image.Image;

public class BackgroundImage extends StaticActor{	

	public BackgroundImage(String imageLink) {
		super();
		setImage(new Image(imageLink, 600, 800, true, true));	
	}
}
