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
	
	public void removeSquare() {
		isCovered = false;
	}
	
	public boolean playable() {
		return (isValid && !isCovered);
	}
	
}
