package view.player;

import junit.framework.TestCase;
import model.Game;
import model.Level;
import model.Lightning;
import model.Piece;

public class TestPlayerLevelView extends TestCase {
	Game game;
	Level level1;
	PlayerApplication app;
	PlayerLevelView panel;
	
	@Override
	public void setUp(){
		game = new Game();
		
		level1 = new Lightning();
		level1.setLimit(10);
		// make the board be able to be played
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 6; j++)
				level1.getBoard().getTile(i, j).convertValid();
		
		// make the pieces for bullpen
		for(int i = 0; i < 3; i++)
			level1.getBullpen().addPiece(new Piece(i,0));
		
		game.setLevel(0, level1);
		
		app = new PlayerApplication(game);
		
		panel = new PlayerLevelView(game, level1, app);
	}
	
	@Override
	public void tearDown(){
		game = null;
		level1 = null;
		app = null;
		panel = null;
	}
	
	public void testLevel(){
		System.out.println("Run!!");
	}
}