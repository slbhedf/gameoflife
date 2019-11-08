package gameoflife;

import java.awt.event.*;
//import javax.swing.Timer;

public class AutoPlayButtonListener implements ActionListener{
	private UserInterface ui;
	private MyTimer myTimer;
	
	private static int DEFAULT_DELAY = 150; // interval milli seconds

	public AutoPlayButtonListener(MyGameBoard myGameBoard, DrawingPanel drawingPanel, UserInterface ui) {
		this.ui = ui;
		this.myTimer = new MyTimer(DEFAULT_DELAY, myGameBoard, drawingPanel, ui);
	}
	
	public void setDelay(int delay) {
		this.myTimer.setDelay(delay);
	}

	public void actionPerformed(ActionEvent ae) {
		System.out.println("Auto Play Button pressed.");
		
		UserInterface ui = this.ui;
		ui.getStopButton().setEnabled(true);
		
		System.out.println("Auto Playing started.");
		this.myTimer.start();
	}

}

