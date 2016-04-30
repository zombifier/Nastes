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

public class ContainerController extends MouseAdapter{
	BuilderApplication app;
	JPanel container;
	int diffX;
	int diffY;
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
