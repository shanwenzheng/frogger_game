package frogger.service;

public class ScoreBaseFactory {
	
	public static int createScoreBase(String gameLevel) {

		if(gameLevel.equals("SimpleMode")) {
			return 0;
		}else if(gameLevel.equals("NormalMode")){
			return 50;
		}else if(gameLevel.equals("HardMode")){
			return 100;
		}
		return 0;
	}
}
