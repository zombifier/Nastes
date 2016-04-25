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
		game.setLevel(0,level.copy());
		builderApplication.redraw();
		builderApplication.repaint();
	}
}
