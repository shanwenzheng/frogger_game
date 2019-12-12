package frogger.view;

import frogger.controller.GameController;
import frogger.model.Map;
import frogger.service.MapFactory;
import frogger.service.MapReader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;

/**
 * <h2> GameView </h2>
 * 
 * <p> The {@link GameView} class is used to paint a {@link Map} to a {@link Pane}
 * 
 * <p> Besides, this class also create home, restart and instruction button and score label to make the view more meaningful and functioning.
 * 
 * <p><Strong> Main Functionality </Strong>
 * 
 * <pre>
 * 		GameView.drawBakcground();
 * 		GameView.getMap();
 * 		GameView.getBackground();
 * </pre>
 * 
 * <p><Strong> Use: </Strong>
 * 
 * <pre>
 * 		GameView gameView = new GameView(gameLevel);
 * 		GameView.drawBackground();
 * </pre>
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see Pane
 * @see Button
 * @see Label
 * @see ProgressBar
 * @see Map
 * @see GameController
 * @see MapFactory
 */
public class GameView {
	
	/** The {@link Pane} that is expected to be drawn with the map on it */
	private Pane background;
	/** The {@link Map} that contains all the objects that will be drawn within {@link Pane} */
	private Map map;
	/** The home {@link Button} that back to the start screen when clicked */
	private Button homeButton;
	/** The restart {@link Button} that restart the game when clicked */
	private Button restartButton;
	/** The instruction {@link Button} that show the instruction of game when clicked */
	private Button instructionButton;
	/** The {@link ProgressBar} to show the time counter of game */
	private ProgressBar progressBar;

	/** 
	 * <p>Initialize the background, home button, restart button,instruction button and progressBar with the operation of new.
	 * 
	 * <p> Create the map by calling {@link MapFactory#createMap(String)} based on the given gameLevel String
	 * 
	 * @param gameLevel		A String represent the gameLevel of current game (e.g., "simpleMode", "NormalMode", "HardMode")
	 * @throws Exception	Exception An exception from {@link MapReader#MapReader(String)} which refers to the {@link ClassNotFoundException}
	 */
	public GameView(String gameLevel) throws Exception {
		background = new Pane();
		progressBar = new ProgressBar();
		homeButton = new Button("🏠");
		restartButton = new Button("🔄");
		instructionButton = new Button("❓");
		map = MapFactory.createMap(gameLevel);
	}
	
	/** Call all the draw function about each separate actor or button and draw them on background */
	public void drawBackground() {
		drawLog();
		drawTurtle();
		drawWetTurtle();
		drawEnd();
		drawAnimal();
		drawObstacle();
		drawScoreBoard();
		drawSnake();
		drawChomper();
		drawLifeImage();
		drawHomeButton();
		drawInstructionButton();
		drawRestartButton();
		drawProgressBar();
	}
	
	/** 
	 * <p>return the {@link #background} with the map on it
	 * 
	 * @return	the {@link #background} with the map on it
	 */
	public Pane getBackground() {
		return background;
	}
	
	/**
	 * <p> return the {@link #map}
	 *  
	 * @return return the {@link #map}
	 */
	public Map getMap() {
		return map;
	}

	/**
	 * <p> return the {@link #progressBar}
	 *
	 * @return return the {@link #progressBar}
	 */
	public ProgressBar getProgressBar() {return progressBar; };
	
	/** <p> Draws the {@link frogger.model.actor.movableActor.Log} from {@link Map} to {@link Pane} */
	public void drawLog() {
		background.getChildren().addAll(map.getLogs());
	}
	
	/** <p> Draws the {@link frogger.model.actor.movableActor.Turtle} from {@link Map} to {@link Pane} */
	public void drawTurtle() {
		background.getChildren().addAll(map.getTurtles());
	}
	
	/** <p> Draws the {@link frogger.model.actor.movableActor.WetTurtle} from {@link Map} to {@link Pane} */
	public void drawWetTurtle() {
		background.getChildren().addAll(map.getWetTurtles());
	}
	
	/** <p> Draws the {@link frogger.model.actor.staticActor.End} from {@link Map} to {@link Pane} */
	public void drawEnd() {
		background.getChildren().addAll(map.getEnds());
	}
	
	/** <p> Draws the {@link frogger.model.actor.movableActor.Frog} from {@link Map} to {@link Pane} */
	public void drawAnimal() {
		background.getChildren().add(map.getAnimal());
	}
	
	/** <p> Draws the {@link frogger.model.actor.movableActor.Obstacle} from {@link Map} to {@link Pane} */
	public void drawObstacle() {
		background.getChildren().addAll(map.getObstacles());
	}
	
	/** <p> Draws the life {@link javafx.scene.image.ImageView} from {@link Map} to {@link Pane} */
	public void drawLifeImage() {
		background.getChildren().addAll(map.getLifeImage());
	}

	/** <p> Draws the life {@link frogger.model.actor.movableActor.Snake} from {@link Map} to {@link Pane} */
	public void drawSnake() {
		background.getChildren().addAll(map.getSnakes());
	}

	/** <p> Draws the life {@link frogger.model.actor.staticActor.Chomper} from {@link Map} to {@link Pane} */
	public void drawChomper() {
		background.getChildren().addAll(map.getChompers());
	}

	/** <p> Draws the scoreBoard which contains three {@link frogger.model.actor.staticActor.Digit} from {@link Map} to {@link Pane} */
	public void drawScoreBoard() {
		background.getChildren().addAll(map.getScoreBoard());
	}
	
	/** <p> Creates the {@link Button} and set the position as well as the action.
	 *  <p> After clicking this button, application will change to start Screen.
	 *  <p> Draws this {@link Button} to {@link Pane}.
	 */
	public void drawHomeButton() {
		homeButton.setLayoutX(450);
		homeButton.setLayoutY(750);
		homeButton.setOnAction(event -> {GameController.INSTANCE.handleHomeButtonPressed();});
		background.getChildren().add(homeButton);
		
	}
	
	/** <p> Creates the {@link Button} and set the position as well as the action.
	 *  <p> After clicking this button, application will restart the game.
	 *  <p> Draws this {@link Button} to {@link Pane}.
	 */
	public void drawRestartButton() {
		restartButton.setLayoutX(550);
		restartButton.setLayoutY(750);
		restartButton.setOnAction(event -> {GameController.INSTANCE.handleRestartButtonPressed();});
		background.getChildren().add(restartButton);
	}
	
	/** <p> Creates the {@link Button} and set the position as well as the action.
	 *  <p> After clicking this button, application will open the instruction page.
	 *  <p> Draws this {@link Button} to {@link Pane}.
	 */
	public void drawInstructionButton() {
		instructionButton.setLayoutX(500);
		instructionButton.setLayoutY(750);
		instructionButton.setOnAction(event -> {GameController.INSTANCE.handleInstructionButtonPressed();});
		background.getChildren().add(instructionButton);
	}

	/**
	 * <p> Creates the {@link ProgressBar} and set the position and style
	 * <p> This progressbar will be used to show the remaining time of game
	 * and after the remaining time is zero, the game ends.
	 */
	public void drawProgressBar(){
		progressBar.setLayoutX(300);
		progressBar.setLayoutY(780);
		progressBar.setPrefWidth(300);
		progressBar.setProgress(0);
		background.getChildren().add(progressBar);
	}
}
