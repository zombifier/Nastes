package model;

public class TileLightning extends Tile {
	boolean isColored;
	
	public TileLightning(boolean isValid) {
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
