package view.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.*;
import view.SplashScreen;

/**
 * PlayerApplication 
 * @author Team Nastes 
 *
 */
public class PlayerApplication extends JFrame {
	
	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = -8924107161190964432L;
	
	Game game;
	
	/**
	 * Create the frame.
	 * @param game Game
	 */
	public PlayerApplication(Game game) {
		
		this.game=game;
		setTitle("Player");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		
		
		JPanel firstPanel = new SplashScreen();
		setPanel(firstPanel);
		
		Timer timer = new Timer(1000, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				setPanel(new PlayerSelectView(game, PlayerApplication.this));
			}
			
		});
		timer.setRepeats(false);
		timer.start();
	}
	
	/**
	 * THis set's the Panel and makes it visible 
	 * @param panel JPanel
	 */
	public void setPanel(JPanel panel){
		setContentPane(panel);
		setVisible(false);
		setVisible(true);
	}
	
	// Move to PlayerLevelView
	/*
	public void initializeLevelView(Level l){
		
		PlayerLevelView levelView = new PlayerLevelView(game,l,this);

		levelView.setBorder(new EmptyBorder(5, 5, 5, 5));
		levelView.setLayout(null);
		levelView.setBounds(0,0,817,593);
		
		

		// Do not know why but it works
		// Need to be out and in
		this.setVisible(false);
		this.setVisible(true);
		
		setContentPane(levelView);
	}
	*/
	
	// Move to PlayerSelectView
	/*
	public void initializeSelectView(){
		ImageIcon result;
		JPanel selectView=new JPanel();
		selectView.setBorder(new EmptyBorder(5, 5, 5, 5));
		selectView.setLayout(null);
		selectView.setBounds(0,0,817,593);
		for(int i=0;i<3;i++)
			for(int j=0;j<5;j++){
				JButton b=new JButton();
				b.setLayout(null);
				b.setBounds(36+150*j, 130+150*i, 140, 140);
				
				final int k=5*i+j;
				
				JLabel lbl=new JLabel();
				lbl.setFont(new Font("Consolas",Font.BOLD,32));
				lbl.setHorizontalAlignment(JLabel.CENTER);
				lbl.setVerticalAlignment(JLabel.CENTER);
				lbl.setText(Integer.toString(k+1));
				lbl.setBounds(0, 10, 140, 40);
				b.add(lbl);
				
				int stars=game.getStar(k);
				for(int c=0;c<3;c++){
					if(stars>c)
						result=filledStar;
					else
						result=emptyStar;
					lbl=new JLabel(result);
					lbl.setBounds(4+44*c, 80-(c%2)*20, 44, 44);
					b.add(lbl);
				}
				Color c;
				if(game.getLevel(k).isPlayable())
					c=Color.green;
				else
					c=Color.red;
				
				b.setBackground(c);
				b.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){
						Level l=game.getLevel(k);
						if(l!=null&&l.isPlayable())
							initializeLevelView(l);
					}
				});
				selectView.add(b);
			}
		setContentPane(selectView);
	}
	*/
	
	Game getGame(){
		return game;
	}
}
