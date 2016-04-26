package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import model.*;

public class TileView extends JPanel {
	Tile tile;
	
	public TileView(Tile tile){
		this.tile = tile;
		setBackground(new Color(255, 0, 255));
		setPreferredSize(new Dimension(45, 45));
	}
	
	public void redraw(){
		if(tile.isValid())
			this.setBackground(new Color(255, 255, 255)); // subject to change
		else
			this.setBackground(new Color(255, 0, 255));
	}
}
