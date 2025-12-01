package numberGuessingGame;

import java.util.Random;
import java.util.Scanner;

import config.Config;
import display.GameDisplay;
import game.Judge;
import game.ReplayManager;
import player.CpuEasy;
import player.CpuPlayer;
import player.CpuSmart;
import player.HumanPlayer;

public class NumberBattleGame {

    private Random random;
    private Scanner scanner;
    private HumanPlayer player;
    private GameDisplay display;
    private Judge judge;
    private CpuPlayer cpu;
    private int secretNumber;
    private Config config;

    public NumberBattleGame(Config config, HumanPlayer player, Scanner scanner) {
        this.random = new Random();
        this.scanner = scanner;
        this.config = config;
        this.player =  player;
        
        this.judge = new Judge();
        this.display = new GameDisplay();

        this.cpu = (config.getCpuLevel() == 1) ? new CpuEasy() : new CpuSmart();
    }

    
    public void startGame() {
        ReplayManager replay = new ReplayManager(scanner);
        
        if(config.getPlayerName().isEmpty()) {
        		player.inputName();
        		config.setPlayerName(player.getName());
        } else {
        		player.setName(config.getPlayerName());
        }

        do {
            playOneGame();
        } while (replay.askReplay());

        System.out.println("ゲームを終了します。ありがとうございました！");
    }

    
    private void playOneGame() {

       
        display.showWelcome(player.getName());
        display.showRules(config.getMinNumber(), config.getMaxNumber());
        display.waitForEnter(scanner);

        
        secretNumber = random.nextInt(config.getMaxNumber() - config.getMinNumber() + 1) + config.getMinNumber();

        boolean gameOver = false;
        final int MAX_TURNS = 100;
        int turnCount = 0;

        while (!gameOver && turnCount < MAX_TURNS) {
        	
        		turnCount++;

           
            int playerGuess = player.makeGuess();
            String hint = judge.getHint(playerGuess, secretNumber);
            display.showPlayerGuess(playerGuess, hint);

            
            if (cpu instanceof CpuSmart) {
                ((CpuSmart) cpu).updateRangeByPlayer(playerGuess, secretNumber);
            }

            
            if (judge.isCorrect(playerGuess, secretNumber)) {
                display.showWinner(player.getName());

                // エクストラ
                if (config.getCpuLevel() == 2 && isDoubleNumber(secretNumber)) {
                    System.out.println("規定条件の達成。Extraゲームが開始されます。");
                    extraGame.ExtraGame extra = new extraGame.ExtraGame(scanner, player);
                    System.out.println("先攻は" + (extra.isPlayerFirst() ? "プレーヤー" : "CPU"));
                    extra.startGame();
                    System.out.println("Extra終了。総ターン数：" + extra.getTurnCount());
                }

                gameOver = true;
                break;
            }

            
            int cpuGuess = cpu.makeGuess();
            
            hint = judge.getHint(cpuGuess, secretNumber);
            display.showCpuGuess(cpuGuess, hint);

            
            if (judge.isCorrect(cpuGuess, secretNumber)) {
                display.showWinner("CPU");
                gameOver = true;
                break;
            }

            
            if (cpu instanceof CpuSmart smartCpu) {
                smartCpu.updateRangeByCpu(cpuGuess, secretNumber);
            }
        }
        if(turnCount >= MAX_TURNS) {
        		System.out.println("ターン数上限に達しました");
        }
    }


    private boolean isDoubleNumber(int num) {
        int tens = num / 10;
        int ones = num % 10;
        return tens == ones && num <= 99;
    }
}

