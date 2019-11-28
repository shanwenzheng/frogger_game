package util;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import model.actor.movableActor.animal.Animal;
import model.actor.staticActor.Digit;
import view.GameView;

public class ScoreBoardUpdater {
	
	private AnimationTimer timer;

	
	public ScoreBoardUpdater(GameView gameView) {
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if(gameView.getMap().getAnimal().changeScore())
					updateScore(gameView.getMap().getAnimal().getPoints(), gameView.getBackground());
			}
		};
	}

	public void updateScore(int n, Pane background) {
		int shift = 0;
		int count = 0;
		while (n > 0) {
			  int d = n / 10;
			  int k = n - d * 10;
			  n = d;			
			  background.getChildren().add(new Digit(k, 30, 565 - shift, 25));
			  shift+=30;
			  count++;
			}
		if(count == 2) {
			background.getChildren().add(new Digit(0, 30, 565-shift, 25));
		}
	  }
	
	public AnimationTimer getTimer() {
		return this.timer;
	}
}

