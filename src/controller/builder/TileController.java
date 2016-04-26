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
			tile.convertValid();
			tileView.redraw();
			System.out.println("Working");
		}
	}
}
