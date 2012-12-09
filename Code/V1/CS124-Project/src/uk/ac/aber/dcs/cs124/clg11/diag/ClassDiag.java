package uk.ac.aber.dcs.cs124.clg11.diag;

import java.awt.*;

public class ClassDiag {
	
	private int x;
	private int y;
	
	public ClassDiag (double x, double y) {
		this.x = (int)x;
		this.y = (int)y;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRoundRect(x, y, 180, 200, 5, 5);
	    g.setColor(Color.red);
	    g.drawLine(x, (y+30), (x + 180), (y+30)); //(X1,Y1,X2,Y2) Y needs to be the same..
	    g.drawRoundRect(x, y, 180, 200, 5, 5); //.. X needs to be first rec coord, then + 180
	    g.drawString("Hello Connor", (x + 10), (y + 20)); //Need to centre!
	}

}
