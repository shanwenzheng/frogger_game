package util;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import model.Animal;
import model.Digit;
import view.GameView;

public class ScoreBoardUpdater {
	
	private AnimationTimer timer;
	private Pane background;
	private Animal animal;
	
	public ScoreBoardUpdater(GameView gameView) {
		createTimer();
		this.animal = gameView.getAnimal();
		this.background = gameView.getBackground();
	}
	  
	private void createTimer() {
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if(animal.changeScore()) {
					updateScore(animal.getPoints());
				}
			}
		};
	}

	public void updateScore(int n) {
		int shift = 0;
		while (n > 0) {
			  int d = n / 10;
			  int k = n - d * 10;
			  n = d;			
			  background.getChildren().add(new Digit(k, 30, 565 - shift, 25));
			  shift+=30;
			}
	  }
	
	public AnimationTimer getTimer() {
		return this.timer;
	}
}

