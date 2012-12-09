

import java.awt.*;

public class ClassDiag extends Drawable {

	private int variable;
	private String className;
	private int varNo;
	private int opNo;
	private int height = 200;
	
	
	public ClassDiag (double x, double y, String className, int varNo, int opNo) {
		this.x = (int)x;
		this.y = (int)y;
		this.className = className;
		this.varNo = varNo;
		this.opNo = opNo;
		height = 65 + (varNo * 15) + (opNo * 15); //Calculate how big the class diag shell has to be.
	}
	
	public void paint(Graphics g) {
		
		variable = y + 50;
		g.setColor(Color.cyan);
		g.fillRoundRect(x, y, 180, height, 5, 5);
	    g.setColor(Color.red);
	    g.drawLine(x, (y + 30), (x + 180), (y + 30)); //(X1,Y1,X2,Y2) Y needs to be the same..
	    g.drawRoundRect(x, y, 180, height, 5, 5); //.. X needs to be first rec coord, then + 180
	    g.drawString(className, (x + 10), (y + 20)); //Need to centre!
	    
	    
	    //ClassDiagData d = (ClassDiagData) data;
	    //ArrayList<String> agrs = d.getInstanceVariables();
	    
	    for (int i = 0; i < varNo; i++) {
	    	g.drawString(" - Test:int", (x + 10), (variable)); // Add variables
	    	variable = variable + 15;
	    }
	    
	    g.drawLine(x, (variable - 5), (x + 180), (variable - 5)); // Variable separator
	    variable = variable + 15;
	    
	    for (int i = 0; i < opNo; i++) {
	    	g.drawString(" + setCounter():void", (x + 10), (variable)); // Add variables
	    	variable = variable + 15;
	    }
	    
	   // if (height < (variable - 15)) {
	  //  	g.fillRoundRect(x, y, 180, (height - 25), 5, 5);
	  //  }
	    
	}

}
