package frogger.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.util.LinkedHashMap;
import org.junit.Test;
import frogger.model.Score;

public class ScoreListWriterTest {
	
	@Test
	public void writeFileTest() {
		String fileURL = System.getProperty("user.dir") + "\\src\\test\\resources\\frogger\\file\\writeTest.txt";
		
		ScoreListWriter.INSTANCE.writeInFile("Test", new Score(200), fileURL);
		
		ScoreListReader.INSTANCE.init();
		ScoreListReader.INSTANCE.readFromFile(fileURL);
		
		LinkedHashMap<String, Score> testMap = ScoreListReader.INSTANCE.getScoreList();
		for(String str: testMap.keySet()) {
			assertEquals("Test",str);
			assertEquals(200,testMap.get(str).getScore());
		}
	}
	
	@Test
	public void createFileTest() {
		String correctFile = System.getProperty("user.dir") + "\\src\\test\\resources\\frogger\\file\\writeTest.txt";
		assertTrue(ScoreListWriter.INSTANCE.createFile(correctFile) instanceof File);
	}
}
