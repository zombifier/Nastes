package view.player;

import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import controller.player.BoardController;
import junit.framework.TestCase;
import model.*;

public class TestPlayerLevelView extends TestCase {
	Game game;
	Level level1;
	PlayerApplication app;
	PlayerLevelView panel;
	BoardController controller;
	
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
		game = new Game();
		
		level1 = new Lightning();
		level1.setLimit(10);
		// make the board be able to be played
		for(int j = 0; j < 6; j++)
			level1.getBoard().getTile(0, j).convertValid();
		
		game.setLevel(0, level1);
		
		app = new PlayerApplication(game);
		
		panel = new PlayerLevelView(game, level1, app);
		
		app.setVisible(true);
		app.setPanel(panel);
		
		// assume the last piece is being held
		level1.holdPiece(new Piece(0, 0));
		panel.setAnchor(new Point(10, 10));
		panel.setMouse(new Point(10, 10));
		
		controller = new BoardController(level1, panel);
	}
	
	public void testLevel(){
		//panel.redraw();
		//panel.repaint();
		System.out.println("Run!!");
	}
	
	public void testFinishLevel(){
		// set up another way
		tearDown();
		setUp1();
	

		// pressed at BoardPosition(0,0)
		// the game should finish
		MouseEvent me = new MouseEvent(panel.getBoardView(), 0, 0, 0, 10, 10, 1, false, MouseEvent.BUTTON1);
		controller.mousePressed(me);
		System.out.println("Run!!");
	}
	
	public void testFinishLevelWithPieceHeld(){
		// set up another way
		tearDown();
		setUp1();
	

		// assume that time run out
		for(int i = 0; i < 10; i++)
			level1.limitDecrease();
		System.out.println("Run!!");
	}
}