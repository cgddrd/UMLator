package uk.ac.aber.dcs.cs124.clg11.frame;

import java.awt.BorderLayout;

import java.awt.*;
import javax.swing.JFrame;
import uk.ac.aber.dcs.cs124.clg11.listener.*;
import uk.ac.aber.dcs.cs124.clg11.panel.*;

public class UMLFrame extends JFrame{
	
	CanvasPanel cvPanel = new CanvasPanel();
	ButtonPanel btPanel = new ButtonPanel();
	MouseInterListener mIL;

	public UMLFrame() {
		this.setSize(200,200);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("'UMLator' - CS124 Project");
		add(cvPanel,BorderLayout.CENTER); // Add to centre of frame
		add(btPanel,BorderLayout.WEST); 
		pack(); //Make frame as small as it can be to fit everything in..
		
		mIL = new MouseInterListener(cvPanel, btPanel);
		cvPanel.addMouseListener(mIL);
	}

	public void showIt() {
		this.setVisible(true);
	}

	public void showIt(String title) {
		this.setTitle(title);
		this.setVisible(true);
	}
}
