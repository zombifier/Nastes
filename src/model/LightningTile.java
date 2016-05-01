package model;

public class LightningTile extends Tile {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4433633684814536552L;
	
	
	boolean isColored;
	
	public LightningTile(boolean isValid, boolean isHint) {
		super(isValid, isHint);
		isColored = false;
	}
	
	public void addSquare() {
		isColored = true;
	}
	
	public boolean playable() {
		return (isValid);
	}
	
	public Tile copy(){
		return new LightningTile(this.isValid, this.isHint);
	}
	
	public int levelType(){
		return 1;
	}

	public boolean isFilled(){
		return isValid && isColored;
	}
}
