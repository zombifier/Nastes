package view.player;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import model.*;


public class StarView extends JFrame {
	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = -4612010243429368724L;
	
	Level level;
	Game game;
	PlayerApplication app;
	
	String emptyStarDir = "/images/EmptyStar.png";
	String filledStarDir = "/images/FilledStar.png";
	
	public StarView(Level level, Game game, PlayerApplication app){
		this.level = level;
		this.game = game;
		this.app = app;

		setBounds(300, 300, 326, 150);
		setTitle("Result");
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.white);
		
		
		ImageIcon emptyStar = new ImageIcon(this.getClass().getResource(emptyStarDir));
		ImageIcon filledStar = new ImageIcon(this.getClass().getResource(filledStarDir));
		ImageIcon result;
		
		
		int numStar = level.resultStar();
		numStar = 2;
		for(int i = 0; i < 3; i++){
			if(numStar > i)
				result = filledStar;
			else
				result = emptyStar;
			
			JLabel lbl = new JLabel(result);
			lbl.setBounds(i * 102, 0, 100, 100);
			panel.add(lbl);
		}
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//StarView.this.game.setStar(StarView.this.level.getNumLevel(),numStar);
				StarView.this.app.setPanel(new PlayerSelectView(StarView.this.game, StarView.this.app));
				StarView.this.app.setEnabled(true);
				dispose();
			}      
		});
		
		setContentPane(panel);
		
	}
}