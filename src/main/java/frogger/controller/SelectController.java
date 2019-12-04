package frogger.controller;

import frogger.constant.GameLevel;
import frogger.service.SceneSwitch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    	addTextLimiter(nickName, 12);
    }

    @FXML
    void backToStartScreen(ActionEvent event) {
    	SceneSwitch.INSTANCE.switchToStartScreen();
    }

    @FXML
    void goToGameScreen(ActionEvent event) {
    	while(checkNameEmpty()) {
    		printNullNickNameError();
    		return;
    	}
    	String name = nickName.getText();
    	String level = gameLevel.getSelectionModel().getSelectedItem();
    	SceneSwitch.INSTANCE.switchToGame(name, level);
    }
    
    public boolean checkNameEmpty() {
    	return nickName.getText().isEmpty();
    }
    
    public void printNullNickNameError() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Input Error");
		alert.setContentText("The nickName cannot be empty");
		alert.showAndWait();
    }
    
    public static void addTextLimiter(TextField tf, int maxLength) {
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (tf.getText().length() > maxLength) {
                    String s = tf.getText().substring(0, maxLength);
                    tf.setText(s);
                }
            }
        });
    }
}
