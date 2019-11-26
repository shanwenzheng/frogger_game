package frogger;

import controller.GameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.GameView;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	    GameView gameView = new GameView();
	    Scene scene  = new Scene(gameView.getBackground(),600,800);
	    gameView.drawMap();
	    
		primaryStage.setScene(scene);
		primaryStage.show();
	
		GameController gameController = new GameController(gameView, scene);
		gameController.startGame();
	}
}
