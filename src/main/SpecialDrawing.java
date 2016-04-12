package main;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SpecialDrawing extends JPanel {

	/**
	 * Create the panel.
	 */
	public SpecialDrawing() {
		setBackground(Color.ORANGE);
		
		JButton btnTuturu = new JButton("Tuturu");
		
		JButton btnTuturu_1 = new JButton("TUturu");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addComponent(btnTuturu)
					.addContainerGap(587, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(569, Short.MAX_VALUE)
					.addComponent(btnTuturu_1)
					.addGap(55))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(btnTuturu)
					.addPreferredGap(ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
					.addComponent(btnTuturu_1)
					.addContainerGap())
		);
		setLayout(groupLayout);

	}

}
