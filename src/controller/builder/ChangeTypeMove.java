package controller.builder;

import model.*;

import view.BuilderApplication;

public class ChangeTypeMove extends BuilderMove {
	Level level, oldLevel;
	BuilderApplication ba;
	int type;
	public ChangeTypeMove (Level level, BuilderApplication ba, int type) {
		this.level = level;
		this.oldLevel = level.copy();
		this.ba = ba;
		this.type = type;
	}
	
	public void doMove() {
		if (level.levelType() == type) return;
		else {
			if (type == 0) level = new Puzzle(10);
			else if (type == 1) level = new Lightning();
			else if (type == 2) level = new Release();
		}
		ba.initialize(level);
	}
	
	public void undo() {
		level = oldLevel;
		ba.initialize(level);
	}
}
