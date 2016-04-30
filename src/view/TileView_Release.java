package view;

import javax.swing.*;

import model.*;

import java.awt.Color;

public class TileView_Release extends TileView {

	/**
	 * Create the panel.
	 */
	public TileView_Release(Tile tile) {
		super(tile);
		
		ReleaseTile t = (ReleaseTile)tile;
		if(t.getNumber()>0){
			JLabel numberPanel = new JLabel();
			numberPanel.setLayout(null);
			numberPanel.setOpaque(false);
			numberPanel.setBounds(0,0,45,45);
			numberPanel.setText(""+t.getNumber());
			numberPanel.setHorizontalAlignment(JLabel.CENTER);
			numberPanel.setVerticalAlignment(JLabel.CENTER);
			this.add(numberPanel);
		}
	}

}
