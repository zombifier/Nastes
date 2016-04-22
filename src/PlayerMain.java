import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import model.*;
import view.*;

public class PlayerMain {
	
	public static void main(String[] args){
		
		Game game = new Game();
		
		PlayerApplication app=new PlayerApplication(game);
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				app.dispose();
			}      
		});

		app.setVisible(true);
	}
}
