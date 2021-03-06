package view.player;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JPanel;

import model.*;

/**
 * MovePieceView
 * @author Team Nastes
 *
 */
public class MovePieceView extends JPanel {
	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 8702825753390803623L;
	
	/**
	 * The size between tiles. 
	 */
	final public static int offset = 2;
	/**
	 * The size of tiles. 
	 */
	final public static int tileSize = 40;
	/**
	 * The effective size of tiles. (Size + offset)
	 */
	final public static int eachSize = offset + tileSize;


	/**
	 * Constructor for MovePieceView. 
	 * Piece piece
	 * HashMap of (Piece,Color) data
	 * @param piece	Piece
	 * @param data HaspMap of piece
	 */
	public MovePieceView(Piece piece,HashMap<Piece,Color> data){
		
		JPanel outPanel,inPanel;
		
		this.setOpaque(false);
		this.setLayout(null);
		
		if(piece != null){
			if(data.get(piece) == null){
				Random r = new Random();
				data.put(piece, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
			}
			
			for(Square square:piece.getSquares()){
				Point point = new Point(square.getX(), square.getY());
				// +5 to make it positive
				// assume that Piece is generated normally
				
				// Color the tile
				inPanel = new JPanel();
				inPanel.setBackground(data.get(piece));
				inPanel.setBounds((point.y + 5) * eachSize + offset / 2,
								(point.x + 5) * eachSize + offset / 2,
								tileSize,
								tileSize);
				
				// Color the border
				outPanel=new JPanel();
				outPanel.setBackground(Color.black);
				outPanel.setBounds((point.y + 5) * eachSize,
									(point.x + 5) * eachSize,
									eachSize,
									eachSize);
				
				add(inPanel);
				add(outPanel);
			}
		}
	}
}
