package model;

/**
 * 
 * @param x 	The x position
 * @param y		The y position 
 * 
 * Board position is the position of a given object in the board. 
 * Board position is measured by a object's top left corner. 
 *
 */

public class BoardPosition {
	int x;
	int y;
	public BoardPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Return vertically coordinate position considered as y in the view.
	 * @return vertically coordinate position
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Return horizontally coordinate position considered as x in the view.
	 * @return horizontally coordinate position
	 */
	public int getY() {
		return y;
	}
	
}
