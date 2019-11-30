package frogger.model.actor.staticActor;

import java.util.ArrayList;

import frogger.Main;
import javafx.scene.image.Image;

public class Digit extends StaticActor{
	
	private ArrayList<Image> digitImages;
	
	public Digit(int n, int size, double  x, double  y) {
		super(x, y);
		digitImages = new ArrayList<Image>() {{
			for(int i = 0; i < 10; i ++)
			{
				add(new Image(Main.class.getResourceAsStream("images/" + i + ".png"), size, size, true, true));
			}
		}};
		setImage(digitImages.get(n));
	}
	
	public void changeScore(int n) {
		setImage(digitImages.get(n));
	}
}
