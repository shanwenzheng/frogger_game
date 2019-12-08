package frogger.model;

/** 
 * <h2> Life </h2>
 * 
 * <p> The {@link Life} class is used to keep the recode of the player's life
 * and provide some operations to make change of the life count.
 * 
 * <p><strong> Use: </strong>
 * <pre>
 * 		Life life = new Life(totaLife);
 * 		life.loseLife();
 * </pre>
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @See GameController
 */
public class Life{
	
	/** The upper limit of life count */
	private int totalLife;
	/** The remaining life count */
	private int remainingLife;
	
	/**
	 * <p> The constructor of {@link Life} class to generate life instance and initial the upper limit and remaining of life count at the beginning of game
	 * 
	 * @param totalLife		An integer of initial life count to be set to {@link #totalLife}
	 */
	public Life(int totalLife) {
		this.totalLife = totalLife;
		this.remainingLife = totalLife;
	}
	
	/** Decreases the {@link #remainingLKife} by {@code 1} and the minimum life count is {@code 0}. */
	public void loseLife() {
		remainingLife--;
		if(remainingLife < 0) {
			remainingLife = 0;
		}
	}
	
	/** 
	 * Returns the {@link #remainingLife}. 
	 * 
	 * @return the {@link #remainingLife}
	 */
	public int getRemainingLife() {
		return remainingLife;
	}
	
	/** 
	 * Returns the {@link #totalLife}. 
	 * 
	 * @return the {@link #totalLife}
	 */
	public int getTotalLife() {
		return totalLife;
	}
}
