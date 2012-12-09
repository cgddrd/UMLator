package uk.ac.aber.dcs.cs124.clg11.diag;
import java.awt.Graphics;



public class RelationshipDiag extends Drawable {
	
	private ClassDiag a, b;
	public RelationshipDiag(ClassDiag a,ClassDiag b) {
		//code for constructing a new relationship goes here
		this.a = a;
		this.b = b;
	}
	
	public void paint(Graphics g) {
		//Draw relationship line with diamond at the end
		g.drawLine(a.getX() + 100, a.getY(), b.getX() + 100, b.getY() - 20); // <--- Change 'b.getY() - 20' to 'b.getY()' if you just want line..
		int x1 = b.getX() + 90;
		int x2 = (x1 + 20);
		int y1 = b.getY() - 20;
		int y2 = (y1 + 20);
		int x = (x1+x2)/2;  
	    int y = (y1+y2)/2;  
	    g.drawLine(x1, y , x , y1);  
	    g.drawLine(x , y1, x2, y );  
	    g.drawLine(x2, y , x , y2);  
	    g.drawLine(x , y2, x1, y ); 
	}

}
