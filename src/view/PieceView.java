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
	/**
	 * getter method for get piece for controller
	 * @return object piece
	 */
	public Piece getPiece(){
		return this.piece;
	}
	
	public SquareView[] getSquare(){
		return squareView;
	}
	
	public void redraw(){
		int minX = 0;
		int minY = 0;
		for (int i=0;i<=5;i++){
			if (minX>this.piece.getSquares()[i].getX()){
				minX = this.piece.getSquares()[i].getX();
			}
			if (minY>this.piece.getSquares()[i].getY()){
				minY = this.piece.getSquares()[i].getY();
				
			}
			
		}
		int maxPrefferX = 0;
		int maxPrefferY = 0;
		for(int i=0;i<=5;i++){
			squareView[i].setLocation(45*piece.getSquares()[i].getX()-minX*45,45*piece.getSquares()[i].getY()-minY*45);
			if (maxPrefferX < 45*piece.getSquares()[i].getX()-minX*45 ){
				maxPrefferX = 45*piece.getSquares()[i].getX()-minX*45;
			}
			if (maxPrefferY < 45*piece.getSquares()[i].getY()-minY*45 ){
				maxPrefferY = 45*piece.getSquares()[i].getY()-minY*45;
			}
			
			this.repaint();
		}
		this.setPreferredSize(new Dimension(maxPrefferX, maxPrefferY));
		
	}
}
