package uk.ac.aber.dcs.cs124.clg11.frame;

import java.awt.BorderLayout;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import uk.ac.aber.dcs.cs124.clg11.listener.*;
import uk.ac.aber.dcs.cs124.clg11.panel.*;

public class UMLFrame extends JFrame{
	
	private ButtonPanel btPanel;
	private StatusPanel stPanel;
	private CanvasPanel cvPanel;
	private MouseInterListener mIL;
	private MousePositionListener mPL;
	private MenuListener mL;
	
	
	private JMenuBar mb = new JMenuBar();
	private JMenu fileMenu = new JMenu("File");
	private JMenu editMenu = new JMenu("Edit");
	private JMenu helpMenu = new JMenu("Help");
	private JMenuItem backCol = new JMenuItem("Choose Background Colour");
	private JMenuItem classCol = new JMenuItem("Choose Class Colour");
	private JMenuItem classTxtCol = new JMenuItem("Choose Class Text Colour");
	
	
	public UMLFrame() {

		String curDir = System.getProperty("user.dir");
		this.setIconImage((new ImageIcon(curDir + "\\src\\uk\\ac\\aber\\dcs\\cs124\\clg11\\frame\\uml_icon.png")).getImage()); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("'UMLator' - CS124 Project");
		
		this.setJMenuBar(mb);
	
		
		
		stPanel = new StatusPanel(cvPanel);
		stPanel.setPreferredSize(new Dimension(this.getWidth(),25));
		
		cvPanel = new CanvasPanel(stPanel);
		
		btPanel = new ButtonPanel(cvPanel);
		btPanel.setPreferredSize(new Dimension(155,this.getHeight()));
		
		add(btPanel,BorderLayout.WEST); 
		add(cvPanel,BorderLayout.CENTER); // Add to centre of frame
		add(stPanel,BorderLayout.SOUTH);
		
		
		pack(); //Make frame as small as it can be to fit everything in..
		
		mIL = new MouseInterListener(cvPanel, btPanel);
		cvPanel.addMouseListener(mIL);
		mPL = new MousePositionListener(cvPanel, btPanel);
		cvPanel.addMouseMotionListener(mPL);
		mL = new MenuListener(cvPanel);
		
		mb.add(fileMenu);
		
		mb.add(editMenu);
		editMenu.add(backCol);
		backCol.addActionListener(mL);
		editMenu.add(classCol);
		classCol.addActionListener(mL);
		editMenu.add(classTxtCol);
		classTxtCol.addActionListener(mL);
		
		mb.add(helpMenu);
		
		Toolkit k=Toolkit.getDefaultToolkit();
		Dimension d=k.getScreenSize();
		this.setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);
		
	}

	public void showIt() {
		this.setVisible(true);
	}


}
