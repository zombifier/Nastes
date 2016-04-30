package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.Timer;

import controller.*;
import controller.builder.ContainerController;
import controller.builder.LevelTypeController;
import controller.builder.LoadController;
import controller.builder.SaveController;
import model.*;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;

public class BuilderApplication extends JFrame {
	private JTextField txtSetLimit;
	JPanel frame;
	Game game;
	Level level;
	BullpenView bullpenView;
	ModelPieceView modelPieceView;
	PieceView pieceBeingDragged = new PieceView(new Piece(0,15));
	JPanel container;
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
		JButton btnHintaddremove = new JButton("Hint (add/remove)");
		
		
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Puzzle");
		comboBox.addItem("Lightning");
		comboBox.addItem("Release");
		comboBox.addActionListener(new LevelTypeController(level, this));
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
		btnUndo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				level.undoMove();
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
		BoardView lblBoard = new BoardView(level.getBoard(), this);
		panel_2.add(lblBoard);
		
		//JLabel lblBullpen = new JLabel("BullPen");
		BullpenView lblBullpen = new BullpenView(level.getBullpen(),this);
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
	
	public void setMovingPiece(PieceView pw, int x, int y){
		this.pieceBeingDragged = null;
		this.pieceBeingDragged = pw;
		Dimension d = this.pieceBeingDragged.getPreferredSize();

		this.container.add(pw);
		this.container.setOpaque(false);

//		this.setComponentZOrder(this.pieceBeingDragged, 0);
		
//		this.pieceBeingDragged.setVisible(true);
//		this.add(this.pieceBeingDragged);

//		this.pieceBeingDragged.setLocation(x, y);
//		this.pieceBeingDragged.setOpaque(false);
//		this.setComponentZOrder(this.pieceBeingDragged, 0);
		//this.repaint();
	}

	public PieceView getPieceBeingDrag() {
		// TODO Auto-generated method stub
		return this.pieceBeingDragged;
	}
}
