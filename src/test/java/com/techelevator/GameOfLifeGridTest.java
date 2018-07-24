package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;





public class GameOfLifeGridTest {
	
	GameOfLifeGrid gameOfLifeGrid = new GameOfLifeGrid();
	
	@Test
	public void create_grid_with_10_rows_5_columns() {
		gameOfLifeGrid.setInitialSize(10, 5);
		int[][] expectedGrid = new int[10][5];
		Assert.assertArrayEquals(expectedGrid, gameOfLifeGrid.getGrid());
		Assert.assertEquals(10, gameOfLifeGrid.getNumberOfRows());
		Assert.assertEquals(5, gameOfLifeGrid.getNumberOfColumns());
		
	}

}
