package controller.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.ReleaseTile;
import view.BuilderApplication;
import view.TileView;
import view.TileView_Release;

public class ChangeNumForReleaseLevel implements ActionListener{
	BuilderApplication ba;
	JFrame selectNumColor;
	TileView tileView;
	int num;
	int color;
	
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
