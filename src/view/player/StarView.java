package view.player;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import model.*;


/**
 * StarView
 * @author Team Nastes
 *
 */
public class StarView extends JFrame {

	private static final long serialVersionUID = -4612010243429368724L;
	
	Level level;
	Game game;
	PlayerApplication app;
	
	String emptyStarDir = "/images/EmptyStar.png";
	String filledStarDir = "/images/FilledStar.png";
	
	/**
	 * StarView
	 * Level level
	 * Game game
	 * PlayerApplication app
	 * @param level
	 * @param game
	 * @param app
	 */
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
		
		
		final int numStar = level.resultStar();
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
				StarView.this.game.setStar(Integer.parseInt(StarView.this.level.getLevelNum().substring(1)), numStar);
				StarView.this.app.setPanel(new PlayerSelectView(StarView.this.game, StarView.this.app));
				StarView.this.app.setEnabled(true);
				dispose();
			}      
		});
		
		setContentPane(panel);
		
	}
}
