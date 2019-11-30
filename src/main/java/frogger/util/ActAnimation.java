package frogger.util;

import frogger.model.actor.movableActor.MovableActor;
import frogger.view.GameView;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public enum ActAnimation {
	INSTANCE;
	
    private AnimationTimer actTimer;
    private Pane background;
    
    public void init(GameView gameView) {
    	this.background = gameView.getBackground();
    	createActTimer();
    }
    
    public void createActTimer() {
    	actTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
        		Class<MovableActor> cls = MovableActor.class;
        		for (Node n : background.getChildren()) {
        			if (cls.isInstance(n)) {
        				MovableActor actor = (MovableActor) n;
        				actor.act(now);
        			}
        		}
            }
        };
    }
    
	public void actStart() {
		actTimer.start();
	}
	
	public void actStop() {
		actTimer.stop();
	}
}