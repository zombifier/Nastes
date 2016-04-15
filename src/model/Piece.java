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
}
