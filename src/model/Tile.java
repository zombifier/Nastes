package model;

abstract public class Tile implements java.io.Serializable {
	/**
	 * Tile class for Kabasuji.
	 * Each tile knows if it is a valid place for a piece, and if it contains a Square.
	 * Is extended by specific tile types for each level type.
	 */
	private static final long serialVersionUID = -2360380133845519730L;
	
	
	boolean isValid;
	boolean isHint;
	boolean hasSquare;
	abstract int levelType();
	
	public Tile(boolean isValid, boolean isHint) {
		this.isValid = isValid;
		this.isHint = isHint;
	}
	
	/** 
	 * Return validity of the tile if the tile is added to the level or not.
	 * @return true if it is valid; otherwise, false.
	 */
	public boolean isValid() { return isValid; }
	
	/**
	 * Return playability of the tile if piece can be place on the tile.
	 * @return true if it is playable; otherwise, false.
	 */
	abstract public boolean playable(); // whether you can add a square to this tile
	
	/**
	 * Add the square to the tile, changing the state of the tile.
	 */
	abstract public void addSquare();
	
	/**
	 * Check if any Square has been placed on the tile.
	 * @return true if the tile is valid and filled by Square already; otherwise, false.
	 */
	abstract public boolean isFilled();
	/**
	 * Remove the square to the tile, changing the state of the tile.
	 */
	public void removeSquare(){
		// Do nothing
	}

	/**
	 * return the copy of the tile
	 * @return Copied tile
	 */
	public Tile copy(){
		System.out.println("Errors occur");
		return null;
	}
	
	/**
	 * Convert the validity of the tile
	 */
	public void convertValid(){
		isValid = !isValid;
	}
	
	/**
	 * return whether a hint is on this tile
	 * @return true if the tile has a hint
	 */
	public boolean isHint() {
		return isHint;
	}
	
	/**
	 * Convert the hint status of the tile
	 */
	public void convertHint(){
		isHint = !isHint;
	}
}