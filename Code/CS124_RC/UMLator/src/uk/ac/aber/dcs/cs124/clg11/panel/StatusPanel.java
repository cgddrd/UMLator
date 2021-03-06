package uk.ac.aber.dcs.cs124.clg11.panel;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SpringLayout;

public class StatusPanel extends JPanel {
	
	private JLabel statusText = new JLabel();
	private JLabel mouseCoords = new JLabel();
	SpringLayout layout = new SpringLayout();
	private JSeparator statusSep = new JSeparator(JSeparator.VERTICAL);

	public StatusPanel(CanvasPanel cp) {
		
		this.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.black));
		this.setLayout(layout);
		this.add(statusText);
		this.add(statusSep);
		this.add(mouseCoords);
		
		layout.putConstraint(SpringLayout.NORTH,statusText,2,SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST,statusText,5,SpringLayout.WEST, this);
       
        layout.putConstraint(SpringLayout.NORTH,statusSep,2,SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.SOUTH,statusSep,-2,SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.WEST,statusSep,8,SpringLayout.EAST, statusText);
        
        layout.putConstraint(SpringLayout.NORTH,mouseCoords,2,SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST,mouseCoords,-10,SpringLayout.EAST, this);
        
	}
	
	public void setStatus(String status) {
		statusText.setText(status);
	}
	
	public void setCoords(int x, int y) {
		mouseCoords.setText("Mouse Coords: X: " + x + " | Y: " + y);
	}
}
