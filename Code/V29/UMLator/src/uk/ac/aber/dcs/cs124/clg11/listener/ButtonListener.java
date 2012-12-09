package uk.ac.aber.dcs.cs124.clg11.listener;

import java.awt.event.*;
import uk.ac.aber.dcs.cs124.clg11.panel.*;
import uk.ac.aber.dcs.cs124.clg11.listener.*;
import javax.swing.*;

public class ButtonListener implements ActionListener {
	
	private CanvasPanel canvasPane;
	private ButtonPanel buttonPane;
	private MouseInterListener mouseList;
	
	public ButtonListener(ButtonPanel bp, CanvasPanel cP) {
		canvasPane = cP;
		buttonPane = bp;
	}
	public void actionPerformed(ActionEvent evt) {
		String actionCommand = evt.getActionCommand();
		
		if (actionCommand.equals("Add Class")) {
			canvasPane.setStatus("Click position for new class");
			buttonPane.addVar = true;
		} else if (actionCommand.equals("Reset Canvas")) {
			canvasPane.clearCanvas();
		} else if (actionCommand.equals("Add Relationship")) {
			buttonPane.addRel = true;
		} else if (actionCommand.equals("Export Java")) {
			canvasPane.exportClass();
		} else if (actionCommand.equals("Save Project")) {
			canvasPane.saveFile();
		} else if (actionCommand.equals("Load Project")) {
		    canvasPane.loadFile();
		}
		
	}
	
	

}
