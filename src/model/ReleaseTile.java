package model;

public class ReleaseTile extends Tile {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2349359474387386315L;
	
	
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
	
	public Tile copy(){
		return new ReleaseTile(this.isValid, this.releaseNumber, this.color);
	}
}
