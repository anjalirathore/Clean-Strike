package com.sahaj.io;

public class Game {
	public Game(int blackcoins, int redcoins, int whitecoins) {
		super();
		this.blackcoins = blackcoins;
		this.redcoins = redcoins;
		this.whitecoins = whitecoins;
	}

	private int blackcoins;
	private int redcoins;
	private int whitecoins;
	
	public int getBlackcoins() {
		return blackcoins;
	}

	public void setBlackcoins(int blackcoins) {
		this.blackcoins = blackcoins;
	}

	public int getRedcoins() {
		return redcoins;
	}

	public void setRedcoins(int redcoins) {
		this.redcoins = redcoins;
	}

	public int getWhitecoins() {
		return whitecoins;
	}

	public void setWhitecoins(int whitecoins) {
		this.whitecoins = whitecoins;
	}
}
