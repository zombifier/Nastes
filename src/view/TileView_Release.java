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
