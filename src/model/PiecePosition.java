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
	 * Return horizontal coordinate position of the square related to the piece considered as x in the view.
	 * @return horizontal coordinate position
	 */
	public int getX() {
		return x;
	}

	/**
	 * Return vertical coordinate position of the square related to the piece considered as y in the view.
	 * @return vertical coordinate position
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
		if (!direction) 
			x *= -1;
		else 
			y *= -1;
	}

	/**
	 * Flip the coordinate of the piece
	 * @param direction true for horizontal; otherwise, vertical
	 */
	public void flip(boolean direction) { // true for horizontal, false for vertical
		if (direction) x *= -1;
		else y *= -1;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof PiecePosition){
			return x == ((PiecePosition)obj).x && y == ((PiecePosition)obj).y;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return "( "+x+" , "+y+" )";
	}

	public PiecePosition copy() {
		return new PiecePosition(this.x, this.y);
	}
}
