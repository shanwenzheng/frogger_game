package view;

import javafx.scene.layout.Pane;
import model.Map;
import model.actor.staticActor.Digit;
import util.MapFactory;

public class GameView {
	private Pane background;
	private Map map;

	public GameView(String gameLevel) {
		background = new Pane();
		map = MapFactory.createMap(gameLevel);
	}
	
	public Pane getBackground() {
		return background;
	}
	
	public Map getMap() {
		return map;
	}

	public void drawBackgroundImage() {
		background.getChildren().add(map.getBackgroundImage());
	}
	
	public void drawLog() {
		background.getChildren().addAll(map.getLogs());
	}
	
	public void drawTurtle() {
		background.getChildren().addAll(map.getTurtles());
	}
	
	public void drawEnd() {
		background.getChildren().addAll(map.getEnd());
	}
	
	public void drawAnimal() {
		background.getChildren().add(map.getAnimal());
	}
	
	public void drawObstacle() {
		background.getChildren().addAll(map.getObstacles());
	}
	
	public void drawDigit() {
		background.getChildren().add(new Digit(0, 30, 565, 25));
		background.getChildren().add(new Digit(0, 30, 535, 25));
		background.getChildren().add(new Digit(0, 30, 505, 25));
	}
}