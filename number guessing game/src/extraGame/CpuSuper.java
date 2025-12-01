package extraGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CpuSuper {
	
	private int min = 1;
	private int max = 100;
	private int guess;
	private final Random random;
	private final List<Integer> playerGuesses;
	
	private int lastPlayerGuess = 50;
	
	public CpuSuper() {
		this.random = new Random();
		this.playerGuesses = new ArrayList<>();
	}
	
	public void updateRangeByPlayer(int playerGuess, int secretNumber) {
		
		playerGuesses.add(playerGuess);
		
		if(playerGuess < secretNumber) {
			min = Math.max(min, playerGuess + 1);
		} else {
			max = Math.min(max, playerGuess - 1);
		}
		
		fixRange();
	}
	
	public void updateRangeByCpu(int cpuGuess, int secretNumber) {
		if(cpuGuess < secretNumber) {
			min = Math.max(min, cpuGuess + 1);
		} else {
			max = Math.min(max, cpuGuess - 1);
		}
		
		fixRange();
	}
	
	public int makeGuess(int turn, int playerGuessInput) {
		
		lastPlayerGuess = playerGuessInput;
		
		fixRange();
		
		int mid = (min + max) / 2;
		
		if(!playerGuesses.isEmpty()) {
			
			int sum = 0;
			for(int g : playerGuesses) sum += g;
			int avg = sum / playerGuesses.size();
			
			mid = (mid + avg) / 2;
		}
		
		int range = Math.max(1, max-min);
		
		int offset = random.nextInt(Math.max(1, range  / 5 + 1));
		
		guess = mid + ((turn % 2 == 0) ? offset : -offset);
		
		guess = Math.max(min, Math.min(guess, max));
		
		return guess;
	}
	
	private void fixRange() {
		// TODO 自動生成されたメソッド・スタブ
		if(min > max) {
			int mid = (min + max) / 2;
			min = mid;
			max = mid;
		}
	}

}
