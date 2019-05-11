package com.sahaj.io;

public class Player {
	public Player(String name) {
		super();
		this.name = name;
	}

	public Player() {
	}

	private String name;
	private String strike;
	private int score;
	private int fouls;
	private int noPocketCount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStrike() {
		return strike;
	}

	public void setStrike(String strike) {
		this.strike = strike;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getFouls() {
		return fouls;
	}

	public void setFouls(int fouls) {
		this.fouls = fouls;
	}

	public int getNoPocketCount() {
		return noPocketCount;
	}

	public void setNoPocketCount(int noPocketCount) {
		this.noPocketCount = noPocketCount;
	}
}
