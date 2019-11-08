package gameoflife;

import javax.swing.*;

public class TestGlider {

	public TestGlider() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		final int WIDTH = 25;
		final int HEIGHT = 25;
		MyGameBoard b = new MyGameBoard(WIDTH, HEIGHT);
		
		b.turnToLiving(0, 0);
		b.turnToLiving(1, 1);
		b.turnToLiving(2, 1);
		b.turnToLiving(0, 2);
		b.turnToLiving(1, 2);
		
		UserInterface ui = new UserInterface(b);
		SwingUtilities.invokeLater(ui);
	}

}
