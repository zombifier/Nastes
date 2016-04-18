package model;

public class PuzzleTile extends Tile {
	boolean isCovered;
	
	public PuzzleTile(boolean isValid) {
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
