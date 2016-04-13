import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import view.BuilderApplication;
import view.PlayerApplication;

public class BuilderMain {

	BuilderApplication app;
	
	public static void main(String[] args){
		BuilderApplication app=new BuilderApplication();
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				app.dispose();
			}      
		});

		app.setVisible(true);
	}
}
