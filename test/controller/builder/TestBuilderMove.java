package controller.builder;

import junit.framework.TestCase;
import model.Game;
import model.Piece;
import model.Puzzle;
import model.Release;
import view.BuilderApplication;

public class TestBuilderMove extends TestCase {
	BuilderApplication ba;
	Game game;
	@Override
	protected void setUp() {
		game = new Game();
		ba = new BuilderApplication(game); 
		

	}
	
	@Override
	protected void tearDown() {
		ba = null;
	}
	
	public void testMove(){
		assertEquals(0, game.getLevel(1).levelType());
		ba.initialize(game.getLevel(1));
		//game.getLevel(1).getBullpen().addPiece(new Piece(1,1));
		//assertEquals(1, game.getLevel(1).getBullpen().numRemainPiece());
//		SelectPieceFromBullpen m1 = new SelectPieceFromBullpen(game.getLevel(1), game.getLevel(1).getBullpen(), game.getLevel(1).getBullpen().getPieces().get(1));
//		m1.doMove();
//		m1.undo();
//		assertEquals(true, m1.valid());
		
	}
}
