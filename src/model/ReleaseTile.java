package model;

public class ReleaseTile extends Tile {
	int releaseNumber;
	int color;
	boolean isCovered;
	
	public ReleaseTile(boolean isValid, int releaseNumber, int color) {
		super(isValid);
		this.releaseNumber = releaseNumber;
		this.color = color;
		this.isCovered = false;
	}
	
	public void addSquare() {
		isCovered = true;
	}
	
	public boolean playable() {
		return (isValid && !isCovered);
	}
	
}
