package frogger.util;

import java.net.URL;

import frogger.Main;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public enum MusicPlayer{
	INSTANCE;
	
	private MediaPlayer startScreenPlayer;
	private MediaPlayer selectPlayer;
	private MediaPlayer gamePlayer;
	private MediaPlayer losePlayer;
	private MediaPlayer winPlayer;
	
	public void init() {
		startScreenPlayer = initPlayer("music/GoodLuckCome.mp3");
		gamePlayer = initPlayer("music/Frogger Main Song Theme (loop).mp3");
	}
	
	public MediaPlayer initPlayer(String musicURL) {
		URL musicFile = Main.class.getResource(musicURL);
		Media sound = new Media(musicFile.toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		return mediaPlayer;
	}
	
	public void playStartScreenMusic() {
		stopMusic();
		startScreenPlayer.play();
	}
	
	public void playGameMusic() {
		stopMusic();
		gamePlayer.play();
	}
	
	public void playLoseMusic() {
		stopMusic();
		losePlayer.play();
	}
	
	public void playWinMusic() {
		stopMusic();
		winPlayer.play();
	}
	
	public void playSelectMusic() {
		stopMusic();
		selectPlayer.play();
	}
	
	public void stopMusic() {
		startScreenPlayer.stop();
		gamePlayer.stop();
//		selectPlayer.stop();
//		losePlayer.stop();
//		winPlayer.stop();
	}

}
