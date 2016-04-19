package model;

public class Puzzle extends Level{
	int moveLimit;
	int moveElapsed;
	int tilesUncovered;
	
	public Puzzle (int moveLimit) {
		super();
		this.moveLimit = moveLimit;
		this.moveElapsed = 0;
		this.tilesUncovered = board.validTiles();
	}
	
	public boolean hasWon() {
		return (tilesUncovered == 0);
	}
	
	public String name() { return "Puzzle"; }
	
	public String getLimit() { return Integer.toString(moveLimit - moveElapsed); }
	
}
