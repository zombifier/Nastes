package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import model.Piece;

public class ModelPieceView extends JPanel {
	
	public ModelPieceView(){
		setBackground(Color.pink);
		for(int i=0;i<35;i++){
			PieceView pieceView = new PieceView(new Piece(0,i));
			Dimension d = pieceView.getPreferredSize();
			pieceView.setBounds((d.width+2)*i,2,d.width,d.height);
			this.add(pieceView);
		}
	}

	@Override
	public Dimension getPreferredSize(){
		PieceView forDim = new PieceView(new Piece(0,0));
		Dimension d = forDim.getPreferredSize();
		return new Dimension((d.width+2)*35,d.height+4);
	}
}
