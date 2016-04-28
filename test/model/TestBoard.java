package model;

import junit.framework.TestCase;

public class TestBoard extends TestCase {
	
	Board board;
	
	@Override
	protected void setUp() {
		board = new Board(0); 
		// Confident
		for(int i=0;i<6;i++)
			board.tiles[0][i].convertValid();
		
	}
	
	@Override
	protected void tearDown() {
		board = null;
	}
	
	public void testPlacePiece(){
		Piece piece = new Piece(0, 0);
		
		assertTrue(board.addPiece(piece, new BoardPosition(0, 0)));
		assertFalse(board.addPiece(piece, new BoardPosition(0, 0)));
	}
}
