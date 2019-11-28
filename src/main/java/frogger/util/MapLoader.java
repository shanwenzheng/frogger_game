package frogger.util;

import frogger.view.GameView;

public class MapLoader {
	
	public static void mapLoad(GameView gameView) {
		gameView.drawBackgroundImage();
		gameView.drawLog();
		gameView.drawTurtle();
		gameView.drawEnd();
		gameView.drawAnimal();
		gameView.drawObstacle();
		gameView.drawDigit();
	}
}
