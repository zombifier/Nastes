package model;

import junit.framework.TestCase;

public class TestTile extends TestCase {
	
//	Tile tile;
//	
//	@Override
//	protected void setUp() {
//		tile = new Tile (false) ; 
//		// Confident
//	}
//	
//	@Override
//	protected void tearDown() {
//		tile = null;
//	}

	
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
	
	public void testIsValid() {
		assertSame(false ,board.tiles[0][0].isValid()) ;
	}
	
	public void testConvertValid() {
		board.tiles[0][0].convertValid() ;
		assertSame(true ,board.tiles[0][0].isValid()) ;
	}
	
	// Someone can add this in when they see it
	
//	public void testTileCopy() {
//		Tile atile = board.tiles[0][0].copy() ;
//	}
	
}