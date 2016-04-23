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
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}
