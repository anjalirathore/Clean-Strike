package com.sahaj.io;

import java.util.LinkedList;
import java.util.List;

public class Judge {
	public Judge(Player p1, Player p2, Game game) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.game = game;
	}
	Player p1;
	Player p2;
	Game game;
	
	public Player getP1() {
		return p1;
	}
	public void setP1(Player p1) {
		this.p1 = p1;
	}
	public Player getP2() {
		return p2;
	}
	public void setP2(Player p2) {
		this.p2 = p2;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	
	public void calcScore(String playerName, String strikeState)
	{
		if (playerName.equalsIgnoreCase("p1"))
			calculateScore(strikeState, this.getP1());
		else if (playerName.equalsIgnoreCase("p2"))
			calculateScore(strikeState, this.getP2());
	}
	
	private void calculateScore(String strikeState, Player player) {
		//1. Strike 2. Multistrike 3. Red strike 4. Striker strike 5. Defunct coin 6. None > 
		switch (strikeState.toLowerCase()) {
		case "strike": {
			if(this.game.getBlackcoins()<0)
				break;
			player.setScore(player.getScore() + 1);
			this.game.setBlackcoins(this.game.getBlackcoins()-1);
			break;
		}
		case "multistrike": {
			if(this.game.getBlackcoins()<0)
				break;
			player.setScore(player.getScore() + 2);
			this.game.setBlackcoins(this.game.getBlackcoins()-2);
			break;
		}
		case "red strike": {
			player.setScore(player.getScore() + 3);
			this.game.setRedcoins(this.game.getRedcoins()-1);
			break;
		}
		case "striker strike": {
			player.setScore(player.getScore() - 1);
			player.setFouls(player.getFouls() + 1);
			checkFouls(player);
			break;
		}
		case "defunct coin": {
			player.setScore(player.getScore() - 2);
			player.setFouls(player.getFouls() + 1);
			checkFouls(player);
			if(this.game.getBlackcoins() > 0)
				this.game.setBlackcoins(this.game.getBlackcoins() - 1);
			else
				this.game.setWhitecoins(this.game.getWhitecoins() - 1);
			break;
		}
		case "none": {
			player.setNoPocketCount(player.getNoPocketCount() + 1);
			if (player.getNoPocketCount() == 3) {
				player.setScore(player.getScore() - 1);
				player.setFouls(player.getFouls() + 1);
				player.setNoPocketCount(0);
				checkFouls(player);
			}	
			break;
		}
		case "white strike" :
		{
			if(this.game.getWhitecoins()<0)
				break;
			player.setScore(player.getScore() - 1);
			player.setFouls(player.getFouls() + 1);
			checkFouls(player);
			this.game.setWhitecoins(this.game.getWhitecoins() - 1);
			break;
		}
		case "white multistrike" :
		{
			if(this.game.getWhitecoins()<0)
				break;
			player.setScore(player.getScore() + 4);
			this.game.setWhitecoins(this.game.getWhitecoins() - 2);
			break;
		}
		default: {
			break;
		}
		}
	}
	
	public Boolean winnerFound() {
		System.out.println("Score Till Now (P1 - P2) : " + this.getP1().getScore() + "-" + this.getP2().getScore());
		if (this.game.getWhitecoins() + this.game.getBlackcoins() + this.game.getRedcoins() <= 0) {
			if (Math.abs(this.getP1().getScore() - this.getP2().getScore()) < 3
					|| (this.getP1().getScore() < 5 && this.getP2().getScore() < 5)) {
				System.out.println("The result of the this is draw. Final Score: " + this.getP1().getScore() + "-"
						+ this.getP2().getScore());
				return true;
			}
		}
		if (this.getP1().getScore() - this.getP2().getScore() >= 3 && this.getP1().getScore() >= 5) {
			System.out.println(
					"Player 1 won the this. Final Score: " + this.getP1().getScore() + "-" + this.getP2().getScore());
			return true;
		} else if (this.getP2().getScore() - this.getP1().getScore() >= 3 && this.getP2().getScore() >= 5) {
			System.out.println(
					"Player 2 won the this. Final Score: " + this.getP2().getScore() + "-" + this.getP1().getScore());
			return true;
		}
		return false;
	}

	private void checkFouls(Player player) {
		if (player.getFouls() == 3) {
			player.setScore(player.getScore() - 1);
			player.setFouls(1);
		}		
	}
	
	

}
