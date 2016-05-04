package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPanel;

import controller.builder.BoardController;
import controller.builder.PiecePlayerController;
import model.*;

/**
 * 
 * BoardView. 
 * Contains Board, BuilderApplication, TileViews, and PieceViews in the board. 
 * @author Team Nastes
 *
 */

public class BoardView extends JPanel {
	// Should not be here because it is a model
	// Also, should not be too specific to only one type
	// TileView_Puzzle tileView_Puzzle[] = new TileView_Puzzle[144];
	
	Board board;
	
	BuilderApplication app;
	
	TileView tileView[][] = new TileView[12][12];
	
	PieceView pieceView[] = new PieceView[24];
	/**
	 * Constructor for BoardView
	 * @param board Board
	 * @param app BuilderApplication
	 */
	public BoardView(Board board, BuilderApplication app) {
		this.board = board;
		this.app = app;
		if(this.board == null) // sanity check
			board = new Board(0);
			
		setPreferredSize(new Dimension(700, 600));
		setBackground(Color.PINK);
		setLayout(null);
		
		try {
			for (int i=0;i<=11;i++){
				for (int j=0;j<=11;j++){
					//System.out.println(board.getTile(i, j));
					if(this.board.getLevelType()==0){
						tileView[i][j] = new TileView_Puzzle(board.getTile(i, j));
					} else if (this.board.getLevelType()==1){
						tileView[i][j] = new TileView_Lightning(board.getTile(i, j));
					} else if (this.board.getLevelType()==2){
						tileView[i][j] = new TileView_Release(board.getTile(i, j));
					}
					
					tileView[i][j].setBounds(77+46*j,25+46*i,45,45);
					add(tileView[i][j]);
					
					//k++;
				}
			}
		} catch (Exception e){
			System.out.println("...");
		}
		BoardController tl = new BoardController(app, this.board, this);
		this.addMouseListener(tl);
		
		
	}
	/**
	 * This function reDraw the Piece in the board
	 * This function was not used. 
	 * @param pw PieceView
	 * @param mousePosition mousePosition
	 */
	public void drawPieceView(PieceView pw, Point mousePosition) {
		// TODO Auto-generated method stub
		Dimension d = pw.getPreferredSize();
		pw.setBounds(mousePosition.x, mousePosition.y, d.width, d.height);
		add(pw);
		//PiecePlayerController m = new PiecePlayerController(this.app,pieceView);
		//pw.addMouseListener(m);
		//pw.addMouseMotionListener(m);
		this.repaint();
	}
	/**
	 * Getter function for board. 
	 * @return board
	 */
	public Board getBoard(){
		return this.board;
	}
	
	
}
