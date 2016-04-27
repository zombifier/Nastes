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

import controller.ResetLevel;
import controller.ReturnSelectLevel;
import model.*;

import java.awt.Color;
import java.awt.ComponentOrientation;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class PlayerGame extends JPanel {
	PlayerApplication app;
	Level level;
	Level original;
	
	public PlayerGame(Level level, Game game, PlayerApplication app){
		this.app = app;
		this.level = level;
		this.original = level.copy();
		
		setBounds(10, 10, 1280, 768);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ReturnSelectLevel(game, app));
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ResetLevel(original, game, app));
		
		JButton btnHint = new JButton("Hint");
		
		JLabel txtpnType = new JLabel();
		txtpnType.setText("Type");
		
		JLabel txtpnLevelNumber = new JLabel();
		txtpnLevelNumber.setText("Level Number");
		
		JLabel txtpnLimit = new JLabel();
		txtpnLimit.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		txtpnLimit.setText(this.level.getLimit());
		
		BoardView boardView_1 = new BoardView(this.level.getBoard());
		
		BullpenView bullpenView = new BullpenView(this.level.getBullpen());
		
		JLabel txtpnUnit = new JLabel();
		txtpnUnit.setText(this.level.getUnit());
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
							.addComponent(txtpnType)
							.addGap(91)
							.addComponent(txtpnLevelNumber)
							.addGap(27)
							.addComponent(txtpnLimit)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtpnUnit, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 468, Short.MAX_VALUE)
							.addComponent(btnReset))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(boardView_1, GroupLayout.PREFERRED_SIZE, 699, GroupLayout.PREFERRED_SIZE)
							.addGap(54)
							.addComponent(bullpenView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
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
						.addComponent(txtpnType)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtpnLevelNumber)
							.addComponent(txtpnLimit)
							.addComponent(txtpnUnit, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(boardView_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bullpenView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(91))
		);
		
		
		
		setLayout(groupLayout);
		
	}
}
