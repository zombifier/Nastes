package controller.player;

import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import junit.framework.TestCase;
import model.*;
import view.player.*;

public class TestBoardController extends TestCase{
	Game game;
	Level level1, level2;
	PlayerApplication app;
	PlayerLevelView panel;
	BoardController controller;

	@Override
	public void setUp(){
		game = new Game();

		level1 = new Puzzle(8);
		level1.setLimit(10);
		// make the board be able to be played
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 6; j++)
				level1.getBoard().getTile(i, j).convertValid();

		// make the pieces for bullpen
		for(int i = 0; i < 3; i++)
			level1.getBullpen().addPiece(new Piece(i,0));
		
		level2 = new Lightning();
		level2.setLimit(10);
		// make the board be able to be played
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 6; j++)
				level2.getBoard().getTile(i, j).convertValid();

		// make the pieces for bullpen
		for(int i = 0; i < 3; i++)
			level2.getBullpen().addPiece(new Piece(i,0));

		game.setLevel(0, level1);
		game.setLevel(0, level2);

		app = new PlayerApplication(game);

	}

	@Override
	public void tearDown(){
		game = null;
		level1 = null;
		panel = null;
		if(app != null)
			app.dispose();
	}

	public void setUp1(){

		panel = new PlayerLevelView(game, level1, app);

		app.setVisible(true);
		app.setPanel(panel);

		controller = new BoardController(level1, panel);

	}

	public void setUp2(){

		panel = new PlayerLevelView(game, level2, app);

		app.setVisible(true);
		app.setPanel(panel);

		controller = new BoardController(level2, panel);

	}

	public void testMovePiecePuzzle(){
		setUp1();
		
		Piece piece = new Piece(0,0);
		level1.holdPiece(piece);
		panel.setAnchor(new Point(10, 10));

		// pressed at BoardPosition(0,0)
		MouseEvent me = new MouseEvent(panel, 0, 0, 0, 10, 10, 1, false, MouseEvent.BUTTON1);
		controller.mousePressed(me);

		// check the piece at the point placed
		assertEquals(piece, level1.getBoard().getPieceAt(new BoardPosition(0, 0)));
		assertNull(level1.getPiece());

		// press again to retrieve the piece
		controller.mousePressed(me);

		// the level should hold the piece
		assertEquals(piece, level1.getPiece());
	}

	public void testMovePieceLightning(){
		setUp2();
		
		Piece piece = new Piece(0,0);
		level2.holdPiece(piece);
		panel.setAnchor(new Point(10, 10));

		// pressed at BoardPosition(0,0)
		MouseEvent me = new MouseEvent(panel.getBoardView(), 0, 0, 0, 10, 10, 1, false, MouseEvent.BUTTON1);
		controller.mousePressed(me);

		// check the piece at the point placed
		assertEquals(piece, level2.getBoard().getPieceAt(new BoardPosition(0, 0)));
		assertNull(level2.getPiece());

		// press again to retrieve the piece
		controller.mousePressed(me);

		// the level should hold the piece
		assertNull(level2.getPiece());
		
	}
}
