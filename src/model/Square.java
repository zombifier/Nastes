package model;

public class Square {
	PiecePosition piecePosition;
	boolean isCoverATile;
	
	public Square(PiecePosition piecePosition) {
		this.piecePosition = piecePosition;
		this.isCoverATile = false;
	}
}
