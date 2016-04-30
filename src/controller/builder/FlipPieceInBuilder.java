package controller.builder;

import model.Piece;

public class FlipPieceInBuilder {
	Piece pieceChosen;
	boolean axis = false;
	public FlipPieceInBuilder(Piece pieceChosen, boolean axis){
		this.pieceChosen = pieceChosen;
		this.axis = axis;
		
	}

	public boolean doMove() {
		if (this.valid()){
			this.pieceChosen.flip(this.axis);

			return true;
		} else {
			return false;
		}
		
		
	}

	
	public boolean undo() {
		this.pieceChosen.flip(!this.axis);
		return true;
	}

	
	public boolean valid() {
		if (this.pieceChosen != null){
			return true;
		} else {
			return false;
		}
		
	}
}
