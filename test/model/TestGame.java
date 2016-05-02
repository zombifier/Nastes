package model;

import junit.framework.TestCase;

public class TestGame extends TestCase {
	
	Game game;
	Level[] levels;
	
	@Override 
	public void setUp(){
		levels = new Level[3];
		levels[0] = new Puzzle(20);
		levels[1] = new Lightning();
		levels[2] = new Release();
		
		game = new Game();
		// set the level
		for(int i = 0; i < 3; i++)
			game.setLevel(i, levels[i]);
		game.reset();
		
	}
	
	@Override
	public void tearDown(){
		levels = null;
		game = null;
	}
	
	public void testInitialize(){
		for(int i = 0; i < 3; i++)
			assertEquals(levels[i], game.levels[i]);
		
	}
	
	public void testSetStar(){
		// set star 
		game.setStar(0, 1);
		game.setStar(1, 2);
		game.setStar(2, 3);
		
		// check the number of star
		assertEquals(1, game.levels[0].getStar());
		assertEquals(2, game.levels[1].getStar());
		assertEquals(3, game.levels[2].getStar());
		// the copies of level should give the same
		assertEquals(1, game.getLevel(0).getStar());
		assertEquals(2, game.getLevel(1).getStar());
		assertEquals(3, game.getLevel(2).getStar());
		
		// set star again
		game.setStar(0, 3);
		game.setStar(1, 2);
		game.setStar(2, 1);
		
		// must choose higher one
		assertEquals(3, game.levels[0].getStar());
		assertEquals(2, game.levels[1].getStar());
		assertEquals(3, game.levels[2].getStar());
		// the copies of level should give the same
		assertEquals(3, game.getLevel(0).getStar());
		assertEquals(2, game.getLevel(1).getStar());
		assertEquals(3, game.getLevel(2).getStar());
	}
}
