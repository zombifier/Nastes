package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.PlayerApplication;
import view.PlayerSelector;

public class ReturnSelectLevel implements ActionListener {
	PlayerApplication app;
	Game game;

	public ReturnSelectLevel(Game game, PlayerApplication app){
		this.app = app;
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		app.updatePanel(new PlayerSelector(game, app));
		System.out.println("Clicked");
	}
	

}
