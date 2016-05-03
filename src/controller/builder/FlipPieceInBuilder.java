package controller.builder;

import model.Piece;
import view.PieceView;

public class FlipPieceInBuilder extends BuilderMove {
	Piece pieceChosen;
	PieceView pieceView;
	boolean axis = false;
	public FlipPieceInBuilder(Piece pieceChosen, PieceView pieceView, boolean axis){
		this.pieceChosen = pieceChosen;
		this.pieceView = pieceView;
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
