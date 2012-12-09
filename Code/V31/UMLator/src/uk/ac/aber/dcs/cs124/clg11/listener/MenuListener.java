package uk.ac.aber.dcs.cs124.clg11.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

import uk.ac.aber.dcs.cs124.clg11.panel.CanvasPanel;

public class MenuListener  implements ActionListener{
	
	private CanvasPanel canvasPane;

	public MenuListener(CanvasPanel cp) {
		this.canvasPane = cp;
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
		}
		
	}

}
