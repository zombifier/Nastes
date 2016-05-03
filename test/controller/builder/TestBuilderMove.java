package controller.builder;

import java.awt.Point;

import junit.framework.TestCase;
import model.Board;
import model.Game;
import model.Lightning;
import model.Piece;
import model.Puzzle;
import model.Release;
import model.ReleaseTile;
import view.BuilderApplication;
import view.PieceView;

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
		Lightning ll = new Lightning();
		game.setLevel(2, ll);
		ba.initialize(game.getLevel(2));
		Release el = new Release();
		game.setLevel(3, el);
		Board testBoard = game.getLevel(3).getBoard();
		ReleaseTile rt = (ReleaseTile) testBoard.getTile(4, 5);
		rt.setNumAndColor(2,2);

		ba.initialize(game.getLevel(3));
		ba.getLevel();
		ba.setMovingPiece(0, new PieceView(new Piece(4,5)), 100, 100);
		ba.updateMovePiece(ba.getPieceBeingDrag(), 200, 200);
		ba.getBoardView().drawPieceView(ba.getPieceBeingDrag(), new Point(100,100));
		ba.getBullpenView().getBullpen();
		ba.getBullpenView().drawPieceView(ba.getPieceBeingDrag());
		//game.getLevel(1).getBullpen().addPiece(new Piece(1,1));
		//assertEquals(1, game.getLevel(1).getBullpen().numRemainPiece());
//		SelectPieceFromBullpen m1 = new SelectPieceFromBullpen(game.getLevel(1), game.getLevel(1).getBullpen(), game.getLevel(1).getBullpen().getPieces().get(1));
//		m1.doMove();
//		m1.undo();
//		assertEquals(true, m1.valid());
		
	}
}
