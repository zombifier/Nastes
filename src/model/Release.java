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
		super();
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
		return false;
	}
	
	public String name() { return "Release"; }
	
	public String getLimit() { return ""; }
	
	public Level copy(){
		return new Release(board.copy(), bullpen.copy());
	}
}
