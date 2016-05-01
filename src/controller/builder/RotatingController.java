package controller.builder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.BuilderApplication;
import view.PieceView;

public class RotatingController implements KeyListener{
	PieceView pieceView;
	BuilderApplication app;
	int isRelease;
	public RotatingController(PieceView pieceBeingDrag, BuilderApplication app){
		this.pieceView = pieceBeingDrag;
		this.app = app;
		this.isRelease = 0;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (this.isRelease == 0){
			if (e.getKeyChar()=='e'){
				
				System.out.println("clockwise");
				RotatingPieceInBuilder rp = new RotatingPieceInBuilder(this.pieceView.getPiece(),false);
//				if (!rp.valid()){return;}
				rp.doMove();
				this.pieceView.redraw();
				this.app.repaint();	
			}
			if (e.getKeyChar()=='r'){
			
				System.out.println("anti clockwise");
				RotatingPieceInBuilder rp = new RotatingPieceInBuilder(this.pieceView.getPiece(),true);
	//			if (!rp.valid()){return;}
				rp.doMove();
				this.pieceView.redraw();
				this.app.repaint();	
			}
			if (e.getKeyChar()=='q'){
				
				System.out.println("vertical");
				FlipPieceInBuilder fp = new FlipPieceInBuilder(this.pieceView.getPiece(),true);
	//			if (!rp.valid()){return;}
				fp.doMove();
				this.pieceView.redraw();
				this.app.repaint();	
			}
			
			if (e.getKeyChar()=='w'){
				
				System.out.println("horizontal");
				FlipPieceInBuilder fp = new FlipPieceInBuilder(this.pieceView.getPiece(),false);
	//			if (!rp.valid()){return;}
				fp.doMove();
				this.pieceView.redraw();
				this.app.repaint();	
			}
			this.isRelease +=1;
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		this.isRelease = 0;

		System.out.println("release");
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
