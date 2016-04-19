package model;

public class Level {
	Board board;
	Bullpen bullpen;
	Piece pieceBeingDragged;
	int starEarned;
	boolean isUnlocked;
	int levelNum;
	Hint hint;
	
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
	
	public void holdPiece(Piece p){
		pieceBeingDragged=p;
	}
	
	public Piece releasePiece(){
		Piece p=pieceBeingDragged;
		pieceBeingDragged=null;
		return p;
	}
}
