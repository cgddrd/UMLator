package uk.ac.aber.dcs.cs124.clg11.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

import uk.ac.aber.dcs.cs124.clg11.panel.ButtonPanel;
import uk.ac.aber.dcs.cs124.clg11.panel.CanvasPanel;

public class MenuListener  implements ActionListener{
	
	private CanvasPanel canvasPane;
	private ButtonPanel buttonPane;

	public MenuListener(CanvasPanel cp, ButtonPanel bp) {
		this.canvasPane = cp;
		this.buttonPane = bp;
	}
	
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		
		if(actionCommand.equals("Choose Background Colour")) {
			Color initialBackground = canvasPane.getBackground();
			Color background = JColorChooser.showDialog(null,"UMLator | Select Background Colour", initialBackground);
		        if (background != null) {
		          canvasPane.setBackground(background);
		        }
		} else if (actionCommand.equals("Choose Class Colour")) {
			Color initialBackground = canvasPane.getBackground();
			Color classColour = JColorChooser.showDialog(null,"UMLator | Select Class Colour", initialBackground);
		        if (classColour != null) {
		          canvasPane.changeColour(classColour);
		        }
		} else if (actionCommand.equals("Choose Class Text Colour")) {
			Color initialBackground = canvasPane.getBackground();
			Color textColour = JColorChooser.showDialog(null,"UMLator | Select Text/Line Colour", initialBackground);
		        if (textColour != null) {
		          canvasPane.changeTextColour(textColour);
		        }
		} else if (actionCommand.equals("New Class")) {
			canvasPane.setStatus("Click position for new class");
			buttonPane.addVar = true;
		} else if (actionCommand.equals("New Relationship")) {
			buttonPane.addRel = true;
		} else if (actionCommand.equals("Clear Canvas")) {
			canvasPane.clearCanvas();
			canvasPane.setStatus("Canvas Cleared Successfully");
		} else if (actionCommand.equals("Save Project")) {
			canvasPane.saveFile();
		} else if (actionCommand.equals("Load Project")) {
			canvasPane.loadFile();
		} else if (actionCommand.equals("Export Java Code")) {
			canvasPane.exportClass();
		} else if (actionCommand.equals("Exit")) {
			canvasPane.exitProgram();
		} else if (actionCommand.equals("Undo")) {
			canvasPane.undoAction();
		} else if (actionCommand.equals("About")) {
			canvasPane.about();
		}
		
	}

}
