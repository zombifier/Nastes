package controller.player;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import model.*;
import view.player.*;

public class BullpenController extends LevelController {
	
	// Constant
	final public static int offset = 2;
	final public static int tileSize = 40;
	final public static int eachSize = offset + tileSize;
	
	Bullpen bullpen;
	BullpenView bullpenView;
	
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
							point=new Point(point.x + yBoard * eachSize,
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

	@Override
	public int refX(){
		return bullpenView.getBounds().x;
	}

	@Override
	public int refY(){
		return bullpenView.getBounds().y;
	}
}
