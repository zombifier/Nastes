package model;

public class PuzzleTile extends Tile {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5638448705903749756L;
	
	
	boolean isCovered;
	
	public PuzzleTile(boolean isValid, boolean isHint) {
		super(isValid, isHint);
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
	
	public Tile copy(){
		return new PuzzleTile(this.isValid, this.isHint);
	}
	
	public int levelType(){
		return 0;
	}
	
	public boolean isFilled(){
		return isValid && isCovered;
	}
	
}
