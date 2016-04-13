package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.PlayerApplication;
import view.PlayerGame;

public class SelectLevel implements ActionListener {
	PlayerApplication app;

	public SelectLevel(PlayerApplication app){
		this.app=app;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		app.updatePanel(new PlayerGame(app));
		System.out.println("Clicked");
	}
	
}
