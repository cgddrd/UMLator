package uk.ac.aber.dcs.cs124.clg11.diag;

import java.awt.Graphics;


public class RelationshipDiag extends Drawable {
    private ClassDiag a, b;
    
    public RelationshipDiag(ClassDiag a,ClassDiag b, String assocVar) {
        //code for constructing a new relationship goes here

        this.a = a;
        ClassDiagData d = (ClassDiagData) this.a.getData();
        RelationshipDiagData rd = new RelationshipDiagData();
        
        rd.setAsscoVar(assocVar);
        d.addAssocInstanceVar(assocVar);
        
        setData(rd);

        this.b = b;
    }
    
    private boolean topSide(int y1, int y2) {
        if (y1 >= y2) {
            //top side
            return true;
        }
        return false;
    }
	
    @Override
    public void paint(Graphics g) {
        //Draw relationship line with diamond at the end
        if (topSide(a.getY(), b.getY())) {
            g.drawLine(a.getX() + 100, a.getY(), a.getX() + 100, b.getY() - 20); // <--- Change 'b.getY() - 20' to 'b.getY()' if you just want line..
        } else {
            if (b.getY() > a.getY() + a.getHeight()) {
                g.drawLine(a.getX() + 100, a.getY() + a.getHeight(), a.getX() + 100, b.getY() - 20);
            }
        }
        
        if (b.getY() > a.getY() && b.getY() < a.getY() + a.getHeight()) {
            g.drawLine(a.getX() + 180, b.getY() -20 , b.getX() + 100, b.getY() -20);
        } else {
            g.drawLine(a.getX() + 100, b.getY() -20 , b.getX() + 100, b.getY() -20);
        }
        
        RelationshipDiagData rd = (RelationshipDiagData) getData();
        //draw asscoiated variable if it exists
        if(rd.getAssocVar() != null) {
            g.drawString(rd.getAssocVar(), a.getX() + 200, a.getY() + 20);
        }
        
        int x1 = b.getX() + 90;
        int x2 = (x1 + 20);
        int y1 = b.getY() - 20;
        int y2 = (y1 + 20);
        int startx = (x1+x2)/2;  
        int starty = (y1+y2)/2;  
        
        g.drawLine(x1, starty , startx , y1);  
        g.drawLine(startx , y1, x2, starty );  
        g.drawLine(x2, starty , startx , y2);  
        g.drawLine(startx , y2, x1, starty ); 
    }

}
