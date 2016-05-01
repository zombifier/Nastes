package controller.builder;

import model.Bullpen;
import model.Level;
import model.Piece;

public class RotatingPieceInBuilder {
	Piece pieceChosen;
	boolean orientation = false;
	public RotatingPieceInBuilder(Piece pieceChosen, boolean orientation){
		this.pieceChosen = pieceChosen;
		this.orientation = orientation;
		
	}

	public boolean doMove() {
		if (this.valid()){
			this.pieceChosen.rotate(this.orientation);

			return true;
		} else {
			return false;
		}
		
		
	}

	
	public boolean undo() {
		this.pieceChosen.rotate(!this.orientation);
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
