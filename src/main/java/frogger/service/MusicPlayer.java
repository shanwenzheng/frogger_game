package frogger.service;

import java.net.URL;

import frogger.Main;
import frogger.constant.FileName;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * <h2> MusicPlayer </h2>
 * 
 * <p> The {@link MusicPlayer} class is an singleton class of utility to provide some methods to play sounds in different pages
 * 
 * <p><strong>Note:</strong> this class is implemented as an {@link Enum} thus to be a singleton class.
 * 
 * <p><strong>Main Functionality:</strong>
 * 
 * <pre>
 *		MusicPlayer.INSTANCE.playStartScreenMusic();
 *		MusicPlayer.INSTANCE.playSelectMusic();
 *		MusicPlayer.INSTANCE.playGameMusic();
 *		MusicPlayer.INSTANCE.playLoseMusic();
 *		MusicPlayer.INSTANCE.playWinMusic();
 * </pre>
 * 
 * <p><strong>Use:</strong>
 * 
 * <pre>
 * 		MusicPlayer.INSTANCE.init();
 * 		MusicPlayer.INSTANCE.{PLAY_MUSIC_METHOD}();
 * </pre>
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 */
public enum MusicPlayer{
	/** The shared instance for global use for whole project */
	INSTANCE;
	
	/** The {@link MediaPlayer} for playing StartScreen music */
	private MediaPlayer startScreenPlayer;
	/** The {@link MediaPlayer} for playing SelectScreen music */
	private MediaPlayer selectPlayer;
	/** The {@link MediaPlayer} for playing Game music */
	private MediaPlayer gamePlayer;
	/** The {@link MediaPlayer} for playing SocreList(Lose) music */
	private MediaPlayer losePlayer;
	/** The {@link MediaPlayer} for playing ScoreList(Win) music */
	private MediaPlayer winPlayer;
	
	/**
	 * <p> The initialize method to initializes every {@link MediaPlayer} in this class
	 */
	public void init() {
		startScreenPlayer = initPlayer(FileName.MUSIC_START);
		selectPlayer = initPlayer(FileName.MUSIC_SELECT);
		gamePlayer = initPlayer(FileName.MUSIC_GAME);
		losePlayer = initPlayer(FileName.MUSIC_DEFEAT);
		winPlayer = initPlayer(FileName.MUSIC_VICTORY);
	}
	
	/**
	 * <p> Creates a {@link MediaPlayer} based on the given music fileName
	 * 
	 * @param musicURL	the music's path to be generated into {@link MediaPlayer}
	 * @return		{@link MediaPlayer} depend on the given music path.
	 */
	public MediaPlayer initPlayer(String musicURL) {
		URL musicFile = Main.class.getResource(musicURL);
		Media sound = new Media(musicFile.toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		return mediaPlayer;
	}
	
	/** <p> Plays the StartScreenMusic */
	public void playStartScreenMusic() {
		stopMusic();
		startScreenPlayer.play();
	}
	
	/** <p> Plays the Game Music */
	public void playGameMusic() {
		stopMusic();
		gamePlayer.play();
	}
	
	/** <p> Plays the game lose music */
	public void playLoseMusic() {
		stopMusic();
		losePlayer.play();
	}
	
	/** <p> Plays the game win music */
	public void playWinMusic() {
		stopMusic();
		winPlayer.play();
	}
	
	/** <p> Plays the SelectScreenMusic */
	public void playSelectMusic() {
		stopMusic();
		selectPlayer.play();
	}
	
	/** <p> Stops all the {@link MediaPlayer} playing music */
	public void stopMusic() {
		startScreenPlayer.stop();
		gamePlayer.stop();
		selectPlayer.stop();
		losePlayer.stop();
		winPlayer.stop();
	}

}
