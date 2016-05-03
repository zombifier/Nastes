package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Stack;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.Timer;

import controller.*;
import controller.builder.BuilderMove;
import controller.builder.ContainerController;
import controller.builder.LevelTypeController;
import controller.builder.LoadController;
import controller.builder.RotatingController;
import controller.builder.SaveController;
import model.*;
import view.BoardView;
import view.BullpenView;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;

/**
 * 
 * Builder Application. 
 * Contains:
 * Frame, Game, Level, BllpenView, ModelPieceView, PieceView, container
 * @author Team Nastes
 *
 */

public class BuilderApplication extends JFrame {
	private JTextField txtSetLimit;
	JPanel frame;
	Game game;
	Level level;
	BullpenView bullpenView;
	BoardView boardView;
	ModelPieceView modelPieceView;
	PieceView pieceBeingDragged = new PieceView(new Piece(0,15));
	JPanel container;

	Stack<BuilderMove> moves=new Stack<BuilderMove>();
	boolean hintMode;
	
	public BuilderApplication(Game game){
		this.game = game;
		setTitle("Kabasuji Editor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 840);
		frame = new SplashScreen();
		redraw();
		repaint();
		
		Timer timer = new Timer(2000,new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				frame.setVisible(false);
				redraw();
				repaint();
				initialize(new Puzzle(10));
			}
			
		});
		
		timer.setRepeats(false);
		timer.start();
		
		
	}
	
	public void initialize(Level lv){
		getContentPane().removeAll();
		
		
		
		
		this.level = lv; // instantiate level
		
		if(this.level == null)
			this.level = new Puzzle(10);
		
		this.container = new JPanel();
		this.container.setPreferredSize(new Dimension(1280,840));
		this.container.setBounds(0, 0, 1280, 840);
		this.container.setLayout(null);
		this.container.setOpaque(false);
		this.container.add(pieceBeingDragged);
		this.add(container);
//		this.container.addMouseListener(new ContainerController(this, container));
//		this.pieceBeingDragged.setLocation(100,100);
//		this.add(this.pieceBeingDragged);
		JCheckBox btnHintaddremove = new JCheckBox("Hint (add/remove)");
		btnHintaddremove.setFocusable(false);
		btnHintaddremove.setSelected(hintMode);
		btnHintaddremove.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		            hintMode = true;
		        } else {//checkbox has been deselected
		            hintMode = false;
		        };
		    }
		});
		
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Puzzle");
		comboBox.addItem("Lightning");
		comboBox.addItem("Release");
		comboBox.addActionListener(new LevelTypeController(lv, this));
		comboBox.setSelectedIndex(level.levelType());
		
		txtSetLimit = new JTextField();
		txtSetLimit.setText(this.level.getLimit());
		txtSetLimit.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		txtSetLimit.setColumns(10);
		txtSetLimit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {
				try{
					int limit = Integer.parseInt(txtSetLimit.getText());
					level.setLimit(limit);
				}catch(Exception e){
					System.out.println("Failed");
				}
				txtSetLimit.setText(level.getLimit());
			}
			
		});
		
		JLabel txtLimitUnit = new JLabel();
		txtLimitUnit.setText(this.level.getUnit());
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae){
				// subject to be changed in the later application
				new SaveController(game,level,BuilderApplication.this).process();
			}
		});
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae){
				// subject to be changed in the later application
				new LoadController(game,BuilderApplication.this).process();
			}
		});
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		
		JButton btnReset = new JButton("Reset");
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.setFocusable(false);
		btnUndo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				undoMove();
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.PINK);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.ORANGE);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(50, Short.MAX_VALUE)
					.addComponent(btnUndo)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(208)
							.addComponent(btnHintaddremove)
							.addGap(74)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addGap(51)
							.addComponent(txtSetLimit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtLimitUnit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(179)
							.addComponent(btnSave)
							.addGap(33)
							.addComponent(btnLoad))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1061, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
									.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE)))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnReset)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnHintaddremove)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSetLimit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtLimitUnit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSave)
								.addComponent(btnLoad))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(65)
									.addComponent(btnUndo))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(85)
							.addComponent(btnReset)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 465, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		//JLabel lblBoard = new JLabel("Board");
		this.boardView = new BoardView(level.getBoard(), this);
		panel_2.add(this.boardView);
		
		//JLabel lblBullpen = new JLabel("BullPen");
		BullpenView lblBullpen = new BullpenView(level.getBullpen(), this);
		panel_3.add(lblBullpen);
		this.bullpenView = lblBullpen;
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setBackground(Color.PINK);

		ModelPieceView modelPieceView = new ModelPieceView(this);
		modelPieceView.setBounds(0, 0, modelPieceView.getPreferredSize().width, modelPieceView.getPreferredSize().height);
		this.modelPieceView = modelPieceView;
		//JPanel panel_1 = new JPanel();
		//panel_1.setBackground(Color.GREEN);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(modelPieceView, modelPieceView.getPreferredSize().width, modelPieceView.getPreferredSize().width, modelPieceView.getPreferredSize().width)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(modelPieceView, GroupLayout.DEFAULT_SIZE, modelPieceView.getPreferredSize().height, modelPieceView.getPreferredSize().height)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

