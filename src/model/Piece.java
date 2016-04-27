package model;

/**
 * Class Piece
 * 
 * @param pieceID	The identifier for the piece within the level
 * @param type		THe type of the piece. Refering to the accual shape of this kind of piece.
 * 					there can be more than one piece in a level with the same type. 
 *
 *		The creation of a piece uses the array below. There is a double array / multi array
 * with all the 36 different types of pieces. When someone wants to create a piece they only use
 * the ID and type. Using the type it will fetch the the position of the squares within the array. 
 *
 */

public class Piece implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3744611337874218968L;
	
	
	BoardPosition boardPosition;
	int pieceID;
	int type;
	int orientation;
	Square[] squares = new Square[6];
	public final static PiecePosition[][] multi = new PiecePosition[][]{
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
	
	
	public Piece(int pieceID, int type) {
		this.pieceID = pieceID;
		this.type = type;
		for (int i=0;i<=5;i++){
			this.squares[i] = new Square(multi[type][i]);
		}
	}
	
	/**
	 * Return the squares belonging to the piece
	 * @return Squares in the piece
	 */
	public Square[] getSquares() {
		return squares;
	}
	
	/**
	 * Rotate the coordinate of the piece
	 * @param direction true for clockwise; otherwise, counterclockwise
	 */
	public void rotate(boolean direction) { // true for clockwise, false for counterclockwise
		for(Square sq:squares){
			sq.rotate(direction);
		}
	}

	/**
	 * Flip the coordinate of the piece
	 * @param direction true for horizontal; otherwise, vertical
	 */
	public void flip(boolean direction) { // true for horizontal, false for vertical
		for(Square sq:squares){
			sq.flip(direction);
		}
	}
	
	/**
	 * return the copy of the piece
	 * @return Copied piece
	 */
	public Piece copy(){
		return new Piece(this.pieceID, this.type);
	}
	
}
