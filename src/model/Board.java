package model;

public class Board {
	Tile[][] tiles;
	
	public Board(){
		this(new Tile[12][12]);
	}
	
	public Board(Tile[][] tiles){
		this.tiles=tiles;
	}
}
