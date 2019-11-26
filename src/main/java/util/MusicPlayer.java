package frogger;

import java.io.File;
import java.net.URL;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class MusicPlayer{
	MediaPlayer mediaPlayer;
	
	public MusicPlayer() {}
	
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
