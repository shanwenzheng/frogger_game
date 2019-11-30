package frogger;

import frogger.controller.GameController;
import frogger.util.MapLoader;
import frogger.view.GameView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		GameView gameView = new GameView("NormalMode");
	    Scene scene  = new Scene(gameView.getBackground(),600,800);
	    MapLoader.mapLoad(gameView);
	    
	    primaryStage.setTitle("Frogger Game");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	
//		GameController gameController = new GameController(gameView, scene);
		GameController.INSTANCE.init(gameView);
		GameController.INSTANCE.startGame();
		
		scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> GameController.INSTANCE.handleKeyPressedEvent(event));
		scene.addEventHandler(KeyEvent.KEY_RELEASED, event -> GameController.INSTANCE.handleKeyReleasedEvent(event));
	}
}
