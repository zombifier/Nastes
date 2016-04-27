package controller.builder;

import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;

import model.*;
import view.*;

/**
 * SaveController class.
 * 
 * @author Team Nastes
 */
public class SaveController {
	Game game;
	Level level;
	BuilderApplication builderApplication;
	
	/**
	 * SaveController constructor. Initializes the values of game, level and builderApp
	 * @param game
	 * @param level
	 * @param builderApplication
	 */
	public SaveController(Game game, Level level, BuilderApplication builderApplication){
		this.game = game;
		this.level = level;
		this.builderApplication = builderApplication;
	}
	
	/**
	 * process()
	 * Actually saves the level in question.
	 */
	public void process(){
		final JFrame selectNumLevel= new JFrame();

		selectNumLevel.setTitle("Save");
		selectNumLevel.setLayout(null);
		selectNumLevel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		selectNumLevel.setPreferredSize(new Dimension(2 + 52 * 5 + 50, 2 + 52 * 3 + 50));
		Dimension d = selectNumLevel.getPreferredSize();
		selectNumLevel.setBounds(300, 300, d.width, d.height);
		selectNumLevel.setVisible(true);
		
		//Find out which button was selected for saving.
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 5; j++){
				JButton button = new JButton();
				button.setBounds(2 + j * 52, 2 + i * 52, 50, 50);
				final int value = 5 * i + j;
				button.setText(Integer.toString(value+1));
				button.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent ae){
						game.setLevel(value, level.copy());
						selectNumLevel.dispose();
					}
				});
				selectNumLevel.add(button);
			}
	}
	
}
