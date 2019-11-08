package gameoflife;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowCloseListener extends WindowAdapter{
	private UserInterface ui;

	public WindowCloseListener(UserInterface ui) {
		this.ui = ui;
	}
	
	public void windowClosing(WindowEvent e){
	    System.exit(0);
	}

}
