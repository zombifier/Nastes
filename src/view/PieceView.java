package view;

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
		SquareView dummySquareView = new SquareView();
		for(int i=0;i<=5;i++){
			squareView[i] = new SquareView();
			squareView[i].setBounds(dummySquareView.getWidth()*piece.getSquares()[i].getX(),dummySquareView.getHeight()*piece.getSquares()[i].getY(),45,45);
			add(squareView[i]);
		}
		
	}
}
