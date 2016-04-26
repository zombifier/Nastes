package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.*;

public class ResetLevel implements ActionListener {
	Level level;
	Game game;
	PlayerApplication app;
	
	public ResetLevel(Level level, Game game, PlayerApplication app){
		this.level = level;
		this.app = app;
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		app.updatePanel(new PlayerGame(level, game, app));
	}
}
