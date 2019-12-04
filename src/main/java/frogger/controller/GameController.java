package frogger.controller;

import frogger.model.Life;
import frogger.model.Score;
import frogger.model.actor.movableActor.MovableActor;
import frogger.model.actor.staticActor.End;
import frogger.service.ActAnimation;
import frogger.service.MusicPlayer;
import frogger.service.SceneSwitch;
import frogger.service.ScoreBaseFactory;
import frogger.service.ScoreBoardUpdater;
import frogger.service.ScoreListWriter;
import frogger.view.GameView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;

public enum GameController {
	INSTANCE;
	
	private GameView gameView;
	private Life life;
	private Score score;
	private Score highScore;
	private String nickName;
	private String gameLevel;
	private int endCount;
	
	public void init(GameView gameView, String nickName, String gameLevel) {
		endCount = 0;
		this.nickName = nickName;
		this.gameLevel = gameLevel;
		this.gameView = gameView;	
		this.score = new Score();
		this.highScore = new Score();
		this.life = new Life(gameView.getMap().getLifeImage().size());
		ActAnimation.INSTANCE.init(gameView.getBackground());
	}
	
	public void startGame() {
		musicStart();
		animationStart();
	}
	
	/* 0 means end game by pressing button. 1 means end game by reach all the end position or lose all life) */
	public void endGame(int status) {
		musicStop();
		animationStop();
		if(status == 1) {handleGameEnd();}
	}
	
	public void musicStart() {
		MusicPlayer.INSTANCE.playGameMusic();
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
			endCount++;
		}
		
		if(endCount == 5) { endGame(1);}
	}

	public void handleScoreChanged(int points) {
		if(points > 0) {
			score.addScore(points);
		} else if (score.getScore() > 50) {
			score.subScore(Math.abs(points));
		}
		ScoreBoardUpdater.INSTANCE.updateScore(score.getScore(), gameView.getMap().getScoreBoard());
		
		if(score.getScore() > highScore.getScore()) {
			highScore.setScore(score.getScore());
			ScoreBoardUpdater.INSTANCE.updateScore(highScore.getScore(), gameView.getMap().getHighScoreBoard());
		}
	}

	public void handleLifeLosed() {
		life.loseLife();
		int index = life.getRemainingLife();
		gameView.getBackground().getChildren().remove(gameView.getMap().getLifeImage().get(index));
		
		if(life.getRemainingLife() == 0) {endGame(1);}
	}
	
	public void handleHomeButtonPressed() {
		endGame(0);
		SceneSwitch.INSTANCE.switchToStartScreen();
	}
	
	public void handleRestartButtonPressed() {
		endGame(0);
		SceneSwitch.INSTANCE.switchToGame(nickName, gameLevel);
	}
	
	public void handleInstructionButtonPressed() {
		SceneSwitch.INSTANCE.switchToInstruction();
	}
	
	public void handleGameEnd() {
		score.addScore(ScoreBaseFactory.createScoreBase(gameLevel));
		ScoreListWriter.INSTANCE.writeInFile(nickName, score);
		
		String gameStatus = endCount == 5 ? "Win" : "Lose";
		SceneSwitch.INSTANCE.switchToScoreList(gameStatus, score);
	}
}
