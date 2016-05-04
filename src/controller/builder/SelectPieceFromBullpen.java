package controller.builder;

import model.Bullpen;
import model.Level;
import model.Piece;
import view.BuilderApplication;

/**
 * This move class is for Select a piece from bullpen
 * @author Team Nastes
 *
 */
public class SelectPieceFromBullpen extends BuilderMove {
	Level level;
	Bullpen bullpen;
	Piece pieceChosen;
	
	/**
	 * Constructor for SelectPieceFromBullpen. Sets level, bullpen and the chosen Piece.
	 * @param level
	 * @param bullpen
	 * @param pieceChosen
	 */
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
