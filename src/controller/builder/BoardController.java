package controller.builder;

import java.awt.Polygon;
import java.awt.event.*;

import model.*;
import view.*;

public class BoardController extends MouseAdapter {
	Board board;
	BoardView boardView;
	
	
	public BoardController(Board board, BoardView boardView){
		this.board = board;
		this.boardView = boardView;
	}
	
	@Override
	public void mousePressed(MouseEvent ae){
		TileView t = (TileView) boardView.findComponentAt(ae.getPoint());
		if(t != null){
			t.convertValid();
			t.redraw();
			System.out.println("Working");
		}
	}
}
