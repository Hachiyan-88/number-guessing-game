package player;

import java.util.Random;

public class CpuEasy extends CpuPlayer {

	private final Random random = new Random();
	
	@Override
	public int makeGuess() {
		
		int currentMin = Math.max(1, min);
		int currentMax = Math.max(currentMin, max);
		
		int range = Math.max(1, currentMax - currentMin + 1);
		
		guess = currentMin + random.nextInt(range);
		
		guess = Math.max(currentMin, Math.min(guess, currentMax));
		
		return guess;
	}
}
