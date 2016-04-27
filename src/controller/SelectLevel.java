package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.*;

/**
 * SelectLevel class.
 * Allows the player to select a level from the level selector.
 * @author Team Nastes
 */
public class SelectLevel implements ActionListener {
	PlayerApplication app;
	Level level;
	Game game;

	/**
	 * Select Level constructor. Initializes app, level and game.
	 * @param level
	 * @param game
	 * @param app
	 */
	public SelectLevel(Level level, Game game, PlayerApplication app){
		this.app = app;
		this.level = level;
		this.game = game;
	}
	
	/**
	 * Opens the selected level.
	 * Note that level must be passed in.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		app.updatePanel(new PlayerGame(level, game, app));
		System.out.println("Clicked");
	}
}
