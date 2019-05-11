package com.sahaj.service;

import com.sahaj.io.Game;
import com.sahaj.io.Judge;
import com.sahaj.io.Player;

/**
 * @author Anjali
 *
 */
public class CleanStrikeService implements ICleanStrikeService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sahaj.service.ICleanStrikeService#showResult(com.sahaj.io.Game,
	 * java.lang.String[])
	 */
	@Override
	public void showResult(Judge judge, String[] strikes) {	
		try {
			for (String strike : strikes) {
				String[] strikeDetails = strike.split(":");
				String playerName = strikeDetails[0].trim();
				String strikeState = strikeDetails[1].trim();
				if (strikeState.equalsIgnoreCase("Red strike") && judge.getGame().getRedcoins() == 0) {
					System.out.println("There can be only one red coin hit! Please validate the input.");
					return;
				}
				judge.calcScore(playerName, strikeState);				
				if (judge.winnerFound())
					return;

			}
		} catch (Exception e) {
			System.out.println("Please make sure you are entering correct format for input.");
			// e.printStackTrace();
		}
	}
	

}
