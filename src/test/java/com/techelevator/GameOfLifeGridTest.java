package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;





public class GameOfLifeGridTest {
	
	GameOfLifeGrid gameOfLifeGrid = new GameOfLifeGrid();
	
	@Before
	public void setup() {
		gameOfLifeGrid.setInitialSize(10, 5);
		
	}
	
	@Test
	public void create_grid_with_10_rows_5_columns() {
		int[][] expectedGrid = new int[10][5];
		Assert.assertArrayEquals(expectedGrid, gameOfLifeGrid.getGrid());
		Assert.assertEquals(10, gameOfLifeGrid.getNumberOfRows());
		Assert.assertEquals(5, gameOfLifeGrid.getNumberOfColumns());
	}
	
	@Test
	public void set_grid_values_to_zero_or_one() {
		gameOfLifeGrid.setGridValues(gameOfLifeGrid.getGrid());
		int[][] grid = gameOfLifeGrid.getGrid();
		gameOfLifeGrid.setGridValues(grid);
		
		boolean isZeroOrOne = true;
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 5; j++) {
				if(!(grid[i][j] == 0 || grid[i][j] == 1)){
					isZeroOrOne = false;
				}
			}
		}
		Assert.assertTrue(isZeroOrOne);
	}
	
	@Test
	public void return_1_if_neighbor_valid_and_in_array() {
		int[][] nonRandomGrid = {{0,0,1,0},
								{1,0,0,1},
								{0,1,0,0}};
		Assert.assertEquals(1, gameOfLifeGrid.countAllLiveNieghbors(nonRandomGrid, 0, 0));
		Assert.assertEquals(3, gameOfLifeGrid.countAllLiveNieghbors(nonRandomGrid, 1, 1));
	}
}
