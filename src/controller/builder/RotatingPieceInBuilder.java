package controller.builder;

import model.Bullpen;
import model.Level;
import model.Piece;
import view.PieceView;

public class RotatingPieceInBuilder extends BuilderMove {
	Piece pieceChosen;
	PieceView pieceView;
	boolean orientation = false;
	public RotatingPieceInBuilder(Piece pieceChosen, PieceView pieceView, boolean orientation){
		this.pieceChosen = pieceChosen;
		this.pieceView = pieceView;
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
		this.pieceView.redraw();
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
