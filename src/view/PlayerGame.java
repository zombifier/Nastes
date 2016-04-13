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

public class PlayerGame extends JPanel {
	PlayerApplication app;
	
	public PlayerGame(PlayerApplication app){
		this.app=app;
		
		setBounds(10, 10, 1280, 720);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ReturnSelectLevel(app));
		
		JButton btnReset = new JButton("Reset");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		
		JButton btnHint = new JButton("Hint");
		
		JTextPane txtpnType = new JTextPane();
		txtpnType.setText("Type");
		
		JTextPane txtpnLevelNumber = new JTextPane();
		txtpnLevelNumber.setText("Level Number");
		
		JTextPane txtpnLimit = new JTextPane();
		txtpnLimit.setText("Limit");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
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
							.addPreferredGap(ComponentPlacement.RELATED, 550, Short.MAX_VALUE)
							.addComponent(btnReset))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 705, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 501, GroupLayout.PREFERRED_SIZE)))
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
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 622, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JLabel lblPieceWillBe = new JLabel("Pieces will be here first");
		
		JLabel lblBullpen = new JLabel("Bullpen");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(153)
							.addComponent(lblPieceWillBe))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(182)
							.addComponent(lblBullpen)))
					.addContainerGap(210, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBullpen)
					.addGap(177)
					.addComponent(lblPieceWillBe)
					.addContainerGap(400, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblBoardHere = new JLabel("Board here");
		panel.add(lblBoardHere);
		setLayout(groupLayout);
	}
}
