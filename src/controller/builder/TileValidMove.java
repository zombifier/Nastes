package controller.builder;

import view.TileView;

public class TileValidMove extends BuilderMove {
	TileView tileView;
	public TileValidMove (TileView tileView) {
		this.tileView = tileView;
	}
	public boolean doMove() {
		tileView.convertValid();
		tileView.redraw();

		return true;
	}
	public boolean undo() {
		tileView.convertValid();
		tileView.redraw();
		return true;
	}
}
