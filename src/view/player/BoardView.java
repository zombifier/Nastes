package view.player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JPanel;

import model.*;

/**
 * BoardView 
 * @author Team Nastes 
 *
 */
public class BoardView extends JPanel {

	private static final long serialVersionUID = -5672387395261489437L;
	
	
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
	
	Level level;
	Board board;

	Random random;
	HashMap<Piece,Color> data;

	Image offScreenImage;
	Graphics offScreenGraphics;

	boolean hintMode;
	
	/**
	 * BoardView constructor. level is a Level and data is a Hashmap
	 * @param level Level
	 * @param data HashMap ()
	 */
	public BoardView(Level level,HashMap<Piece,Color> data){
		this.hintMode = false;
		this.level = level;
		board = level.getBoard();
		
		this.data=data;

		random=new Random();
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

		Dimension dim = getPreferredSize();
		offScreenGraphics.clearRect(0,0,dim.width,dim.height);
		offScreenGraphics.setColor(Color.black);
		offScreenGraphics.fillRect(0,0,dim.width,dim.height);

		Color colorTile;
		for(int i = 0; i < 12; i++)
			for(int j = 0; j < 12; j++) {
				Tile tile = board.getTile(i, j);
				if(tile == null || !tile.isValid())
					colorTile = Color.black;
				else if ((hintMode) && (tile.isHint()))
					colorTile = Color.cyan;
				else if(tile.isValid() && !tile.isFilled())
					colorTile = Color.white;
				else {
					if(level.levelType() == 0){ // Check if level is Puzzle
						// if so, print the color of the piece instead of one of tile
						Piece piece = board.getPieceAt(new BoardPosition(i, j));
						colorTile = data.get(piece);
						if(colorTile == null){
							colorTile=new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
							data.put(piece, colorTile);
						}
					}
					else
						colorTile = Color.green;
				}
				offScreenGraphics.setColor(colorTile);
				offScreenGraphics.fillRect((j + 1) * offset + j * tileSize,
											(i + 1) * offset + i * tileSize,
											tileSize,
											tileSize);
				// Print the number if there is
				if(level.levelType() == 2){ // Check if level is Release
					int color = ((ReleaseTile)tile).getColor(); // Confident because having check
					if(color > 0){
						Color colorNumber;
						if(color==1)
							colorNumber=Color.red;
						else if(color==2)
							colorNumber=Color.yellow;
						else 
							colorNumber=Color.green;
						int num = ((ReleaseTile)tile).getNumber(); // Confident because having check
						offScreenGraphics.setFont(new Font("Consolas",Font.BOLD,16));
						offScreenGraphics.setColor(colorNumber);
						offScreenGraphics.drawString("" + num, 
													(j + 1) * offset + j * tileSize + tileSize / 2,
													(i + 1) * offset + i * tileSize + tileSize / 3 * 2);
					}
				}
				
				}
		
	}
	
	/**
	 * Images are created off screen before being moved on screen 
	 * @return off screen image
	 */
	public Image getImage(){
		return offScreenImage;
	}
	
	/**
	 * It set's hint. Specifically, it inverses the hintMode boolean, telling you if there
	 * is a hint or not
	 */
	public void setHint() {
		hintMode = !hintMode;
	}
	
	/**
	 * This is for loading. Call this function 
	 * @param b
	 */
	public void setBoard(Board b){
		board=b;
	}
}
