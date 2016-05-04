package controller.builder;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import view.BuilderApplication;
import view.BullpenView;
import view.PieceView;
import view.SquareView;

/**
 * This class is for the container of builder when the builder want to move the piece to make sure if the level can be complete.
 * @author Team Nastes
 *
 */
public class ContainerController extends MouseAdapter{
	BuilderApplication app;
	JPanel container;
	int diffX;
	int diffY;
	/**
	 * Constructor for ContainerController. Sets builder application and container.
	 * @param app
	 * @param container
	 */
	public ContainerController(BuilderApplication app, JPanel container){
		super();
		this.app = app;
		this.container = container;
	}
	
	@Override
	public void mouseReleased(MouseEvent ae){
		System.out.println("Release");
//		MouseEvent parentEvent = SwingUtilities.convertMouseEvent(this.container, ae, this.app);
		this.app.dispatchEvent(ae);
	}
	@Override
    public void mouseClicked(MouseEvent ae) {

		System.out.println("Click");
//		MouseEvent parentEvent = SwingUtilities.convertMouseEvent(this.container, ae, this.app);
		this.app.dispatchEvent(ae);
    }

 
    @Override
    public void mousePressed(MouseEvent ae) {

		System.out.println("Press");
//		MouseEvent parentEvent = SwingUtilities.convertMouseEvent(this.container, ae, this.app);
		this.app.dispatchEvent(ae);
    }
	
}
