package frogger.util;

import java.util.ArrayList;

import frogger.model.actor.movableActor.animal.Animal;
import frogger.model.actor.staticActor.Digit;
import frogger.view.GameView;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

public class ScoreBoardUpdater {
	
	private AnimationTimer scoreUpdatertimer;
	private Animal animal;
	private ArrayList<Digit> digits;

	public ScoreBoardUpdater(GameView gameView) {
		createScoreUpdaterTimer();
		animal = gameView.getMap().getAnimal();
		digits = gameView.getMap().getDigit();
	}
	
	public void createScoreUpdaterTimer() {
		scoreUpdatertimer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if(animal.changeScore())
					updateScore(animal.getPoints(), digits);
			}
		};
	}

	public void updateScore(int n, ArrayList<Digit> digits) {
		for (Digit digit: digits) {
			int d = n / 10;
			int k = n - d * 10;
			n = d;
			digit.changeScore(k);
		}
	  }
	
	public AnimationTimer getScoreUpdaterTimer() {
		return scoreUpdatertimer;
	}
}
