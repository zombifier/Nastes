package model;

/**
 * 
 * @param levels 	These are the levels that go into the gmae. There must be at least one
 * 					for our game there is always 15. 
 * 
 * The top level class. It is our game. 
 *
 */

public class Game implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5284714301610333022L;
	
	
	Level[] levels;
	
	public Game(){
		// Put the levels here
		levels = new Level[15];
		for(int i = 0; i < 15; i++)
			levels[i] = new Puzzle(8); // The number needs to be changed
	}
	
	public Game(Level[] levels){
		this.levels=levels;
	}
	
	/**
	 * return the level corresponding to the number.
	 * @param stage Number of level in the game
	 * @return Level corresponding to the stage
	 */
	public Level getLevel(int stage){
		return levels[stage];
	}
	
	/**
	 * Put the level corresponding to the number
	 * @param stage Number of level in the game
	 * @param level Level put in the corresponding stage number
	 */
	public void setLevel(int stage, Level level){
		levels[stage] = level;
	}
}
