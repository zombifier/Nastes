package controller.builder;

import model.*;

import view.BuilderApplication;

/**
 * This class is move class for change type of level for builder application throught the combo box.
 * @author Team Nastes
 *
 */
public class ChangeTypeMove extends BuilderMove {
	Level level;
	BuilderApplication ba;
	int type;
	/**
	 * Constructor for ChangeTypeMove. Sets level, builder application and type of the level
	 * @param level Level
	 * @param ba BuilderApplication
	 * @param type int
	 */
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
