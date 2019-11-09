# Simulation of Conway's Game of Life with Java Swing.

<img src="https://raw.githubusercontent.com/slbhedf/gameoflife/master/20191108184043.png">

Conway's Game of Life - Wikipedia
https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life

# Files
* README.md 	: here
* UserInterface.java : Runnable class
* GameOfLifeBoard.java : abstract class of Game Board 
* MyGameBoard.java 	: inherites  GameOfLifeBoard
* Grid.java : draws grid, and fills living cells with balck
* DrawingPanel.java : inherites JPanel
* AutoPlayButtonListener.java 	
* ClearButtonListener.java 	
* PlayButtonListener.java 
* ScreenClickListener.java 
* StopButtonListener.java 
* WindowCloseListener.java
* MyTimer.java 	: inherites javax.swing.Timer
		
* TestGameOfLifesLogic.java: find out whether MyGameBoard really works

* TestBlinker.java 	: graphical test
* TestGlider.java 	: graphical test
* TestGosperGliderGun.java : graphical test	
* TestLargeX.java 	: graphical test
* TestToad.java 	: graphical test
	
# Note
1. if you click a squre, its color become changed, from black to white, or from white to black.
white squares are dead cells, black squres are living cells.

2. you can play auto play mode, if you press "auto play" button.
