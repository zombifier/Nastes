package model;

/**
 * PiecePosition of Square
 * @author Team Nastes
 *
 */
public class PiecePosition implements java.io.Serializable {
	/**
	 * set serialVersionUID
	 */
	private static final long serialVersionUID = -5144906033202040591L;
	
	
	int x;
	int y;
	
	/**
	 * Constructor for PiecePosition. Sets x and y position. 
	 * @param x
	 * @param y
	 */
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
		if (!direction) {
			x *= -1;
//			x = x + 5;
		}else{ 
			y *= -1;
//			y = y + 5;
		}
	}

	/**
	 * Flip the coordinate of the piece
	 * @param direction true for horizontal; otherwise, vertical
	 */
	public void flip(boolean direction) { // true for horizontal, false for vertical
		if (direction) {
			x *= -1;
//			x = x + 5;
		}
		else {
			y *= -1;
//			y = y + 5;
		}
	}
	
	/**
	 * Translate the PiecePosition to the specific location.
	 * @param x X-coordination
	 * @param y Y-coordination
	 */
	public void translate(int x, int y){
		this.x -= x;
		this.y -= y;
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

	/**
	 * return a new PiecePosition that is the same as the original
	 * @return PiecePosition  
	 */
	public PiecePosition copy() {
		return new PiecePosition(this.x, this.y);
	}
}
