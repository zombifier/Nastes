package model;

public class Lightning extends Level{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6541820812029948658L;
	
	
	
	int timeLimit;
	int timeElapsed;
	int tilesUncolored;
	
	public Lightning() {
		super(1);
		this.timeLimit = 60;
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
		if ((tilesUncolored == 0)||(timeElapsed == timeLimit)){
			return true;
		} else {
			return false;
		}
	}
	
	public String name() { return "Lightning"; }

	public void setLimit(int limit) { timeLimit = limit; }
	
	public String getLimit() { return Integer.toString(timeLimit - timeElapsed); }

	public String getUnit() { return "Seconds"; }

	public Level copy(){
		return new Lightning(board.copy(), bullpen.copy(), this.timeLimit);
	}
	
	public int levelType(){
		return 1;
	}
	
	public int resultStar(){
		/*if(board.numRemainTile() <= 0) return 3;
		else if(board.numRemainTile() <= 6) return 2;
		else if(board.numRemainTile() <= 12) return 1;
		return 0;*/
		return 0;
	}
	
	public void limitDecrease() {
		timeLimit = timeLimit-1;
	}
	
}
