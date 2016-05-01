package controller.builder;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import model.Piece;
import view.BuilderApplication;
import view.BullpenView;
import view.PieceView;
import view.PlayerGame;

public class PieceController extends MouseAdapter{
	BuilderApplication app;
	BullpenView bullpenView;
	PieceView pieceView;
	
	public PieceController(BuilderApplication app, PieceView pieceView){
		super();
		this.app = app;
		this.bullpenView = this.app.getPullpenView();
		this.pieceView = pieceView;
	}
	
	@Override
	public void mousePressed(MouseEvent ae){
		if (this.pieceView == null){
			return;
		}
		
		System.out.println("success test");
		AddPieceFromScrollToBullpen newAdd = new AddPieceFromScrollToBullpen(this.pieceView.getPiece(), this.pieceView, this.bullpenView.getBullpen(), this.bullpenView);
		if (newAdd.doMove()) {
			app.addMove(newAdd);
		}
		
		//this.app.repaint();
		//PieceView copyPieceView = new PieceView(this.pieceView.getPiece());
		//this.bullpenView.drawPieceView(copyPieceView);
		//this.app.player.setPieceBeingDrag(pieceView.getPiece());
		//copyPieceView.setBounds(ae.getX(),ae.getY(),270,270);
		//this.playerGame.add(pieceView);
		//bullpenView.remove(pieceView);
		
		//Point p = new Point (ae.getX() - pieceView.getX(), ae.getY() - pieceView.getY());
		
	}
	
	@Override
	public void mouseDragged(MouseEvent ae){
		ae.translatePoint(ae.getComponent().getLocation().x-pieceView.getX(), ae.getComponent().getLocation().y-pieceView.getY());
		pieceView.setLocation(ae.getX(),ae.getY());
	}
	
}
