package game;

import java.util.Scanner;

public class ReplayManager {
	private final Scanner scanner;
	
	public ReplayManager(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public boolean askReplay() {
		
		System.out.println("もう一回遊びますか？(y/n)");
		
		while(true) {
			String input = scanner.nextLine().trim().toLowerCase();
			
			if(input.equals("y")) {
				return true;
			}else if(input.equals("n")) {
				return false;
			}else if(input.isEmpty()) {
				System.out.println("入力が空です。yかnを入力してください");
			}else {
				System.out.println("yかnで入力してください");
			}
		}
	}

}
