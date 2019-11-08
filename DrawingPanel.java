package gameoflife;

import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel{
	/**
	 * the game board and grid are drawn on the drawing panel 
	 */
	private static final long serialVersionUID = 1L;
	private Grid grid;

	public DrawingPanel(Grid grid) {
		this.grid = grid;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.grid.drawLines(g);
		this.grid.fillSqaures(g);
	}
}
