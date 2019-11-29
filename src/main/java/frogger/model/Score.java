package frogger.model;

import frogger.util.ScoreBoardUpdater;

public class Score {
	
	private int points;
	
	public Score() {
		points = 0;
	}
	
	public void addScore(int point) {
		this.points += point;
		showScore();
	}
	
	public void subScore(int point) {
		if(points > 50) {
			this.points -= point;
			showScore();
		}
	}
	
	public void showScore() {
		ScoreBoardUpdater.INSTANCE.updateScore(points);
	}
	
	public int getScore() {
		return points;
	}
}
