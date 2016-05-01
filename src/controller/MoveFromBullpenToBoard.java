package controller;

import model.Board;
import model.Bullpen;
import model.Piece;

/**
 * Move Class for Bullpen to Board
 * Handles moving from bullpen to board. 
 * @author TeamNasts
 *
 */

public class MoveFromBullpenToBoard {
	
	Bullpen bullpen;
	Board board;
	Piece pieceBeingDrag;
	public MoveFromBullpenToBoard(Bullpen bullpen,Board board,Piece piece){
		this.bullpen = bullpen;
		this.board = board;
		this.pieceBeingDrag = piece;
	}
	
	public boolean doMove() {
		
		return true;
	}

	
	public boolean undo() {
		
		return true;
	}

	
	public boolean valid() {
		return false;
	}
}
