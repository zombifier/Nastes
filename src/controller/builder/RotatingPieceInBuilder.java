package controller.builder;

import model.Bullpen;
import model.Level;
import model.Piece;
import view.PieceView;

/**
 * This move class is for rotating piece in builder application.
 * @author Team Nastes
 *
 */
public class RotatingPieceInBuilder extends BuilderMove {
	Piece pieceChosen;
	PieceView pieceView;
	boolean orientation = false;
	/**
	 * Constructor for RotatingPieceInBuilder. 
	 * Sets pieceChosen, the pieceView that it is in and its orieantation that it want to rotate.
	 * @param pieceChosen Piece
	 * @param pieceView PieceView
	 * @param orientation boolean
	 */
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
