package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import controller.ReturnSelectLevel;

public class PlayerGame extends JPanel {
	PlayerApplication app;
	
	public PlayerGame(PlayerApplication app){
		this.app=app;
		
		setBounds(10, 10, 960, 720);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ReturnSelectLevel(app));
		
		JButton btnReset = new JButton("Reset");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(btnBack)
					.addPreferredGap(ComponentPlacement.RELATED, 750, Short.MAX_VALUE)
					.addComponent(btnReset)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(btnReset))
					.addContainerGap(624, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
