package frogger.util;

import frogger.util.Animation;
import frogger.util.MusicPlayer;
import frogger.util.ScoreBoardUpdater;
import frogger.view.GameView;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;

public enum GameManager {
	INSTANCE;
	
	private GameView gameView;
	private Animation animation;
	private ScoreBoardUpdater scoreBoardUpdater;
	
	public void init(GameView gameView, Scene scene) {
		this.gameView = gameView;
		animation = new Animation(gameView);
		scoreBoardUpdater = new ScoreBoardUpdater(gameView);
		handleKeyEvent(scene);
	}
	
	public void handleKeyEvent(Scene scene) {
		scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> gameView.getMap().getAnimal().handleKeyPressed(event));
		scene.addEventHandler(KeyEvent.KEY_RELEASED, event -> gameView.getMap().getAnimal().handleKeyReleased(event));
	}
	
	public void startGame() {
	    MapLoader.mapLoad(gameView);
		musicStart();
		animationStart();
	}
	
	public void endGame() {
		musicStop();
		animationStop();
		printEndGameInfo();
	}
    
	public void musicStart() {
		MusicPlayer.INSTANCE.playMusic();
	}
	
	public void musicStop() {
		MusicPlayer.INSTANCE.stopMusic();
	}
	
	private void animationStart() {
		animation.getActTimer().start();	
	}
	
	private void animationStop() {
		animation.getActTimer().stop();
	}
	
	public ScoreBoardUpdater getScoreBoardUpdater() {
		return scoreBoardUpdater;
	}
	
	public void printEndGameInfo() {
		System.out.println("STOPP: ");
  		Alert alert = new Alert(AlertType.INFORMATION);
  		alert.setTitle("You Have Won The Game!");
  		alert.setHeaderText("Your High Score: "+gameView.getMap().getAnimal().getPoints()+"!");
  		alert.setContentText("Highest Possible Score: 800");
  		alert.show();
	}
}
