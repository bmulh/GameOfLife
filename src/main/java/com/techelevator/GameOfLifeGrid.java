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
	public int countLiveNieghbors(int[][] currentGrid, int row, int column) {
		int liveNeighborCount = 0;
		boolean isCounting = true;
		while(isCounting)
		try { liveNeighborCount += currentGrid[row + 1][column]; //check bottom
			liveNeighborCount += currentGrid[row - 1][column]; //check top
			liveNeighborCount += currentGrid[row][column + 1]; //check right
			liveNeighborCount += currentGrid[row][column - 1]; //check left
			liveNeighborCount += currentGrid[row - 1][column - 1]; //up 1 left 1
			liveNeighborCount += currentGrid[row - 1][column + 1]; //up 1 right 1
			liveNeighborCount += currentGrid[row + 1][column - 1]; // down 1 left 1
			liveNeighborCount += currentGrid[row + 1][column + 1]; //down 1 right 1
			
		} catch(Exception e) {
			
		}
		return null;
		
	}
	
	
	public boolean isInFirstRow(int rowValue) {
		if(rowValue == 0) {
			return true;
		}
		return false;
	}
	
	public boolean isInLastRow(int rowValue) {
		if(rowValue == (this.numberOfRows - 1)) {
			return true;
		}
		return false;
	}
	
	public boolean isInFirstColumn(int columnValue) {
		if(columnValue == 0) {
			return true;
		}
		return false;
	}
	
	public boolean isInLastColumn(int columnValue) {
		if(columnValue == (this.numberOfColumns - 1)) {
			return true;
		}
		return false;
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
