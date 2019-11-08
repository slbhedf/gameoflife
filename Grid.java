package gameoflife;

import java.awt.*;

public class Grid {
	private MyGameBoard myGameBoard;
	private int unitLength;
	private int left = 50; // left top is (0, 0) now
	private int top = 50; // left top is (0, 0) now
	public static int DEFAULT_UNIT_LENGTH;
	
	public Grid(MyGameBoard myGameBoard, int unitLength) {
		this.myGameBoard = myGameBoard;
		this.unitLength = unitLength;
	}
	
	public Grid(MyGameBoard myGameBoard) {
		this.myGameBoard = myGameBoard;
		this.unitLength = DEFAULT_UNIT_LENGTH;
	}
	
	
	public int getUnitLength() {
		return this.unitLength;
	}
	
	public MyGameBoard getMyGameBoard() {
		return this.myGameBoard;
	}
	
	public int getLeft() {
		return this.left;
	}
	
	public void setLeft(int left) {
		this.left = left;
	}
	
	public int getTop() {
		return this.top;
	}
	
	public void setTop(int top) {
		this.top = top;
	}

	public void drawLines(Graphics g) {
		g.setColor(Color.GRAY);
		MyGameBoard board = this.myGameBoard;
		int columns = board.getNumberOfColumns();
		int rows = board.getNumberOfRows();
		int unitLength = this.getUnitLength();

		int x1,x2, y1,y2;
		x1 = this.getLeft();
		y1 = this.getTop();
		x2 = this.getLeft();
		y2 = rows*unitLength + this.getTop();
		// draw vertical lines from left to right
		while(x1 <= columns * unitLength + this.getLeft()) {
			g.drawLine(x1, y1, x2, y2);
			x1 += unitLength;
			x2 += unitLength;
		}

		x1 = this.getLeft();
		y1 = this.getTop();
		x2 = columns*unitLength + this.getLeft();
		y2 = this.getTop();
		// draw horizontal lines from top to bottom
		while(y1 <= rows * unitLength + this.getTop()) {
			g.drawLine(x1, y1, x2, y2);
			y1 += unitLength;
			y2 += unitLength;
		}
	}
	

	public void fillSqaures(Graphics g) {
		g.setColor(Color.BLACK);
		int width = this.myGameBoard.getNumberOfColumns();
		int height = this.myGameBoard.getNumberOfRows();
		int unitLength = this.unitLength;
		for(int i=0; i<width; i++) {
			for(int j=0; j<height; j++) {
				if(!this.myGameBoard.onTheBoard(i, j)) {
					continue;
				}
				if(this.myGameBoard.getBoard()[i][j]) {
					g.fillRect(i*unitLength+this.getLeft()+1, j*unitLength+this.getTop()+1, unitLength-1, unitLength-1);
				}
			}
		}
	}

}
