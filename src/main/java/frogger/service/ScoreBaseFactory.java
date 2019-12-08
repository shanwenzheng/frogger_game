package frogger.service;

/**
 * <h2> ScoreBaseFactory </h2>
 * 
 * <p>The {@link ScoreBaseFactory} class is used to generate an additional point depend on the gameLevel
 * 
 * <p><strong>Note:</strong> this class is implemented as an factory pattern.
 * 
 * <p><strong>Main Functionality:</strong>
 * 
 * <pre>
 *		ScoreBaseFactory.createScoreBase(gameLevel);
 * </pre>
 * 
 * <p><strong>Use:</strong>
 * 
 * <pre>
 * 		ScoreBaseFactory.{method}();
 * </pre>
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 *
 */
public class ScoreBaseFactory {
	
	/**
	 * <p>return the additional point depend on the given gameLevel
	 * 
	 * @param gameLevel		The gameLevel of current game (e.g., SimpleMode)
	 * @return		Return the additional point (e.g., NormalMode -> 50 points)
	 */
	public static int createScoreBase(String gameLevel) {

		if(gameLevel.equals("SimpleMode")) {
			return 0;
		}else if(gameLevel.equals("NormalMode")){
			return 50;
		}else if(gameLevel.equals("HardMode")){
			return 100;
		}
		return 0;
	}
}
