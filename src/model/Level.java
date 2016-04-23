package model;

public abstract class Level {
	Board board;
	Bullpen bullpen;
	Piece pieceBeingDragged;
	int starEarned;
	boolean isUnlocked;
	int levelNum;
	Hint hint;
	
	public Level(){
		board=new Board();
		bullpen=new Bullpen();
		pieceBeingDragged=null;
	}

	public Level(Board b,Bullpen p){
		board=b;
		bullpen=p;
		pieceBeingDragged=null;
	}
	
	/**
	 * Set the piece considered to be held.
	 * @param p Piece being held
	 */
	public void holdPiece(Piece p){
		pieceBeingDragged=p;
	}
	
	/**
	 * Release the piece currently held and return it.
	 * @return Piece if there is piece currently held; otherwise null.
	 */
	public Piece releasePiece(){
		Piece p=pieceBeingDragged;
		pieceBeingDragged=null;
		return p;
	}
	
	/**
	 * Decide whether the current state of level is finished or not.
	 * @return true if the level has finished; otherwise false.
	 */
	abstract public boolean hasWon();
	
	/**
	 * Return the level name (type).
	 * @return Name of the type of level
	 */
	abstract public String name();
	
	/**
	 * Get string which contains the limit used for the view.
	 * @return String of limit
	 */
	abstract public String getLimit();
	
	/**
	 * Get string which contains the level number used for the view.
	 * @return String of stage number
	 */
	public String getLevelNum() {
		return "#"+Integer.toString(levelNum);
	}
	
	/**
	 * return the board of the level.
	 * @return Board of the level
	 */
	public Board getBoard(){
		return board;
	}
	
	/**
	 * return the bullpen of the level.
	 * @return Bullpen of the level
	 */
	public Bullpen getBullpen(){
		return bullpen;
	}
}
