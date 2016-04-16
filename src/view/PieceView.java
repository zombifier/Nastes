package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

public class PieceView extends JPanel {

	/**
	 * Create the panel.
	 */
	public PieceView() {
		setBackground(Color.GREEN);
		
		JLabel lblThisIsA = new JLabel("This is a Piece View");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addComponent(lblThisIsA)
					.addContainerGap(49, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblThisIsA)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
