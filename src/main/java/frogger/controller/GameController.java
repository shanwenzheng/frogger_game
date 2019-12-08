package frogger.controller;

import java.util.LinkedHashMap;

import frogger.model.Life;
import frogger.model.Map;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * <h2> GameController </h2>
 * 
 * <p> The {@link GameController} class is used to manage the process and status of game and reflect the game results to the view
 * 
 * <p><strong>Note:</strong> this class is implemented as an {@link Enum} thus to be a singleton class.
 * 
 * <p> <strong> Main Functionality: </strong>
 * <pre>
 * 		GameController.INSTANCE.startGame();
 * 		GameController.INSTANCE.endGame();
 *		GameController.INSTANCE.handleKeyEvent();
 *		GameController.INSTANCE.handleTouchEvent();
 *		GameController.INSTANCE.handleEndEvent();
 *		GameController.INSTANCE.handleButtonEvent();
 *		GameController.INSTANCE.handleScoreEvent();
 *		GameController.INSTANCE.handleLifeEvent();
 * </pre>
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see SceneSwitch
 * @see GameView
 * @see Map
 * @see Pane
 * @see Life
 * @see Score
 * @see ActAnimation
 * @see MusicPlayer
 * @see ScoreListWriter
 * @see ScoreBoardUpdater
 * @see ScoreBaseFactory
 */
public enum GameController {
	/** The shared instance for global use for whole project */
	INSTANCE;
	
	/** The game playing {@link Map} */
	private Map map;
	
	/** The game playing {@link Pane} */
	private Pane background;
	
	/** The {@link Life} of current game */
	private Life life;
	
	/** The {@link Score} of current game */
	private Score score;
	
	/** The nickName of current game */
	private String nickName;
	
	/** The gameLevel of current game */
	private String gameLevel;
	
	/** The number of end position has reached for current game */
	private int endCount;
	
	/** A temporary {@link LinkedHashMap} store the high score of each round. */
	private LinkedHashMap<Integer, Score> popupScoreList;
	
    /** 
     *  <p> Initializes the game properties based on the given {@link GameView},{@code nickName} and {@code gameLevel}. 
     *  
     *  @param gameView		The current game playing {@link GameView}
     *  @param nickName		The nickName of current game
     *  @param gameLevel 	The gameLevel of current game
     */
	public void init(GameView gameView, String nickName, String gameLevel) {
		endCount = 0;
		this.nickName = nickName;
		this.gameLevel = gameLevel;
		this.map = gameView.getMap();
		this.background = gameView.getBackground();
		this.score = new Score();
		this.life = new Life(map.getLifeImage().size());
		ActAnimation.INSTANCE.init(background);
		
		popupScoreList = new LinkedHashMap<Integer, Score>() {{
			for(int i = 0; i < life.getTotalLife(); i++) {
				put(i, new Score());
			}
		}};
	}
	
	/** <p>Starts the game
	 *
	 * <p> This method start the {@link MusicPlayer} and {@link ActAnimation} 
	 */
	public void startGame() {
		musicStart();
		animationStart();
	}
	
	/**
	 * <p> Ends the game
	 * 
	 * <p> This method stop the {@link MusicPlayer} and {@link ActAnimation}
	 * And if the {@link #life} is used up or {@link #endCount} equals to 5 then call {@link #handleGameEnd()}.
	 * 
	 * @param status	The status of ending game. 0 means end game by pressing button and 1 means end game by reach all the end position or lose all life and then call {@link #handleGameEnd()}.
	 */
	public void endGame(int status) {
		musicStop();
		animationStop();
		if(status == 1) {handleGameEnd();}
	}
	
	/** <p> Start playing the music by calling {@link MusicPlayer#playGameMusic()} */
	public void musicStart() {
		MusicPlayer.INSTANCE.playGameMusic();
	}
	
	/** <p> Stop playing the music by calling {@link MusicPlayer#stopMusic()} */
	public void musicStop() {
		MusicPlayer.INSTANCE.stopMusic();
	}
	
	/** <p> Start {@link ActAnimation} timer by calling {@link ActAnimation#actStart()} */
	private void animationStart() {
		ActAnimation.INSTANCE.actStart();
	}
	
	/** <p> Stop {@link ActAnimation} timer by calling {@link ActAnimation#actStop()} */
	private void animationStop() {
		ActAnimation.INSTANCE.actStop();
	}
	
	/**
	 * <p> This method call {@link frogger.model.actor.movableActor.Frog#moveKeyPressed(String)} when player presses a key.
	 * 
	 * <p> This method is added into {@link javafx.scene.Scene} in {@link SceneSwitch} and called when player presses a key.
	 *  
	 * @param event		Player pressed key event
	 */
	public void handleKeyPressedEvent(KeyEvent event) {
		map.getAnimal().moveKeyPressed(event.getText());
	}
	
	/**
	 * <p> This method call {@link frogger.model.actor.movableActor.Frog#moveKeyReleased(String)} when player releases a key.
	 * 
	 * <p> This method is added into {@link javafx.scene.Scene} in {@link SceneSwitch} and called when player releases a key.
	 *  
	 * @param event		Player pressed key event
	 */
	public void handleKeyReleasedEvent(KeyEvent event) {
		map.getAnimal().moveKeyReleased(event.getText());
	}
	
