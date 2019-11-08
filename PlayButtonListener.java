package gameoflife;

import java.awt.event.*;


public class PlayButtonListener implements ActionListener{
	private MyGameBoard myGameBoard;
	private DrawingPanel drawingPanel;

	public PlayButtonListener(MyGameBoard myGameBoard, DrawingPanel drawingPanel) {
		this.myGameBoard = myGameBoard;
		this.drawingPanel = drawingPanel;
	}
	
	public void actionPerformed(ActionEvent ae) {
		System.out.println("Play button pressed.");
		this.myGameBoard.playTurn();
		this.drawingPanel.repaint();
	}
}
