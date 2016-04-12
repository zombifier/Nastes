package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LevelSelector extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelSelector frame = new LevelSelector();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LevelSelector() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnLevel = new JButton("Level 1");
		btnLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlayerWindow nw = new PlayerWindow();
				nw.newscreen();
				
			}
		});
		
		JButton btnLevel_1 = new JButton("Level 2 ");
		
		JButton btnLevel_2 = new JButton("Level 3");
		
		JButton btnLevel_3 = new JButton("Level 4");
		
		JButton btnLevel_4 = new JButton("Level5");
		
		JButton btnLevel_5 = new JButton("Level 6");
		
		JButton btnLevel_6 = new JButton("Level 7");
		
		JButton btnLevel_7 = new JButton("Level 8");
		
		JButton btnLevel_8 = new JButton("Level 9");
		
		JButton btnLevel_9 = new JButton("Level 10");
		
		JButton btnLevel_10 = new JButton("Level 11");
		
		JButton btnLevel_11 = new JButton("Level 12");
		
		JButton btnLevel_12 = new JButton("Level 13");
		
		JButton btnLevel_13 = new JButton("Level 14");
		
		JButton btnLevel_14 = new JButton("Level 15");
		
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
		
		JTextPane txtpnTotalStar = new JTextPane();
		txtpnTotalStar.setText("Total Star: 0/45");
		
		JTextPane txtpnKabasuji = new JTextPane();
		txtpnKabasuji.setText("Kabasuji");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(144, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
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
									.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
							.addGap(169))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(txtpnTotalStar, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
							.addGap(333))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(txtpnKabasuji, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
							.addGap(335))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtpnKabasuji, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(65)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnLevel_4)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_14, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
							.addGap(23)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnLevel_9)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_9, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
							.addGap(28)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnLevel_14)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnLevel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_13, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
								.addGap(23)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnLevel_8)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
								.addGap(28)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnLevel_13)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnLevel)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(panel_10, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
									.addGap(23)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnLevel_5)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
									.addGap(28)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnLevel_10)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
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
					.addContainerGap(143, Short.MAX_VALUE))
		);
		
		JTextPane textPane_13 = new JTextPane();
		textPane_13.setText("# Star Unlock");
		panel_14.add(textPane_13);
		
		JTextPane textPane_12 = new JTextPane();
		textPane_12.setText("# Star Unlock");
		panel_9.add(textPane_12);
		
		JTextPane textPane_11 = new JTextPane();
		textPane_11.setText("# Star Unlock");
		panel_4.add(textPane_11);
		
		JTextPane textPane_10 = new JTextPane();
		textPane_10.setText("# Star Unlock");
		panel_3.add(textPane_10);
		
		JTextPane textPane_9 = new JTextPane();
		textPane_9.setText("# Star Unlock");
		panel_2.add(textPane_9);
		
		JTextPane textPane_8 = new JTextPane();
		textPane_8.setText("# Star Unlock");
		panel_1.add(textPane_8);
		
		JTextPane textPane_7 = new JTextPane();
		textPane_7.setText("# Star Unlock");
		panel.add(textPane_7);
		
		JTextPane textPane_6 = new JTextPane();
		textPane_6.setText("# Star Unlock");
		panel_8.add(textPane_6);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setText("# Star Unlock");
		panel_7.add(textPane_5);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setText("# Star Unlock");
		panel_6.add(textPane_4);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setText("# Star Unlock");
		panel_5.add(textPane_3);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setText("# Star Unlock");
		panel_13.add(textPane_2);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("# Star Unlock");
		panel_12.add(textPane_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("# Star Unlock");
		panel_11.add(textPane);
		
		JTextPane txtpnStarUnlock = new JTextPane();
		txtpnStarUnlock.setText("# Star Unlock");
		panel_10.add(txtpnStarUnlock);
		contentPane.setLayout(gl_contentPane);
	}
}
