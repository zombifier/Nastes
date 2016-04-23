package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Dimension;

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
		
		setBackground(new Color(221, 160, 221));
		setPreferredSize(new Dimension(430,600));
<<<<<<< HEAD
		setLayout(null);
=======
>>>>>>> branch 'master' of https://github.com/zombifier/Nastes.git
		
<<<<<<< HEAD
		PieceView pieceView = new PieceView(new Piece(1,3));
		pieceView.setBounds(10, 10, 270, 270);
		add(pieceView);
		PieceView pieceView2 = new PieceView(new Piece(1,14));
		pieceView2.setBounds(10+100, 10+80, 270, 270);
		add(pieceView2);
//		PieceView pieceView_1 = new PieceView(new Piece(2,1));
//		add(pieceView_1);
//		PieceView pieceView_2 = new PieceView(new Piece(3,2));
//		add()
=======
		PieceView pieceView = new PieceView(null);
>>>>>>> branch 'master' of https://github.com/zombifier/Nastes.git
		
<<<<<<< HEAD
=======
		PieceView pieceView_1 = new PieceView(null);
		
		PieceView pieceView_2 = new PieceView(null);
		
		JLabel lblThisIsBullpenview = new JLabel("This is BullPenView");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(pieceView_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(pieceView_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(180)
							.addComponent(lblThisIsBullpenview))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(pieceView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblThisIsBullpenview)
					.addGap(18)
					.addComponent(pieceView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(pieceView_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addComponent(pieceView_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
		);
		setLayout(groupLayout);
>>>>>>> branch 'master' of https://github.com/zombifier/Nastes.git

	}
}
