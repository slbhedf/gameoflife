package gameoflife;

import javax.swing.SwingUtilities;

public class TestToad {

	public TestToad() {
	}

	public static void main(String[] args) {
		final int WIDTH = 25;
		final int HEIGHT = 25;
		MyGameBoard b = new MyGameBoard(WIDTH, HEIGHT);
		
		// vertical lines
		for(int i=3; i<WIDTH; i+=6) {
			for(int j=2; j<HEIGHT; j+=6) {
				b.turnToLiving(i-2, j-1);
				b.turnToLiving(i-1, j-1);
				b.turnToLiving(i, j-1);
				b.turnToLiving(i-3, j);
				b.turnToLiving(i-2, j);
				b.turnToLiving(i-1, j);
			}
		}

		UserInterface ui = new UserInterface(b);
		SwingUtilities.invokeLater(ui);
	}

}
