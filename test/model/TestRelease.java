package model;

import junit.framework.TestCase;

public class TestRelease extends TestCase {
	Release release;
	
	@Override
	protected void setUp() {
		release = new Release(); 
		
	}
	
	@Override
	protected void tearDown() {
		release = null;
	}
	
	public void testInitiateRelease(){
		assertEquals(6, release.redNumbersUncovered);
		assertEquals(6, release.yellowNumbersUncovered);
		assertEquals(6, release.greenNumbersUncovered);
		assertEquals(2, release.levelType());
		assertEquals("Release",release.name());
		release.setLimit(3);
		Release copyRelease = (Release) release.copy();
		assertEquals(2, copyRelease.levelType());
		assertEquals("Release",copyRelease.name());
	}
	
	public void testSecondConstructor(){
		ReleaseTile[][] tiles = new ReleaseTile[12][12];
		for (int i=0;i<=11;i++){
			for (int j=0;j<=11;j++){
				tiles[i][j] = new ReleaseTile(true, false, 0, 0);
			}
		}
		
		for (int i = 1;i<7;i++){
			tiles[2][i].setNumAndColor(i, 1);
			tiles[3][i].setNumAndColor(i, 2);
			tiles[4][i].setNumAndColor(i, 3);
		}
		
		assertEquals(1,tiles[2][3].getColor());
		assertEquals(3,tiles[2][3].getNumber());
		assertEquals(false,tiles[2][3].isFilled());
		Tile copyTile = tiles[2][3].copy();
		assertEquals(true,copyTile.playable());
		for (int i = 1;i<7;i++){
			tiles[2][i].addSquare();
		}
		
	
		assertEquals(true,tiles[2][3].isFilled());
		assertEquals(false,tiles[2][3].playable());
		assertEquals(2,tiles[2][3].levelType());
		
		Board board = new Board(tiles);
		Bullpen bullpen = new Bullpen();
		assertEquals(true,release.hasWon());
		bullpen.addPiece(new Piece(0,0));
		release = new Release(board, bullpen);
		release.updateNumberUncovered();
		assertEquals(1,release.resultStar());
		assertEquals("2",release.getLimit());	

		assertEquals(false,release.hasWon());	
		for (int i = 1;i<7;i++){
			tiles[3][i].addSquare();
			tiles[4][i].addSquare();
		}
		assertEquals(3,release.resultStar());
		release.updateNumberUncovered();
		assertEquals(true,release.hasWon());
		assertEquals("0",release.getLimit());
		assertEquals("Sets",release.getUnit());
		
		
		
	}
}
