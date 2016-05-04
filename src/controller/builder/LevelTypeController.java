package controller.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import model.*;
import view.BuilderApplication;

/**
 * this class is for chosing level type when the builder click on the JComboBox.
 * @author Team Nastes
 *
 */
public class LevelTypeController implements ActionListener {
	Level level;
	BuilderApplication ba;
	/**
	 * Constructor for LevelTypeController. Sets level and builder application.
	 * @param level Level
	 * @param ba BuilderApplication
	 */
	public LevelTypeController(Level level, BuilderApplication ba){
		this.level = level;
		this.ba = ba;
	}
	
	public void actionPerformed(ActionEvent ae) {
		JComboBox<String> cb = (JComboBox<String>) ae.getSource();
		String levelType = (String) cb.getSelectedItem();
		BuilderMove m;
		if (levelType.equals("Puzzle")) {
			m = new ChangeTypeMove(level, ba, 0);
		}
		else if (levelType.equals("Lightning")) {
			m = new ChangeTypeMove(level, ba, 1);
		}
		else {
			m = new ChangeTypeMove(level, ba, 2);
		}
		if (m.doMove())
			ba.addMove(m);
	}
}
