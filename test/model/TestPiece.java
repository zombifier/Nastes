package model;

import junit.framework.TestCase;

public class TestPiece extends TestCase {
	Piece piece;
	
	@Override
	protected void setUp() {
		
	}
	
	@Override
	protected void tearDown() {
		piece = null;
	}
	
	public void testCreate35Pieces(){
		for(int i = 0; i < 35; i++){
			piece = new Piece(i, i);
		}
	}
	
	
	public void testRotateCounterclockwise(){
		piece = new Piece(0, 11);
		Piece resultPiece = new Piece(0, 11);
		Square[] resultSquares = resultPiece.getSquares();
		resultSquares[0].piecePosition = new PiecePosition(0, 0);
		resultSquares[1].piecePosition = new PiecePosition(-1, 0);
		resultSquares[2].piecePosition = new PiecePosition(-2, 0);
		resultSquares[3].piecePosition = new PiecePosition(0, 1);
		resultSquares[4].piecePosition = new PiecePosition(-1, 1);
		resultSquares[5].piecePosition = new PiecePosition(-2, 1);
		

		
		piece.rotate(false);
		Square[] squares = piece.getSquares();
		
		for(int i = 0; i < 6; i++)
			System.out.println(squares[i].piecePosition+" vs "+resultSquares[i].piecePosition);
		
		for(int i = 0; i < 6; i++)
			assertTrue(squares[i].piecePosition.equals(resultSquares[i].piecePosition));
	}
	
	
	public void testRotateClockwise(){
		piece = new Piece(1, 11);
		Piece resultPiece = new Piece(0, 11);
		Square[] resultSquares = resultPiece.getSquares();
		resultSquares[0].piecePosition = new PiecePosition(0, 0);
		resultSquares[1].piecePosition = new PiecePosition(1, 0);
		resultSquares[2].piecePosition = new PiecePosition(2, 0);
		resultSquares[3].piecePosition = new PiecePosition(0, -1);
		resultSquares[4].piecePosition = new PiecePosition(1, -1);
		resultSquares[5].piecePosition = new PiecePosition(2, -1);


		
		piece.rotate(true);
		Square[] squares = piece.getSquares();


		for(int i = 0; i < 6; i++)
			System.out.println(squares[i].piecePosition+" vs "+resultSquares[i].piecePosition);
		for(int i = 0; i < 6; i++)
			assertTrue(squares[i].piecePosition.equals(resultSquares[i].piecePosition));
	}
}
