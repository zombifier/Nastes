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
		setBounds(10, 10, 960, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnLevel = new JButton("Level 1");
		
		JButton btnLevel_1 = new JButton("Level 2 ");
		
		JButton btnLevel_2 = new JButton("Level 3");
		
		JButton btnLevel_3 = new JButton("Level 4");
		
		JButton btnLevel_4 = new JButton("Level 5");
		
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(144, Short.MAX_VALUE)
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
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(116)
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
					.addContainerGap(286, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
