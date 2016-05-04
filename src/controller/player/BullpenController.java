package controller.player;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import model.*;
import view.player.*;

/**
 * Bull pen controller
 * @author Team Nastes
 *
 */
public class BullpenController extends LevelController {
	
	/**
	 * THis is the offset. Distance between tiles
	 */
	// constants 
	final public static int offset = 2;
	/**
	 * This is the tiles size. That actual size of the tiles. (squares) 
	 */
	final public static int tileSize = 40;
	/**
	 * This is the "actual size" Size of the tiles added to offset
	 */
	final public static int eachSize = offset + tileSize;
	
	Bullpen bullpen;
	BullpenView bullpenView;
	/**
	 * Constructor for BullpenController
	 * @param level Level
	 * @param levelView LevelView
	 */
	public BullpenController(Level level,PlayerLevelView levelView) {
		super(level,levelView);
		
		bullpen = level.getBullpen();
		bullpenView = levelView.getBullpenView();
	}

	@Override
	public void mousePressed(MouseEvent me){
		int x = me.getX();
		int y = me.getY();
		
		Piece pieceBeingDragged = level.getPiece();
		ArrayList<Piece> pieces = bullpen.getPieces();
		boolean found = false;
		if(pieceBeingDragged == null){
			for(int i=pieces.size() - 1; i >= 0; i--){
				Piece piece = pieces.get(i);
				Point point = bullpenView.getPiecePoint(piece);
				if(point != null){
					int xBoard = Math.floorDiv(y - point.y, eachSize);
					int yBoard = Math.floorDiv(x - point.x, eachSize);
					for(Square square: piece.getSquares())
						if(square.getX() == xBoard && square.getY() == yBoard){
							found = true;
							piece.translate(xBoard, yBoard);
							point = new Point(point.x + yBoard * eachSize,
									point.y + xBoard * eachSize);
							break;
						}
				}
				if(found){
					//bullpen.pieceLevel(true);
					bullpen.removePiece(piece);
					level.holdPiece(piece);
					levelView.setMovePieceView(piece);
					levelView.setAnchor(new Point(x-point.x,y-point.y));
					super.mouseMoved(me);
					break;
				}
			}
				
		}
		else { // 
			Point po=levelView.getAnchor();
			po=new Point(x-po.x,y-po.y);
			if(bullpenView.setLocation(pieceBeingDragged,po)){
				bullpen.addPiece(pieceBeingDragged);
				//bullpen.pieceLevel(false);
				level.holdPiece(null);
				levelView.setMovePieceView(null);
			}
		}
		
		levelView.redraw();
		levelView.repaint();
	}
	
	/**
	 * Reference for X. The bull pen location in the level.
	 * @return position 
	 */
	@Override
	public int refX(){
		return bullpenView.getBounds().x;
	}

	/**
	 * Reference for Y. The Bull pen location in the level. 
	 * @return position
	 */
	@Override
	public int refY(){
		return bullpenView.getBounds().y;
	}
}
