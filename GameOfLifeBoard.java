package gameoflife;


// https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life

public abstract class GameOfLifeBoard {
	private int columns;
	private int rows;
	private boolean[][] board; // if a board[i][j] is alive, board[i][j]=true 
	private int[][] livingNeighbours;
	
	public GameOfLifeBoard(int columns, int rows) {
		this.columns = columns;
		this.rows = rows;
		this.board = new boolean[columns][rows];
		this.livingNeighbours = new int[columns][rows];
	}
	
	public boolean[][] getBoard() {
		return this.board;
	}
	
	public int getNumberOfColumns() {
		return this.columns;
	}
	
	public int getNumberOfRows() {
		return this.rows;
	}
	
	public void playTurn() {
		for(int i=0; i<this.getNumberOfColumns(); i++) {
			for(int j=0; j<this.getNumberOfRows(); j++) {
				this.livingNeighbours[i][j] = this.getNumberOfLivingNeighbours(i, j);
			}
		}
		
		// update at the same time
		for(int i=0; i<this.getNumberOfColumns(); i++) {
			for(int j=0; j<this.getNumberOfRows(); j++) {
				this.manageCell(i, j, livingNeighbours[i][j]);
			}
		}
		
		
	}
	
	public abstract void turnToLiving(int i,  int j);
	public abstract void turnToDead(int i, int j) ;
	public abstract boolean isAlive(int i, int j);
	public abstract void initiateRandomCells(double probabilityForEachCell) ;
	public abstract int getNumberOfLivingNeighbours(int i, int j) ;
	public abstract void manageCell(int i, int j, int livingNeighbours) ;



}
