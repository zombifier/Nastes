package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerApplication extends JFrame {
	JPanel frame;
	
	public PlayerApplication(){
		initialize();
	}
	
	private void initialize(){
		PlayerApplication dummy = this;
		setTitle("Kabasuji");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 768);
		
		frame = new SplashScreen();
		redraw();
		repaint();
		Timer timer = new Timer(2000,new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				frame = new PlayerSelector(dummy);
				
				redraw();
				repaint();
			}
			
		});
		timer.setRepeats(false);
		timer.start();
		
		
		
		
		
	}
	
	void redraw(){
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
	
	public void updatePanel(JPanel panel){
		frame=panel;
		redraw();
		repaint();
	}
}
