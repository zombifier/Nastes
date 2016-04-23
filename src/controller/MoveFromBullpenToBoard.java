package controller;

import model.Board;
import model.Bullpen;
import model.Piece;

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
