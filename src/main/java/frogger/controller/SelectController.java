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

/**
 * <h2> SelectController</h2>
 * 
 * <p> The {@link SelectController} class is a controller for Select Screen
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see SceneSwitch
 */
public class SelectController {

	/** The nickname text field shown on the screen */
    @FXML
    private TextField nickName;

    /** The gameLevel combox shown on the screen */
    @FXML
    private ComboBox<String> gameLevel;

    /** The back {@link Button} back to the start screen when clicked */
    @FXML
    private Button back;

    /** The start {@link Button} start the game when clicked */
    @FXML
    private Button start;
    
    /** 
     * <p> This method is called when the scene is initialized.
     * 
     * <p> This method set {@link gameLevel} combox by reading the gameLevel constant from {@link GameLevel}.
     * And call {@link #addTextLimiter(TextField, int)} function to set the limit number of text.
     */
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

    /** 
     * <p> Called when the {@link #back} is clicked and back to the start screen
     * 
     * @param event		The Button click event 
     */
    @FXML
    void backToStartScreen(ActionEvent event) {
    	SceneSwitch.INSTANCE.switchToStartScreen();
    }

    /** 
     * <p> Called when the {@link #start} is clicked and start the game
     * 
     * <p> This method will check the if the player enter their nickName and then pass the nickName (read from {@link #nickName})
     * and gameLevel (read from {@link #gameLevel}) to game screen.
     * 
     * @param event		The Button click event 
     */
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
    
    /** 
     *  <p> Check whether player input their nickName
     *  
     * @return true if nickName is empty, false otherwise
     */
    public boolean checkNameEmpty() {
    	return nickName.getText().isEmpty();
    }
    
    /** print an alert to show the error information */
    public void printNullNickNameError() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Input Error");
		alert.setContentText("The nickName cannot be empty");
		alert.showAndWait();
    }
    
    /**
     * <p> This method is used to check whether the nickName has come to the max length.
     * 
     * <p> This method add an {@link ChangeListener} to {@link #nickName} to detect the change of nickName. Each time the nickName is changed,
     * the override function {@link ChangeListener#changed(ObservableValue, Object, Object)} will be called to detect the length of nickName 
     * and compared with maxLength.
     * 
     * @param tf			The {@link TextField} which will be added a {@link ChangeListener}
     * @param maxLength		The max length of {@link TextField}
     */
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
