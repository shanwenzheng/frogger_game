package model;


import model.log.LongLog;
import model.log.ShortLog;
import model.obstacle.car;
import model.obstacle.longTruck;
import model.obstacle.shortTruck;
import model.turtle.NormalTurtle;
import model.turtle.WetTurtle;

public class NormalModeMap extends Map{

	@Override
	public void createObstacles() {
		getObstacles().add(new shortTruck(120, 0, 649, 1));
		getObstacles().add(new shortTruck(120, 300, 649, 1));
		getObstacles().add(new shortTruck(120, 600, 649, 1));
		getObstacles().add(new car(50, 100, 597, -1));
		getObstacles().add(new car(50, 250, 597, -1));
		getObstacles().add(new car(50, 400, 597, -1));
		getObstacles().add(new car(50, 550, 597, -1));
		getObstacles().add(new longTruck(200, 0, 540, 1));
		getObstacles().add(new longTruck(200, 500, 540, 1));
		getObstacles().add(new car(50, 500, 490, -5));
	}

	@Override
	public void createLogs() {
		getLogs().add(new ShortLog(150, 0, 166, 0.75));
		getLogs().add(new ShortLog(150, 220, 166, 0.75));
		getLogs().add(new ShortLog(150, 440, 166, 0.75));
		getLogs().add(new LongLog(300, 0, 276, -2));
		getLogs().add(new LongLog(300, 400, 276, -2));
		getLogs().add(new ShortLog(150, 50, 329, 0.75));
		getLogs().add(new ShortLog(150, 270, 329, 0.75));
		getLogs().add(new ShortLog(150, 490, 329, 0.75));
	}

	@Override
	public void createTurtles() {
		getTurtles().add(new NormalTurtle(130, 500, 376, -1));
		getTurtles().add(new NormalTurtle(130, 300, 376, -1));
		getTurtles().add(new WetTurtle(130, 700, 376, -1));
		getTurtles().add(new WetTurtle(130, 600, 217, -1));
		getTurtles().add(new WetTurtle(130, 400, 217, -1));
		getTurtles().add(new WetTurtle(130, 200, 217, -1));
	}

}
