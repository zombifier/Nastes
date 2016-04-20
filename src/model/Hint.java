package model;

public class Hint {
	Piece piece;
	BoardPosition boardPosition;
	
	public Hint(Piece piece, BoardPosition boardPosition) {
		this.piece = piece;
		this.boardPosition = boardPosition;
	}
}
