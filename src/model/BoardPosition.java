package model;

/**
 * Board position is the position of a given object in the board.
 * Board position is measured by a object's top left corner.  
 *  	
 * 		
 * 
 * 
 * 
 *
 */

public class BoardPosition implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6646980816657643296L;
	
	
	int x;
	int y;
	/**
	 * Constructor for BoardPosition. Sets x and y position. 
	 * @param x The x position
	 * @param y The y position 
	 */
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
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof BoardPosition){
			BoardPosition another = (BoardPosition)obj;
			if(another.x == this.x && another.y == this.y)
				return true;
		}
		return false;
	}
	
}