//		this.setComponentZOrder(this.pieceBeingDragged, 0);
	}
	
	public void redraw(){
		getContentPane().removeAll();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(frame, GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(frame, GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		
	}


	public BullpenView getPullpenView() {
		// TODO Auto-generated method stub
		return this.bullpenView;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public void updateMovePiece(PieceView pw,int x,int y){
//		this.setComponentZOrder(this.pieceBeingDragged, 0);
		pw.setLocation(x, y);
		this.repaint();
	}
	
	public void setMovingPiece(int countPress, PieceView pw, int x, int y){
		for (KeyListener k:this.getKeyListeners()){
			this.removeKeyListener(k);
		}
		for (int i=0;i<6;i++){
			this.pieceBeingDragged.getSquare()[i].setBackground(Color.YELLOW);
		}
		this.pieceBeingDragged = null;
		this.pieceBeingDragged = pw;
		Dimension d = this.pieceBeingDragged.getPreferredSize();
		if (countPress == 0){
			this.pieceBeingDragged.setLocation(750+x,150+y);
		}

		this.container.add(this.pieceBeingDragged);
		for (int i=0;i<6;i++){
			this.pieceBeingDragged.getSquare()[i].setBackground(Color.RED);
		}
		this.container.setOpaque(false);

		this.addKeyListener(new RotatingController(this.pieceBeingDragged, this));
//		this.setComponentZOrder(this.pieceBeingDragged, 0);
		
//		this.pieceBeingDragged.setVisible(true);
//		this.add(this.pieceBeingDragged);

//		this.pieceBeingDragged.setLocation(x, y);
//		this.pieceBeingDragged.setOpaque(false);
//		this.setComponentZOrder(this.pieceBeingDragged, 0);
		this.repaint();
	}
	/**
	 * get the pieceView of piece being drag
	 * @return
	 */
	public PieceView getPieceBeingDrag() {
		// TODO Auto-generated method stub
		return this.pieceBeingDragged;
	}
	
	public JPanel getPieceContainer(){
		return this.container;
	}
	
	/**
	 * add new move
	 */
	public void addMove(BuilderMove m) {
		moves.push(m);
	}
	
	/**
	 * undo a move
	 */
	public void undoMove() {
		if (!moves.empty()) {
			BuilderMove m = moves.pop();
			m.undo();
		}
		repaint();
	}
	
	/**
	 * returns whether builder is in "add hint mode"
	 * @return true is builder is in hint mode, false if not
	 */
	public boolean hintMode() {
		return hintMode;
	}
	
	public BoardView getBoardView(){
		return this.boardView;
	}
	public BullpenView getBullpenView(){
		return this.bullpenView;
	}
}
