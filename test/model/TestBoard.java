package model;

import junit.framework.TestCase;

public class TestBoard extends TestCase {
	
	Board board;
	
	@Override
	protected void setUp() {
		board = new Board(0); 
		// Confident

		
	}
	
	@Override
	protected void tearDown() {
		board = null;
	}
	
	public void testCreateLightning() {
		board = null;
		board = new Board(1);
		board = null;
	}
	
	public void testCreateRelease() {
		board = null;
		board = new Board(2);
		board = null;
	}
	
	public void testPlaceRemovePiece(){
		for(int i=0;i<6;i++)
			board.tiles[0][i].convertValid();
		Piece piece = new Piece(0, 0);
		
		assertTrue(board.addPiece(piece, new BoardPosition(0, 0)));
		assertFalse(board.addPiece(piece, new BoardPosition(0, 0)));
		
		board.removePiece(piece) ; 
		
		assertSame(board.removePiece(piece), null) ;
		assertTrue(board.addPiece(piece, new BoardPosition(0, 0)));
		
	}
	
	// Test whether or not the tiles on the board are valid 
	public void testIsValid() {
		assertFalse(board.tiles[0][0].isValid()) ;
		board.tiles[0][0].convertValid() ;
		assertTrue(board.tiles[0][0].isValid()) ;
		
	}
	
	public void testValidTiles() {
		assertEquals(0, board.validTiles());
	}
	
	public void testConvertTiles() {
		for(int i=0;i<12;i++) {
			for (int j=0;j<12;j++) {
				board.tiles[i][j].convertValid();
			}
		}
		assertEquals(144, board.validTiles()) ;
	}
	
	
	public void testGetLevelType() {
		assertEquals(board.getLevelType(), 0) ;
	}
	
	public void testCopyBoard() {
		board.copy() ;
		for(int i=0;i<12;i++) {
			for (int j=0;j<12;j++) {
				board.tiles[i][j].convertValid();
			}
		}
		assertEquals(144, board.validTiles()) ;
		
	}
	
	public void testGetArrayTile() {
		assertSame(board.getArrayTile(),board.tiles) ;
	}
	
	public void testGetTile() {
		assertFalse(board.getTile(0,0).isValid()) ;
	}
	
	public void testGetPieceAt () {
		for(int i=0;i<6;i++)
			board.tiles[0][i].convertValid();
		Piece piece = new Piece(0, 0);
		
		assertSame(board.getPieceAt(new BoardPosition(0,0)), null) ;
		
		board.addPiece(piece, new BoardPosition(0, 0));
		assertSame(board.getPieceAt(new BoardPosition(0,0)), piece);
		
	}
	
	public void testGetBoardPosition () {
		
		assertSame(board.getBoardPosition(null), null);
		
		for(int i=0;i<6;i++)
			board.tiles[0][i].convertValid();
		Piece piece = new Piece(0, 0);
		board.addPiece(piece, new BoardPosition(0, 0));
		
		assertNotSame(board.getBoardPosition(piece), new BoardPosition(0,0)) ;
		
	}
	
}
