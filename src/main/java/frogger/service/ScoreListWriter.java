package frogger.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import frogger.Main;
import frogger.model.Score;

public enum ScoreListWriter {
	INSTANCE;
	
	public void writeInFile(String nickName, Score score) {
		try {
			URL fileURL = Main.class.getResource("scoreFile/highScore.txt");
			
			PrintWriter writer = new PrintWriter(new FileOutputStream(fileURL.getPath(),true));
			writer.print(nickName + "\r\n");
			writer.print(score.getScore() + "\r\n");
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
