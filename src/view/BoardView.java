package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import controller.builder.TileController;
import model.*;

public class BoardView extends JPanel {
	// Should not be here because it is a model
	// Also, should not be too specific to only one type
	// TileView_Puzzle tileView_Puzzle[] = new TileView_Puzzle[144];
	
	Board board;
	
	TileView tileView[][] = new TileView[12][12];
	/**
	 * Create the panel.
	 */
	public BoardView(Board board) {
		this.board = board;
		
		if(this.board == null) // sanity check
			board = new Board();
			
		setPreferredSize(new Dimension(700, 600));
		setBackground(Color.PINK);
		setLayout(null);
		
		for (int i=0;i<=11;i++){
			for (int j=0;j<=11;j++){
				tileView[i][j] = new TileView_Puzzle(board.getTile(i, j));
				tileView[i][j].setBounds(77+46*j,25+46*i,45,45);
				add(tileView[i][j]);
				TileController tl = new TileController(board.getTile(i, j), tileView[i][j]);
				tileView[i][j].addMouseListener(tl);
				//k++;
			}
		}

		
		
	}
}
