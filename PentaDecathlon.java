package gameoflife;

public class PentaDecathlon {

	public PentaDecathlon() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		final int WIDTH = 25;
		final int HEIGHT = 25;
		MyGameBoard b = new MyGameBoard(WIDTH, HEIGHT);
		
		for(int j=5; j<=14; j++) {
			if(j==7 || j==12) {
				continue;
			}
			b.turnToLiving(12, j);
		}
		b.turnToLiving(11, 7);
		b.turnToLiving(13, 7);
		
		b.turnToLiving(11, 12);
		b.turnToLiving(13, 12);
		
		UserInterface ui = new UserInterface(b);
		ui.run();

	}

}
