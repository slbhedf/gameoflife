package gameoflife;

import javax.swing.SwingUtilities;

public class TestBlinker {

	public TestBlinker() {
	}

	public static void main(String[] args) {
		final int WIDTH = 25;
		final int HEIGHT = 25;
		MyGameBoard b = new MyGameBoard(WIDTH, HEIGHT);
		// vertical lines
		for(int i=1; i<WIDTH; i+=8) {
			for(int j=0; j<HEIGHT; j++) {
				if(j%4==3) {
					continue;
				}
				b.turnToLiving(i, j);
			}
		}

		// horizontal lines
		for(int j=1; j<HEIGHT; j+=4){
			for(int i=4; i<WIDTH; i+=8) {
				b.turnToLiving(i, j);
				b.turnToLiving(i+1, j);
				b.turnToLiving(i+2, j);
			}
		}

		UserInterface ui = new UserInterface(b);
		SwingUtilities.invokeLater(ui);
	}

}
