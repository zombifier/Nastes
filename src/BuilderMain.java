import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;


import model.*;
import view.*;

/**
 * BuilderMain class. The main class for the Kabasuji game builder.
 * @author Team Nastes
 */
public class BuilderMain {

	final static String location = "Game.storage";
	
	static Game game;
	BuilderApplication app;

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
	 * saveGame()
	 * Saves the game.
	 */
	static void saveGame(){
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(location));
			oos.writeObject(game);
		} catch (Exception e) {
			System.err.println("Unable to save game: " + e.getMessage());
		}
		
		if (oos != null) {
			try { oos.close(); } catch (IOException ioe) { } 
		}
	}
	
	/**
	 * Main function.
	 * Calls loadGame to get the game.
	 * If one does not yet exist, creates a new one.
	 * Instantiates the Application, makes it visible to a player and watches for a windowClose event.
	 * On close, automatically save the state of the game.
	 * @param args
	 */
	public static void main(String[] args){
		game = loadGame();
		
		if(game == null){ // Check if the game is ready to be used
			game = new Game();
		}
		
		BuilderApplication app=new BuilderApplication(game);
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				saveGame();
				app.dispose();
			}      
		});

		app.setVisible(true);
	}
}
