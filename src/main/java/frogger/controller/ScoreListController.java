package frogger.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ScoreListController {

    @FXML
    private ListView scoreList;
    
    @FXML
    public void initialize() {
        ObservableList<String> options = FXCollections.observableArrayList();
        options.add("This is the first test");
        options.add("The is the second test");
        options.add("My name is Wenzheng Shan");
        options.add("I am working on my Software Maintenance coursework 2");
        scoreList.setItems(options);
    }

}
