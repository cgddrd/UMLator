package uk.ac.aber.dcs.cs124.clg11.panel;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import uk.ac.aber.dcs.cs124.clg11.listener.*;

public class ButtonPanel extends JPanel {
	
	private JLabel posText = new JLabel("Controls");
	private JLabel aText = new JLabel("");
	private JLabel bText = new JLabel("");
	JButton upButton, downButton, resetButton;
	public Boolean addVar = false;

	public ButtonPanel() {
		
		ButtonListener buttonList = new ButtonListener(this);
		this.setLayout(new GridLayout(6,0)); //Create new grid
		this.add(posText);
		
		upButton = new JButton("Add");
        this.add(upButton);
        upButton.addActionListener(buttonList);
        
        this.add(aText);
        downButton = new JButton("Down");
        this.add(downButton);
        this.add(bText);
        resetButton = new JButton("Reset");
        this.add(resetButton);
	}
}
