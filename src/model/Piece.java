package model;

public class Piece {
	BoardPosition boardPosition;
	int pieceID;
	int type;
	int orientation;
	Square[] squares;
	PiecePosition[][] multi = new PiecePosition[][]{
		//PIECES 1-5
		{new PiecePosition(0,0),new PiecePosition(0,1),new PiecePosition(0,2),new PiecePosition(0,3),new PiecePosition(0,4),new PiecePosition(0,5)},
		{new PiecePosition(0,0),new PiecePosition(0,1),new PiecePosition(0,2),new PiecePosition(0,3),new PiecePosition(0,4),new PiecePosition(1,0)},
		{new PiecePosition(1,0),new PiecePosition(1,1),new PiecePosition(1,2),new PiecePosition(1,3),new PiecePosition(1,4),new PiecePosition(0,3)},
		{new PiecePosition(0,0),new PiecePosition(0,1),new PiecePosition(0,2),new PiecePosition(0,3),new PiecePosition(0,4),new PiecePosition(1,2)},
		{new PiecePosition(0,1),new PiecePosition(0,2),new PiecePosition(1,1),new PiecePosition(2,0),new PiecePosition(2,1),new PiecePosition(3,0)},
		//PIECES 6-10
		{new PiecePosition(0,0),new PiecePosition(1,0),new PiecePosition(2,0),new PiecePosition(2,1),new PiecePosition(3,1),new PiecePosition(4,1)},
		{new PiecePosition(0,1),new PiecePosition(0,2),new PiecePosition(0,3),new PiecePosition(0,4),new PiecePosition(1,0),new PiecePosition(1,1)},
		{new PiecePosition(0,2),new PiecePosition(0,3),new PiecePosition(1,0),new PiecePosition(1,1),new PiecePosition(1,2),new PiecePosition(1,3)},
		{new PiecePosition(0,0),new PiecePosition(1,0),new PiecePosition(1,1),new PiecePosition(1,2),new PiecePosition(1,3),new PiecePosition(2,3)},
		{new PiecePosition(0,0),new PiecePosition(1,0),new PiecePosition(1,1),new PiecePosition(1,2),new PiecePosition(1,3),new PiecePosition(2,0)},
		//PIECES 11-15
		{new PiecePosition(0,3),new PiecePosition(1,3),new PiecePosition(2,0),new PiecePosition(2,1),new PiecePosition(2,2),new PiecePosition(2,3)},
		{new PiecePosition(0,0),new PiecePosition(0,1),new PiecePosition(0,2),new PiecePosition(1,0),new PiecePosition(1,1),new PiecePosition(1,2)},
		{new PiecePosition(0,1),new PiecePosition(0,2),new PiecePosition(0,3),new PiecePosition(1,0),new PiecePosition(1,1),new PiecePosition(2,1)},
		{new PiecePosition(0,2),new PiecePosition(0,3),new PiecePosition(1,1),new PiecePosition(1,2),new PiecePosition(2,0),new PiecePosition(2,1)},
		{new PiecePosition(0,0),new PiecePosition(0,1),new PiecePosition(0,2),new PiecePosition(0,3),new PiecePosition(1,1),new PiecePosition(1,2)},
		//PIECES 16-20
		{new PiecePosition(0,1),new PiecePosition(1,0),new PiecePosition(1,1),new PiecePosition(1,2),new PiecePosition(1,3),new PiecePosition(2,1)},
		{new PiecePosition(0,0),new PiecePosition(0,1),new PiecePosition(0,2),new PiecePosition(0,3),new PiecePosition(1,1),new PiecePosition(1,3)},
		{new PiecePosition(0,0),new PiecePosition(0,1),new PiecePosition(0,2),new PiecePosition(1,2),new PiecePosition(1,3),new PiecePosition(2,2)},
		{new PiecePosition(0,0),new PiecePosition(1,0),new PiecePosition(2,0),new PiecePosition(2,1),new PiecePosition(2,2),new PiecePosition(3,2)},
		{new PiecePosition(0,1),new PiecePosition(1,0),new PiecePosition(1,1),new PiecePosition(2,0),new PiecePosition(2,1),new PiecePosition(3,0)},
		//PIECES 21-25
		{new PiecePosition(0,1),new PiecePosition(0,2),new PiecePosition(1,1),new PiecePosition(1,2),new PiecePosition(2,0),new PiecePosition(2,1)},
		{new PiecePosition(0,1),new PiecePosition(0,2),new PiecePosition(1,0),new PiecePosition(1,1),new PiecePosition(1,2),new PiecePosition(2,1)},
		{new PiecePosition(0,0),new PiecePosition(0,3),new PiecePosition(1,0),new PiecePosition(1,1),new PiecePosition(1,2),new PiecePosition(1,3)},
		{new PiecePosition(0,1),new PiecePosition(0,2),new PiecePosition(1,0),new PiecePosition(1,1),new PiecePosition(2,1),new PiecePosition(2,2)},
		{new PiecePosition(0,0),new PiecePosition(0,1),new PiecePosition(0,2),new PiecePosition(1,0),new PiecePosition(1,2),new PiecePosition(2,0)},
		//PIECES 26-30
		{new PiecePosition(0,0),new PiecePosition(0,1),new PiecePosition(0,2),new PiecePosition(1,1),new PiecePosition(1,2),new PiecePosition(2,2)},
		{new PiecePosition(0,0),new PiecePosition(1,0),new PiecePosition(1,1),new PiecePosition(1,2),new PiecePosition(1,3),new PiecePosition(2,1)},
		{new PiecePosition(0,2),new PiecePosition(1,2),new PiecePosition(2,0),new PiecePosition(2,1),new PiecePosition(2,2),new PiecePosition(2,3)},
		{new PiecePosition(0,0),new PiecePosition(0,1),new PiecePosition(1,1),new PiecePosition(2,0),new PiecePosition(2,1),new PiecePosition(3,0)},
		{new PiecePosition(0,1),new PiecePosition(0,2),new PiecePosition(1,1),new PiecePosition(2,0),new PiecePosition(2,1),new PiecePosition(2,2)},
		//PIECES 31-35
		{new PiecePosition(0,0),new PiecePosition(0,1),new PiecePosition(0,2),new PiecePosition(1,1),new PiecePosition(1,2),new PiecePosition(2,1)},
		{new PiecePosition(0,2),new PiecePosition(0,3),new PiecePosition(1,0),new PiecePosition(1,1),new PiecePosition(1,2),new PiecePosition(2,2)},
		{new PiecePosition(0,0),new PiecePosition(0,1),new PiecePosition(1,1),new PiecePosition(2,1),new PiecePosition(2,2),new PiecePosition(3,1)},
		{new PiecePosition(0,1),new PiecePosition(1,0),new PiecePosition(1,1),new PiecePosition(2,1),new PiecePosition(2,2),new PiecePosition(3,1)},
		{new PiecePosition(0,2),new PiecePosition(1,1),new PiecePosition(1,2),new PiecePosition(2,0),new PiecePosition(2,1),new PiecePosition(3,1)}
	};
	
	
	public Piece(int pieceID, int type, Square[] squares) {
		this.pieceID = pieceID;
		this.type = type;
		
		this.squares = squares;
	}
	
	public Square[] getSquares() {
		return squares;
	}
	
	public void rotate(boolean direction) { // true for clockwise, false for counterclockwise
		for(Square sq:squares){
			sq.rotate(direction);
		}
	}
	
	public void flip(boolean direction) { // true for horizontal, false for vertical
		for(Square sq:squares){
			sq.flip(direction);
		}
	}
}
