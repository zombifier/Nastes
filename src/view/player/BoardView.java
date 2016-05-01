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

public class BoardView extends JPanel {
	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = -5672387395261489437L;
	
	// Constant
	final public static int offset = 2;
	final public static int tileSize = 40;
	final public static int eachSize = offset + tileSize;
	
	Level level;
	Board board;

	Random random;
	HashMap<Piece,Color> data;

	Image offScreenImage;
	Graphics offScreenGraphics;

	public BoardView(Level level,HashMap<Piece,Color> data){
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
				
				// Print the number if there is
				if(level.levelType() == 2){ // Check if level is Release
					int type = ((ReleaseTile)tile).getColor(); // Confident because having check
					if(type > 0){
						Color colorNumber;
						if(i==0)
							colorNumber=Color.red;
						else if(i==1)
							colorNumber=Color.yellow;
						else 
							colorNumber=Color.blue;
						type = ((ReleaseTile)tile).getNumber(); // Confident because having check
						offScreenGraphics.setFont(new Font("Consolas",Font.BOLD,16));
						offScreenGraphics.setColor(colorNumber);
						offScreenGraphics.drawString("" + (type + 1), 
													(j + 1) * offset + j * tileSize + tileSize / 2,
													(i + 1) * offset + i * tileSize + tileSize / 3 * 2);
					}
				}
				offScreenGraphics.setColor(colorTile);
				offScreenGraphics.fillRect((j + 1) * offset + j * tileSize,
											(i + 1) * offset + i * tileSize,
											tileSize,
											tileSize);
				}
		
	}
	
	public Image getImage(){
		return offScreenImage;
	}
	
	public void setBoard(Board b){
		board=b;
	}
}
