package controller.builder;

import model.Piece;
import view.PieceView;

/**
 * This class is for flipping piece in builder appplication.
 * @author Team Nastes
 *
 */
public class FlipPieceInBuilder extends BuilderMove {
	Piece pieceChosen;
	PieceView pieceView;
	boolean axis = false;
	/**
	 * Constructors for FlipPieceInBuilder. Sets pieceChosen, pieceView of that and axis that the player want to flip
	 * @param pieceChosen
	 * @param pieceView
	 * @param axis
	 */
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
