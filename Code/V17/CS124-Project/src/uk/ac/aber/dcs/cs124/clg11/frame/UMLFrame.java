package uk.ac.aber.dcs.cs124.clg11.frame;

import java.awt.BorderLayout;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import uk.ac.aber.dcs.cs124.clg11.listener.*;
import uk.ac.aber.dcs.cs124.clg11.panel.*;

public class UMLFrame extends JFrame{
	
	CanvasPanel cvPanel = new CanvasPanel();
	ButtonPanel btPanel;
	MouseInterListener mIL;
	MousePositionListener mPL;

	public UMLFrame() {
		String curDir = System.getProperty("user.dir");
		this.setIconImage((new ImageIcon(curDir + "\\src\\uk\\ac\\aber\\dcs\\cs124\\clg11\\frame\\uml_icon.png")).getImage());  
		this.setSize(200,200);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("'UMLator' - CS124 Project");
		
		btPanel = new ButtonPanel(cvPanel);
		
		add(cvPanel,BorderLayout.CENTER); // Add to centre of frame
		add(btPanel,BorderLayout.WEST); 
		pack(); //Make frame as small as it can be to fit everything in..
		
		
		mIL = new MouseInterListener(cvPanel, btPanel);
		cvPanel.addMouseListener(mIL);
		mPL = new MousePositionListener(cvPanel, btPanel);
		cvPanel.addMouseMotionListener(mPL);
		
	}

	public void showIt() {
		this.setVisible(true);
	}

	public void showIt(String title) {
		this.setTitle(title);
		this.setVisible(true);
	}
}
