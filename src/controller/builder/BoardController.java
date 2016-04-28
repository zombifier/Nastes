package controller.builder;

import java.awt.Polygon;
import java.awt.event.*;

import model.*;
import view.*;

/**
 * BoardController class.
 * @author Team Nastes
 */
public class BoardController extends MouseAdapter {
	BuilderApplication ba;
	Board board;
	BoardView boardView;
	
	/**
	 * BoardController constructor. Sets the board and boardView to the current board and boardView.
	 * @param board
	 * @param boardView
	 */
	public BoardController(BuilderApplication ba, Board board, BoardView boardView){
		this.ba = ba;
		this.board = board;
		this.boardView = boardView;
	}
	
	@Override
	public void mousePressed(MouseEvent ae){
		TileView t;
		try{
			t = (TileView) boardView.findComponentAt(ae.getPoint());
		}catch(Exception e){
			System.out.println("Does not click on the screen");
			t = null;
		}
		if(t != null){
			// If the user left clicked, toggle the state of the tile
			if (ae.getModifiers()==InputEvent.BUTTON1_MASK){
				//System.out.println("Tile state toggle initiated.");
				BuilderMove m = new TileValidMove (t);
				if (m.doMove()) {
					ba.getLevel().addMove(m);
				}			}
			if (ae.getModifiers()==InputEvent.BUTTON3_MASK){
				//Check to see if the level is a release level.
				//If it is, run the below.
				//System.out.println("Release number state change initiated.");
				//Call the function that handles changing the number.
			}
		}
	}
	/*
	@Override
	public void mouseReleased(MouseEvent ae){
		TileView t = (TileView) boardView.findComponentAt(ae.getPoint());
		if(t != null){
			PieceView pw = (PieceView)ae.getComponent();
			this.boardView.drawPieceView(pw,t.getMousePosition());
		} else {
			System.out.println("Whoops");
		}
	}
	*/
}
