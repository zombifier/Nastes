package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * SplashScreen, JPanel for the the first few second.
 * @author Team Nastes
 *
 */
public class SplashScreen extends JPanel {
	
	/**
	 * Create the panel.
	 */
	public SplashScreen() {
		setBackground(Color.PINK);
		
		JLabel lblKabasuji = new JLabel("Kabasuji");
		lblKabasuji.setFont(new Font("Brush Script MT", Font.BOLD, 200));
		lblKabasuji.setForeground(Color.blue);
		
		JLabel lblTeamNastes = new JLabel("Team Nastes");
		lblTeamNastes.setFont(new Font("Tahoma", Font.PLAIN, 32));
		
		JLabel lblSamHuang = new JLabel("Sam Huang");
		lblSamHuang.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel lblDuongNguyen = new JLabel("Duong Nguyen");
		lblDuongNguyen.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel lblKhoiDoan = new JLabel("Khoi Doan");
		lblKhoiDoan.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel lblNewLabel = new JLabel("Chaiwat Ekkaewnumchai");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel lblJeffreyBardon = new JLabel("Jeffrey Bardon");
		lblJeffreyBardon.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(153)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(lblTeamNastes)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblKhoiDoan)
								.addComponent(lblNewLabel)
								.addComponent(lblJeffreyBardon)
								.addComponent(lblSamHuang)
								.addComponent(lblDuongNguyen)))
						.addComponent(lblKabasuji))
					.addContainerGap(113, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(108)
					.addComponent(lblKabasuji)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(79)
							.addComponent(lblKhoiDoan)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel)
							.addGap(13)
							.addComponent(lblJeffreyBardon)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSamHuang)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDuongNguyen))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(138)
							.addComponent(lblTeamNastes)))
					.addContainerGap(140, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
