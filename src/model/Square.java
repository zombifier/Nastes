package model;

public class Square {
	PiecePosition piecePosition;
	boolean isCoverATile;
	
	public Square(PiecePosition piecePosition) {
		this.piecePosition = piecePosition;
		this.isCoverATile = false;
	}


	/**
	 * Return vertically coordinate position of the square related to the piece considered as y in the view.
	 * @return vertically coordinate position
	 */
	public int getX() {
		return piecePosition.getX();
	}

	/**
	 * Return horizontally coordinate position of the square related to the piece considered as x in the view.
	 * @return horizontally coordinate position
	 */
	public int getY() {
		return piecePosition.getY();
	}

	/**
	 * Rotate the coordinate of the piece
	 * @param direction true for clockwise; otherwise, counterclockwise
	 */
	public void rotate(boolean direction) { // true for clockwise, false for counterclockwise
		piecePosition.rotate(direction);
	}

	/**
	 * Flip the coordinate of the piece
	 * @param direction true for horizontal; otherwise, vertical
	 */
	public void flip(boolean direction) {
		piecePosition.flip(direction);
	}
}
