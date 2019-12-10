package frogger.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.util.LinkedHashMap;
import org.junit.Test;
import frogger.model.Score;

/**
 * <h2> ScoreListWriterTest </h2>
 * 
 * <p> The {@link ScoreListWriterTest} class is used to test the correctness of the write function and create file function in {@link ScoreListWriter}
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see ScoreListWriter
 * @see ScoreListReader
 */
public class ScoreListWriterTest {
	
	/**
	 * <p>This is a test function to test whether method {@link ScoreListWriter#writeInFile(String, Score, String)} can successfully write the information into file
	 */
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
	
	/**
	 * <p> This is the test function to test whether method {@link ScoreListWriter#createFile(String)} can successfully create the corresponding file within the given input file path.
	 */
	@Test
	public void createFileTest() {
		String correctFile = System.getProperty("user.dir") + "\\src\\test\\resources\\frogger\\file\\writeTest.txt";
		assertTrue(ScoreListWriter.INSTANCE.createFile(correctFile) instanceof File);
	}
}
