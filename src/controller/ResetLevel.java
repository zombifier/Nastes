package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.*;

/**
 * ResetLevel class.
 * Handles resetting a level.
 * @author Team Nastes
 */
public class ResetLevel implements ActionListener {
	Level level;
	Game game;
	PlayerApplication app;
	
	/**
	 * ResetLevel constructor. Initializes the values of level, app and game.
	 * @param level
	 * @param game
	 * @param app
	 */
	public ResetLevel(Level level, Game game, PlayerApplication app){
		this.level = level;
		this.app = app;
		this.game = game;
	}

	/**
	 * Rather than do anything clever, just create a new game with the specified level.
	 * Can this be undone?
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		app.updatePanel(new PlayerGame(level, game, app));
	}
}
