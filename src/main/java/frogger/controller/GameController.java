package frogger.controller;

import frogger.model.Score;
import frogger.model.actor.movableActor.Frog;
import frogger.model.actor.movableActor.MovableActor;
import frogger.model.actor.staticActor.End;
import frogger.util.Animation;
import frogger.util.MapLoader;
import frogger.util.MusicPlayer;
import frogger.util.ScoreBoardUpdater;
import frogger.view.GameView;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;

public enum GameController {
	INSTANCE;
	
	private AnimationTimer endDetecter;
	private GameView gameView;
	private Animation animation;
	
	public void init(GameView gameView, Scene scene) {
		createEndDetecter();
		this.gameView = gameView;
		animation = new Animation(gameView);
		MusicPlayer.INSTANCE.init();
		ScoreBoardUpdater.INSTANCE.init(gameView.getMap().getDigit());
		handleKeyEvent(scene);
	}
	
	public void handleKeyEvent(Scene scene) {
		scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> gameView.getMap().getAnimal().handleKeyPressed(event));
		scene.addEventHandler(KeyEvent.KEY_RELEASED, event -> gameView.getMap().getAnimal().handleKeyReleased(event));
	}
	
	public void startGame() {
	    loadMap();
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
	
	private void createEndDetecter() {
		endDetecter = new AnimationTimer() {
	      @Override
	      public void handle(long now) {
	      	if (checkEndActivited()) {
	      		endGame();
	      	}
	      }
	      
	      public boolean checkEndActivited() {
	    	  for(int i = 0; i < gameView.getMap().getEnd().size(); i++) {
	    		  if (!gameView.getMap().getEnd().get(i).isActivated()) {return false;}
	    	  }
	    	  return true;
	      }
		};
	}
	
	public void loadMap() {
		MapLoader.mapLoad(gameView);
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
	
	public void printEndGameInfo() {
		System.out.println("STOPP: ");
  		Alert alert = new Alert(AlertType.INFORMATION);
  		alert.setTitle("You Have Won The Game!");
  		alert.setHeaderText("Your High Score: "+gameView.getMap().getAnimal().getPoints()+"!");
  		alert.setContentText("Highest Possible Score: 800");
  		alert.show();
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
