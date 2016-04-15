package model;

public class Square {
	PiecePosition piecePosition;
	boolean isCoverATile;
	
	public Square(PiecePosition piecePosition) {
		this.piecePosition = piecePosition;
		this.isCoverATile = false;
	}
	
	public int getX() {
		return piecePosition.getX();
	}
	
	public int getY() {
		return piecePosition.getY();
	}
	
	public void rotate(boolean direction) { // true for clockwise, false for counterclockwise
		piecePosition.rotate(direction);
	}
	
	public void flip(boolean direction) {
		piecePosition.flip(direction);
	}
}
