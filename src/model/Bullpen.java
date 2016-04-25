package model;

import java.util.ArrayList;

/**
 * 
 * @param pieces 	The pieces that are in the bullpen 
 * 
 * Bullpen is where the piece will start at the start of any given level. 
 *
 */

public class Bullpen implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2259938307173061386L;
	
	
	ArrayList<Piece> pieces;
	
	public Bullpen(){
		this(new ArrayList<Piece>());
	}
	
	public Bullpen(ArrayList<Piece> pieces){
		this.pieces = pieces;
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
}
