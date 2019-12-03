package frogger.service;

import frogger.model.actor.movableActor.MovableActor;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public enum ActAnimation {
	INSTANCE;
	
    private AnimationTimer actTimer;
    private Pane background;
    
    public void init(Pane background) {
    	this.background = background;
    	createActTimer();
    }
    
    public void createActTimer() {
    	actTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
        		Class<MovableActor> cls = MovableActor.class;
        		for(int i = 0; i < background.getChildren().size(); i++) {
        			Node n = background.getChildren().get(i);
        			if(cls.isInstance(n)) {
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