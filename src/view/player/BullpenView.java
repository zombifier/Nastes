package view.player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JPanel;

import model.*;

/**
 * Bull pen View
 * @author Team Nastes
 *
 */
public class BullpenView extends JPanel{
	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = -1581143889245005383L;
	
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
	
	Bullpen bullpen;

	HashMap<Piece,Color> data;
	HashMap<Piece,Point> pieces;
	
	Random random;

	Image offScreenImage;
	Graphics offScreenGraphics;
	
	/**
	 * Constructor for Bull pen view
	 * @param level
	 * @param data
	 */
	public BullpenView(Level level, HashMap<Piece,Color> data){
		bullpen = level.getBullpen();
		
		this.data = data;
		
		random = new Random();
		
		pieces = new HashMap<Piece,Point>();
		
		for(Piece piece:bullpen.getPieces())
			initialize(piece);
		
	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(13 * offset + 12 * tileSize, 13 * offset + 12 * tileSize);
	}
	
	@Override
	public Dimension getMinimumSize(){
		return new Dimension(13 * offset + 12 * tileSize, 13 * offset + 12 * tileSize);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (offScreenImage == null) {
			// create on demand
			Dimension s = getPreferredSize();
			offScreenImage = this.createImage(s.width, s.height);
			offScreenGraphics = offScreenImage.getGraphics();

			redraw();
		}

		// if no offscreenImage, then Swing hasn't fully initialized; leave now
		if (offScreenImage == null) {
			System.err.println("Swing not ready for drawing.");
			return;
		}

		// copy image into place.
		g.drawImage(offScreenImage, 0, 0, this);
	}
	
	/**
	 * 
	 */
	public void redraw(){
		if (offScreenImage == null) {
			// create on demand
			Dimension s = getPreferredSize();
			offScreenImage = this.createImage(s.width, s.height);
			offScreenGraphics = offScreenImage.getGraphics();

		}
		
		offScreenGraphics.clearRect(0,0,this.getPreferredSize().width,getPreferredSize().height);
		offScreenGraphics.setColor(Color.white);
		offScreenGraphics.fillRect(0,0,getPreferredSize().width,getPreferredSize().height);
		
		// Assume every piece in bullpen has valid point
		for(Piece piece: bullpen.getPieces()){
			
			// get point on actual bullpen for piece
			Point point = pieces.get(piece);
			if(point == null){ // if there is not, initialize one
				initialize(piece);
				point = pieces.get(piece);
			}
			
			// get color of piece on actual bullpen
			Color colorPiece = data.get(piece); 
			if(colorPiece == null){ // if there is not, initialize one
				colorPiece = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
				data.put(piece,colorPiece);
			}
			
			// print it on bullpen
			for(Square square: piece.getSquares()){
				offScreenGraphics.setColor(Color.black);
				offScreenGraphics.fillRect(point.x + square.getY() * eachSize,
											point.y + square.getX()* eachSize,
											eachSize,
											eachSize);
				offScreenGraphics.setColor(colorPiece);
				offScreenGraphics.fillRect(point.x + square.getY() * eachSize + offset/2,
											point.y + square.getX() * eachSize + offset/2,
											tileSize,
											tileSize);
			}
		}
	}
	
	/**
	 * Decide if the piece can be placed at the specific point.
	 * @param piece Piece placed to bullpen
	 * @param point Point on bullpen
	 * @return True if the piece can place at the specific point without out of bound; otherwise, false
	 */
	boolean validPoint(Piece piece, Point point){
		for(Square square: piece.getSquares()){
			int y = point.y + eachSize * square.getX();
			int x = point.x + eachSize * square.getY();
			// Check if square is out of bound
			if(x < 0 || y < 0 || x + eachSize > this.getPreferredSize().width || y + eachSize > this.getPreferredSize().height){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Set the piece which currently has no position on the bullpen.
	 * @param piece Piece placed on the bullpen
	 */
	void initialize(Piece piece){
		Point point = new Point(-eachSize, -eachSize);
		
		// Border of bullpen
		int x = this.getPreferredSize().width;
		int y = this.getPreferredSize().height;
		
		// Check until it can be placed
		while(!validPoint(piece, point)){
			point = new Point(random.nextInt(x),random.nextInt(y));
		}
		
		this.pieces.put(piece,point);
	}
	
	/**
	 * Set piece on the bull if it can be placed
	 * @param piece Piece placed on bullpen
	 * @param point Point which the top-left of 0, 0 square of the piece
	 * @return true if the piece can be placed; otherwise, false
	 */
	public boolean setLocation(Piece piece, Point point){
		if(validPoint(piece, point)){
			pieces.put(piece, point);
			return true;
		}
		return false;
	}
	
	/**
	 * This get's the location of a piece
	 * @param piece
	 * @return position
	 */
	public Point getPiecePoint(Piece piece){
		return pieces.get(piece);
	}
	
	/**
	 * This create's the bullpen
	 * @param bullpen
	 */
	public void setBullpen(Bullpen bullpen){
		this.bullpen = bullpen;
	}
}
