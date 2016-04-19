package model;

public class TilePuzzle extends Tile {
	boolean isCovered;
	
	public TilePuzzle(boolean isValid) {
		super(isValid);
		isCovered = false;
	}
	
	public void addSquare() {
		isCovered = true;
	}
	
	public boolean valid() {
		return (isValid && !isCovered);
	}
	
}
