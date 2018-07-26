package com.techelevator;

import com.techelevator.View.Menu;
import java.util.*;


public class GameOfLifeCLI {
	
	private static final String MAIN_MENU_OPTION_CUSTOM_GRID_SIZE = "Select a custom Grid(if not selected, will default to 8x6 grid)";
	private static final String MAIN_MENU_OPTION_DISPLAY_NEXT_STATE = "Display next state";
	private static final String MAIN_MENU_OPTION_QUIT = "Quit Conway's Game of Life";
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_CUSTOM_GRID_SIZE, 
													   MAIN_MENU_OPTION_DISPLAY_NEXT_STATE, MAIN_MENU_OPTION_QUIT};
	private static final String NEXT_STATE_MENU_RECALCULATE = "Recalculate and display another interation";
	private static final String NEXT_STATE_MENU_RETURN_TO_PREVIOUS_MENU = "Return to previous menu";
	private static final String[] NEXT_STATE_MENU_OPTIONS = {NEXT_STATE_MENU_RECALCULATE, 
															 NEXT_STATE_MENU_RETURN_TO_PREVIOUS_MENU};

	private Menu menu;
	private GameOfLifeGrid initialGameOfLifeGrid;
	
	public GameOfLifeCLI(Menu menu, GameOfLifeGrid initialGameOfLifeGrid) {
		this.menu = menu;
		this.initialGameOfLifeGrid = initialGameOfLifeGrid;
	}
	
	public void run() {
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_CUSTOM_GRID_SIZE)){
				userSetInitialGrid();
				
			}
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_NEXT_STATE)){
				displayNextState();
				
				while(true) {
				String choice2 = (String)menu.getChoiceFromOptions(NEXT_STATE_MENU_OPTIONS);
			
					if(choice2.equals(NEXT_STATE_MENU_RECALCULATE)) {
						int[][] currentGrid = initialGameOfLifeGrid.getNewState();
						initialGameOfLifeGrid.moveToSecondState(currentGrid);
						
						System.out.println("Current State \n");
						printGrid(initialGameOfLifeGrid.getGrid());
						
						System.out.println("New State \n");
						printGrid(initialGameOfLifeGrid.getNewState());
						
					} 
					if(choice2.equals(NEXT_STATE_MENU_RETURN_TO_PREVIOUS_MENU)){
						break;
					}
				}
			}
			if(choice.equals(MAIN_MENU_OPTION_QUIT)){
				System.exit(0);
			}
		}
	}
	
	
	
	
	public void userSetInitialGrid() {
		System.out.println("Please enter a grid that is larger than 0x0 and smaller than 15x15\n");
		
		System.out.println("How many rows?   ");
		int rows = menu.getDimensionsFromUser();
		
		System.out.println("How many columns?   ");
		int columns = menu.getDimensionsFromUser();
		
		initialGameOfLifeGrid.setInitialSize(rows, columns);
	}
	public void printGrid(int[][] grid) {
		int rowLength = grid.length;
		int columnLength = grid[0].length;
		
		String cellPrintValue = "";
		
		for(int i = 0; i < rowLength; i++) {
			for(int j = 0; j < columnLength; j++) {
				if(grid[i][j] == 0) {
					cellPrintValue = ".";
				} else {
					cellPrintValue = "O";
				}
				System.out.print(cellPrintValue + " ");
			}
			System.out.println();
		}
		System.out.println("\n*************************\n");
	}
	public void displayNextState() {
		if(initialGameOfLifeGrid.getNumberOfColumns() == 0) {
			initialGameOfLifeGrid.setInitialSize(6, 8);
		}
		initialGameOfLifeGrid.setGridValues();
		
		System.out.println("Initial State \n");
		printGrid(initialGameOfLifeGrid.getGrid());
		
		System.out.println("New State \n");
		printGrid(initialGameOfLifeGrid.getNewState());
	}
	
}
