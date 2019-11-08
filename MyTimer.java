package gameoflife;

import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyTimer implements ActionListener {
	private Timer timer;
	private MyGameBoard myGameBoard;
	private DrawingPanel drawingPanel;
	private UserInterface ui;
	
	public MyTimer(int delay, MyGameBoard myGameBoard,  DrawingPanel drawingPanel, UserInterface ui) {
		this.timer = new Timer(delay, this);
		this.myGameBoard = myGameBoard;
		this.drawingPanel = drawingPanel;
		this.ui = ui;
	}
	
	public void setDelay(int delay) {
		this.timer.setDelay(delay);
	}
	
	public int getDelay() {
		return this.timer.getDelay();
	}
	
	public void start() {
		this.timer.start();
		this.ui.getAutoPlayButton().setEnabled(false);
		this.ui.getPlayButton().setEnabled(false);
		this.ui.getStopButton().setEnabled(true);
	}
	
	public void stop() {
		this.timer.stop();
		System.out.println("Auto Playing Stopped.");
		this.ui.getStopButton().setEnabled(false);
		this.ui.getAutoPlayButton().setEnabled(true);
		this.ui.getPlayButton().setEnabled(true);
		this.ui.TurnOffStopSignal();
	}

	public void actionPerformed(ActionEvent e) {
		this.myGameBoard.playTurn();
		this.drawingPanel.repaint();
		if (this.ui.stopSignal()) {
			this.stop();
		}
		
	}
}
