package frogger.service;

import java.io.File;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Scanner;
import frogger.Main;
import frogger.constant.FileName;
import frogger.model.Score;

public enum ScoreListReader {
	INSTANCE;
	
	private LinkedHashMap<String, Score> scoreList;
	
	public void init() {
		scoreList = new LinkedHashMap<String, Score>();
	}
	
	public void readFromFile() {
		try {
			URL fileURL = Main.class.getResource(FileName.FILE_SCORE_LIST);
			File f = createFile(fileURL.getPath());
			
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
	
	public File createFile(String fileURL) {
		File f = new File(fileURL);
		if (!f.exists())
		{
			System.out.println("File open fails");
			System.exit(0);
		}
		return f;
	}
	
	public LinkedHashMap<String, Score> getScoreList(){
		return scoreList;
	}
	
}
