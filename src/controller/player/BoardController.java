package controller.player;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Random;

import model.*;
import view.player.*;
/**
 * Board Controller 
 * @author Team Nastes
 *
 */
public class BoardController extends LevelController {
	
	// Constant
	/**
	 * This is space between tiles
	 */
	final public static int offset = 2;
	/**
	 * size of actual tiles
	 */
	final public static int tileSize = 40;
	/**
	 * the size of the tiles 
	 */
	final public static int eachSize = offset + tileSize;
	
	Board board;
	BoardView boardView;
	/**
	 * Constructor for BoardController
	 * @param level
	 * @param levelView
	 */
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
				super.mouseMoved(me);
				if (level.levelType()==0) level.limitDecrease();
			}
		}
		else {
			if(board.addPiece(level.getPiece(), new BoardPosition(yBoard, xBoard))){
				level.holdPiece(null);
				levelView.setMovePieceView(null);
				if (level.levelType() != 1) { // Hack!!
					level.limitDecrease();
				}
				else {
					// add new piece to bullpen
					Random rand = new Random();
					level.getBullpen().addPiece(new Piece(rand.nextInt(), rand.nextInt(35)));
				}
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
	/**
	 * Reference for X. Position of the board view in the level view. 
	 * @return position
	 */
	@Override
	public int refX(){
		return boardView.getBounds().x;
	}
	/**
	 * Reference for Y. Position of the board view in the level view 
	 * @return position
	 */
	@Override
	public int refY(){
		return boardView.getBounds().y;
	}
}
