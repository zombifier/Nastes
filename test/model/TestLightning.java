package model;

import junit.framework.TestCase;

public class TestLightning extends TestCase {
	
	Lightning level;
	Piece piece;
	
	@Override
	public void setUp(){
		level = new Lightning();
		level.levelNum = 1;
		level.timeLimit = 10;
		// 3 row
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 6; j++)
				level.board.tiles[i][j].isValid = true;
		piece = new Piece(0,0);
	}
	
	@Override
	public void tearDown(){
		level = null;
		piece = null;
	}
	
	public void testInitialize(){
		// initial condition
		assertEquals(1, level.levelType());
		assertEquals("Lightning", level.name());
		assertEquals("#1", level.getLevelNum());
		assertEquals("10", level.getLimit());
		assertEquals("Seconds", level.getUnit());
		
		// Change limit
		level.setLimit(20);
		assertEquals("20", level.getLimit());
		
		// assume time run for 10 seconds
		for(int i = 0; i < 10; i++)
			level.limitDecrease();
		
		assertEquals("10", level.getLimit());
		
		assertEquals(0, level.resultStar());
		
		// there are valid but unplayed tiles
		assertFalse(level.hasWon());
		
		// assume that time has passed only half
		level.timeElapsed = level.timeLimit / 2;
		assertFalse(level.hasWon());
		
		// assume that the time is up
		level.timeElapsed = level.timeLimit;
		assertTrue(level.hasWon());
	}
	
	public void testPlacePiece(){
		// place first -> not finish and currently 1 star
		assertTrue(level.board.addPiece(piece, new BoardPosition(0, 0)));
		
		assertFalse(level.hasWon());
		assertEquals(1, level.resultStar());
		
		// place at the wrong place
		assertFalse(level.board.addPiece(piece, new BoardPosition(0, 3)));
		
		// place at the same place, result should be the same
		assertTrue(level.board.addPiece(piece, new BoardPosition(0, 0)));
		
		assertFalse(level.hasWon());
		assertEquals(1, level.resultStar());
		
		// place the second
		assertTrue(level.board.addPiece(piece, new BoardPosition(1, 0)));
		
		assertFalse(level.hasWon());
		assertEquals(2, level.resultStar());
		
		// place the third
		assertTrue(level.board.addPiece(piece, new BoardPosition(2, 0)));
		
		assertTrue(level.hasWon());
		assertEquals(3, level.resultStar());
	}
	
	public void testCopy(){
		// copy the level
		Level another = level.copy();
		
		// initial condition for level
		assertEquals(1, another.levelType());
		assertEquals("Lightning", another.name());
		assertEquals("#1", another.getLevelNum());
		assertEquals("10", another.getLimit());
		assertEquals("Seconds", another.getUnit());
		
		
	}
}
