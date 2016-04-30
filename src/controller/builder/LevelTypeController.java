package controller.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import model.*;
import view.BuilderApplication;

public class LevelTypeController implements ActionListener {
	Level level;
	BuilderApplication ba;
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
