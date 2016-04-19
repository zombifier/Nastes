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
		starEarned=0;
		isUnlocked=false;
		levelNum=0;
		
	}

	public Level(Board b,Bullpen p,int levelNum){
		board=b;
		bullpen=p;
		pieceBeingDragged=null;
		starEarned=0;
		isUnlocked=false;
		this.levelNum=levelNum;
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
