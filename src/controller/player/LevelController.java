package controller.player;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.*;
import view.player.*;
/**
 * Level Controller
 * @author Team nastes
 *
 */
public class LevelController extends MouseAdapter {
	Level level;
	PlayerLevelView levelView;
	/**
	 * Constructor for LevelController
	 * @param l level
	 * @param lv LevelView
	 */
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
	
	/**
	 * This is location(x) of the level.... within the level. Should be 0
	 * @return position
	 */
	public int refX(){
		return levelView.getBounds().x;
	}
	
	/** This is the location(y) of the level within the level. Should be 0. 
	 * @return position
	 */
	public int refY(){
		return levelView.getBounds().y;
	}
	
	
}
