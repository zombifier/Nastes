package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.*;

public class SelectLevel implements ActionListener {
	PlayerApplication app;
	Level level;
	Game game;

	public SelectLevel(Level level, Game game, PlayerApplication app){
		this.app = app;
		this.level = level;
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		app.updatePanel(new PlayerGame(level, game, app));
		System.out.println("Clicked");
	}
	
}
