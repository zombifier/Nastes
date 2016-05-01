import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;

import model.*;
import view.player.*;

/**
 * PlayerMain class. The main class for the Kabasuji game player.
 * @author Team Nastes
 */
public class PlayerMain {

	final static String location = "Game.storage";
	
	/**
	 * loadGame()
	 * Loads the game, conditional on being able to find one to load.
	 * @return game
	 */
	private static Game loadGame() {
		// Inspired by Professor Heineman WordMap loadMap
		
		 ObjectInputStream ois = null;
		 Game game = new Game();
		 try {
			 ois = new ObjectInputStream (new FileInputStream(location));
			 game = (Game)ois.readObject();
			 ois.close();
		 } catch (Exception e) {
			 // unable to perform restore. 
			 System.err.println("Unable to load game from: " + location);
			 game = null;
		 }
		 
		 // close down safely
		 if (ois != null) {
			 try { ois.close(); } catch (IOException ioe) { }
		 }
		 
		 return game;
	}
	
	/**
	 * Main function.
	 * Calls loadGame to get the game.
	 * If one does not yet exist, creates a new one.
	 * Instantiates the Application, makes it visible to a player and watches for a windowClose event.
	 * @param args
	 */
	public static void main(String[] args){
		
		Game game = loadGame();
		
		if(game == null)
			game = new Game();
		
		PlayerApplication app=new PlayerApplication(game);
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				app.dispose();
			}      
		});

		app.setVisible(true);
	}
}
