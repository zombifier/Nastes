package controller;

import model.*;
import view.*;

public class SaveController {
	Game game;
	Level level;
	BuilderApplication builderApplication;
	
	public SaveController(Game game, Level level, BuilderApplication builderApplication){
		this.game = game;
		this.level = level;
		this.builderApplication = builderApplication;
	}
	
	public void process(){
		game.setLevel(0,level.copy()); // not load directly because there may be changes
		// 0 for now, subject to change
		//builderApplication.redraw();
		//builderApplication.repaint();
	}
}
