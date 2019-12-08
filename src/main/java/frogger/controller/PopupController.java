package frogger.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

import frogger.model.Score;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

/**
 * <h2> PopupController</h2>
 * 
 * <p> The {@link PopupController} class is a controller for Popup temporary each round score list scene.
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see frogger.service.SceneSwitch
 * @see Score
 */
public class PopupController {

	/** The list of temporary each round score list shown on the screen*/
    @FXML
    private ListView<String> popupScoreList;
    
    /** 
     * <p> This method is called by {@link frogger.service.SceneSwitch#switchToPopup(LinkedHashMap)} every time when the frog lose its life
     * and show the each round of score to the screen.
     * 
     * <p> This method first sort the given {@code socreList} in descending order and renders the sorted {@link LinkedHashMap} into {@link #popupScoreList}.
     * 
     * @param scoreList	A temporary score list store the each round of score
     */
    public void setPopupScoreList(LinkedHashMap<Integer, Score> scoreList) {
    	ObservableList<String> options = FXCollections.observableArrayList();
    	
    	// Sort the scoreList
    	ArrayList<Map.Entry<Integer, Score>> list = new ArrayList<Map.Entry<Integer, Score>>(scoreList.entrySet());
    	Collections.sort(list, new Comparator<Map.Entry<Integer, Score>>() {
            public int compare(Map.Entry<Integer, Score> o1, Map.Entry<Integer, Score> o2) {
                return o2.getValue().getScore() - o1.getValue().getScore();
            }
        });
    	
        for (int i = 0; i < list.size(); i++) {
        	options.add("Round " + (list.get(i).getKey() + 1) + ": " + list.get(i).getValue().getScore());
        }
    	popupScoreList.setItems(options);
    }

}
