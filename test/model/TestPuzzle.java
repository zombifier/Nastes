package model;

import junit.framework.TestCase;

public class TestPuzzle extends TestCase{
	Level level;
	Piece[] pieces;
	@Override
	public void setUp() {
		Board board = new Board(0);
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 6; j++) {
				board.getTile(i, j).convertValid();
			}
		Bullpen bullpen = new Bullpen();
		pieces = new Piece[3];
		pieces[0] = new Piece(1, 0);
		pieces[1] = new Piece(2, 0);
		pieces[2] = new Piece(3, 0);
		bullpen.addPiece(pieces[0]);
		bullpen.addPiece(pieces[1]);
		bullpen.addPiece(pieces[2]);
		level = new Puzzle(board, bullpen, 10);
	}
	
	@Override
	public void tearDown() {
		level = null;
	}
	
	public void testConstructor() {
		assertEquals(level.hasWon(), false);
		assertEquals(level.getStar(), 0);
		assertEquals(level.getLimit(), "10");
		assertEquals(level.resultStar(), 0);
		assertEquals(level.name(), "Puzzle");
		assertEquals(level.levelType(), 0);
	}
	
	public void testMove() {
		assertTrue(level.getBoard().isLegal(pieces[0], new BoardPosition(0,0)));
		if (level.getBoard().addPiece(pieces[0], new BoardPosition(0,0))) {
			level.getBullpen().removePiece(pieces[0]);
			level.limitDecrease();
		}
		assertEquals(level.getLimit(), "9");
		assertEquals(level.resultStar(), 1);
		assertTrue(level.getBoard().isLegal(pieces[1], new BoardPosition(1,0)));
		if (level.getBoard().addPiece(pieces[1], new BoardPosition(1,0))) {
			level.getBullpen().removePiece(pieces[1]);
			level.limitDecrease();
		}
		assertEquals(level.getLimit(), "8");
		assertEquals(level.resultStar(), 2);
		assertTrue(level.getBoard().isLegal(pieces[2], new BoardPosition(2,0)));
		if (level.getBoard().addPiece(pieces[2], new BoardPosition(2,0))) {
			level.getBullpen().removePiece(pieces[2]);
			level.limitDecrease();
		}
		assertEquals(level.getLimit(), "7");
		assertEquals(level.resultStar(), 3);
	}
	
	public void testCopy() {
		Level l = level.copy();
		assertEquals(l.hasWon(), false);
		assertEquals(l.getStar(), 0);
		assertEquals(l.getLimit(), "10");
		assertEquals(l.resultStar(), 0);
		assertEquals(l.name(), "Puzzle");
		assertEquals(l.levelType(), 0);
	}
}
