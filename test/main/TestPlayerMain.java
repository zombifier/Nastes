package main;
import junit.framework.TestCase;
import main.PlayerMain;

public class TestPlayerMain extends TestCase {

	public void testBuilderMain(){
		PlayerMain player = new PlayerMain();
		player.main(null);
		player.app.getWindowListeners()[0].windowClosing(null);
	}
}
