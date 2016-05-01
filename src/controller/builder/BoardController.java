package controller.builder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Polygon;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.*;
import view.*;

/**
 * BoardController class.
 * @author Team Nastes
 */
public class BoardController extends MouseAdapter {
	BuilderApplication ba;
	Board board;
	BoardView boardView;
	
	/**
	 * BoardController constructor. Sets the board and boardView to the current board and boardView.
	 * @param board
	 * @param boardView
	 */
	public BoardController(BuilderApplication ba, Board board, BoardView boardView){
		this.ba = ba;
		this.board = board;
		this.boardView = boardView;
	}
	
	@Override
	public void mousePressed(MouseEvent ae){
		TileView t;
		try{
			t = (TileView) boardView.findComponentAt(ae.getPoint());
		}catch(Exception e){
			System.out.println("Does not click on the screen");
			t = null;
		}
		if(t != null){
			// If the user left clicked, toggle the state of the tile
			if (ae.getModifiers()==InputEvent.BUTTON1_MASK){
				//System.out.println("Tile state toggle initiated.");
				BuilderMove m = new TileValidMove (t,ba.hintMode());
				if (m.doMove()) {
					ba.addMove(m);
				}			
			}
			if (ae.getModifiers()==InputEvent.BUTTON3_MASK){
				//Check to see if the level is a release level.
				//If it is, run the below.
				//System.out.println("Release number state change initiated.");
				//Call the function that handles changing the number.
				if(this.ba.getLevel().levelType() == 2){
					System.out.println("Release number state change initiated.");
					if (t.getTile().isValid()){
						final JFrame selectNumLevel= new JFrame();
	
						selectNumLevel.setTitle("Select Number and Color");
						selectNumLevel.setLayout(null);
						selectNumLevel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						selectNumLevel.setPreferredSize(new Dimension(2 + 52 * 7 + 50, 2 + 52 * 3 + 50));
						Dimension d = selectNumLevel.getPreferredSize();
						selectNumLevel.setBounds(300, 300, d.width, d.height);
						selectNumLevel.setVisible(true);
						
						//Find out which button was selected for saving.
						for(int i = 0; i < 3; i++)
							for(int j = 0; j < 7; j++){
								JButton button = new JButton();
								button.setBounds(2 + j * 52, 2 + i * 52, 50, 50);
								final int value = 7 * i + j;
								int num = (value+1)%7;
								int color = (value)/7+1;
								if (color == 1){
									button.setText(""+Integer.toString(num));
									button.setBackground(Color.RED);
								} else if (color ==2){
									button.setText(""+Integer.toString(num));
									button.setBackground(Color.BLUE);
								} else if (color == 3){
									button.setText(""+Integer.toString(num));
									button.setBackground(Color.GREEN);
								}
								button.addActionListener(new ChangeNumForReleaseLevel(this.ba,selectNumLevel,t,num,color));
								
								selectNumLevel.add(button);
							}
					}else {
						return;
					}
				
				}
			}
		}
	}
	
//	@Override
//	public void mouseReleased(MouseEvent ae){
//		System.out.println("Hahaha");
//		TileView t = (TileView) boardView.findComponentAt(ae.getPoint());
//		
//		if(t != null){
//			PieceView pw = (PieceView)ae.getComponent();
//			this.boardView.drawPieceView(pw,t.getMousePosition());
//		} else {
//			System.out.println("Whoops");
//		}
//	}
	
}
