package controller.player;

import java.awt.Point;
import java.awt.event.MouseEvent;

import model.*;
import view.player.*;

public class BoardController extends LevelController {
	
	// Constant
	final public static int offset = 2;
	final public static int tileSize = 40;
	final public static int eachSize = offset + tileSize;
	
	Board board;
	BoardView boardView;
	
	public BoardController(Level level,PlayerLevelView levelView){
		super(level, levelView);
		board = level.getBoard();
		boardView = levelView.getBoardView();
	}
	
	@Override
	public void mousePressed(MouseEvent me){
		int x = me.getX();
		int y = me.getY();
		
		int xBoard = x / eachSize;
		int yBoard = y / eachSize;
		
		int xCheck = x % eachSize - offset;
		int yCheck = y % eachSize - offset;
		
		
		// Out of bound case
		if(xCheck < 0 || yCheck < 0 || xBoard >= 12 || yBoard >= 12 || xBoard < 0 || yBoard < 0) return;
		
		Piece pieceBeingDragged = level.getPiece();
		if(pieceBeingDragged == null){
			if(level.levelType() != 0) return;

			BoardPosition boPos = board.getBoardPosition(board.getPieceAt(new BoardPosition(yBoard, xBoard)));
			pieceBeingDragged = board.removePiece(board.getPieceAt(new BoardPosition(yBoard, xBoard)));
			
			if(pieceBeingDragged != null){
				pieceBeingDragged.translate(yBoard - boPos.getX(), xBoard - boPos.getY());
				level.holdPiece(pieceBeingDragged);
				levelView.setMovePieceView(pieceBeingDragged);
				x -= xBoard * eachSize;
				y -= yBoard * eachSize;
				levelView.setAnchor(new Point(x, y));
			}
		}
		else {
			if(board.addPiece(level.getPiece(), new BoardPosition(yBoard, xBoard))){
				level.holdPiece(null);
				levelView.setMovePieceView(null);
			}
		}
		
		levelView.redraw();
		levelView.repaint();
	}
	/*
	@Override
	public void mouseMoved(MouseEvent me){
		Point p=new Point(me.getX()+boardView.getBounds().x,
							me.getY()+boardView.getBounds().y);
		
		levelView.setMouse(p);
		//System.out.println(me.getPoint());
		
		levelView.redraw();
		levelView.repaint();
	}
	*/
	@Override
	public int refX(){
		return boardView.getBounds().x;
	}

	@Override
	public int refY(){
		return boardView.getBounds().y;
	}
}
