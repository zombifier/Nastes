package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

public class BoardView extends JPanel {

	/**
	 * Create the panel.
	 */
	public BoardView() {
		setBackground(Color.PINK);
		
		JPanel panel = new JPanel();
		
		JButton btnTuturu = new JButton("Tuturu !");
		
		JLabel lblThisIsBoardview = new JLabel("This is BoardView");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(88)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(465, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(81, Short.MAX_VALUE)
					.addComponent(lblThisIsBoardview)
					.addGap(18)
					.addComponent(btnTuturu)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(btnTuturu))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblThisIsBoardview)))
					.addGap(28)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(358, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
