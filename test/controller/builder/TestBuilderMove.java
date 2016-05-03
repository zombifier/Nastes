package controller.builder;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import junit.framework.TestCase;
import model.Board;
import model.Game;
import model.Lightning;
import model.Piece;
import model.Puzzle;
import model.PuzzleTile;
import model.Release;
import model.ReleaseTile;
import model.Tile;
import view.BuilderApplication;
import view.PieceView;
import view.TileView_Puzzle;
import view.TileView_Release;
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
	
	public void testLoadAndSaveController(){
		ba.initialize(game.getLevel(1));
		PieceController pc = new PieceController(ba, new PieceView(new Piece(4,5)));
		MouseEvent me = new MouseEvent(ba, 0, 2, 0, 0, 2, 1, false, MouseEvent.BUTTON1);
		pc.mousePressed(me);
		SaveController sc = new SaveController(game, ba.getLevel(), ba);
		sc.process();
		
		LoadController lc = new LoadController(game, ba);
		lc.process();
		
		assertEquals(1,ba.getBullpenView().getBullpen().numRemainPiece());
		
	}
	
	public void testRotateAndFlipController(){
		ba.initialize(game.getLevel(1));
		PieceView pw = new PieceView(new Piece(0,0));
		PiecePlayerController ppc = new PiecePlayerController(ba, pw);
		MouseEvent ae = new MouseEvent(pw, 0, 1, 0, 0, 0, 1, false,MouseEvent.BUTTON1);
		ppc.mouseReleased(ae);
		RotatingController rc = new RotatingController(pw, ba);
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(ba, 0, 0, 1, 'e');
		rc.keyPressed(e);
		rc.keyReleased(e);
		@SuppressWarnings("deprecation")
		KeyEvent r = new KeyEvent(ba, 1, 0, 1, 'r');
		rc.keyPressed(r);
		rc.keyReleased(r);
		@SuppressWarnings("deprecation")
		KeyEvent w = new KeyEvent(ba, 2, 0, 1, 'w');
		rc.keyPressed(w);
		rc.keyReleased(w);
		@SuppressWarnings("deprecation")
		KeyEvent q = new KeyEvent(ba, 3, 0, 1, 'q');
		rc.keyPressed(q);
		rc.keyReleased(q);
	}
	
	public void testChangeTypeMove(){
		Release el = new Release();
		game.setLevel(1, el);
		ba.initialize(game.getLevel(1));
		
		ChangeTypeMove ctm = new ChangeTypeMove(game.getLevel(1), ba, 0);
		ctm.doMove();
		assertEquals(0,ba.getLevel().levelType());
		
	}
	
	public void testChangeNumForReleaseLevel(){
		Release el = new Release();
		game.setLevel(1, el);
		ba.initialize(game.getLevel(1));
		
		ChangeNumForReleaseLevel cm = new ChangeNumForReleaseLevel(ba,new JFrame(), new TileView_Release(new ReleaseTile(false, false, 4, 5)), 1, 2);
		ActionEvent ae = new ActionEvent(ba, 0, getName());
		cm.actionPerformed(ae);
	}
}
