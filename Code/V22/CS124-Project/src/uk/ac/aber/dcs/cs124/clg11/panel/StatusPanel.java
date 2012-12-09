package uk.ac.aber.dcs.cs124.clg11.panel;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class StatusPanel extends JPanel {
	
	private JLabel titleText = new JLabel("--System Menu--");
	SpringLayout layout = new SpringLayout();

	public StatusPanel(CanvasPanel cP) {
		
		this.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.black));
		
	}
}
