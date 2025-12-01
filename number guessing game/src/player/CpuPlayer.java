package player;

public abstract class CpuPlayer {
	
	protected int guess;
	protected int min = 1;
	protected int max = 100;
	
    public void updateRangeByPlayer(int playerGuess, int secretNumber) {
        if (playerGuess < secretNumber) {
            min = Math.max(min, playerGuess + 1);
        } else {
            max = Math.min(max, playerGuess - 1);
        }
    }

    
    public void updateRangeByCpu(int cpuGuess, int secretNumber) {
        if (cpuGuess < secretNumber) {
            min = Math.max(min, cpuGuess + 1);
        } else {
            max = Math.min(max, cpuGuess - 1);
        }
    }
	
	public abstract int makeGuess();
	

}
