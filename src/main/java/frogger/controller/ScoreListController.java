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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class ScoreListController {

    @FXML
    private ListView<String> listView;
    
    @FXML
    private Button restart;

    @FXML
    private Button home;
    
    private LinkedHashMap<String, Score> scoreList;
    
    @FXML
    public void initialize() {
    	ScoreListReader.INSTANCE.init();
    	ScoreListReader.INSTANCE.readFromFile();
    	
        scoreList = sortScoreList(ScoreListReader.INSTANCE.getScoreList());
    	
        int count = 1;
        ObservableList<String> options = FXCollections.observableArrayList();
        for(String nickName : scoreList.keySet()) {
        	int score = scoreList.get(nickName).getScore();
        	options.add(count + ".  " + nickName + ":" + score);
        	count++;
        }
        listView.setItems(options);
    }
    
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

    @FXML
    void backToHome(ActionEvent event) {
    	SceneSwitch.INSTANCE.switchToStartScreen();
    }

    @FXML
    void restartGame(ActionEvent event) {
    	SceneSwitch.INSTANCE.switchToSelect();
    }
}
