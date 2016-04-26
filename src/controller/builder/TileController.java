package controller.builder;

import java.awt.event.*;

import model.*;
import view.*;

public class TileController extends MouseAdapter {
	Tile tile;
	TileView tileView;
	
	public TileController(Tile tile, TileView tileView){
		this.tile = tile;
		this.tileView = tileView;
	}
	
	@Override
	public void mousePressed(MouseEvent ae){
		if(tile != null && tileView != null){
			//Check which mouse button was pressed
		    switch(ae.getModifiers()) {
		    	//Left click
		      	case InputEvent.BUTTON1_MASK: {
		      		tile.convertValid();
					tileView.redraw();
					System.out.println("Tile state toggled."); 
		        	break;
		      	}
		      	//Right click
		    	case InputEvent.BUTTON3_MASK: {
		    		//Insert code for release tile checking
		    		//Insert code for being able to update the color/number, if release
		    	  	System.out.println("That's the RIGHT button");     
		    		break;
		      	}
		    }
		}
	}
}
