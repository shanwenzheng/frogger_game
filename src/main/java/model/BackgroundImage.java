package model;




import frogger.Main;
import javafx.scene.image.Image;

public class BackgroundImage extends StaticActor{

	
	public BackgroundImage(String imageLink) {
		setImage(new Image(Main.class.getResourceAsStream(imageLink), 600, 800, true, true));
		
	}

}
