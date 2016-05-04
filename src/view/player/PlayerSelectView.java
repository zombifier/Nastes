package view.player;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.*;

/**
 * PlayerSelectView 
 * @author Team Nastes
 *
 */
public class PlayerSelectView extends JPanel {
	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = -8544625318432363920L;
	
	Game game;
	PlayerApplication app;

	String emptyStarDir = "/images/SmallEmptyStar.png";
	String filledStarDir = "/images/SmallFilledStar.png";
	ImageIcon emptyStar;
	ImageIcon filledStar;
	
	/**
	 * Constructor for PlayerSelectview
	 * Game game
	 * PlayerApplication app
	 * @param game	Game
	 * @param app Builder Application
	 */
	public PlayerSelectView(Game game, PlayerApplication app){
		emptyStar = new ImageIcon(this.getClass().getResource(emptyStarDir));
		filledStar = new ImageIcon(this.getClass().getResource(filledStarDir));
		
		this.game = game;
		this.app = app;
		
		ImageIcon resultStar;
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		setBounds(0,0,817,593);
		

		JLabel lblKabasuji = new JLabel("Kabasuji");
		lblKabasuji.setFont(new Font("Brush Script MT", Font.BOLD, 72));
		lblKabasuji.setForeground(Color.black);
		lblKabasuji.setVerticalAlignment(JLabel.CENTER);
		lblKabasuji.setHorizontalAlignment(JLabel.CENTER);
		lblKabasuji.setBounds(0, 20, 817, 80);
		add(lblKabasuji);
		
		// Set levels to be selected
		for(int i=0;i<3;i++)
			for(int j=0;j<5;j++){
				JButton levelButton = new JButton();
				levelButton.setLayout(null);
				levelButton.setBounds(36 + 150 * j, 130 + 150 * i, 140, 140);

				final int k=5*i+j;

				JLabel levelLabel = new JLabel();
				levelLabel.setFont(new Font("Consolas", Font.BOLD, 32));
				levelLabel.setHorizontalAlignment(JLabel.CENTER);
				levelLabel.setVerticalAlignment(JLabel.CENTER);
				levelLabel.setText(Integer.toString(k + 1));
				levelLabel.setBounds(0, 10, 140, 40);
				levelButton.add(levelLabel);

				int stars = game.getLevel(k).getStar();
				for(int c = 0; c < 3; c++){
					if(stars > c)
						resultStar = filledStar;
					else
						resultStar = emptyStar;
					levelLabel = new JLabel(resultStar);
					levelLabel.setBounds(4 + 44 * c, 80 - (c % 2) * 20, 44, 44);
					levelButton.add(levelLabel);
				}
				Color colorButton;
				if(game.getLevel(k).isPlayable())
					colorButton = Color.green;
				else
					colorButton = Color.red;

				levelButton.setBackground(colorButton);
				levelButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){
						Level level = game.getLevel(k);
						if(level != null && level.isPlayable())
							PlayerSelectView.this.app.setPanel(new PlayerLevelView(game, level, app));
					}
				});
				add(levelButton);
			}
		
	}
}
