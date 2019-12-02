package frogger.service;

import java.util.ArrayList;

import frogger.model.actor.staticActor.Digit;

public enum ScoreBoardUpdater {
	INSTANCE;
	
	public void updateScore(int n, ArrayList<Digit> scoreBoard) {
		for (Digit digit: scoreBoard) {
			int d = n / 10;
			int k = n - d * 10;
			n = d;
			digit.changeScore(k);
		}
	  }
}

