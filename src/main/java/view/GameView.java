package view;

import frogger.Main;
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
		String str = Main.class.getResource("images/iKogsKW.png").toString();
		String style = "-fx-background-image: url('" + str + "'); -fx-background-size: 600 800;";
		background.setStyle(style);
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
		background.getChildren().addAll(map.getDigit());
	}
}