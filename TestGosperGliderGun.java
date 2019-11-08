package gameoflife;

import javax.swing.SwingUtilities;

public class TestGosperGliderGun {

	public TestGosperGliderGun() {
	}

	public static void main(String[] args) {
		final int WIDTH = 40;
		final int HEIGHT = 25;
		MyGameBoard b = new MyGameBoard(WIDTH, HEIGHT);
		
		b.turnToLiving(1, 5);
		b.turnToLiving(1, 6);
		b.turnToLiving(2, 5);
		b.turnToLiving(2, 6);
		
		b.turnToLiving(11, 5);
		b.turnToLiving(11, 6);
		b.turnToLiving(11, 7);
		b.turnToLiving(12, 4);
		b.turnToLiving(12, 8);
		b.turnToLiving(13, 3);
		b.turnToLiving(13, 9);
		b.turnToLiving(14, 3);
		b.turnToLiving(14, 9);
		b.turnToLiving(15, 6);
		b.turnToLiving(16, 4);
		b.turnToLiving(16, 8);
		b.turnToLiving(17, 5);
		b.turnToLiving(17, 6);
		b.turnToLiving(17, 7);
		b.turnToLiving(18, 6);
		
		b.turnToLiving(21, 3);
		b.turnToLiving(21, 4);
		b.turnToLiving(21, 5);
		b.turnToLiving(22, 3);
		b.turnToLiving(22, 4);
		b.turnToLiving(22, 5);
		b.turnToLiving(23, 2);
		b.turnToLiving(23, 6);
		b.turnToLiving(25, 1);
		b.turnToLiving(25, 2);
		b.turnToLiving(25, 6);
		b.turnToLiving(25, 7);
		
		b.turnToLiving(35, 3);
		b.turnToLiving(35, 4);
		b.turnToLiving(36, 3);
		b.turnToLiving(36, 4);
		
		UserInterface ui = new UserInterface(b);
		SwingUtilities.invokeLater(ui);
	}

}
