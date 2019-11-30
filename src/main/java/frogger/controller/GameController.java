package frogger.controller;

import frogger.model.actor.movableActor.MovableActor;
import frogger.model.actor.staticActor.End;
import frogger.util.ActAnimation;
import frogger.util.EndDetecter;
import frogger.util.MusicPlayer;
import frogger.util.ScoreBoardUpdater;
import frogger.view.GameView;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;

public enum GameController {
	INSTANCE;
	private GameView gameView;
	
	public void init(GameView gameView) {
		this.gameView = gameView;	
		MusicPlayer.INSTANCE.init();
		EndDetecter.INSTANCE.init(gameView);
		ActAnimation.INSTANCE.init(gameView);
		ScoreBoardUpdater.INSTANCE.init(gameView.getMap().getDigit());
	}
	
	public void startGame() {
		endDetecterStart();
		musicStart();
		animationStart();
	}
	
	public void endGame() {
		endDetecterStop();
		musicStop();
		animationStop();
		printEndGameInfo();
	}
	
	public void endDetecterStart() {
		EndDetecter.INSTANCE.endDetectStart();
	}
	
	public void endDetecterStop() {
		EndDetecter.INSTANCE.endDetectStop();
	}
    
	public void musicStart() {
		MusicPlayer.INSTANCE.playMusic();
	}
	
	public void musicStop() {
		MusicPlayer.INSTANCE.stopMusic();
	}
	
	private void animationStart() {
		ActAnimation.INSTANCE.actStart();
	}
	
	private void animationStop() {
		ActAnimation.INSTANCE.actStop();
	}
	
	public void printEndGameInfo() {
		System.out.println("STOPP: ");
  		Alert alert = new Alert(AlertType.INFORMATION);
  		alert.setTitle("You Have Won The Game!");
  		alert.setHeaderText("Your High Score: "+gameView.getMap().getAnimal().getPoints()+"!");
  		alert.setContentText("Highest Possible Score: 800");
  		alert.show();
	}
	
	public void handleKeyPressedEvent(KeyEvent event) {
		gameView.getMap().getAnimal().moveKeyPressed(event.getText());
	}
	
	public void handleKeyReleasedEvent(KeyEvent event) {
		gameView.getMap().getAnimal().moveKeyReleased(event.getText());
	}
	
	public void handleLogTurtleTouched(MovableActor actor) {
		gameView.getMap().getAnimal().move(actor.getSpeed(), 0);
	}
	
	public void handleObstacleTouched(MovableActor actor) {
		gameView.getMap().getAnimal().setDeathType("carDeath");
	}
	
	public void handlePoolTouched(MovableActor actor) {
		gameView.getMap().getAnimal().setDeathType("waterDeath");
	}
	
	public void handleEndTouched(MovableActor actor) {
		if(!actor.getIntersectingObjects(End.class).get(0).isActivated()) {
			gameView.getMap().getAnimal().getPoints().addScore(50);
			actor.getIntersectingObjects(End.class).get(0).setEnd();
		}
	}
}
