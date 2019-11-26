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
	private MusicPlayer musicPlayer;
	private Animation animation;
	private ScoreBoardUpdater scoreBoardUpdater;
	
	public GameController(GameView gameView) {
		createTimer();
		this.gameView = gameView;
		musicPlayer = new MusicPlayer();
		animation = new Animation(gameView);
		scoreBoardUpdater = new ScoreBoardUpdater(gameView);
	}
	
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (gameView.getAnimal().getStop()) {
            		System.out.print("STOPP:");
            		musicPlayer.stopMusic();
            		stop();
            		animation.getTimer().stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+gameView.getAnimal().getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            	}
            }
        };
    }
	public void start() {
		musicPlayer.playMusic();
		animation.getTimer().start();
		scoreBoardUpdater.getTimer().start();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  gameView.getBackground().getChildren().add(new Digit(k, 30, 360 - shift, 25));
    		  shift+=30;
    		}
    }
}
