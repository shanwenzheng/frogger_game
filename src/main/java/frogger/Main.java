package frogger;

import frogger.controller.GameController;
import frogger.util.GameManager;
import frogger.util.MapLoader;
import frogger.view.GameView;
import javafx.application.Application;
import javafx.scene.Scene;
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
	
		GameManager.INSTANCE.init(gameView, scene);
		GameManager.INSTANCE.startGame();
	}
}
