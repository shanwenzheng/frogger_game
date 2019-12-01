package frogger.util;

import frogger.view.GameView;

public class MapLoader {
	
	public static void mapLoad(GameView gameView) {
		gameView.drawLog();
		gameView.drawTurtle();
		gameView.drawWetTurtle();
		gameView.drawEnd();
		gameView.drawAnimal();
		gameView.drawObstacle();
		gameView.drawScoreBoard();
		gameView.drawHighScoreBoard();
		gameView.drawLifeImage();
	}
}
