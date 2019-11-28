package frogger.util;

import frogger.model.actor.movableActor.MovableActor;
import frogger.view.GameView;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class Animation {
    private AnimationTimer actTimer;
    private Pane background;
    
    public Animation(GameView gameView) {
    	this.background = gameView.getBackground();
    	createTimer();
    }
    
    public void createTimer() {
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
    
	public AnimationTimer getActTimer() {
		return actTimer;
	}
}
