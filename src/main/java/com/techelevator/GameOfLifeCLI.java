package com.techelevator;

import com.techelevator.View.Menu;

public class GameOfLifeCLI {
	
	private static final String MAIN_MENU_OPTION_CUSTOM_GRID_SIZE = "Select a custom Grid(if not selected, will default to 8x6 grid)";
	private static final String MAIN_MENU_OPTION_DISPLAY_NEXT_STATE = "Display next state";
	private static final String MAIN_MENU_OPTION_QUIT = "Quit Conway's Game of Life";
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_CUSTOM_GRID_SIZE, 
													   MAIN_MENU_OPTION_DISPLAY_NEXT_STATE, MAIN_MENU_OPTION_QUIT};
	private static final String NEXT_STATE_MENU_RECALCULATE = "Recalculate grid";
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
				System.out.println("Please enter a grid that is larger than 0x0 and smaller than 15x15\n");
				System.out.println("How many rows?   ");
				int rows = menu.getDimensionsFromUser();
				
				System.out.println("How many columns?   ");
				int columns = menu.getDimensionsFromUser();
			}
		}
	}
	

}
