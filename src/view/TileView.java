package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class TileView extends JPanel {

	public TileView(){
		setBackground(new Color(255, 0, 255));
		setPreferredSize(new Dimension(45, 45));
	}
}
