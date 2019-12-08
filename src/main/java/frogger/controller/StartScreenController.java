package frogger.controller;

import frogger.service.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * <h2> HomeController</h2>
 * 
 * <p> The {@link StartScreenControoler} class is a controller for Start Screen
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @See SceneSwitch
 */
public class StartScreenController {

	/** The start {@link Button} switch to the select screen when clicked */
    @FXML
    private Button start;

    /** The instruction {@link Button} switch to the instruction screen when clicked */
    @FXML
    private Button instruction;

    /** The exit {@Link Button} exit the application when clicked */
    @FXML
    private Button exit;

    /** 
     * <p> Called when the {@link #exit} is clicked and exit the application
     * 
     * @param event		The Button click event 
     */
    @FXML
    void exitProgram(ActionEvent event) {
    	SceneSwitch.INSTANCE.exitProgram();
    }

    /** 
     * <p> Called when the {@link #instruction} is clicked and show the instruction page
     * 
     * @param event		The Button click event 
     */
    @FXML
    void switchToInstruction(ActionEvent event) {
    	SceneSwitch.INSTANCE.switchToInstruction();
    }

    /** 
     * <p> Called when the {@link #start} is clicked and switch to the select screen
     * 
     * @param event		The Button click event 
     */
    @FXML
    void switchToStartScreen(ActionEvent event) {
    	SceneSwitch.INSTANCE.switchToSelect();
    }

}
