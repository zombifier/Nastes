package model;

public class Lightning extends Level{
	int timeLimit;
	int timeElapsed;
	int tilesUncolored;
	
	public Lightning(int timeLimit) {
		super();
		this.timeLimit = timeLimit;
		this.timeElapsed = 0;
		this.tilesUncolored = board.validTiles();
	}
	
	public boolean hasWon() {
		return tilesUncolored == 0;
	}
	
	public String name() { return "Lightning"; }
	
	public String getLimit() { return Integer.toString(timeLimit - timeElapsed); }

	
}
