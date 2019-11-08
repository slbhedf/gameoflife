package gameoflife;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopButtonListener implements ActionListener{
	private UserInterface ui;

	public StopButtonListener(UserInterface ui) {
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// stop auto playing
		UserInterface ui = this.ui;
		ui.TurnOnStopSignal();
		System.out.println("Sent a Stop Signal");
	}

}
