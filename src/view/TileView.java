package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import model.*;

/**
 * TileView
 * @author Team Nastes 
 *
 */
public class TileView extends JPanel {
	Tile tile;
	
	/**
	 * Constructor for TileView
	 * Tile tile
	 * @param tile
	 */
	public TileView(Tile tile){
		this.tile = tile;
		setLayout(null);
		if(tile.isValid()) {
			if (tile.isHint()) 
				this.setBackground(new Color(0, 255, 255)); // subject to change
			else
				this.setBackground(new Color(255, 255, 255)); // subject to change
		}
		else
			this.setBackground(new Color(255, 0, 255));
		setPreferredSize(new Dimension(45, 45));
	}
	
	/**
	 * This is the redraw function. It changes the color of a tile 
	 */
	public void redraw(){
		if(tile.isValid())
			this.setBackground(new Color(255, 255, 255)); // subject to change
		else
			this.setBackground(new Color(255, 0, 255));
	}
	
	/**
	 * This changes the color of a tile, but to a blue color to represent hint. 
	 */
	public void drawHint() {
		if (tile.isHint()) {
			this.setBackground(new Color(0, 255, 255)); // subject to change
		}
		else redraw();
	}
	
	/**
	 * This changes the isValid of a tile. So wether or not a tile is valid. 
	 */
	public void convertValid(){
		this.tile.convertValid();
	}
	
	/**
	 * This changes a tile to be or not to be a hint tile. 
	 */
	public void convertHint(){
		this.tile.convertHint();
	}
	
	/**
	 * Changes whether or not a tile is in a game
	 * @return boolean
	 */
	public boolean isInGame() {
		return this.tile.isValid();
	}
	
	/**
	 * This get's you a specific tile in the array tiles 
	 * @return tile
	 */
	public Tile getTile(){
		return this.tile;
	}
	
}
