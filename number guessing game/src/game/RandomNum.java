package game;

import java.util.Random;

public class RandomNum {
	
	private int secretNumber;
	
	public RandomNum() {
		
		Random random = new Random();
		
		secretNumber = random.nextInt(100) + 1;
	}
	
	public int getSecretNumber() {
		return secretNumber;
	}
	
}
