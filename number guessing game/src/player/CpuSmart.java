package player;

public class CpuSmart extends CpuPlayer {

	@Override
	public int makeGuess() {
		
		if(min > max) {
			int temp = min;
			min = Math.min(min, max);
			max = Math.max(temp, max);
		}
		
		guess = (min + max) / 2;
		
		if(guess < min) guess = min;
		if(guess > max) guess = max;
		
		System.out.println("CPU(強い)の予想：" + guess);
		return guess;
	}
	
	
	@Override
	public void updateRangeByCpu(int cpuGuess, int secretNumber) {
		
		if(cpuGuess < secretNumber) {
			min = Math.max(min, cpuGuess + 1);
		} else {
			max = Math.min(max, cpuGuess - 1);
		}
		
		if(min > max) {
			min = max;
		}
	}
	
	@Override
	public void updateRangeByPlayer(int playerGuess, int secretNumber) {
		
		if(playerGuess < secretNumber) {
			min = Math.max(min, playerGuess + 1);
		} else {
			max = Math.min(max, playerGuess - 1);
		}
		
		if(min > max) {
			max = min;
		}
	}
	
}
