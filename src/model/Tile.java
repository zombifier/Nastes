package model;

abstract public class Tile {
	boolean isValid;
	boolean hasSquare;
	
	public Tile(boolean isValid) {
		this.isValid = isValid;
	}
	
	public boolean isValid() { return isValid; }
	
	abstract public boolean playable(); // whether you can add a square to this tile
	
	abstract public void addSquare();
	public void removeSquare(){
		
	}
}