# GameOfLife

This code runs a 2D representation of Conway's Game of life, you can read more about it [HERE](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life).

## BUILD

Using Maven, you can run the application by running the following command
```
java -cp game-of-life-kata-0.0.1-SNAPSHOT.jar com.techelevator.GameOfLifeStart
```

To run the unit tests use the following command 
```
mvn test
```
## How it Works

Once the program is ran, the following CLI will display with three options:

1) Select a custom Grid(if not selected, will default to 8x6 grid)
2) Display next state
3) Quit Conway's Game of Life

_Select a custom Grid(if not selected, will default to 8x6 grid)_

The User will be prompted for the length of rows and columns that they want to use in the Game of Life grid.

_Display next state_

 Creates an initial grid with the grid length the user selected, 8x6 is defaulted to if no custom size was selected.  dead cells display as an '.' while living cells display as a 'O'.

 The next state is then displayed following the below rules:
-  Any live cell with fewer than two live neighbors dies, as if caused by under population
- Any live cell with more than three live neighbors dies, as if by overcrowding
- Any live cell with two or three live neighbors lives on to the next generation
- Any dead cell with exactly three live neighbors becomes a live cell

A user is then prompted with the following options

1) Recalculate and display another interation
2) Return to previous menu

_Recalculate and display another interation_
    
The user is able to continue with the new state as the initial state and create new generations of the grid

_Return to previous menu_

Takes the user back to the main menu

_Quit Conway's Game of Life_

User is able to end the program


