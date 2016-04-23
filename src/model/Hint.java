package model;

/**
 * 
 * @param piece 	 		This is the piece that the hint is helping you place. 
 * @param boardPosition		This is the location on the board that the piece goes
 * 
 * 		The hint class. Nothing special. Hints work by placing one piece for the player 
 * when the game beings 
 *
 */

public class Hint {
	Piece piece;
	BoardPosition boardPosition;
	
	public Hint(Piece piece, BoardPosition boardPosition) {
		this.piece = piece;
		this.boardPosition = boardPosition;
	}
}
