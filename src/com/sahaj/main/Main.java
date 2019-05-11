package com.sahaj.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.sahaj.io.Game;
import com.sahaj.io.Judge;
import com.sahaj.io.Player;
import com.sahaj.service.CleanStrikeService;

public class Main {

	public static void main(String args[]) throws IOException {

		System.out.println("Please enter values in input.txt file from the list below \n1. Strike \n2. Multistrike \n3. Red strike \n4. Striker strike \n5. Defunct coin \n6. None\n");
		String fileName = "input.txt";
		ClassLoader classLoader = new Main().getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		// Read File Content
		String content = new String(Files.readAllBytes(file.toPath()));
		String[] strikes = content.split("\r\n");
		Game game = new Game(9,1,9);
		Judge judge = new Judge(new Player("P1"), new Player("P2"), game);
		CleanStrikeService cSS = new CleanStrikeService();
		cSS.showResult(judge, strikes);

	}

}
