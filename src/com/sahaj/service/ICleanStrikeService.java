package com.sahaj.service;

import com.sahaj.io.Game;
import com.sahaj.io.Judge;

public interface ICleanStrikeService {
	
	/**
	 * @param game
	 * @param strikes
	 */
	void showResult(Judge judge, String[] strikes);

}
