package frogger.view;

import frogger.model.Map;
import frogger.util.MapFactory;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class GameView {
	private Pane background;
	private Map map;

	public GameView(String gameLevel) throws Exception {
		background = new Pane();
		map = MapFactory.createMap(gameLevel);
	}
	
	public Pane getBackground() {
		return background;
	}
	
	public Map getMap() {
		return map;
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
		background.getChildren().addAll(map.getEnds());
	}
	
	public void drawAnimal() {
		background.getChildren().add(map.getAnimal());
	}
	
	public void drawObstacle() {
		background.getChildren().addAll(map.getObstacles());
	}
	
	public void drawLifeImage() {
		background.getChildren().addAll(map.getLifeImage());
	}
	
	public void drawScoreBoard() {
		background.getChildren().add(createLabel("C-SCORE", 504, 742));
		background.getChildren().addAll(map.getScoreBoard());
	}
	
	public void drawHighScoreBoard() {
        background.getChildren().add(createLabel("H-SCORE", 304, 742));
		background.getChildren().addAll(map.getHighScoreBoard());
	}
	
	public Label createLabel(String str, int xPos, int yPos) {
		Label label = new Label(str);
		label.setLayoutX(xPos);
		label.setLayoutY(yPos);
		return label;
	}
}
