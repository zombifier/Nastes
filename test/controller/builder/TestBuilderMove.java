package controller.builder;

import java.awt.Point;
import java.awt.event.MouseEvent;

import junit.framework.TestCase;
import model.Board;
import model.Game;
import model.Lightning;
import model.Piece;
import model.Puzzle;
import model.PuzzleTile;
import model.Release;
import model.ReleaseTile;
import view.BuilderApplication;
import view.PieceView;
import view.TileView_Puzzle;
import controller.builder.*;

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
	
	public void testBuilderApplication(){
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
		
		PieceController pc = new PieceController(ba, new PieceView(new Piece(4,5)));
		MouseEvent me = new MouseEvent(ba, 0, 2, 0, 0, 2, 1, false, MouseEvent.BUTTON1);
		pc.mousePressed(me);
		assertEquals(1,ba.getBullpenView().getBullpen().numRemainPiece());
		
		
		//game.getLevel(1).getBullpen().addPiece(new Piece(1,1));
		//assertEquals(1, game.getLevel(1).getBullpen().numRemainPiece());
//		SelectPieceFromBullpen m1 = new SelectPieceFromBullpen(game.getLevel(1), game.getLevel(1).getBullpen(), game.getLevel(1).getBullpen().getPieces().get(1));
//		m1.doMove();
//		m1.undo();
//		assertEquals(true, m1.valid());
		
	}
	
	public void testPieceController(){
		ba.initialize(game.getLevel(1));
		PieceController pc = new PieceController(ba, new PieceView(new Piece(4,5)));
		MouseEvent me = new MouseEvent(ba, 0, 2, 0, 0, 2, 1, false, MouseEvent.BUTTON1);
		pc.mousePressed(me);
		assertEquals(1,ba.getBullpenView().getBullpen().numRemainPiece());
		
		MouseEvent me2 = new MouseEvent(ba.getBullpenView(), 0, 2, 0, 0, 2, 1, false, MouseEvent.BUTTON1);
		PiecePlayerController ppc = new PiecePlayerController(ba, new PieceView(ba.getBullpenView().getBullpen().getPieces().get(0)));
		ppc.mousePressed(me2);

	}
	
	public void testBoardController(){
		ba.initialize(game.getLevel(1));
		BoardController bc = new BoardController(ba, ba.getBoardView().getBoard(), ba.getBoardView());
		
		MouseEvent me2 = new MouseEvent(ba.getBoardView(), 0, 2, 78, 26, 0, 1, false, MouseEvent.BUTTON1);
		bc.mousePressed(me2);
		assertEquals(false,ba.getBoardView().getBoard().getTile(0, 0).isValid());	
	}
	

	
}
