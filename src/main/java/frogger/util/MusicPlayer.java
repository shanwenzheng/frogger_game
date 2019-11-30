package frogger.util;

import java.net.URL;

import frogger.Main;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public enum MusicPlayer{
	INSTANCE;
	
	MediaPlayer mediaPlayer;
	
	public void playMusic() {
		URL musicFile = Main.class.getResource("music/Frogger Main Song Theme (loop).mp3");
		Media sound = new Media(musicFile.toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
