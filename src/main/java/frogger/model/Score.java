package frogger.model;

public class Score {
	
	private int points;
	
	public Score() {
		points = 0;
	}
	
	public void addScore(int point) {
		this.points += point;
	}
	
	public void subScore(int point) {
		this.points -= point;
	}
	
	public int getScore() {
		return points;
	}
}

