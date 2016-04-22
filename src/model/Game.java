package model;

public class Game {
	Level[] levels;
	
	public Game(){
		// Put the levels here
		levels = new Level[15];
		levels[0] = new Puzzle(8); // The number needs to be changed
	}
	
	public Game(Level[] levels){
		this.levels=levels;
	}
	
	public Level getLevel(int stage){
		return levels[stage];
	}
}
