package com.techelevator;

public class GameOfLifeGrid {
	
	private int numberOfColumns;
	private int numberOfRows;
	private int[][] grid;
	
	public void setInitialSize(int rows, int columns){
		this.grid = new int[rows][columns];
		this.numberOfColumns = columns;
		this.numberOfRows = rows;

	}
	
	public void setGridValues(int[][] grid){
		int rowLength = grid.length;
		int columnLength = grid[0].length;
		
		for(int i = 0; i < rowLength; i++) {
			for(int j = 0; j < columnLength; j++) {
				int cellValue = 0;
				double num = Math.random();
				if(num <= 0.1) { //returns 1(alive) ~10% of the time
					cellValue = 1;
				}
				grid[i][j] = cellValue;
			}
		}
	}
	
	public int[][] getNewState(){
		int rowLength = grid.length;
		int columnLength = grid[0].length;
		int [][] newGrid = new int[rowLength][columnLength];
		
		return newGrid;
	}
	
	public int countAllLiveNieghbors(int[][] currentGrid, int row, int column) {
		int liveNeighborTotalCount = 0;
		
		liveNeighborTotalCount += validNeighbor(currentGrid, row + 1, column); //check bottom
		liveNeighborTotalCount += validNeighbor(currentGrid, row - 1, column); //check top
		liveNeighborTotalCount += validNeighbor(currentGrid, row, column + 1); //check right
		liveNeighborTotalCount += validNeighbor(currentGrid, row, column - 1); //check left
		liveNeighborTotalCount += validNeighbor(currentGrid, row - 1, column - 1); //up 1 left 1
		liveNeighborTotalCount += validNeighbor(currentGrid, row - 1, column + 1); //up 1 right 1
		liveNeighborTotalCount += validNeighbor(currentGrid, row + 1, column - 1); // down 1 left
		liveNeighborTotalCount += validNeighbor(currentGrid, row + 1, column + 1); //down 1 right 1
				
		return liveNeighborTotalCount;
	}
	
	public int validNeighbor(int[][] currentGrid, int neighborRow, int neighborColumn) {
		int liveNeighborCount = 0;
		try {
			liveNeighborCount += currentGrid[neighborRow][neighborColumn];
		} catch(Exception e) {
			
		}
		
		return liveNeighborCount;
		
	}

	
	//getters & setters
	public int getNumberOfColumns() {
		return numberOfColumns;
	}

	public void setNumberOfColumns(int numberOfColumns) {
		this.numberOfColumns = numberOfColumns;
	}

	public int getNumberOfRows() {
		return numberOfRows;
	}

	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

	public int[][] getGrid() {
		return grid;
	}

	public void setGrid(int[][] grid) {
		this.grid = grid;
	}

}
