package controller;

import model.*;
import view.*;

public class LoadController {
	Game game;
	BuilderApplication builderApplication;
	
	public LoadController(Game game, BuilderApplication builderApplication){
		this.game = game;
		this.builderApplication = builderApplication;
	}
	
	public void process(){
		Level level = game.getLevel(0); // 0 for now, subject to change
		if(level != null){
			builderApplication.initialize(level);
		}
	}
}
