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
	
	public boolean doMove() {
		if (level.levelType() == type) return false;
		else {
			if (type == 0) level = new Puzzle(10);
			else if (type == 1) level = new Lightning();
			else if (type == 2) level = new Release();
		}
		ba.initialize(level);
		return true;
	}
	
	public boolean undo() {
		ba.initialize(oldLevel);
		return true;
	}
}
