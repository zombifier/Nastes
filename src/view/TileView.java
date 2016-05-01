package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import model.*;

public class TileView extends JPanel {
	Tile tile;
	
	public TileView(Tile tile){
		this.tile = tile;
		setLayout(null);
		if(tile.isValid())
			this.setBackground(new Color(255, 255, 255)); // subject to change
		else
			this.setBackground(new Color(255, 0, 255));
		setPreferredSize(new Dimension(45, 45));
	}
	
	public void redraw(){
		if(tile.isValid())
			this.setBackground(new Color(255, 255, 255)); // subject to change
		else
			this.setBackground(new Color(255, 0, 255));
	}
	
	public void drawHint() {
		if (tile.isHint()) {
			this.setBackground(new Color(0, 255, 255)); // subject to change
		}
		else redraw();
	}
	
	public void convertValid(){
		this.tile.convertValid();
	}
	
	public void convertHint(){
		this.tile.convertHint();
	}
	
	public boolean isInGame() {
		return this.tile.isValid();
	}
	
	public Tile getTile(){
		return this.tile;
	}
	
}
