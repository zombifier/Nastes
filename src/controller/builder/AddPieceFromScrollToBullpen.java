package controller.builder;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

import model.Bullpen;
import model.Piece;
import view.BullpenView;
import view.PieceView;

/**
 * Move class for adding piece from scroll pane to bullpen.
 * @author Team Nastes
 *
 */
public class AddPieceFromScrollToBullpen extends BuilderMove {
	Piece pieceChosen;
	PieceView pieceView;
	Bullpen bullpen;
	BullpenView bullpenView;
	PieceView copyPieceView;
	/**
	 * AddPieceFromScrollToBullpen constructor
	 * @param pieceChosen
	 * @param pieceView
	 * @param bullpen
	 * @param bullpenView
	 */
	public AddPieceFromScrollToBullpen(Piece pieceChosen, PieceView pieceView, Bullpen bullpen, BullpenView bullpenView){
		this.pieceChosen = pieceChosen;
		this.pieceView = pieceView;
		this.bullpen = bullpen;
		this.bullpenView = bullpenView;
		
	}
	/**
	 * function will add piece to bullpen (entities)
	 * @return if the move successful or not
	 */
	public boolean doMove() {
		if (this.valid()){	
			this.bullpen.addPiece(this.pieceChosen);
			copyPieceView = new PieceView(this.pieceView.getPiece());
			this.bullpenView.drawPieceView(copyPieceView);
			return true;
		} else {
			return false;
		}
		
		
	}

	/**
	 * function will undo add piece to bullpen, which would just remove the piece
	 * @return true
	 */
	public boolean undo() {
		this.bullpen.removePiece(this.pieceChosen);
		this.copyPieceView.getParent().remove(copyPieceView);
		this.bullpenView.repaint();
		
		return true;
	}

	/**
	 * this function check if the move is valid or not
	 * @return if the move is valid or not
	 */
	public boolean valid() {
		if (this.pieceChosen != null){
			return true;
		} else {
			return false;
		}
		
	}
}
