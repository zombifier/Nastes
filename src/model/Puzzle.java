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
		super(0);
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
		return (tilesUncovered == 0) ;
	}
	
	public String name() { return "Puzzle"; }

	public void setLimit(int limit) { moveLimit = limit; }
	
	public String getLimit() { return Integer.toString(moveLimit - moveElapsed); }

	public String getUnit() { return "Moves"; }
	
	public Level copy(){
		return new Puzzle(board.copy(), bullpen.copy(), moveLimit);
	}
	
	public int levelType(){
		return 0;
	}
	
	public int resultStar(){
		if(bullpen.numRemainPiece() <= 0) return 3;
		else if(bullpen.numRemainPiece() <= 1) return 2;
		else if(bullpen.numRemainPiece() <= 2) return 1;
		return 0;
	}
	
	public void limitDecrease() {
		moveElapsed = moveElapsed+1;
	}
	
}