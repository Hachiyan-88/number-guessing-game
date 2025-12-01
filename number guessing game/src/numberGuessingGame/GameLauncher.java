package numberGuessingGame;

import java.util.Scanner;

import config.Config;
import player.HumanPlayer;

public class GameLauncher {

	public void Run() {
		
		Scanner scanner = new Scanner(System.in);
		
		Config config = new Config();
		
		config.setCpuLevel(selectCpuLevel(scanner));	
		
		HumanPlayer player = new HumanPlayer(scanner, "");
		player.inputName();
		config.setPlayerName(player.getName());
		
		
		NumberBattleGame game = new NumberBattleGame(config, player, scanner);
		game.startGame();;
		
		
		scanner.close();
		

	}
	
	public int selectCpuLevel(Scanner scanner) {
		
		System.out.println("CPUの強さを選択してください");
		System.out.println("1弱い");
		System.out.println("2強い");
		
		int level;
		
		while(true) {
			
			//System.out.println("入力");
			String input = scanner.nextLine().trim();
			
			try {
				level = Integer.parseInt(input);
				if(level == 1 || level == 2) {
					return level;
				} else {
					System.out.println("１または２を入力してください");
				}
				
			} catch(NumberFormatException e) {
				System.out.println("数字を入力してください");
			}

		}
	}
}
