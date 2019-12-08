package frogger.service;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Scanner;
import frogger.constant.FileName;
import frogger.model.Score;

/**
 * <h2> ScoreListReader </h2>
 * 
 * <p>The {@link ScoreListReader} class is an singleton class of utility to read a {@link Score} and related nickName from a ScoreList File
 * 
 * <p><strong>Note:</strong> this class is implemented as an {@link Enum} thus to be a singleton class.
 * 
 * <p><strong>Main Functionality:</strong>
 * 
 * <pre>
 *		ScoreListWriter.INSTANCE.readFromFile();
 * </pre>
 * 
 * <p><strong>Use:</strong>
 * 
 * <pre>
 * 		ScoreListReader.INSTANCE.{METHOD}()
 * </pre>
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see frogger.controller.ScoreListController
 * @see Score
 */
public enum ScoreListReader {
	/** The shared instance for global use for whole project */
	INSTANCE;
	
	/** A {@link LinkedHashMap} store the nickName and corresponding score which from socreList file */
	private LinkedHashMap<String, Score> scoreList;
	
	/**
	 * Initialize the scoreList using new.
	 */
	public void init() {
		scoreList = new LinkedHashMap<String, Score>();
	}
	
	/**
	 * <p> Read all the score and nickname pair from socreList file.
	 */
	public void readFromFile() {
		try {
			File f = createFile(FileName.FILE_SCORE_LIST);
			
			Scanner read = new Scanner(f);
			while(read.hasNextLine()) {
				String nickName = read.nextLine();
				Score score = new Score(Integer.valueOf(read.nextLine()).intValue());
				scoreList.put(nickName, score);
			}
			read.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <p>Initializes the file based on the given file URL string
	 * 
	 * 
	 * @param fileURL	The path of file which will be written
	 * @return	return {@link File} if file create successfully, exist program if file does not exist
	 */
	public File createFile(String fileURL) {
		File f = new File(fileURL);
		if (!f.exists())
		{
			System.out.println("File open fails");
			System.exit(0);
		}
		return f;
	}
	
	/**
	 * <p> returns the scoreList read from file and will be used to print to the screen by {@link frogger.controller.ScoreListController}.
	 * 
	 * @return	return the socreList read from file
	 */
	public LinkedHashMap<String, Score> getScoreList(){
		return scoreList;
	}
	
}
