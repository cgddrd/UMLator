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
		// TODO Auto-generated method stub
		g.drawLine(a.getX() + 100, a.getY(), b.getX() + 100, b.getY());
	}

}
