package frogger.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import frogger.Main;
import frogger.constant.FileName;
import frogger.controller.GameController;
import frogger.controller.PopupController;
import frogger.model.Score;
import frogger.view.GameView;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;

/**
 * 
 * <h2>SceneSwitch</h2>
 * 
 * <p>The {@link SceneSwitch} class is an singleton class of utility to provide some methods to switch between
 * different scenes in the primary Stage ({@link SceneSwitch#getPrimaryStage()}). Moreover, this class also create a new 
 * instructionStage({@link SceneSwitch#getInstructionStage()}) to show the instruction.
 * 
 * <p><strong>Note:</strong> this class is implemented as an {@link Enum} thus to be a singleton class.
 * 
 * <p><strong>Main Functionality:</strong>
 * 
 * <pre>
 * 		SceneSwitch.INSTANCE.switchToHome();
 * 		SceneSwitch.INSTANCE.switchToSelect();
 * 		SceneSwitch.INSTANCE.switchToGame(nickName, gameLevel);
 * 		SceneSwitch.INSTANCE.switchToInstruction();
 * 		SceneSwitch.INSTANCE.switchToScoreList(gameStatus, Score);
 * </pre>
 * 
 * <p><strong>Use:</strong>
 * 
 * <pre>
 * 		SceneSwitch.INSTANCE.{METHOD}()
 * </pre>
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @See MusicPlayer
 * @See GameController
 * @See InstructionController
 * @See ScoreListController
 * @See SelectController
 * @See StartScreenController
 * @See PopupController
 */
public enum SceneSwitch {
	/** The shared instance for global use for whole project */
	INSTANCE;
	
	/** The primary stage of the application */
	private Stage primaryStage;
	/** The instruction stage of the application */
	private Stage instructionStage;
	/** The high score popup stage of the application */
	private Stage popupStage;
	
	
	/**
	 * <p>Initializes the primaryStage of application based on the given {@link Stage} from {@link Main#start()}
	 * and create instructionStage and popoupStage using new Stage().
	 * 
	 * @param primaryStage the primaryStage of application
	 */
	public void init(Stage primaryStage) {
		this.primaryStage = primaryStage;
		instructionStage = new Stage();
		popupStage = new Stage();
	}
	
	/**
	 * <p>Switch the current scene to StartScreen
	 */
	public void switchToStartScreen() {
		try {
			MusicPlayer.INSTANCE.playStartScreenMusic();
			Pane root = FXMLLoader.load(Main.class.getResource(FileName.VIEW_START));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <p>Switch the current scene to game Page
	 * 
	 * <p>The {@link GameView} will changed depend on the gameLevel and this method also addEventHandler to scene and add CSS styleSheet.
	 * 
	 * @param nickName The name of current player (passed from {@link frogger.controller.SelectController})
	 * @param gameLevel The leve; of current game (passed from {@link frogger.controller.SelectController});
	 */
	public void switchToGame(String nickName, String gameLevel) {
		try {
			GameView gameView = new GameView(gameLevel);
			gameView.drawBackground();
		    Scene scene = new Scene(gameView.getBackground(),600,800);
		
			GameController.INSTANCE.init(gameView, nickName, gameLevel);
			GameController.INSTANCE.startGame();
			
			scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> GameController.INSTANCE.handleKeyPressedEvent(event));
			scene.addEventHandler(KeyEvent.KEY_RELEASED, event -> GameController.INSTANCE.handleKeyReleasedEvent(event));
			scene.getStylesheets().add(Main.class.getResource("css/game.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <p>Switch the current scene to StartScreen
	 */
	public void switchToSelect() {
		try {			
			MusicPlayer.INSTANCE.playSelectMusic();
			Pane root = FXMLLoader.load(Main.class.getResource(FileName.VIEW_SELECT));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <p>Open the instruction stage
	 */
	public void switchToInstruction() {
		try {
	        Pane root = FXMLLoader.load(Main.class.getResource(FileName.VIEW_INSTRUCTION)); 
	        Scene scene = new Scene(root);
	        instructionStage.setTitle("Instruction");
	        instructionStage.setResizable(false);
	        instructionStage.setScene(scene);
	        instructionStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <p> Open the Popup stage
	 * 
	 * @param popupScoreList	A temporary {@link ArrayList} store the high score of each round.
	 */
	public void switchToPopup(LinkedHashMap<Integer, Score> popupScoreList) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(FileName.VIEW_POPUP));
			Pane root = fxmlLoader.load();
			PopupController popupController = fxmlLoader.getController();
			popupController.setPopupScoreList(popupScoreList);
			
			Scene scene = new Scene(root);
			instructionStage.setTitle("Instruction");
			instructionStage.setResizable(false);
			instructionStage.setScene(scene);
			instructionStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <p>Switch the current scene to ScoreList
	 * 
	 * <p>Show the different image of game status and play different music depend on status parameters 
	 * and show the score of this currentGame
	 * 
	 * @param	status status == "Win" if game victory, == "Lose" if game defeat (passed from {@link frogger.controller.GameController#handleGameEnd()})
	 * @param	score The score of currentGame (passed from {@link frogger.controller.GameController#handleGameEnd()}
	 */
	public void switchToScoreList(String status, Score score) {
		try {
			ImageView statusImage = new ImageView();
			statusImage.setLayoutX(70);
			statusImage.setLayoutY(30);
			
			if(status.equals("Win")) {
				statusImage.setImage(new Image(Main.class.getResourceAsStream(FileName.IMAGE_VICTORY), 450, 450, true, true));
				MusicPlayer.INSTANCE.playWinMusic();
			}else {
				statusImage.setImage(new Image(Main.class.getResourceAsStream(FileName.IMAGE_DEFEAT), 450, 450, true, true));
				MusicPlayer.INSTANCE.playLoseMusic();
			}
			
			Text currentScore = new Text("Your Score: " + score.getScore());
			currentScore.setLayoutX(70);
			currentScore.setLayoutY(260);
			currentScore.setId("currentScore");
			
			Pane root = FXMLLoader.load(Main.class.getResource(FileName.VIEW_HIGHSCORELIST));
			root.getChildren().add(statusImage);
			root.getChildren().add(currentScore);
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exit the application
	 */
	public void exitProgram() {
		Platform.exit();
	}
	
	/**
	 * Returns the primary stage of the application
	 * 
	 * @return	the primary stage of the application
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	/**
	 * Returns the instruction stage of the application
	 * 
	 * @return	the instruction stage of the application
	 */
	public Stage getInstructionStage() {
		return instructionStage;
	}

	/**
	 * Returns the popup stage of the application
	 * 
	 * @return	the popup stage of the application
	 */
	public Stage getPopupStage() {
		return popupStage;
	}
}

