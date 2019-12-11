 package frogger.constant;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <h2> FileName </h2>
 * 
 * <p> The {@link FileName} class is used to store constant file names.
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 *
 */
public class FileName {
	
	public static final String IMAGE_CAR_LEFT = "images/obstacle/car1Left.png";
	public static final String IMAGE_CAR_RIGHT = "images/obstacle/car1Right.png";
	public static final String IMAGE_LONG_TRUCK_LEFT = "images/obstacle/truck2Left.png";
	public static final String IMAGE_LONG_TRUCK_RIGHT = "images/obstacle/truck2Right.png";
	public static final String IMAGE_SHORT_TRUCK_LEFT = "images/obstacle/truck1Left.png";
	public static final String IMAGE_SHORT_TRUCK_RIGHT = "images/obstacle/truck1Right.png";
	
	public static final String IMAGE_LONG_LOG = "images/log/logs.png";
	public static final String IMAGE_MEDIUM_LOG = "images/log/log2.png";
	public static final String IMAGE_SHORT_LOG = "images/log/log3.png";
	
	public static final String IMAGE_END = "images/end/End.png";
	public static final String IMAGE_END_FROG = "images/end/FrogEnd.png";

	public static final String IMAGE_SNAKE = "images/snake/snake.png";
	public static final String IMAGE_CHOMPER = "images/chomper/Chomper.jpg";
	
	public static final ArrayList<String> IMAGE_TURTLE = new ArrayList<String>(
			Arrays.asList(
					"images/turtle/TurtleAnimation1.png",
					"images/turtle/TurtleAnimation2.png",
					"images/turtle/TurtleAnimation3.png" ));
	
	public static final ArrayList<String> IMAGE_WETTURTLE = new ArrayList<String>(
			Arrays.asList(
					"images/wetturtle/TurtleAnimation1Wet.png",
					"images/wetturtle/TurtleAnimation2Wet.png",
					"images/wetturtle/TurtleAnimation3Wet.png",
					"images/wetturtle/TurtleAnimation4Wet.png" ));
	
	public static final ArrayList<String> IMAGE_DIGIT = new ArrayList<String>(
			Arrays.asList(
					"images/digit/0.png",
					"images/digit/1.png",
					"images/digit/2.png",
					"images/digit/3.png",
					"images/digit/4.png",
					"images/digit/5.png",
					"images/digit/6.png",
					"images/digit/7.png",
					"images/digit/8.png",
					"images/digit/9.png" ));
	
	public static final ArrayList<String> IMAGE_CAR_SNAKE__DEATH = new ArrayList<String>(
			Arrays.asList(
					"images/death/cardeath1.png",
					"images/death/cardeath2.png",
					"images/death/cardeath3.png" ));
	
	public static final ArrayList<String> IMAGE_WATER_CHOMPER_DEATH = new ArrayList<String>(
			Arrays.asList(
					"images/death/waterdeath1.png",
					"images/death/waterdeath2.png",
					"images/death/waterdeath3.png",
					"images/death/waterdeath4.png" ));
	
	public static final String IMAGE_FROG_UP = "images/frog/froggerUp.png";
	public static final String IMAGE_FROG_DOWN = "images/frog/froggerDown.png";
	public static final String IMAGE_FROG_LEFT = "images/frog/froggerLeft.png";	
	public static final String IMAGE_FROG_RIGHT = "images/frog/froggerRight.png";	
	
	public static final String IMAGE_FROG_UP_JUMP = "images/frog/froggerUpJump.png";	
	public static final String IMAGE_FROG_DOWN_JUMP = "images/frog/froggerDownJump.png";	
	public static final String IMAGE_FROG_LEFT_JUMP = "images/frog/froggerLeftJump.png";	
	public static final String IMAGE_FROG_RIGHT_JUMP = "images/frog/froggerRightJump.png";	
	
	public static final String IMAGE_LIFE = "images/frog/life.png";
	
	public static final String IMAGE_VICTORY = "images/scorelist/victory.jpg";
	public static final String IMAGE_DEFEAT = "images/scorelist/defeat.png";
	
	public static final String VIEW_START = "view/startScreen.fxml";
	public static final String VIEW_SELECT = "view/select.fxml";
	public static final String VIEW_INSTRUCTION = "view/instruction.fxml";
	public static final String VIEW_HIGHSCORELIST = "view/highScoreList.fxml";
	public static final String VIEW_POPUP = "view/popup.fxml";
	
	public static final String MUSIC_START = "music/startScreen.mp3";
	public static final String MUSIC_SELECT = "music/select.mp3";
	public static final String MUSIC_GAME = "music/game.mp3";
	public static final String MUSIC_VICTORY = "music/victory.mp3";
	public static final String MUSIC_DEFEAT = "music/defeat.mp3";
	
	public static final String FILE_SCORE_LIST = System.getProperty("user.dir") + "\\src\\main\\resources\\frogger\\scoreFile\\highScore.txt";
}
