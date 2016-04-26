package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

import javax.swing.LayoutStyle.ComponentPlacement;

import model.*;

import javax.swing.JLabel;

public class BullpenView extends JPanel {

	Bullpen bullpen;
	
	/**
	 * Create the panel.
	 */
	public BullpenView(Bullpen bullpen) {
		this.bullpen = bullpen;
		
		if(this.bullpen == null)
			this.bullpen = new Bullpen();
		
		setBackground(new Color(221, 160, 221));
		setPreferredSize(new Dimension(430,600));
		setLayout(null);
		
		Random rand = new Random();
		
		for(Piece piece: bullpen.getPieces()){
			PieceView pieceView = new PieceView(piece);
			Dimension d = pieceView.getPreferredSize();
			pieceView.setBounds(rand.nextInt(this.getPreferredSize().width), rand.nextInt(this.getPreferredSize().height), d.width, d.height);
			add(pieceView);
		}
		
		/*
		PieceView pieceView = new PieceView(new Piece(1,3));
		pieceView.setBounds(10, 10, 270, 270);
		add(pieceView);
		PieceView pieceView2 = new PieceView(new Piece(1,14));
		pieceView2.setBounds(10+100, 10+80, 270, 270);
		add(pieceView2);*/
		
//		PieceView pieceView_1 = new PieceView(new Piece(2,1));
//		add(pieceView_1);
//		PieceView pieceView_2 = new PieceView(new Piece(3,2));
//		add()

	}
}
