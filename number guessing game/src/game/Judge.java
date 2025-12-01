package game;

public class Judge {
	
	public boolean isCorrect(int guess, int secretNumber) {
		
	return guess == secretNumber;
	}
	public String getHint(int guess, int secretNumber) {
		
		if(guess == secretNumber) {	
		return "正解";
		} else if(guess < secretNumber) {
			return "もっと大きい数字です";
		} else {
			return "もっと小さい数字です";
		}
	}

}
