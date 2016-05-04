package controller.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.ReleaseTile;
import view.BuilderApplication;
import view.TileView;
import view.TileView_Release;

/**
 * This class is move class for changing number in the release level.
 * @author Team Nastes
 *
 */
public class ChangeNumForReleaseLevel implements ActionListener{
	BuilderApplication ba;
	JFrame selectNumColor;
	TileView tileView;
	int num;
	int color;
	/**
	 * Constructor for ChangeNumForReleaseLevel. Sets builder application, JFrame of the button, TileView, number and color.
	 * @param ba BuilderApplication
	 * @param selectNumColor JFrame
	 * @param tileView TileView
	 * @param num int 
	 * @param color int
	 */
	public ChangeNumForReleaseLevel(BuilderApplication ba,JFrame selectNumColor,TileView tileView, int num, int color) {
		// TODO Auto-generated constructor stub
		this.ba = ba;
		this.selectNumColor = selectNumColor;
		this.tileView = tileView;
		this.num = num;
		this.color = color;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ReleaseTile rt = ((ReleaseTile) this.tileView.getTile());
		rt.setNumAndColor(this.num,this.color);
		TileView_Release rtv = (TileView_Release)this.tileView;
		rtv.setNumAndColor(this.num, this.color);
		this.selectNumColor.dispose();
		this.ba.repaint();
	}

}
