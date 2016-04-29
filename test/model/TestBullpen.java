package model;

import junit.framework.TestCase;

public class TestBullpen extends TestCase{

	Bullpen bullpen;
	
	@Override
	protected void setUp() {
		bullpen = new Bullpen(); 
		
	}
	
	@Override
	protected void tearDown() {
		bullpen = null;
	}
	
	public void testInitiateBullpen(){
		assertEquals(0, bullpen.numRemainPiece());
	}
	
	public void testAddAndRemovePiece(){
		
		Piece piece1 = new Piece(0,0);
		bullpen.addPiece(piece1);
		
		assertEquals(1, bullpen.numRemainPiece());
		assertEquals(piece1, bullpen.pieces.get(0));
		
		Piece piece2 = new Piece(1,2);
		bullpen.addPiece(piece2);

		assertEquals(2, bullpen.numRemainPiece());
		assertEquals(piece2, bullpen.pieces.get(1));
		
		bullpen.removePiece(piece1);

		assertEquals(1, bullpen.numRemainPiece());
		assertEquals(piece2, bullpen.pieces.get(0));
		
		bullpen.removePiece(piece1);

		assertEquals(1, bullpen.numRemainPiece());
		
	}
	
	public void testCopy(){
		Piece piece1 = new Piece(0,0);
		Piece piece2 = new Piece(1,3);
		Piece piece3 = new Piece(2,8);
		
		Bullpen another;
		
		bullpen.addPiece(piece1);
		bullpen.addPiece(piece2);
		bullpen.addPiece(piece3);
		
		another = bullpen.copy();
		
		assertFalse(bullpen == another);
		assertEquals(3, another.numRemainPiece());
		for(int i = 0; i < 3; i++)
			assertEquals(bullpen.pieces.get(i).type, another.pieces.get(i).type);
		
		another.removePiece(piece2);
		assertEquals(3, another.numRemainPiece());
	}
	
	public void testIterable(){
		Piece[] pieces = new Piece[5];
		for(int i = 0; i < 5; i++){
			pieces[i] = new Piece(i, i);
			bullpen.addPiece(pieces[i]);
		}
			
		for(Piece piece: bullpen.getPieces()){
			boolean check = false;
			for(Piece anotherPiece: pieces)
				if(piece == anotherPiece)
					check = true;
			if(!check)
				fail();
		}
	}
}
