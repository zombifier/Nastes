package view;

import javax.swing.*;

import model.*;

import java.awt.Color;

/**
 * TileView_Release class. 
 * @author Team Nastes
 *
 */
public class TileView_Release extends TileView {

	/**
	 * Constructor for TileView_Release
	 * @param tile Tile
	 */
	public TileView_Release(Tile tile) {
		super(tile);
		
		ReleaseTile t = (ReleaseTile)tile;
		if(t.getNumber()>0){
			JLabel numberPanel = new JLabel();
			numberPanel.setLayout(null);
			numberPanel.setOpaque(false);
			numberPanel.setBounds(15,15,15,15);
			numberPanel.setText(""+t.getNumber());
			numberPanel.setHorizontalAlignment(JLabel.CENTER);
			numberPanel.setVerticalAlignment(JLabel.CENTER);
			if (t.getColor() == 1){
				numberPanel.setForeground(Color.RED);
			}else if (t.getColor() == 2){
				numberPanel.setForeground(Color.BLUE);
			} else if (t.getColor() == 3){

				numberPanel.setForeground(Color.GREEN);
			}
			this.add(numberPanel);
		}
	}
	
	/**
	 * This function set number and color for the release tile. 
	 * @param num int
	 * @param color int
	 */
	public void setNumAndColor(int num, int color){
		this.removeAll();

		ReleaseTile t = (ReleaseTile)tile;
		if(t.getNumber()>0){
			JLabel numberPanel = new JLabel();
			numberPanel.setLayout(null);
			numberPanel.setOpaque(false);
			numberPanel.setBounds(15,15,15,15);
			numberPanel.setText(""+t.getNumber());
			numberPanel.setHorizontalAlignment(JLabel.CENTER);
			numberPanel.setVerticalAlignment(JLabel.CENTER);
			this.add(numberPanel);
			if (t.getColor() == 1){
				numberPanel.setForeground(Color.RED);
			}else if (t.getColor() == 2){
				numberPanel.setForeground(Color.YELLOW);
			} else if (t.getColor() == 3){

				numberPanel.setForeground(Color.GREEN);
			}
		}
		this.repaint();
		
	}
	

}
