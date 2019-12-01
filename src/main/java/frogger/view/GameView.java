package frogger.view;

import frogger.model.Map;
import frogger.util.MapFactory;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class GameView {
	private Pane background;
	private Map map;
	private Label scoreLabel;
	private Label highScoreLabel;

	public GameView(String gameLevel) throws Exception {
		background = new Pane();
		scoreLabel = new Label();
		highScoreLabel = new Label();
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
		initScoreBoard(scoreLabel, "C-SCORE", 504, 742);
		background.getChildren().add(scoreLabel);
		background.getChildren().addAll(map.getScoreBoard());
	}
	
	public void drawHighScoreBoard() {
		initScoreBoard(highScoreLabel, "H-SCORE", 304, 742);
        background.getChildren().add(highScoreLabel);
		background.getChildren().addAll(map.getHighScoreBoard());
	}
	
	public void initScoreBoard(Label label, String str, int xPos, int yPos) {
		label.setText(str);
		label.setLayoutX(xPos);
		label.setLayoutY(yPos);
	}
}
