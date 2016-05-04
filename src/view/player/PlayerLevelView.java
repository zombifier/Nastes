package view.player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.player.*;
import model.*;

/**
 * Player level view
 * @author Team Nastes
 *
 */
public class PlayerLevelView extends JPanel {
	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = -5818449171686104200L;

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
	 * This is the font used in the game
	 */
	final public static Font font = new Font("Consolas", Font.BOLD, 28);

	HashMap<Piece,Color> data;

	Level level;

	Game game;

	BoardView boardView;

	BullpenView bullpenView;

	JLabel txtLimit;

	PlayerApplication app;

	Point mouse; // mouse position
	Point anchor; // null if there is no piece selected

	MovePieceView movePieceView;

	Image offScreenImage;
	Graphics offScreenGraphics;

	Timer timer;
	TimerTask timerTask;
	
	boolean done = false;

	/**
	 * This is the constructor for Player Level view
	 * Game game
	 * Level level
	 * Playerapplication app
	 * @param game
	 * @param level
	 * @param app
	 */
	public PlayerLevelView(Game game, Level level, PlayerApplication app){
		this.game = game;
		this.level = level;
		this.app = app;

		this.setLayout(null);

		this.setBackground(Color.darkGray);

		LevelController lc = new LevelController(level, this);
		addMouseListener(lc);
		addMouseMotionListener(lc);

		LevelKeyController lkc = new LevelKeyController(level, this);
		addKeyListener(lkc);
		setFocusable(true);
		requestFocusInWindow();


		data = new HashMap<Piece,Color>();


		movePieceView = new MovePieceView(null, data);

		// BoardView
		boardView = new BoardView(level,data);
		Dimension d = boardView.getPreferredSize();
		boardView.setBounds(10, 80, d.width, d.height);
		this.add(boardView);

		BoardController bc = new BoardController(level, this);
		boardView.addMouseListener(bc);
		boardView.addMouseMotionListener(bc);


		// BullpenView
		bullpenView = new BullpenView(level, data);
		Dimension d1 = bullpenView.getPreferredSize();
		bullpenView.setBounds(20+d.width, 80, d1.width, d1.height);
		this.add(bullpenView);

		BullpenController bpc = new BullpenController(level, this);
		bullpenView.addMouseListener(bpc);
		bullpenView.addMouseMotionListener(bpc);


		// Timer for Lightning Level
		timer = new Timer();
		timerTask = new TimerTask(){

			@Override
			public void run() {
				//level.update(1);
				//PlayerLevelView.this.getLimitView().redraw();
				//PlayerLevelView.this.getLimitView().repaint();
				if (level.levelType()==1) {
					level.limitDecrease();
					txtLimit.setText(level.getLimit() + " " + level.getUnit());
				}

				if(level.hasWon()){
					PlayerLevelView.this.redraw();
					PlayerLevelView.this.repaint();
					finishLevel();
				}
			}

		};
		timer.schedule(timerTask, 1000, 1000);


		// Back Button
		JButton backButton=new JButton();
		backButton.setFont(font);
		backButton.setText("Back");
		backButton.setBounds(10, 10, 100, 60);
		backButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				finishLevel();
			}
		});
		add(backButton);


		// Reset Button
		JButton resetButton=new JButton();
		resetButton.setFont(font);
		resetButton.setText("Reset");
		resetButton.setBounds(687, 10, 120, 60);
		resetButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PlayerLevelView.this.app.setPanel(
						new PlayerLevelView(PlayerLevelView.this.game,
								PlayerLevelView.this.game.getLevel(Integer.parseInt(level.getLevelNum().substring(1))),
								PlayerLevelView.this.app));
			}
		});
		add(resetButton);


		// Hint Button
		JButton hintButton=new JButton();
		hintButton.setFont(font);
		hintButton.setText("Hint");
		hintButton.setBounds(900, 10, 120, 60);
		hintButton.setFocusable(false);
		hintButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				showHint();
			}
		});
		add(hintButton);


		// Background 
		JPanel bg = new JPanel();
		bg.setBackground(Color.black);
		bg.setBounds(200, 10, 150, 60);
		bg.setLayout(null);
		add(bg);
		// Type of level
		JLabel nameLabel = new JLabel();
		nameLabel.setFont(font);
		nameLabel.setText(level.name());
		nameLabel.setBackground(Color.white);
		nameLabel.setOpaque(true);
		nameLabel.setBounds(2, 2, 146, 56);
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		nameLabel.setVerticalAlignment(JLabel.CENTER);
		bg.add(nameLabel);


		// Background
		bg=new JPanel();
		bg.setBackground(Color.black);
		bg.setBounds(350, 10, 60, 60);
		bg.setLayout(null);
		add(bg);
		// Number of level
		JLabel numLabel = new JLabel();
		numLabel.setFont(font);
		numLabel.setHorizontalAlignment(JLabel.CENTER);
		numLabel.setVerticalAlignment(JLabel.CENTER);
		numLabel.setText(level.getLevelNum());
		numLabel.setBackground(Color.white);
		numLabel.setOpaque(true);
		numLabel.setBounds(2, 2, 56, 56);
		bg.add(numLabel);


		// Background
		bg=new JPanel();
		bg.setBackground(Color.black);
		bg.setBounds(410, 10, 180, 60);
		bg.setLayout(null);
		add(bg);
		// Limit of level
		txtLimit = new JLabel();
		txtLimit.setBackground(Color.white);
		txtLimit.setFont(font);
		txtLimit.setText(level.getLimit() + " " + level.getUnit());
		txtLimit.setOpaque(true);
		txtLimit.setHorizontalAlignment(JLabel.CENTER);
		txtLimit.setVerticalAlignment(JLabel.CENTER);
		txtLimit.setBounds(2, 2, 176, 56);
		bg.add(txtLimit);
	}


	@Override
	public Dimension getPreferredSize(){
		return new Dimension(1000,600);
	}

	@Override
	public Dimension getMinimumSize(){
		return new Dimension(1000,600);
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
		g.drawImage(offScreenImage,0,0,this);


	}

	/**
	 * THis is the redraw function for updating. It will redraw off the screen before moving
	 * it back on
	 */
	public void redraw(){

		if (offScreenImage == null) {
			// create on demand
			Dimension s = getPreferredSize();
			offScreenImage = this.createImage(s.width, s.height);
			offScreenGraphics = offScreenImage.getGraphics();

		}

		Dimension dim = getPreferredSize();
		offScreenGraphics.clearRect(0, 0, dim.width, dim.height);
		offScreenGraphics.setColor(Color.darkGray);
		offScreenGraphics.fillRect(0, 0, dim.width, dim.height);


		boardView.redraw();
		boardView.repaint();

		bullpenView.redraw();
		bullpenView.repaint();

		txtLimit.setText(level.getLimit() + " " + level.getUnit());

		if(level.hasWon() && !done){
			done = true;
			finishLevel();
		}

		
		if(level.getPiece()!=null){ // Check if there is piece being held
			// if so, set an appropriate position
			int x = mouse.x - anchor.x - 5 * eachSize;
			int y = mouse.y - anchor.y - 5 * eachSize;
			//movePieceView.setVisible(true);
			movePieceView.setLocation(new Point(x, y));
		}
		else{
			// if not, send it out of screen
			movePieceView.setLocation(new Point(-1000, -1000));
		}
	}

	/**
	 * THis is for moving the mouse. 
	 * @param point
	 */
	public void setMouse(Point point){
		mouse = point;
	}

	/**
	 * @param point
	 */
	public void setAnchor(Point point){
		anchor = point;
	}

	/**
	 * @return boardView
	 */
	public BoardView getBoardView(){
		return boardView;
	}

	/**
	 * @return bullpenView
	 */
	public BullpenView getBullpenView(){
		return bullpenView;
	}

	/**
	 * @param p
	 */
	public void setMovePieceView(Piece p){
		remove(movePieceView);

		movePieceView=new MovePieceView(p,data);
		movePieceView.setSize(new Dimension(eachSize * 12, eachSize * 12));
		add(movePieceView);
		try{
			this.setComponentZOrder(movePieceView,0);
		}catch(Exception e){
			System.out.println("ZOrder Problem");
			e.printStackTrace();
		}
	}


	/**
	 * Get's Anchor
	 * @return anchor
	 */
	public Point getAnchor() {
		return anchor;
	}

	void finishLevel(){
		timer.cancel();
		
		
		if(level.getPiece()!=null){
			level.getBullpen().addPiece(level.getPiece());
			bullpenView.redraw();
			bullpenView.repaint();
			level.releasePiece();
			this.setMovePieceView(null);
		}
		StarView starView = new StarView(level, game, app);
		starView.setVisible(true);
	}

	/**
	 * Function for showing hint
	 */
	public void showHint() {
		Timer timer = new Timer();
		boardView.setHint();
		boardView.redraw();
		timer.schedule(new TimerTask() {
			  @Override
			  public void run() {
				  boardView.setHint();
				  boardView.redraw();
			  }
			}, 5000);
	}

}
