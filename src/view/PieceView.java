package view;

import java.awt.Dimension;

import javax.swing.JPanel;

import model.Piece;


public class PieceView extends JPanel{
	Piece piece;
	SquareView squareView[] = new SquareView[6]; 
	/**
	 * Create the panel.
	 */
	public PieceView(Piece piece) {
		this.piece = piece;
		if(this.piece != null)
			this.initialize();
	}
	
	void initialize(){
		setLayout(null);
		
		setOpaque(false);
		
		for(int i=0;i<=5;i++){
			squareView[i] = new SquareView();
			squareView[i].setBounds(45*piece.getSquares()[i].getX(),45*piece.getSquares()[i].getY(),45,45);
			add(squareView[i]);
		}
		
	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(45*6,45*6); // The smallest size that can keep long hexomino
	}
}
