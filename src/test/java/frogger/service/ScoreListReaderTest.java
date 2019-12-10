package frogger.service;

import static org.junit.Assert.*;

import java.io.File;
import java.util.LinkedHashMap;
import org.junit.Test;
import frogger.model.Score;

/**
 * <h2> ScoreListReaderTest </h2>
 * 
 * <p> The {@link ScoreListReaderTest} class is used to test the correctness of the read function and create file function in {@link ScoreListReader}
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see ScoreListReader
 */
public class ScoreListReaderTest {

	/**
	 * <p>This is a test function to test whether method {@link ScoreListReader#readFromFile(String)} can successfully read the information from file
	 */
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
	
	/**
	 * <p> This is the test function to test whether method {@link ScoreListReader#createFile(String)} can successfully create the corresponding file within the given input file path.
	 */
	@Test
	public void createFileTest() {
		String correctFile = System.getProperty("user.dir") + "\\src\\test\\resources\\frogger\\file\\readTest.txt";
		assertTrue(ScoreListReader.INSTANCE.createFile(correctFile) instanceof File);
	}
}
