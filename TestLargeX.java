package gameoflife;

import javax.swing.SwingUtilities;

public class TestLargeX {

	public TestLargeX() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		final int WIDTH = 25;
		final int HEIGHT = 25;
		MyGameBoard b = new MyGameBoard(WIDTH, HEIGHT);
		
		for(int i=0; i<WIDTH && i < HEIGHT; i++) {
			b.turnToLiving(i, i);
		}
		
		for(int i=0; i<WIDTH && i < HEIGHT; i++) {
			b.turnToLiving(i, -i+HEIGHT-1);
		}
		
		UserInterface ui = new UserInterface(b);
		SwingUtilities.invokeLater(ui);
	}

}
