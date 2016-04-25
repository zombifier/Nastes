package model;

public class Lightning extends Level{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6541820812029948658L;
	
	
	
	int timeLimit;
	int timeElapsed;
	int tilesUncolored;
	
	public Lightning(int timeLimit) {
		super();
		this.timeLimit = timeLimit;
		this.timeElapsed = 0;
		this.tilesUncolored = board.validTiles();
	}
	
	public Lightning(Board board, Bullpen bullpen, int timeLimit) {
		super(board, bullpen);
		this.timeLimit = timeLimit;
		this.timeElapsed = 0;
		this.tilesUncolored = board.validTiles();
	}
	
	public boolean hasWon() {
		return tilesUncolored == 0;
	}
	
	public String name() { return "Lightning"; }
	
	public String getLimit() { return Integer.toString(timeLimit - timeElapsed); }

	public Level copy(){
		return new Lightning(board.copy(), bullpen.copy(), this.timeLimit);
	}
	
}
