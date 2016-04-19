package model;

public class TileRelease extends Tile {
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
	
	public boolean valid() {
		return (isValid && !isCovered);
	}
	
}
