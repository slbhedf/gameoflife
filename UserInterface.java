package gameoflife;

import java.awt.*;
import javax.swing.*;

public class UserInterface implements Runnable{
	private MyGameBoard myGameBoard;
	private DrawingPanel drawingPanel;
	private Grid grid;
	private JFrame frame;
	private JButton playButton;
	private JButton clearButton;
	private JButton autoPlayButton;
	private JButton stopButton;
	private boolean stopSignal;
	private AutoPlayButtonListener autoPlayButtonListener;
	
	private static int unitLength = 20; // the side of the square of the grid 
	
	public UserInterface(MyGameBoard myGameBoard, Grid grid) {
		this.frame = new JFrame("Game of Life");
		this.myGameBoard = myGameBoard;
		this.grid = grid;
		this.drawingPanel = new DrawingPanel(grid);
		this.stopSignal = false;
		
		this.setScreenSize();
	}
	
	public UserInterface(MyGameBoard myGameBoard) {
		this(myGameBoard, new Grid(myGameBoard, unitLength));
	}
	
	public boolean stopSignal() {
		return this.stopSignal;
	}
	
	public void TurnOnStopSignal() {
		this.stopSignal = true;
	}
	
	public void TurnOffStopSignal() {
		this.stopSignal = false;
	}
	
	public void run() {
		JFrame frame = this.getFrame();

		this.createComponents(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
	
	public void setScreenSize(int width, int height) {
		JFrame frame = this.getFrame();
		frame.setPreferredSize(new Dimension(width, height));
	}
	
	public void setScreenSize() {
		JFrame frame = this.getFrame();
		int width = this.grid.getLeft() * 2 + this.grid.getUnitLength() * this.myGameBoard.getNumberOfColumns() +20;
		int height = this.grid.getTop() * 2 + this.grid.getUnitLength() * this.myGameBoard.getNumberOfRows()+80;
		frame.setPreferredSize(new Dimension(width, height));
	}
	
	public JButton getAutoPlayButton() {
		return this.autoPlayButton;
	}
	
	public JButton getClearButton() {
		return this.clearButton;
	}
	
	public JButton getPlayButton() {
		return this.playButton;
	}
	
	public JButton  getStopButton() {
		return this.stopButton;
	}

	
	public void createComponents(Container container) {
		// layout
		BorderLayout layout = new BorderLayout();
		JFrame frame = this.getFrame();
		frame.setLayout(layout);
		
		// when closing the window
		frame.addWindowListener(new WindowCloseListener(this));
		
		// game board, grid, drawing panel
		MyGameBoard gameBoard = this.myGameBoard;
		Grid grid = this.grid;
		DrawingPanel drawingPanel = this.drawingPanel;
		drawingPanel.addMouseListener(new ScreenClickListener(grid, drawingPanel));
		
		// play button
		JButton playButton = new JButton("Play");
		playButton.addActionListener(new PlayButtonListener(gameBoard, drawingPanel));
		this.playButton = playButton;
		
		// clear button
		JButton clearButton = new JButton("clear");
		clearButton.addActionListener(new ClearButtonListener(gameBoard, drawingPanel));
		this.clearButton = clearButton;
		
		// auto play button
		JButton autoPlayButton = new JButton("Auto Play");
		AutoPlayButtonListener autoPlayButtonListener = new AutoPlayButtonListener(gameBoard, drawingPanel, this);
		this.autoPlayButtonListener = autoPlayButtonListener;
		autoPlayButton.addActionListener(autoPlayButtonListener);
		this.autoPlayButton = autoPlayButton;
		
		// stop button
		JButton stopButton = new JButton("Stop");
		stopButton.addActionListener(new StopButtonListener(this));
		stopButton.setEnabled(false);
		this.stopButton = stopButton;
		
		// add buttons to a panel
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(1,4));
		buttons.add(clearButton, BorderLayout.WEST);
		buttons.add(playButton,BorderLayout.CENTER);
		buttons.add(autoPlayButton, BorderLayout.EAST);
		buttons.add(stopButton);
		
		// add the components to the container
		container.add(drawingPanel, BorderLayout.CENTER);
		container.add(buttons, BorderLayout.SOUTH);
	}
	
	
	public JFrame getFrame() {
		return this.frame;
	}
	
	
	public MyGameBoard getgameBoard() {
		return this.myGameBoard;
	}
	
	public AutoPlayButtonListener getAutoPlayButtonListener() {
		return this.autoPlayButtonListener;
	}
}
