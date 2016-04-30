package controller.builder;

import view.TileView;

public class TileValidMove extends BuilderMove {
	TileView tileView;
	boolean isHint;
	public TileValidMove (TileView tileView, boolean isHint) {
		this.tileView = tileView;
		this.isHint = isHint;
	}
	public boolean doMove() {
		if (!valid()) return false;
		if (isHint) {
			tileView.convertHint();
			tileView.drawHint();
		}
		else {
			tileView.convertValid();
			tileView.redraw();
		}
		return true;
	}
	public boolean undo() {
		if (isHint) {
			tileView.convertHint();
			tileView.drawHint();
		}
		else {
			tileView.convertValid();
			tileView.redraw();
		}
		return true;
	}
	
	public boolean valid() {
		if ((!tileView.isInGame()) && isHint) return false;
		else return true;
	}
}
