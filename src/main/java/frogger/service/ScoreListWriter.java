package frogger.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import frogger.constant.FileName;
import frogger.model.Score;

/**
 * <h2> ScoreListWriter </h2>
 * 
 * <p>The {@link ScoreListWriter} class is an singleton class of utility to write a {@link Score} and related nickName to a ScoreList File
 * 
 * <p><strong>Note:</strong> this class is implemented as an {@link Enum} thus to be a singleton class.
 * 
 * <p><strong>Main Functionality:</strong>
 * 
 * <pre>
 *		ScoreListWriter.INSTANCE.writeInFile(nickName, score);
 * </pre>
 * 
 * <p><strong>Use:</strong>
 * 
 * <pre>
 * 		ScoreListWriter.INSTANCE.{METHOD}()
 * </pre>
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see frogger.controller.ScoreListController
 * @see Score
 */
public enum ScoreListWriter {
	/** The shared instance for global use for whole project */
	INSTANCE;
	
	/**
	 * <p> Writes the given {@link Score} and nickName to the socreList file
	 * 
	 * @param nickName	The nickname to be written to file (passed from {@link frogger.controller.GameController});
	 * @param score		The score{@link Score} to be written to file (passed from {@link frogger.controller.GameController});
	 */
	public void writeInFile(String nickName, Score score) {
		try {
			File f = createFile(FileName.FILE_SCORE_LIST);
			
			PrintWriter writer = new PrintWriter(new FileOutputStream(f,true));
			writer.print(nickName + "\r\n");
			writer.print(score.getScore() + "\r\n");
			writer.close();
			
		} catch (FileNotFoundException e) {
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
}
