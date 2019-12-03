package frogger.controller;

import frogger.service.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class InstructionController {

    @FXML
    private Button exit;
    
    @FXML
    private TextArea objectText;

    @FXML
    private TextArea controlText;

    @FXML
    private TextArea actorText;

    @FXML
    private TextArea scoreText;
    
    @FXML
    public void initialize() {
    	objectText.setEditable(false);
    	controlText.setEditable(false);
    	actorText.setEditable(false);
    	scoreText.setEditable(false);
    }

    @FXML
    void closeInstructionStage(ActionEvent event) {
    	SceneSwitch.INSTANCE.getInstructionStage().close();
    }

}
