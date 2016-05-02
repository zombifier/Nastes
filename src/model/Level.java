package model;

import java.util.Stack;

import controller.builder.BuilderMove;

public abstract class Level implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5998873478522304717L;
	
	
	Board board;
	Bullpen bullpen;
	Piece pieceBeingDragged;
	int starEarned;
	boolean isUnlocked;
	int levelNum;
	Hint hint;
	abstract public int levelType();
	
	public Level(int type){
		board=new Board(type);
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
	 * Return piece being dragged.
	 * @return Piece if there is a piece being dragged; otherwise, null
	 */
	public Piece getPiece(){
		return pieceBeingDragged;
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
	 * Set limit for different type of level
	 * @param limit Number indicating limit for level
	 */
	abstract public void setLimit(int limit);
	
	/**
	 * Get string which contains the limit used for the view.
	 * @return String of limit
	 */
	abstract public String getLimit();
	
	/**
	 * Get string which contains the unit of limit for the view
	 * @return String of unit of limit
	 */
	abstract public String getUnit();
	
	abstract public int resultStar();
	
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
	
	/**
	 * return the copy of the level
	 * @return Copied level
	 */
	abstract public Level copy();
	
	/**
	 * Return the state of level
	 * @return true if it is unlocked; otherwise, false
	 */
	public boolean isPlayable(){
		return isUnlocked;
	}
	
	/**
	 * Return star having been earned before
	 * @return Number of star earned before
	 */
	public int getStar(){
		return starEarned;
	}
	
	/**
	 * Update the limit (or in the case of Release, the number sets filled)
	 */
	public abstract void limitDecrease();
	
}
