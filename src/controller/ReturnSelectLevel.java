package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.PlayerApplication;
import view.PlayerSelector;

public class ReturnSelectLevel implements ActionListener {
	PlayerApplication app;

	public ReturnSelectLevel(PlayerApplication app){
		this.app=app;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		app.updatePanel(new PlayerSelector(app));
		System.out.println("Clicked");
	}
	

}
