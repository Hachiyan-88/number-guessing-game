package extraGame;

import java.util.Random;
import java.util.Scanner;

import display.GameDisplay;
import game.Judge;
import player.HumanPlayer;

public class ExtraGame {

	private Scanner scanner;
	private Random random = new Random();
	private HumanPlayer player;
	private CpuSuper cpu;
	private Judge judge;
	private GameDisplay display;
	private int secretNumber;
	
	private int turnCount;
	private boolean playerFirst;
	
	
	public ExtraGame(Scanner scanner, HumanPlayer player) {
		
	this.cpu = new CpuSuper();
	this.display = new GameDisplay();
	this.player = player;
	this.judge = new Judge();
	this.scanner = scanner;
	this.secretNumber = random.nextInt(100) + 1;
	this.playerFirst = random.nextBoolean();
	
	}
	
	public int getTurnCount() {
		return turnCount;
	}
	
	public boolean isPlayerFirst() {
		return playerFirst;
	}
	
	public void startGame() {

		display.showExtraGameInto(playerFirst);
		
		boolean gameOver = false;
		boolean playerTurn = playerFirst;
		
		boolean hideCpuLog = true;
		
		int lastPlayerGuess = 50;
		
		final int MAX_TURNS = 100;
		
		
		while(!gameOver && turnCount < MAX_TURNS) {
			turnCount++;
			
			if(playerTurn) {
				display.showExtraGameTurn(true, false);
				
				int playerGuess = player.makeGuess();
				
				lastPlayerGuess = playerGuess;
				
				
				String hint = judge.getHint(playerGuess, secretNumber);
				display.showPlayerGuess(playerGuess, hint);
				
				if(judge.isCorrect(playerGuess, secretNumber)) {
					display.showExtraGameWin(player.getName(), turnCount);
					gameOver = true;
					break;
				}
				
				 cpu.updateRangeByPlayer(playerGuess, secretNumber);
				 
			} else {
				
				int cpuGuess = cpu.makeGuess(turnCount, lastPlayerGuess);
				
				cpuGuess = Math.max(1, Math.min(cpuGuess, 100));
				
				String hint = judge.getHint(cpuGuess, secretNumber);
				
				if(!hideCpuLog) {
					display.showCpuGuess(cpuGuess, hint);
					
				} else {
					System.out.println("CPUのターン（ログは非表示です）");
					hideCpuLog = false;
				}
				
				if(judge.isCorrect(cpuGuess, secretNumber)) {
					display.showWinner("CPUの勝ち");
					System.out.println("ゲーム終了です");
					gameOver = true;
					break;
				}
				
				cpu.updateRangeByCpu(cpuGuess, secretNumber);
			}
			
			playerTurn = !playerTurn;
			
		}
		if(turnCount >= MAX_TURNS) {
			System.out.println("ターン数の上限に達しました");
		}
	}
}
