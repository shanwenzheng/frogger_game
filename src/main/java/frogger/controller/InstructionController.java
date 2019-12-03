package frogger.controller;

import frogger.service.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InstructionController {

    @FXML
    private Button exit;

    @FXML
    void closeInstructionStage(ActionEvent event) {
    	SceneSwitch.INSTANCE.getInstructionStage().close();
    }

}
