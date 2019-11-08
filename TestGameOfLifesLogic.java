package gameoflife;
import java.util.Scanner;

public class TestGameOfLifesLogic {
	private GameOfLifeBoard board;
	private Scanner scanner;

	public TestGameOfLifesLogic(GameOfLifeBoard board) {
		this.board = board;
		this.scanner = new Scanner(System.in);
	}
	
	public String readInput(String q) {
		System.out.print(q);
		String input = this.scanner.nextLine();
		return input;
	}
	
	public void play() {
		while(true) {
			String input = this.readInput("Press enter to continue, otherwise quit: <enter>");
			if(!input.isEmpty()) {
				System.out.println("Thanks!");
				break;
			}
			
			
			for(int j=0; j<this.board.getNumberOfRows(); j++) {
				for(int i=0; i<this.board.getNumberOfColumns(); i++) {
					if(this.board.getBoard()[i][j]) {
						System.out.print("x");
					} else {
						System.out.print(" ");
					}
				}
				System.out.println("");
			}
			this.board.playTurn();
		}
	}

	public static void main(String[] args) {
		MyGameBoard blinker = new MyGameBoard(5,5);
		blinker.turnToLiving(2, 1);
		blinker.turnToLiving(2, 2);
		blinker.turnToLiving(2, 3);
		TestGameOfLifesLogic blinkerTester = new TestGameOfLifesLogic(blinker);
		blinkerTester.play();
		
		MyGameBoard toad = new MyGameBoard(6,6);
		toad.turnToLiving(3, 2);
		toad.turnToLiving(4, 2);
		toad.turnToLiving(5, 2);
		toad.turnToLiving(2, 3);
		toad.turnToLiving(3, 3);
		toad.turnToLiving(4, 3);
		TestGameOfLifesLogic toadTester = new TestGameOfLifesLogic(toad);
		toadTester.play();
//		PersonalBoard board = new PersonalBoard(7, 7);
//
//		board.turnToLiving(0, 1);
//		board.turnToLiving(1, 0);
//		board.turnToLiving(1, 2);
//		board.turnToLiving(2, 2);
//		board.turnToLiving(2, 1);
//		GameOfLifeTester tester = new GameOfLifeTester(board);
//
//		System.out.println("Neighbours alive (0,0): " + board.getNumberOfLivingNeighbours(0, 0));
//		System.out.println("Neighbours alive (1,1): " + board.getNumberOfLivingNeighbours(1, 1));
//		tester.play();

	}

}
