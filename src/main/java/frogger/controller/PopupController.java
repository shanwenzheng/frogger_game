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

public class PopupController {

    @FXML
    private ListView<String> popupScoreList;
    
    
    public void setPopupScoreList(LinkedHashMap<Integer, Score> scoreList) {
    	ObservableList<String> options = FXCollections.observableArrayList();
    	
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
