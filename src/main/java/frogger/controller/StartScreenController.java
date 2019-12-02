package frogger.controller;

import frogger.util.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StartScreenController {

    @FXML
    private Button start;

    @FXML
    private Button instruction;

    @FXML
    private Button exit;

    @FXML
    void exitProgram(ActionEvent event) {
    	SceneSwitch.INSTANCE.exitProgram();
    }

    @FXML
    void switchToInstruction(ActionEvent event) {

    }

    @FXML
    void switchToStartScreen(ActionEvent event) {
    	SceneSwitch.INSTANCE.switchToGame();
    }

}
