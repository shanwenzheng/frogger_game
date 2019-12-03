package frogger.controller;

import frogger.constant.GameLevel;
import frogger.service.SceneSwitch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SelectController {

    @FXML
    private TextField nickName;

    @FXML
    private ComboBox<String> gameLevel;

    @FXML
    private Button back;

    @FXML
    private Button start;
    
    @FXML
    public void initialize() {
    	ObservableList<String> options = FXCollections.observableArrayList();
    	for(String str : GameLevel.gameLevelList) {
    		options.add(str);
    	}
    	gameLevel.setItems(options);
    	gameLevel.getSelectionModel().selectFirst();
    	
    	nickName.setText("Unknown Player");
    }

    @FXML
    void backToStartScreen(ActionEvent event) {
    	SceneSwitch.INSTANCE.switchToStartScreen();
    }

    @FXML
    void goToGameScreen(ActionEvent event) {
    	String name = nickName.getText();
    	String level = gameLevel.getSelectionModel().getSelectedItem();
    	SceneSwitch.INSTANCE.switchToGame(name, level);
    }
}
