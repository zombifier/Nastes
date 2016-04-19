package model;

public class Level {
	Board board;
	Bullpen bullpen;
	Piece pieceBeingDragged;
	
	public Level(){
		board=new Board();
		bullpen=new Bullpen();
		pieceBeingDragged=null;
	}

	public Level(Board b,Bullpen p){
		board=b;
		bullpen=p;
		pieceBeingDragged=null;
	}
	
	
}
