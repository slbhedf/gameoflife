package gameoflife;

import java.awt.event.*;

public class ClearButtonListener implements ActionListener{
	private MyGameBoard board;
	private DrawingPanel panel;

	public ClearButtonListener(MyGameBoard board, DrawingPanel panel) {
		this.board = board;
		this.panel = panel;
	}
	
	public void actionPerformed(ActionEvent ae) {
		this.board.clearBoard();
		this.panel.repaint();
		System.out.println("Clear button pressed.");
	}

}
