package gameoflife;

import java.awt.*;
import java.awt.event.*;

public class ScreenClickListener implements MouseListener{
	private Grid grid;
	private Component component;

	public ScreenClickListener(Grid grid, Component component) {
		this.grid = grid;
		this.component = component;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		int unitLength = this.grid.getUnitLength();
		int left = this.grid.getLeft();
		int top = this.grid.getTop();
		MyGameBoard myGameBoard = this.grid.getMyGameBoard();

		int i = (mouseX - left) / unitLength;
		int j = (mouseY - top) / unitLength;
		if(myGameBoard.onTheBoard(i, j)) {
			if(myGameBoard.getBoard()[i][j]) {
				myGameBoard.turnToDead(i, j);
			} else {
				myGameBoard.turnToLiving(i, j);
			}
			System.out.println("(" + mouseX+","+mouseY + ") clicked, "  
					+ "board[" + i + "][" + j + "] is " + myGameBoard.isAlive(i, j));
		}
		this.component.repaint();
		
	}

	public void mouseEntered(MouseEvent e){	
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
}
