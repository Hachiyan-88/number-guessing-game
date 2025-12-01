package player;

import java.util.Scanner;

public class HumanPlayer {
	
	private final Scanner scanner;
	private String name;
	
	private static final int MIN = 1;
	private static final int MAX = 100;
	
	public HumanPlayer(Scanner scanner, String name) {
		this.scanner = scanner;
		this.name = (name == null) ? "" : name.trim();
		

	}
	


	public void inputName() {
		
		System.out.println("名前を入力してください：");

		
		while(true) {
			String input = scanner.nextLine().trim();
			
			if(input.replaceAll("\\s+", "").isEmpty()) {
				System.out.println("名前が空です。再度入力してください");
				continue;
			}
			setName(input);
			break;
		}
	}

	public String getName() {
		return name;
	}
	
	public void setName(String playerName) {
		if(playerName == null || playerName.trim().isEmpty() || 
		   playerName.replaceAll("\\s+", "").isEmpty()) {
			throw new IllegalArgumentException("名前が空またはnullです。正しい名前を設定して下さい");
		}
		
		this.name = playerName.trim();
	}
	
	public int makeGuess() {
		
		while(true) {
			System.out.println(name + "のターンです。数字を入力してください（" + MIN + "～" + MAX + "）：" );
			
			String input = scanner.nextLine().trim();
			
			if(input.isEmpty()) {
				System.out.println("入力が空です。数字を入力してください");
				continue;
			}
			
			int guess;
			
			try {
				
				guess = Integer.parseInt(input);
			
			} catch(NumberFormatException e) {
				
				System.out.println("数字を入力してください");
				continue;
			}
			
			if(guess < MIN || guess > MAX) {
			System.out.println(MIN + "～" + MAX +"の範囲で入力してください");
			continue;
			}
			
			return guess;
			
		}
		
	}

}
