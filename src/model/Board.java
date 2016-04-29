package model;

import java.awt.Point;
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
	
	
	Tile tiles[][] = new Tile[12][12];
	HashMap<Piece,BoardPosition> pieces;
	
	public Board(int levelType){
		pieces = new HashMap<Piece, BoardPosition>();
		tiles = new Tile[12][12];
		for (int i=0;i<=11;i++){
			for (int j=0;j<=11;j++){
				if (levelType == 0){
					tiles[i][j] = new PuzzleTile(false);
				} else if (levelType == 1){
					tiles[i][j] = new LightningTile(false);
				} else if (levelType == 2){
					tiles[i][j] = new ReleaseTile(false,0,0);
				}
			}
		}
			
		
	}
	
	public Board(Tile[][] tiles){
		pieces = new HashMap<Piece, BoardPosition>();
		this.tiles=tiles;
	}
	
	/**
	 * Count the valid tiles on the board.
	 * @return the number of valid tiles
	 */
	public int validTiles() {
		int count = 0;
		for (int i = 0; i < 12; i++)
			for (int j = 0; j < 12; j++) {
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
			for(int j = 0; j < 12; j++){
				if(this.tiles[i][j] != null){
					tiles[i][j] = this.tiles[i][j].copy();
				}
			}
		return new Board(tiles);
	}
	
	/**
	 * Return the specific tile of the board
	 * @param x Row
	 * @param y Column
	 * @return Tile at the row x and column y
	 */
	public Tile getTile(int x, int y){
		return tiles[x][y];
	}
	/**
	 * Return level type of the level
	 * @return an integer that represent the level type
	 */
	public int getLevelType(){
		
		return this.tiles[0][0].levelType();
	}
	/**
	 * Return the array of tile
	 * @return an array of tile
	 */
	public Tile[][] getArrayTile(){
		return this.tiles;
	}

	public int numRemainTile() {
		int number = 0;
		for(int i = 0; i < 12; i++)
			for(int j = 0; j < 12; j++)
				if(tiles[i][j] != null && tiles[i][j].playable())
					number++;
		return number;
	}

}
