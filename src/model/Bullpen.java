package model;

/**
 * 
 * @param pieces 	The pieces that are in the bullpen 
 * 
 * Bullpen is where the piece will start at the start of any given level. 
 *
 */

public class Bullpen {
	Piece[] pieces;
	
	public Bullpen(){
		this(null);
	}
	
	public Bullpen(Piece pieces[]){
		this.pieces = pieces;
	}
	
}
