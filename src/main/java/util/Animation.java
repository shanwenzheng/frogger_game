package util;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import model.actor.Actor;
import model.actor.movableActor.MovableActor;
import view.GameView;

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
                List<MovableActor> actors = getObjects(MovableActor.class);
                
                for (MovableActor anActor: actors) {
                	anActor.act(now);
                }
            }
        };
    }
    
    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: background.getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }
    
	public AnimationTimer getActTimer() {
		return actTimer;
	}
}
