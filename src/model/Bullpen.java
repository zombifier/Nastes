package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Bullpen is where the piece will start at the start of any given level. 
 * 
 * @param pieces 	The pieces that are in the bullpen 
 * 
 * 
 *
 */

public class Bullpen implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2259938307173061386L;
	
	
	ArrayList<Piece> pieces;
	
	/**
	 * Constructor for Bullpen if bullpen doesn't have any attribute
	 */
	public Bullpen(){
		pieces = new ArrayList<Piece>();
	}
	
	/**
	 * Second Constructor for Bullpen if the bullpen got load from the game storage
	 * @param pieces
	 */
	public Bullpen(ArrayList<Piece> pieces){
		this.pieces = pieces;
		
	}
	
	/**
	 * getter method for pieces
	 * @return ArrayList<piece>
	 */
	public ArrayList<Piece> getPieces(){
		return pieces;
	}

	/**
	 * return the copy of the bullpen
	 * @return Copied bullpen
	 */
	public Bullpen copy(){
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		for(Piece piece: this.pieces)
			pieces.add(piece.copy());
		return new Bullpen(pieces);
		
	}
	/**
	 * add a piece into bullpen, use in builder
	 * @param piece
	 * @return void
	 */
	public void addPiece(Piece piece){
		this.pieces.add(piece);
	}

	/**
	 * remove a piece from the bullpen, use in builder
	 * @param pieceChosen
	 * @return void
	 */
	public void removePiece(Piece pieceChosen) {
		this.pieces.remove(pieceChosen);
		
	}

	/**
	 * return the value of piece remaining on the bullpen
	 * @return piece.size()
	 */
	public int numRemainPiece() {
		// TODO Auto-generated method stub
		return pieces.size();
	}
}
