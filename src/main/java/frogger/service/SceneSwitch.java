package frogger.service;

import java.io.IOException;

import frogger.Main;
import frogger.controller.GameController;
import frogger.view.GameView;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;

public enum SceneSwitch {
	INSTANCE;
	
	private Stage primaryStage;
	private Stage instructionStage;
	
	public void init(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void switchToStartScreen() {
		try {
			MusicPlayer.INSTANCE.playStartScreenMusic();
			Pane root = FXMLLoader.load(Main.class.getResource("view/startScreen.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void switchToGame(String nickName, String gameLevel) {
		try {
			GameView gameView = new GameView(gameLevel);
			gameView.drawBackground();
		    Scene scene = new Scene(gameView.getBackground(),600,800);
		
			GameController.INSTANCE.init(gameView);
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
	
	public void switchToSelect() {
		try {
			MusicPlayer.INSTANCE.playSelectMusic();
			Pane root = FXMLLoader.load(Main.class.getResource("view/select.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void switchToInstruction() {
		try {
	        instructionStage = new Stage();
	        Pane root = FXMLLoader.load(Main.class.getResource("view/instruction.fxml")); 
	        Scene scene = new Scene(root);
	        instructionStage.setScene(scene);
	        instructionStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void exitProgram() {
		Platform.exit();
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public Stage getInstructionStage() {
		return instructionStage;
	}
}
