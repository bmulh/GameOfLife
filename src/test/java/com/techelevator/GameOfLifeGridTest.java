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
		gameOfLifeGrid.setGridValues();
		int[][] grid = gameOfLifeGrid.getGrid();
		gameOfLifeGrid.setGridValues();
		
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
		Assert.assertEquals(1, gameOfLifeGrid.countAllLiveNeighbors(nonRandomGrid, 0, 0));
		Assert.assertEquals(3, gameOfLifeGrid.countAllLiveNeighbors(nonRandomGrid, 1, 1));
	}
	
	@Test
	public void return_cell_dead_if_less_than_2_neighbors() {
		int[][] nonRandomGrid = {{0,0,1,0},
								{1,0,0,1},
								{0,1,0,0}};
		gameOfLifeGrid.setGrid(nonRandomGrid);
		int[][] newStateGrid = gameOfLifeGrid.getNewState();
		Assert.assertEquals(0, newStateGrid[2][1]);
		Assert.assertEquals(0, newStateGrid[2][3]);
	}
	
	@Test
	public void cell_dead_if_more_than_3_live_neighbors() {
		int[][] nonRandomGrid = {{0,0,1,0},
								{1,0,0,1},
								{0,1,0,0},
								{1,1,0,1}};
		gameOfLifeGrid.setGrid(nonRandomGrid);
		int[][] newStateGrid = gameOfLifeGrid.getNewState();
		Assert.assertEquals(0, newStateGrid[2][0]);
	}
	
	@Test
	public void dead_cell_becomes_alive_if_3_live_neighbors() {
		int[][] nonRandomGrid = {{0,0,1,0},
								 {1,0,0,1},
								 {0,1,0,0},
								 {1,1,0,1}};
		gameOfLifeGrid.setGrid(nonRandomGrid);
		int[][] newStateGrid = gameOfLifeGrid.getNewState();
		Assert.assertEquals(1, newStateGrid[1][1]);
	}
	
	@Test
	public void check_all_cells_in_grid() {
		int[][] nonRandomGrid = {{0,0,1,0},
				 				 {1,0,0,1},
				 				 {0,1,0,0},
				 				 {1,1,0,1}};
		gameOfLifeGrid.setGrid(nonRandomGrid);
		int[][] newStateGrid = gameOfLifeGrid.getNewState();
		Assert.assertEquals(0, newStateGrid[0][0]);
		Assert.assertEquals(0, newStateGrid[0][1]);
		Assert.assertEquals(0, newStateGrid[0][2]);
	    Assert.assertEquals(0, newStateGrid[0][3]); 
		Assert.assertEquals(0, newStateGrid[1][0]);
		Assert.assertEquals(1, newStateGrid[1][1]);
		Assert.assertEquals(1, newStateGrid[1][2]);
		Assert.assertEquals(0, newStateGrid[1][3]);
		Assert.assertEquals(0, newStateGrid[2][0]);
		Assert.assertEquals(1, newStateGrid[2][1]);
		Assert.assertEquals(0, newStateGrid[2][2]);
		Assert.assertEquals(0, newStateGrid[2][3]);
		Assert.assertEquals(1, newStateGrid[3][0]);
		Assert.assertEquals(1, newStateGrid[3][1]);
		Assert.assertEquals(1, newStateGrid[3][2]);
		Assert.assertEquals(0, newStateGrid[3][3]);
	}
	
	@Test
	public void _second_state_becomes_the_starting_state() {
		int[][] startingGrid = {{0,0,0,0},
      			   				 {0,0,0,0},
      			   				 {0,0,0,0},
      			   				 {0,0,0,0}};
		
		int[][] nonRandomGrid = {{0,0,1,0},
				       			 {1,0,0,1},
				       			 {0,1,0,0},
				       			 {1,1,0,1}};
		gameOfLifeGrid.setGrid(startingGrid);
		gameOfLifeGrid.moveToSecondState(nonRandomGrid);
		Assert.assertArrayEquals(nonRandomGrid, gameOfLifeGrid.getGrid());
	}
}
