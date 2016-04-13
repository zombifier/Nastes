import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import view.PlayerApplication;

public class PlayerMain {
	PlayerApplication app;
	
	public static void main(String[] args){
		PlayerApplication app=new PlayerApplication();
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				app.dispose();
			}      
		});

		app.setVisible(true);
	}
}
