package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import model.*;

public class BoardView extends JPanel {
	// Should not be here because it is a model
	// TileView_Puzzle tileView_Puzzle[] = new TileView_Puzzle[144];
	
	Board board;
	/**
	 * Create the panel.
	 */
	public BoardView(Board board) {
		this.board = board;
		setPreferredSize(new Dimension(700, 600));
		setBackground(Color.PINK);
		setLayout(null);
		// Should call the data in board variable
		/* int k = 0;
		for (int i=0;i<=11;i++){
			for (int j=0;j<=11;j++){
				tileView_Puzzle[k] = new TileView_Puzzle();
				tileView_Puzzle[k].setBounds(77+46*j,25+46*i,45,45);
				add(tileView_Puzzle[k]);
				k++;
			}
		}*/

		
		
	}
}
