package model;

public class Release extends Level{
	/**
	 * 
	 */
	private static final long serialVersionUID = 822020599043953773L;
	
	
	int redNumbersUncovered;
	int yellowNumbersUncovered;
	int greenNumbersUncovered;
	
	public Release() {
		super(2);
		this.redNumbersUncovered = 6;
		this.yellowNumbersUncovered = 6;
		this.greenNumbersUncovered = 6;
	}
	
	public Release(Board board, Bullpen bullpen) {
		super(board, bullpen);
		this.redNumbersUncovered = 6;
		this.yellowNumbersUncovered = 6;
		this.greenNumbersUncovered = 6;
	}
	
	public boolean hasWon() {
		if ((this.redNumbersUncovered==0)&&(this.yellowNumbersUncovered==0)&&(this.greenNumbersUncovered==0)){
			return true;
		}else{
		return false;
		}
	}
	
	public String name() { return "Release"; }

	public void setLimit(int limit) { /* cannot change by setting */ }
	
	public String getLimit() {
		int i = 0;
		if (redNumbersUncovered == 0) i++;
		if (yellowNumbersUncovered == 0) i++;
		if (greenNumbersUncovered == 0) i++;
		return Integer.toString(i);
	}

	public String getUnit() { return "Sets"; }
	
	public Level copy(){
		return new Release(board.copy(), bullpen.copy());
	}
	
	public int levelType(){
		return 2;
	}
	
	public int resultStar(){
		// subject to be changed
		int numStar = 0;
		if (this.redNumbersUncovered == 0){
			numStar = numStar + 1;
		}
		if (this.yellowNumbersUncovered == 0){
			numStar = numStar + 1;
		}
		if (this.greenNumbersUncovered == 0){
			numStar = numStar + 1;
		}
		return numStar;
	}
	
	public void limitDecrease(){
		ReleaseTile t;
		for (int i=0;i <12;i++)
			for (int j=0;i <12;i++) {
				t = (ReleaseTile) board.getTile(i, j);
				if (t.isFilled()) {
					switch (t.getColor()) {
					case (1): redNumbersUncovered--; break;
					case (2): yellowNumbersUncovered--; break;
					case (3): greenNumbersUncovered--; break;
					}
				}
			}
	}
}
