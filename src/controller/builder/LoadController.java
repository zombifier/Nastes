package controller.builder;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.*;
import view.*;

/**
 * LoadController class.
 * Handles loading the selected level.
 * @author Team Nastes
 */
public class LoadController {
	Game game;
	BuilderApplication builderApplication;
	
	/**
	 * LoadController constructor. Initializes the values of game and builderApp.
	 * @param game Game
	 * @param builderApplication BuilderApplication
	 */
	public LoadController(Game game, BuilderApplication builderApplication){
		this.game = game;
		this.builderApplication = builderApplication;
	}
	
	/**
	 * process()
	 * Actually handles the loading of the level.
	 */
	public void process(){

		final JFrame selectNumLevel= new JFrame();

		selectNumLevel.setTitle("Load");
		selectNumLevel.setLayout(null);
		selectNumLevel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		selectNumLevel.setPreferredSize(new Dimension(2 + 52 * 5 + 50, 2 + 52 * 3 + 50));
		Dimension d = selectNumLevel.getPreferredSize();
		selectNumLevel.setBounds(300, 300, d.width, d.height);
		selectNumLevel.setVisible(true);
		
		//Find out which button was selected for loading.
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 5; j++){
				JButton button = new JButton();
				button.setBounds(2 + j * 52, 2 + i * 52, 50, 50);
				final int value = 5 * i + j;
				button.setText(Integer.toString(value+1));
				button.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent ae){
						Level level = game.getLevel(value); 
						if(level != null){
							builderApplication.initialize(level);
						}
						selectNumLevel.dispose();
					}
				});
				selectNumLevel.add(button);
			}
		
	}
}
