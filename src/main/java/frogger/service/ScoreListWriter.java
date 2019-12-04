package frogger.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import frogger.Main;
import frogger.constant.FileName;
import frogger.model.Score;

public enum ScoreListWriter {
	INSTANCE;
	
	public void writeInFile(String nickName, Score score) {
		try {
			URL fileURL = Main.class.getResource(FileName.FILE_SCORE_LIST);
			File f = createFile(fileURL.getPath());
			
			PrintWriter writer = new PrintWriter(new FileOutputStream(f,true));
			writer.print(nickName + "\r\n");
			writer.print(score.getScore() + "\r\n");
			writer.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
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
