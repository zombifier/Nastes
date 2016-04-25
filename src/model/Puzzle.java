package model;

public class Puzzle extends Level{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6410571738242909273L;
	
	
	int moveLimit;
	int moveElapsed;
	int tilesUncovered;
	
	public Puzzle (int moveLimit) {
		super();
		this.moveLimit = moveLimit;
		this.moveElapsed = 0;
		this.tilesUncovered = board.validTiles();
	}
	
	public Puzzle (Board board, Bullpen bullpen, int moveLimit) {
		super(board, bullpen);
		this.moveLimit = moveLimit;
		this.moveElapsed = 0;
		this.tilesUncovered = board.validTiles();
	}
	
	public boolean hasWon() {
		return (tilesUncovered == 0);
	}
	
	public String name() { return "Puzzle"; }
	
	public String getLimit() { return Integer.toString(moveLimit - moveElapsed); }
	
	public Level copy(){
		return new Puzzle(board.copy(), bullpen.copy(), moveLimit);
	}
}