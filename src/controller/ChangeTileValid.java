package controller;

import model.Tile;

/**
 * 
 * @author Team Nastes 
 *
 */

public class ChangeTileValid {
	Tile tile;
	
	public boolean doMove() {
		
		return true;
	}

	
	public boolean undo() {
		
		return true;
	}

	
	public boolean valid() {
		return true;
	}
}
