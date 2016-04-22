package model;

public class Piece {
	BoardPosition boardPosition;
	int pieceID;
	int type;
	int orientation;
	Square[] squares;
	
	public Piece(int pieceID, int type, Square[] squares) {
		this.pieceID = pieceID;
		this.type = type;
		
		this.squares = squares;
	}
	
	public Square[] getSquares() {
		return squares;
	}
	
	public void rotate(boolean direction) { // true for clockwise, false for counterclockwise
		for(Square sq:squares){
			sq.rotate(direction);
		}
	}
	
	public void flip(boolean direction) { // true for horizontal, false for vertical
		for(Square sq:squares){
			sq.flip(direction);
		}
	}
}
