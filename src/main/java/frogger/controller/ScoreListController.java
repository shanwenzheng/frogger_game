package frogger.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

import frogger.model.Score;
import frogger.service.SceneSwitch;
import frogger.service.ScoreListReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

/**
 * <h2> ScoreListController</h2>
 * 
 * <p> The {@link ScoreListController} class is a controller for Score List scene
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @See SceneSwitch
 * @See Score
 * @See ScoreListReader
 */
public class ScoreListController {

	/** The list of score list shown on the screen*/
    @FXML
    private ListView<String> listView;
    
    /** The list of score list read from file */
    private LinkedHashMap<String, Score> scoreList;
    
    /** 
     * <p> This method is called when the scene is initialized.
     * 
     * <p> This method called {@link ScoreListReader} read the score list from file and 
     * call the {@link #sortScoreList(LinkedHashMap)} to sort the score list in descending order. 
     * In addition, the method also renders the result after sorting into {@link #listView}.
     */
    @FXML
    public void initialize() {
    	ScoreListReader.INSTANCE.init();
    	ScoreListReader.INSTANCE.readFromFile();
        ObservableList<String> options = FXCollections.observableArrayList();
        scoreList = sortScoreList(ScoreListReader.INSTANCE.getScoreList());
    	
        for(String nickName : scoreList.keySet()) {
        	int score = scoreList.get(nickName).getScore();
        	options.add("   " + nickName + ":" + score);
        }
        listView.setItems(options);
    }
    
    /** 
     * <p> Called when the home {@link Button} is clicked and show the start screen.
     * 
     * @param event		The Button click event 
     */
    @FXML
    void backToHome(ActionEvent event) {
    	SceneSwitch.INSTANCE.switchToStartScreen();
    }

    /** 
     * <p> Called when the restart {@link Button} is clicked and show the select screen.
     * 
     * @param event		The Button click event 
     */
    @FXML
    void restartGame(ActionEvent event) {
    	SceneSwitch.INSTANCE.switchToSelect();
    }
    
    /** 
     * <p> Called when the exit {@link Button} is clicked and exit the program.
     * 
     * @param event		The Button click event 
     */
    @FXML
    void exitGame(ActionEvent event) {
    	SceneSwitch.INSTANCE.exitProgram();
    }
    
    /**
     * <p> This method will sort the input {@code scoreList} in descending order (by comparing the {@link Score} value)
     * and return the sorted scoreList.
     * 
     * @param scoreList		Unsorted {@code socreList}
     * @return				Sorted {@code socreList} in descending order
     */
    public LinkedHashMap<String, Score> sortScoreList(LinkedHashMap<String,Score> scoreList) {
    	ArrayList<Map.Entry<String, Score>> list = new ArrayList<Map.Entry<String, Score>>(scoreList.entrySet());
    	
    	Collections.sort(list, new Comparator<Map.Entry<String, Score>>() {
            public int compare(Map.Entry<String, Score> o1, Map.Entry<String, Score> o2) {
                return o2.getValue().getScore() - o1.getValue().getScore();
            }
        });
    	
    	LinkedHashMap<String, Score> returnScoreList = new LinkedHashMap<String, Score>();
        for (Map.Entry<String, Score> entry : list) {
            String nickName = entry.getKey();
            Score score = entry.getValue();
            returnScoreList.put(nickName, score);
        }
        
        return returnScoreList;
    }
}
