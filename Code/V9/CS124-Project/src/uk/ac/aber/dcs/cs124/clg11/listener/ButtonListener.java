package uk.ac.aber.dcs.cs124.clg11.listener;

import java.awt.event.*;
import uk.ac.aber.dcs.cs124.clg11.panel.*;
import uk.ac.aber.dcs.cs124.clg11.listener.*;
import javax.swing.*;

public class ButtonListener implements ActionListener {
	
	private CanvasPanel canvasPane;
	private ButtonPanel buttonPane;
	private MouseInterListener mouseList;
	
	public ButtonListener(ButtonPanel bp) {
		buttonPane = bp;
	}
	public void actionPerformed(ActionEvent evt) {
		String actionCommand = evt.getActionCommand();
		
		if (actionCommand.equals("Add")) {
			buttonPane.addVar = true;
		} else if (actionCommand.equals("Reset")) {
			buttonPane.clearAll = true;
		}
		
	}
	
	

}
