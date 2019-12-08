package frogger.service;

import java.util.ArrayList;

import frogger.model.actor.staticActor.Digit;

/**
 * <h2>ScoreBoardUpdater</h2>
 * 
 * <p>The {@link ScoreBoardUpdater} class is an singleton class of utility to update the {@link Digit} created in map 
 * when the {@link Score} changed
 * 
 * <p><strong>Note:</strong> this class is implemented as an {@link Enum} thus to be a singleton class.
 * 
 * <p><strong>Main Functionality:</strong>
 * 
 * <pre>
 *		ScoreBoardUpdater.INSTANCE.updateScore(n, scoreBoard);
 * </pre>
 * 
 * <p><strong>Use:</strong>
 * 
 * <pre>
 * 		ScoreBoardUpdater.INSTANCE.{METHOD}()
 * </pre>
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @See ScoreListController
 * @See Digit
 *
 */
public enum ScoreBoardUpdater {
	/** The shared instance for global use for whole project */
	INSTANCE;
	
	/**
	 * <p> Update the {@link Digit} image based on the given input points
	 * 
	 * <p> Each time get the single figure of input n and update corresponding digit to this single figure
	 * 
	 * @param n		The current point of game (passed from {@link frogger.controller.gameController})
	 * @param scoreBoard	The {@link ArrayList} with three single {@link Digit} as scoreBoard being updated (generated in {@link Map})
	 */
	public void updateScore(int n, ArrayList<Digit> scoreBoard) {
		for (Digit digit: scoreBoard) {
			int d = n / 10;
			int k = n - d * 10;
			n = d;
			digit.changeScore(k);
		}
	  }
}

