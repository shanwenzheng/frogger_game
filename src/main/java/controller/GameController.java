package controller;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Digit;
import util.Animation;
import util.MusicPlayer;
import util.ScoreBoardUpdater;
import view.GameView;

public class GameController {
	private AnimationTimer timer;
	private GameView gameView;
	private Animation animation;
	private ScoreBoardUpdater scoreBoardUpdater;
	
	public GameController(GameView gameView) {
		createTimer();
		this.gameView = gameView;
		animation = new Animation(gameView);
		scoreBoardUpdater = new ScoreBoardUpdater(gameView);
	}
	
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
      	      	if (gameView.getAnimal().getStop()) {
      	      		endGame();
      	      	}
      	      }
      		};
    	}
	
	public void startGame() {
		musicStart();
		timer.start();
		animationStart();
		scoreBoardUpdaterStart();
	}

	public void endGame() {
		musicStop();
		timer.stop();
		animationStop();
		scoreBoardUpdaterStop();
		printEndGameInfo();
	}
    
	public void musicStart() {
		MusicPlayer.INSTANCE.playMusic();
	}
	
	public void musicStop() {
		MusicPlayer.INSTANCE.stopMusic();
	}
	
	private void animationStart() {
		animation.getTimer().start();	
	}
	
	private void animationStop() {
		animation.getTimer().stop();
	}
	
	private void scoreBoardUpdaterStart() {
		scoreBoardUpdater.getTimer().start();
	}
	
	private void scoreBoardUpdaterStop() {
		scoreBoardUpdater.getTimer().stop();
	}
	
	public void printEndGameInfo() {
		System.out.println("STOPP: ");
  		Alert alert = new Alert(AlertType.INFORMATION);
  		alert.setTitle("You Have Won The Game!");
  		alert.setHeaderText("Your High Score: "+gameView.getAnimal().getPoints()+"!");
  		alert.setContentText("Highest Possible Score: 800");
  		alert.show();
	}
}
