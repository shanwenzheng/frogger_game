package frogger.controller;

import static org.junit.Assert.*;
import java.util.LinkedHashMap;
import org.junit.Test;
import frogger.model.Score;

public class ScoreListControllerTest {

	LinkedHashMap<String, Score> scoreList = new LinkedHashMap<String, Score>();
	
	ScoreListController scoreListController = new ScoreListController();
	
	@Test
	public void sortScoreListTest() {
		scoreList.put("test1", new Score(1));
		scoreList.put("test2", new Score(2));
		scoreList.put("test3", new Score(3));
		
		scoreList = scoreListController.sortScoreList(scoreList);
		
		int count = 3;
		for(String str : scoreList.keySet()) {
			assertEquals("test" + count, str);
			assertEquals(count, scoreList.get(str).getScore());
			count--;
		}
	}

}
