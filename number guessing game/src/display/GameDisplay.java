package display;

import java.util.Scanner;

public class GameDisplay {
	
	int cpuLevel = 0;

	public void showWelcome(String playerName) {
		System.out.println("===数字当てゲーム===");
		System.out.println("ようこそ" + playerName + "さん");
	}
	
	public void showRules(int min, int max) {
		
        System.out.println("=== ルール説明 ===");
        System.out.println(min + "～" + max + "の数字を予想して当てましょう。");
        System.out.println("CPUと交互に予想します。");
        System.out.println("数字が正解なら勝利です。");
        System.out.println("小さい数字なら「もっと大きい」とヒントが出ます。");
        System.out.println("大きい数字なら「もっと小さい」とヒントが出ます。");
        System.out.println("===================");
	}
	
	public void showCpuLevel(int level) {
		String cpuLevel = (level == 1) ? "弱い" : "強い";  
		System.out.println("CPUの強さは" + cpuLevel);
	}
	
	public void showPlayerGuess(int guess, String hint) {
		System.out.println("あなたの予想: " + guess + " → " + hint);
	}
	
	public void showCpuGuess(int guess, String hint) {
		System.out.println("CPUの予想: " + guess + " → " + hint);
	}
	
	public void showWinner(String winnerName) {
		System.out.println(winnerName + " の勝ちです！");
	}
	public void waitForEnter(Scanner scanner) {
		
		
		System.out.println("準備ができたら Enter キーを押してください...");
		
		while(true) {
			String input = scanner.nextLine();
			
			if(input.isEmpty()) {
				break;
			}
			
			System.out.println("Enterのみが有効です。もう一度押してください");
		}
	}
	
	//ExtraGame専用演出
	
	public void showExtraGameInto(boolean playerFirst) {
	    System.out.println("╔══════════════════════╗");
	    System.out.println("║      EXTRA GAME      ║");
	    System.out.println("╚══════════════════════╝");
	    pause(500);
	    
	    System.out.println("CPU最強の挑戦者が現れた！！");
	    pause(500);

	    System.out.println("先攻は… " + (playerFirst ? "プレイヤー" : "CPU"));
	    pause(500);
	    System.out.println();
	}
	
	public void showExtraGameWin(String playerName, int turnCount) {
	    System.out.println("=======================================");
	    System.out.println("🔥🔥 EXTRA GAME 完全制覇！🔥🔥");
	    System.out.println("=======================================");
	    System.out.println(playerName + " さん、超上級モードを勝利しました！");
	    System.out.println("クリアターン数: " + turnCount + " ターン");
	    System.out.println("あなたこそ真のナンバーキングです!");
	    System.out.println("=======================================");
	}
	
	   public void showExtraGameTurn(boolean isPlayerTurn, boolean hideCpuLog) {
	        if(isPlayerTurn) {
	            System.out.println("あなたのターンです！");
	        } else {
	            if(hideCpuLog) {
	                System.out.println("CPUのターン（ログは非表示です）");
	            } else {
	                System.out.println("CPUのターン");
	            }
	        }
	    }
	
    public void showExtraGameLose() {
        System.out.println("=======================================");
        System.out.println("💀 CPUの勝利 💀");
        System.out.println("あなたは敗北しました。ゲーム終了です...");
        System.out.println("=======================================");
    }
	
	
	
	private void pause(int ms) {
	    try {
	        Thread.sleep(ms);
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
	}

}
