package frogger.util;

import java.util.ArrayList;

import frogger.model.actor.staticActor.Digit;
import frogger.view.GameView;

public class ScoreBoardUpdater {

	private ArrayList<Digit> digits;

	public ScoreBoardUpdater(GameView gameView) {
		digits = gameView.getMap().getDigit();
	}

	public void updateScore(int n) {
		for (Digit digit: digits) {
			int d = n / 10;
			int k = n - d * 10;
			n = d;
			digit.changeScore(k);
		}
	  }
}

