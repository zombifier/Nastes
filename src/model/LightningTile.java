package model;

public class LightningTile extends Tile {
	boolean isColored;
	
	public LightningTile(boolean isValid) {
		super(isValid);
		isColored = false;
	}
	
	public void addSquare() {
		isColored = true;
	}
	
	public boolean valid() {
		return (isValid && !isColored);
	}
}
