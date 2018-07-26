package com.techelevator;

import com.techelevator.View.Menu;

public class GameOfLifeStart {

	public static void main(String[] args) {
		
		Menu menu = new Menu(System.in, System.out);
		
		GameOfLifeGrid gameOfLifeGrid = new GameOfLifeGrid();
		
		GameOfLifeCLI cli = new GameOfLifeCLI(menu, gameOfLifeGrid);
		cli.run();
	}
}
