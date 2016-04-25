import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import model.*;
import view.*;

public class BuilderMain {

	BuilderApplication app;
	
	public static void main(String[] args){
		BuilderApplication app=new BuilderApplication(new Game());
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				app.dispose();
			}      
		});

		app.setVisible(true);
	}
}
