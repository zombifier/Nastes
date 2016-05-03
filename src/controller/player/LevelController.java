package controller.player;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.*;
import view.player.*;

public class LevelController extends MouseAdapter {
	Level level;
	PlayerLevelView levelView;
	
	public LevelController(Level l,PlayerLevelView lv){
		level=l;
		levelView=lv;
	}
	
	@Override
	public void mouseMoved(MouseEvent me){
		Point p=new Point(me.getX()+refX(),
							me.getY()+refY());
		levelView.setMouse(p);
		
		
		levelView.redraw();
		levelView.repaint();
	}
	
	public int refX(){
		return levelView.getBounds().x;
	}
	
	public int refY(){
		return levelView.getBounds().y;
	}
	
	
}
