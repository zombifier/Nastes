package controller.builder;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import view.BuilderApplication;
import view.BullpenView;
import view.PieceView;
import view.SquareView;
import view.TileView;

public class PiecePlayerController extends MouseAdapter{
	BuilderApplication app;
	BullpenView bullpenView;
	PieceView pieceView;
	int diffX;
	int diffY;
	int countPress;
	boolean beingMoved = false;
	public PiecePlayerController(BuilderApplication app, PieceView pieceView){
		super();
		this.app = app;
		this.bullpenView = this.app.getPullpenView();
		this.pieceView = pieceView;
		this.countPress = 0;
	}
	
	@Override
	public void mousePressed(MouseEvent ae){
		if (this.pieceView == null){
			return;
		}
		SquareView s;
		try{
		s = (SquareView) this.pieceView.findComponentAt(ae.getPoint());
		} catch (Exception e){
			System.out.println("Hahaha");
			s = null;
		}
		if (s == null){
			Component source = (Component) ae.getSource();
	        MouseEvent parentEvent = SwingUtilities.convertMouseEvent(source, ae, source.getParent());
	        source.getParent().dispatchEvent(parentEvent);
//	        System.out.println("Hahaha2");
			
		}
		if(s != null){
			if (ae.getModifiers()==InputEvent.BUTTON1_MASK){
				this.beingMoved = true;
				System.out.println("success press, start to move");
				SelectPieceFromBullpen newSelect = new SelectPieceFromBullpen(this.app.getLevel(), this.bullpenView.getBullpen(),this.pieceView.getPiece());
				newSelect.doMove();
				//this.app.repaint();
				//PieceView copyPieceView = new PieceView(this.pieceView.getPiece());
				this.diffX = ae.getX();
				this.diffY = ae.getY();
				this.bullpenView.remove(this.pieceView);
				
		//		ae.translatePoint(ae.getComponent().getLocation().x, ae.getComponent().getLocation().y);
				this.app.setMovingPiece(this.countPress,this.pieceView,ae.getComponent().getLocation().x,ae.getComponent().getLocation().y);
				this.countPress = 1;
				//		this.bullpenView.repaint();
				//copyPieceView.setBounds(ae.getX(),ae.getY(),270,270);
				//this.playerGame.add(pieceView);
				//bullpenView.remove(pieceView);
		//		for (int i=0;i<=6;i++){
		//		this.app.setComponentZOrder(ae.getComponent(), 0);
		//		}
				//Point p = new Point (ae.getX() - pieceView.getX(), ae.getY() - pieceView.getY());
			}
			if (ae.getModifiers()==InputEvent.BUTTON3_MASK){
				this.pieceView.getParent().remove(this.pieceView);
				this.app.repaint();
			}
			
		} 
	}
	
	@Override
	public void mouseDragged(MouseEvent ae){
		if (this.beingMoved){
			this.bullpenView.repaint();
//			System.out.println("being Move");
			ae.translatePoint(ae.getComponent().getLocation().x-diffX, ae.getComponent().getLocation().y-diffY);
			this.app.updateMovePiece(this.pieceView, ae.getX(),ae.getY());
			//this.pieceView.setLocation(ae.getX(),ae.getY());
//	
//			System.out.println("" + (ae.getX())+" "+(ae.getY()));
			//pieceView.setLocation(ae.getX(),ae.getY());
		}
		
		
	}
	@Override
	public void mouseReleased(MouseEvent ae){
		this.beingMoved=false;
	}
	
}
