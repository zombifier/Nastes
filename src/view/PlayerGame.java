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
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class PlayerGame extends JPanel {
	PlayerApplication app;
	
	public PlayerGame(PlayerApplication app){
		this.app=app;
		
		setBounds(10, 10, 1280, 720);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ReturnSelectLevel(app));
		
		JButton btnReset = new JButton("Reset");
		
		JButton btnHint = new JButton("Hint");
		
		JTextPane txtpnType = new JTextPane();
		txtpnType.setText("Type");
		
		JTextPane txtpnLevelNumber = new JTextPane();
		txtpnLevelNumber.setText("Level Number");
		
		JTextPane txtpnLimit = new JTextPane();
		txtpnLimit.setText("Limit");
		
		BoardView boardView_1 = new BoardView();
		
		BullpenView bullpenView = new BullpenView();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(btnBack)
							.addGap(110)
							.addComponent(btnHint)
							.addGap(116)
							.addComponent(txtpnType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(91)
							.addComponent(txtpnLevelNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(txtpnLimit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 555, Short.MAX_VALUE)
							.addComponent(btnReset))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(boardView_1, GroupLayout.PREFERRED_SIZE, 697, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(bullpenView, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnBack)
							.addComponent(btnReset)
							.addComponent(btnHint))
						.addComponent(txtpnType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnLevelNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnLimit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(boardView_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(bullpenView, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		
		
		
		setLayout(groupLayout);
		
	}
}
