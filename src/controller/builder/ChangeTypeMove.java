package controller.builder;

import model.*;

import view.BuilderApplication;

public class ChangeTypeMove extends BuilderMove {
	Level level;
	BuilderApplication ba;
	int type;
	public ChangeTypeMove (Level level, BuilderApplication ba, int type) {
		this.level = level;
		this.ba = ba;
		this.type = type;
	}
	
	public boolean doMove() {
		if (!valid()) return false;
		else {
			if (type == 0) ba.initialize(new Puzzle(10));
			else if (type == 1) ba.initialize(new Lightning());
			else if (type == 2) ba.initialize(new Release());
		}
		return true;
	}
	
	public boolean undo() {
		ba.initialize(level);
		return true;
	}
	
	public boolean valid() {
		if (level.levelType() == type) return false;
		else return true;
	}
}
