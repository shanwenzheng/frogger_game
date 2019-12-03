package frogger.view;

import frogger.controller.GameController;
import frogger.model.Map;
import frogger.service.MapFactory;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class GameView {
	private Pane background;
	private Map map;
	private Button homeButton;
	private Button restartButton;
	private Button instructionButton;

	public GameView(String gameLevel) throws Exception {
		background = new Pane();
		homeButton = new Button("🏠");
		restartButton = new Button("🔄");
		instructionButton = new Button("❓");
		map = MapFactory.createMap(gameLevel);
	}
	
	public void drawBackground() {
		drawLog();
		drawTurtle();
		drawWetTurtle();
		drawEnd();
		drawAnimal();
		drawObstacle();
		drawScoreBoard();
		drawHighScoreBoard();
		drawLifeImage();
		drawHomeButton();
		drawInstructionButton();
		drawRestartButton();
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
	
	public void drawHomeButton() {
		homeButton.setLayoutX(420);
		homeButton.setLayoutY(25);
		homeButton.setOnAction(event -> {GameController.INSTANCE.handleHomeButtonPressed();});
		background.getChildren().add(homeButton);
		
	}
	
	public void drawRestartButton() {
		restartButton.setLayoutX(540);
		restartButton.setLayoutY(25);
		restartButton.setOnAction(event -> {GameController.INSTANCE.handleRestartButtonPressed();});
		background.getChildren().add(restartButton);
	}
	
	public void drawInstructionButton() {
		instructionButton.setLayoutX(480);
		instructionButton.setLayoutY(25);
		instructionButton.setOnAction(event -> {GameController.INSTANCE.handleInstructionButtonPressed();});
		background.getChildren().add(instructionButton);
	}
}
