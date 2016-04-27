package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.PlayerApplication;
import view.PlayerSelector;

/**
 * ReturnSelectLevel class.
 * Handles taking the player back to the level selection menu.
 * @author Team Nastes
 */
public class ReturnSelectLevel implements ActionListener {
	PlayerApplication app;
	Game game;

	/**
	 * ReturnSelectLevel constructor. Initializes the values of app and game.
	 * @param game
	 * @param app
	 */
	public ReturnSelectLevel(Game game, PlayerApplication app){
		this.app = app;
		this.game = game;
	}
	
	/**
	 * No need to remember current level progress.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		app.updatePanel(new PlayerSelector(game, app));
		System.out.println("Clicked on the select level button.");
	}
}
