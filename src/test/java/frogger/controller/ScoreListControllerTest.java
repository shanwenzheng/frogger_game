package frogger.controller;

import static org.junit.Assert.*;
import java.util.LinkedHashMap;
import org.junit.Test;
import frogger.model.Score;

/**
 * <h2> ScoreListControllerTest </h2>
 * 
 * <p> The {@link ScoreListControllerTest} function is used to test the correctness of parts of the method in {@link ScoreListController} 
 * which are testable without launching application.
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see ScoreListController
 * @see Score
 */
public class ScoreListControllerTest {

	/** A {@link LinkedHashMap} store the nickName and corresponding score */
	LinkedHashMap<String, Score> scoreList = new LinkedHashMap<String, Score>();
	/** A {@link ScoreListController} that help to accomplish the test */
	ScoreListController scoreListController = new ScoreListController();
	
	/** 
	 * <p>This is the test method that tests the correctness of {@link ScoreListController#sortScoreList(LinkedHashMap)}.
	 * <p>This test will pass if {@link #scoreList} is sorted in descending order after calling {@link ScoreListController#sortScoreList(LinkedHashMap)}.
	 */
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
