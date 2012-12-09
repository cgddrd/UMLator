package uk.ac.aber.dcs.cs124.clg11.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

import uk.ac.aber.dcs.cs124.clg11.diag.ClassDiag;
import uk.ac.aber.dcs.cs124.clg11.vector.VectorOfClasses;

public class CanvasPanel extends JPanel {
	
	private VectorOfClasses voc = new VectorOfClasses();

	public CanvasPanel() {
		this.setBackground(Color.gray);
		this.setPreferredSize(new Dimension(600,400)); //Set size of panel
		//repaint(); //Calls the paint method - no need for Graphics g crap...
	}
	
 /* public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.cyan);
		g.fillRoundRect(150, 10, 180, 200, 5, 5);
	    g.setColor(Color.red);
	    g.drawLine(150, 35, 330, 35); //(X1,Y1,X2,Y2) Y needs to be the same..
	    g.drawRoundRect(150, 10, 180, 200, 5, 5); //.. X needs to be first rec coord, then + 180
	    g.drawString("Hello Connor", 225, 28); //Need to centre!
	} */
	
	public void addClass(double x, double y) {
		voc.addClass(new ClassDiag (x,y));
		repaint();
	}

 	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		voc.drawAll(g);
	}
}
