package controller.player;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.*;
import view.player.*;

/**
 * Level Key Controller 
 * @author Team Nastes
 *
 */
public class LevelKeyController extends KeyAdapter {
	

	/**
	 * Size between tiles
	 */
	// Constant
	final public static int offset = 2;
	/**
	 * Size of Tiles
	 */
	final public static int tileSize = 40;
	/**
	 * The total size a tiles takes 
	 */
	final public static int eachSize = offset + tileSize;
	
	Level level;
	PlayerLevelView levelView;
	
	/**
	 * Constructor of the class
	 * @param level Level
	 * @param levelView LevelView
	 */
	public LevelKeyController(Level level,PlayerLevelView levelView){
		this.level = level;
		this.levelView = levelView;
	}
	
	@Override
	public void keyPressed(KeyEvent ke){
		Point anchor = levelView.getAnchor();
		
		if(level.getPiece() == null) return;
		
		if(ke.getKeyCode() == KeyEvent.VK_R){
			level.getPiece().rotate(false);
			anchor=new Point(anchor.y, eachSize - anchor.x);
			/*
			if (level.levelType() == 0)
				level.limitDecrease();
				*/
		}
		if(ke.getKeyCode() == KeyEvent.VK_E){
			level.getPiece().rotate(true);
			anchor=new Point(eachSize - anchor.y, anchor.x);
			/*
			if (level.levelType() == 0)
				level.limitDecrease();
			*/
		}
		if(ke.getKeyCode() == KeyEvent.VK_W){
			level.getPiece().flip(true);
			anchor=new Point(anchor.x, eachSize - anchor.y);
			/*
			if (level.levelType() == 0)
				level.limitDecrease();
				*/
		}
		if(ke.getKeyCode() == KeyEvent.VK_Q){
			level.getPiece().flip(false);
			anchor=new Point(eachSize - anchor.x, anchor.y);
			/*
			if (level.levelType() == 0)
				level.limitDecrease();
			*/
		}
		
		levelView.setAnchor(anchor);
		levelView.setMovePieceView(level.getPiece());
		
		levelView.redraw();
		levelView.repaint();
	}
}
