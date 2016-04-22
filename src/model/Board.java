package model;

import java.util.*;

public class Board {
	Tile[][] tiles;
	HashMap<Piece,BoardPosition> pieces;
	public Board(){
		this(new Tile[12][12]);
	}
	
	public Board(Tile[][] tiles){
		this.tiles=tiles;
	}
	
	public int validTiles() {
		int count = 0;
		for (int i = 0; i < 12; i++)
			for (int j = 0; i < 12; i++) {
				if (tiles[i][j] != null && tiles[i][j].isValid()) count++;
			}
		return count;
	}
	
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
	
	
}
