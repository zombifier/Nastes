package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SplashScreen extends JPanel {
	
	/**
	 * Create the panel.
	 */
	public SplashScreen() {
		setBackground(Color.PINK);
		
		JLabel lblKabasuji = new JLabel("Kabasuji");
		lblKabasuji.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		JLabel lblTeamNastes = new JLabel("Team Nastes");
		lblTeamNastes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblSamHuang = new JLabel("Sam Huang");
		
		JLabel lblDuongNguyen = new JLabel("Duong Nguyen");
		
		JLabel lblKhoiDoan = new JLabel("Khoi Doan");
		
		JLabel lblNewLabel = new JLabel("Chaiwat Ekkaewnumchai");
		
		JLabel lblJeffreyBardon = new JLabel("Jeffrey Bardon");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(546, Short.MAX_VALUE)
					.addComponent(lblKabasuji)
					.addGap(506))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(263)
					.addComponent(lblTeamNastes)
					.addGap(342)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblJeffreyBardon)
						.addComponent(lblNewLabel)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblDuongNguyen)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblSamHuang)
								.addGap(16)))
						.addComponent(lblKhoiDoan))
					.addContainerGap(352, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(164)
					.addComponent(lblKabasuji)
					.addGap(105)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTeamNastes)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSamHuang)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDuongNguyen)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblKhoiDoan)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblJeffreyBardon)
					.addContainerGap(294, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
