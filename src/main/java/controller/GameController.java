package controller;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import util.Animation;
import util.MusicPlayer;
import util.ScoreBoardUpdater;
import view.GameView;

public class GameController {
	private AnimationTimer endDetecter;
	private GameView gameView;
	private Animation animation;
	private ScoreBoardUpdater scoreBoardUpdater;
	
	public GameController(GameView gameView, Scene scene) {
		createEndDetecter();
		this.gameView = gameView;
		animation = new Animation(gameView);
		scoreBoardUpdater = new ScoreBoardUpdater(gameView);
		
		scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> gameView.getMap().getAnimal().handleKeyPressed(event));
		scene.addEventHandler(KeyEvent.KEY_RELEASED, event -> gameView.getMap().getAnimal().handleKeyReleased(event));
	}
	
	public void startGame() {
		musicStart();
		endDetecterStart();
		animationStart();
		scoreBoardUpdaterStart();
	}
	
	public void endGame() {
		musicStop();
		endDetecterStop();
		animationStop();
		scoreBoardUpdaterStop();
		printEndGameInfo();
	}
	
	private void createEndDetecter() {
		endDetecter = new AnimationTimer() {
	      @Override
	      public void handle(long now) {
	      	if (gameView.getMap().getAnimal().getStop()) {
	      		endGame();
	      	}
	      }
		};
	}
	
	public void endDetecterStart() {
		endDetecter.start();
	}
	
	public void endDetecterStop() {
		endDetecter.stop();
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
	
	private void scoreBoardUpdaterStart() {
		scoreBoardUpdater.getScoreUpdaterTimer().start();
	}
	
	private void scoreBoardUpdaterStop() {
		scoreBoardUpdater.getScoreUpdaterTimer().stop();
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
