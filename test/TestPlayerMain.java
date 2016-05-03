import junit.framework.TestCase;

public class TestPlayerMain extends TestCase {

	public void testBuilderMain(){
		PlayerMain player = new PlayerMain();
		player.main(null);
		player.app.getWindowListeners()[0].windowClosing(null);
	}
}
