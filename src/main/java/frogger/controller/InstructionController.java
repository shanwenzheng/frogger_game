package frogger.controller;

import frogger.service.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * <h2> InstructionController</h2>
 * 
 * <p> The {@link InstructionController} class is a controller for instruction screen
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see SceneSwitch
 */
public class InstructionController {

    /** The exit {@link Button} exit the application when clicked */
    @FXML
    private Button exit;
    
    /** The object {@link TextArea} contains the information about the objective of game */
    @FXML
    private TextArea objectText;

    /** The control {@link TextArea} contains the information about the controls of game */
    @FXML
    private TextArea controlText;

    /** The actor {@link TextArea} contains the information about the actor of game */
    @FXML
    private TextArea actorText;

    /** The score {@link TextArea} contains the information about the score of game */
    @FXML
    private TextArea scoreText;
    
    /** <p> This method is called when the scene is initialized and set all the {@link TextArea} un-editable. */
    @FXML
    public void initialize() {
    	objectText.setEditable(false);
    	controlText.setEditable(false);
    	actorText.setEditable(false);
    	scoreText.setEditable(false);
    }

    /** 
     * <p> Called when the {@link #exit} is clicked and exit the application
     * 
     * @param event		The Button click event 
     */
    @FXML
    void closeInstructionStage(ActionEvent event) {
    	SceneSwitch.INSTANCE.getInstructionStage().close();
    }

}
