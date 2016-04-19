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
	
	public boolean addPiece(Piece piece, BoardPosition position) {
		boolean legal = true;
		int xPos;
		int yPos;
		for (Square s:piece.getSquares()) {
			xPos = position.getX() + s.getX();
			yPos = position.getY() + s.getY();
			// check if the square's position is out of bounds or is not valid
			if ((xPos < 0) || (xPos > 11) || (yPos < 0) || (yPos > 11) || (!tiles[xPos][yPos].valid())) {
				legal = false;
				break;
			}
		}
		if (legal) { // add the piece and notify the tiles that a square is added on top
			pieces.put(piece, position);
			for (Square s:piece.getSquares()) {
				xPos = position.getX() + s.getX();
				yPos = position.getY() + s.getY();
				tiles[xPos][yPos].addSquare();
			}
		}
		return legal;
	}
	
	public boolean removePiece(Piece piece) {
		int xPos, yPos;

		BoardPosition position = pieces.remove(piece);
		if (position!=null) {
			for (Square s:piece.getSquares()) {
				xPos = position.getX() + s.getX();
				yPos = position.getY() + s.getY();
				tiles[xPos][yPos].removeSquare();
			}
			return true;
		}
		else return false;
	}
	
	
}
