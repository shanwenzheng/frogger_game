package frogger.model;

public class Life{
	
	private int totalLife;
	private int remainingLife;
	
	public Life(int totalLife) {
		this.totalLife = totalLife;
		this.remainingLife = totalLife;
	}
	
	public Life() {
		this(3);
	}
	
	public void loseLife() {
		remainingLife--;
		if(remainingLife < 0) {
			remainingLife = 0;
		}
	}
	
	public int getRemainingLife() {
		return remainingLife;
	}
	
	public int getTotalLife() {
		return totalLife;
	}
}
