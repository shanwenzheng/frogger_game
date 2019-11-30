package frogger.util;

import frogger.controller.GameController;
import frogger.view.GameView;
import javafx.animation.AnimationTimer;

public enum EndDetecter {
	INSTANCE;
	
	private AnimationTimer endDetecter;
	private GameView gameView;
	
	public void init(GameView gameView) {
		this.gameView = gameView;
		createEndDetecter();
	}
	
	public void createEndDetecter() {
		endDetecter = new AnimationTimer() {
	      @Override
	      public void handle(long now) {
	      	if (checkEndActivited()) {
	      		GameController.INSTANCE.endGame();
	      	}
	      }
		};
	}
	
    public boolean checkEndActivited() {
  	  for(int i = 0; i < gameView.getMap().getEnd().size(); i++) {
  		  if (!gameView.getMap().getEnd().get(i).isActivated()) {return false;}
  	  }
  	  return true;
    }
    
	public void endDetectStart() {
		endDetecter.start();
	}
	
	public void endDetectStop() {
		endDetecter.stop();
	}
}
