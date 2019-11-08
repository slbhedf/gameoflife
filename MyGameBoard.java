package gameoflife;

import java.util.Random;

public class MyGameBoard extends GameOfLifeBoard  {
	public static int left = 0;
	public static int right = 500;
	public static int low = 0;
	public static int high = 500;

	public MyGameBoard(int columns, int rows){
		super(columns, rows);
	}

	public void turnToLiving(int i, int j) {
		boolean[][] board = this.getBoard();
		board[i][j] = true;
	}

	public void turnToDead(int i, int j) {
		boolean[][] board = this.getBoard();
		board[i][j] = false;
	}

	public boolean isAlive(int i, int j) {
		boolean[][] board = this.getBoard();
		return board[i][j];
	}

	public void initiateRandomCells(double probabilityForEachCell) {
		Random random = new Random();
		boolean[][] board = this.getBoard();

		for(int i=0; i<this.getNumberOfColumns(); i++) {
			for(int j=0; j<this.getNumberOfRows(); j++) {
				if(random.nextFloat() <= probabilityForEachCell) {
					board[i][j] = true; 
				} else {
					board[i][j] = false;
				} 
			}
		}
	}
	
	// find out whether gameboard[i][j] is on the gameboard or not.
	// this method is necessary to avoid ArrayIndexError.
	public boolean onTheBoard(int i, int j) {
		if(i >= 0 && i < this.getNumberOfColumns()) {
			if(j >= 0 && j < this.getNumberOfRows()) {
				return true;
			}
		}
		return false;
	}

	public int getNumberOfLivingNeighbours(int i, int j) {		
		int count = 0;
		for(int n=j-1; n<=j+1; n++) {
			for(int m=i-1; m<=i+1; m++) {
				if(this.onTheBoard(m, n)) {
					if(m==i && n==j) {
						continue;
					} else {
						if(this.isAlive(m, n)) {
							count++;
						}
					}
				}
			}
		}
		return count;
	}

	public void manageCell(int i, int j, int livingNeighbours) {
		if(this.isAlive(i, j)) {
			if (livingNeighbours < 2) {
				this.turnToDead(i, j);
			} else if(livingNeighbours > 3) {
				this.turnToDead(i, j);
			}
		} else {
			if (livingNeighbours == 3) {
				this.turnToLiving(i, j);
			}
		}
	}
	
	// all cells become dead
	public void clearBoard() {
		int width = this.getNumberOfColumns();
		int height = this.getNumberOfRows();
		for(int i=0; i<width; i++) {
			for(int j=0; j<height; j++) {
				this.turnToDead(i, j);
			}
		}
	}

	
	
	

	public static void main(String[] args) {
		MyGameBoard board = new MyGameBoard(7, 5);

		board.turnToLiving(0, 1);
		board.turnToLiving(1, 0);
		board.turnToLiving(1, 2);
		board.turnToLiving(2, 2);
		board.turnToLiving(2, 1);

		System.out.println("Neighbours alive (0,0): " + board.getNumberOfLivingNeighbours(0, 0));
		System.out.println("Neighbours alive (1,1): " + board.getNumberOfLivingNeighbours(1, 1));
		


	}

}
