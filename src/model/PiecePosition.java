package model;

public class PiecePosition implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5144906033202040591L;
	
	
	int x;
	int y;
	
	public PiecePosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Return vertically coordinate position of the square related to the piece considered as y in the view.
	 * @return vertically coordinate position
	 */
	public int getX() {
		return x;
	}

	/**
	 * Return horizontally coordinate position of the square related to the piece considered as x in the view.
	 * @return horizontally coordinate position
	 */
	public int getY() {
		return y;
	}

	/**
	 * Rotate the coordinate of the piece
	 * @param direction true for clockwise; otherwise, counterclockwise
	 */
	public void rotate(boolean direction) { // true for clockwise, false for counterclockwise
		int temp = x;
		x = y;
		y = temp;
		if (direction) x *= -1;
		else y *= -1;
	}

	/**
	 * Flip the coordinate of the piece
	 * @param direction true for horizontal; otherwise, vertical
	 */
	public void flip(boolean direction) { // true for horizontal, false for vertical
		if (direction) x *= -1;
		else y *= -1;
	}
}
