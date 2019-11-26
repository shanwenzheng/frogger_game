package view;

import frogger.World;
import model.Animal;
import model.BackgroundImage;
import model.Digit;
import model.End;
import model.Log;
import model.Obstacle;
import model.Turtle;
import model.WetTurtle;

public class GameView {
	private World background;
	private Animal animal;
	
	public GameView() {
		background = new World();
		animal = new Animal("images/froggerUp.png");
	}
	
	public World getBackground() {
		return background;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void drawMap() {
		BackgroundImage froggerback = new BackgroundImage("images/iKogsKW.png");
	    
		background.add(froggerback);
		
		background.add(new Log("images/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("images/log3.png", 150, 220, 166, 0.75));
		background.add(new Log("images/log3.png", 150, 440, 166, 0.75));
		background.add(new Log("images/logs.png", 300, 0, 276, -2));
		background.add(new Log("images/logs.png", 300, 400, 276, -2));
		background.add(new Log("images/log3.png", 150, 50, 329, 0.75));
		background.add(new Log("images/log3.png", 150, 270, 329, 0.75));
		background.add(new Log("images/log3.png", 150, 490, 329, 0.75));
		
		background.add(new Turtle(500, 376, -1, 130, 130));
		background.add(new Turtle(300, 376, -1, 130, 130));
		background.add(new WetTurtle(700, 376, -1, 130, 130));
		background.add(new WetTurtle(600, 217, -1, 130, 130));
		background.add(new WetTurtle(400, 217, -1, 130, 130));
		background.add(new WetTurtle(200, 217, -1, 130, 130));
		background.add(new End(13,96));
		background.add(new End(141,96));
		background.add(new End(141 + 141-13,96));
		background.add(new End(141 + 141-13+141-13+1,96));
		background.add(new End(141 + 141-13+141-13+141-13+3,96));
		background.add(animal);
		background.add(new Obstacle("images/truck1"+"Right.png", 0, 649, 1, 120, 120));
		background.add(new Obstacle("images/truck1"+"Right.png", 300, 649, 1, 120, 120));
		background.add(new Obstacle("images/truck1"+"Right.png", 600, 649, 1, 120, 120));
		background.add(new Obstacle("images/car1Left.png", 100, 597, -1, 50, 50));
		background.add(new Obstacle("images/car1Left.png", 250, 597, -1, 50, 50));
		background.add(new Obstacle("images/car1Left.png", 400, 597, -1, 50, 50));
		background.add(new Obstacle("images/car1Left.png", 550, 597, -1, 50, 50));
		background.add(new Obstacle("images/truck2Right.png", 0, 540, 1, 200, 200));
		background.add(new Obstacle("images/truck2Right.png", 500, 540, 1, 200, 200));
		background.add(new Obstacle("images/car1Left.png", 500, 490, -5, 50, 50));
		background.add(new Digit(0, 30, 360, 25));
		background.start();
	}
}