	/**
	 * <p> This method is called by {@link frogger.model.actor.movableActor.Turtle} or {@link frogger.model.actor.movableActor.Log} when they touch {@link frogger.model.actor.movableActor.Frog}.
	 * <p> This method calls {@link frogger.model.actor.movableActor.Frog#move(double, double)} to let frog move with input {@code actor} speed.
	 *  
	 * @param actor		The {@link MovableActor} who call this method
	 */
	public void handleLogTurtleTouched(MovableActor actor) {
		map.getAnimal().move(actor.getSpeed(), 0);
	}
	
	/**
	 * <p> This method is called by {@link frogger.model.actor.movableActor.Obstacle} when they touch {@link frogger.model.actor.movableActor.Frog}.
	 * <p> This method calls {@link frogger.model.actor.movableActor.Frog#setDeathType(String)} to set frog deathType to carDeath.
	 *  
	 * @param actor		The {@link MovableActor} who call this method
	 */
	public void handleObstacleTouched(MovableActor actor) {
		map.getAnimal().setDeathType("carDeath");
	}
	
	/**
	 * <p> This method is called by {@link frogger.model.actor.movableActor.WetTurtle} or {@link frogger.model.actor.movableActor.Frog} when frog sunk into pool.
	 * <p> This method calls {@link frogger.model.actor.movableActor.Frog#setDeathType(String)} to set frog deathType to waterDeath.
	 *  
	 * @param actor		The {@link MovableActor} who call this method
	 */
	public void handlePoolTouched(MovableActor actor) {
		map.getAnimal().setDeathType("waterDeath");
	}
	
	/**
	 * <p> This method is called by {@link frogger.model.actor.movableActor.Frog} when frog enter into terminal point.
	 * <p> This method will check whether the entered end position is activated. If is not activated, then handle score event and reset the property of frog
	 *  
	 * @param actor		The {@link MovableActor} who call this method
	 */
	public void handleEndTouched(MovableActor actor) {
		if(!actor.getIntersectingObjects(End.class).get(0).isActivated()) {
			actor.getIntersectingObjects(End.class).get(0).setEnd();
			handleScoreChanged(50);
			map.getAnimal().setOrigin(1);
			endCount++;
		}
		
		if(endCount == 5) { endGame(1);}
	}

	/**
	 * <p>	This method handle the {@link Score} add or subtract based on the given input {@code points} and call {@link ScoreBoardUpdater#updateScore(int, java.util.ArrayList)}
	 * to update scoreBoard view in {@link Map}. This method also called {@link #handlePopupScoreListChanged(int)} to update the current round score list.
	 * 
	 * @param points	The point will be added or subtracted in {@link #score}
	 */
	public void handleScoreChanged(int points) {
		int changePoints = 0;
		if(points > 0) {
			score.addScore(points);
			changePoints = points;
		} else if (score.getScore() > 50) {
			score.subScore(Math.abs(points));
			changePoints = points;
		}
		ScoreBoardUpdater.INSTANCE.updateScore(score.getScore(), map.getScoreBoard());
		handlePopupScoreListChanged(changePoints);
	}

	/**
	 * <p> This method handle the {@link Life} lose situation and remove the corresponding imageView in {@link Map}
	 * <p> This method also check if {@link Life#getRemainingLife()} equals to 0, then call {@link #endGame(int)}
	 */
	public void handleLifeLosed() {
		life.loseLife();
		int index = life.getRemainingLife();
		background.getChildren().remove(map.getLifeImage().get(index));
		SceneSwitch.INSTANCE.switchToPopup(popupScoreList);
		
		if(life.getRemainingLife() == 0) {endGame(1);}
	}
	
    /** <p> Called when the home {@link javafx.scene.control.Button} is clicked and back to the start screen as well as {@link #endGame(int)} */
	public void handleHomeButtonPressed() {
		endGame(0);
		SceneSwitch.INSTANCE.switchToStartScreen();
	}
	
	/** <p> Called when the restart {@link javafx.scene.control.Button} is clicked and restart the game */
	public void handleRestartButtonPressed() {
		endGame(0);
		SceneSwitch.INSTANCE.switchToGame(nickName, gameLevel);
	}
	
	/** <p> Called when the instruction {@link javafx.scene.control.Button} is clicked and show the instruction screen */
	public void handleInstructionButtonPressed() {
		SceneSwitch.INSTANCE.switchToInstruction();
	}
	
	/** 
	 * <p> This method is called when the remaining life is zero or the {@link #endCount} is five.
	 * <p> After calling this method, it write the {@link Score} and corresponding nickName into file by calling {@link ScoreListWriter#writeInFile(String, Score)}
	 * and call {@link SceneSwitch#switchToScoreList(String, Score)} to show the high score list to player. 
	 * Moreover, this method also create an additional score points based on the {@link #gameLevel} by calling {@link ScoreBaseFactory#createScoreBase(String)}. 
	 */
	public void handleGameEnd() {
		score.addScore(ScoreBaseFactory.createScoreBase(gameLevel));
		ScoreListWriter.INSTANCE.writeInFile(nickName, score);
		
		String gameStatus = endCount == 5 ? "Win" : "Lose";
		SceneSwitch.INSTANCE.switchToPopup(popupScoreList);
		SceneSwitch.INSTANCE.switchToScoreList(gameStatus, score);
	}
	
	/**
	 * <p> This method update the current round popup socre list with given {@code point} and called by {@link #handleScoreChanged(int)}.
	 *  
	 * @param points	The changed point will be added or subtracted in {@link #popupScoreList}
	 */
	public void handlePopupScoreListChanged(int points) {
		int index = life.getTotalLife() - life.getRemainingLife();
		
		if(points > 0) {
			popupScoreList.get(index).addScore(points);
		}else{
			popupScoreList.get(index).subScore(Math.abs(points));
		}
	}
}
