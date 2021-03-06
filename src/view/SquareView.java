package view;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;

/**
 * SquareView class. 
 * @author Team Nastes
 *
 */
public class SquareView extends JPanel {

	/**
	 * Create the panel.
	 */
	public SquareView() {
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(45, 45));

	}
	/**
	 * return height of the square
	 * @return 45
	 */
	public int getHeight(){
		return 45;
	}
	/**
	 * return width of the square
	 * @return 45
	 */
	public int getWidth(){
		return 45;
	}
}
