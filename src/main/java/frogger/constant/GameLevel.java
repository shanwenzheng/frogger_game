package frogger.constant;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <h2> GameLevel </h2>
 * 
 * <p> The {@link GameLevel} class is used to store constant game level names.
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 *
 */
public class GameLevel {
	public static final ArrayList<String> gameLevelList = new ArrayList<String>(Arrays.asList(
			"NormalMode",
			"SimpleMode",
			"HardMode"
	));
}