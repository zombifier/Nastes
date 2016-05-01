package controller.builder;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

import model.Bullpen;
import model.Piece;
import view.BullpenView;
import view.PieceView;

public class AddPieceFromScrollToBullpen extends BuilderMove {
	Piece pieceChosen;
	PieceView pieceView;
	Bullpen bullpen;
	BullpenView bullpenView;
	PieceView copyPieceView;
	public AddPieceFromScrollToBullpen(Piece pieceChosen, PieceView pieceView, Bullpen bullpen, BullpenView bullpenView){
		this.pieceChosen = pieceChosen;
		this.pieceView = pieceView;
		this.bullpen = bullpen;
		this.bullpenView = bullpenView;
		
	}
	
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

	
	public boolean undo() {
		this.bullpen.removePiece(this.pieceChosen);
		this.copyPieceView.getParent().remove(copyPieceView);
		this.bullpenView.repaint();
		
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
