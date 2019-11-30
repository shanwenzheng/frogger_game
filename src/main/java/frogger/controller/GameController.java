package frogger.controller;

import frogger.model.Score;
import frogger.model.actor.movableActor.MovableActor;
import frogger.model.actor.staticActor.End;
import frogger.util.ActAnimation;
import frogger.util.EndDetecter;
import frogger.util.MusicPlayer;
import frogger.util.ScoreBoardUpdater;
import frogger.view.GameView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;

public enum GameController {
	INSTANCE;
	private GameView gameView;
	private Score score;
	
	public void init(GameView gameView) {
		this.gameView = gameView;	
		this.score = new Score();
		ActAnimation.INSTANCE.init(gameView.getBackground());
		MusicPlayer.INSTANCE.init("music/Frogger Main Song Theme (loop).mp3");
	}
	
	public void startGame() {
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
		ActAnimation.INSTANCE.actStart();
	}
	
	private void animationStop() {
		ActAnimation.INSTANCE.actStop();
	}
	
	public void printEndGameInfo() {
		System.out.println("STOPP: ");
  		Alert alert = new Alert(AlertType.INFORMATION);
  		alert.setTitle("You Have Won The Game!");
  		alert.setHeaderText("Your High Score: "+score.getScore()+"!");
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
			actor.getIntersectingObjects(End.class).get(0).setEnd();
			handleScoreChanged(50);
			gameView.getMap().getAnimal().setOrigin(1);
		}
		if(EndDetecter.INSTANCE.checkEndActivited(gameView.getMap().getEnd())) {
			endGame();
		}
	}
	
	public void handleScoreChanged(int points) {
		if(points > 0) {
			score.addScore(points);
		} else if (score.getScore() > 50) {
			score.subScore(Math.abs(points));
		}
		ScoreBoardUpdater.INSTANCE.updateScore(score.getScore(), gameView.getMap().getScoreBoard());
	}
}
