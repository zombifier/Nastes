package controller.builder;

import model.Bullpen;
import model.Level;
import model.Piece;
import view.BuilderApplication;

public class SelectPieceFromBullpen {
	Level level;
	Bullpen bullpen;
	Piece pieceChosen;
	
	public SelectPieceFromBullpen(Level level,Bullpen bullpen,Piece pieceChosen){
		this.level = level;
		this.bullpen = bullpen;
		this.pieceChosen = pieceChosen;
		
	}

	public boolean doMove() {
		if (this.valid()){
			this.bullpen.removePiece(this.pieceChosen);
			this.level.holdPiece(this.pieceChosen);
			return true;
		} else {
			return false;
		}
		
		
	}

	
	public boolean undo() {
		this.bullpen.addPiece(this.pieceChosen);
		this.level.releasePiece();
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
