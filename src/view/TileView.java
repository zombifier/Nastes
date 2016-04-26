package view;

import java.awt.Color;

import javax.swing.JPanel;

import model.*;

public class TileView extends JPanel {
	Tile tile;
	
	public TileView(Tile tile){
		this.tile = tile;
	}
	
	public void redraw(){
		if(tile.isValid())
			this.setBackground(new Color(255, 255, 255)); // subject to change
		else
			this.setBackground(new Color(255, 0, 255));
	}
}
