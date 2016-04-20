package model;

public class Bullpen {
	Piece[] pieces;
	
	public Bullpen(){
		this(null);
	}
	
	public Bullpen(Piece pieces[]){
		this.pieces = pieces;
	}
	
}
