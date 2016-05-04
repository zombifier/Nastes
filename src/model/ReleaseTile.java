package model;

/**
 * ReleaseTile class. 
 * @author Team Nastes
 *
 */
public class ReleaseTile extends Tile {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2349359474387386315L;
	
	
	int releaseNumber; // Valid range: 1-6
	int color; // Valid range: 1-3
	boolean isCovered;
	
	/**
	 * Constructor for ReleaseTile class. Sets releaseNumber, color and set isCovered to be false.
	 * @param isValid
	 * @param isHint
	 * @param releaseNumber
	 * @param color
	 */
	public ReleaseTile(boolean isValid, boolean isHint, int releaseNumber, int color) {
		super(isValid, isHint);
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
		return new ReleaseTile(this.isValid, this.isHint, this.releaseNumber, this.color);
	}
	
	public int levelType(){
		return 2;
	}
	
	public boolean isFilled(){
		return isValid && isCovered;
	}
	
	/**
	 * Return number on tile.
	 * @return one of number in range 1 to 6 if there is a number; otherwise, zero
	 */
	public int getNumber(){
		return releaseNumber;
	}
	
	/**
	 * Return kind of color.
	 * @return one of number in range 1 to 3 if there is a number; otherwise, zero
	 */
	public int getColor(){
		return color;
	}
	/**
	 * 
	 * @param num
	 * @param color
	 */
	public void setNumAndColor(int num, int color){
		this.releaseNumber = num;
		this.color = color;
	}
}
