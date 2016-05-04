package model;

/**
 * Puzzle level class
 * @author Team Nastes
 *
 */
public class Puzzle extends Level{
	/**
	 * set serialVersionUID
	 */
	private static final long serialVersionUID = -6410571738242909273L;
	
	
	int moveLimit;
	int moveElapsed;
	int tilesUncovered;
	
	/**
	 * Constructor for Puzzle level with input of moveLimit
	 * @param moveLimit
	 */
	public Puzzle (int moveLimit) {
		super(0);
		this.moveLimit = moveLimit;
		this.moveElapsed = 0;
		this.tilesUncovered = board.validTiles();
	}
	
	/**
	 * Second Constructor for Puzzle when load from the game storage.
	 * @param board
	 * @param bullpen
	 * @param moveLimit
	 */
	public Puzzle (Board board, Bullpen bullpen, int moveLimit) {
		super(board, bullpen);
		this.moveLimit = moveLimit;
		this.moveElapsed = 0;
		this.tilesUncovered = board.validTiles();
	}
	
	public boolean hasWon() {
		if ((pieceBeingDragged == null && bullpen.numRemainPiece() <= 0) || (moveElapsed == moveLimit)){
			return true;
		} else {return false;}
	}
	
	public String name() { return "Puzzle"; }

	public void setLimit(int limit) { moveLimit = limit; }
	
	public String getLimit() { return Integer.toString(moveLimit - moveElapsed); }

	public String getUnit() { return "Moves"; }
	
	public Level copy(){
		Level level = new Puzzle(board.copy(), bullpen.copy(), moveLimit);
		level.copyCondition((Level)this);
		return level;
	}
	
	public int levelType(){
		return 0;
	}
	
	public int resultStar(){
		/*if(this.tilesUncovered <= 0) return 3;
		else if(this.tilesUncovered <= 6) return 2;
		else if(this.tilesUncovered <= 12) return 1;
		return 0;*/
		// Should rely on pieces left in bullpen (having sent the current held piece to bullpen)
		if(bullpen.numRemainPiece() <= 0) return 3;
		else if(bullpen.numRemainPiece() <= 1) return 2;
		else if(bullpen.numRemainPiece() <= 2) return 1;
		return 0;
	}
	
	public void limitDecrease() {
		moveElapsed = moveElapsed + 1;
	}
	
}