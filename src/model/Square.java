package model;

public class Square implements java.io.Serializable {
	/**
	 *  Square class for Kabasuji.
	 *  Each square knows of its position, and if it is covering a tile.
	 */
	private static final long serialVersionUID = 419883477850643614L;
	
	PiecePosition piecePosition;
	boolean isCoverATile;
	
	public Square(PiecePosition piecePosition) {
		this.piecePosition = piecePosition;
		this.isCoverATile = false;
	}

	/**
	 * Return horizontal coordinate position of the square related to the piece considered as x in the view.
	 * @return horizontal coordinate position
	 */
	public int getX() {
		return piecePosition.getX();
	}

	/**
	 * Return vertical coordinate position of the square related to the piece considered as y in the view.
	 * @return vertical coordinate position
	 */
	public int getY() {
		return piecePosition.getY();
	}

	/**
	 * Rotate the coordinates of the piece
	 * @param direction true for clockwise; otherwise, counterclockwise
	 */
	public void rotate(boolean direction) { // true for clockwise, false for counterclockwise
		piecePosition.rotate(direction);
	}

	/**
	 * Flip the coordinates of the piece
	 * @param direction true for horizontal; otherwise, vertical
	 */
	public void flip(boolean direction) { // true for horizontal, false for vertical
		piecePosition.flip(direction);
	}
}
