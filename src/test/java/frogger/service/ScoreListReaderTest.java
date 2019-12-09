package frogger.service;

import static org.junit.Assert.*;

import java.io.File;
import java.util.LinkedHashMap;
import org.junit.Test;
import frogger.model.Score;

public class ScoreListReaderTest {

	@Test
	public void readFileTest() {
		String fileURL = System.getProperty("user.dir") + "\\src\\test\\resources\\frogger\\file\\readTest.txt";
		
		ScoreListReader.INSTANCE.init();
		ScoreListReader.INSTANCE.readFromFile(fileURL);
		
		LinkedHashMap<String, Score> testMap = ScoreListReader.INSTANCE.getScoreList();
		for(String str: testMap.keySet()) {
			assertEquals("test",str);
			assertEquals(100,testMap.get(str).getScore());
		}
	}
	
	@Test
	public void createFileTest() {
		String correctFile = System.getProperty("user.dir") + "\\src\\test\\resources\\frogger\\file\\readTest.txt";
		assertTrue(ScoreListReader.INSTANCE.createFile(correctFile) instanceof File);
	}
}
