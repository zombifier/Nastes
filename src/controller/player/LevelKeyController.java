package controller.player;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.*;
import view.player.*;

public class LevelKeyController extends KeyAdapter {
	

	// Constant
	final public static int offset = 2;
	final public static int tileSize = 40;
	final public static int eachSize = offset + tileSize;
	
	Level level;
	PlayerLevelView levelView;
	
	public LevelKeyController(Level level,PlayerLevelView levelView){
		this.level = level;
		this.levelView = levelView;
	}
	
	@Override
	public void keyPressed(KeyEvent ke){
		Point p=levelView.getAnchor();
		
		if(level.getPiece()==null) return;
		
		if(ke.getKeyCode()==KeyEvent.VK_Z){
			level.getPiece().rotate(false);
			p=new Point(p.y, eachSize - p.x);
			//level.update(0); for update; need attention
		}
		if(ke.getKeyCode()==KeyEvent.VK_X){
			level.getPiece().rotate(true);
			p=new Point(eachSize - p.y, p.x);
			//level.update(0); for update; need attention
		}
		if(ke.getKeyCode()==KeyEvent.VK_A){
			level.getPiece().flip(true);
			p=new Point(p.x, eachSize - p.y);
			//level.update(0); for update; need attention
		}
		if(ke.getKeyCode()==KeyEvent.VK_S){
			level.getPiece().flip(false);
			p=new Point(eachSize - p.x, p.y);
			//level.update(0); for update; need attention
		}
		
		levelView.setAnchor(p);
		levelView.setMovePieceView(level.getPiece());
		
		levelView.redraw();
		levelView.repaint();
	}
}
