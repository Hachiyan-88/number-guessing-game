package config;


public class Config {
	private int minNumber;
	private int maxNumber;
	private int maxAttempts;
	private int cpuLevel;
	private String playerName;
	
	
	public Config() {
		
		this.cpuLevel = 1;
		this.minNumber = 1;
		this.maxNumber = 100;
		this.maxAttempts = 0;
		this.playerName = "";
	}
	
	public int getCpuLevel() {
		return cpuLevel;
		
	}
	
	public void setCpuLevel(int cpuLevel) {
		this.cpuLevel = cpuLevel;
	}
	
	public int getMinNumber() {
		return minNumber;
		
	}
	
	public void setMinNumber(int minNumber) {
		this.minNumber = minNumber;
	}
	
	public int getMaxNumber() {
		return maxNumber;
		
	}
	
	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
	
	public int getMaxAttempts() {
		return maxAttempts;
		
	}
	
	public void setMaxAttempts(int maxAttempts) {
		this.maxAttempts = maxAttempts;
	}
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		
		this.playerName = playerName;
		
	}
}
