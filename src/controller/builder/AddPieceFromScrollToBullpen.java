package controller.builder;

import java.awt.Dimension;
import java.util.Random;

import model.Bullpen;
import model.Piece;
import view.PieceView;

public class AddPieceFromScrollToBullpen extends BuilderMove {
	Piece pieceChosen;
	Bullpen bullpen;
	
	public AddPieceFromScrollToBullpen(Piece pieceChosen,Bullpen bullpen){
		this.pieceChosen = pieceChosen;
		this.bullpen = bullpen;
		
	}
	
	public boolean doMove() {
		if (this.valid()){	
			this.bullpen.addPiece(this.pieceChosen);
			return true;
		} else {
			return false;
		}
		
		
	}

	
	public boolean undo() {
		this.bullpen.removePiece(this.pieceChosen);
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
