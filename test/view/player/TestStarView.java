package view.player;

import javax.swing.JFrame;

import junit.framework.TestCase;
import model.Game;
import model.Level;
import model.Piece;
import model.Release;
import model.ReleaseTile;

public class TestStarView extends TestCase {
	Game game;
	Level level1;
	PlayerApplication app;
	StarView frame;
	
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
		
		frame = new StarView(level1, game, app);
		
		frame.setVisible(true);
		app.setVisible(true);
	}
	
	@Override
	public void tearDown(){
		game = null;
		level1 = null;
		frame = null;
		if(app != null)
			app.dispose();
	}
	
	public void testStar(){
		System.out.println("Run!!");
		frame.getWindowListeners()[0].windowClosing(null);
	}
}
