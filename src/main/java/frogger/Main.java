package frogger;

import frogger.service.MusicPlayer;
import frogger.service.SceneSwitch;
import javafx.application.Application;
import javafx.stage.Stage;

/** 
 * The {@link Main} class for the frogger game application
 * 
 * <p> This class is the entrnace of program also the plugin of maven project
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see MusicPlayer
 * @see SceneSwitch
 */
public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Starts the application
	 * 
	 * @param primaryStage the primary stage of frogger game application
	 */
	@Override
	public void start(Stage primaryStage){
		MusicPlayer.INSTANCE.init();
		SceneSwitch.INSTANCE.init(primaryStage);
		
		primaryStage.setTitle("Frogger Game");
		primaryStage.setResizable(false);
		
		SceneSwitch.INSTANCE.switchToStartScreen();
	}
}
