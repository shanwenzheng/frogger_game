package frogger.model;

/**
 * <h2> Score </h2>
 * 
 * <p> The {@link Score} class is used to keep the record of player's score 
 * and provide some operations to make change of the score
 * 
 * <p><strong> Use: </strong>
 * 
 * <pre>
 * 		Score score = new Score() or Score score = new Score(points);
 * 		score.addScore(point);
 * 		score.subScore(point);
 * </pre>
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see frogger.controller.GameController
 */
public class Score {
	
	/** The value of the score. */
	private int points;
	
	/** <p> The constructor of {@link Score} class to generate instance.
	 *  <p> This constructor set the original points to zero.
	 */
	public Score() {
		points = 0;
	}
	
	/**
	 * <p> The constructor of {@link Score} class to generate instance.
	 * <p> This constructor set the original points to given input points.
	 * 
	 * @param points	The initial point
	 */
	public Score(int points) {
		this.points = points;
	}
	
	/**
	 * <p> Increases the {@link #points} by the given {@code points}.
	 * 
	 * @param point	an integer to be added to the {@link #points}
	 */
	public void addScore(int point) {
		this.points += point;
	}
	
	/**
	 * <p> Decreases the {@link #points} by the given {@code points}.
	 * 
	 * @param point	an integer to be subtracted to the {@link #points}
	 */
	public void subScore(int point) {
		this.points -= point;
	}
	
	/**
	 * <p> Returns the {@link #points}
	 * 
	 * @return an integer indicating the value of score
	 */
	public int getScore() {
		return points;
	}
	
	/**
	 * <p> Set the {@link #points} by the given {@code points}.
	 * 
	 * @param points an integer to be set to the {@link #points}
	 */
	public void setScore(int points) {
		this.points = points;
	}
}

