package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import controller.builder.PieceController;
import model.Piece;

/**
 * ModelPieceView
 * Contains: 
 * BuilderApplication 
 * @author Team Nastes 
 *
 */
public class ModelPieceView extends JPanel {
	BuilderApplication app;
	public ModelPieceView(BuilderApplication app){
		this.app = app;
		setBackground(Color.pink);
		for(int i=0;i<35;i++){
			PieceView pieceView = new PieceView(new Piece(0,i));
			Dimension d = pieceView.getPreferredSize();
			pieceView.setBounds((d.width+2)*i,2,d.width,d.height);
			this.add(pieceView);
			pieceView.addMouseListener(new PieceController(this.app,pieceView));
		}
	}

	@Override
	public Dimension getPreferredSize(){
		PieceView forDim = new PieceView(new Piece(0,0));
		Dimension d = forDim.getPreferredSize();
		return new Dimension((d.width+2)*35,d.height+4);
	}
}
