package frogger.service;

import frogger.model.actor.movableActor.MovableActor;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * <h2> ActAnimation </h2>
 * 
 * <p>The {@link ActAnimation} class is used to create a timer which serves to call each {@link MovableActor} to execute act method
 *  
 * <p><strong>Note:</strong> this class is implemented as an {@link Enum} thus to be a singleton class.
 * 
 * <p> <strong> Use: </strong>
 * 
 * <pre>
 * 		ActAnimation.INSTANCE.init(background);
 * 		ActAnimation.INSTANCE.actStart();
 * 		ActAnimation.INSTANCE.actStop();
 * </pre>
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see Pane
 * @see AnimationTimer
 * @see MovableActor
 */
public enum ActAnimation {
	/** The shared instance for global use for whole project */
	INSTANCE;
	
	/** <p>A timer that called handle function in each frame while it is active*/
    private AnimationTimer actTimer;
    /** <p> The background of scene which contains all the {@link MovableActor} */
    private Pane background;
    
    /** 
     * <p> A initialize function that initialize background and call {@link ActAnimation#createActTimer()} function to create act timer 
     * 
     * @param background	A pane that contains all the {@link MovableActor} which need to be called to perfrom act method in each frame while it is active
     * */
    public void init(Pane background) {
    	this.background = background;
    	createActTimer();
    }
    
    /**
     *  <p> A method to initialize act timer and override the method handle(long) which will be called in every frame to execute {@link MovableActor#act(long)}
     *  
     *  <p> In every frame, handle function will get all {@link MovableActor} objects from background
     *  and make judgment if this object isInstance then execute it act function
     */
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
    
    /** <p>Call {@link AnimationTimer#start()} method to start the timer */
	public void actStart() {
		actTimer.start();
	}
	
    /** <p>Call {@link AnimationTimer#stop()} method to stop the timer */
	public void actStop() {
		actTimer.stop();
	}
}
