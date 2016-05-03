package main;
import junit.framework.TestCase;
import main.BuilderMain;

public class TestBuilderMain extends TestCase {

	public void testBuilderMain(){
		BuilderMain builder = new BuilderMain();
		builder.main(null);
		builder.app.getWindowListeners()[0].windowClosing(null);
	}
}
