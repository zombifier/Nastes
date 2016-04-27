package view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.*;

import model.*;
import javax.swing.GroupLayout.Alignment;

public class StarView extends JFrame {

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
		
		setContentPane(panel);
		
	}
}
