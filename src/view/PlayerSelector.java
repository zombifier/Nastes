package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import controller.SelectLevel;
import model.*;

public class PlayerSelector extends JPanel {
	
	PlayerApplication app;
	Game game;
	
	public PlayerSelector(Game game, PlayerApplication app){
		this.app = app;
		this.game = game;
		
		setBounds(10, 10, 1280, 720);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton btnLevel = new JButton("Level 1");
		btnLevel.addActionListener(new SelectLevel(this.game.getLevel(0), game, app));
		
		JButton btnLevel_1 = new JButton("Level 2");
		btnLevel_1.addActionListener(new SelectLevel(this.game.getLevel(1), game, app));
		
		JButton btnLevel_2 = new JButton("Level 3");
		btnLevel_2.addActionListener(new SelectLevel(this.game.getLevel(2), game, app));
		
		JButton btnLevel_3 = new JButton("Level 4");
		btnLevel_3.addActionListener(new SelectLevel(this.game.getLevel(3), game, app));
		
		JButton btnLevel_4 = new JButton("Level 5");
		btnLevel_4.addActionListener(new SelectLevel(this.game.getLevel(4), game, app));
		
		JButton btnLevel_5 = new JButton("Level 6");
		btnLevel_5.addActionListener(new SelectLevel(this.game.getLevel(5), game, app));
		
		JButton btnLevel_6 = new JButton("Level 7");
		btnLevel_6.addActionListener(new SelectLevel(this.game.getLevel(6), game, app));
		
		JButton btnLevel_7 = new JButton("Level 8");
		btnLevel_7.addActionListener(new SelectLevel(this.game.getLevel(7), game, app));
		
		JButton btnLevel_8 = new JButton("Level 9");
		btnLevel_8.addActionListener(new SelectLevel(this.game.getLevel(8), game, app));
		
		JButton btnLevel_9 = new JButton("Level 10");
		btnLevel_9.addActionListener(new SelectLevel(this.game.getLevel(9), game, app));
		
		JButton btnLevel_10 = new JButton("Level 11");
		btnLevel_10.addActionListener(new SelectLevel(this.game.getLevel(10), game, app));
		
		JButton btnLevel_11 = new JButton("Level 12");
		btnLevel_11.addActionListener(new SelectLevel(this.game.getLevel(11), game, app));
		
		JButton btnLevel_12 = new JButton("Level 13");
		btnLevel_12.addActionListener(new SelectLevel(this.game.getLevel(12), game, app));
		
		JButton btnLevel_13 = new JButton("Level 14");
		btnLevel_13.addActionListener(new SelectLevel(this.game.getLevel(13), game, app));
		
		JButton btnLevel_14 = new JButton("Level 15");
		btnLevel_14.addActionListener(new SelectLevel(this.game.getLevel(14), game, app));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.PINK);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.PINK);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.PINK);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.PINK);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.PINK);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.PINK);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.PINK);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.PINK);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.PINK);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.PINK);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.PINK);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.PINK);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.PINK);
		
		JLabel txtpnTotalStar = new JLabel();
		txtpnTotalStar.setText("Total Star: 0/45");
		
		JLabel txtpnKabasuji = new JLabel();
		txtpnKabasuji.setText("Kabasuji");
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(331, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnLevel)
								.addComponent(btnLevel_5)
								.addComponent(btnLevel_10)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_10, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
							.addGap(51)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnLevel_1)
										.addComponent(panel_11, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnLevel_6)
										.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(btnLevel_11)
									.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
							.addGap(40)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnLevel_2)
								.addComponent(panel_12, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLevel_7)
								.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLevel_12)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
							.addGap(63)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnLevel_3)
								.addComponent(panel_13, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLevel_8)
								.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLevel_13)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(1)
									.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
							.addGap(70)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnLevel_4)
									.addComponent(panel_14, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnLevel_9)
									.addComponent(panel_9, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnLevel_14)
									.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtpnTotalStar, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
							.addGap(164))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtpnKabasuji, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
							.addGap(166)))
					.addGap(320))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(116, Short.MAX_VALUE)
					.addComponent(txtpnKabasuji, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(65)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnLevel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_14, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(btnLevel_9)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_9, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(btnLevel_14)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnLevel_3)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_13, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addGap(23)
								.addComponent(btnLevel_8)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addGap(28)
								.addComponent(btnLevel_13)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnLevel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_10, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
									.addGap(23)
									.addComponent(btnLevel_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
									.addGap(28)
									.addComponent(btnLevel_10)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnLevel_2)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(panel_12, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnLevel_1)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(panel_11, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
									.addGap(23)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnLevel_7)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnLevel_6)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
									.addGap(28)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnLevel_11)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnLevel_12)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))))))
					.addGap(110)
					.addComponent(txtpnTotalStar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(87))
		);
		
		JLabel textPane_13 = new JLabel();
		textPane_13.setText("# Star Unlock");
		panel_14.add(textPane_13);
		
		JLabel textPane_12 = new JLabel();
		textPane_12.setText("# Star Unlock");
		panel_9.add(textPane_12);
		
		JLabel textPane_11 = new JLabel();
		textPane_11.setText("# Star Unlock");
		panel_4.add(textPane_11);
		
		JLabel textPane_10 = new JLabel();
		textPane_10.setText("# Star Unlock");
		panel_3.add(textPane_10);
		
		JLabel textPane_9 = new JLabel();
		textPane_9.setText("# Star Unlock");
		panel_2.add(textPane_9);
		
		JLabel textPane_8 = new JLabel();
		textPane_8.setText("# Star Unlock");
		panel_1.add(textPane_8);
		
		JLabel textPane_7 = new JLabel();
		textPane_7.setText("# Star Unlock");
		panel.add(textPane_7);
		
		JLabel textPane_6 = new JLabel();
		textPane_6.setText("# Star Unlock");
		panel_8.add(textPane_6);
		
		JLabel textPane_5 = new JLabel();
		textPane_5.setText("# Star Unlock");
		panel_7.add(textPane_5);
		
		JLabel textPane_4 = new JLabel();
		textPane_4.setText("# Star Unlock");
		panel_6.add(textPane_4);
		
		JLabel textPane_3 = new JLabel();
		textPane_3.setText("# Star Unlock");
		panel_5.add(textPane_3);
		
		JLabel textPane_2 = new JLabel();
		textPane_2.setText("# Star Unlock");
		panel_13.add(textPane_2);
		
		
		JLabel textPane_1 = new JLabel();
		textPane_1.setText("# Star Unlock");
		panel_12.add(textPane_1);
		
		JLabel textPane = new JLabel();
		textPane.setText("# Star Unlock");
		panel_11.add(textPane);
		
		JLabel txtpnStarUnlock = new JLabel();
		txtpnStarUnlock.setText("# Star Unlock");
		panel_10.add(txtpnStarUnlock);
		setLayout(gl_contentPane);
	}
}
