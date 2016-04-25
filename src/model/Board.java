package model;

import java.util.*;

/**
 * @param tiles
 * 
 * The Board class. 
 * A board is made of a double array of tiles. 12 x 12. Even if a tile is not "active" or 
 * being used, it is still part of the board. 
 *
 */

public class Board implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3839076323758829272L;
	
	
	Tile[][] tiles;
	HashMap<Piece,BoardPosition> pieces;
	public Board(){
		this(new Tile[12][12]);
	}
	
	public Board(Tile[][] tiles){
		this.tiles=tiles;
	}
	
	/**
	 * Count the valid tiles on the board.
	 * @return the number of valid tiles
	 */
	public int validTiles() {
		int count = 0;
		for (int i = 0; i < 12; i++)
			for (int j = 0; i < 12; i++) {
				if (tiles[i][j] != null && tiles[i][j].isValid()) count++;
			}
		return count;
	}
	
	/**
	 * Check whether it is legal to move the piece to the board at the specific position.
	 * @param piece Piece considered to move to the board
	 * @param position Position piece goes
	 * @return true if it is legal; otherwise, false.
	 */
	public boolean isLegal(Piece piece, BoardPosition position) {
		boolean legal = true;
		int xPos;
		int yPos;
		for (Square s:piece.getSquares()) {
			xPos = position.getX() + s.getX();
			yPos = position.getY() + s.getY();
			// check if the square's position is out of bounds or is not valid
			if ((xPos < 0) || (xPos > 11) || (yPos < 0) || (yPos > 11) || (!tiles[xPos][yPos].playable())) {
				legal = false;
				break;
			}
		}
		return legal;
	}
	
	/**
	 * Add piece to the board if it is legal; otherwise, the board stays the same.
	 * @param piece Piece added
	 * @param position Position piece goes
	 * @return true if it is legal; otherwise, false.
	 */
	public boolean addPiece(Piece piece, BoardPosition position) {
		int xPos;
		int yPos;
		if (isLegal(piece, position)) { // add the piece and notify the tiles that a square is added on top
			pieces.put(piece, position);
			for (Square s:piece.getSquares()) {
				xPos = position.getX() + s.getX();
				yPos = position.getY() + s.getY();
				tiles[xPos][yPos].addSquare();
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Remove piece from the board if there is the piece.
	 * @param piece Piece removed
	 * @return the removed piece if it is regal; otherwise, null.
	 */
	public Piece removePiece(Piece piece) {
		int xPos, yPos;

		BoardPosition position = pieces.remove(piece);
		if (position!=null) {
			for (Square s:piece.getSquares()) {
				xPos = position.getX() + s.getX();
				yPos = position.getY() + s.getY();
				tiles[xPos][yPos].removeSquare();
			}
			return piece;
		}
		else return null;
	}
	

	/**
	 * return the copy of the board
	 * @return Copied board
	 */
	public Board copy(){
		Tile[][] tiles;
		tiles = new Tile[12][12];
		for(int i = 0; i < 12; i++)
			for(int j = 0; j < 12; j++)
				tiles[i][j] = this.tiles[i][j].copy();
		
		return new Board(tiles);
	}
}
