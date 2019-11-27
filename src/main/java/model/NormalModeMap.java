package model;

public class NormalModeMap extends Map{

	@Override
	public void createObstacles() {
		getObstacles().add(new Obstacle("file:resources/images/truck1"+"Right.png", 120, 0, 649, 1));
		getObstacles().add(new Obstacle("file:resources/images/truck1"+"Right.png", 120, 300, 649, 1));
		getObstacles().add(new Obstacle("file:resources/images/truck1"+"Right.png", 120, 600, 649, 1));
		getObstacles().add(new Obstacle("file:resources/images/car1Left.png", 50, 100, 597, -1));
		getObstacles().add(new Obstacle("file:resources/images/car1Left.png", 50, 250, 597, -1));
		getObstacles().add(new Obstacle("file:resources/images/car1Left.png", 50, 400, 597, -1));
		getObstacles().add(new Obstacle("file:resources/images/car1Left.png", 50, 550, 597, -1));
		getObstacles().add(new Obstacle("file:resources/images/truck2Right.png", 200, 0, 540, 1));
		getObstacles().add(new Obstacle("file:resources/images/truck2Right.png", 200, 500, 540, 1));
		getObstacles().add(new Obstacle("file:resources/images/car1Left.png", 50, 500, 490, -5));
	}

	@Override
	public void createLogs() {
		getLogs().add(new Log("file:resources/images/log3.png", 150, 0, 166, 0.75));
		getLogs().add(new Log("file:resources/images/log3.png", 150, 220, 166, 0.75));
		getLogs().add(new Log("file:resources/images/log3.png", 150, 440, 166, 0.75));
		getLogs().add(new Log("file:resources/images/logs.png", 300, 0, 276, -2));
		getLogs().add(new Log("file:resources/images/logs.png", 300, 400, 276, -2));
		getLogs().add(new Log("file:resources/images/log3.png", 150, 50, 329, 0.75));
		getLogs().add(new Log("file:resources/images/log3.png", 150, 270, 329, 0.75));
		getLogs().add(new Log("file:resources/images/log3.png", 150, 490, 329, 0.75));
	}

	@Override
	public void createTurtles() {
		getTurtles().add(new Turtle(130, 500, 376, -1));
		getTurtles().add(new Turtle(130, 300, 376, -1));
	}

	@Override
	public void createWetturtles() {
		getWetturtles().add(new WetTurtle(130, 700, 376, -1));
		getWetturtles().add(new WetTurtle(130, 600, 217, -1));
		getWetturtles().add(new WetTurtle(130, 400, 217, -1));
		getWetturtles().add(new WetTurtle(130, 200, 217, -1));
	}

}
