package controller.player;

import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import junit.framework.TestCase;
import view.player.*;
import model.*;

public class TestLevelKeyController extends TestCase {
	Game game;
	Level level1;
	Piece piece;
	PlayerApplication app;
	PlayerLevelView panel;
	LevelKeyController controller;
	
	@Override
	public void setUp(){
		game = new Game();
		
		level1 = new Release();
		level1.setLimit(10);
		// make the board be able to be played
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 6; j++)
				level1.getBoard().getTile(i, j).convertValid();
			((ReleaseTile)(level1.getBoard().getTile(i, 0))).setNumAndColor(1, i+1);
		}
		
		// make the pieces for bullpen
		for(int i = 0; i < 3; i++)
			level1.getBullpen().addPiece(new Piece(i,0));
		
		game.setLevel(0, level1);
		
		app = new PlayerApplication(game);
		
		panel = new PlayerLevelView(game, level1, app);
		
		app.setVisible(true);
		app.setPanel(panel);
		
		piece = new Piece(0,0);
		level1.holdPiece(piece);
		panel.setAnchor(new Point(10, 10));
		panel.setMouse(new Point(10, 10));
		
		controller = new LevelKeyController(level1, panel);
	}
	
	@Override
	public void tearDown(){
		game = null;
		level1 = null;
		panel = null;
		if(app != null)
			app.dispose();
	}
	
	public void testRotateClockwise(){
		// press e to rotate clockwise
		KeyEvent ke = new KeyEvent(panel, 0, 0, 0, KeyEvent.VK_E, KeyEvent.CHAR_UNDEFINED);
		controller.keyPressed(ke);
		
		// Compare to another constructed precisely
		Piece compare = new Piece(1,0);
		compare.rotate(true);
		
		Square[] squares = piece.getSquares(), compareSquares = compare.getSquares();
		
		// Check each square has the same PiecePosition
		for(int i = 0; i < 6; i++)
			assertTrue(squares[i].equalPosition(compareSquares[i]));
	}
	
	public void testRotateCounterclockwise(){
		// press r to rotate counterclockwise
		KeyEvent ke = new KeyEvent(panel, 0, 0, 0, KeyEvent.VK_R, KeyEvent.CHAR_UNDEFINED);
		controller.keyPressed(ke);
		
		// Compare to another constructed precisely
		Piece compare = new Piece(1,0);
		compare.rotate(false);
		
		Square[] squares = piece.getSquares(), compareSquares = compare.getSquares();
		
		// Check each square has the same PiecePosition
		for(int i = 0; i < 6; i++)
			assertTrue(squares[i].equalPosition(compareSquares[i]));
	}
	
	public void testFlipHorizontal(){
		// press w to flip horizontal
		KeyEvent ke = new KeyEvent(panel, 0, 0, 0, KeyEvent.VK_W, KeyEvent.CHAR_UNDEFINED);
		controller.keyPressed(ke);
		
		// Compare to another constructed precisely
		Piece compare = new Piece(1,0);
		compare.flip(true);
		
		Square[] squares = piece.getSquares(), compareSquares = compare.getSquares();
		
		// Check each square has the same PiecePosition
		for(int i = 0; i < 6; i++)
			assertTrue(squares[i].equalPosition(compareSquares[i]));
	}
	
	public void testFlipVertical(){
		// press q to flip vertical
		KeyEvent ke = new KeyEvent(panel, 0, 0, 0, KeyEvent.VK_Q, KeyEvent.CHAR_UNDEFINED);
		controller.keyPressed(ke);
		
		// Compare to another constructed precisely
		Piece compare = new Piece(1,0);
		compare.flip(false);
		
		Square[] squares = piece.getSquares(), compareSquares = compare.getSquares();
		
		// Check each square has the same PiecePosition
		for(int i = 0; i < 6; i++)
			assertTrue(squares[i].equalPosition(compareSquares[i]));
	}
}
