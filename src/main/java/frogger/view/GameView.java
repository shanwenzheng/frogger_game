package frogger.view;

import frogger.model.Map;
import frogger.util.MapFactory;
import javafx.scene.layout.Pane;

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
		background.setStyle(map.getBackgroundImage());
	}
	
	public void drawLog() {
		background.getChildren().addAll(map.getLogs());
	}
	
	public void drawTurtle() {
		background.getChildren().addAll(map.getTurtles());
	}
	
	public void drawWetTurtle() {
		background.getChildren().addAll(map.getWetTurtles());
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
		background.getChildren().addAll(map.getScoreBoard());
	}
}
